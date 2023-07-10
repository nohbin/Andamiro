package com.andamiro.controller.diet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.DietAction;
import com.andamiro.controller.admin.dietListAction;
import com.andamiro.dao.diet.DietDAO;

public class dietDeleteAction implements DietAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dietNumber = request.getParameter("dietNumber");
		DietDAO dietDao = DietDAO.getInstance();
		dietDao.deleteDiet(dietNumber);
		
		String url = "/AdminServlet?command=diet_list&page=1";
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
