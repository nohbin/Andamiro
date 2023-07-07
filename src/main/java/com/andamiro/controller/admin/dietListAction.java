package com.andamiro.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.AdminAction;
import com.andamiro.dao.board.BoardDAO;
import com.andamiro.dao.diet.DietDAO;
import com.andamiro.dto.diet.DietVO;

public class dietListAction implements AdminAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DietDAO dietDao = DietDAO.getInstance();
		
		String tempPage = request.getParameter("page");
		int currentPage = 0;
		if(tempPage == null || tempPage.length() == 0) {
			currentPage = 1;
		}
		
		currentPage = Integer.parseInt(tempPage);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		int totalRows = boardDAO.getTotalRowsDiet();
		
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
		
		
//		List<DietVO> dietList = dietDao.selectAllboards();
		List<DietVO> dietList = dietDao.selectDietBypage(start,end);
		request.setAttribute("totalRows", totalRows);
		request.setAttribute("dietList", dietList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalPages", totalPages);
		
		
		
		
		String url = "/admin/diet/dietList.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
