package com.andamiro.controller.diet;

import com.andamiro.controller.action.DietAction;

public class DietActionFactory {
	private static DietActionFactory instance = new DietActionFactory();
	private DietActionFactory() {};
	
	public static DietActionFactory getInstance() {
		return instance;
		
	}
	
	public DietAction getAction(String command) {
		DietAction action = null;
		
		if(command.equals("diet_write_form")) {
			action = new dietWriteFormAction();
		} else if(command.equals("diet_write")) {
			action = new dietWriteAction();
		}  else if(command.equals("diet_view")) {
			action = new dietViewAction();
		} else if(command.equals("diet_delete")) {
			action = new dietDeleteAction();
		} else if(command.equals("diet_update_form")) {
			action = new dietUpdateFormAction();
		} else if(command.equals("diet_update")) {
			action = new dietUpdateAction();
		} else if(command.equals("dietDetail_write_form")) {
			action = new dietDetailWriteFormAction();
		} else if(command.equals("dietDetail_write")) {
			action = new dietDetailWriteAction();
		} else if(command.equals("dietDetail_view")) {
			action = new dietDetailViewAction();
		} else if(command.equals("dietDetail_delete")) {
			action = new dietDetailDeleteAction();
		} else if(command.equals("dietDetail_update_form")) {
			action = new dietDetailUpdateFormAction();
		} else if(command.equals("dietDetail_update")) {
			action = new dietDetailUpdateAction();
		}
		
		return action;
	}
}
