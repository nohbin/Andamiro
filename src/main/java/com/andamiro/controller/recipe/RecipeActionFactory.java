package com.andamiro.controller.recipe;

import com.andamiro.controller.action.RecipeAction;

public class RecipeActionFactory {
	private static RecipeActionFactory instance = new RecipeActionFactory();
	private RecipeActionFactory() {};
	
	public static RecipeActionFactory getInstance() {
		return instance;
	}
	
	public RecipeAction getAction(String command) {
		RecipeAction action = null;
		
		if(command.equals("recipe_write_form")) {
			action = new RecipeWriteForm();
		}else if(command.equals("recipe_write")) {
			action = new RecipeWriteAction();
		}else if(command.equals("recipe_list")) {
			action = new RecipeListAction();
		}else if(command.equals("recipe_detail")) {
			action = new RecipeDetailAction();
		}
		return action;
	}
}
