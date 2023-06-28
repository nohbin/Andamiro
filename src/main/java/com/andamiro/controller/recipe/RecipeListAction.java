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
import com.andamiro.dto.recipe.RecipeVO;

public class RecipeListAction implements RecipeAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		List<RecipeVO> recipeList = null;
		
		if(request.getParameter("mainingre") != null) {
			int mainIngre = Integer.parseInt(request.getParameter("mainingre"));
			recipeList = recipeDAO.selectAllRecipeByMainIngre(mainIngre);
			System.out.println(mainIngre);
		}else if(request.getParameter("how")!=null) {
			int how = Integer.parseInt(request.getParameter("how"));
			recipeList = recipeDAO.selectAllRecipeByHow(how);
		}else if(request.getParameter("kind")!=null) {
			int kind = Integer.parseInt(request.getParameter("kind"));
			recipeList = recipeDAO.selectAllRecipeByKind(kind);
		}else {
			recipeList = recipeDAO.selectAllRecipe();
		}
		
		List<RecipeKindVO> recipeKindList = recipeDAO.selectAllRecipeKind();
		List<RecipeHowVO> recipeHowList = recipeDAO.selectAllRecipeHow();
		List<RecipeMainIngreVO> recipeMainIngreList = recipeDAO.selectAllRecipeMainIngre();
		
		
		request.setAttribute("recipeKindList", recipeKindList);
		request.setAttribute("recipeHowList", recipeHowList);
		request.setAttribute("recipeMainIngreList", recipeMainIngreList);
		String url = "/recipe/recipe-list.jsp";
		request.setAttribute("recipeList", recipeList);
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}
