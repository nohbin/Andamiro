package com.andamiro.dao.review;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.andamiro.dto.recipe.RecipeVO;
import com.andamiro.utill.DBManager;

public class ReviewRecipeDAO {
	public ReviewRecipeDAO() {}
	private static ReviewRecipeDAO instance = new ReviewRecipeDAO();
	
	public static ReviewRecipeDAO getInstance() {
		return instance;
	}
	
	public static ArrayList<RecipeVO> listBestRecipe(){
		ArrayList<RecipeVO> recipeList = new ArrayList<RecipeVO>();
		String sql = "select recipeGrade from (select recipeGrade from recipe order by recipeGrade desc) where rownum<=8";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				RecipeVO recipe = new RecipeVO();
				recipe.setMainPicture(rs.getString("mainpicture"));
				recipe.setRecipeName(rs.getString("recipename"));
				recipe.setMemberNumber(rs.getInt("membernum"));
				recipe.setRecipeCompetition(rs.getInt("recipeCompetition"));
				recipe.setRecipeView(rs.getInt("recipeview"));
				recipeList.add(recipe);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
						
		return recipeList;
	
	}
}
