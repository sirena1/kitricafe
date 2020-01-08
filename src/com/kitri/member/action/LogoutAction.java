package com.kitri.member.action;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.kitri.action.*;

public class LogoutAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
//		session.setAttribute("userInfo", null);
//		session.removeAttribute("userInfo");
		session.invalidate(); //session안에 있는 것을 모두 무효화 시켜라
//		return "/member/loginok.jsp";
		return "/index.jsp";
	}
}
