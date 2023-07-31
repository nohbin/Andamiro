package com.andamiro.dao.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.andamiro.dto.member.MemberVO;
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
		List<ReviewVO> list = new ArrayList<ReviewVO>();
		try (Connection conn = DBManager.getConnection(); 
			 Statement stmt = conn.createStatement();)
		{
			try (ResultSet rs = stmt.executeQuery("select * from andamiroreview order by recipeid desc");) {
				while (rs.next()) {
					ReviewVO rVo = new ReviewVO();
					rVo.setReviewNum(rs.getInt("reviewnum"));
					rVo.setRecipeId(rs.getInt("recipeid"));
					rVo.setMemberNumber(rs.getInt("membernumber"));
					rVo.setReviewPicture(rs.getString("reviewpicture"));
					rVo.setRecipeName(rs.getString("recipename"));
					rVo.setReview(rs.getString("review"));
					rVo.setRecipegrade(rs.getInt("recipegrade"));
					rVo.setRegdate(rs.getTimestamp("regdate"));
					try(ResultSet rs2 = stmt.executeQuery("select * from andamiromember where memberNumber = "+ "'"+rVo.getMemberNumber()+"'");)
					{
						 if (rs.next()) {
				                MemberVO memberVO = new MemberVO();
				                memberVO.setMemberNumber(rs.getInt("memberNumber"));
				                memberVO.setId(rs.getString("id"));
				                memberVO.setPwd(rs.getString("pwd"));
				                memberVO.setName(rs.getString("name"));
				                memberVO.setPhone(rs.getString("phone"));
				                memberVO.setEmail(rs.getString("email"));
				                memberVO.setJoinDate(rs.getString("joindate"));
				                memberVO.setSubscribe(rs.getString("subscribe"));
				                memberVO.setAdminCode(rs.getString("adminCode"));
				                rVo.setMemberVO(memberVO);
				            }
					}
					list.add(rVo);
					System.out.println(rVo);
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
					rVo.setReviewPicture(rs.getString("reviewpicture"));
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rVo;

	}

	public void updateReview(ReviewVO rVo) {
		String sql = "update andamiroreview set  review=?, recipegrade=?, joinDate=?, reviewpicture=? where recipeid=?";

		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, rVo.getReview());
			pstmt.setInt(2, rVo.getRecipegrade());
			pstmt.setTimestamp(3, rVo.getRegdate());
			pstmt.setString(4, rVo.getReviewPicture());
			pstmt.setInt(5, rVo.getRecipeId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertReview(ReviewVO reviewVO) {
		// TODO Auto-generated method stub
		String sql = "insert into andamiroreview (REVIEWNUM, RECIPENAME, memberNumber , RECIPEID,   REVIEWPICTURE, REVIEW, RECIPEGRADE ) values "
				+ "(reviewnum_seq.nextval , ? ,? , ? , ? , ? , ?)";

		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, reviewVO.getRecipeName());
			pstmt.setInt(2, reviewVO.getMemberNumber());
			pstmt.setInt(3, reviewVO.getRecipeId());
			pstmt.setString(4, reviewVO.getReviewPicture());
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
		try (Connection conn = DBManager.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, recipeID);
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					reviewVO = new ReviewVO();
					reviewVO.setReviewNum(rs.getInt("reviewnum"));
					reviewVO.setRecipeId(rs.getInt("recipeid"));
					reviewVO.setMemberNumber(rs.getInt("membernumber"));
					reviewVO.setReviewPicture(rs.getString("reviewpicture"));
					reviewVO.setRegdate(rs.getTimestamp("joindate"));
					reviewVO.setReview(rs.getString("review"));
					reviewVO.setRecipegrade(rs.getInt("recipegrade"));
					try(PreparedStatement pstmt1 = conn.prepareStatement("select * from andamiromember where memberNumber = ?");)
					{	
						pstmt1.setInt(1, reviewVO.getMemberNumber());
						try(ResultSet rs2 = pstmt1.executeQuery()){
							 if (rs2.next()) {
								MemberVO memberVO = new MemberVO();
				                memberVO.setMemberNumber(rs2.getInt("memberNumber"));
				                memberVO.setId(rs2.getString("id"));
				                memberVO.setName(rs2.getString("name"));
				                memberVO.setPhone(rs2.getString("phone"));
				                memberVO.setEmail(rs2.getString("email"));
				                memberVO.setJoinDate(rs2.getString("joindate"));
				                memberVO.setSubscribe(rs2.getString("subscribe"));
				                memberVO.setAdminCode(rs2.getString("adminCode"));
				                reviewVO.setMemberVO(memberVO);
				            }
						}
					}
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
		String sql = "select * from andamiroreview where memberNumber = ? order by recipeid desc";
		List<ReviewVO> list = new ArrayList<ReviewVO>();

		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, memberId);
			try (ResultSet rs = pstmt.executeQuery();) {
				while (rs.next()) {
					ReviewVO rVo = new ReviewVO();
					rVo.setReviewNum(rs.getInt("reviewnum"));
					rVo.setRecipeId(rs.getInt("recipeid"));
					rVo.setReviewPicture(rs.getString("reviewpicture"));
					rVo.setRecipeName(rs.getString("recipename"));
					rVo.setReview(rs.getString("review"));
					rVo.setRecipegrade(rs.getInt("recipegrade"));
					rVo.setRegdate(rs.getTimestamp("joindate"));
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
		String sql = "update andamiroreview set  review=?, recipegrade=?, joinDate=?, reviewpicture=? where reviewnum=?";

		try (Connection conn = DBManager.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql);) 
		{
			pstmt.setString(1, rVo.getReview());
			pstmt.setInt(2, rVo.getRecipegrade());
			pstmt.setTimestamp(3, rVo.getRegdate());
			pstmt.setString(4, rVo.getReviewPicture());
			pstmt.setInt(5, rVo.getReviewNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ReviewVO selectOneReviewByReviewNum(int reviewNum) {
		// TODO Auto-generated method stub
		String sql = "select * from andamiroreview where reviewnum = ?";
		ReviewVO reviewVO = null;
		try(Connection conn = DBManager.getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql);) 
		{
			pstmt.setInt(1, reviewNum);
			try(ResultSet rs = pstmt.executeQuery();)
			{
				if(rs.next()) {
					reviewVO = new ReviewVO();
					reviewVO.setReviewNum(rs.getInt("reviewnum"));
					reviewVO.setRecipeId(rs.getInt("recipeid"));
					reviewVO.setMemberNumber(rs.getInt("membernumber"));
					reviewVO.setReviewPicture(rs.getString("reviewPicture"));
					reviewVO.setReview(rs.getString("review"));
					reviewVO.setRecipegrade(rs.getInt("recipegrade"));
					reviewVO.setRegdate(rs.getTimestamp("joindate"));
					reviewVO.setRecipeName(rs.getString("recipename"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reviewVO;
	}

}
