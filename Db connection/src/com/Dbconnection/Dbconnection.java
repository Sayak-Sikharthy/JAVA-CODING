package com.Dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;


public class Dbconnection {
public Connection con = null;
	
	public Connection dbConnect () {
		
		try {
			
			System.out.println("Connecting...");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbnew", "root", "");
			System.out.println("Connected!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dbconnection dc = new Dbconnection();
		dc.dbConnect();
	}

}
