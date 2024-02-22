package com.Dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class DataInsert {
	public Connection con = null;
	public PreparedStatement ps = null;
	int i = 0;
public void dataInsert() {
		
		try {
	//		User Input
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your sl.no ");
			Integer slnumber = sc.nextInt();
			
			System.out.println("Enter your emp_name ");
			String empname = sc.next();
			
			System.out.println("Enter your emp_id ");
			Integer emp_id = sc.nextInt();
			
			System.out.println("Enter your dept ");
			String department = sc.next();
			
			System.out.println("Enter your salary ");
			Integer salary = sc.nextInt();
			
			
	//		Database connection
			Dbconnection dc = new Dbconnection();
			con = dc.dbConnect();
			
	//		SQL Query Execution
			String insertQuery = "insert into emp values(?, ?, ?,?,?)";
			ps = con.prepareStatement(insertQuery);
			ps.setInt(1, slnumber);
			ps.setString(2, empname);
			ps.setInt(3, emp_id);
			ps.setString(4, department);
			ps.setInt(5, salary);
			i = ps.executeUpdate();
			
	//		Check the data inserted or not
			if(i>0) {
				System.out.println("Successful");
			}
			else {
				System.out.println("Failed");
			}
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 DataInsert dataInsertInstance = new DataInsert();
         dataInsertInstance.dataInsert();
	}

}
