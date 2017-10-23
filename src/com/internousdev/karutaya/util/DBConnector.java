package com.internousdev.karutaya.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String user = "root";
	private static String password = "mysql";

    public Connection getConnection() {
	String url = "jdbc:mysql://localhost/karutaya";
	Connection con = null;
	try {
		Class.forName(driverName);
		con = (Connection) DriverManager.getConnection(url,user,password);
	} catch(ClassNotFoundException e) {
		e.printStackTrace();
	} catch(SQLException e) {
		e.printStackTrace();
	}
	return con;
	}

    public Connection getCreditConnection(String credittype) {
    	String url = "jdbc:mysql://localhost/"+credittype;
    	Connection con = null;
    	try {
    		Class.forName(driverName);
    		con = (Connection) DriverManager.getConnection(url,user,password);
    	} catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return con;
    	}
}
