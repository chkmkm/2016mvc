package com.struts.tutorial.action3;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.struts.tutorial.model.JavaBean;

public class Action02 implements Action, Preparable, ModelDriven {
	
	private JavaBean bean;
	private String msg;
	
	public JavaBean getBean() {
		return bean;
	}
	
	public void setBean(JavaBean bean) {
		this.bean = bean;
	}
	
	public String getMsg() {
		return msg;
	}
	
	@Override
	public String execute() throws Exception {
		
		System.out.println("id:"+bean.getId());
		System.out.println("pw:"+bean.getPw());
		if("root".equals(bean.getId())){
			return ERROR;
		}
		if("admin".equals(bean.getId())&&"1234".equals(bean.getPw())){
			msg = "관리자님 환영합니다.";
			return SUCCESS;
		}
		return INPUT;
	}

	@Override
	public Object getModel() {
		return bean;
	}

	@Override
	public void prepare() throws Exception {
		bean = new JavaBean();
	}

}
