package com.andamiro.controller.diet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.DietAction;
import com.andamiro.controller.admin.dietDetailListAction;
import com.andamiro.dao.diet.DietDetailDAO;

public class dietDetailDeleteAction implements DietAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dietDetailID = request.getParameter("dietDetailID");
		DietDetailDAO dietDetailDao = DietDetailDAO.getInstance();
		dietDetailDao.deleteDetail(dietDetailID);
		
		String url = "/AdminServlet?command=dietDetail_list&page=1";
		request.getRequestDispatcher(url).forward(request, response);	
	}

}
