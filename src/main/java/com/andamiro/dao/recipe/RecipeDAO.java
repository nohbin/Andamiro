package com.andamiro.dao.recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.andamiro.dto.recipe.RecipeDetailVO;
import com.andamiro.dto.recipe.RecipeIngreVO;
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
			pstmt.setString(2, recipeVO.getRecipeDetailVO().getRecipePicId().getPic01());
			pstmt.setString(3, recipeVO.getRecipeDetailVO().getRecipePicId().getPic02());
			pstmt.setString(4, recipeVO.getRecipeDetailVO().getRecipePicId().getPic03());
			pstmt.setString(5, recipeVO.getRecipeDetailVO().getRecipePicId().getPic04());
			pstmt.setString(6, recipeVO.getRecipeDetailVO().getRecipePicId().getPic05());
			pstmt.executeUpdate();

			sql = "INSERT INTO RECIPEORDER (RECIPEORDERID,RECIPEID, ORDER01, ORDER02, ORDER03, ORDER04, ORDER05) "
					+ "VALUES (ORDERID_SEQ.nextval,?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipeId);
			pstmt.setString(2, recipeVO.getRecipeDetailVO().getOrderId().getOrder01());
			pstmt.setString(3, recipeVO.getRecipeDetailVO().getOrderId().getOrder02());
			pstmt.setString(4, recipeVO.getRecipeDetailVO().getOrderId().getOrder03());
			pstmt.setString(5, recipeVO.getRecipeDetailVO().getOrderId().getOrder04());
			pstmt.setString(6, recipeVO.getRecipeDetailVO().getOrderId().getOrder05());
			pstmt.executeUpdate();

			sql = "INSERT INTO RECIPEINGRE (INGREID , RECIPEID, INGRE01, INGRE02, INGRE03, INGRE04, INGRE05, INGRE06, INGRE07, "
					+ "INGRE08, INGRE09, INGRE10, INGRE11, INGRE12) "
					+ "VALUES (INGREID_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipeId);
			pstmt.setString(2, recipeVO.getRecipeDetailVO().getRecipeingreId().getIngre01());
			pstmt.setString(3, recipeVO.getRecipeDetailVO().getRecipeingreId().getIngre02());
			pstmt.setString(4, recipeVO.getRecipeDetailVO().getRecipeingreId().getIngre03());
			pstmt.setString(5, recipeVO.getRecipeDetailVO().getRecipeingreId().getIngre04());
			pstmt.setString(6, recipeVO.getRecipeDetailVO().getRecipeingreId().getIngre05());
			pstmt.setString(7, recipeVO.getRecipeDetailVO().getRecipeingreId().getIngre06());
			pstmt.setString(8, recipeVO.getRecipeDetailVO().getRecipeingreId().getIngre07());
			pstmt.setString(9, recipeVO.getRecipeDetailVO().getRecipeingreId().getIngre08());
			pstmt.setString(10, recipeVO.getRecipeDetailVO().getRecipeingreId().getIngre09());
			pstmt.setString(11, recipeVO.getRecipeDetailVO().getRecipeingreId().getIngre10());
			pstmt.setString(12, recipeVO.getRecipeDetailVO().getRecipeingreId().getIngre11());
			pstmt.setString(13, recipeVO.getRecipeDetailVO().getRecipeingreId().getIngre12());
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

			recipeDetailVO.setRecipePicId(recipePicVo);
			recipeDetailVO.setOrderId(recipeOrderVo);
			recipeDetailVO.setRecipeingreId(recipeIngreVO);

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
		}finally {
			DBManager.close(conn, pstmt);
		}
	}

}