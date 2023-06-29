package com.andamiro.controller.recipe;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.RecipeAction;
import com.andamiro.dao.recipe.RecipeDAO;
import com.andamiro.dto.recipe.RecipeHowVO;
import com.andamiro.dto.recipe.RecipeKindVO;
import com.andamiro.dto.recipe.RecipeMainIngreVO;

public class RecipeWriteForm implements RecipeAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String url = "/recipe/recipe-reg.jsp";
		
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		List<RecipeKindVO> recipeKindList = recipeDAO.selectAllRecipeKind();
		List<RecipeHowVO> recipeHowList = recipeDAO.selectAllRecipeHow();
		List<RecipeMainIngreVO> recipeMainIngreList = recipeDAO.selectAllRecipeMainIngre();
		
		
		request.setAttribute("recipeKindList", recipeKindList);
		request.setAttribute("recipeHowList", recipeHowList);
		request.setAttribute("recipeMainIngreList", recipeMainIngreList);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
