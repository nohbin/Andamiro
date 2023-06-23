package com.andamiro.controller.diet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.DietAction;
import com.andamiro.dao.diet.DietDetailDAO;
import com.andamiro.dto.diet.dietDetailVO;

public class dietDetailUpdateAction implements DietAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			dietDetailVO ddVo = new dietDetailVO();
			ddVo.setDietDetailID(Integer.parseInt(request.getParameter("dietDetailID")));
			ddVo.setFoodName(request.getParameter("foodName"));
			ddVo.setKcal(request.getParameter("kcal"));
			ddVo.setComponent(request.getParameter("component"));
			DietDetailDAO ddDao = DietDetailDAO.getInstance();
			ddDao.updateDetail(ddVo);
			
			new dietDetailListAction().excute(request, response);
	}

}
