package com.andamiro.controller.subscribe;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.SubscribeAction;
import com.andamiro.dao.subscribeMem.SubscribeMemberDAO;
import com.andamiro.dto.subscribeMem.SubscribeMemberVO;

public class SubmemViewAction implements SubscribeAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/subscribe/submemView.jsp";
		String subNumber = request.getParameter("subNumber");
		SubscribeMemberDAO sDao = SubscribeMemberDAO.getInstance();
		SubscribeMemberVO sVO = sDao.selectOneBySnum(subNumber);
		request.setAttribute("subscribe", sVO);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}