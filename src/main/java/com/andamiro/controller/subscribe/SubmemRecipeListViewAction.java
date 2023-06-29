package com.andamiro.controller.subscribe;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.SubscribeAction;
import com.andamiro.dao.recipe.RecipeDAO;
import com.andamiro.dto.recipe.RecipeVO;

public class SubmemRecipeListViewAction implements SubscribeAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<RecipeVO> recipeList = RecipeDAO.getInstance().selectAllRecipeBySubNumber(Integer.parseInt(request.getParameter("subNumber")));
		
		request.setAttribute("recipeList", recipeList);
		
		request.getRequestDispatcher("member/mypage-savedrecipe.jsp").forward(request, response);
		
	}
}
