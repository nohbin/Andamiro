//package com.andamiro.controller.main;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.andamiro.controller.action.MainSearchAction;
//import com.andamiro.dao.MainSearchDAO;
//import com.andamiro.dto.main.MainSearchVO;
//
//public class MainNoSearchAction implements MainSearchAction {
//
//	@Override
//	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String url = "/search/nosearch.jsp";
//        MainSearchDAO mainSearchDao = MainSearchDAO.getInstance();
//        String recipename = request.getParameter("recipename");
//        String userid = request.getParameter("userid");
//        List<MainSearchVO> searchList = mainSearchDao.searchRecipe(recipename);
//        request.setAttribute("searchList", searchList);
//        System.out.println("서치리스트"+searchList);
//        request.getRequestDispatcher(url).forward(request, response);
//
//	}
//
//}
