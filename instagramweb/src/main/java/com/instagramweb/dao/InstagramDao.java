package com.instagramweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.instagramweb.utility.DAOFactory;
import com.instagramweb.entity.InstagramUser;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;
public class InstagramDao implements InstagramDaoInterface {
	private List<InstagramUser> userList;
	Connection con=null;
	public InstagramDao() {
		//userList=InstagramDAOFactory.createObject("admin service");
	    userList=new ArrayList<InstagramUser>();
	    
	    try {
	    	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	    	con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
	    	}
	    	catch(ClassNotFoundException|SQLException e) {
	    		e.printStackTrace();
	    	}
	    
	}
	
	public int createProfileDAO(InstagramUser iu)throws Exception{
		
		int i=0;
		
		//step 1 load driver
		// Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		 
		
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		//Class.forName("com.mysql.jdbc.Driver");
		
		//step 2 create connection with database
		Connection con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
		
		
		//step 3 create query
		PreparedStatement ps=con.prepareStatement("insert into instagramuser values(?,?,?,?)");
		ps.setString(1, iu.getName());
		ps.setString(2, iu.getPassword());
		ps.setString(3, iu.getEmail());
		ps.setString(4, iu.getAddress());
		//since here 4 ? so we can pass 1st parameter of setstring upto 4 and then in that case the 2nd parameter passed value will get inserted 
		//at that respective column postn as passed in 1st parameter.
		//step 4 executeQuery
		i=ps.executeUpdate();//jab insert/update/delete ho to executeUpdate() is used.
		//using file chactr by chrtr we using 

	     
       return i;
	}

	

	@Override
	public boolean loginprofileDAO(InstagramUser iu) {
		// TODO Auto-generated method stub
		System.out.println("inside login profile");
		boolean i=false;
		try {
		PreparedStatement ps=con.prepareStatement("select * from instagramuser where name=? and password=?");
		ps.setString(1,iu.getName());
		ps.setString(2,iu.getPassword());
		ResultSet res=ps.executeQuery();
		if(res.next()) {
			i=true;
		}
	}
		catch(SQLException ee) {
			ee.printStackTrace();
		}
		return i;
	}

	
}