package com.Dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class DataUpdate {
	public Connection con = null;
	public PreparedStatement ps = null;
	int i = 0;
	
	public void dataUpdate() {
		
		try {
	//		User Input
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your emp_id : ");
			int emp_id = sc.nextInt();
			
			System.out.println("Enter your new salary : ");
			int salary = sc.nextInt();
			
	//		Database connection
			Dbconnection dc = new Dbconnection();
			con = dc.dbConnect();
			
	//		SQL Query Execution
			String updateQuery = "update emp set salary=? where emp_id=?";
			ps = con.prepareStatement(updateQuery);
			ps.setInt(1, salary);
			ps.setInt(2, emp_id);
			i = ps.executeUpdate();
			
	//		Check the data inserted or not
			if(i>0) {
				System.out.println("Successful");
			}
			else {
				System.out.println("Failed");
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataUpdate dataUpdateInstance = new DataUpdate();
        dataUpdateInstance.dataUpdate();
	}

}
