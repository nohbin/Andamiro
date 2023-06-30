package com.andamiro.dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.andamiro.utill.DBManager;

public class BoardDAO {
	private BoardDAO() {
	}

	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}

	public int getTotalRowsMember() {
		int count = 0;

		String sql = "select count(memberNumber) from andamiromember";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int index = 0;

			if (rs.next()) {
				count = rs.getInt(++index);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}

	public int getTotalRowsRecipe() {
		int count = 0;

		String sql = "select count(recipeid) from andamirorecipe";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			int index = 0;

			if (rs.next()) {
				count = rs.getInt(++index);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}

}
