package com.struts.tutorial.action;

public class TutorialAction03 {
	
	private String msg;
	
	//�Ķ���� �� ������
	public void setMsg(String msg){
		this.msg = msg;
	}
	
	//�¿� �����Ҷ�
	public String getMsg(String msg){
		return msg;
	}

	public String execute(){
		System.out.println(msg);
		return "success";
	}
	
}
