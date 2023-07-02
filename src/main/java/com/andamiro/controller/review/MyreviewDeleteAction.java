package com.andamiro.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.ReviewAction;
import com.andamiro.dao.review.ReviewDAO;

public class MyreviewDeleteAction implements ReviewAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		ReviewDAO rDao = ReviewDAO.getInstance();
		rDao.deleteMyreview(num);
		new MyreviewListAction().execute(request, response);
	
	}
}
