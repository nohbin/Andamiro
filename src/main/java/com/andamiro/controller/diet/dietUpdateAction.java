package com.andamiro.controller.diet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.DietAction;
import com.andamiro.dao.diet.DietDAO;
import com.andamiro.dto.diet.DietVO;

public class dietUpdateAction implements DietAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DietVO dVo= new DietVO();
		dVo.setDietNumber(Integer.parseInt(request.getParameter("dietNumber")));
		dVo.setDiet_kind(request.getParameter("diet_kind"));
		dVo.setDiet_menu(request.getParameter("diet_menu"));
		dVo.setDiet_picture(request.getParameter("diet_picture"));
		DietDAO dDao = DietDAO.getInstance();
		dDao.updateDiet(dVo);
		
		new dietListAction().excute(request, response);
	}

}
