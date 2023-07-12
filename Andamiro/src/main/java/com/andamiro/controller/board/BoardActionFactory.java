package com.andamiro.controller.board;

import com.andamiro.controller.action.BoardAction;

public class BoardActionFactory {

	private static BoardActionFactory instance = new BoardActionFactory();
	
	private BoardActionFactory() {};
	
	public static BoardActionFactory getInstance() {
		return instance;
	}
	
	public BoardAction getAction(String command){
		BoardAction action = null;
		if(command.equals("board_paging")) {
			action = new BoardPagingMemberAction();
		}
		return action;
	}
	
	
}
