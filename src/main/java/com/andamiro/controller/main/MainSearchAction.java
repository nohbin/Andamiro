package com.andamiro.controller.main;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.MainAction;
import com.andamiro.dao.main.SearchDAO;
import com.andamiro.dto.search.SearchVO;

public class MainSearchAction implements MainAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/search/searchlist.jsp";
		SearchDAO sDao = SearchDAO.getInstance();
		ArrayList<SearchVO> searchList = sDao.searchResult(url);
		request.setAttribute("searchList", searchList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
