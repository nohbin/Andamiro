package com.andamiro.dao.diet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.andamiro.dto.diet.DietVO;
import com.andamiro.dto.diet.dietDetailVO;
import com.andamiro.utill.DBManager;

public class DietDAO {
	private DietDAO() {}
	private static DietDAO instance = new DietDAO();
	public static DietDAO getInstance() {
		return instance;
	}
	
//	public List<DietVO> selectAllboards() {
//	    String sql = "select * from diet order by dietNumber desc ";
//	    List<DietVO> list = new ArrayList<DietVO>();
//
//	    try (Connection conn = DBManager.getConnection();
//	         Statement stmt = conn.createStatement();
//	         ResultSet rs = stmt.executeQuery(sql)) 
//	    {
//	        while (rs.next()) {
//	            DietVO dietVo = new DietVO();
//	            dietVo.setDietNumber(rs.getInt("dietNumber"));
//	            dietVo.setDiet_kind(rs.getString("diet_kind"));
//	            dietVo.setDiet_menu(rs.getString("diet_menu"));
//	            dietVo.setDiet_picture(rs.getString("diet_picture"));
//	            list.add(dietVo);
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//
//	    return list;
//	}

	public void insertDiet(DietVO dietVo) {
	    String sql = "insert into  diet (dietNumber, diet_kind, diet_menu, diet_picture) values (dietNum_seq.NEXTVAL, ?, ?, ?)";

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) 
	    {
	        pstmt.setString(1, dietVo.getDiet_kind());
	        pstmt.setString(2, dietVo.getDiet_menu());
	        pstmt.setString(3, dietVo.getDiet_picture());
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	public DietVO selectOneDietByDnum(String dietNumber) {
	    String sql = "select * from diet where dietNumber = ?";
	    DietVO dietVo = null;
	    
	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) 
	    {
	        pstmt.setString(1, dietNumber);
	        try (ResultSet rs = pstmt.executeQuery()) {
	            if (rs.next()) {
	                dietVo = new DietVO();
	                dietVo.setDietNumber(rs.getInt("dietNumber"));
	                dietVo.setDiet_kind(rs.getString("diet_kind"));
	                dietVo.setDiet_menu(rs.getString("diet_menu"));
	                dietVo.setDiet_picture(rs.getString("diet_picture"));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dietVo;
	}


	public void deleteDiet(String dietNumber) {
	    String sql = "delete from diet where dietNumber = ?";

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) 
	    {
	        pstmt.setString(1, dietNumber);
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	public void updateDiet(DietVO dietVo) {
	    String sql = "update diet set diet_kind=?, diet_menu=?, diet_picture=? where dietNumber = ?";

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql)) 
	    {
	        pstmt.setString(1, dietVo.getDiet_kind());
	        pstmt.setString(2, dietVo.getDiet_menu());
	        pstmt.setString(3, dietVo.getDiet_picture());
	        pstmt.setInt(4, dietVo.getDietNumber());
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


//	public DietVO selectRecDiet(String dietNumber) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String sql = "select * from  diet where diet_kind = '추천식단' order by dietNumber";
//		DietVO dietVo = null;
//		dietDetailVO dietDetailVo = null;
//		try {
//			conn = DBManager.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				dietVo = new DietVO();
//				dietVo.setDietNumber(rs.getInt("dietNumber"));
//				dietVo.setDiet_kind(rs.getString("diet_kind"));
//				dietVo.setDiet_menu(rs.getString("diet_menu"));
//				dietVo.setDiet_picture(rs.getString("diet_picture"));
//			}
//			
//			//음식명 받아오기 
//			sql = "select foodName from dietDetail where dietNumber = ? ";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, dietNumber);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				dietDetailVo = new dietDetailVO();
//				dietDetailVo.setDietNumber(rs.getInt("dietNumber"));
//				dietDetailVo.setFoodName(rs.getString("foodName"));
//				
//			};
//			
//			dietVo.setDietDetailVO(dietDetailVo);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		
//		return dietVo;
//	}

	//추천식단 정보(종류,메뉴,사진 ) 불러옴
	public List<DietVO> selectRecDiet() {
	    String sql = "select * from diet where diet_kind = '추천식단' order by dietNumber";
	    List<DietVO> dietList = new ArrayList<>();

	    try (Connection conn = DBManager.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) 
	    {
	        while (rs.next()) {
	            DietVO dietVo = new DietVO();
	            dietVo.setDiet_kind(rs.getString("diet_kind"));
	            dietVo.setDiet_menu(rs.getString("diet_menu"));
	            dietVo.setDiet_picture(rs.getString("diet_picture"));
	            dietList.add(dietVo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dietList;
	}


	//저칼로리 식단 정보 불러옴 
	public List<DietVO> selectLowDiet() {
	    String sql = "select * from diet where diet_kind = '저칼로리식단' order by dietNumber";
	    List<DietVO> dietList = new ArrayList<>();

	    try (Connection conn = DBManager.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) 
	    {
	        while (rs.next()) {
	            DietVO dietVo = new DietVO();
	            dietVo.setDiet_kind(rs.getString("diet_kind"));
	            dietVo.setDiet_menu(rs.getString("diet_menu"));
	            dietVo.setDiet_picture(rs.getString("diet_picture"));
	            dietList.add(dietVo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dietList;
	}


	//간단식단 정보 불러옴
	public List<DietVO> selectSimpleDiet() {
	    String sql = "select * from diet where diet_kind = '간단식단' order by dietNumber";
	    List<DietVO> dietList = new ArrayList<>();

	    try (Connection conn = DBManager.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

	        while (rs.next()) {
	            DietVO dietVo = new DietVO();
	            dietVo.setDiet_kind(rs.getString("diet_kind"));
	            dietVo.setDiet_menu(rs.getString("diet_menu"));
	            dietVo.setDiet_picture(rs.getString("diet_picture"));
	            dietList.add(dietVo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dietList;
	}


	
	//프로틴 식단 정보 불러옴
	public List<DietVO> selectProteinDiet() {
	    String sql = "select * from diet where diet_kind = '프로틴식단' order by dietNumber";
	    List<DietVO> dietList = new ArrayList<>();

	    try (Connection conn = DBManager.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) 
	    {
	        while (rs.next()) {
	            DietVO dietVo = new DietVO();
	            dietVo.setDiet_kind(rs.getString("diet_kind"));
	            dietVo.setDiet_menu(rs.getString("diet_menu"));
	            dietVo.setDiet_picture(rs.getString("diet_picture"));
	            dietList.add(dietVo);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dietList;
	}

	public List<DietVO> selectDietBypage(int start, int end) {
		List<DietVO> dietList = new ArrayList<>();
		String sql = "select * from (select ROW_NUMBER() OVER (ORDER BY dietNumber) NUM, A.* FROM diet A ORDER BY dietNumber)"
				+ "where NUM BETWEEN? AND? ";
		
		try(Connection conn = DBManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql))
		{
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			try(ResultSet rs = pstmt.executeQuery())
			{
				while (rs.next()) {
					DietVO dietVo = new DietVO();
					dietVo.setDietNumber(rs.getInt("dietNumber"));
		            dietVo.setDiet_kind(rs.getString("diet_kind"));
		            dietVo.setDiet_menu(rs.getString("diet_menu"));
		            dietVo.setDiet_picture(rs.getString("diet_picture"));
		            
		            dietList.add(dietVo);
				}
			} 
		}   catch (SQLException e) {
				e.printStackTrace();
		}
		
		return dietList;
	
	}
}


