package com.andamiro.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.andamiro.dto.member.MemberVO;
import com.andamiro.utill.DBManager;

public class MemberDAO {
	private static MemberDAO instance;
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	public int insertMember(MemberVO mem) {
	    int result = 0;
	    String sql = "INSERT INTO andamiromember (memberNumber, id, pwd, name, phone, email, joinDate) VALUES (member_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) 
	    {
	        pstmt.setString(1, mem.getId());
	        pstmt.setString(2, mem.getPwd());
	        pstmt.setString(3, mem.getName());
	        pstmt.setString(4, mem.getPhone());
	        pstmt.setString(5, mem.getEmail());
	        pstmt.setString(6, mem.getJoinDate());
	        result = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	public MemberVO selectOneMemberbyID(String userid) {
	    String sql = "SELECT * FROM andamiromember WHERE id = ?";
	    MemberVO memberVO = null;

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) 
	    {
	        pstmt.setString(1, userid);
	        try (ResultSet rs = pstmt.executeQuery()) 
	        {
	            if (rs.next()) {
	                memberVO = new MemberVO();
	                memberVO.setMemberNumber(rs.getInt("memberNumber"));
	                memberVO.setId(rs.getString("id"));
	                memberVO.setPwd(rs.getString("pwd"));
	                memberVO.setName(rs.getString("name"));
	                memberVO.setPhone(rs.getString("phone"));
	                memberVO.setEmail(rs.getString("email"));
	                memberVO.setJoinDate(rs.getString("joindate"));
	                memberVO.setSubscribe(rs.getString("subscribe"));
	                memberVO.setAdminCode(rs.getString("adminCode"));
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return memberVO;
	}


	public int MemberIdCheckById(String id) {
	    String sql = "SELECT COUNT(*) FROM andamiromember WHERE id = ?";
	    int idCheckResult = 0;

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) 
	    {
	        pstmt.setString(1, id);
	        try (ResultSet rs = pstmt.executeQuery()) 
	        {
	            if (rs.next()) {
	                idCheckResult = rs.getInt(1);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return idCheckResult;
	}


	public void updateMemberInfoByMemberNumber(int memberNumber, MemberVO memberVO) {
	    String sql = null;

	    if (memberVO.getId() != null) {
	        sql = "UPDATE andamiromember SET ID = ?, PWD = ?, PHONE = ? WHERE MEMBERNUMBER = ?";
	    } else {
	        sql = "UPDATE andamiromember SET PWD = ?, PHONE = ? WHERE MEMBERNUMBER = ?";
	    }

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        if (memberVO.getId() != null) {
	            pstmt.setString(1, memberVO.getId());
	            pstmt.setString(2, memberVO.getPwd());
	            pstmt.setString(3, memberVO.getPhone());
	            pstmt.setInt(4, memberNumber);
	        } else {
	            pstmt.setString(1, memberVO.getPwd());
	            pstmt.setString(2, memberVO.getPhone());
	            pstmt.setInt(3, memberNumber);
	        }	

	        pstmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	public List<MemberVO> selectAllMember() {
	    List<MemberVO> memberList = new ArrayList<>();

	    String sql = "select /*+ index_asc(andamiromember membernumber) */ * from andamiromember where membernumber > 0";

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) 
	    {
	        while (rs.next()) {
	            MemberVO memberVO = new MemberVO();
	            memberVO.setMemberNumber(rs.getInt("memberNumber"));
	            memberVO.setId(rs.getString("id"));
	            memberVO.setPwd(rs.getString("pwd"));
	            memberVO.setName(rs.getString("name"));
	            memberVO.setPhone(rs.getString("phone"));
	            memberVO.setEmail(rs.getString("email"));
	            memberVO.setJoinDate(rs.getString("joindate"));
	            memberVO.setSubscribe(rs.getString("subscribe"));
	            memberList.add(memberVO);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return memberList;
	}


	public List<MemberVO> selectAllMemberFirstPage() {
	    List<MemberVO> memberList = new ArrayList<>();

	    String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY memberNumber) NUM, A.* FROM andamiromember A ORDER BY memberNumber) "
	            + "WHERE NUM BETWEEN 1 AND 5";

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) 
	    {
	        while (rs.next()) {
	            MemberVO memberVO = new MemberVO();
	            memberVO.setMemberNumber(rs.getInt("memberNumber"));
	            memberVO.setId(rs.getString("id"));
	            memberVO.setPwd(rs.getString("pwd"));
	            memberVO.setName(rs.getString("name"));
	            memberVO.setPhone(rs.getString("phone"));
	            memberVO.setEmail(rs.getString("email"));
	            memberVO.setJoinDate(rs.getString("joindate"));
	            memberVO.setSubscribe(rs.getString("subscribe"));
	            
	            memberList.add(memberVO);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return memberList;
	}


	public List<MemberVO> selectMemberByPage(int start, int end) {
	    List<MemberVO> memberList = new ArrayList<>();

	    String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY memberNumber) NUM, A.* FROM andamiromember A ORDER BY memberNumber) "
	            + "WHERE NUM BETWEEN ? AND ?";

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) {

	        pstmt.setInt(1, start);
	        pstmt.setInt(2, end);

	        try (ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                MemberVO memberVO = new MemberVO();
	                memberVO.setMemberNumber(rs.getInt("memberNumber"));
	                memberVO.setId(rs.getString("id"));
	                memberVO.setPwd(rs.getString("pwd"));
	                memberVO.setName(rs.getString("name"));
	                memberVO.setPhone(rs.getString("phone"));
	                memberVO.setEmail(rs.getString("email"));
	                memberVO.setJoinDate(rs.getString("joindate"));
	                memberVO.setSubscribe(rs.getString("subscribe"));

	                memberList.add(memberVO);
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return memberList;
	}

}
