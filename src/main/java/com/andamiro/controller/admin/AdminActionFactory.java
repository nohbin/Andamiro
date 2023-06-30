package com.andamiro.controller.admin;

import com.andamiro.controller.action.AdminAction;

public class AdminActionFactory {

	private static AdminActionFactory instance = new AdminActionFactory();
	private AdminActionFactory() {};
	public static AdminActionFactory getInstance() {
		return instance;
	}

	public AdminAction getAction(String command) {
		AdminAction action = null;
		if(command.equals("admin_main_view")) {
			action = new AdminMainForm();
		}else if(command.equals("recipe_list_view")) {
			action = new AdminRecipeListViewForm();
		}else if(command.equals("submem_list")) {
			action = new SubmemListAction();
		}
		
		return action;
	}
	
}
