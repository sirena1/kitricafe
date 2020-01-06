package com.kitri.util;

import java.sql.*;

public class DBConnection {

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@192.168.12.65:1521:xe", "c##kitri", "kitri");
	}
}
