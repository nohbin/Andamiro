package com.andamiro.dao.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.andamiro.dto.recipe.RecipeVO;
import com.andamiro.utill.DBManager;

public class MainDAO {
	public MainDAO() {}
	private static MainDAO instance = new MainDAO();
	public static MainDAO getInstance() {
		return instance;
	}
	
	public static ArrayList<RecipeVO> bestListRecipe(){
		ArrayList<RecipeVO> rVoList = new ArrayList<RecipeVO>();
		String sql = "SELECT mainpicture, recipename, userid, recipeCompetition, recipeview FROM (SELECT * FROM recipe ORDER BY recipeview DESC) WHERE ROWNUM <= 8";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RecipeVO rVo = new RecipeVO();
				rVo.setMainPicture(rs.getString("mainpicture"));
				rVo.setRecipeName(rs.getString("recipename"));
				rVo.setUserId(rs.getString("userid"));
				rVo.setRecipeGrade(rs.getString("recipegrade"));
				rVo.setRecipeView(rs.getInt("recipeview"));
				rVo.setRecipeRegDate(rs.getTimestamp("reciperegdate"));
				rVoList.add(rVo);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
			
		return rVoList;
	}
	
}
