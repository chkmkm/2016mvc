package com.mvc2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneController implements CMDimp {
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("POJO Ŭ���� ����-One");
//		request.getRequestDispatcher("/WEB-INF/page/list.jsp").forward(request, response);
		return "detail";
	}
	
}
