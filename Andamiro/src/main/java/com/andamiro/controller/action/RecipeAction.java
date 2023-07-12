package com.andamiro.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andamiro.controller.event.Action;

public interface RecipeAction extends Action {
	public void excute(HttpServletRequest request , HttpServletResponse response) throws IOException , ServletException;
}
