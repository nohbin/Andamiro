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

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		request.getRequestDispatcher(url).forward(request, response);
	}

}
