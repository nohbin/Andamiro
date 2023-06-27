package com.andamiro.controller.diet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.DietAction;
import com.andamiro.dao.diet.DietDAO;
import com.andamiro.dto.diet.DietVO;

public class dietViewAction implements DietAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/diet/dietView.jsp";
		String dietNumber = request.getParameter("dietNumber");
		DietDAO dDao = DietDAO.getInstance();
		DietVO dVo = dDao.selectOneDietBDnum(dietNumber);
		request.setAttribute("diet", dVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
