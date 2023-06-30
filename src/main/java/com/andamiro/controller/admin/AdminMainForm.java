package com.andamiro.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.AdminAction;
import com.andamiro.dao.member.MemberDAO;
import com.andamiro.dto.member.MemberVO;

public class AdminMainForm implements AdminAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		List<MemberVO> memberList = memberDAO.selectAllMemberFirstPage();
		
		request.setAttribute("memberList", memberList);
		
		String url = "/admin/adminmainpage.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
