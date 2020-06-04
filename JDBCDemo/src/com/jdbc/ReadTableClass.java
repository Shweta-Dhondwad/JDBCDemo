package com.jdbc;
import java.sql.*;
public class ReadTableClass {
	private static String driver_name="com.mysql.jdbc.Driver";
	private static String db_URL="jdbc:mysql://localhost/school";
	private static String db_userName="root";
	private static String db_password="Shweta123";
  public static void main(String[] args) {

	  Connection con=null;
	  Statement stmt=null;
	  try{
		  System.out.println("Creatig driver");
		  Class.forName(driver_name);
		  System.out.println("Establishing");
		  con= DriverManager.getConnection(db_URL, db_userName, db_password);
				  
				  System.out.println("Create statement..");
		  stmt= con.createStatement();
		  System.out.println("Firingg a query to database");
		  String querry = "select * from Student";
		  ResultSet rs = stmt.executeQuery(querry);
		  while(rs.next()){
			  int stud_id= rs.getInt(1);
			  int stud_age= rs.getInt(2);
			  String first_name= rs.getString(3);
			  String last_name= rs.getString(4);
			  System.out.println("Student details= " +stud_id+", "+stud_age+", "+first_name+", "+last_name);
			 
			 }
	  }catch(ClassNotFoundException | SQLException e){
		  e.printStackTrace();
	  }
	  finally{
		  try{
			  stmt.close();
		  }catch(Exception e){ System.out.println(e);}  
	  }
	}

}
