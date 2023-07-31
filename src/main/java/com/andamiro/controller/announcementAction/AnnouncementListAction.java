package com.andamiro.controller.announcementAction;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andamiro.controller.action.AnnouncementAction;
import com.andamiro.dao.Announcement.AnnouncementDAO;
import com.andamiro.dto.Announcement.AnnouncementVO;
import com.andamiro.dto.member.MemberVO;
import com.andamiro.utill.PagingUtil;

public class AnnouncementListAction implements AnnouncementAction {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String url = "/announcement/announcementlist.jsp";
        AnnouncementDAO annDao = AnnouncementDAO.getInstance();
        // 전체 게시글 수 조회
        int total = annDao.getAnnouncementCount();
        int nowPage = 1; // 현재 페이지 번호 (기본값은 1로 설정)
        int perPage = 10; // 한 페이지당 보여질 게시글 수 (예시: 10)

        // 요청 파라미터에서 현재 페이지 번호(nowPage)를 받아와 설정
        String pageParam = request.getParameter("nowPage");
        if (pageParam != null && !pageParam.isEmpty()) {
            nowPage = Integer.parseInt(pageParam);
        }
        // PagingUtil 객체 생성
        PagingUtil pagingUtil = new PagingUtil(total, nowPage, perPage);

        // 한 페이지당 게시글 시작 번호와 종료 번호 가져오기
        int start = pagingUtil.getStart();
        int end = pagingUtil.getEnd();

        // 공지사항 게시글 조회
        List<AnnouncementVO> annList = annDao.selectAnnouncementList(start, end);
        request.setAttribute("annList", annList);
        request.setAttribute("pagingUtil", pagingUtil);
        
      

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
        
    }
}
