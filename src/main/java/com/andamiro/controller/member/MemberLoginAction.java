package com.andamiro.controller.member;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andamiro.controller.action.MemberAction;
import com.andamiro.dao.member.MemberDAO;
import com.andamiro.dao.subscribeMem.SubscribeMemberDAO;
import com.andamiro.dto.member.MemberVO;
import com.andamiro.dto.subscribeMem.SubscribeMemberVO;
import com.andamiro.utill.SHA256;

public class MemberLoginAction implements MemberAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String sub_start = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		LocalDateTime startDateTime = LocalDateTime.parse(sub_start, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		LocalDateTime endDateTime = startDateTime.plusDays(30);
		String sub_end = endDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		SubscribeMemberDAO subscribememberDao = SubscribeMemberDAO.getInstance();
		
				
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
		    url = "index.jsp";
		    //로그인 성공시 해당 회원의 구독 체크
		    SubscribeMemberVO subscribememberVo = subscribememberDao.selectOneById(userid);
		    if (subscribememberVo != null) {   // 구독 정보가 존재하는 경우
		        if (subscribememberVo.getSub_end().equals(currentDate)) { // 구독 날짜가 지났을 때
		            subscribememberDao.SubCheck(subscribememberVo.getSubNumber());
		        }
		    }
		    session.removeAttribute("id");
		    session.setAttribute("loginUser", memberVO);
		    
		    
		} else {
		    url = "member/loginfail.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
