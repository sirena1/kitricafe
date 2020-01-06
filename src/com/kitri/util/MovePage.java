package com.kitri.util;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class MovePage {

	//redirect
	public static void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
//		response.sendRedirect(root + path); //path : ok  또는 fail --- 어디든 갈 수 있다. memberDetailDto가 null값이 나온다. (프로젝트 full 경로 써주기)
		response.sendRedirect(request.getContextPath() + path);
	}
	//forward
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		//request에 담았으니까 forward
		RequestDispatcher dispatcher = request.getRequestDispatcher(path); //이 class 내에서만 이동 가능 (프로젝트 경로 x)
		dispatcher.forward(request, response);
	}
}
