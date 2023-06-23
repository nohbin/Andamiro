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
	public ArrayList<EventVO> sumEvent() {

		ArrayList<EventVO> eventList = new ArrayList<EventVO>();

		String sql = "INSERT INTO EVENTMAIN(EVSTART,EVEND,ING,imgsum)"
				+ "VALUES(?,?,?,?)";



		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EventVO eVO = new EventVO();
				
				
				eVO.setEvstart(rs.getInt("evstart"));
				eVO.setEvend(rs.getInt("evend"));
				eVO.setIng(rs.getString("ing"));
				eVO.setImgsum(rs.getString("imgsum"));
				eventList.add(eVO);

			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventList;
	} // 공모전 이벤트

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
}




