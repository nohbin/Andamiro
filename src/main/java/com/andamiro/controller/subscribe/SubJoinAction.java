package com.andamiro.controller.subscribe;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andamiro.controller.action.SubscribeAction;
import com.andamiro.dao.subscribeMem.SubscribeMemberDAO;
import com.andamiro.dto.member.MemberVO;
import com.andamiro.dto.subscribeMem.SubscribeMemberVO;

public class SubJoinAction implements SubscribeAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		int status = 1;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date currentTime = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentTime) ;
		calendar.add(Calendar.DAY_OF_MONTH, 30);   //현재 날짜에서 30일을 더함 
		Date endDate = calendar.getTime();
		String sub_start = dateFormat.format(currentTime);
		String sub_end = dateFormat.format(endDate);
		SubscribeMemberVO subVO = new SubscribeMemberVO();
		subVO.setMemberNumber(loginUser.getMemberNumber());
		subVO.setSub_start(sub_start);
		subVO.setSub_end(sub_end);
		subVO.setUserId(request.getParameter("userid"));
		subVO.setStatus(status);
		SubscribeMemberDAO sDao = SubscribeMemberDAO.getInstance();
		sDao.insertSubMem(subVO);
		
		
		String url = "subscribe/subscribeSuccess.jsp";
		request.getRequestDispatcher(url).forward(request, response);
			
	}

}
