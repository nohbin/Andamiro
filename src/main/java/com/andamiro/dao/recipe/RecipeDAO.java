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

	private RecipeDAO() {
	}

	public static RecipeDAO getInstance() {
		if (instance == null) {
			instance = new RecipeDAO();
		}
		return instance;
	}

	public void registRecipe(RecipeVO recipeVO) {
		try (Connection conn = DBManager.getConnection();) {
			String insertRecipe = "INSERT INTO ANDAMIRORECIPE (recipeId, memberNumber, recipeName, mainPicture, recipetag1, recipetag2, recipetag3, USERID, recipedetailid) "
					+ "VALUES (RECIPEID_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, RECIPEID_SEQ.currval)";
			try (PreparedStatement pstmt = conn.prepareStatement(insertRecipe);) {
				pstmt.setInt(1, recipeVO.getMemberNumber());
				pstmt.setString(2, recipeVO.getRecipeName());
				pstmt.setString(3, recipeVO.getMainPicture());
				pstmt.setString(4, recipeVO.getRecipetag1());
				pstmt.setString(5, recipeVO.getRecipetag2());
				pstmt.setString(6, recipeVO.getRecipetag3());
				pstmt.setString(7, recipeVO.getUserId());
				pstmt.executeUpdate();
			}

			int recipeId = 0;
			String selectRecipeId = "SELECT recipeid_seq.currval FROM dual";
			try (PreparedStatement pstmt = conn.prepareStatement(selectRecipeId);
					ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					recipeId = rs.getInt(1);
				}
			}

			String insertRecipePicture = "INSERT INTO RECIPEPICTURE (RECIPEPICID, RECIPEID, PIC01, PIC02, PIC03, PIC04, PIC05) "
					+ "VALUES (PICID_SEQ.nextval, ?, ?, ?, ?, ?, ?)";
			try (PreparedStatement pstmt = conn.prepareStatement(insertRecipePicture);) {
				pstmt.setInt(1, recipeId);
				RecipePicVO recipePicVO = recipeVO.getRecipeDetailVO().getRecipePicVO();
				pstmt.setString(2, recipePicVO.getPic01());
				pstmt.setString(3, recipePicVO.getPic02());
				pstmt.setString(4, recipePicVO.getPic03());
				pstmt.setString(5, recipePicVO.getPic04());
				pstmt.setString(6, recipePicVO.getPic05());
				pstmt.executeUpdate();
			}

			String insertRecipeOrder = "INSERT INTO RECIPEORDER (RECIPEORDERID, RECIPEID, ORDER01, ORDER02, ORDER03, ORDER04, ORDER05) "
					+ "VALUES (ORDERID_SEQ.nextval, ?, ?, ?, ?, ?, ?)";
			try (PreparedStatement pstmt = conn.prepareStatement(insertRecipeOrder);) {
				pstmt.setInt(1, recipeId);
				RecipeOrderVO recipeOrderVO = recipeVO.getRecipeDetailVO().getRecipeOrderVO();
				pstmt.setString(2, recipeOrderVO.getOrder01());
				pstmt.setString(3, recipeOrderVO.getOrder02());
				pstmt.setString(4, recipeOrderVO.getOrder03());
				pstmt.setString(5, recipeOrderVO.getOrder04());
				pstmt.setString(6, recipeOrderVO.getOrder05());
				pstmt.executeUpdate();
			}

			String insertRecipeIngre = "INSERT INTO RECIPEINGRE (INGREID, RECIPEID, INGRE01, INGRE02, INGRE03, INGRE04, INGRE05, INGRE06, INGRE07, "
					+ "INGRE08, INGRE09, INGRE10, INGRE11, INGRE12) "
					+ "VALUES (INGREID_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try (PreparedStatement pstmt = conn.prepareStatement(insertRecipeIngre);) {
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
			}

			int recipePicId = 0;
			String selectRecipePicId = "SELECT PICID_SEQ.currval FROM dual";
			try (PreparedStatement pstmt = conn.prepareStatement(selectRecipePicId);
					ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					recipePicId = rs.getInt(1);
				}
			}

			int recipeOrderId = 0;
			String selectRecipeOrderId = "SELECT ORDERID_SEQ.currval FROM dual";
			try (PreparedStatement pstmt = conn.prepareStatement(selectRecipeOrderId);
					ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					recipeOrderId = rs.getInt(1);
				}
			}

			int ingreId = 0;
			String selectIngreId = "SELECT INGREID_SEQ.currval FROM dual";
			try (PreparedStatement pstmt = conn.prepareStatement(selectIngreId); ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					ingreId = rs.getInt(1);
				}
			}

			String insertRecipeDetail = "INSERT INTO ANDAMIRORECIPE_DETAIL (RECIPEDETAILID, RECIPEID, RECIPEHOW, RECIPEKIND, RECIPEMAININGRE, RECIPEFORPERSON, "
					+ "RECIPEFORTIME, RECIPEFORLEVEL, RECIPEDISCRIPTION, recipePicId, OrderId, recipeingreId) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try (PreparedStatement pstmt = conn.prepareStatement(insertRecipeDetail)) {
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<RecipeVO> selectAllRecipe() {
		// TODO Auto-generated method stub

		List<RecipeVO> list = new ArrayList<>();

		String sql = "select * from andamirorecipe order by RECIPEREGDATE desc";

		try (Connection conn = DBManager.getConnection(); Statement stmt = conn.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public RecipeVO selectOneRecipeByID(int recipeID) {
		RecipeVO recipeVO = null;

		try (Connection conn = DBManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ANDAMIRORECIPE WHERE RECIPEID = ?");
				PreparedStatement pstmtDetail = conn.prepareStatement("SELECT * FROM ANDAMIRORECIPE_DETAIL WHERE RECIPEID = ?");
				PreparedStatement pstmtPic = conn.prepareStatement("SELECT * FROM RECIPEPICTURE WHERE RECIPEID = ?");
				PreparedStatement pstmtOrder = conn.prepareStatement("SELECT * FROM RECIPEORDER WHERE RECIPEID = ?");
				PreparedStatement pstmtIngre = conn.prepareStatement("SELECT * FROM RECIPEINGRE WHERE RECIPEID = ?");) {
			pstmt.setInt(1, recipeID);
			pstmtDetail.setInt(1, recipeID);
			pstmtPic.setInt(1, recipeID);
			pstmtOrder.setInt(1, recipeID);
			pstmtIngre.setInt(1, recipeID);
			try (ResultSet rs = pstmt.executeQuery()) {
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
					recipeVO.setReviewCount(rs.getInt("REVIEWCOUNT"));
				}
			}

			if (recipeVO != null) {
				try (ResultSet rsDetail = pstmtDetail.executeQuery()) {
					if (rsDetail.next()) {
						RecipeDetailVO recipeDetailVO = new RecipeDetailVO();
						recipeDetailVO.setRecipeDetailID(rsDetail.getInt("RECIPEDETAILID"));
						recipeDetailVO.setRecipeID(rsDetail.getInt("RECIPEID"));
						recipeDetailVO.setRecipeHow(rsDetail.getInt("RECIPEHOW"));
						recipeDetailVO.setRecipeKind(rsDetail.getInt("RECIPEKIND"));
						recipeDetailVO.setRecipeMainIngre(rsDetail.getInt("RECIPEMAININGRE"));
						recipeDetailVO.setRecipeDiscription(rsDetail.getString("RECIPEDISCRIPTION"));
						recipeDetailVO.setRecipeforperson(rsDetail.getString("RECIPEFORPERSON"));
						recipeDetailVO.setRecipefortime(rsDetail.getString("RECIPEFORTIME"));
						recipeDetailVO.setRecipeforlevel(rsDetail.getString("RECIPEFORLEVEL"));

						try (ResultSet rsPic = pstmtPic.executeQuery()) {
							if (rsPic.next()) {
								RecipePicVO recipePicVO = new RecipePicVO();
								recipePicVO.setRecipePicid(rsPic.getInt("RECIPEPICID"));
								recipePicVO.setRecipeId(rsPic.getInt("RECIPEID"));
								recipePicVO.setPic01(rsPic.getString("PIC01"));
								recipePicVO.setPic02(rsPic.getString("PIC02"));
								recipePicVO.setPic03(rsPic.getString("PIC03"));
								recipePicVO.setPic04(rsPic.getString("PIC04"));
								recipePicVO.setPic05(rsPic.getString("PIC05"));
								recipeDetailVO.setRecipePicVO(recipePicVO);
							}
						}

						try (ResultSet rsOrder = pstmtOrder.executeQuery()) {
							if (rsOrder.next()) {
								RecipeOrderVO recipeOrderVO = new RecipeOrderVO();
								recipeOrderVO.setRecipeOrderId(rsOrder.getInt("RECIPEORDERID"));
								recipeOrderVO.setRecipeId(rsOrder.getInt("RECIPEID"));
								recipeOrderVO.setOrder01(rsOrder.getString("ORDER01"));
								recipeOrderVO.setOrder02(rsOrder.getString("ORDER02"));
								recipeOrderVO.setOrder03(rsOrder.getString("ORDER03"));
								recipeOrderVO.setOrder04(rsOrder.getString("ORDER04"));
								recipeOrderVO.setOrder05(rsOrder.getString("ORDER05"));
								recipeDetailVO.setRecipeOrderVO(recipeOrderVO);
							}
						}

						try (ResultSet rsIngre = pstmtIngre.executeQuery()) {
							if (rsIngre.next()) {
								RecipeIngreVO recipeIngreVO = new RecipeIngreVO();
								recipeIngreVO.setIngreid(rsIngre.getInt("INGREID"));
								recipeIngreVO.setRecipeId(rsIngre.getInt("RECIPEID"));
								recipeIngreVO.setIngre01(rsIngre.getString("INGRE01"));
								recipeIngreVO.setIngre02(rsIngre.getString("INGRE02"));
								recipeIngreVO.setIngre03(rsIngre.getString("INGRE03"));
								recipeIngreVO.setIngre04(rsIngre.getString("INGRE04"));
								recipeIngreVO.setIngre05(rsIngre.getString("INGRE05"));
								recipeIngreVO.setIngre06(rsIngre.getString("INGRE06"));
								recipeIngreVO.setIngre07(rsIngre.getString("INGRE07"));
								recipeIngreVO.setIngre08(rsIngre.getString("INGRE08"));
								recipeIngreVO.setIngre09(rsIngre.getString("INGRE09"));
								recipeIngreVO.setIngre10(rsIngre.getString("INGRE10"));
								recipeIngreVO.setIngre11(rsIngre.getString("INGRE11"));
								recipeIngreVO.setIngre12(rsIngre.getString("INGRE12"));
								recipeDetailVO.setRecipeingreVO(recipeIngreVO);
							}
						}
						recipeVO.setRecipeDetailVO(recipeDetailVO);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recipeVO;
	}

	public void updateViewCount(int recipID) {
		// TODO Auto-generated method stub
		String sql = "update ANDAMIRORECIPE set RECIPEVIEW = RECIPEVIEW + 1 where RECIPEID = ?";

		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, recipID);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<RecipeVO> selectAllRecipeByMainIngre(int mainIngre) {
		String sql = "select * from andamirorecipe where recipeid in "
				+ "(select recipeid from andamirorecipe_detail where recipemainingre = ?) order by RECIPEREGDATE desc";

		List<RecipeVO> list = new ArrayList<>();
		try (Connection conn = DBManager.getConnection(); 
			 PreparedStatement pstmt = conn.prepareStatement(sql);) 
		{
			pstmt.setInt(1, mainIngre);
			try (ResultSet rs = pstmt.executeQuery();) {
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RecipeVO> selectAllRecipeByHow(int how) {
		String sql = "select * from andamirorecipe where recipeid in "
				+ "(select recipeid from andamirorecipe_detail where recipehow = ?) order by RECIPEREGDATE desc";

		List<RecipeVO> list = new ArrayList<>();
		try (Connection conn = DBManager.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql);) 
		{
			pstmt.setInt(1, how);

			try (ResultSet rs = pstmt.executeQuery();) {
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RecipeVO> selectAllRecipeByKind(int kind) {
		String sql = "select * from andamirorecipe where recipeid in "
				+ "(select recipeid from andamirorecipe_detail where recipekind = ? ) order by RECIPEREGDATE desc";

		List<RecipeVO> list = new ArrayList<>();
		try (Connection conn = DBManager.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql);)

		{
			pstmt.setInt(1, kind);
			try (ResultSet rs = pstmt.executeQuery();) {
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RecipeVO> selectAllRecipeByMemberNumber(int memberNumber) {
		List<RecipeVO> list = new ArrayList<>();
		String sql = "select * from andamirorecipe where membernumber = ? order by RECIPEREGDATE desc";

		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, memberNumber);
			try (ResultSet rs = pstmt.executeQuery()) {
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void deleteRecipeById(int recipeId) {
		// TODO Auto-generated method stub
		String sql = "delete from andamiroRecipe where recipeid = ?";

		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, recipeId);
			pstmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateRecipeByRecipeId(int recipeId, RecipeVO recipeVO) {
		try (Connection conn = DBManager.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("UPDATE ANDAMIRORECIPE SET recipeName = ?, mainPicture = ?, recipetag1 = ?, recipetag2 = ?, recipetag3 = ? WHERE RECIPEID = ?");
				PreparedStatement pstmtPic = conn.prepareStatement("UPDATE RECIPEPICTURE SET PIC01 = ?, PIC02 = ?, PIC03 = ?, PIC04 = ?, PIC05 = ? WHERE RECIPEID = ?");
				PreparedStatement pstmtIngre = conn.prepareStatement("UPDATE RECIPEINGRE SET INGRE01 = ?, INGRE02 = ?, INGRE03 = ?, INGRE04 = ?, INGRE05 = ?, INGRE06 = ?, INGRE07 = ?, INGRE08 = ?, INGRE09 = ?, INGRE10 = ?, INGRE11 = ?, INGRE12 = ? WHERE RECIPEID = ?");
				PreparedStatement pstmtOrder = conn.prepareStatement("UPDATE RECIPEORDER SET ORDER01 = ?, ORDER02 = ?, ORDER03 = ?, ORDER04 = ?, ORDER05 = ? WHERE RECIPEID = ?");
				PreparedStatement pstmtDetail = conn.prepareStatement("UPDATE ANDAMIRORECIPE_DETAIL SET RECIPEHOW = ?, RECIPEKIND = ?, RECIPEMAININGRE = ?, RECIPEFORPERSON = ?, RECIPEFORTIME = ?, RECIPEFORLEVEL = ?, RECIPEDISCRIPTION = ? WHERE RECIPEID = ?")) {
			// 안다미로레시피 업데이트
			pstmt.setString(1, recipeVO.getRecipeName());
			pstmt.setString(2, recipeVO.getMainPicture());
			pstmt.setObject(3, recipeVO.getRecipetag1());
			pstmt.setObject(4, recipeVO.getRecipetag2());
			pstmt.setObject(5, recipeVO.getRecipetag3());
			pstmt.setInt(6, recipeId);
			pstmt.executeUpdate();

			// 레시피 사진 업데이트
			RecipePicVO recipePicVO = recipeVO.getRecipeDetailVO().getRecipePicVO();
			pstmtPic.setObject(1, recipePicVO.getPic01());
			pstmtPic.setObject(2, recipePicVO.getPic02());
			pstmtPic.setObject(3, recipePicVO.getPic03());
			pstmtPic.setObject(4, recipePicVO.getPic04());
			pstmtPic.setObject(5, recipePicVO.getPic05());
			pstmtPic.setInt(6, recipeId);
			pstmtPic.executeUpdate();

			// 재료 업데이트
			RecipeIngreVO recipeIngreVO = recipeVO.getRecipeDetailVO().getRecipeingreVO();
			pstmtIngre.setObject(1, recipeIngreVO.getIngre01());
			pstmtIngre.setObject(2, recipeIngreVO.getIngre02());
			pstmtIngre.setObject(3, recipeIngreVO.getIngre03());
			pstmtIngre.setObject(4, recipeIngreVO.getIngre04());
			pstmtIngre.setObject(5, recipeIngreVO.getIngre05());
			pstmtIngre.setObject(6, recipeIngreVO.getIngre06());
			pstmtIngre.setObject(7, recipeIngreVO.getIngre07());
			pstmtIngre.setObject(8, recipeIngreVO.getIngre08());
			pstmtIngre.setObject(9, recipeIngreVO.getIngre09());
			pstmtIngre.setObject(10, recipeIngreVO.getIngre10());
			pstmtIngre.setObject(11, recipeIngreVO.getIngre11());
			pstmtIngre.setObject(12, recipeIngreVO.getIngre12());
			pstmtIngre.setInt(13, recipeId);
			pstmtIngre.executeUpdate();

			// 순서 업데이트
			RecipeOrderVO recipeOrderVO = recipeVO.getRecipeDetailVO().getRecipeOrderVO();
			pstmtOrder.setObject(1, recipeOrderVO.getOrder01());
			pstmtOrder.setObject(2, recipeOrderVO.getOrder02());
			pstmtOrder.setObject(3, recipeOrderVO.getOrder03());
			pstmtOrder.setObject(4, recipeOrderVO.getOrder04());
			pstmtOrder.setObject(5, recipeOrderVO.getOrder05());
			pstmtOrder.setInt(6, recipeId);
			pstmtOrder.executeUpdate();

			//상세 레시피 업데이트
			RecipeDetailVO recipeDetailVO = recipeVO.getRecipeDetailVO();
			pstmtDetail.setInt(1, recipeDetailVO.getRecipeHow());
			pstmtDetail.setInt(2, recipeDetailVO.getRecipeKind());
			pstmtDetail.setInt(3, recipeDetailVO.getRecipeMainIngre());
			pstmtDetail.setString(4, recipeDetailVO.getRecipeforperson());
			pstmtDetail.setString(5, recipeDetailVO.getRecipefortime());
			pstmtDetail.setString(6, recipeDetailVO.getRecipeforlevel());
			pstmtDetail.setString(7, recipeDetailVO.getRecipeDiscription());
			pstmtDetail.setInt(8, recipeId);
			pstmtDetail.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<RecipeKindVO> selectAllRecipeKind() {
		// TODO Auto-generated method stub
		List<RecipeKindVO> list = new ArrayList<>();
		try (Connection conn = DBManager.getConnection(); 
			 Statement stmt = conn.createStatement();) {
			try (ResultSet rs = stmt.executeQuery("select * from RECIPEKIND");) {
				while (rs.next()) {
					RecipeKindVO recipeKindVO = new RecipeKindVO();
					recipeKindVO.setRecipeKindId(rs.getInt("RECIPEKINDID"));
					recipeKindVO.setRecipeKind(rs.getString("RECIPEKIND"));
					list.add(recipeKindVO);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<RecipeHowVO> selectAllRecipeHow() {
		List<RecipeHowVO> list = new ArrayList<>();

		try (Connection conn = DBManager.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM RECIPEHOW");
			 ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				RecipeHowVO recipeHowVO = new RecipeHowVO();
				recipeHowVO.setRecipeHowId(rs.getInt("RECIPEHOWID"));
				recipeHowVO.setRecipeHow(rs.getString("RECIPEHOW"));
				list.add(recipeHowVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<RecipeMainIngreVO> selectAllRecipeMainIngre() {
		List<RecipeMainIngreVO> list = new ArrayList<>();

		try (Connection conn = DBManager.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM RECIPEMAININGRE");
			 ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				RecipeMainIngreVO recipeMainIngreVO = new RecipeMainIngreVO();
				recipeMainIngreVO.setRecipeIngreId(rs.getInt("RECIPEINGREID"));
				recipeMainIngreVO.setRecipeIngre(rs.getString("RECIPEINGRE"));
				list.add(recipeMainIngreVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<RecipeVO> selectRecipeByPage(int start, int end) {
		List<RecipeVO> lists = new ArrayList<>();

		String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY recipeid) NUM, A.* FROM andamirorecipe A ORDER BY recipeid) "
				+ "WHERE NUM BETWEEN ? AND ?";

		try (Connection conn = DBManager.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			try (ResultSet rs = pstmt.executeQuery()) {
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
					lists.add(recipeVO);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lists;
	}

	public List<RecipeVO> selectAllRecipeBySubNumber(int subNumber) {
		String sql = "SELECT * FROM andamirorecipe WHERE recipeid IN (SELECT recipeid FROM submemberrecipe WHERE subnumber = ?)";
		List<RecipeVO> list = new ArrayList<>();

		try (Connection conn = DBManager.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, subNumber);
			try (ResultSet rs = pstmt.executeQuery()) {
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public void updateRecipeGradeByRecipeId(int recipeId) {
		String sql = "UPDATE andamirorecipe SET recipegrade = (SELECT TO_CHAR(AVG(recipegrade), 'FM999999990.00') FROM andamiroreview WHERE recipeid = ?) WHERE recipeid = ?";

		try (Connection conn = DBManager.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, recipeId);
			pstmt.setInt(2, recipeId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateReviewCountByRecipeId(int recipeId) {
		String sql = "UPDATE andamirorecipe SET reviewcount = (SELECT COUNT(recipeid) FROM andamiroreview WHERE recipeid = ?) WHERE recipeid = ?";

		try (Connection conn = DBManager.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, recipeId);
			pstmt.setInt(2, recipeId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<RecipeVO> searchRecipe(String recipename) {
    	String sql = "SELECT * FROM andamirorecipe WHERE recipename LIKE ?";
    	List<RecipeVO> list = new ArrayList<RecipeVO>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
      
        try {
            conn = DBManager.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + recipename + "%");
            rs = pstmt.executeQuery();
            System.out.println("성공"+conn);
            System.out.println("rs"+rs);
            System.out.println("list"+list);
            System.out.println("recipename1"+recipename);
            while (rs.next()) {
            	RecipeVO mainSearchVO = new RecipeVO();
                mainSearchVO.setRecipeName(rs.getString("recipename"));
                list.add(mainSearchVO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBManager.close(conn, pstmt, rs);
        }
        return list;
    }
	

}