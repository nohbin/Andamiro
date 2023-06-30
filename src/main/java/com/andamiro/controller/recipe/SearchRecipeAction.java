package com.andamiro.controller.recipe;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.RecipeAction;
import com.andamiro.dao.recipe.RecipeDAO;
import com.andamiro.dto.recipe.RecipeVO;

public class SearchRecipeAction implements RecipeAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    String url = "/search/searchlist.jsp";
	    RecipeDAO mainSearchDao = RecipeDAO.getInstance();
        String recipename = request.getParameter("recipename");
        List<RecipeVO> searchList = mainSearchDao.searchRecipe(recipename);
        System.out.println("searchList 뭐있냐" + searchList);
        request.setAttribute("searchList", searchList);
        request.getRequestDispatcher(url).forward(request, response);

	}

}
