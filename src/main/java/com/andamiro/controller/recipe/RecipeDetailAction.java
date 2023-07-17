package com.andamiro.controller.recipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andamiro.controller.action.RecipeAction;
import com.andamiro.dao.recipe.RecipeDAO;
import com.andamiro.dao.review.ReviewDAO;
import com.andamiro.dto.recipe.RecipeIngreVO;
import com.andamiro.dto.recipe.RecipeOrderVO;
import com.andamiro.dto.recipe.RecipePicVO;
import com.andamiro.dto.recipe.RecipeVO;
import com.andamiro.dto.review.ReviewVO;

public class RecipeDetailAction implements RecipeAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		int recipID = Integer.parseInt(request.getParameter("recipID"));
		RecipeDAO recipDAO = RecipeDAO.getInstance();
//		Cookie[] cookies = request.getCookies();
//		Cookie viewCookie = null;
//		
//		if(cookies != null) {
//			for(int i = 0; i < cookies.length; i++) {
//				if(cookies[i].getName().equals("visited")) {
//					viewCookie = cookies[i];
//					System.out.println(cookies[i].getName());
//				}
//			}
//		}
//		
//		if(viewCookie == null) {
//			Cookie newCookie = new Cookie("visited", "OK");
//			response.addCookie(newCookie);
//			recipDAO.updateViewCount(recipID);
//		}
		
		HttpSession session = request.getSession();
		Integer viewCount = (Integer) session.getAttribute("viewCount");
		Set <Integer> visitedRecipes = (Set<Integer>)session.getAttribute("visitedRecipes");

		if (viewCount == null) {
		    viewCount = 1;
		} else {
		    viewCount++;
		}

		session.setAttribute("viewCount", viewCount);

		if (visitedRecipes == null) {
		    visitedRecipes = new HashSet<>();
		}

		if (!visitedRecipes.contains(recipID)) {
		    visitedRecipes.add(recipID);
		    session.setAttribute("visitedRecipes", visitedRecipes);
		    recipDAO.updateViewCount(recipID);
		}

		
		RecipeVO recipVO = recipDAO.selectOneRecipeByID(recipID);
		RecipeIngreVO recipeIngreVO = recipVO.getRecipeDetailVO().getRecipeingreVO();

		List<String> recipeIngreList = new ArrayList<>();
		if (recipeIngreVO != null) {
			for (int i = 1; i <= 12; i++) {
				String ingredient = getIngredientValue(recipeIngreVO, i);
				if (ingredient != null) {
					recipeIngreList.add(ingredient);
				}
			}
		}

		RecipePicVO recipePicVO = recipVO.getRecipeDetailVO().getRecipePicVO();
		List<String> recipePicList = new ArrayList<>();
		if (recipePicVO != null) {
			for (int i = 1; i <= 5; i++) {
				String recipePicture = getPictureValue(recipePicVO, i);
				if (recipePicture != null) {
					recipePicList.add(recipePicture);
				}
			}
		}

		RecipeOrderVO recipeOrderVO = recipVO.getRecipeDetailVO().getRecipeOrderVO();
		List<String> recipeOrderList = new ArrayList<>();
		if (recipeOrderVO != null) {
			for (int i = 0; i <= 5; i++) {
				String recipeOrder = getOrderValue(recipeOrderVO, i);
				if (recipeOrder != null) {
					recipeOrderList.add(recipeOrder);
				}
			}
		}
		
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		List<ReviewVO> reviewList = reviewDAO.selectAllReviewsByRecipeID(recipID);
		
		request.setAttribute("reviewList", reviewList);
		request.setAttribute("recipe", recipVO);
		request.setAttribute("recipeIngreList", recipeIngreList);
		request.setAttribute("recipePicList", recipePicList);
		request.setAttribute("recipeOrderList", recipeOrderList);
		String url = "recipe/recipe-detail.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	private String getOrderValue(RecipeOrderVO recipeOrderVO, int i) {
		switch (i) {
		case 1:
			return recipeOrderVO.getOrder01();
		case 2:
			return recipeOrderVO.getOrder02();
		case 3:
			return recipeOrderVO.getOrder03();
		case 4:
			return recipeOrderVO.getOrder04();
		case 5:
			return recipeOrderVO.getOrder05();
		default:
			return null;
		}
	}

	private String getPictureValue(RecipePicVO recipePicVo, int i) {
		switch (i) {
		case 1:
			return recipePicVo.getPic01();
		case 2:
			return recipePicVo.getPic02();
		case 3:
			return recipePicVo.getPic03();
		case 4:
			return recipePicVo.getPic04();
		case 5:
			return recipePicVo.getPic05();
		default:
			return null;
		}
	}

	private String getIngredientValue(RecipeIngreVO recipeIngreVO, int i) {
		switch (i) {
		case 1:
			return recipeIngreVO.getIngre01();
		case 2:
			return recipeIngreVO.getIngre02();
		case 3:
			return recipeIngreVO.getIngre03();
		case 4:
			return recipeIngreVO.getIngre04();
		case 5:
			return recipeIngreVO.getIngre05();
		case 6:
			return recipeIngreVO.getIngre06();
		case 7:
			return recipeIngreVO.getIngre07();
		case 8:
			return recipeIngreVO.getIngre08();
		case 9:
			return recipeIngreVO.getIngre09();
		case 10:
			return recipeIngreVO.getIngre10();
		case 11:
			return recipeIngreVO.getIngre11();
		case 12:
			return recipeIngreVO.getIngre12();
		default:
			return null;
		}
	}
}
