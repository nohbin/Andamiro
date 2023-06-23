package com.andamiro.controller.member;

import com.andamiro.controller.action.MemberAction;

public class MemberActionFactory {
	
	private static MemberActionFactory instance = new MemberActionFactory();
	private MemberActionFactory() {};
	
	public static MemberActionFactory getInstance() {
		return instance;
	}
	
	public MemberAction getAction(String command) {
		MemberAction action = null;
		
		if(command.equals("member_join_form")) {
			action = new MemberJoinForm();
		}else if(command.equals("member_join")) {
			action = new MemberJoinAction();
		}else if(command.equals("member_login_form")) {
			action = new MemberLoginForm();
		}else if(command.equals("member_login")) {
			action = new MemberLoginAction();
		}else if(command.equals("member_logout")) {
			action = new MemberLogoutAction();
		}else if(command.equals("member_mypage")) {
			action = new MemberMypageAction();
		}else if(command.equals("member_Idcheck_form")) {
			action = new MemberIdCheckForm();
		}else if(command.equals("member_Idcheck")) {
			action = new MemberIdCheckAction();
		}
		return action;
	}
}
