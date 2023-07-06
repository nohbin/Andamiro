package com.andamiro.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.MemberAction;

public class MemeberMypageEditAction implements MemberAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String url = "/member/mypage-edit.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
