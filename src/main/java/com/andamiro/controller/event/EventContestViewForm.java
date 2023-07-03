package com.andamiro.controller.event;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.dao.event.EventDAO;
import com.andamiro.dto.event.EventVO;
public class EventContestViewForm implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/event/Event_contest.jsp";
        int eventno = Integer.parseInt(request.getParameter("eventno"));
        EventDAO eventDAO = EventDAO.getInstance();
        EventVO eventvo = eventDAO.selectOneByEventNumber(eventno);
        request.setAttribute("gang", eventvo);

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
