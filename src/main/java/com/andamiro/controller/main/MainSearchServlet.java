package com.andamiro.controller.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.andamiro.controller.action.MainAction;


@WebServlet("/MainSearchServlet")
public class MainSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println("서블릿으로 부터 받음" + command);
		
		MainActionFactory af = MainActionFactory.getInstance();
		MainAction action = af.getAction(command);
	   System.out.println(action);
		if(action != null) {
			action.execute(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
