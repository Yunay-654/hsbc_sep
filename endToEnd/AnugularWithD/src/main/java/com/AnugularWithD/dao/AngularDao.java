package com.AnugularWithD.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.AnugularWithD.entity.Employee;
@Repository
public class AngularDao implements AngularDaoInterface{
	
	@Override
	public List<Employee> viewallProfileDAO(){
		Connection con=null;
		List<Employee> ll=null;
	
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
		PreparedStatement ps=con.prepareStatement("select * from instagramuser");
				
		ResultSet res=ps.executeQuery();
		
		ll=new ArrayList<Employee>();
		
		while(res.next()) {
			Employee uu=new Employee();
			uu.setName(res.getString(1));
			uu.setPassword(res.getString(2));
			uu.setEmail(res.getString(3));
			uu.setAddress(res.getString(4));
			
			ll.add(uu);
		}
		}
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return ll;
	}

	@Override
	public void deleteProfileDao(String email) {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		 con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
		PreparedStatement ps=con.prepareStatement("delete from instagramuser where email=?");
		ps.setString(1,email);
		ps.executeUpdate();
		}
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public void createProfileDao(Employee e) {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		 
		
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//Class.forName("com.mysql.jdbc.Driver");
		
		//step 2 create connection with database
		 con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
		
		
		//step 3 create query
		PreparedStatement ps=con.prepareStatement("insert into instagramuser values(?,?,?,?)");
		ps.setString(1, e.getName());
		ps.setString(2, e.getPassword());
		ps.setString(3, e.getEmail());
		ps.setString(4, e.getAddress());
		//since here 4 ? so we can pass 1st parameter of setstring upto 4 and then in that case the 2nd parameter passed value will get inserted 
		//at that respective column postn as passed in 1st parameter.
		//step 4 executeQuery
		ps.executeUpdate();
		}
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException ee){
				ee.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void editProfileDao(String email,Employee e) throws Exception {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		 con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
	
		if(email!=null) {
		       ps=con.prepareStatement("update InstagramUser set name=?,password=?,email=?,address=? where email=?");
		       ps.setString(1, e.getName());
		       ps.setString(2, e.getPassword());
		       ps.setString(3, e.getEmail());
		       ps.setString(4, e.getAddress());
		       ps.setString(5,email);
		       ps.executeUpdate();
		       }
		
	}
		catch(ClassNotFoundException|SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException ee){
				ee.printStackTrace();
			}
		}
	}
}
