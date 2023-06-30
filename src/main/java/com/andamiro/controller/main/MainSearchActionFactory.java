//package com.andamiro.controller.main;
//
//import com.andamiro.controller.action.MainSearchAction;
//
//public class MainSearchActionFactory {
//	private static MainSearchActionFactory instance = new MainSearchActionFactory();
//	public MainSearchActionFactory() {super();}
//	public static MainSearchActionFactory getInstance() {
//		return instance;
//	}
//	
//	public MainSearchAction getAction(String command) {
//		MainSearchAction action = null;
//		System.out.println("커맨드야~"+command);
//		if(command==null) {
//			action = new MainNoSearchAction();
//		}else if(command.equals("main_search")) {
//			action = new MainSearchListAction();
//					
//		}
//		
//		
//		return action;
//		
//	}
//		
//}
