package com.kitri.member.model.dao;

import java.util.*;

import com.kitri.member.model.*;

public interface MemberDao {

	int idCheck(String id); //아이디 중복검사, count가 0이면 사용ok, 1이면 사용no
	List<ZipCodeDto> zipSearch(String doro);
	int register(MemberDetailDto memberDetailDto); //회원가입
	MemberDetailDto getMember(String id); 
	void modify(MemberDetailDto memberDetailDto ); //회원정보수정
	void delete(String id);
	MemberDto login(Map<String, String> map); //MemberDto가 없는 클래스가 있는 경우 Map으로 동일하게 사용할 수 있다. 
	
}
