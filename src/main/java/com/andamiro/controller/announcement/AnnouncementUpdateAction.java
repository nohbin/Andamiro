package com.andamiro.controller.announcement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.AnnouncementAction;
import com.andamiro.dao.announcement.AnnouncementDAO;
import com.andamiro.dto.announcement.AnnouncementVO;

public class AnnouncementUpdateAction implements AnnouncementAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	  System.out.println("excute실행");
	  String annTitle = request.getParameter("annTitle");
	  String id = request.getParameter("id");
	  String announcement = request.getParameter("announcement");
	  int annNum = Integer.parseInt(request.getParameter("annNum"));
	  
	  AnnouncementVO annVO = new AnnouncementVO();
	  annVO.setAnnouncement(announcement);
	  annVO.setId(id);
	  annVO.setAnnTitle(annTitle);
	  annVO.setAnnNum(annNum);
	  AnnouncementDAO annDAO =  AnnouncementDAO.getInstance();
	  annDAO.updateAnnouncement(annVO , annNum);
	  String url = "/AnnouncementServlet?command=announcement_list";
	  request.getRequestDispatcher(url).forward(request, response);
	}
}
