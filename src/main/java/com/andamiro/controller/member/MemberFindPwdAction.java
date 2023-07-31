package com.andamiro.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.MemberAction;
import com.andamiro.dao.member.MemberDAO;
import com.andamiro.dto.member.MemberVO;
import com.andamiro.utill.SHA256;

public class MemberFindPwdAction implements MemberAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		MemberVO memberVO = new MemberVO();
		memberVO.setId(id);	
		memberVO.setEmail(email);
		MemberVO memberCheckVO = memberDAO.selectOneMemberByIdAndEmail(id,email);
		if(memberCheckVO != null) {
			request.setAttribute("id", memberCheckVO.getId());
			request.getRequestDispatcher("/member/updatepassword.jsp").forward(request, response);
		}else {
			request.setAttribute("result", "아이디 또는 이메일을 다시 입력해주세요");
			request.getRequestDispatcher("/member/findpassword.jsp").forward(request, response);
		}
	}

}
