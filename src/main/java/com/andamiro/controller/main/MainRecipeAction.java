package com.andamiro.controller.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.ReviewAction;
import com.andamiro.dao.review.ReviewRecipeDAO;
import com.andamiro.dto.review.ReviewRecipeVO;

public class MainRecipeAction implements ReviewAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/main.jsp";
		ArrayList<ReviewRecipeVO> bsetRecipeList = ReviewRecipeDAO.listBestRecipe();
		request.setAttribute("bsetRecipeList", bsetRecipeList);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
