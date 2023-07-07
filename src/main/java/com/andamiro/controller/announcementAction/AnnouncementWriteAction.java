package com.andamiro.controller.announcementAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.AnnouncementAction;
import com.andamiro.dao.Announcement.AnnouncementDAO;
import com.andamiro.dto.Announcement.AnnouncementVO;

public class AnnouncementWriteAction implements AnnouncementAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String annTitle = request.getParameter("annTitle");
		String id = request.getParameter("id");
		
		AnnouncementDAO annDAO = new AnnouncementDAO();
		
		AnnouncementVO annVO = new AnnouncementVO();
		annVO.setAnnTitle(annTitle);
		annVO.setId(id);
		annVO.setAnnouncement(request.getParameter("announcement"));

		
		annDAO.insertAnnouncement(annVO);
		request.setAttribute("message", "게시글이 등록되었습니다.");
		request.getRequestDispatcher("/announcement/announcementwritesuccess.jsp").forward(request, response);
		
	}

}
