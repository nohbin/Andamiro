package com.andamiro.controller.diet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.DietAction;
import com.andamiro.controller.admin.dietDetailListAction;
import com.andamiro.dao.diet.DietDetailDAO;
import com.andamiro.dto.diet.dietDetailVO;

public class dietDetailUpdateAction implements DietAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//			dietDetailVO dietDetailVo = new dietDetailVO();
//			dietDetailVo.setDietDetailID(Integer.parseInt(request.getParameter("dietDetailID")));
//			dietDetailVo.setFoodName(request.getParameter("foodName"));
//			dietDetailVo.setKcal(request.getParameter("kcal"));
//			dietDetailVo.setComponent(request.getParameter("component"));
//			DietDetailDAO ddDao = DietDetailDAO.getInstance();
//			ddDao.updateDetail(dietDetailVo);
//			
//			new dietDetailListAction().excute(request, response);
			
			int dietDetailID = Integer.parseInt(request.getParameter("dietDetailID"));
			String foodName = request.getParameter("foodName");
			String kcal = request.getParameter("kcal");
			String component = request.getParameter("component");
			
			dietDetailVO dietDetailVo = new dietDetailVO();
			dietDetailVo.setDietDetailID(dietDetailID);
			dietDetailVo.setFoodName(foodName);
			dietDetailVo.setKcal(kcal);
			dietDetailVo.setComponent(component);
			DietDetailDAO dietDetailDao = DietDetailDAO.getInstance();
			dietDetailDao.updateDietDetailByID(dietDetailVo, dietDetailID);
			
			String url = "/AdminServlet?command=dietDetail_list&page=1";
			request.getRequestDispatcher(url).forward(request, response);	
		
	}

}
