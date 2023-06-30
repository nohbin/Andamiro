package com.andamiro.controller.event;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.dao.event.EventDAO;
import com.andamiro.dto.event.EventVO;

public class EventUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url="admin/eventUpdate.jsp";
		String eventNo=request.getParameter("eventNo");
		EventDAO eventDAO = EventDAO.getInstance();
		EventVO eventVO = eventDAO.selectOneEventByEventNumber(eventNo);
		request.setAttribute("eno", eventVO);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
		
	}

}
