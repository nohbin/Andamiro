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

	public static MemberDAO getInstance() {
		if (instance == null) {
			instance = new MemberDAO();
		}
		return instance;
	}

	public int insertMember(MemberVO mem) {
		int result = 0;
		String sql = "INSERT INTO andamiromember (memberNumber , id, pwd, name, phone, email, joinDate) VALUES (member_seq.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getPwd());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getPhone());
			pstmt.setString(5, mem.getEmail());
			pstmt.setString(6, mem.getJoinDate());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public int userCheck(String userid, String pwd) {
		// TODO Auto-generated method stub
		return 0;
	}

	public MemberVO selectOneMemberbyID(String userid) {
		// TODO Auto-generated method stub
		String sql = "select * from andamiromember where id = ?";
		MemberVO memberVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return memberVO;
	}

	public int MemberIdCheckById(String id) {
		String sql = "select * from andamiromember where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int idCheckResult = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			idCheckResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return idCheckResult;
	}

	public void updateMemberInfoByMemberNumber(int memberNumber, MemberVO memberVO) {
		// TODO Auto-generated method stub
		String sql = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			if (memberVO.getId() != null) {
				sql = "UPDATE andamiromember SET ID = ?, PWD = ?, PHONE = ? WHERE MEMBERNUMBER = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberVO.getId());
				pstmt.setString(2, memberVO.getPwd());
				pstmt.setString(3, memberVO.getPhone());
				pstmt.setInt(4, memberNumber);
				pstmt.execute();
			} else {
				sql = "UPDATE andamiromember SET PWD = ?, PHONE = ? WHERE MEMBERNUMBER = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberVO.getPwd());
				pstmt.setString(2, memberVO.getPhone());
				pstmt.setInt(3, memberNumber);
				pstmt.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		System.out.println("업데이트문 종료");
	}

	public List<MemberVO> selectAllMember() {
		// TODO Auto-generated method stub
		List<MemberVO> lists = new ArrayList<>();
		MemberVO memberVO = null;
		String sql = "select * from andamiromember order by memberNumber";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemberNumber(rs.getInt("memberNumber"));
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setJoinDate(rs.getString("joindate"));
				memberVO.setSubscribe(rs.getString("subscribe"));
				lists.add(memberVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return lists;
	}

	public List<MemberVO> selectAllMemberFirstPage() {
		// TODO Auto-generated method stub
		List<MemberVO> lists = new ArrayList<>();
		MemberVO memberVO = null;
		String sql = "SELECT *FROM (SELECT ROW_NUMBER() OVER (ORDER BY memberNumber) NUM , A.* FROM andamiromember A ORDER BY memberNumber) "
				+ "WHERE NUM BETWEEN 1 AND 5";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemberNumber(rs.getInt("memberNumber"));
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setJoinDate(rs.getString("joindate"));
				memberVO.setSubscribe(rs.getString("subscribe"));
				lists.add(memberVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return lists;
	}

	public List<MemberVO> selectMemberByPage(int start, int end) {
		// TODO Auto-generated method stub
		List<MemberVO> lists = new ArrayList<>();
		MemberVO memberVO = null;
		String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY memberNumber) NUM , A.* FROM andamiromember A ORDER BY memberNumber) "
				+ "WHERE NUM BETWEEN ? AND ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemberNumber(rs.getInt("memberNumber"));
				memberVO.setId(rs.getString("id"));
				memberVO.setPwd(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setPhone(rs.getString("phone"));
				memberVO.setEmail(rs.getString("email"));
				memberVO.setJoinDate(rs.getString("joindate"));
				memberVO.setSubscribe(rs.getString("subscribe"));
				lists.add(memberVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return lists;
	}
}
