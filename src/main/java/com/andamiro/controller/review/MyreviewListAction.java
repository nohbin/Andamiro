package com.andamiro.controller.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.ReviewAction;
import com.andamiro.dao.review.ReviewDAO;
import com.andamiro.dto.review.ReviewVO;

public class MyreviewListAction implements ReviewAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/review/review.jsp";
		ReviewDAO rDao = ReviewDAO.getInstance();
		List<ReviewVO> reviewList = rDao.selectAllReviews();
		request.setAttribute("reviewList", reviewList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
