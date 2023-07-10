package com.andamiro.controller.diet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.DietAction;
import com.andamiro.controller.admin.dietDetailListAction;
import com.andamiro.dao.diet.DietDetailDAO;
import com.andamiro.dto.diet.dietDetailVO;

public class dietDetailWriteAction implements DietAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dietDetailVO dietDetailVo = new dietDetailVO();
		dietDetailVo.setDietNumber(Integer.parseInt(request.getParameter("dietNumber")));
		dietDetailVo.setFoodName(request.getParameter("foodName"));
		dietDetailVo.setKcal(request.getParameter("kcal"));
		dietDetailVo.setComponent(request.getParameter("component"));
		
		DietDetailDAO dietDetailDao = DietDetailDAO.getInstance();
		dietDetailDao.insertDetail(dietDetailVo);
		
		String url = "/AdminServlet?command=dietDetail_list&page=1";
		request.getRequestDispatcher(url).forward(request, response);	
	}

}
