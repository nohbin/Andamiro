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
		}
		
		return action;
	}
}
