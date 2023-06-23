package com.andamiro.controller.event;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.dao.event.EventDAO;
import com.andamiro.dto.event.EventVO;

public class EventMainViewForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String url = "/event/Event_main.jsp";
		
		EventDAO eventDAO=EventDAO.getInstance();
		ArrayList<EventVO> newEventList=eventDAO.sumEvent();
		
		request.setAttribute("newEventList",newEventList);
		
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
		
	}
	}
