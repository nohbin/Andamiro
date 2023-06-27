package com.andamiro.controller.event;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.dao.event.EventDAO;
import com.andamiro.dto.event.EventVO;

public class EventViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url= "admin/eventView.jsp";
		
		String eventno=request.getParameter("eventno");
		
		EventDAO eDao= EventDAO.getInstance();
		
		EventVO eVO = eDao.selectOneEventByEventNumber(eventno);
		
		request.setAttribute("event",eVO);
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
