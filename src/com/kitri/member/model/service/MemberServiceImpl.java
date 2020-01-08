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
		//dao에 일시키기
		return MemberDaoImpl.getMemberDao().idCheck(id);
	}

	@Override
	public List<ZipCodeDto> zipSearch(String doro) {
		return MemberDaoImpl.getMemberDao().zipSearch(doro);
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
		//dto역할을 할 수 있는 map (dto로도 할 수 있다. 나중에 게시판 등에서는 인자값을 두개 받을 수 없기 때문에 map 사용)
		Map<String, String> map = new HashMap<String, String>();
		map.put("userid", id);
		map.put("userpwd", pass);
		return MemberDaoImpl.getMemberDao().login(map);
	}

	@Override
	public void logout() {
	}

}
