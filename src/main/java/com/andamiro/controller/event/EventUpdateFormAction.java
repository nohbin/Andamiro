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
		EventDAO eDao = EventDAO.getInstance();
		EventVO eVO = eDao.selectOneEventByEventNumber(eventNo);
		request.setAttribute("eno", eVO);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
		
	}

}
