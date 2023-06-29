package com.andamiro.dao.subscribeMem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.andamiro.dto.subscribeMem.SubscribeMemberVO;
import com.andamiro.utill.DBManager;

public class SubscribeMemberDAO {
	private SubscribeMemberDAO() {}
	private static SubscribeMemberDAO instance = new SubscribeMemberDAO();
	public static SubscribeMemberDAO getInstance() {
		return instance;
	}
	public void insertSubMem(SubscribeMemberVO subVO) {
		String sql = "insert into subscribemember ("
				+ "subNumber, memberNumber, sub_start, sub_end, USERID) "
				+ "VALUES (subNum_seq.nextval,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subVO.getMemberNumber());
			pstmt.setString(2, subVO.getSub_start());
			pstmt.setString(3, subVO.getSub_end());
			pstmt.setString(4,subVO.getUserId());
			pstmt.executeUpdate();
			
			sql = "SELECT subNum_seq.currval FROM dual";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int subnumber = 0;
			if (rs.next()) {
				subnumber = rs.getInt(1);
			}

			
			sql = "update andamiromember set subscribe = ? where membernumber = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subnumber);
			pstmt.setInt(2, subVO.getMemberNumber());
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	public List<SubscribeMemberVO> selectAllmember() {
		String sql = "select * from subscribemember order by subNumber desc";
		List<SubscribeMemberVO> list = new ArrayList<SubscribeMemberVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				SubscribeMemberVO sVO = new SubscribeMemberVO();
				sVO.setSubNumber(rs.getInt("subNumber"));
				sVO.setMemberNumber(rs.getInt("memberNumber"));
				sVO.setUserId(rs.getString("userId"));
				sVO.setSub_start(rs.getString("sub_start"));
				sVO.setSub_end(rs.getString("sub_end"));
				list.add(sVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	public SubscribeMemberVO selectOneBySnum(String subNumber) {
		String sql = "select * from subscribemember where subNumber = ? ";
		SubscribeMemberVO sVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subNumber);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sVO = new SubscribeMemberVO();
				sVO.setSubNumber(rs.getInt("subNumber"));
				sVO.setMemberNumber(rs.getInt("memberNumber"));
				sVO.setUserId(rs.getString("userId"));
				sVO.setSub_start(rs.getString("sub_start"));
				sVO.setSub_end(rs.getString("sub_end"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return sVO;
	}
	
	
	//관리자 페이지에서 구독해지하는 메소드
	public void deleteSubmem(String subNumber) {
		String sql = "delete from subscribemember WHERE subNumber = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, subNumber);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	//구독 기간만료시 구독해지하는 메소드
	public void SubFinish(int subNumber) {
		String sql = "delete from subscribemember where subNumber = ?"; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subNumber);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void saveRecipeForSubmember(int subNumber, int recipeId) {
		// TODO Auto-generated method stub
		String sql = "insert into SUBMEMBERRECIPE VALUES(?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recipeId);
			pstmt.setInt(2, subNumber);
			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	
}

