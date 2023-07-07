
package com.andamiro.controller.recipe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andamiro.controller.action.RecipeAction;
import com.andamiro.controller.member.MemberMypageAction;
import com.andamiro.dao.recipe.RecipeDAO;
import com.andamiro.dto.member.MemberVO;

public class RecipeDeleteAction implements RecipeAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		int recipeId = Integer.parseInt(request.getParameter("recipeId"));
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.deleteRecipeById(recipeId);
		
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("loginUser");
		if(memberVO.getAdminCode().equals("999")) {
			request.getRequestDispatcher("AdminServlet?command=recipe_list_view&page=1").forward(request, response);
		}else {
			new MemberMypageAction().excute(request, response);
		}
		
		
	}

}

