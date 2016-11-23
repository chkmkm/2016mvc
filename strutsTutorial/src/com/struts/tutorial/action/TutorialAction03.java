package com.struts.tutorial.action;

public class TutorialAction03 {
	
	private String msg;
	
	//파라미터 값 받을때
	public void setMsg(String msg){
		this.msg = msg;
	}
	
	//뮤에 전달할때
	public String getMsg(String msg){
		return msg;
	}

	public String execute(){
		System.out.println(msg);
		return "success";
	}
	
}
