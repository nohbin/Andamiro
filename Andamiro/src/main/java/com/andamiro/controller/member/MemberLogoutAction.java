package com.andamiro.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andamiro.controller.action.MemberAction;

public class MemberLogoutAction implements MemberAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String url = "/member/logout.jsp";
		String logoutMessage = "로그아웃 하셨습니다.";

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		String infochange = (String) request.getAttribute("infoChangeMessage");
		
		if(infochange != null) {
			logoutMessage = infochange;
		}
		
		request.setAttribute("logoutMessage", logoutMessage);
		
		
		
		
			

		request.getRequestDispatcher(url).forward(request, response);
	}

}
