package com.andamiro.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.MemberAction;
import com.andamiro.dao.member.MemberDAO;
import com.andamiro.dto.member.MemberVO;

public class MemberFindIdAction implements MemberAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		MemberVO memberVO = memberDAO.selectOneMemeberbyNameAndEmail(request.getParameter("name"),request.getParameter("email"));
		if(memberVO != null) {
			request.setAttribute("id", memberVO.getId());
		}
		
		
		request.getRequestDispatcher("/member/findidresult.jsp").forward(request, response);
	}

}
