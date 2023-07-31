package com.andamiro.controller.announcementAction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.AnnouncementAction;
import com.andamiro.dao.Announcement.AnnouncementDAO;
import com.andamiro.dto.Announcement.AnnouncementVO;

public class AnnouncementSearchAction implements AnnouncementAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/announcement/announcementlist.jsp";
		AnnouncementDAO annDAO = AnnouncementDAO.getInstance();
		String annTitle = request.getParameter("annTitle");
		List<AnnouncementVO> annList = annDAO.AnnouncementSearch(annTitle);
		request.setAttribute("annList", annList);
		request.getRequestDispatcher(url).forward(request, response);

	}

}
