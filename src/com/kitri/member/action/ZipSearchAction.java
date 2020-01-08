package com.kitri.member.action;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.kitri.action.*;
import com.kitri.member.model.*;
import com.kitri.member.model.service.*;

public class ZipSearchAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sdoro = request.getParameter("sdoro");
		System.out.println("sdoro ====" + sdoro);
		List<ZipCodeDto> list = MemberServiceImpl.getMemberService().zipSearch(sdoro);
		System.out.println(">>>>>>>>>>" + list.size());
//		TODO 나중에 json lib를 이용해서...
		request.setAttribute("ziplist", list);
		return "/member/ziplist_json.jsp";
	}	
}