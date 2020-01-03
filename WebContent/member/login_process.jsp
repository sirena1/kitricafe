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

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String name = null;
	
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	try {
		conn = getConnection();
		StringBuilder sql = new StringBuilder();
		sql.append("select name \n");
		sql.append("from member \n");
		sql.append("where id = ? and pass = ?");
		pstmt = conn.prepareStatement(sql.toString());
		//물음표의 개수
		pstmt.setString(1, id);
		pstmt.setString(2, pass);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			name = rs.getString("name");	
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pstmt !=  null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

if(name != null) {
	response.sendRedirect(root + "/login/loginok.jsp?name=" + URLEncoder.encode(name, "utf-8") + "&id=" + id);
} else { 
	response.sendRedirect(root + "/login/loginfail.jsp");
}
%>

