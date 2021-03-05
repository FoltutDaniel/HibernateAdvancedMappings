package com.zeke.OneToOne;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		
		try {
			System.out.println("Connecting to "+ jdbcUrl);
			Connection myCon = DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println(myCon);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
