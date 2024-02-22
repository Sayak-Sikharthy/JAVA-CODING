package com.Dbconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DataDelete {
	
	public Connection con = null;
	public PreparedStatement ps = null;
	int i = 0;

	public void dataDelete() {
		try {
			
			System.out.println("Enter the emp_id to delete");
			Scanner sc = new Scanner(System.in);
			int id = sc.nextInt();
			
			Dbconnection dc = new Dbconnection();
			con = dc.dbConnect();
			
			String delQuery = "delete from emp where emp_id=?";
			ps = con.prepareStatement(delQuery);
			ps.setInt(1, id);
			
			i = ps.executeUpdate();
			if(i>0) {
				System.out.println("Data Deleted");
			}
			else {
				System.out.println("Failed");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DataDelete dataDeleteInstance = new DataDelete();
        dataDeleteInstance.dataDelete();
	}

}
