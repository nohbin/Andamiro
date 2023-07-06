package com.andamiro.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.AdminAction;
import com.andamiro.dao.recipe.RecipeDAO;
import com.andamiro.dto.recipe.RecipeVO;

public class AdminRecipeDetailEditForm implements AdminAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		int recipeId = Integer.parseInt(request.getParameter("recipeid"));
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		RecipeVO recipeVO = recipeDAO.selectOneRecipeByID(recipeId);
		
		request.setAttribute("recipe", recipeVO);
		
		String url = "/admin/recipe/adminrecipeedit.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
		
		
	}

}
