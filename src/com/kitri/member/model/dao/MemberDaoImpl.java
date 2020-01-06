package com.kitri.member.model.dao;

import java.sql.*;
import java.util.*;

import com.kitri.member.model.*;

public class MemberDaoImpl implements MemberDao {
	// 2.
	private static MemberDao memberDao;

	static {
		memberDao = new MemberDaoImpl();
	}

	// 1.
	private MemberDaoImpl() {
	}

	// 3.
	public static MemberDao getMemberDao() {
		return memberDao;
	}

	@Override
	public int idCheck(String id) {
		int cnt = 1; // 부정적인 값(사용할 수 없다)을 주면 좋다. 0이 아닌... 만약 0인 경우에도 사용할 수 없다는 에러가 뜰 수 있기 때문에
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.65:1521:xe", "c##kitri", "kitri");
			StringBuilder sql = new StringBuilder();
			sql.append("select count(id) \n");
			sql.append("from member \n");
			sql.append("where id=? \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next(); //단독.. 무조건 한번은 얻어오니까 100%로 하나의 값
			cnt = rs.getInt(1);
		} catch (Exception e) {
			cnt = 1; //에러 났을 때 대처할 수 있는 코드를 catch 블럭에 넣어주면 좋다.
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
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
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
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
