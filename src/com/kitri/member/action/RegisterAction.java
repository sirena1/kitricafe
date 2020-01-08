package com.kitri.member.action;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.kitri.action.*;
import com.kitri.member.model.*;
import com.kitri.member.model.service.*;

public class RegisterAction implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = null;
		
		MemberDetailDto memberDetailDto = new MemberDetailDto();
		memberDetailDto.setId(request.getParameter("id")); 
		memberDetailDto.setName(request.getParameter("name"));
		memberDetailDto.setPass(request.getParameter("pass"));
		memberDetailDto.setEmailid(request.getParameter("emailid"));
		memberDetailDto.setEmaildomain(request.getParameter("emaildomain"));
		memberDetailDto.setTel1(request.getParameter("tel1"));
		memberDetailDto.setTel2(request.getParameter("tel2"));
		memberDetailDto.setTel3(request.getParameter("tel3"));
		memberDetailDto.setZipcode(request.getParameter("zipcode"));
		memberDetailDto.setAddress(request.getParameter("address"));
		memberDetailDto.setAddressDetail(request.getParameter("address_detail"));
		
		int cnt = MemberServiceImpl.getMemberService().register(memberDetailDto);
		
		if(cnt != 0) {
			//성공했을 때만 request에 담아라
			request.setAttribute("registerInfo", memberDetailDto);
			path = "/member/registerok.jsp";
		} else {
			path = "/member/registerfail.jsp";
		}
		return path;
	}
}