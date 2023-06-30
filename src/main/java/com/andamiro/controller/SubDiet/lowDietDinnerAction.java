package com.andamiro.controller.SubDiet;

import java.io.IOException;
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

public class lowDietDinnerAction implements SubDietAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/diet/lowdiet_dinner.jsp";
		DietDAO dietDao = DietDAO.getInstance();
		DietDetailDAO dietDetailDao = DietDetailDAO.getInstance();

		//식단메뉴, 식단 사진 출력 
		List<DietVO> dietList = dietDao.selectLowDiet();
		request.setAttribute("dietList", dietList);
		
		//식단음식명 출력
		List<dietDetailVO> foodList70 = dietDetailDao.selectlowFood1(); 
		List<dietDetailVO> foodList71 = dietDetailDao.selectlowFood2();  
		List<dietDetailVO> foodList72 = dietDetailDao.selectlowFood3();  
 		request.setAttribute("dietDetailList1",foodList70);  
 		request.setAttribute("dietDetailList2",foodList71);  
 		request.setAttribute("dietDetailList3",foodList72);  
 		
		//식단상세정보 출력
		List<dietDetailVO> dietdetailList6 = dietDetailDao.selectDietDetail6();
 		request.setAttribute("dietDetailList6", dietdetailList6);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
