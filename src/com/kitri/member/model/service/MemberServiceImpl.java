package com.kitri.member.model.service;

import java.util.*;

import com.kitri.member.model.*;
import com.kitri.member.model.dao.*;

public class MemberServiceImpl implements MemberService{

	private static MemberService memberService;
	
	//싱글톤 패턴
	static {
		memberService = new MemberServiceImpl();
	}
	
	private MemberServiceImpl() {}
	
	public static MemberService getMemberService() {
		return memberService;
	}
	
	@Override
	public int idCheck(String id) {
		return 0;
	}

	@Override
	public List<ZipCodeDto> zipSearch(String doro) {
		return null;
	}

	@Override
	public int register(MemberDetailDto memberDetailDto) {
		return MemberDaoImpl.getMemberDao().register(memberDetailDto);
	}

	@Override
	public MemberDetailDto getMember(String id) {
		return null;
	}

	@Override
	public void modify(MemberDetailDto memberDetailDto) {
	}

	@Override
	public void delete(String id) {
	}

	@Override
	public MemberDto login(String id, String pass) {
		return null;
	}

	@Override
	public void logout() {
	}

}
