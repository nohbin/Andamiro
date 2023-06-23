package com.andamiro.controller.member;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.MemberAction;
import com.andamiro.dao.member.MemberDAO;
import com.andamiro.dto.member.MemberVO;
import com.andamiro.utill.SHA256;

public class MemberJoinAction implements MemberAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String id = request.getParameter("id");
		System.out.println(id);
		String rawpwd = request.getParameter("pwd");
		String pwd = SHA256.encodeSha256(rawpwd);
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String joinDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

		MemberVO memberVO = new MemberVO();
		memberVO.setId(id);
		memberVO.setPwd(pwd);
		memberVO.setName(name);
		memberVO.setPhone(phone);
		memberVO.setEmail(email);
		memberVO.setJoinDate(joinDate);

		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.insertMember(memberVO);

//		int result = memberDAO.insertMember(memberVO);
//		if (result != 0) {
//			new MemberJoinForm().excute(request, response);
//		} else {
			new MemberLoginForm().excute(request, response);
//		}

	}
}
