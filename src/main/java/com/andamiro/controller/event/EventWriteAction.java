package com.andamiro.controller.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.dao.event.EventDAO;
import com.andamiro.dto.event.EventVO;

public class EventWriteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventVO eventVO = new EventVO();
        eventVO.setEventno(request.getParameter("eventno"));
        eventVO.setTerm(request.getParameter("term"));
        eventVO.setIng(request.getParameter("ing"));
        eventVO.setImgsum(request.getParameter("imgsum"));
        eventVO.setPoster(request.getParameter("poster"));

        EventDAO eventDAO = EventDAO.getInstance();
        eventDAO.insertEvent(eventVO);

        // 이벤트 정보를 추가한 후에 수행할 다른 동작을 여기에 추가할 수 있습니다.

        // 예시: 이벤트 목록 페이지로 리다이렉트
        response.sendRedirect("./admin/eventList.jsp");
    }

}