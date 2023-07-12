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
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/admin/eventUpdate.jsp";
        int eventno = Integer.parseInt(request.getParameter("eventno"));
        EventDAO eventdao = EventDAO.getInstance();
        EventVO eventvo = eventdao.selectOneEventByEventNumber(eventno);
        request.setAttribute("eno", eventvo);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
