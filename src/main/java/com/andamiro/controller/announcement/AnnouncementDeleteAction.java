package com.andamiro.controller.announcement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.AnnouncementAction;
import com.andamiro.dao.announcement.AnnouncementDAO;

public class AnnouncementDeleteAction implements AnnouncementAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String annNum = request.getParameter("annNum");
		AnnouncementDAO annDAO = AnnouncementDAO.getInstance();
		annDAO.deleteAnnouncement(annNum);
		String url = "/AnnouncementServlet?command=announcement_list";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
