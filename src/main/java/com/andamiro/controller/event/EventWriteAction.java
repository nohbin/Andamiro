package com.andamiro.controller.event;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.dao.event.EventDAO;
import com.andamiro.dto.event.EventVO;
import com.andamiro.dto.recipe.RecipeVO;

public class EventWriteAction implements Action {

    @Override
    public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int eventno = Integer.parseInt(request.getParameter("eventno"));
        String eventkind = request.getParameter("eventkind");
        String term = request.getParameter("term");
        String ing = request.getParameter("ing");
        String imgsum = request.getParameter("imgsum");
        String poster = request.getParameter("poster");

        EventVO eventVO = new EventVO();
        eventVO.setEventno(eventno);
        eventVO.setEventkind(eventkind);
        eventVO.setTerm(term);
        eventVO.setIng(ing);
        eventVO.setImgsum(imgsum);
        eventVO.setPoster(poster);

        RecipeVO recipeVO = new RecipeVO();
        recipeVO.setRecipeCompetition(eventno);
        
     

        EventDAO eventDAO = EventDAO.getInstance();
        eventDAO.insertEvent(eventVO);
      
        new EventListAction().excute(request, response);
    }
}

