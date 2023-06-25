package com.andamiro.controller.review;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.ReviewAction;
import com.andamiro.dao.recipe.RecipeDAO;
import com.andamiro.dao.review.ReviewRecipeDAO;
import com.andamiro.dto.recipe.RecipeVO;

public class MainAction implements ReviewAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/main.jsp";
		RecipeDAO recipeDao = RecipeDAO.getInstance();
		ArrayList<RecipeVO> bsetRecipeList = ReviewRecipeDAO.listBestRecipe();
		request.setAttribute("bsetRecipeList", bsetRecipeList);
	
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
