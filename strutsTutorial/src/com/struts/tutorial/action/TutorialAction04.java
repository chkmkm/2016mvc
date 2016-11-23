package com.struts.tutorial.action;

public class TutorialAction04 {
	
	public String actionRunner(){
		System.out.println("actionRunner() run");
		return "success";
	}
	
	public String execute(){
		System.out.println("execute() run");
		return "success";
	}
	
}
