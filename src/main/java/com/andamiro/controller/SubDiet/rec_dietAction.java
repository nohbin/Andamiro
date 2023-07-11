package com.andamiro.controller.SubDiet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.andamiro.controller.action.SubDietAction;
import com.andamiro.dao.diet.DietDAO;
import com.andamiro.dao.diet.DietDetailDAO;
import com.andamiro.dto.diet.DietVO;
import com.andamiro.dto.diet.dietDetailVO;
import com.andamiro.dto.member.MemberVO;
import com.andamiro.dto.subscribeMem.SubscribeMemberVO;

public class rec_dietAction implements SubDietAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {	
		String url = "/diet/recdiet.jsp";
		DietDAO dietDao = DietDAO.getInstance();
		DietDetailDAO dietDetailDao = DietDetailDAO.getInstance();
		
		
		//식단 출력 (메뉴, 사진)
		List<DietVO> dietList = dietDao.selectRecDiet();
		request.setAttribute("dietList", dietList);
		
		//음식명 출력
		List<dietDetailVO> foodList76 = dietDetailDao.selectfoodName1(); 
		List<dietDetailVO> foodList77 = dietDetailDao.selectfoodName2();  
		List<dietDetailVO> foodList78 = dietDetailDao.selectfoodName3();  
 		request.setAttribute("dietDetailList1",foodList76);  
 		request.setAttribute("dietDetailList2",foodList77);  
 		request.setAttribute("dietDetailList3",foodList78);  
	
 		//식단 상세정보 출력
 		List<dietDetailVO> dietdetailList = dietDetailDao.selectDietDetail1();
 		request.setAttribute("dietDetailList", dietdetailList);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}	

}
