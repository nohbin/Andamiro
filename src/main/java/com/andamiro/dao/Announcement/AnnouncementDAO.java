package com.andamiro.dao.Announcement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.andamiro.dto.Announcement.AnnouncementVO;
import com.andamiro.utill.DBManager;

public class AnnouncementDAO {
	public static AnnouncementDAO instance = new AnnouncementDAO();

	public AnnouncementDAO() {
	}

	public static AnnouncementDAO getInstance() {
		return instance;
	}

	public List<AnnouncementVO> selectAllList() {
		String sql = "SELECT A.ID , N.*\r\n"
				+ "FROM ANDAMIROMEMBER A\r\n"
				+ "INNER JOIN ANNOUNCEMENT N ON A.ID =  N.ID";
		List<AnnouncementVO> annList = new ArrayList<AnnouncementVO>();

		try (Connection conn = DBManager.getConnection(); Statement stmt = conn.createStatement();) 

			{
				try (ResultSet rs = stmt.executeQuery(sql);) {
					while (rs.next()) {
						AnnouncementVO annVO = new AnnouncementVO();
							annVO.setAnnNum(rs.getInt("annNum"));
							annVO.setAnnTitle(rs.getString("annTitle"));
							annVO.setViewCount(rs.getInt("viewCount"));
							annVO.setJoindate(rs.getTimestamp("joindate"));
							annVO.setId(rs.getString("id"));
							annList.add(annVO);
					}
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return annList;
	}
	public void insertAnnouncement(AnnouncementVO annVO) {
		String sql = "INSERT INTO announcement (annNum, joindate, annTitle, id, announcement) VALUES (ann_no_seq.NEXTVAL, sysdate, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, annVO.getAnnTitle());
			pstmt.setString(2, annVO.getId());
			pstmt.setString(3, annVO.getAnnouncement());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void redcountView(int annNum) {
		String sql = "update announcement set viewCount=viewCount+1 where annNum=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, annNum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public AnnouncementVO selectOneAnnouncementNum(int annNum) {
		String sql = "SELECT * FROM ANNOUNCEMENT WHERE annNum = ?";
		AnnouncementVO annVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, annNum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				annVO = new AnnouncementVO();
				annVO.setAnnNum(rs.getInt("annNum"));
				annVO.setAnnTitle(rs.getString("annTitle"));
				annVO.setAnnouncement(rs.getString("announcement"));
				annVO.setId(rs.getString("id"));
				annVO.setViewCount(rs.getInt("viewCount"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return annVO;
	}
	public void updateAnnouncement(AnnouncementVO annVO, int annNum) {
	    String sql = "UPDATE announcement SET announcement = ?, id = ?, annTitle = ? WHERE annNum = ?";
	    
	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);) {
	        pstmt.setString(1, annVO.getAnnouncement());
	        pstmt.setString(2, annVO.getId());
	        pstmt.setString(3, annVO.getAnnTitle());
	        pstmt.setInt(4, annVO.getAnnNum());
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void deleteAnnouncement(String annNum) {
		String sql = "delete announcement where annNum=?";
		
		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, annNum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	

