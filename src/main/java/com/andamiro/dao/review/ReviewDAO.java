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
		String sql = "select * from andamiroreview order by recipeid desc";
		List<ReviewVO> list = new ArrayList<ReviewVO>();

		try (Connection conn = DBManager.getConnection(); 
				Statement stmt = conn.createStatement();)

		{
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					ReviewVO rVo = new ReviewVO();
					rVo.setReviewNum(rs.getInt("reviewnum"));
					rVo.setRecipeId(rs.getInt("recipeid"));
					rVo.setImg(rs.getString("reviewpicture"));
					rVo.setRecipeName(rs.getString("recipename"));
					rVo.setReview(rs.getString("review"));
					rVo.setRecipegrade(rs.getInt("recipegrade"));
					rVo.setRegdate(rs.getTimestamp("regdate"));
					list.add(rVo);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void deleteMyreview(String recipeid) {
		String sql = "delete andamiroreview where reviewnum=?";

		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, recipeid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ReviewVO selectOneBoradByNum(String recipeid) {
		String sql = "select * from andamiroreview where recipeid=?";
		ReviewVO rVo = null;

		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, recipeid);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					rVo = new ReviewVO();
					rVo.setReviewNum(rs.getInt("reviewnum"));
					rVo.setRecipeId(rs.getInt("recipeID"));
					rVo.setRecipeName(rs.getString("recipename"));
					rVo.setReview(rs.getString("review"));
					rVo.setRecipegrade(rs.getInt("recipegrade"));
					rVo.setRegdate(rs.getTimestamp("regdate"));
					rVo.setImg(rs.getString("reviewpicture"));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rVo;

	}

	public void updateReview(ReviewVO rVo) {
		String sql = "update andamiroreview set  review=?, recipegrade=?, regDate=?, reviewpicture=? where recipeid=?";

		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, rVo.getReview());
			pstmt.setInt(2, rVo.getRecipegrade());
			pstmt.setTimestamp(3, rVo.getRegdate());
			pstmt.setString(4, rVo.getImg());
			pstmt.setInt(5, rVo.getRecipeId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertReview(String memberId, int recipeId, ReviewVO reviewVO, String recipename) {
		// TODO Auto-generated method stub
		String sql = "insert into andamiroreview (REVIEWNUM, RECIPEID ,ID,  RECIPENAME, REVIEWPICTURE, REVIEW, RECIPEGRADE ) values "
				+ "(reviewnum_seq.nextval , ? ,? , ? , ? , ? , ?)";

		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, recipeId);
			pstmt.setString(2, memberId);
			pstmt.setString(3, recipename);
			pstmt.setString(4, reviewVO.getImg());
			pstmt.setString(5, reviewVO.getReview());
			pstmt.setInt(6, reviewVO.getRecipegrade());
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public List<ReviewVO> selectAllReviewsByRecipeID(int recipeID) {
		// TODO Auto-generated method stub
		String sql = "select * from andamiroreview where recipeid = ?";
		ReviewVO reviewVO = null;
		List<ReviewVO> list = new ArrayList<>();
		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, recipeID);
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					reviewVO = new ReviewVO();
					reviewVO.setReviewNum(rs.getInt("reviewnum"));
					reviewVO.setRecipeId(rs.getInt("recipeid"));
					reviewVO.setUserId(rs.getString("id"));
					reviewVO.setImg(rs.getString("reviewpicture"));
					reviewVO.setRegdate(rs.getTimestamp("regdate"));
					reviewVO.setReview(rs.getString("review"));
					reviewVO.setRecipegrade(rs.getInt("recipegrade"));
					list.add(reviewVO);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<ReviewVO> selectAllReviewsByMemberId(String memberId) {
		String sql = "select * from andamiroreview where id = ? order by recipeid desc";
		List<ReviewVO> list = new ArrayList<ReviewVO>();

		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, memberId);
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					ReviewVO rVo = new ReviewVO();
					rVo.setReviewNum(rs.getInt("reviewnum"));
					rVo.setRecipeId(rs.getInt("recipeid"));
					rVo.setImg(rs.getString("reviewpicture"));
					rVo.setRecipeName(rs.getString("recipename"));
					rVo.setReview(rs.getString("review"));
					rVo.setRecipegrade(rs.getInt("recipegrade"));
					rVo.setRegdate(rs.getTimestamp("regdate"));
					list.add(rVo);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public void updateReviewByReviewNum(ReviewVO rVo, int reviewNum) {
		String sql = "update andamiroreview set  review=?, recipegrade=?, regDate=?, reviewpicture=? where reviewnum=?";

		try (Connection conn = DBManager.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql);) 
		{
			pstmt.setString(1, rVo.getReview());
			pstmt.setInt(2, rVo.getRecipegrade());
			pstmt.setTimestamp(3, rVo.getRegdate());
			pstmt.setString(4, rVo.getImg());
			pstmt.setInt(5, rVo.getReviewNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
