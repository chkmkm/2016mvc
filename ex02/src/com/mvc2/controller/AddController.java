package com.mvc2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.model.GuestDao;

public class AddController implements CMDimp {
	
	private GuestDao dao;
	
	public AddController(GuestDao dao) {
		this.dao = dao;
	}
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("POJO 클래스 실행-Add");
//		request.getRequestDispatcher("/WEB-INF/page/list.jsp").forward(request, response);
		return "form";
	}
	
}
