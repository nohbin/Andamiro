package com.andamiro.dao.recipe;

import java.sql.*;
import java.util.*;

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
	private RecipeDAO() {}
	public static RecipeDAO getInstance() {
		if (instance == null) {
			instance = new RecipeDAO();
		}
		return instance;
	}

	public void registRecipe(RecipeVO recipeVO) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = DBManager.getConnection();

	        String insertRecipeQuery = "INSERT INTO ANDAMIRORECIPE (recipeId, memberNumber, recipeName, mainPicture, recipetag1, recipetag2, recipetag3, USERID, recipedetailid) " +
	                "VALUES (RECIPEID_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, RECIPEID_SEQ.currval)";
	        pstmt = conn.prepareStatement(insertRecipeQuery);
	        pstmt.setInt(1, recipeVO.getMemberNumber());
	        pstmt.setString(2, recipeVO.getRecipeName());
	        pstmt.setString(3, recipeVO.getMainPicture());
	        pstmt.setString(4, recipeVO.getRecipetag1());
	        pstmt.setString(5, recipeVO.getRecipetag2());
	        pstmt.setString(6, recipeVO.getRecipetag3());
	        pstmt.setString(7, recipeVO.getUserId());
	        pstmt.executeUpdate();

	        int recipeId = 0;
	        String selectRecipeIdQuery = "SELECT recipeid_seq.currval FROM dual";
	        pstmt = conn.prepareStatement(selectRecipeIdQuery);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            recipeId = rs.getInt(1);
	        }

	        String insertRecipePictureQuery = "INSERT INTO RECIPEPICTURE (RECIPEPICID, RECIPEID, PIC01, PIC02, PIC03, PIC04, PIC05) " +
	                "VALUES (PICID_SEQ.nextval, ?, ?, ?, ?, ?, ?)";
	        pstmt = conn.prepareStatement(insertRecipePictureQuery);
	        pstmt.setInt(1, recipeId);
	        RecipePicVO recipePicVO = recipeVO.getRecipeDetailVO().getRecipePicVO();
	        pstmt.setString(2, recipePicVO.getPic01());
	        pstmt.setString(3, recipePicVO.getPic02());
	        pstmt.setString(4, recipePicVO.getPic03());
	        pstmt.setString(5, recipePicVO.getPic04());
	        pstmt.setString(6, recipePicVO.getPic05());
	        pstmt.executeUpdate();

	        String insertRecipeOrderQuery = "INSERT INTO RECIPEORDER (RECIPEORDERID, RECIPEID, ORDER01, ORDER02, ORDER03, ORDER04, ORDER05) " +
	                "VALUES (ORDERID_SEQ.nextval, ?, ?, ?, ?, ?, ?)";
	        pstmt = conn.prepareStatement(insertRecipeOrderQuery);
	        pstmt.setInt(1, recipeId);
	        RecipeOrderVO recipeOrderVO = recipeVO.getRecipeDetailVO().getRecipeOrderVO();
	        pstmt.setString(2, recipeOrderVO.getOrder01());
	        pstmt.setString(3, recipeOrderVO.getOrder02());
	        pstmt.setString(4, recipeOrderVO.getOrder03());
	        pstmt.setString(5, recipeOrderVO.getOrder04());
	        pstmt.setString(6, recipeOrderVO.getOrder05());
	        pstmt.executeUpdate();

	        String insertRecipeIngreQuery = "INSERT INTO RECIPEINGRE (INGREID, RECIPEID, INGRE01, INGRE02, INGRE03, INGRE04, INGRE05, INGRE06, INGRE07, " +
	                "INGRE08, INGRE09, INGRE10, INGRE11, INGRE12) " +
	                "VALUES (INGREID_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        pstmt = conn.prepareStatement(insertRecipeIngreQuery);
	        pstmt.setInt(1, recipeId);
	        RecipeIngreVO recipeIngreVO = recipeVO.getRecipeDetailVO().getRecipeingreVO();
	        pstmt.setString(2, recipeIngreVO.getIngre01());
	        pstmt.setString(3, recipeIngreVO.getIngre02());
	        pstmt.setString(4, recipeIngreVO.getIngre03());
	        pstmt.setString(5, recipeIngreVO.getIngre04());
	        pstmt.setString(6, recipeIngreVO.getIngre05());
	        pstmt.setString(7, recipeIngreVO.getIngre06());
	        pstmt.setString(8, recipeIngreVO.getIngre07());
	        pstmt.setString(9, recipeIngreVO.getIngre08());
	        pstmt.setString(10, recipeIngreVO.getIngre09());
	        pstmt.setString(11, recipeIngreVO.getIngre10());
	        pstmt.setString(12, recipeIngreVO.getIngre11());
	        pstmt.setString(13, recipeIngreVO.getIngre12());
	        pstmt.executeUpdate();

	        int recipePicId = 0;
	        String selectRecipePicIdQuery = "SELECT PICID_SEQ.currval FROM dual";
	        pstmt = conn.prepareStatement(selectRecipePicIdQuery);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            recipePicId = rs.getInt(1);
	        }

	        int recipeOrderId = 0;
	        String selectRecipeOrderIdQuery = "SELECT ORDERID_SEQ.currval FROM dual";
	        pstmt = conn.prepareStatement(selectRecipeOrderIdQuery);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            recipeOrderId = rs.getInt(1);
	        }

	        int ingreId = 0;
	        String selectIngreIdQuery = "SELECT INGREID_SEQ.currval FROM dual";
	        pstmt = conn.prepareStatement(selectIngreIdQuery);
	        rs = pstmt.executeQuery();
	        if (rs.next()) {
	            ingreId = rs.getInt(1);
	        }

	        String insertRecipeDetailQuery = "INSERT INTO ANDAMIRORECIPE_DETAIL (RECIPEDETAILID, RECIPEID, RECIPEHOW, RECIPEKIND, RECIPEMAININGRE, RECIPEFORPERSON, " +
	                "RECIPEFORTIME, RECIPEFORLEVEL, RECIPEDISCRIPTION, recipePicId, OrderId, recipeingreId) " +
	                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        pstmt = conn.prepareStatement(insertRecipeDetailQuery);
	        pstmt.setInt(1, recipeId);
	        pstmt.setInt(2, recipeId);
	        RecipeDetailVO recipeDetailVO = recipeVO.getRecipeDetailVO();
	        pstmt.setInt(3, recipeDetailVO.getRecipeHow());
	        pstmt.setInt(4, recipeDetailVO.getRecipeKind());
	        pstmt.setInt(5, recipeDetailVO.getRecipeMainIngre());
	        pstmt.setString(6, recipeDetailVO.getRecipeforperson());
	        pstmt.setString(7, recipeDetailVO.getRecipefortime());
	        pstmt.setString(8, recipeDetailVO.getRecipeforlevel());
	        pstmt.setString(9, recipeDetailVO.getRecipeDiscription());
	        pstmt.setInt(10, recipePicId);
	        pstmt.setInt(11, recipeOrderId);
	        pstmt.setInt(12, ingreId);
	        pstmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBManager.close(conn, pstmt, rs);
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

	public RecipeVO selectOneRecipeByID(int recipeID) {
		RecipeVO recipeVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();

			// 레시피 정보 쿼리
			String recipeSql = "SELECT * FROM ANDAMIRORECIPE WHERE RECIPEID = ?";
			pstmt = conn.prepareStatement(recipeSql);
			pstmt.setInt(1, recipeID);
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

			if (recipeVO != null) {
				// 레시피 디테일 쿼리
				String recipeDetailSql = "SELECT * FROM ANDAMIRORECIPE_DETAIL WHERE RECIPEID = ?";
				pstmt = conn.prepareStatement(recipeDetailSql);
				pstmt.setInt(1, recipeID);
				rs = pstmt.executeQuery();

				if (rs.next()) {
					RecipeDetailVO recipeDetailVO = new RecipeDetailVO();
					recipeDetailVO.setRecipeDetailID(rs.getInt("RECIPEDETAILID"));
					recipeDetailVO.setRecipeID(rs.getInt("RECIPEID"));
					recipeDetailVO.setRecipeHow(rs.getInt("RECIPEHOW"));
					recipeDetailVO.setRecipeKind(rs.getInt("RECIPEKIND"));
					recipeDetailVO.setRecipeMainIngre(rs.getInt("RECIPEMAININGRE"));
					recipeDetailVO.setRecipeDiscription(rs.getString("RECIPEDISCRIPTION"));
					recipeDetailVO.setRecipeforperson(rs.getString("RECIPEFORPERSON"));
					recipeDetailVO.setRecipefortime(rs.getString("RECIPEFORTIME"));
					recipeDetailVO.setRecipeforlevel(rs.getString("RECIPEFORLEVEL"));

					// 레시피 사진 쿼리
					String recipePicSql = "SELECT * FROM RECIPEPICTURE WHERE RECIPEID = ?";
					pstmt = conn.prepareStatement(recipePicSql);
					pstmt.setInt(1, recipeID);
					ResultSet picRs = pstmt.executeQuery();

					if (picRs.next()) {
						RecipePicVO recipePicVo = new RecipePicVO();
						recipePicVo.setRecipePicid(picRs.getInt("RECIPEPICID"));
						recipePicVo.setRecipeId(picRs.getInt("RECIPEID"));
						recipePicVo.setPic01(picRs.getString("PIC01"));
						recipePicVo.setPic02(picRs.getString("PIC02"));
						recipePicVo.setPic03(picRs.getString("PIC03"));
						recipePicVo.setPic04(picRs.getString("PIC04"));
						recipePicVo.setPic05(picRs.getString("PIC05"));
						recipeDetailVO.setRecipePicVO(recipePicVo);
					}

					// 레시피 순서 쿼리
					String recipeOrderSql = "SELECT * FROM RECIPEORDER WHERE RECIPEID = ?";
					pstmt = conn.prepareStatement(recipeOrderSql);
					pstmt.setInt(1, recipeID);
					ResultSet orderRs = pstmt.executeQuery();

					if (orderRs.next()) {
						RecipeOrderVO recipeOrderVo = new RecipeOrderVO();
						recipeOrderVo.setRecipeOrderId(orderRs.getInt("RECIPEORDERID"));
						recipeOrderVo.setRecipeId(orderRs.getInt("RECIPEID"));
						recipeOrderVo.setOrder01(orderRs.getString("ORDER01"));
						recipeOrderVo.setOrder02(orderRs.getString("ORDER02"));
						recipeOrderVo.setOrder03(orderRs.getString("ORDER03"));
						recipeOrderVo.setOrder04(orderRs.getString("ORDER04"));
						recipeOrderVo.setOrder05(orderRs.getString("ORDER05"));
						recipeDetailVO.setRecipeOrderVO(recipeOrderVo);
					}

					// 레시피 재료 쿼리
					String recipeIngreSql = "SELECT * FROM RECIPEINGRE WHERE RECIPEID = ?";
					pstmt = conn.prepareStatement(recipeIngreSql);
					pstmt.setInt(1, recipeID);
					ResultSet ingreRs = pstmt.executeQuery();

					if (ingreRs.next()) {
						RecipeIngreVO recipeIngreVO = new RecipeIngreVO();
						recipeIngreVO.setIngreid(ingreRs.getInt("INGREID"));
						recipeIngreVO.setRecipeId(ingreRs.getInt("RECIPEID"));
						recipeIngreVO.setIngre01(ingreRs.getString("INGRE01"));
						recipeIngreVO.setIngre02(ingreRs.getString("INGRE02"));
						recipeIngreVO.setIngre03(ingreRs.getString("INGRE03"));
						recipeIngreVO.setIngre04(ingreRs.getString("INGRE04"));
						recipeIngreVO.setIngre05(ingreRs.getString("INGRE05"));
						recipeIngreVO.setIngre06(ingreRs.getString("INGRE06"));
						recipeIngreVO.setIngre07(ingreRs.getString("INGRE07"));
						recipeIngreVO.setIngre08(ingreRs.getString("INGRE08"));
						recipeIngreVO.setIngre09(ingreRs.getString("INGRE09"));
						recipeIngreVO.setIngre10(ingreRs.getString("INGRE10"));
						recipeIngreVO.setIngre11(ingreRs.getString("INGRE11"));
						recipeIngreVO.setIngre12(ingreRs.getString("INGRE12"));
						recipeDetailVO.setRecipeingreVO(recipeIngreVO);
					}

					recipeVO.setRecipeDetailVO(recipeDetailVO);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// 리소스 정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
				recipeVO.setReviewCount(rs.getInt("REVIEWCOUNT"));
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

	public void updateRecipeByRecipeId(int recipeId, RecipeVO recipeVO) {
	    Connection conn = null;
	    PreparedStatement pstmt = null;

	    try {
	        conn = DBManager.getConnection();

	        String updateRecipe = "UPDATE ANDAMIRORECIPE SET recipeName = ?, mainPicture = ?, recipetag1 = ?, " +
	                "recipetag2 = ?, recipetag3 = ? WHERE RECIPEID = ?";
	        pstmt = conn.prepareStatement(updateRecipe);
	        pstmt.setString(1, recipeVO.getRecipeName());
	        pstmt.setString(2, recipeVO.getMainPicture());
	        pstmt.setObject(3, recipeVO.getRecipetag1());
	        pstmt.setObject(4, recipeVO.getRecipetag2());
	        pstmt.setObject(5, recipeVO.getRecipetag3());
	        pstmt.setInt(6, recipeId);
	        pstmt.executeUpdate();

	        // Update RECIPEPICTURE table
	        String updateRecipePicture = "UPDATE RECIPEPICTURE SET PIC01 = ?, PIC02 = ?, PIC03 = ?, PIC04 = ?, PIC05 = ? " +
	                "WHERE RECIPEID = ?";
	        pstmt = conn.prepareStatement(updateRecipePicture);
	        RecipePicVO recipePicVO = recipeVO.getRecipeDetailVO().getRecipePicVO();
	        pstmt.setObject(1, recipePicVO.getPic01());
	        pstmt.setObject(2, recipePicVO.getPic02());
	        pstmt.setObject(3, recipePicVO.getPic03());
	        pstmt.setObject(4, recipePicVO.getPic04());
	        pstmt.setObject(5, recipePicVO.getPic05());
	        pstmt.setInt(6, recipeId);
	        pstmt.executeUpdate();

	        String updateRecipeIngre = "UPDATE RECIPEINGRE SET INGRE01 = ?, INGRE02 = ?, INGRE03 = ?, INGRE04 = ?, " +
	                "INGRE05 = ?, INGRE06 = ?, INGRE07 = ?, INGRE08 = ?, INGRE09 = ?, INGRE10 = ?, INGRE11 = ?, INGRE12 = ? " +
	                "WHERE RECIPEID = ?";
	        pstmt = conn.prepareStatement(updateRecipeIngre);
	        RecipeIngreVO recipeIngreVO = recipeVO.getRecipeDetailVO().getRecipeingreVO();
	        pstmt.setObject(1, recipeIngreVO.getIngre01());
	        pstmt.setObject(2, recipeIngreVO.getIngre02());
	        pstmt.setObject(3, recipeIngreVO.getIngre03());
	        pstmt.setObject(4, recipeIngreVO.getIngre04());
	        pstmt.setObject(5, recipeIngreVO.getIngre05());
	        pstmt.setObject(6, recipeIngreVO.getIngre06());
	        pstmt.setObject(7, recipeIngreVO.getIngre07());
	        pstmt.setObject(8, recipeIngreVO.getIngre08());
	        pstmt.setObject(9, recipeIngreVO.getIngre09());
	        pstmt.setObject(10, recipeIngreVO.getIngre10());
	        pstmt.setObject(11, recipeIngreVO.getIngre11());
	        pstmt.setObject(12, recipeIngreVO.getIngre12());
	        pstmt.setInt(13, recipeId);
	        pstmt.executeUpdate();

	        // Update RECIPEORDER table
	        String updateRecipeOrder = "UPDATE RECIPEORDER SET ORDER01 = ?, ORDER02 = ?, ORDER03 = ?, ORDER04 = ?, " +
	                "ORDER05 = ? WHERE RECIPEID = ?";
	        pstmt = conn.prepareStatement(updateRecipeOrder);
	        RecipeOrderVO recipeOrderVO = recipeVO.getRecipeDetailVO().getRecipeOrderVO();
	        pstmt.setObject(1, recipeOrderVO.getOrder01());
	        pstmt.setObject(2, recipeOrderVO.getOrder02());
	        pstmt.setObject(3, recipeOrderVO.getOrder03());
	        pstmt.setObject(4, recipeOrderVO.getOrder04());
	        pstmt.setObject(5, recipeOrderVO.getOrder05());
	        pstmt.setInt(6, recipeId);
	        pstmt.executeUpdate();

	        String updateRecipeDetail = "UPDATE ANDAMIRORECIPE_DETAIL SET RECIPEHOW = ?, RECIPEKIND = ?, " +
	                "RECIPEMAININGRE = ?, RECIPEFORPERSON = ?, RECIPEFORTIME = ?, RECIPEFORLEVEL = ?, RECIPEDISCRIPTION = ? " +
	                "WHERE RECIPEID = ?";
	        pstmt = conn.prepareStatement(updateRecipeDetail);
	        RecipeDetailVO recipeDetailVO = recipeVO.getRecipeDetailVO();
	        pstmt.setInt(1, recipeDetailVO.getRecipeHow());
	        pstmt.setInt(2, recipeDetailVO.getRecipeKind());
	        pstmt.setInt(3, recipeDetailVO.getRecipeMainIngre());
	        pstmt.setString(4, recipeDetailVO.getRecipeforperson());
	        pstmt.setString(5, recipeDetailVO.getRecipefortime());
	        pstmt.setString(6, recipeDetailVO.getRecipeforlevel());
	        pstmt.setString(7, recipeDetailVO.getRecipeDiscription());
	        pstmt.setInt(8, recipeId);
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	       DBManager.close(conn, pstmt);
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
				recipeVO.setReviewCount(rs.getInt("REVIEWCOUNT"));
				list.add(recipeVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
		}finally {
			DBManager.close(conn, pstmt);
		}

	}

	public void updateReviewCountByRecipeId(int recipeId) {
		// TODO Auto-generated method stub
		String sql = "update andamirorecipe set reviewcount = (select count(recipeid) from andamiroreview where recipeid=?) where recipeid = ?";
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
		}finally {
			DBManager.close(conn, pstmt);
		}

	}

}
