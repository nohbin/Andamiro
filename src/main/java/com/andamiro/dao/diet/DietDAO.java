package com.andamiro.dao.diet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.andamiro.dto.diet.DietVO;
import com.andamiro.utill.DBManager;

public class DietDAO {
	private DietDAO() {}
	private static DietDAO instance = new DietDAO();
	public static DietDAO getInstance() {
		return instance;
	}
	
	public List<DietVO> selectAllboards() {
		String sql = "select * from diet order by dietNumber desc ";
		List<DietVO> list = new ArrayList<DietVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				DietVO dVo = new DietVO();
				dVo.setDietNumber(rs.getInt("dietNumber"));
				dVo.setDiet_kind(rs.getString("diet_kind"));
				dVo.setDiet_menu(rs.getString("diet_menu"));
				dVo.setDiet_picture(rs.getString("diet_picture"));
				list.add(dVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}

	public void insertDiet(DietVO dVo) {
		String sql = "insert into  diet ("
				+ "dietNumber, diet_kind, diet_menu, diet_picture) "
				+ "values (dietNum_seq.NEXTVAL, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dVo.getDiet_kind());
			pstmt.setString(2, dVo.getDiet_menu());
			pstmt.setString(3, dVo.getDiet_picture());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
				
				
				
	}

	public DietVO selectOneDietByDnum(String dietNumber) {
		String sql = "select * from diet where dietNumber = ?";
		DietVO dVo = null; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dietNumber);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dVo = new DietVO();
				dVo.setDietNumber(rs.getInt("dietNumber"));
				dVo.setDiet_kind(rs.getString("diet_kind"));
				dVo.setDiet_menu(rs.getString("diet_menu"));
				dVo.setDiet_picture(rs.getString("diet_picture"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return dVo;
	}

	public void deleteDiet(String dietNumber) {
		String sql = "delete from diet where dietNumber = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dietNumber);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
				
				
	}

	public void updateDiet(DietVO dVo) {
		String sql = "update diet set diet_kind=?, diet_menu=?, diet_picture=? "
				+ " where dietNumber = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dVo.getDiet_kind());
			pstmt.setString(2, dVo.getDiet_menu());
			pstmt.setString(3, dVo.getDiet_picture());
			pstmt.setInt(4, dVo.getDietNumber());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	
	
	
	
}
