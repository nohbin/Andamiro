package com.andamiro.dao.review;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.andamiro.dto.review.ReviewVO;
import com.andamiro.utill.DBManager;

public class ReviewDAO {
	private ReviewDAO() {	}
	private static ReviewDAO instance = new ReviewDAO();
	
	public static ReviewDAO getInstance() {
		return instance;
		
	}
	public List<ReviewVO> selectAllReviews(){
		String sql = "select * from review order by num desc";
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			System.out.println("성공");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ReviewVO rVo = new ReviewVO();
				rVo.setNum(rs.getInt("num"));
				rVo.setImg(rs.getString("img"));
				rVo.setTitle(rs.getString("title"));
				rVo.setReview(rs.getString("review"));
				rVo.setRecipegrade(rs.getInt("recipegrade"));
				rVo.setJoindate(rs.getTimestamp("joindate"));
				list.add(rVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		System.out.println(list);
		return list;
	} 
	public void deleteMyreview(String num) {
		String sql = "delete review where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	}
	public  ReviewVO selectOneBoradByNum(String num) {
		String sql = "select * from review where num=?";
		ReviewVO rVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();		
			
			if(rs.next()) {
				rVo = new ReviewVO();
				
				rVo.setNum(rs.getInt("num"));
				rVo.setTitle(rs.getString("title"));
				rVo.setReview(rs.getString("review"));
				rVo.setRecipegrade(rs.getInt("recipegrade"));
				rVo.setJoindate(rs.getTimestamp("joindate"));
				rVo.setImg(rs.getString("img"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rVo;
		
	}
//	public void updateReadCount(String num) {
//		String sql = "update review set readcount=readcount+1 where num=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			conn = DBManager.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, num);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			DBManager.close(conn, pstmt);
//		}
//		
//	}
	public void updateReview(ReviewVO rVo) {
	    String sql = "update review set num=?, title=?, review=?, recipegrade=?, joinDate=?, img=? where num=?";
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    try {
	        conn = DBManager.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        
	        pstmt.setInt(1, rVo.getNum());
	        pstmt.setString(2, rVo.getTitle());
	        pstmt.setString(3, rVo.getReview());
	        pstmt.setInt(4, rVo.getRecipegrade());
	        pstmt.setTimestamp(5, rVo.getJoindate());
	        pstmt.setString(6, rVo.getImg());
	        pstmt.setInt(7, rVo.getNum()); // WHERE 절의 매개변수 설정
	        pstmt.executeUpdate();
	        
	    } catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    
	}

	
}
