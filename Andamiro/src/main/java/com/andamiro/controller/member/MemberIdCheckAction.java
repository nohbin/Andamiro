package com.andamiro.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.MemberAction;
import com.andamiro.dao.member.MemberDAO;

public class MemberIdCheckAction implements MemberAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String url = null;
		String id = request.getParameter("id");
		MemberDAO memberDAO = MemberDAO.getInstance();

		int idCheckResult = memberDAO.MemberIdCheckById(id);
		if(idCheckResult == 1) {
			request.setAttribute("message", "은(는) 중복된 아이디 입니다! 다른 아이디를 입력해주세요");
			url = "/member/memberidcheck.jsp";
		}else {
			url = "/member/idchecksuccess.jsp";
		}
		
		request.setAttribute("id", id);
		
	
		request.getRequestDispatcher(url).forward(request, response);
	}
}
