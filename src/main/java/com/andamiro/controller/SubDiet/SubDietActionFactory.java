package com.andamiro.controller.SubDiet;

import com.andamiro.controller.action.SubDietAction;

public class SubDietActionFactory {
	private static SubDietActionFactory instance = new SubDietActionFactory();
	private SubDietActionFactory() {};
	
	public static SubDietActionFactory getInstance() {
		return instance;
	}
	
	public SubDietAction getAction(String command) {
		SubDietAction action = null;
		
		if(command.equals("rec_diet")) {
			action = new rec_dietAction();
		}
		
		return action;
	}
}
