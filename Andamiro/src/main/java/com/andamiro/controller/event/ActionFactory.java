package com.andamiro.controller.event;


import com.andamiro.controller.recipe.Recipe_ContestMoreView;
import com.andamiro.controller.recipe.Recipe_ContestWriteAction;
import com.andamiro.controller.recipe.Recipe_ContestWriteForm;

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
		// 공모전
		else if (command.equals("EventContestViewform")) {
			action = new EventContestViewForm();
		}
		// 일반이벤트
		else if (command.equals("EventViewform")) {
			action = new EventNomalViewForm();
		}
		// 이벤트리스트
		else if (command.equals("event_list")) {
			action = new EventListAction();
		} else if (command.equals("event_write_form")) {
			action = new EventWriteFormAction();
		} else if (command.equals("event_write")) {
			action = new EventWriteAction();
		} else if (command.equals("event_view")) {
			action = new EventViewAction();
		} else if (command.equals("event_update_form")) {
			action = new EventUpdateFormAction();
		} else if (command.equals("event_update")) {
			action = new EventUpdateAction();
		} else if (command.equals("event_delete")) {
			action = new EventDeleteAction();
		} else if (command.equals("contest_recipewrite")) {
			action = new Recipe_ContestWriteForm();
		}else if(command.equals("contest_recipewrite_action")) {
			action= new Recipe_ContestWriteAction();
		
		}else if(command.equals("contest_moreview")) {
			action = new Recipe_ContestMoreView();
		}

		return action;
	}
}