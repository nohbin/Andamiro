package com.andamiro.controller.subscribe;

import com.andamiro.controller.action.SubscribeAction;

public class SubscirbeActionFactory {
	private static SubscirbeActionFactory instance = new SubscirbeActionFactory();
	private SubscirbeActionFactory() {};
	
	public static SubscirbeActionFactory getInstance() {
		return instance;
	}
	
	public SubscribeAction getAction(String command) {
		SubscribeAction action = null;
		
		if(command.equals("sub_join")) {
			action = new SubJoinAction();
		} else if(command.equals("submem_view")) {
			action = new SubmemViewAction();
		} else if(command.equals("submem_delete")) {
			action = new SubmemDeleteAction();
		} else if(command.equals("save_recipe")) {
			action = new SubmemSaveRecipeAction();
		} else if(command.equals("save_recipe_view")){
			action = new SubmemRecipeListViewAction();
		}
				
				
		
		return action;
	}
}
