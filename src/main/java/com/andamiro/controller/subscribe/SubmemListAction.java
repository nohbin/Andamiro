package com.andamiro.controller.subscribe;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.SubscribeAction;
import com.andamiro.dao.subscribeMem.SubscribeMemberDAO;
import com.andamiro.dto.subscribeMem.SubscribeMemberVO;

public class SubmemListAction implements SubscribeAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/subscribe/submemList.jsp";
		SubscribeMemberDAO sDao = SubscribeMemberDAO.getInstance();
		List<SubscribeMemberVO> submemList = sDao.selectAllmember();
		request.setAttribute("submemList", submemList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
