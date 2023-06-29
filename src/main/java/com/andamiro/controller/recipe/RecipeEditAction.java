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

public class RecipeEditAction implements RecipeAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		MemberVO userid = (MemberVO) session.getAttribute("loginUser");
		int recipeId = Integer.parseInt(request.getParameter("recipeId"));
		RecipeDAO recipeDAO = RecipeDAO.getInstance();
		RecipeVO recipeVO = recipeDAO.selectOneRecipeByID(recipeId);
		recipeVO.setMemberNumber(userid.getMemberNumber());
		recipeVO.setRecipeID(Integer.parseInt(request.getParameter("recipeId")));
		recipeVO.setRecipeName(request.getParameter("name"));
		String mainPicture = recipeVO.getMainPicture();

		if (request.getParameter("mainpic").equals(null) || request.getParameter("mainpic").equals("")) {
			recipeVO.setMainPicture(mainPicture);
		} else {
			recipeVO.setMainPicture(request.getParameter("mainpic"));
		}
		recipeVO.setRecipetag1(request.getParameter("tag1"));
		recipeVO.setRecipetag2(request.getParameter("tag2"));
		recipeVO.setRecipetag3(request.getParameter("tag3"));

		RecipeDetailVO recipeDetailVO = recipeVO.getRecipeDetailVO();
		recipeDetailVO.setRecipeHow(Integer.parseInt(request.getParameter("how")));
		recipeDetailVO.setRecipeKind(Integer.parseInt(request.getParameter("kind")));
		recipeDetailVO.setRecipeMainIngre(Integer.parseInt(request.getParameter("mainIngre")));
		recipeDetailVO.setRecipeforperson(request.getParameter("person"));
		recipeDetailVO.setRecipefortime(request.getParameter("time"));
		recipeDetailVO.setRecipeforlevel(request.getParameter("level"));
		recipeDetailVO.setRecipeDiscription(request.getParameter("discription"));

		RecipePicVO recipePicVO = recipeDetailVO.getRecipePicVO();
		for (int i = 1; i <= 5; i++) {
			String parameterName = "pic" + i;
			if (request.getParameter(parameterName).equals(null) || request.getParameter(parameterName).equals("")) {
				recipePicVO = recipeDetailVO.getRecipePicVO();
			} else {
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
		}

		RecipeOrderVO recipeOrderVO = recipeDetailVO.getRecipeOrderVO();
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
		RecipeIngreVO recipeIngreVO = recipeDetailVO.getRecipeingreVO();
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
		recipeDetailVO.setRecipePicVO(recipePicVO);
		recipeDetailVO.setRecipeOrderVO(recipeOrderVO);
		recipeDetailVO.setRecipeingreVO(recipeIngreVO);
		recipeVO.setRecipeDetailVO(recipeDetailVO);
		
		recipeDAO.updateRecipeByRecipeid(recipeId, recipeVO);

		String url = "recipe/recipeRegSuccess.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
