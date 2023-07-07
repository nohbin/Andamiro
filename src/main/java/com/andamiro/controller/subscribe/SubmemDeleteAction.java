package com.andamiro.controller.subscribe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.SubscribeAction;
import com.andamiro.controller.admin.dietListAction;
import com.andamiro.dao.diet.DietDAO;
import com.andamiro.dao.subscribeMem.SubscribeMemberDAO;

public class SubmemDeleteAction implements SubscribeAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String subNumber = request.getParameter("subNumber");
		SubscribeMemberDAO sDao = SubscribeMemberDAO.getInstance();
		sDao.deleteSubmem(subNumber);
		String url = "/admin/subscribe/subscribeDeleteSuccess.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
