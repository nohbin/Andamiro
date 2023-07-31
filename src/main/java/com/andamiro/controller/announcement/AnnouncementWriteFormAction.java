package com.andamiro.controller.announcement;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.AnnouncementAction;

public class AnnouncementWriteFormAction implements AnnouncementAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "/announcement/announcemenwrite.jsp";
		request.getRequestDispatcher(url).forward(request, response);

	}

}
