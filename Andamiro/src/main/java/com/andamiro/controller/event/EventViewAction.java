package com.andamiro.controller.event;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.dao.event.EventDAO;
import com.andamiro.dto.event.EventVO;

public class EventViewAction implements Action {

    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/admin/eventView.jsp";

         int eventno = Integer.parseInt(request.getParameter("eventno"));

        EventDAO eventDAO = EventDAO.getInstance();

        EventVO eventVO = eventDAO.selectOneEventByEventNumber(eventno);

        request.setAttribute("eventview", eventVO);

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}
