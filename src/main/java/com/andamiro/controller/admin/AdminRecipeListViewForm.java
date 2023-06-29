package com.andamiro.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.AdminAction;
import com.andamiro.dao.board.BoardDAO;
import com.andamiro.dao.member.MemberDAO;
import com.andamiro.dao.recipe.RecipeDAO;
import com.andamiro.dto.member.MemberVO;
import com.andamiro.dto.recipe.RecipeVO;

public class AdminRecipeListViewForm implements AdminAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		RecipeDAO recipeDAO = RecipeDAO.getInstance();

		String tempPage = request.getParameter("page");
		int currentPage = 0;
		if (tempPage == null || tempPage.length() == 0) {
			currentPage = 1;
		}
		currentPage = Integer.parseInt(tempPage);

		BoardDAO boardDAO = BoardDAO.getInstance();
		int totalRows = boardDAO.getTotalRowsRecipe();
		// 페이지에 나타낼 row 값
		int pageLength = 5;
		int currentBlock = currentPage % pageLength == 0 ? currentPage / pageLength : (currentPage / pageLength) + 1;
		int startPage = (currentBlock - 1) * pageLength + 1;
		int endPage = startPage + pageLength - 1;
		int totalPages = totalRows % pageLength == 0 ? totalRows / pageLength : (totalRows / pageLength) + 1;

		if (endPage > totalPages) {
			endPage = totalPages;
		}

		if (totalPages == 0) {
			totalPages = 1;
		}
		if (currentPage > totalPages) {
			currentPage = 1;
		}
		int start = ((currentPage - 1) * pageLength) + 1;
		int end = start + pageLength - 1;

		List<RecipeVO> recipeList = recipeDAO.selectRecipeByPage(start, end);

		request.setAttribute("totalRows", totalRows);
		request.setAttribute("recipeList", recipeList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalPages", totalPages);

		String url = "/admin/recipe/adminrecipepage.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
