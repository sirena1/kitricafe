package com.kitri.member.controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.kitri.factory.*;
import com.kitri.util.*;


@WebServlet("/user")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String root = request.getContextPath();
		
		String act = request.getParameter("act");
		System.out.println("act >>>>>> " + act); 
		
		String path = "/index.jsp";
		
		if("mvjoin".equals(act)) {
			//단순이동은 redirect
			MovePage.redirect(request, response, "/member/member.jsp");
		} else if("mvlogin".equals(act)) {
			MovePage.redirect(request, response, "/member/login.jsp");
		} else if("register".equals(act)) {
//			System.out.println(">>>>>>>>> " + request.getParameter("name"));
			path = MemberActionFactory.getRegisterAction().execute(request, response);		
			MovePage.forward(request, response, path);
		} else if("idcheck".equals(act)) {
			//DB 갔다오기
			path = MemberActionFactory.getIdCheckAction().execute(request, response); 
			MovePage.forward(request, response, path);
		} else if("zipsearch".equals(act)) {
			path = MemberActionFactory.getZipSearchAction().execute(request, response); 
			//가져갈 데이터가 있으면 forward
			MovePage.forward(request, response, path);
		} else if("login".equals(act)) {
			path = MemberActionFactory.getLoginAction().execute(request, response); 
			MovePage.forward(request, response, path);
		} else if("logout".equals(act)) {
			path = MemberActionFactory.getLogoutAction().execute(request, response); 
			MovePage.forward(request, response, path);
		} else if("maillist".equals(act)) {
			path = "/member/maillist.jsp";
//			MovePage.forward(request, response, path);
			MovePage.redirect(request, response, path);
		} else {
			response.sendRedirect(root + path);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
