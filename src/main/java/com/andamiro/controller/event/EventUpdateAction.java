package com.andamiro.controller.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.dao.event.EventDAO;
import com.andamiro.dto.event.EventVO;

public class EventUpdateAction implements Action {

    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eventno = Integer.parseInt(request.getParameter("eventno"));
        String eventkind = request.getParameter("eventkind");
        String term = request.getParameter("eventTerm");
        String ing = request.getParameter("ing");
        String imgsum = request.getParameter("eventImgsum");
        String poster = request.getParameter("eventPoster");

        EventVO eventVO = new EventVO();
        eventVO.setEventno(eventno);
        eventVO.setEventkind(eventkind);
        eventVO.setTerm(term);
        eventVO.setIng(ing);
        eventVO.setImgsum(imgsum);
        eventVO.setPoster(poster);

        EventDAO eventDAO = EventDAO.getInstance();
        eventDAO.updateEvent(eventVO);

        // Perform any additional actions after updating event information here
        // For example, you can redirect to the event list page

        // 이벤트 정보를 수정한 후에 수행할 다른 동작을 여기에 추가할 수 있습니다.
        new EventListAction().excute(request, response);
    }
}
