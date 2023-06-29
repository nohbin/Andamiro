package com.andamiro.dao.recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.andamiro.dto.member.MemberVO;
import com.andamiro.dto.recipe.RecipeDetailVO;
import com.andamiro.dto.recipe.RecipeHowVO;
import com.andamiro.dto.recipe.RecipeIngreVO;
import com.andamiro.dto.recipe.RecipeKindVO;
import com.andamiro.dto.recipe.RecipeMainIngreVO;
import com.andamiro.dto.recipe.RecipeOrderVO;
import com.andamiro.dto.recipe.RecipePicVO;
import com.andamiro.dto.recipe.RecipeVO;
import com.andamiro.utill.DBManager;

public class RecipeDAO {

	private static RecipeDAO instance;

	public static RecipeDAO getInstance() {
		if (instance == null) {
			instance = new RecipeDAO();
		}
		return instance;
	}

	public void registRecipe(RecipeVO recipeVO) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			String sql = "INSERT INTO ANDAMIRORECIPE (recipeId , memberNumber , recipeName , mainPicture , recipetag1 , recipetag2 , recipetag3, USERID , recipedetailid ) "
					+ "VALUES (RECIPEID_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, RECIPEID_SEQ.currval)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipeVO.getMemberNumber());
			pstmt.setString(2, recipeVO.getRecipeName());
			pstmt.setString(3, recipeVO.getMainPicture());
			pstmt.setString(4, recipeVO.getRecipetag1());
			pstmt.setString(5, recipeVO.getRecipetag2());
			pstmt.setString(6, recipeVO.getRecipetag3());
			pstmt.setString(7, recipeVO.getUserId());
			pstmt.executeUpdate();
			sql = "SELECT recipeid_seq.currval FROM dual";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int recipeId = 0;
			if (rs.next()) {
				recipeId = rs.getInt(1);
			}

			sql = "INSERT INTO RECIPEPICTURE (RECIPEPICID,RECIPEID, PIC01, PIC02, PIC03, PIC04, PIC05) "
					+ "VALUES (PICID_SEQ.nextval,?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipeId);
			pstmt.setString(2, recipeVO.getRecipeDetailVO().getRecipePicVO().getPic01());
			pstmt.setString(3, recipeVO.getRecipeDetailVO().getRecipePicVO().getPic02());
			pstmt.setString(4, recipeVO.getRecipeDetailVO().getRecipePicVO().getPic03());
			pstmt.setString(5, recipeVO.getRecipeDetailVO().getRecipePicVO().getPic04());
			pstmt.setString(6, recipeVO.getRecipeDetailVO().getRecipePicVO().getPic05());
			pstmt.executeUpdate();

			sql = "INSERT INTO RECIPEORDER (RECIPEORDERID,RECIPEID, ORDER01, ORDER02, ORDER03, ORDER04, ORDER05) "
					+ "VALUES (ORDERID_SEQ.nextval,?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipeId);
			pstmt.setString(2, recipeVO.getRecipeDetailVO().getRecipeOrderVO().getOrder01());
			pstmt.setString(3, recipeVO.getRecipeDetailVO().getRecipeOrderVO().getOrder02());
			pstmt.setString(4, recipeVO.getRecipeDetailVO().getRecipeOrderVO().getOrder03());
			pstmt.setString(5, recipeVO.getRecipeDetailVO().getRecipeOrderVO().getOrder04());
			pstmt.setString(6, recipeVO.getRecipeDetailVO().getRecipeOrderVO().getOrder05());
			pstmt.executeUpdate();

			sql = "INSERT INTO RECIPEINGRE (INGREID , RECIPEID, INGRE01, INGRE02, INGRE03, INGRE04, INGRE05, INGRE06, INGRE07, "
					+ "INGRE08, INGRE09, INGRE10, INGRE11, INGRE12) "
					+ "VALUES (INGREID_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipeId);
			pstmt.setString(2, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre01());
			pstmt.setString(3, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre02());
			pstmt.setString(4, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre03());
			pstmt.setString(5, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre04());
			pstmt.setString(6, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre05());
			pstmt.setString(7, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre06());
			pstmt.setString(8, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre07());
			pstmt.setString(9, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre08());
			pstmt.setString(10, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre09());
			pstmt.setString(11, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre10());
			pstmt.setString(12, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre11());
			pstmt.setString(13, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre12());
			pstmt.executeUpdate();

