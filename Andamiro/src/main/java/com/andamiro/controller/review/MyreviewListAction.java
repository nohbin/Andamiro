package com.andamiro.controller.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andamiro.controller.action.ReviewAction;
import com.andamiro.dao.review.ReviewDAO;
import com.andamiro.dto.member.MemberVO;
import com.andamiro.dto.review.ReviewVO;

public class MyreviewListAction implements ReviewAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/review/review.jsp";
		ReviewDAO rDao = ReviewDAO.getInstance();
		HttpSession session = request.getSession();
		MemberVO memberVO =  (MemberVO) session.getAttribute("loginUser");
		String memberId = memberVO.getId();
		List<ReviewVO> reviewList = rDao.selectAllReviewsByMemberId(memberId);
		request.setAttribute("reviewList", reviewList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
