package com.andamiro.controller.announcementAction;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andamiro.controller.action.AnnouncementAction;
import com.andamiro.dao.Announcement.AnnouncementDAO;
import com.andamiro.dto.Announcement.AnnouncementVO;
import com.andamiro.dto.member.MemberVO;

public class AnnouncementDetailAction implements AnnouncementAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "announcement/announcement_detail.jsp";
		int annNum = Integer.parseInt(request.getParameter("annNum"));
		String annTitle = request.getParameter("annTitle");
		HttpSession session = request.getSession();
		MemberVO memberVO =  (MemberVO) session.getAttribute("loginUser");
		AnnouncementDAO annDAO = AnnouncementDAO.getInstance();
		annDAO.redcountView(annNum);
		AnnouncementVO annVO = annDAO.selectOneAnnouncementNum(annNum);
		request.setAttribute("announcement", annVO);
		request.getRequestDispatcher(url).forward(request, response);
		
		

	}

}
