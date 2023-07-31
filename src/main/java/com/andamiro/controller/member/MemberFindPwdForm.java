package com.andamiro.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.MemberAction;

public class MemberFindPwdForm implements MemberAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String url = "/member/findpassword.jsp";
		String id = request.getParameter("id");
		
		if(id != null) {
			request.setAttribute("id", id);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
