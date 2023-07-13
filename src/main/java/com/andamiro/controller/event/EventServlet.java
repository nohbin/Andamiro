package com.andamiro.controller.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EventServlet")
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 요청시 보낸 파라미터 command 값을 얻어온다.
		String command = request.getParameter("command");
		// 파라미터 command 값이 제대로 전달되었는지 확인차 출력
		System.out.println("요청확인" + command);

		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);

		if (action != null) {
			action.excute(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post 방식으로 요청시 한글 깨짐을 방지하기 위한 코드 추가
		request.setCharacterEncoding("UTF-8");
		// post 방식으로 요청되어도 doGet()를 호출하도록 하여
		// doGet()에서만 요청에 대한 처리를 한다.
		doGet(request, response);
	}
}