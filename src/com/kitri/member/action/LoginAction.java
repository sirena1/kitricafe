package com.kitri.member.action;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.kitri.action.*;
import com.kitri.member.model.*;
import com.kitri.member.model.service.*;

public class LoginAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = "/index.jsp";
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDto memberDto = MemberServiceImpl.getMemberService().login(id, pass);
		if (memberDto != null) {
			
			path = "/member/loginok.jsp";
		} else {
			path = "/member/loginfail.jsp";
		}
		return path;
	}
	
	
}
