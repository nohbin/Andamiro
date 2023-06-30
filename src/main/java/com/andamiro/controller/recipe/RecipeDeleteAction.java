package com.andamiro.controller.recipe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.RecipeAction;
import com.andamiro.controller.member.MemberMypageAction;
import com.andamiro.dao.recipe.RecipeDAO;

public class RecipeDeleteAction implements RecipeAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		int recipeId = Integer.parseInt(request.getParameter("recipeId"));
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.deleteRecipeById(recipeId);
		new MemberMypageAction().excute(request, response);
				
	}

}
