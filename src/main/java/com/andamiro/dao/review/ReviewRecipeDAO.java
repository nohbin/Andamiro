package com.andamiro.dao.review;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.andamiro.dto.review.ReviewRecipeVO;
import com.andamiro.utill.DBManager;

public class ReviewRecipeDAO {
	public ReviewRecipeDAO() {}
	private static ReviewRecipeDAO instance = new ReviewRecipeDAO();
	
	public static ReviewRecipeDAO getInstance() {
		return instance;
	}
	
	public ArrayList<ReviewRecipeVO> listBestRecipe(){
		ArrayList<ReviewRecipeVO> recipeList = new ArrayList<ReviewRecipeVO>();
		String sql = "SELECT mainpicture, recipename, userid, recipeRegDate, recipeview FROM (SELECT * FROM andamirorecipe ORDER BY recipeview DESC) WHERE ROWNUM <= 8";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewRecipeVO recipe = new ReviewRecipeVO();
				recipe.setMainPicture(rs.getString("mainpicture"));
				recipe.setRecipeName(rs.getString("recipename"));
				recipe.setUserId(rs.getString("userid"));
				recipe.setRecipeRegDate(rs.getTimestamp("recipeRegDate"));
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