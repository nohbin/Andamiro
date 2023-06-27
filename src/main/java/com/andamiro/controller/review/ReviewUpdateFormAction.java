package com.andamiro.controller.review;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.ReviewAction;
import com.andamiro.dao.review.ReviewDAO;
import com.andamiro.dto.review.ReviewVO;

public class ReviewUpdateFormAction implements ReviewAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("execute() 실행!");
		String url = "/review/updatereview.jsp";
		String num = request.getParameter("num");
		ReviewDAO rDao = ReviewDAO.getInstance();
		ReviewVO rVo = rDao.selectOneBoradByNum(num);
		request.setAttribute("review", rVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
