package com.andamiro.controller.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.ReviewAction;
import com.andamiro.dao.recipe.RecipeDAO;
import com.andamiro.dao.review.ReviewDAO;
import com.andamiro.dto.review.ReviewVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewWriteAction implements ReviewAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String realFolder = "C:\\upload\\img\\andamiro";
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
		String memberId = multi.getParameter("memberId");
		int recipeId = Integer.parseInt(multi.getParameter("recipeid"));
		
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setUserId(memberId);
		reviewVO.setRecipeId(recipeId);
		reviewVO.setReview(multi.getParameter("reviewtext"));
		reviewVO.setRecipegrade(Integer.parseInt(multi.getParameter("grade")));
		reviewVO.setImg(multi.getFilesystemName("reviewImage"));
		String recipename = multi.getParameter("recipename");
		
		reviewDAO.insertReview(memberId , recipeId , reviewVO , recipename);
		
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.updateRecipeGradeByRecipeId(recipeId);
		recipeDAO.updateReviewCountByRecipeId(recipeId);
		
		request.setAttribute("recipeId", recipeId);
		request.getRequestDispatcher("review/reviewwirtesuccess.jsp").forward(request, response);
	}

}
