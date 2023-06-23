package com.andamiro.controller.event;


public class ActionFactory {
 private static ActionFactory instance = new ActionFactory();
 private ActionFactory() {
 super();
 }
 public static ActionFactory getInstance() {
 return instance;
 }
 public Action getAction(String command) {
 Action action = null;
 System.out.println("ActionFactory :" + command);
 /* 추가된 부분 */
 if (command.equals("EventMainViewForm")) {
 action = new EventMainViewForm();
 }                        
 //공모전
 else if (command.equals("EventContestViewform")) {
	 action = new EventContestViewForm();
	 }
 //일반이벤트				
 else if(command.equals("EventViewform")) {
	 action = new EventViewForm();
 }
 return action;
 }
}