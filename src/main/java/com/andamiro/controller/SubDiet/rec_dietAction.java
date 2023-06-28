package com.andamiro.controller.SubDiet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.SubDietAction;
import com.andamiro.dao.diet.DietDAO;
import com.andamiro.dao.diet.DietDetailDAO;
import com.andamiro.dto.diet.DietVO;
import com.andamiro.dto.diet.dietDetailVO;

public class rec_dietAction implements SubDietAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/diet/recdiet.jsp";
		DietDAO dietDao = DietDAO.getInstance();
		DietDetailDAO dietDetailDao = DietDetailDAO.getInstance();
		List<DietVO> dietList = dietDao.selectRecDiet();
		List<dietDetailVO> foodList76 = dietDetailDao.selectfoodName1();  //원래 메소드
		List<dietDetailVO> foodList77 = dietDetailDao.selectfoodName2();  //원래 메소드
		List<dietDetailVO> foodList78 = dietDetailDao.selectfoodName3();  //원래 메소드
 		request.setAttribute("dietList", dietList);
 		request.setAttribute("dietDetailList",foodList76);  //원래 메소드
 		request.setAttribute("dietDetailList2",foodList77);  //원래 메소드
 		request.setAttribute("dietDetailList3",foodList78);  //원래 메소드
 		
 		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}	

}
