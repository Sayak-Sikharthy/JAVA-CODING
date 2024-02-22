package com.Dbconnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class DataSelect {
public Connection con = null;
	
	public void dataSelect() {
		try {
			
			Dbconnection dc = new Dbconnection();
			con = dc.dbConnect();
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from emp");
			
			while(rs.next()) {
				System.out.println("emp_id: "+rs.getInt("emp_id"));
				System.out.println("emp_name: "+rs.getString("emp_name"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 DataSelect dataSelectInstance = new DataSelect();
         dataSelectInstance.dataSelect();
	}

}
