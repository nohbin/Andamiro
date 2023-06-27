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
		
		EventVO eVO=new EventVO();
		
		eVO.setEventno(Integer.parseInt(request.getParameter("eventno")));
		eVO.setEvstart((request.getParameter("evstart")));
		eVO.setEvend((request.getParameter("evend")));
		eVO.setIng(request.getParameter("ing"));
		eVO.setImgsum(request.getParameter("imgsum"));
		
		EventDAO eDao = EventDAO.getInstance();
		eDao.updateEvent(eVO);
		
		new EventListAction().execute(request, response);
		
	}

}
