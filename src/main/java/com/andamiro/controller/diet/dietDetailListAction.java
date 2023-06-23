package com.andamiro.controller.diet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.DietAction;
import com.andamiro.dao.diet.DietDetailDAO;
import com.andamiro.dto.diet.dietDetailVO;

public class dietDetailListAction implements DietAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/admin/dietDetailList.jsp";
		String dietNumber = request.getParameter("dietNumber");
		DietDetailDAO ddDao = DietDetailDAO.getInstance();
//		dietDetailVO ddVo = ddDao.selectOneDietByDnum(dietNumber);
		
		List<dietDetailVO> dietDetailList = ddDao.selectAllboards();
		request.setAttribute("dietDetailList", dietDetailList);
		
//		request.setAttribute("dietDetail", ddVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
