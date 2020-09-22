package com.instagram.entity;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
public class Table_structure_demo {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
		PreparedStatement ps=con.prepareStatement("select * from instagramuser");
		ResultSet res=ps.executeQuery();
		ResultSetMetaData rs=res.getMetaData();
		int i=rs.getColumnCount();
		for(int j=1;j<=i;j++) {
			System.out.println("Name is"+rs.getColumnName(j));
			System.out.println("type is"+rs.getColumnTypeName(j));
			System.out.println("size is"+rs.getColumnDisplaySize(j));
		}
		

	}

}
