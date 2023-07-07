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

public class simpleDietDinnerAction implements SubDietAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/diet/simplediet_dinner.jsp";
		DietDAO dietDao = DietDAO.getInstance();
		DietDetailDAO dietDetailDao = DietDetailDAO.getInstance();

		//식단메뉴, 식단 사진 출력 
		List<DietVO> dietList = dietDao.selectSimpleDiet();
		request.setAttribute("dietList", dietList);
		
		//식단음식명 출력
		List<dietDetailVO> foodList79 = dietDetailDao.selectSimpleFood1(); 
		List<dietDetailVO> foodList80 = dietDetailDao.selectSimpleFood2();  
		List<dietDetailVO> foodList81 = dietDetailDao.selectSimpleFood3();  
 		request.setAttribute("dietDetailList1",foodList79);  
 		request.setAttribute("dietDetailList2",foodList80);  
 		request.setAttribute("dietDetailList3",foodList81);  
 		
		//식단상세정보 출력
		List<dietDetailVO> dietdetailList = dietDetailDao.selectSimpleDinnerDetail();
 		request.setAttribute("dietDetailList", dietdetailList);
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
