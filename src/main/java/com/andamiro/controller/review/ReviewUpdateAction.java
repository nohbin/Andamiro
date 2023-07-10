package com.andamiro.controller.review;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.action.ReviewAction;
import com.andamiro.dao.review.ReviewDAO;
import com.andamiro.dto.review.ReviewVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ReviewUpdateAction implements ReviewAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String realFolder = "C:\\upload\\img\\andamiro";
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
		int recipeId = Integer.parseInt(multi.getParameter("recipeid"));
		String review = multi.getParameter("review");
		int recipegrade = Integer.parseInt(multi.getParameter("recipegrade"));
		int reviewNum = Integer.parseInt(multi.getParameter("reviewnum"));
		ReviewDAO rDao = ReviewDAO.getInstance();
		ReviewVO rVo = rDao.selectOneReviewByReviewNum(reviewNum);
		
		String originalImg = rVo.getImg();
		String updateImg = multi.getFilesystemName("img");
		if(updateImg == null || updateImg.isEmpty()) {
			rVo.setImg(originalImg);
		}else {
			rVo.setImg(updateImg);
		}
		
		rVo.setReviewNum(reviewNum);
		rVo.setRecipeId(recipeId);
		rVo.setReview(review);
		rVo.setRecipegrade(recipegrade);
		rVo.setRegdate(new Timestamp(System.currentTimeMillis()));
		rDao.updateReviewByReviewNum(rVo , reviewNum);

		String url = "/ReviewServlet?command=myreview";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
