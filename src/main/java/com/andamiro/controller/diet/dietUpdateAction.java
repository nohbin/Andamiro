package com.andamiro.controller.diet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.DietAction;
import com.andamiro.controller.admin.dietListAction;
import com.andamiro.dao.diet.DietDAO;
import com.andamiro.dto.diet.DietVO;

public class dietUpdateAction implements DietAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		dietVo.setDietNumber(Integer.parseInt(request.getParameter("dietNumber")));
//		dietVo.setDiet_kind(request.getParameter("diet_kind"));
//		dietVo.setDiet_menu(request.getParameter("diet_menu"));
//		dietVo.setDiet_picture(request.getParameter("diet_picture"));
//		dietDao.updateDiet(dietVo);
//		DietVO dietVo= new DietVO();
//		DietDAO dietDao = DietDAO.getInstance();
		
		//dietDao.selectOneDietByDnum(int dietNumber)

		int dietNumber = Integer.parseInt(request.getParameter("dietNumber"));
		String diet_kind = request.getParameter("diet_kind");
		String diet_menu = request.getParameter("diet_menu");
		String diet_picture = request.getParameter("diet_picture");
		
		DietVO dietVo= new DietVO();
		dietVo.setDietNumber(dietNumber);
		dietVo.setDiet_kind(diet_kind);
		dietVo.setDiet_menu(diet_menu);
		dietVo.setDiet_picture(diet_picture);
		DietDAO dietDao = DietDAO.getInstance();
		dietDao.updateDietBydietNum(dietVo, dietNumber);
		
		String url = "/AdminServlet?command=diet_list&page=1";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
