package com.kitri.member.model.dao;

import java.sql.*;
import java.util.*;

import com.kitri.member.model.*;
import com.kitri.util.*;

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
			conn = DBConnection.getConnection();
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
			DBClose.close(conn, pstmt, rs);
		}
		return cnt;
	}

	@Override
	public List<ZipCodeDto> zipSearch(String doro) {
		List<ZipCodeDto> list = new ArrayList<ZipCodeDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select 	new_post_code zipcode, sido_kor || ' ' || gugun_kor || ' ' ||  \n");
			sql.append("	nvl(upmyon_kor, ' ')  || ' ' || doro_kor  || ' ' ||  \n");
			sql.append("	case when building_refer_number != '0' \n");
			sql.append("		then building_origin_number||'-'||building_refer_number  \n");
			sql.append("		else trim(to_char(building_origin_number, '99999')) \n");
			sql.append("	end  || ' ' || sigugun_building_name as address \n");
			sql.append("from 	postcode \n");
			sql.append("where 	doro_kor like '%'||?||'%' \n");
			sql.append("or 	sigugun_building_name like '%'||?||'%' \n");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, doro);
			pstmt.setString(2, doro);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ZipCodeDto zipCodeDto = new ZipCodeDto();
				zipCodeDto.setZipcode(rs.getString("zipcode"));
				zipCodeDto.setAddress(rs.getString("address"));
				
				list.add(zipCodeDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return list;
	}
	
	@Override
	public int register(MemberDetailDto memberDetailDto) {
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
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
			DBClose.close(conn, pstmt);
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
	public MemberDto login(Map<String, String> map) { //select 값이 여러개니까 return type을 MemberDto로 잡기
		MemberDto memberDto = null;
		//여기서 new 하지 않는다. 아이디와 비밀번호가 맞을 때만 생성
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBConnection.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select name, id, emailid, emaildomain \n");
			sql.append("from member \n");
			sql.append("where id = ? and pass = ?");
			pstmt = conn.prepareStatement(sql.toString());
			//물음표의 개수
			pstmt.setString(1, map.get("userid"));
			pstmt.setString(2, map.get("userpwd"));
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//얻어왔다면 그 때 new 하기
				memberDto = new MemberDto();
				memberDto.setId(rs.getString("id"));
				memberDto.setName(rs.getString("name"));
				memberDto.setEmailid(rs.getString("emailid"));
				memberDto.setEmaildomain(rs.getString("emaildomain"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.close(conn, pstmt, rs);
		}
		return null;
	}
}
