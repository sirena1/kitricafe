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
//			request.setAttribute("userInfo", memberDto);
			////////////////cookie/////////////////////
			String idck = request.getParameter("idsave");
			if("saveok".equals(idck)) {
				Cookie cookie = new Cookie("asid", id); //id 저장
				cookie.setPath(request.getContextPath());
				cookie.setMaxAge(60*60*24*365*20); 
				
				response.addCookie(cookie);
			} else {
				Cookie cookie[] = request.getCookies();
				if(cookie != null) {
					int len = cookie.length;
					for(int i=0;i<len;i++){
						if(cookie[i].getName().equals("asid")){
							//아까 만든 cookie의 만료날짜 0초 지금 지워라
							cookie[i].setMaxAge(0);
							cookie[i].setPath(request.getContextPath());
							response.addCookie(cookie[i]);
							break;
						}
					}
				}
			}
			////////////////session/////////////////////
			//로그인을 했는지 안했는지 판단의 근거인 session
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", memberDto);
			path = "/member/loginok.jsp";
		} else {
			path = "/member/loginfail.jsp";
		}
		return path;
	}	
}
