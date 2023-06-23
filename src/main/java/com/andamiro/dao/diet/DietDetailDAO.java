package com.andamiro.dao.diet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.andamiro.dto.diet.dietDetailVO;
import com.andamiro.utill.DBManager;

public class DietDetailDAO {
	private DietDetailDAO() {}
	private static DietDetailDAO instance = new DietDetailDAO();
	public static DietDetailDAO getInstance() {
		return instance;
	}
	
	public List<dietDetailVO> selectAllboards() {
		String sql = "select * from dietDetail order by dietDetailID desc ";
		List<dietDetailVO> list = new ArrayList<dietDetailVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO ddVo = new dietDetailVO();
				ddVo.setDietDetailID(rs.getInt("dietDetailID"));
				ddVo.setDietNumber(rs.getInt("dietNumber"));
				ddVo.setFoodName(rs.getString("foodName"));
				ddVo.setKcal(rs.getString("kcal"));
				ddVo.setComponent(rs.getString("component"));
				list.add(ddVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}

	public void insertDetail(dietDetailVO ddVo) {
		String sql = "insert into dietDetail ("
				+ "dietDetailID,dietNumber, foodName, kcal, component) "
				+ "values (dietDetailID_seq.nextval, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ddVo.getDietNumber());
			pstmt.setString(2, ddVo.getFoodName());
			pstmt.setString(3, ddVo.getKcal());
			pstmt.setString(4, ddVo.getComponent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		
				
	}

	public dietDetailVO selectOneDetailById(String dietDetailID) {
		String sql = "select * from dietDetail where dietDetailID = ?";
		dietDetailVO ddVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dietDetailID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ddVo = new dietDetailVO();
				ddVo.setDietDetailID(rs.getInt("dietDetailID"));
				ddVo.setFoodName(rs.getString("foodName"));
				ddVo.setKcal(rs.getString("kcal"));
				ddVo.setComponent(rs.getString("component"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);			
		}
		return ddVo;
	}

	public void deleteDetail(String dietDetailID) {
		String sql = "delete dietDetail where dietDetailID = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn =DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dietDetailID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);			
		}
		
	}

	public void updateDetail(dietDetailVO ddVo) {
		String sql = "update dietDetail set  foodName=?, kcal=?, component=? "
				+ " where dietDetailID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ddVo.getFoodName());
			pstmt.setString(2, ddVo.getKcal());
			pstmt.setString(3, ddVo.getComponent());
			pstmt.setInt(4, ddVo.getDietDetailID());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

//	public dietDetailVO selectOneDietByDnum(String dietNumber) {
//		String sql = "select * from dietDetail where dietNumber = ?";
//		dietDetailVO ddVo = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, dietNumber);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				ddVo = new dietDetailVO();
//				ddVo.setDietNumber(rs.getInt("dietNumber"));
//				ddVo.setDietDetailID(rs.getInt("dietDetailID"));
//				ddVo.setFoodName(rs.getString("foodName"));
//				ddVo.setKcal(rs.getString("kcal"));
//				ddVo.setComponent(rs.getString("component"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, pstmt, rs);
//		}
//		return ddVo;
//	}
}
