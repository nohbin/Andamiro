package com.andamiro.controller.diet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.DietAction;
import com.andamiro.controller.admin.dietListAction;
import com.andamiro.dao.diet.DietDAO;
import com.andamiro.dto.diet.DietVO;

public class dietWriteAction implements DietAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DietVO dietVo = new DietVO();
//		dVo.setSubNumber(Integer.parseInt(request.getParameter("subNumber")));
		dietVo.setDiet_kind(request.getParameter("diet_kind"));
		dietVo.setDiet_menu(request.getParameter("diet_menu"));
		dietVo.setDiet_picture(request.getParameter("diet_picture"));
		
		DietDAO dDao = DietDAO.getInstance();
		dDao.insertDiet(dietVo);
		
		new dietListAction().excute(request, response);
	}

}
