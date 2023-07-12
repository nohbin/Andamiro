package com.andamiro.controller.subscribe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.SubscribeAction;
import com.andamiro.dao.subscribeMem.SubscribeMemberDAO;

public class SubmemSaveRecipeAction implements SubscribeAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int subNumber = Integer.parseInt(request.getParameter("subNumber"));
		int recipeId = Integer.parseInt(request.getParameter("recipeid"));
				
		SubscribeMemberDAO subscribeMemberDAO = SubscribeMemberDAO.getInstance();
		subscribeMemberDAO.saveRecipeForSubmember(subNumber , recipeId);
		
		String url = "subscribe/saverecipe.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
