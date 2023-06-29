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
	private ReviewDAO() {
	}

	private static ReviewDAO instance = new ReviewDAO();

	public static ReviewDAO getInstance() {
		return instance;

	}

	public List<ReviewVO> selectAllReviews() {
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
			while (rs.next()) {
				ReviewVO rVo = new ReviewVO();

				rVo.setRecipeId(rs.getInt("recipeid"));
				rVo.setImg(rs.getString("reviewpicture"));
				rVo.setUserId(rs.getString("id"));
				rVo.setReview(rs.getString("review"));
				rVo.setRecipegrade(rs.getInt("recipegrade"));
				rVo.setRegdate(rs.getTimestamp("regdate"));
				list.add(rVo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}
	
	public List<ReviewVO> selectAllReviewsByRecipeID(int recipID) {
		// TODO Auto-generated method stub
		String sql = "select * from andamiroreview where recipeid = ?";
		ReviewVO reviewVO = null;
		List<ReviewVO> list = new ArrayList<>();
		try {
			Connection conn = DBManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipID);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				reviewVO = new ReviewVO();
				reviewVO.setRecipeId(rs.getInt("recipeid"));
				reviewVO.setUserId(rs.getString("id"));
				reviewVO.setImg(rs.getString("reviewpicture"));
				reviewVO.setRegdate(rs.getTimestamp("regdate"));
				reviewVO.setReview(rs.getString("review"));
				reviewVO.setRecipegrade(rs.getInt("recipegrade"));
				list.add(reviewVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void deleteMyreview(String num) {
		String sql = "delete review where recipeid=?";
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
		} finally {

		}
	}

	public ReviewVO selectOneBoradByNum(String num) {
		String sql = "select * from review where num=?";
		ReviewVO rVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				rVo = new ReviewVO();

				rVo.setRecipeId(rs.getInt("recipeid"));
				rVo.setUserId(rs.getString("id"));
				rVo.setReview(rs.getString("review"));
				rVo.setRecipegrade(rs.getInt("recipegrade"));
				rVo.setRegdate(rs.getTimestamp("regdate"));
				rVo.setImg(rs.getString("reviewpicture"));
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
		String sql = "update review set recipeid=?, id=?, review=?, recipegrade=?, joinDate=?, img=? where= num? ";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rVo.getRecipeId());
			pstmt.setString(2, rVo.getUserId());
			pstmt.setString(3, rVo.getReview());
			pstmt.setInt(4, rVo.getRecipegrade());
			pstmt.setTimestamp(5, rVo.getRegdate());
			pstmt.setString(6, rVo.getImg());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertReview(String memberId, int recipeId, ReviewVO reviewVO) {
		// TODO Auto-generated method stub
		String sql = "insert into andamiroreview (reviewnum, recipeid , id, reviewpicture, review, recipegrade ) values "
				+ "(reviewnum_seq.nextval , ? , ? , ? , ? , ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipeId);
			pstmt.setString(2, memberId);
			pstmt.setString(3, reviewVO.getImg());
			pstmt.setString(4, reviewVO.getReview());
			pstmt.setInt(5, reviewVO.getRecipegrade());
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}

	

}
