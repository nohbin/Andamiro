package com.andamiro.dao.subscribeMem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, subVO.getMemberNumber());
			pstmt.setString(2, subVO.getSub_start());
			pstmt.setString(3, subVO.getSub_end());
			pstmt.setString(4,subVO.getUserId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		
	}






}

