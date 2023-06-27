package com.andamiro.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.MemberAction;
import com.andamiro.dao.member.MemberDAO;
import com.andamiro.dto.member.MemberVO;
import com.andamiro.utill.SHA256;

public class MemberInfoEditAction implements MemberAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int memberNumber = Integer.parseInt(request.getParameter("membernumber"));
		String changeId = request.getParameter("changeid");
		String originalId = request.getParameter("originalId");
		String rawpwd = request.getParameter("pwd");
		String pwd = SHA256.encodeSha256(rawpwd);
		String phone = request.getParameter("phone");
		
		MemberVO memberVO = new MemberVO();
		if(!(originalId.equals(changeId))) {
			memberVO.setId(changeId);	
		}
		memberVO.setPwd(pwd);
		memberVO.setPhone(phone);
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.updateMemberInfoByMemberNumber(memberNumber , memberVO);
		
		
		String infoChangeMessage = "회원정보 수정 완료. 다시 로그인 해주세요.";
		request.setAttribute("infoChangeMessage", infoChangeMessage);
		
		MemberLogoutAction logoutAction = new MemberLogoutAction();
        logoutAction.excute(request, response);
        
		
	}

}