			sql = "SELECT PICID_SEQ.currval FROM dual";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int recippicID = 0;
			if (rs.next()) {
				recippicID = rs.getInt(1);
			}

			sql = "SELECT ORDERID_SEQ.currval FROM dual";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int recipeorderID = 0;
			if (rs.next()) {
				recipeorderID = rs.getInt(1);
			}

			sql = "SELECT INGREID_SEQ.currval FROM dual";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int ingreID = 0;
			if (rs.next()) {
				ingreID = rs.getInt(1);
			}

			sql = "INSERT INTO ANDAMIRORECIPE_DETAIL (RECIPEDETAILID , RECIPEID, RECIPEHOW, RECIPEKIND, RECIPEMAININGRE, RECIPEFORPERSON, "
					+ "RECIPEFORTIME, RECIPEFORLEVEL, RECIPEDISCRIPTION , recipePicId , OrderId , recipeingreId ) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipeId);
			pstmt.setInt(2, recipeId);
			pstmt.setInt(3, recipeVO.getRecipeDetailVO().getRecipeHow());
			pstmt.setInt(4, recipeVO.getRecipeDetailVO().getRecipeKind());
			pstmt.setInt(5, recipeVO.getRecipeDetailVO().getRecipeMainIngre());
			pstmt.setString(6, recipeVO.getRecipeDetailVO().getRecipeforperson());
			pstmt.setString(7, recipeVO.getRecipeDetailVO().getRecipefortime());
			pstmt.setString(8, recipeVO.getRecipeDetailVO().getRecipeforlevel());
			pstmt.setString(9, recipeVO.getRecipeDetailVO().getRecipeDiscription());
			pstmt.setInt(10, recippicID);
			pstmt.setInt(11, recipeorderID);
			pstmt.setInt(12, ingreID);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<RecipeVO> selectAllRecipe() {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<RecipeVO> list = new ArrayList<>();

		String sql = "select * from andamirorecipe order by RECIPEREGDATE desc";

		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				RecipeVO recipeVO = new RecipeVO();
				recipeVO.setRecipeID(rs.getInt("RECIPEID"));
				recipeVO.setMemberNumber(rs.getInt("MEMBERNUMBER"));
				recipeVO.setRecipeName(rs.getString("RECIPENAME"));
				recipeVO.setMainPicture(rs.getString("MAINPICTURE"));
				recipeVO.setRecipeGrade(rs.getString("RECIPEGRADE"));
				recipeVO.setRecipetag1(rs.getString("RECIPETAG1"));
				recipeVO.setRecipetag2(rs.getString("RECIPETAG2"));
				recipeVO.setRecipetag3(rs.getString("RECIPETAG3"));
				recipeVO.setRecipeView(rs.getInt("RECIPEVIEW"));
				recipeVO.setRecipeCompetition(rs.getInt("RECIPECOMPETITION"));
				recipeVO.setRecipeDetailID(rs.getInt("RECIPEDETAILID"));
				recipeVO.setRecipeRegDate(rs.getTimestamp("RECIPEREGDATE"));
				recipeVO.setUserId(rs.getString("USERID"));
				list.add(recipeVO);
				System.out.println(rs.getInt("RECIPEID") + " 의 평점은 : " + rs.getString("RECIPEGRADE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public RecipeVO selectOneRecipeByID(int recipID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from ANDAMIRORECIPE where RECIPEID = ?";
		RecipeVO recipeVO = null;
		RecipeDetailVO recipeDetailVO = null;
		RecipePicVO recipePicVo = null;
		RecipeOrderVO recipeOrderVo = null;
		RecipeIngreVO recipeIngreVO = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				recipeVO = new RecipeVO();
				recipeVO.setRecipeID(rs.getInt("RECIPEID"));
				recipeVO.setMemberNumber(rs.getInt("MEMBERNUMBER"));
				recipeVO.setRecipeName(rs.getString("RECIPENAME"));
				recipeVO.setMainPicture(rs.getString("MAINPICTURE"));
				recipeVO.setRecipeGrade(rs.getString("RECIPEGRADE"));
				recipeVO.setRecipetag1(rs.getString("RECIPETAG1"));
				recipeVO.setRecipetag2(rs.getString("RECIPETAG2"));
				recipeVO.setRecipetag3(rs.getString("RECIPETAG3"));
				recipeVO.setRecipeView(rs.getInt("RECIPEVIEW"));
				recipeVO.setRecipeCompetition(rs.getInt("RECIPECOMPETITION"));
				recipeVO.setRecipeDetailID(rs.getInt("RECIPEDETAILID"));
				recipeVO.setRecipeRegDate(rs.getTimestamp("RECIPEREGDATE"));
				recipeVO.setUserId(rs.getString("USERID"));
			}

			// 레시피 디테일 받아오기
			sql = "select * from ANDAMIRORECIPE_DETAIL where RECIPEID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				recipeDetailVO = new RecipeDetailVO();
				recipeDetailVO.setRecipeDetailID(rs.getInt("RECIPEDETAILID"));
				recipeDetailVO.setRecipeID(rs.getInt("RECIPEID"));
				recipeDetailVO.setRecipeHow(rs.getInt("RECIPEHOW"));
				recipeDetailVO.setRecipeKind(rs.getInt("RECIPEKIND"));
				recipeDetailVO.setRecipeMainIngre(rs.getInt("RECIPEMAININGRE"));
				recipeDetailVO.setRecipeDiscription(rs.getString("RECIPEDISCRIPTION"));
				recipeDetailVO.setRecipeforperson(rs.getString("RECIPEFORPERSON"));
				recipeDetailVO.setRecipefortime(rs.getString("RECIPEFORTIME"));
				recipeDetailVO.setRecipeforlevel(rs.getString("RECIPEFORLEVEL"));
			}

			// 레시피 사진 받아오기
			sql = "select * from RECIPEPICTURE where RECIPEID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				recipePicVo = new RecipePicVO();
				recipePicVo.setRecipePicid(rs.getInt("RECIPEPICID"));
				recipePicVo.setRecipeId(rs.getInt("RECIPEID"));
				recipePicVo.setPic01(rs.getString("PIC01"));
				recipePicVo.setPic02(rs.getString("PIC02"));
				recipePicVo.setPic03(rs.getString("PIC03"));
				recipePicVo.setPic04(rs.getString("PIC04"));
				recipePicVo.setPic05(rs.getString("PIC05"));
			}

