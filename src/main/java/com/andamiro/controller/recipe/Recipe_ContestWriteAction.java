package com.andamiro.controller.recipe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.andamiro.controller.action.RecipeAction;
import com.andamiro.dao.recipe.RecipeDAO;
import com.andamiro.dto.member.MemberVO;
import com.andamiro.dto.recipe.RecipeDetailVO;
import com.andamiro.dto.recipe.RecipeIngreVO;
import com.andamiro.dto.recipe.RecipeOrderVO;
import com.andamiro.dto.recipe.RecipePicVO;
import com.andamiro.dto.recipe.RecipeVO;

public class Recipe_ContestWriteAction implements RecipeAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    HttpSession session = request.getSession();
	    MemberVO userid = (MemberVO) session.getAttribute("loginUser");
	  
	    
	    RecipeVO recipeVO = new RecipeVO();
	    recipeVO.setMemberNumber(userid.getMemberNumber());
	    recipeVO.setRecipeName(request.getParameter("name"));
	    recipeVO.setMainPicture(request.getParameter("mainpic"));
	    recipeVO.setRecipetag1(request.getParameter("tag1"));
	    recipeVO.setRecipetag2(request.getParameter("tag2"));
	    recipeVO.setRecipetag3(request.getParameter("tag3"));
	    recipeVO.setUserId(request.getParameter("userid"));
	    recipeVO.setRecipeCompetition(Integer.parseInt(request.getParameter("eventno")));
	
		RecipeDetailVO recipDetailVO = new RecipeDetailVO();
		recipDetailVO.setRecipeHow(Integer.parseInt(request.getParameter("how")));
		recipDetailVO.setRecipeKind(Integer.parseInt(request.getParameter("kind")));
		recipDetailVO.setRecipeMainIngre(Integer.parseInt(request.getParameter("mainIngre")));
		recipDetailVO.setRecipeforperson(request.getParameter("person"));
		recipDetailVO.setRecipefortime(request.getParameter("time"));
		recipDetailVO.setRecipeforlevel(request.getParameter("level"));
		recipDetailVO.setRecipeDiscription(request.getParameter("discription"));

		RecipePicVO recipePicVO = new RecipePicVO();
		for (int i = 1; i <= 5; i++) {
			String parameterName = "pic" + i;
			String parameterValue = request.getParameter(parameterName);
			if (parameterValue != null) {
				switch (i) {
				case 1:
					recipePicVO.setPic01(parameterValue);
					break;
				case 2:
					recipePicVO.setPic02(parameterValue);
					break;
				case 3:
					recipePicVO.setPic03(parameterValue);
					break;
				case 4:
					recipePicVO.setPic04(parameterValue);
					break;
				case 5:
					recipePicVO.setPic05(parameterValue);
					break;
				}
			}
		}
		RecipeOrderVO recipeOrderVO = new RecipeOrderVO();
		for (int i = 1; i <= 5; i++) {
			String parameterName = "order" + i;
			String parameterValue = request.getParameter(parameterName);
			if (parameterValue != null) {
				switch (i) {
				case 1:
					recipeOrderVO.setOrder01(parameterValue);
					break;
				case 2:
					recipeOrderVO.setOrder02(parameterValue);
					break;
				case 3:
					recipeOrderVO.setOrder03(parameterValue);
					break;
				case 4:
					recipeOrderVO.setOrder04(parameterValue);
					break;
				case 5:
					recipeOrderVO.setOrder05(parameterValue);
					break;
				}
			}
		}
		RecipeIngreVO recipeIngreVO = new RecipeIngreVO();
		for (int i = 1; i <= 12; i++) {
			String parameterName = "ingre" + i;
			String parameterValue = request.getParameter(parameterName);
			if (parameterValue != null) {
				switch (i) {
				case 1:
					recipeIngreVO.setIngre01(parameterValue);
					break;
				case 2:
					recipeIngreVO.setIngre02(parameterValue);
					break;
				case 3:
					recipeIngreVO.setIngre03(parameterValue);
					break;
				case 4:
					recipeIngreVO.setIngre04(parameterValue);
					break;
				case 5:
					recipeIngreVO.setIngre05(parameterValue);
					break;
				case 6:
					recipeIngreVO.setIngre06(parameterValue);
					break;
				case 7:
					recipeIngreVO.setIngre07(parameterValue);
					break;
				case 8:
					recipeIngreVO.setIngre08(parameterValue);
					break;
				case 9:
					recipeIngreVO.setIngre09(parameterValue);
					break;
				case 10:
					recipeIngreVO.setIngre10(parameterValue);
					break;
				case 11:
					recipeIngreVO.setIngre11(parameterValue);
					break;
				case 12:
					recipeIngreVO.setIngre12(parameterValue);
					break;
				}
			}
		}

		recipDetailVO.setRecipePicVO(recipePicVO);
		recipDetailVO.setRecipeOrderVO(recipeOrderVO);
		recipDetailVO.setRecipeingreVO(recipeIngreVO);

		recipeVO.setRecipeDetailVO(recipDetailVO);
		
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		recipeDAO.contestRecipe(recipeVO);
		
		String url="recipe/recipeRegSuccess.jsp";
		request.getRequestDispatcher(url).forward(request, response); 
		
	}
}
