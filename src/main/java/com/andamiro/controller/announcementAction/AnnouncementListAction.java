package com.andamiro.controller.announcementAction;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andamiro.controller.action.AnnouncementAction;
import com.andamiro.dao.Announcement.AnnouncementDAO;
import com.andamiro.dto.Announcement.AnnouncementVO;
import com.andamiro.dto.member.MemberVO;

public class AnnouncementListAction implements AnnouncementAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url ="/announcement/announcementlist.jsp";
		AnnouncementDAO annDao = AnnouncementDAO.getInstance();
//		HttpSession session = request.getSession();
//		MemberVO memVO = (MemberVO) session.getAttribute("loginUser");
//		String memberId = memVO.getId(); // 로그인시 보이도록 해주기
		List<AnnouncementVO> annList = annDao.selectAllList();
		request.setAttribute("annList", annList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