			// 레시피 순서 받아오기
			sql = "select * from RECIPEORDER where RECIPEID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				recipeOrderVo = new RecipeOrderVO();
				recipeOrderVo.setRecipeOrderId(rs.getInt("RECIPEORDERID"));
				recipeOrderVo.setRecipeId(rs.getInt("RECIPEID"));
				recipeOrderVo.setOrder01(rs.getString("ORDER01"));
				recipeOrderVo.setOrder02(rs.getString("ORDER02"));
				recipeOrderVo.setOrder03(rs.getString("ORDER03"));
				recipeOrderVo.setOrder04(rs.getString("ORDER04"));
				recipeOrderVo.setOrder05(rs.getString("ORDER05"));
			}

			// 레시피 재료 받아오기
			sql = "select * from RECIPEINGRE where RECIPEID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				recipeIngreVO = new RecipeIngreVO();
				recipeIngreVO.setIngreid(rs.getInt("INGREID"));
				recipeIngreVO.setRecipeId(rs.getInt("RECIPEID"));
				recipeIngreVO.setIngre01(rs.getString("INGRE01"));
				recipeIngreVO.setIngre02(rs.getString("INGRE02"));
				recipeIngreVO.setIngre03(rs.getString("INGRE03"));
				recipeIngreVO.setIngre04(rs.getString("INGRE04"));
				recipeIngreVO.setIngre05(rs.getString("INGRE05"));
				recipeIngreVO.setIngre06(rs.getString("INGRE06"));
				recipeIngreVO.setIngre07(rs.getString("INGRE07"));
				recipeIngreVO.setIngre08(rs.getString("INGRE08"));
				recipeIngreVO.setIngre09(rs.getString("INGRE09"));
				recipeIngreVO.setIngre10(rs.getString("INGRE10"));
				recipeIngreVO.setIngre11(rs.getString("INGRE11"));
				recipeIngreVO.setIngre12(rs.getString("INGRE12"));
			}

			recipeDetailVO.setRecipePicVO(recipePicVo);
			recipeDetailVO.setRecipeOrderVO(recipeOrderVo);
			recipeDetailVO.setRecipeingreVO(recipeIngreVO);

			recipeVO.setRecipeDetailVO(recipeDetailVO);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return recipeVO;
	}

	public void updateViewCount(int recipID) {
		// TODO Auto-generated method stub
		String sql = "update ANDAMIRORECIPE set RECIPEVIEW = RECIPEVIEW + 1 where RECIPEID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipID);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public List<RecipeVO> selectAllRecipeByMainIngre(int mainIngre) {
		String sql = "select * from andamirorecipe where recipeid in "
				+ "(select recipeid from andamirorecipe_detail where recipemainingre = ?) order by RECIPEREGDATE desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecipeVO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mainIngre);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RecipeVO recipeVO = new RecipeVO();
				recipeVO.setRecipeID(rs.getInt("RECIPEID"));
				recipeVO.setMemberNumber(rs.getInt("MEMBERNUMBER"));
				recipeVO.setRecipeName(rs.getString("RECIPENAME"));
				recipeVO.setMainPicture(rs.getString("MAINPICTURE"));
				recipeVO.setRecipeGrade(rs.getString("RECIPEGRADE"));
				recipeVO.setRecipetag1(rs.getString("RECIPETAG1"));
				recipeVO.setRecipetag2(rs.getString("RECIPETAG2"));
				recipeVO.setRecipetag3(rs.getString("RECIPETAG3"));
				recipeVO.setRecipeView(rs.getInt("RECIPEVIEW"));
				recipeVO.setRecipeCompetition(rs.getInt("RECIPECOMPETITION"));
				recipeVO.setRecipeDetailID(rs.getInt("RECIPEDETAILID"));
				recipeVO.setRecipeRegDate(rs.getTimestamp("RECIPEREGDATE"));
				recipeVO.setUserId(rs.getString("USERID"));
				list.add(recipeVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RecipeVO> selectAllRecipeByHow(int how) {
		String sql = "select * from andamirorecipe where recipeid in "
				+ "(select recipeid from andamirorecipe_detail where recipehow = ?) order by RECIPEREGDATE desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecipeVO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, how);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RecipeVO recipeVO = new RecipeVO();
				recipeVO.setRecipeID(rs.getInt("RECIPEID"));
				recipeVO.setMemberNumber(rs.getInt("MEMBERNUMBER"));
				recipeVO.setRecipeName(rs.getString("RECIPENAME"));
				recipeVO.setMainPicture(rs.getString("MAINPICTURE"));
				recipeVO.setRecipeGrade(rs.getString("RECIPEGRADE"));
				recipeVO.setRecipetag1(rs.getString("RECIPETAG1"));
				recipeVO.setRecipetag2(rs.getString("RECIPETAG2"));
				recipeVO.setRecipetag3(rs.getString("RECIPETAG3"));
				recipeVO.setRecipeView(rs.getInt("RECIPEVIEW"));
				recipeVO.setRecipeCompetition(rs.getInt("RECIPECOMPETITION"));
				recipeVO.setRecipeDetailID(rs.getInt("RECIPEDETAILID"));
				recipeVO.setRecipeRegDate(rs.getTimestamp("RECIPEREGDATE"));
				recipeVO.setUserId(rs.getString("USERID"));
				list.add(recipeVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RecipeVO> selectAllRecipeByKind(int kind) {
		String sql = "select * from andamirorecipe where recipeid in "
				+ "(select recipeid from andamirorecipe_detail where recipekind = ? ) order by RECIPEREGDATE desc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecipeVO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, kind);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RecipeVO recipeVO = new RecipeVO();
				recipeVO.setRecipeID(rs.getInt("RECIPEID"));
				recipeVO.setMemberNumber(rs.getInt("MEMBERNUMBER"));
				recipeVO.setRecipeName(rs.getString("RECIPENAME"));
				recipeVO.setMainPicture(rs.getString("MAINPICTURE"));
				recipeVO.setRecipeGrade(rs.getString("RECIPEGRADE"));
				recipeVO.setRecipetag1(rs.getString("RECIPETAG1"));
				recipeVO.setRecipetag2(rs.getString("RECIPETAG2"));
				recipeVO.setRecipetag3(rs.getString("RECIPETAG3"));
				recipeVO.setRecipeView(rs.getInt("RECIPEVIEW"));
				recipeVO.setRecipeCompetition(rs.getInt("RECIPECOMPETITION"));
				recipeVO.setRecipeDetailID(rs.getInt("RECIPEDETAILID"));
				recipeVO.setRecipeRegDate(rs.getTimestamp("RECIPEREGDATE"));
				recipeVO.setUserId(rs.getString("USERID"));
				list.add(recipeVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RecipeVO> selectAllRecipeByMemberNumber(int memberNumber) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecipeVO> list = new ArrayList<>();
		String sql = "select * from andamirorecipe where membernumber = ? order by RECIPEREGDATE desc";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, memberNumber);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RecipeVO recipeVO = new RecipeVO();
				recipeVO.setRecipeID(rs.getInt("RECIPEID"));
				recipeVO.setMemberNumber(rs.getInt("MEMBERNUMBER"));
				recipeVO.setRecipeName(rs.getString("RECIPENAME"));
				recipeVO.setMainPicture(rs.getString("MAINPICTURE"));
				recipeVO.setRecipeGrade(rs.getString("RECIPEGRADE"));
				recipeVO.setRecipetag1(rs.getString("RECIPETAG1"));
				recipeVO.setRecipetag2(rs.getString("RECIPETAG2"));
				recipeVO.setRecipetag3(rs.getString("RECIPETAG3"));
				recipeVO.setRecipeView(rs.getInt("RECIPEVIEW"));
				recipeVO.setRecipeCompetition(rs.getInt("RECIPECOMPETITION"));
				recipeVO.setRecipeDetailID(rs.getInt("RECIPEDETAILID"));
				recipeVO.setRecipeRegDate(rs.getTimestamp("RECIPEREGDATE"));
				recipeVO.setUserId(rs.getString("USERID"));
				list.add(recipeVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void deleteRecipeById(int recipeId) {
		// TODO Auto-generated method stub
		String sql = "delete from andamiroRecipe where recipeid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipeId);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void updateRecipeByRecipeid(int recipeId, RecipeVO recipeVO) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE ANDAMIRORECIPE SET recipeName = ?, mainPicture = ?, "
				+ "recipetag1 = ?, recipetag2 = ?, recipetag3 = ? WHERE RECIPEID = ?";
		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, recipeVO.getRecipeName());
			pstmt.setString(2, recipeVO.getMainPicture());
			pstmt.setObject(3, recipeVO.getRecipetag1());
			pstmt.setObject(4, recipeVO.getRecipetag2());
			pstmt.setObject(5, recipeVO.getRecipetag3());
			pstmt.setInt(6, recipeId);
			pstmt.executeUpdate();

			sql = "UPDATE RECIPEPICTURE SET PIC01 = ?, PIC02 = ?, PIC03 = ?, PIC04 = ?, PIC05 = ? WHERE RECIPEID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, recipeVO.getRecipeDetailVO().getRecipePicVO().getPic01());
			pstmt.setObject(2, recipeVO.getRecipeDetailVO().getRecipePicVO().getPic02());
			pstmt.setObject(3, recipeVO.getRecipeDetailVO().getRecipePicVO().getPic03());
			pstmt.setObject(4, recipeVO.getRecipeDetailVO().getRecipePicVO().getPic04());
			pstmt.setObject(5, recipeVO.getRecipeDetailVO().getRecipePicVO().getPic05());
			pstmt.setInt(6, recipeId);
			pstmt.executeUpdate();

			sql = "UPDATE RECIPEINGRE SET INGRE01 = ?, INGRE02 = ?, INGRE03 = ?, INGRE04 = ?, INGRE05 = ?, INGRE06 = ?, INGRE07 = ?, "
					+ "INGRE08 = ?, INGRE09 = ?, INGRE10 = ?, INGRE11 = ?, INGRE12 = ? WHERE RECIPEID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre01());
			pstmt.setObject(2, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre02());
			pstmt.setObject(3, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre03());
			pstmt.setObject(4, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre04());
			pstmt.setObject(5, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre05());
			pstmt.setObject(6, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre06());
			pstmt.setObject(7, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre07());
			pstmt.setObject(8, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre08());
			pstmt.setObject(9, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre09());
			pstmt.setObject(10, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre10());
			pstmt.setObject(11, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre11());
			pstmt.setObject(12, recipeVO.getRecipeDetailVO().getRecipeingreVO().getIngre12());
			pstmt.setInt(13, recipeId);
			pstmt.executeUpdate();

			sql = "UPDATE RECIPEORDER SET ORDER01 = ?, ORDER02 = ?, ORDER03 = ?, ORDER04 = ?, ORDER05 = ? WHERE RECIPEID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, recipeVO.getRecipeDetailVO().getRecipeOrderVO().getOrder01());
			pstmt.setObject(2, recipeVO.getRecipeDetailVO().getRecipeOrderVO().getOrder02());
			pstmt.setObject(3, recipeVO.getRecipeDetailVO().getRecipeOrderVO().getOrder03());
			pstmt.setObject(4, recipeVO.getRecipeDetailVO().getRecipeOrderVO().getOrder04());
			pstmt.setObject(5, recipeVO.getRecipeDetailVO().getRecipeOrderVO().getOrder05());
			pstmt.setInt(6, recipeId);
			pstmt.executeUpdate();

			sql = "UPDATE ANDAMIRORECIPE_DETAIL SET RECIPEHOW = ?, RECIPEKIND = ?, RECIPEMAININGRE = ?, RECIPEFORPERSON = ?, "
					+ "RECIPEFORTIME = ?, RECIPEFORLEVEL = ?, RECIPEDISCRIPTION = ? " + "WHERE RECIPEID = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipeVO.getRecipeDetailVO().getRecipeHow());
			pstmt.setInt(2, recipeVO.getRecipeDetailVO().getRecipeKind());
			pstmt.setInt(3, recipeVO.getRecipeDetailVO().getRecipeMainIngre());
			pstmt.setString(4, recipeVO.getRecipeDetailVO().getRecipeforperson());
			pstmt.setString(5, recipeVO.getRecipeDetailVO().getRecipefortime());
			pstmt.setString(6, recipeVO.getRecipeDetailVO().getRecipeforlevel());
			pstmt.setString(7, recipeVO.getRecipeDetailVO().getRecipeDiscription());
			pstmt.setInt(8, recipeId);
			pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<RecipeKindVO> selectAllRecipeKind() {
		// TODO Auto-generated method stub
		List<RecipeKindVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from RECIPEKIND";
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				RecipeKindVO recipeKindVO = new RecipeKindVO();
				recipeKindVO.setRecipeKindId(rs.getInt("RECIPEKINDID"));
				recipeKindVO.setRecipeKind(rs.getString("RECIPEKIND"));
				list.add(recipeKindVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RecipeHowVO> selectAllRecipeHow() {
		List<RecipeHowVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from RECIPEHOW";
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				RecipeHowVO recipeHowVO = new RecipeHowVO();
				recipeHowVO.setRecipeHowId(rs.getInt("RECIPEHOWID"));
				recipeHowVO.setRecipeHow(rs.getString("RECIPEHOW"));
				list.add(recipeHowVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RecipeMainIngreVO> selectAllRecipeMainIngre() {
		List<RecipeMainIngreVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from RECIPEMAININGRE";
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				RecipeMainIngreVO recipeMainIngreVO = new RecipeMainIngreVO();
				recipeMainIngreVO.setRecipeIngreId(rs.getInt("RECIPEINGREID"));
				recipeMainIngreVO.setRecipeIngre(rs.getString("RECIPEINGRE"));
				list.add(recipeMainIngreVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RecipeVO> selectRecipeByPage(int start, int end) {
		// TODO Auto-generated method stub
		List<RecipeVO> lists = new ArrayList<>();
		RecipeVO recipeVO = null;
		String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY recipeid) NUM , A.* FROM andamirorecipe A ORDER BY recipeid) "
				+ "WHERE NUM BETWEEN ? AND ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				recipeVO = new RecipeVO();
				recipeVO.setRecipeID(rs.getInt("RECIPEID"));
				recipeVO.setMemberNumber(rs.getInt("MEMBERNUMBER"));
				recipeVO.setRecipeName(rs.getString("RECIPENAME"));
				recipeVO.setMainPicture(rs.getString("MAINPICTURE"));
				recipeVO.setRecipeGrade(rs.getString("RECIPEGRADE"));
				recipeVO.setRecipetag1(rs.getString("RECIPETAG1"));
				recipeVO.setRecipetag2(rs.getString("RECIPETAG2"));
				recipeVO.setRecipetag3(rs.getString("RECIPETAG3"));
				recipeVO.setRecipeView(rs.getInt("RECIPEVIEW"));
				recipeVO.setRecipeCompetition(rs.getInt("RECIPECOMPETITION"));
				recipeVO.setRecipeDetailID(rs.getInt("RECIPEDETAILID"));
				recipeVO.setRecipeRegDate(rs.getTimestamp("RECIPEREGDATE"));
				recipeVO.setUserId(rs.getString("USERID"));
				lists.add(recipeVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lists;
	}

	public List<RecipeVO> selectAllRecipeBySubNumber(int subNumber) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM andamirorecipe WHERE recipeid IN (SELECT recipeid FROM submemberrecipe WHERE subnumber = ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<RecipeVO> list = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subNumber);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				RecipeVO recipeVO = new RecipeVO();
				recipeVO.setRecipeID(rs.getInt("RECIPEID"));
				recipeVO.setMemberNumber(rs.getInt("MEMBERNUMBER"));
				recipeVO.setRecipeName(rs.getString("RECIPENAME"));
				recipeVO.setMainPicture(rs.getString("MAINPICTURE"));
				recipeVO.setRecipeGrade(rs.getString("RECIPEGRADE"));
				recipeVO.setRecipetag1(rs.getString("RECIPETAG1"));
				recipeVO.setRecipetag2(rs.getString("RECIPETAG2"));
				recipeVO.setRecipetag3(rs.getString("RECIPETAG3"));
				recipeVO.setRecipeView(rs.getInt("RECIPEVIEW"));
				recipeVO.setRecipeCompetition(rs.getInt("RECIPECOMPETITION"));
				recipeVO.setRecipeDetailID(rs.getInt("RECIPEDETAILID"));
				recipeVO.setRecipeRegDate(rs.getTimestamp("RECIPEREGDATE"));
				recipeVO.setUserId(rs.getString("USERID"));
				list.add(recipeVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public void updateRecipeGradeByRecipeId(int recipeId) {
		// TODO Auto-generated method stub
		String sql = "UPDATE andamirorecipe SET recipegrade = (SELECT TO_CHAR(AVG(recipegrade), 'FM999999990.00') FROM andamiroreview WHERE recipeid = ?) WHERE recipeid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipeId);
			pstmt.setInt(2, recipeId);
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}