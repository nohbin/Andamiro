package com.andamiro.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.AdminAction;

public class AdminMainForm implements AdminAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String url = "/admin/adminmainpage.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
