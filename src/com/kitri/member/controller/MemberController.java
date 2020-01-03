package com.kitri.member.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.kitri.factory.*;


@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		
		String act = request.getParameter("act");
		System.out.println("act >>>>>> " + act); 
		
		String path = "/index.jsp";
		if("mvjoin".equals(act)) {
			response.sendRedirect(root + "/member/member.jsp");
		} else if("mvlogin".equals(act)) {
			response.sendRedirect(root + "/member/login.jsp");
		} else if("register".equals(act)) {
//			System.out.println(">>>>>>>>> " + request.getParameter("name"));
			path = MemberActionFactory.getRegisterAction().execute(request, response);
//			response.sendRedirect(root + path); //path : ok  또는 fail --- 어디든 갈 수 있다. memberDetailDto가 null값이 나온다. (프로젝트 full 경로 써주기)
			RequestDispatcher dispatcher = request.getRequestDispatcher(path); //이 class 내에서만 이동 가능 (프로젝트 경로 x)
			dispatcher.forward(request, response);
		} else if("".equals(act)) {
			
		} else if("".equals(act)) {
			
		} else {
			response.sendRedirect(root + path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
