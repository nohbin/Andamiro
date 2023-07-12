package com.andamiro.dao.event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	    String sql = "SELECT * FROM eventmain ORDER BY eventno DESC";

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) {

	        while (rs.next()) {
	            EventVO event = new EventVO();
	            event.setEventno(rs.getInt("eventno"));
	            event.setEventkind(rs.getString("eventkind"));
	            event.setTerm(rs.getString("term"));
	            event.setIng(rs.getString("ing"));
	            event.setImgsum(rs.getString("imgsum"));
	            eventList.add(event);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return eventList;
	}
	
	
	public ArrayList<EventVO> getEventPost() {
	    ArrayList<EventVO> eventList = new ArrayList<>();
	    String sql = "SELECT eventno, poster FROM eventmain ORDER BY eventno DESC";

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) {

	        while (rs.next()) {
	            EventVO event = new EventVO();
	            event.setEventno(rs.getInt("eventno"));
	            event.setPoster(rs.getString("poster"));
	      
	            eventList.add(event);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return eventList;
	}
	
	public ArrayList<EventVO> getNoEventPost() {
	    ArrayList<EventVO> eventList = new ArrayList<>();
	    String sql = "SELECT eventno, poster FROM eventmain ORDER BY eventno DESC";

	    try (Connection conn = DBManager.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         ResultSet rs = pstmt.executeQuery()) {

	        while (rs.next()) {
	            EventVO event = new EventVO();
	            event.setEventno(rs.getInt("eventno"));
	            event.setPoster(rs.getString("poster"));
	      
	            eventList.add(event);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return eventList;
	}
		public EventVO selectOneEventByEventNumber(int eventno) {
			String sql = "select * from eventmain where eventno = ?";
			
			EventVO eVO = null; 
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eventno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				eVO = new EventVO();
				eVO.setEventno(rs.getInt("eventno"));
				eVO.setEventkind(rs.getString("eventkind"));
				eVO.setTerm(rs.getString("term"));
				eVO.setIng(rs.getString("ing"));
				eVO.setImgsum(rs.getString("imgsum"));
				eVO.setPoster(rs.getString("poster"));
			}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			
			return eVO;
		}
			
	
		

		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		public void insertEvent(EventVO eVO) {
		    String sql = "INSERT INTO EVENTMAIN (EVENTNO, eventkind, TERM, ING, imgsum, poster) VALUES (?, ?, ?, ?, ?, ?)";
		    Connection conn = null;
		    PreparedStatement pstmt = null;

		    try {
		        conn = DBManager.getConnection();
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setInt(1,(eVO.getEventno())); // Assuming EVENTNO is of numeric data type
		        pstmt.setString(2, eVO.getEventkind());
		        pstmt.setString(3, eVO.getTerm());
		        pstmt.setString(4, eVO.getIng());
		        pstmt.setString(5, eVO.getImgsum());
		        pstmt.setString(6, eVO.getPoster());
		        pstmt.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        DBManager.close(conn, pstmt);
		    }
		}
		
		
		public void updateEvent(EventVO eVO) {
		    String sql = "UPDATE eventmain SET term=?, ing=?, imgsum=?, poster=?, eventkind=?" + "WHERE eventno=?";

		    Connection conn = null;
		    PreparedStatement pstmt = null; 
		    try {
		        conn = DBManager.getConnection();
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, eVO.getTerm());
		        pstmt.setString(2, eVO.getIng());
		        pstmt.setString(3, eVO.getImgsum());
		        pstmt.setString(4, eVO.getPoster());
		        pstmt.setString(5, eVO.getEventkind());
		        pstmt.setInt(6, eVO.getEventno());
		        pstmt.executeUpdate();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        DBManager.close(conn, pstmt);
		    }
		}

		
	public void deleteEvent(int EventNo) {
		String sql = "delete eventmain where eventno=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, EventNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		
		
	}
	
		
		
	
		// 공모전 이벤트





	
	
	public ArrayList<EventVO> event() {
	    ArrayList<EventVO> eventPoster = new ArrayList<EventVO>();
	    String sql = "SELECT poster FROM eventmain ORDER BY eventno DESC";

	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = DBManager.getConnection();
	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            EventVO eVO = new EventVO();
	            	
	            eVO.setPoster(rs.getString("poster"));
	           
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        DBManager.close(conn, pstmt, rs);
	    }
	    return eventPoster;
	}

	



    public ArrayList<EventVO> allList() {
        ArrayList<EventVO> eventList = new ArrayList<>();
        String sql = "SELECT eventno, term, ing, imgsum FROM eventmain ORDER BY eventno DESC";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                EventVO eventVO = new EventVO();
                eventVO.setEventno(rs.getInt("eventno"));
                eventVO.setTerm(rs.getString("term"));
                eventVO.setIng(rs.getString("ing"));
                eventVO.setImgsum(rs.getString("imgsum"));
                eventList.add(eventVO);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return eventList;
    }

    
    
    
	public EventVO selectOneByEventNumber(int eventno) {
		String sql = "SELECT *FROM EVENTMAIN WHERE EVENTNO=?";
		EventVO eventVO = null;
		try {
			Connection conn = DBManager.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eventno);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) { 
				eventVO = new EventVO();
				eventVO.setEventno(rs.getInt("eventno"));
				eventVO.setTerm(rs.getString("term"));
				eventVO.setIng(rs.getString("ing"));
				eventVO.setImgsum(rs.getString("imgsum"));
				eventVO.setPoster(rs.getString("poster"));
				eventVO.setEventkind(rs.getString("eventkind"));
				System.out.println(eventVO.getPoster());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return eventVO;
	}


	
}