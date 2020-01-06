package com.kitri.member.action;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.kitri.action.*;
import com.kitri.member.model.service.*;

public class IdCheckAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("checkid");
		int cnt = MemberServiceImpl.getMemberService().idCheck(id);
		System.out.println(id + "                  " + cnt);
		//바구니에 담아서 넘기기
		request.setAttribute("searchid", id);
		request.setAttribute("idcount", cnt + "");
		return "/member/idresult.jsp";
	}	
}
