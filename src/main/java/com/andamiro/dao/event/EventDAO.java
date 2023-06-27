package com.andamiro.dao.event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.andamiro.dto.diet.DietVO;
import com.andamiro.dto.event.EventVO;
import com.andamiro.utill.DBManager;

public class EventDAO {
	private EventDAO() {

	}

	private static EventDAO instance = new EventDAO();

	public static EventDAO getInstance() {
		return instance;
	}

	// 이벤트 메인
	public ArrayList<EventVO> getEventList() {
	    ArrayList<EventVO> eventList = new ArrayList<>();

	    String sql = "SELECT evstart, evend, ing, imgsum FROM eventmain ORDER BY eventno DESC";

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) {

	    	while (rs.next()) {
	    	    EventVO event = new EventVO();
	    	    event.setEvstart(rs.getString("evstart"));
	    	    event.setEvend(rs.getString("evend"));
	    	    event.setIng(rs.getString("ing"));
	    	    event.setImgsum(rs.getString("imgsum"));
	    	    eventList.add(event);
	    	}

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return eventList;
	}

		public EventVO selectOneEventByEventNumber(String eventNumber ) {
			String sql = "select * from eventmain where eventno = ?";
			
			EventVO eVO = null; 
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eventNumber);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				eVO = new EventVO();
				eVO.setEvstart(rs.getString("evstart"));
				eVO.setEvend(rs.getString("evend"));
				eVO.setIng(rs.getString("ing"));
				eVO.setImgsum(rs.getString("imgsum"));
			}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			
			return eVO;
		}
			
			
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void insertEvent(EventVO eVO) {
			
			String sql = "INSERT INTO EVENTMAIN(EVENTNO,EVSTART,EVEND,ING,imgsum)"
						+ "VALUES(?,?,?,?,?)";
				
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,eVO.getEventno());
				pstmt.setString(2,eVO.getEvstart());
				pstmt.setString(3,eVO.getEvend());
				pstmt.setString(4,eVO.getIng());
				pstmt.setString(5,eVO.getImgsum());
				pstmt.executeUpdate();
				
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBManager.close(conn, pstmt);
			}
		}
		
		
		public void updateEvent(EventVO eVO) {
		String sql = "update eventmain set evstart=?, evend=?, ing=?, imgsum=?"
		+ "where eventno=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,eVO.getEvstart());
			pstmt.setString(2,eVO.getEvend());
			pstmt.setString(3,eVO.getIng());
			pstmt.setString(4,eVO.getImgsum());
			pstmt.executeUpdate();

			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		
		
	}
		
		
	public void deleteEvent(String EventNo) {
		String sql = "delete eventmain where eventno=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, EventNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		
	}
	
		
		
	
		// 공모전 이벤트





	public ArrayList<EventVO> conEvent() {
		ArrayList<EventVO> conImg = new ArrayList<EventVO>();

		String sql = "select*from eventcontestdetail";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EventVO eVO = new EventVO();
				eVO.setContestno(rs.getInt("contestno"));
				eVO.setConpost(rs.getString("conpost"));
				conImg.add(eVO);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return conImg;

	}// 일반 이벤트
	
	public ArrayList<EventVO> event() {
	    ArrayList<EventVO> eventList = new ArrayList<EventVO>();
	    String sql = "SELECT * FROM nomaleventdetail";

	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = DBManager.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            EventVO eVO = new EventVO();
	            eVO.setEventno(rs.getInt("eventno"));
	            eVO.setPost(rs.getString("post"));
	            eventList.add(eVO);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBManager.close(conn, pstmt, rs);
	    }
	    return eventList;
	}

	public DietVO selectOneDietByDnum(String dietNumber) {
		// TODO Auto-generated method stub
		return null;
	}
}




