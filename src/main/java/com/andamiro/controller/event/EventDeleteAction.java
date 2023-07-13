package com.andamiro.controller.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.dao.event.EventDAO;

public class EventDeleteAction implements Action {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int eventno = Integer.parseInt(request.getParameter("eventno"));
		
		EventDAO eventDAO=EventDAO.getInstance();
		eventDAO.deleteEvent(eventno);
		
		new EventListAction().excute(request,response);
		
		
		
		
	}

}