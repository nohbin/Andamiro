package com.andamiro.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.dao.review.ReviewRecipeDAO;
import com.andamiro.dto.review.ReviewRecipeVO;

public class MainRecipeAction implements ReviewAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/main.jsp";
		ReviewRecipeDAO rDao = ReviewRecipeDAO.getInstance();
		ArrayList<ReviewRecipeVO> bsetRecipeList = rDao.listBestRecipe();
		request.setAttribute("bsetRecipeList", bsetRecipeList);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
