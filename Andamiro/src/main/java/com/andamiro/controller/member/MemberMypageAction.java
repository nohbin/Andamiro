package com.andamiro.controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.MemberAction;
import com.andamiro.dao.recipe.RecipeDAO;
import com.andamiro.dto.recipe.RecipeVO;

public class MemberMypageAction implements MemberAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		int memberNumber = Integer.parseInt(request.getParameter("memberNumber"));
		List<RecipeVO> recipeList = recipeDAO.selectAllRecipeByMemberNumber(memberNumber);
		
		
		
		String url = "/member/mypage.jsp";
		request.setAttribute("recipeList", recipeList);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
