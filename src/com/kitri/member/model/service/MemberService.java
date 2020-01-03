package com.kitri.member.model.service;

import java.util.*;

import com.kitri.member.model.*;

public interface MemberService {
	
	int idCheck(String id); //아이디 중복검사, count가 0이면 사용ok, 1이면 사용no
	List<ZipCodeDto> zipSearch(String doro);
	int register(MemberDetailDto memberDetailDto); //회원가입
	MemberDetailDto getMember(String id); 
	void modify(MemberDetailDto memberDetailDto ); //회원정보수정
	void delete(String id);
	MemberDto login(String id, String pass);
	void logout();
}
