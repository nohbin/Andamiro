package com.andamiro.controller.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.dao.event.EventDAO;
import com.andamiro.dto.event.EventVO;

public class EventUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EventVO eventVO=new EventVO();
		
		eventVO.setEventno((request.getParameter("eventno")));
		eventVO.setTerm(request.getParameter("term"));
		eventVO.setIng(request.getParameter("ing"));
		eventVO.setImgsum(request.getParameter("imgsum"));
		
		EventDAO eventDAO = EventDAO.getInstance();
		eventDAO.updateEvent(eventVO);
		
		new EventListAction().execute(request, response);
		
	}

}
