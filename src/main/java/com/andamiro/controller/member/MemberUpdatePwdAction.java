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

public class MemberUpdatePwdAction implements MemberAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		MemberVO memberCheckVO = memberDAO.selectOneMemberbyID(id);
		
		if(memberCheckVO != null) {
			MemberVO memberVO = new MemberVO();
			
			String rawpwd = request.getParameter("pwd");
			String pwd = SHA256.encodeSha256(rawpwd);
			
			memberVO.setId(id);	
			memberVO.setPwd(pwd);
			
			memberDAO.updateMemberPassword(memberVO);
			request.setAttribute("id", memberVO.getId());
			request.getRequestDispatcher("/member/login.jsp").forward(request, response);
		}else {
			request.setAttribute("result", "에러 발생");
		}
		
		
	}

}
