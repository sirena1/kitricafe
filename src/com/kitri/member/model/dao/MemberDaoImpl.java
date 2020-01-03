package com.kitri.member.model.dao;

import java.sql.*;
import java.util.*;

import com.kitri.member.model.*;

public class MemberDaoImpl implements MemberDao{
	//2.
	private static MemberDao memberDao;
	
	static {
		memberDao = new MemberDaoImpl();
	}
	
	//1.
	private MemberDaoImpl() {}
	
	//3.
	public static MemberDao getMemberDao() {
		return memberDao;
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
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.65:1521:xe", "c##kitri", "kitri");
			StringBuilder sql = new StringBuilder();
			sql.append("insert all \n");
			sql.append("	into member(id, name, pass, emailid, emaildomain, joindate) \n");
			sql.append("	values(?,?,?,?,?,sysdate) \n");
			sql.append("	into member_detail(id, tel1, tel2, tel3, zipcode, address, address_detail) \n");
			sql.append("	values(?,?,?,?,?,?,?) \n");
			sql.append("	select * from dual");
			pstmt = conn.prepareStatement(sql.toString());
			int idx = 0;
			pstmt.setString(++idx, memberDetailDto.getId());
			pstmt.setString(++idx, memberDetailDto.getName());
			pstmt.setString(++idx, memberDetailDto.getPass());
			pstmt.setString(++idx, memberDetailDto.getEmailid());
			pstmt.setString(++idx, memberDetailDto.getEmaildomain());
			pstmt.setString(++idx, memberDetailDto.getId());
			pstmt.setString(++idx, memberDetailDto.getTel1());
			pstmt.setString(++idx, memberDetailDto.getTel2());
			pstmt.setString(++idx, memberDetailDto.getTel3());
			pstmt.setString(++idx, memberDetailDto.getZipcode());
			pstmt.setString(++idx, memberDetailDto.getAddress());
			pstmt.setString(++idx, memberDetailDto.getAddressDetail());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
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
	public MemberDto login(Map<String, String> map) {
		return null;
	}
}
