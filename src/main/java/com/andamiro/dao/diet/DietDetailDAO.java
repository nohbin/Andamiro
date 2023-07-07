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
	
	//dietDetail 데이터 모두 조회하는 메소드(not 페이징처리)
//	public List<dietDetailVO> selectAllboards() {
//		String sql = "select * from dietDetail order by dietDetailID desc ";
//		List<dietDetailVO> list = new ArrayList<dietDetailVO>();
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = DBManager.getConnection();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				dietDetailVO dietDetailVo = new dietDetailVO();
//				dietDetailVo.setDietDetailID(rs.getInt("dietDetailID"));
//				dietDetailVo.setDietNumber(rs.getInt("dietNumber"));
//				dietDetailVo.setFoodName(rs.getString("foodName"));
//				dietDetailVo.setKcal(rs.getString("kcal"));
//				dietDetailVo.setComponent(rs.getString("component"));
//				list.add(dietDetailVo);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBManager.close(conn, stmt, rs);
//		}
//		
//		return list;
//	}
	
	//dietDetail 데이터 모두 조회 (페이징 처리)
	public List<dietDetailVO> selectDetailByPage(int start, int end) {
		List<dietDetailVO> dietDetailList = new ArrayList<>();
		
		String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY dietDetailID) NUM, A.* FROM dietDetail A ORDER BY dietDetailID) "
	            + "WHERE NUM BETWEEN ? AND ? ";
		
	    try (Connection conn = DBManager.getConnection();
	    	 PreparedStatement pstmt = conn.prepareStatement(sql)) {
	    	
	    	pstmt.setInt(1, start);
	    	pstmt.setInt(2, end);
			
	    	try(ResultSet rs = pstmt.executeQuery()) 
	    	{
	    		while(rs.next()) {
	    			dietDetailVO dietDetailVo = new dietDetailVO();
	    			dietDetailVo.setDietDetailID(rs.getInt("dietDetailID"));
					dietDetailVo.setDietNumber(rs.getInt("dietNumber"));
					dietDetailVo.setFoodName(rs.getString("foodName"));
					dietDetailVo.setKcal(rs.getString("kcal"));
					dietDetailVo.setComponent(rs.getString("component"));
	    			dietDetailList.add(dietDetailVo);
	    		}
	    	}
	    	
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
	    	
	    return dietDetailList;
		
	}
	
	
	
	

	public void insertDetail(dietDetailVO dietDetailVo) {
		String sql = "insert into dietDetail ("
				+ "dietDetailID,dietNumber, foodName, kcal, component) "
				+ "values (dietDetailID_seq.nextval, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dietDetailVo.getDietNumber());
			pstmt.setString(2, dietDetailVo.getFoodName());
			pstmt.setString(3, dietDetailVo.getKcal());
			pstmt.setString(4, dietDetailVo.getComponent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		
				
	}

	public dietDetailVO selectOneDetailById(String dietDetailID) {
		String sql = "select * from dietDetail where dietDetailID = ?";
		dietDetailVO dietDetailVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dietDetailID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dietDetailVo = new dietDetailVO();
				dietDetailVo.setDietDetailID(rs.getInt("dietDetailID"));
				dietDetailVo.setFoodName(rs.getString("foodName"));
				dietDetailVo.setKcal(rs.getString("kcal"));
				dietDetailVo.setComponent(rs.getString("component"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);			
		}
		return dietDetailVo;
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

	public void updateDetail(dietDetailVO dietDetailVo) {
		String sql = "update dietDetail set  foodName=?, kcal=?, component=? "
				+ " where dietDetailID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dietDetailVo.getFoodName());
			pstmt.setString(2, dietDetailVo.getKcal());
			pstmt.setString(3, dietDetailVo.getComponent());
			pstmt.setInt(4, dietDetailVo.getDietDetailID());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	
	
 	
	
	//추천식단(아침) 음식명 불러옴
 	public List<dietDetailVO> selectfoodName1() {
		String sql = "select foodName from dietDetail where dietNumber= 1 order by dietDetailID "; 
		List<dietDetailVO> foodList1 = new ArrayList<dietDetailVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietDetailVo = new dietDetailVO();
				dietDetailVo.setFoodName(rs.getString("foodName"));
				foodList1.add(dietDetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return foodList1;
	}

 	//추천식단(점심) 음식명 불러옴
	public List<dietDetailVO> selectfoodName2() {
		String sql = "select foodName from dietDetail where dietNumber= 2 order by dietDetailID "; 
		List<dietDetailVO> foodList2 = new ArrayList<dietDetailVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietDetailVo = new dietDetailVO();
				dietDetailVo.setFoodName(rs.getString("foodName"));
				foodList2.add(dietDetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return foodList2;
	}

	//추천식단(저녁) 음식명 불러옴
	public List<dietDetailVO> selectfoodName3() {
		String sql = "select foodName from dietDetail where dietNumber= 3 order by dietDetailID "; 
		List<dietDetailVO> foodList3 = new ArrayList<dietDetailVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietDetailVo = new dietDetailVO();
				dietDetailVo.setFoodName(rs.getString("foodName"));
				foodList3.add(dietDetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return foodList3;  
	}

	
	//추천식단(아침) 상세정보 불러옴 
	public List<dietDetailVO> selectDietDetail1() {
		String sql = "select * from dietDetail where dietNumber = 1 order by dietDetailID";
		List<dietDetailVO> dietdetailList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietdetailVo = new dietDetailVO();
				dietdetailVo.setFoodName(rs.getString("foodName"));;
				dietdetailVo.setKcal(rs.getString("kcal"));
				dietdetailVo.setComponent(rs.getString("component"));
				dietdetailList.add(dietdetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return dietdetailList;
	}

	//추천식단(점심) 상세정보 불러옴 
	public List<dietDetailVO> selectDietDetail2() {
		String sql = "select * from dietDetail where dietNumber = 2 order by dietDetailID";
		List<dietDetailVO> dietdetailList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietdetailVo = new dietDetailVO();
				dietdetailVo.setFoodName(rs.getString("foodName"));;
				dietdetailVo.setKcal(rs.getString("kcal"));
				dietdetailVo.setComponent(rs.getString("component"));
				dietdetailList.add(dietdetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return dietdetailList;
	}

	//추천식단(저녁)의 상세정보 불러옴 
	public List<dietDetailVO> selectDietDetail3() {
		String sql = "select * from dietDetail where dietNumber = 3 order by dietDetailID";
		List<dietDetailVO> dietdetailList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietdetailVo = new dietDetailVO();
				dietdetailVo.setFoodName(rs.getString("foodName"));;
				dietdetailVo.setKcal(rs.getString("kcal"));
				dietdetailVo.setComponent(rs.getString("component"));
				dietdetailList.add(dietdetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return dietdetailList;
	}

	//간단 식단(아침) 음식명 출력 
	public List<dietDetailVO> selectSimpleFood1() {
		String sql = "select foodName from dietDetail where dietNumber= 4 order by dietDetailID "; 
		List<dietDetailVO> foodList1 = new ArrayList<dietDetailVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietDetailVo = new dietDetailVO();
				dietDetailVo.setFoodName(rs.getString("foodName"));
				foodList1.add(dietDetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return foodList1;
	}

	//간단식단(점심) 음식명 출력 
	public List<dietDetailVO> selectSimpleFood2() {
		String sql = "select foodName from dietDetail where dietNumber= 5 order by dietDetailID "; 
		List<dietDetailVO> foodList2 = new ArrayList<dietDetailVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietDetailVo = new dietDetailVO();
				dietDetailVo.setFoodName(rs.getString("foodName"));
				foodList2.add(dietDetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return foodList2;
	}

	//간단식단(저녁) 음식명 출력 
	public List<dietDetailVO> selectSimpleFood3() {
		String sql = "select foodName from dietDetail where dietNumber= 6 order by dietDetailID "; 
		List<dietDetailVO> foodList3 = new ArrayList<dietDetailVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietDetailVo = new dietDetailVO();
				dietDetailVo.setFoodName(rs.getString("foodName"));
				foodList3.add(dietDetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return foodList3;
	}

	//간단식단(아침)영양정보 불러옴 
	public List<dietDetailVO> selectDietDetail() {
		String sql = "select * from dietDetail where dietNumber = 4 order by dietDetailID";
		List<dietDetailVO> dietdetailList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietdetailVo = new dietDetailVO();
				dietdetailVo.setFoodName(rs.getString("foodName"));;
				dietdetailVo.setKcal(rs.getString("kcal"));
				dietdetailVo.setComponent(rs.getString("component"));
				dietdetailList.add(dietdetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return dietdetailList;
	}

	//간단식단(점심) 영양정보 불러옴
	public List<dietDetailVO> selectSimpleDetail() {
		String sql = "select * from dietDetail where dietNumber = 5 order by dietDetailID";
		List<dietDetailVO> dietdetailList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietdetailVo = new dietDetailVO();
				dietdetailVo.setFoodName(rs.getString("foodName"));;
				dietdetailVo.setKcal(rs.getString("kcal"));
				dietdetailVo.setComponent(rs.getString("component"));
				dietdetailList.add(dietdetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return dietdetailList;
	}

	//간단식단(저녁) 영양정보 불러옴
	public List<dietDetailVO> selectSimpleDinnerDetail() {
		String sql = "select * from dietDetail where dietNumber = 6 order by dietDetailID";
		List<dietDetailVO> dietdetailList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietdetailVo = new dietDetailVO();
				dietdetailVo.setFoodName(rs.getString("foodName"));;
				dietdetailVo.setKcal(rs.getString("kcal"));
				dietdetailVo.setComponent(rs.getString("component"));
				dietdetailList.add(dietdetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return dietdetailList;
	}
	
	
	//저칼로리식단(아침)의 음식명 출력
	public List<dietDetailVO> selectlowFood1() {
			String sql = "select foodName from dietDetail where dietNumber= 7 order by dietDetailID "; 
			List<dietDetailVO> foodList1 = new ArrayList<dietDetailVO>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				conn = DBManager.getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				while(rs.next()) {
					dietDetailVO dietDetailVo = new dietDetailVO();
					dietDetailVo.setFoodName(rs.getString("foodName"));
					foodList1.add(dietDetailVo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				DBManager.close(conn, stmt, rs);
			}
			
			return foodList1;
	
			}

	//저칼로리식단(점심)의 음식명 출력
	public List<dietDetailVO> selectlowFood2() {
		String sql = "select foodName from dietDetail where dietNumber= 8 order by dietDetailID "; 
		List<dietDetailVO> foodList2 = new ArrayList<dietDetailVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietDetailVo = new dietDetailVO();
				dietDetailVo.setFoodName(rs.getString("foodName"));
				foodList2.add(dietDetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return foodList2;

		}

	//저칼로리식단(저녁)의 음식명 출력 
	public List<dietDetailVO> selectlowFood3() {
		String sql = "select foodName from dietDetail where dietNumber= 9 order by dietDetailID "; 
		List<dietDetailVO> foodList3 = new ArrayList<dietDetailVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietDetailVo = new dietDetailVO();
				dietDetailVo.setFoodName(rs.getString("foodName"));
				foodList3.add(dietDetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return foodList3;
	}

	//저칼로리식단(아침) 영양정보 불러옴 
	public List<dietDetailVO> selectDietDetail4() {
		String sql = "select * from dietDetail where dietNumber = 7 order by dietDetailID";
		List<dietDetailVO> dietdetailList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietdetailVo = new dietDetailVO();
				dietdetailVo.setFoodName(rs.getString("foodName"));;
				dietdetailVo.setKcal(rs.getString("kcal"));
				dietdetailVo.setComponent(rs.getString("component"));
				dietdetailList.add(dietdetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return dietdetailList;
	}

	//저칼로리식단(점심) 영양정보 불러옴 
	public List<dietDetailVO> selectDietDetail5() {
		String sql = "select * from dietDetail where dietNumber = 8 order by dietDetailID";
		List<dietDetailVO> dietdetailList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietdetailVo = new dietDetailVO();
				dietdetailVo.setFoodName(rs.getString("foodName"));;
				dietdetailVo.setKcal(rs.getString("kcal"));
				dietdetailVo.setComponent(rs.getString("component"));
				dietdetailList.add(dietdetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return dietdetailList;
	}
	
	//저칼로리식단(저녁) 영양정보 불러옴 
	public List<dietDetailVO> selectDietDetail6() {
		String sql = "select * from dietDetail where dietNumber = 9 order by dietDetailID";
		List<dietDetailVO> dietdetailList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietdetailVo = new dietDetailVO();
				dietdetailVo.setFoodName(rs.getString("foodName"));;
				dietdetailVo.setKcal(rs.getString("kcal"));
				dietdetailVo.setComponent(rs.getString("component"));
				dietdetailList.add(dietdetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return dietdetailList;
	}



	//프로틴식단(아침) 음식명 출력
	public List<dietDetailVO> selectProteinFood1() {
		String sql = "select foodName from dietDetail where dietNumber= 10 order by dietDetailID "; 
		List<dietDetailVO> foodList1 = new ArrayList<dietDetailVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietDetailVo = new dietDetailVO();
				dietDetailVo.setFoodName(rs.getString("foodName"));
				foodList1.add(dietDetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return foodList1;
	}

	//프로틴식단(점심) 음식명 출력
	public List<dietDetailVO> selectProteinFood2() {
		String sql = "select foodName from dietDetail where dietNumber= 11 order by dietDetailID "; 
		List<dietDetailVO> foodList2 = new ArrayList<dietDetailVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietDetailVo = new dietDetailVO();
				dietDetailVo.setFoodName(rs.getString("foodName"));
				foodList2.add(dietDetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return foodList2;
	}

	//프로틴식단(저녁) 음식명 출력
	public List<dietDetailVO> selectProteinFood3() {
		String sql = "select foodName from dietDetail where dietNumber= 12 order by dietDetailID "; 
		List<dietDetailVO> foodList3 = new ArrayList<dietDetailVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietDetailVo = new dietDetailVO();
				dietDetailVo.setFoodName(rs.getString("foodName"));
				foodList3.add(dietDetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBManager.close(conn, stmt, rs);
		}
		
		return foodList3;
	}

	//프로틴식단(아침) 영양정보 불러옴 
	public List<dietDetailVO> selectProteinDetail() {
		String sql = "select * from dietDetail where dietNumber = 10 order by dietDetailID";
		List<dietDetailVO> dietdetailList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietdetailVo = new dietDetailVO();
				dietdetailVo.setFoodName(rs.getString("foodName"));;
				dietdetailVo.setKcal(rs.getString("kcal"));
				dietdetailVo.setComponent(rs.getString("component"));
				dietdetailList.add(dietdetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return dietdetailList;
	}

	
	//프로틴식단(점심) 영양정보 불러옴 
	public List<dietDetailVO> selectProteinLunchDetail() {
		String sql = "select * from dietDetail where dietNumber = 11 order by dietDetailID";
		List<dietDetailVO> dietdetailList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietdetailVo = new dietDetailVO();
				dietdetailVo.setFoodName(rs.getString("foodName"));;
				dietdetailVo.setKcal(rs.getString("kcal"));
				dietdetailVo.setComponent(rs.getString("component"));
				dietdetailList.add(dietdetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return dietdetailList;
	}

	////프로틴식단(저녁) 영양정보 불러옴
	public List<dietDetailVO> selectProteinDinnerDetail() {
		String sql = "select * from dietDetail where dietNumber = 12 order by dietDetailID";
		List<dietDetailVO> dietdetailList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dietDetailVO dietdetailVo = new dietDetailVO();
				dietdetailVo.setFoodName(rs.getString("foodName"));;
				dietdetailVo.setKcal(rs.getString("kcal"));
				dietdetailVo.setComponent(rs.getString("component"));
				dietdetailList.add(dietdetailVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return dietdetailList;
	}


	

}
