<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,java.net.*"%>

<%!
public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading Success!!!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}

private Connection getConnection() throws SQLException {
	return DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.65:1521:xe","c##kitri","kitri");
}
 %>

<%

String root = request.getContextPath();

int cnt = 0;
Connection conn = null;
PreparedStatement pstmt = null;		
request.setCharacterEncoding("utf-8");
//1.request.getParameter("html의 name과 일치해야 함")
String id = request.getParameter("id"); 
String name = request.getParameter("name");
String pass = request.getParameter("pass");
String emailid = request.getParameter("emailid");
String emaildomain = request.getParameter("emaildomain");
String tel1 = request.getParameter("tel1");
String tel2 = request.getParameter("tel2");
String tel3 = request.getParameter("tel3");
String zipcode = request.getParameter("zipcode");
String address = request.getParameter("address");
String addressDetail = request.getParameter("address_detail");

try {
	conn = getConnection();
	StringBuilder sql = new StringBuilder();
	sql.append("insert all \n");
	sql.append("	into member(id, name, pass, emailid, emaildomain, joindate) \n");
	sql.append("	values(?,?,?,?,?,sysdate) \n");
	sql.append("	into member_detail(id, tel1, tel2, tel3, zipcode, address, address_detail) \n");
	sql.append("	values(?,?,?,?,?,?,?) \n");
	sql.append("	select * from dual");
	pstmt = conn.prepareStatement(sql.toString());
	int idx = 0;
	pstmt.setString(++idx, id);
	pstmt.setString(++idx, name);
	pstmt.setString(++idx, pass);
	pstmt.setString(++idx, emailid);
	pstmt.setString(++idx, emaildomain);
	pstmt.setString(++idx, id);
	pstmt.setString(++idx, tel1);
	pstmt.setString(++idx, tel2);
	pstmt.setString(++idx, tel3);
	pstmt.setString(++idx, zipcode);
	pstmt.setString(++idx, address);
	pstmt.setString(++idx, addressDetail);
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

if(cnt != 0) { //성공
	response.sendRedirect(root + "/member/registerok.jsp?name=" + URLEncoder.encode(name, "utf-8") + "&id=" + id);
} else { //실패
	response.sendRedirect(root + "/member/registerfail.jsp");
}
%>
