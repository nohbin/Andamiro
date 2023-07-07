package com.andamiro.dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	    String sql = "SELECT COUNT(memberNumber) FROM andamiromember";

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) 
	    {
	        if (rs.next()) {
	            count = rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return count;
	}


	public int getTotalRowsRecipe() {
	    int count = 0;
	    String sql = "SELECT COUNT(recipeid) FROM andamirorecipe";

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) 
	    {
	        if (rs.next()) {
	            count = rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return count;
	}

	public int getTotalRowsSubmember() {
		int count = 0;
		String sql = "select count(subnumber) from subscribemember";
		
		try(Connection conn = DBManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()) 
		{
			if (rs.next()){
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count;
	}

	public int getTotalRowsDiet() {
		int count = 0;
		String sql = "select count(dietNumber) from diet";
		
		try(Connection conn = DBManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()) 
			{
				if (rs.next()){
					count = rs.getInt(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		
		return count;
	}

	public int getTotalRowsDietDetail() {
		int count = 0;
		String sql = "select count(dietDetailID) from dietDetail";
		
		try(Connection conn = DBManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()) 
			{
				if (rs.next()){
				 count = rs.getInt(1);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		
		return count;
	}
}
