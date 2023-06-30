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
		} else if(command.equals("rec_lunch")) {
			action = new rec_lunchAction();
		} else if(command.equals("rec_dinner")) {
			action = new rec_DinnerAction();
		} else if(command.equals("lowDiet")) {
			action = new lowDietAction();
		} else if(command.equals("lowDietLunch")) {
			action = new lowDietLunchAction();
		} else if(command.equals("lowDietDinner")) {
			action = new lowDietDinnerAction();
		} else if(command.equals("simpleDiet")) {
			action = new simpleDietAction();
		} else if(command.equals("simpleDietLunch")) {
			action = new simpleDietLunchAction();
		} else if(command.equals("simpleDietDinner")) {
			action = new simpleDietDinnerAction();
		} else if(command.equals("proteinDiet")) {
			action = new proteinDietAction();
		} else if(command.equals("proteinLunch")) {
			action = new proteinLunchAction();
		} else if(command.equals("proteinDinner")) {
			action = new proteinDinnerAction();
		}
		
		
		
		return action;
		}
	
}
