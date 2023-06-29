package com.andamiro.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.BoardAction;
import com.andamiro.dao.board.BoardDAO;
import com.andamiro.dao.member.MemberDAO;
import com.andamiro.dto.member.MemberVO;

public class BoardPagingRecipeAction implements BoardAction{

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		
		String tempPage = request.getParameter("page");
		int currentPage = 0;
		if(tempPage == null || tempPage.length() == 0) {
			currentPage = 1;
		}
		currentPage = Integer.parseInt(tempPage);
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		int totalRows = boardDAO.getTotalRowsMember();
		// 페이지에 나타낼 row 값
		int pageLength = 5;
		int currentBlock = currentPage % pageLength == 0 ? currentPage / pageLength : (currentPage / pageLength) + 1;
		int startPage = (currentBlock-1) * pageLength+1;
		int endPage= startPage + pageLength - 1;
		int totalPages = totalRows % pageLength == 0? totalRows/pageLength : (totalRows/pageLength) +1;
		
		if(endPage> totalPages) {
			endPage = totalPages;
		}
		
		if(totalPages==0) {
			totalPages = 1;
		}
		if(currentPage > totalPages) {
			currentPage = 1;
		}
		int start = ((currentPage - 1) * pageLength) + 1;
		int end = start + pageLength -1;
		
		List<MemberVO> memberList = memberDAO.selectMemberByPage(start , end);
		
		request.setAttribute("totalRows", totalRows);
		request.setAttribute("memberList", memberList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalPages", totalPages);
		
		String url = "/admin/adminmainpage.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
