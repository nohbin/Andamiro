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
		
		int memberNumber = Integer.parseInt(multi.getParameter("memberNumber"));
		int recipeId = Integer.parseInt(multi.getParameter("recipeid"));
		String recipename = multi.getParameter("recipename");
		System.out.println("recipeID : " + recipeId);
		
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		
		ReviewVO reviewVO = new ReviewVO();
		reviewVO.setMemberNumber(memberNumber);
		reviewVO.setRecipeId(recipeId);
		reviewVO.setReview(multi.getParameter("reviewtext"));
		reviewVO.setRecipegrade(Integer.parseInt(multi.getParameter("grade")));
		reviewVO.setReviewPicture(multi.getFilesystemName("reviewImage"));
		reviewVO.setRecipeName(recipename);
		
		
		reviewDAO.insertReview(reviewVO);
		
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.updateRecipeGradeByRecipeId(recipeId);
		recipeDAO.updateReviewCountByRecipeId(recipeId);
		
		request.setAttribute("recipeId", recipeId);
		request.getRequestDispatcher("review/reviewwirtesuccess.jsp").forward(request, response);
	}

}
