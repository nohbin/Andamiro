package com.andamiro.controller.diet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.DietAction;
import com.andamiro.dao.diet.DietDetailDAO;
import com.andamiro.dto.diet.dietDetailVO;

public class dietDetailViewAction implements DietAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/diet/dietDetailView.jsp";
		String dietDetailID = request.getParameter("dietDetailID");
		DietDetailDAO dietDetailDao = DietDetailDAO.getInstance();
		dietDetailVO dietDetailVo = dietDetailDao.selectOneDetailById(dietDetailID);
		request.setAttribute("dietDetail", dietDetailVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
