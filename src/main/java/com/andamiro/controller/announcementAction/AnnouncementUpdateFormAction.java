package com.andamiro.controller.announcementAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.AnnouncementAction;
import com.andamiro.dao.Announcement.AnnouncementDAO;
import com.andamiro.dto.Announcement.AnnouncementVO;

public class AnnouncementUpdateFormAction implements AnnouncementAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int annNum = Integer.parseInt(request.getParameter("annNum"));
        
        AnnouncementDAO annDAO = AnnouncementDAO.getInstance();
        annDAO.redcountView(annNum);
        AnnouncementVO announcementVO = annDAO.selectOneAnnouncementNum(annNum);
        if (announcementVO != null) {
            request.setAttribute("announcement", announcementVO);
            String url = "/announcement/announcementupdate.jsp";
            request.getRequestDispatcher(url).forward(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
