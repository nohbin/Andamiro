package com.andamiro.dao.subscribeMem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.andamiro.dto.subscribeMem.SubscribeMemberVO;
import com.andamiro.utill.DBManager;

public class SubscribeMemberDAO {
	private SubscribeMemberDAO() {}
	private static SubscribeMemberDAO instance = new SubscribeMemberDAO();
	public static SubscribeMemberDAO getInstance() {
		return instance;
	}
	
	
	public void insertSubMem(SubscribeMemberVO subVO) {
	    String insertSql = "INSERT INTO subscribemember (subNumber, memberNumber, sub_start, sub_end, userId) "
	            + "VALUES (subNum_seq.nextval, ?, ?, ?, ?)";
	    String selectSql = "SELECT subNum_seq.currval FROM dual";
	    String updateSql = "UPDATE andamiromember SET subscribe = ? WHERE membernumber = ?";
	    
	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmtInsert = conn.prepareStatement(insertSql);
	         PreparedStatement pstmtSelect = conn.prepareStatement(selectSql);
	         PreparedStatement pstmtUpdate = conn.prepareStatement(updateSql)) 
	    {
	        pstmtInsert.setInt(1, subVO.getMemberNumber());
	        pstmtInsert.setString(2, subVO.getSub_start());
	        pstmtInsert.setString(3, subVO.getSub_end());
	        pstmtInsert.setString(4, subVO.getUserId());
	        pstmtInsert.executeUpdate();
	        
	        int subnumber = 0;
	        ResultSet rs = pstmtSelect.executeQuery();
	        if (rs.next()) {
	            subnumber = rs.getInt(1);
	        }
	        
	        pstmtUpdate.setInt(1, subnumber);
	        pstmtUpdate.setInt(2, subVO.getMemberNumber());
	        pstmtUpdate.execute();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public List<SubscribeMemberVO> selectAllmember() {
	    String sql = "SELECT * FROM subscribemember ORDER BY subNumber DESC";
	    List<SubscribeMemberVO> list = new ArrayList<>();
	    
	    try (Connection conn = DBManager.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) 
	    {
	        while (rs.next()) {
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
	    }
	    
	    return list;
	}

	
	public SubscribeMemberVO selectOneBySnum(String subNumber) {
	    String sql = "SELECT * FROM subscribemember WHERE subNumber = ?";
	    SubscribeMemberVO sVO = null;
	    
	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        
	        pstmt.setString(1, subNumber);
	        try( ResultSet rs = pstmt.executeQuery();)
	        {
	        	if (rs.next()) {
		            sVO = new SubscribeMemberVO();
		            sVO.setSubNumber(rs.getInt("subNumber"));
		            sVO.setMemberNumber(rs.getInt("memberNumber"));
		            sVO.setUserId(rs.getString("userId"));
		            sVO.setSub_start(rs.getString("sub_start"));
		            sVO.setSub_end(rs.getString("sub_end"));
		        }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return sVO;
	}

	
	//관리자 페이지에서 구독해지하는 메소드
	public void deleteSubmem(String subNumber) {
	    String sql = "DELETE FROM subscribemember WHERE subNumber = ?";
	    
	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setString(1, subNumber);
	        pstmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	
	//구독 기간만료시 구독해지하는 메소드
	public void SubFinish(int subNumber) {
	    String sql = "DELETE FROM subscribemember WHERE subNumber = ?";
	    
	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setInt(1, subNumber);
	        pstmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	public void saveRecipeForSubmember(int subNumber, int recipeId) {
	    String sql = "INSERT INTO SUBMEMBERRECIPE (recipeId, subNumber) VALUES (?, ?)";

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) 
	    {
	        pstmt.setInt(1, recipeId);
	        pstmt.setInt(2, subNumber);
	        pstmt.execute();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	
	public List<SubscribeMemberVO> selectMemberByPage(int start, int end) {
	    List<SubscribeMemberVO> memberList = new ArrayList<>();

	    String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY subNumber) NUM, A.* FROM subscribemember A ORDER BY subNumber) "
	            + "WHERE NUM BETWEEN ? AND ?";

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) 
	    {
	        pstmt.setInt(1, start);
	        pstmt.setInt(2, end);
	        try (ResultSet rs = pstmt.executeQuery()) 
	        {
	            while (rs.next()) {
	                SubscribeMemberVO subscribeMemberVO = new SubscribeMemberVO();
	                subscribeMemberVO.setSubNumber(rs.getInt("subNumber"));
	                subscribeMemberVO.setMemberNumber(rs.getInt("memberNumber"));
	                subscribeMemberVO.setUserId(rs.getString("userId"));
	                subscribeMemberVO.setSub_start(rs.getString("sub_start"));
	                subscribeMemberVO.setSub_end(rs.getString("sub_end"));

	                memberList.add(subscribeMemberVO);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return memberList;
	}

	
}

