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
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class RecipeWriteAction implements RecipeAction {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		String realFolder = "C:\\upload\\img\\andamiro";
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		
		MemberVO userid = (MemberVO) session.getAttribute("loginUser");
		RecipeVO recipeVO = new RecipeVO();
		recipeVO.setMemberNumber(userid.getMemberNumber());
		recipeVO.setRecipeName(multi.getParameter("name"));
		recipeVO.setMainPicture(multi.getFilesystemName("mainpic"));
		recipeVO.setRecipetag1(multi.getParameter("tag1"));
		recipeVO.setRecipetag2(multi.getParameter("tag2"));
		recipeVO.setRecipetag3(multi.getParameter("tag3"));
		recipeVO.setUserId(multi.getParameter("userid"));

		RecipeDetailVO recipDetailVO = new RecipeDetailVO();
		recipDetailVO.setRecipeHow(Integer.parseInt(multi.getParameter("how")));
		recipDetailVO.setRecipeKind(Integer.parseInt(multi.getParameter("kind")));
		recipDetailVO.setRecipeMainIngre(Integer.parseInt(multi.getParameter("mainIngre")));
		recipDetailVO.setRecipeforperson(multi.getParameter("person"));
		recipDetailVO.setRecipefortime(multi.getParameter("time"));
		recipDetailVO.setRecipeforlevel(multi.getParameter("level"));
		recipDetailVO.setRecipeDiscription(multi.getParameter("discription"));
		
		//사진 업로드 관련
		RecipePicVO recipePicVO = new RecipePicVO();
		for (int i = 1; i <= 5; i++) {
			String parameterName = "pic" + i;
			String parameterValue = multi.getFilesystemName(parameterName);
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
			String parameterValue = multi.getParameter(parameterName);
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
			String parameterValue = multi.getParameter(parameterName);
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
		recipeDAO.registRecipe(recipeVO);

		String url = "recipe/recipeRegSuccess.jsp";
		request.getRequestDispatcher(url).forward(request, response);

	}
}
