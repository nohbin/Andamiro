package com.andamiro.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andamiro.controller.action.MemberAction;
import com.andamiro.dao.member.MemberDAO;
import com.andamiro.dto.member.MemberVO;
import com.andamiro.utill.SHA256;

public class MemberLoginAction implements MemberAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String rawpwd = request.getParameter("pwd");
		String pwd = SHA256.encodeSha256(rawpwd);
		String url = "";
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberVO memberVO = memberDAO.selectOneMemberbyID(userid);
		if (memberVO == null || memberVO.getId().isEmpty() || memberVO.getPwd().isEmpty()) {
		    url = "member/loginfail.jsp";
		} else if (memberVO.getId().equals(userid) && memberVO.getPwd().equals(pwd)) {
		    HttpSession session = request.getSession();
		    session.removeAttribute("id");
		    session.setAttribute("loginUser", memberVO);
		    url = "index.jsp";
		} else {
		    url = "member/loginfail.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
