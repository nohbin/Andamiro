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
		System.out.println("너도 일하냐?"+command);
		if(command.equals("recipe_write_form")) {
			action = new RecipeWriteForm();
		}else if(command.equals("recipe_write")) {
			action = new RecipeWriteAction();
		}else if(command.equals("recipe_list")) {
			action = new RecipeListAction();
		}else if(command.equals("recipe_detail")) {
			action = new RecipeDetailAction();
		}else if(command.equals("delete_recipe")) {
			action = new RecipeDeleteAction();
		}else if(command.equals("edit_recipe_form")) {
			action = new RecipeEditForm();
		}else if(command.equals("recipe_edit")) {
			action = new RecipeEditAction();
		}else if(command.equals("main_search")) {
			action = new SearchRecipeAction();
					
		}
		return action;
	}
}
