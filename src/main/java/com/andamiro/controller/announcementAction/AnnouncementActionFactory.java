package com.andamiro.controller.announcementAction;

import com.andamiro.controller.action.AnnouncementAction;

public class AnnouncementActionFactory {
	public static AnnouncementActionFactory instance = new AnnouncementActionFactory();
	public AnnouncementActionFactory() {}
	public static AnnouncementActionFactory getInstance() {
		return instance;
	}
	public AnnouncementAction getAction(String command) {
		AnnouncementAction action = null;
		
		if(command.equals("announcement_list")) {
			action = new AnnouncementListAction();
		}else if(command.equals("announcement_write_form")) {
			action = new AnnouncementWriteFormAction();
		}else if(command.equals("announcement_write")) {
			action = new AnnouncementWriteAction();
		}
		
		
		
		
		
		return action;
	}
	
	
}
