package com.andamiro.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.ReviewAction;
import com.andamiro.dao.recipe.RecipeDAO;
import com.andamiro.dao.review.ReviewDAO;
import com.andamiro.dto.review.ReviewVO;

public class ReviewWriteAction implements ReviewAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberId = request.getParameter("memberId");
		int recipeId = Integer.parseInt(request.getParameter("recipeid"));
		
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setUserId(memberId);
		reviewVO.setRecipeId(recipeId);
		reviewVO.setReview(request.getParameter("reviewtext"));
		reviewVO.setRecipegrade(Integer.parseInt(request.getParameter("grade")));
		reviewVO.setImg(request.getParameter("reviewImage"));
		String recipename = request.getParameter("recipename");
		
		reviewDAO.insertReview(memberId , recipeId , reviewVO , recipename);
		
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.updateRecipeGradeByRecipeId(recipeId);
		recipeDAO.updateReviewCountByRecipeId(recipeId);
		
		request.setAttribute("recipeId", recipeId);
		request.getRequestDispatcher("review/reviewwirtesuccess.jsp").forward(request, response);
	}

}
