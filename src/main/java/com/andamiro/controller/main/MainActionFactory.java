package com.andamiro.controller.main;

import com.andamiro.controller.action.MainAction;

public class MainActionFactory {
	public static MainActionFactory instance = new MainActionFactory();
	
	private MainActionFactory() {}
	
	public static MainActionFactory getInstance() {
		return instance;
	}
	
	public MainAction getAction(String command) {
		MainAction action = null;
		if (command.equals("recipe_search")) {
			action = new MainSearchAction();
		}
		
		return action;
	}
}
