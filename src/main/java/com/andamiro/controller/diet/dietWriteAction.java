package com.andamiro.controller.diet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.DietAction;
import com.andamiro.controller.admin.dietListAction;
import com.andamiro.dao.diet.DietDAO;
import com.andamiro.dto.diet.DietVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class dietWriteAction implements DietAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//원래 소스 
//		DietVO dietVo = new DietVO();
//		dietVo.setDiet_kind(request.getParameter("diet_kind"));
//		dietVo.setDiet_menu(request.getParameter("diet_menu"));
//		dietVo.setDiet_picture(request.getParameter("diet_picture"));
//		
//		DietDAO dDao = DietDAO.getInstance();
//		dDao.insertDiet(dietVo);
//		
//		new dietListAction().excute(request, response);
//		
		request.setCharacterEncoding("UTF-8");
		String realFolder = "C:\\upload\\img\\anadamiro";
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
		DietVO dietVo = new DietVO();
		dietVo.setDiet_kind(multi.getParameter("diet_kind"));
		dietVo.setDiet_menu(multi.getParameter("diet_menu"));
		dietVo.setDiet_picture(multi.getFilesystemName("diet_picture"));
		
		DietDAO dDao = DietDAO.getInstance();
		dDao.insertDiet(dietVo);
		
//		new dietListAction().excute(request, response);
		String url = "/admin/diet/dietWriteSuccess.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
