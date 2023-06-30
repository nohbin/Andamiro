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

public class proteinLunchAction implements SubDietAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/diet/proteindiet_lunch.jsp";
		DietDAO dietDao = DietDAO.getInstance();
		DietDetailDAO dietDetailDao = DietDetailDAO.getInstance();

		//식단메뉴, 식단 사진 출력 
		List<DietVO> dietList = dietDao.selectProteinDiet();
		request.setAttribute("dietList", dietList);
		
		//식단음식명 출력(아침,점심,저녁 순)
		List<dietDetailVO> foodList73 = dietDetailDao.selectProteinFood1(); 
		List<dietDetailVO> foodList74 = dietDetailDao.selectProteinFood2();  
		List<dietDetailVO> foodList75 = dietDetailDao.selectProteinFood3();  
 		request.setAttribute("dietDetailList1",foodList73);  
 		request.setAttribute("dietDetailList2",foodList74);  
 		request.setAttribute("dietDetailList3",foodList75);  
 		
		//식단상세정보 출력
		List<dietDetailVO> dietdetailList = dietDetailDao.selectProteinLunchDetail();
 		request.setAttribute("dietDetailList", dietdetailList);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
