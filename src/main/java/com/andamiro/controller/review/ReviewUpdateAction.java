package com.andamiro.controller.review;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.ReviewAction;
import com.andamiro.dao.review.ReviewDAO;
import com.andamiro.dto.review.ReviewVO;

public class ReviewUpdateAction implements ReviewAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("excute실행" ); 
		int num = Integer.parseInt(request.getParameter("num"));
	        String review = request.getParameter("review");
	        int recipegrade = Integer.parseInt(request.getParameter("recipegrade"));
	        String img = request.getParameter("img");
	        ReviewVO rVo = new ReviewVO();
	        rVo.setNum(num);
	        rVo.setReview(review);
	        rVo.setRecipegrade(recipegrade);
	        rVo.setJoindate(new Timestamp(System.currentTimeMillis()));
	        rVo.setImg(img);
	        ReviewDAO rDao = ReviewDAO.getInstance();
	        rDao.updateReview(rVo);
	        new MyreviewListAction().execute(request, response);
	}

}
