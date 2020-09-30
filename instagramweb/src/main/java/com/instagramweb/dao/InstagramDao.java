package com.instagramweb.dao;

import java.util.ArrayList;
import java.util.List;

import com.instagramweb.utility.DAOFactory;
import com.instagramweb.entity.IrctcUser;
import com.instagramweb.entity.Country;
import com.instagramweb.entity.InstagramUser;
import com.instagramweb.entity.IrctcUser;

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

	@Override
	public int checkmailDAO(InstagramUser iu) {
		int i=0;
		// TODO Auto-generated method stub
		try {
		PreparedStatement ps=con.prepareStatement("select * from instagramuser where email=?");
		ps.setString(1, iu.getEmail());
		ResultSet res=ps.executeQuery();
		if(res.next()) {
			i=1;
		}
		}
		catch(SQLException ee) {
			ee.printStackTrace();
		}
		return i;
	}

	@Override
	public List<IrctcUser> sourceDAO()throws Exception {
		Connection con=null;
		List<IrctcUser> ll=null;
	
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
		PreparedStatement ps=con.prepareStatement("select * from irctcuser");
				
		ResultSet res=ps.executeQuery();
		
		ll=new ArrayList<IrctcUser>();
		
		while(res.next()) {
			IrctcUser uu=new IrctcUser();
			uu.setCity(res.getString(2));
			
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
		// TODO Auto-generated method stub
	}

	@Override
	public List<String> countryDAO() throws Exception {
		// TODO Auto-generated method stub
		Connection con=null;
		List<String> ll=null;
	
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
		PreparedStatement ps=con.prepareStatement("select * from country");
				
		ResultSet res=ps.executeQuery();
		
		ll=new ArrayList<String>();
		
		while(res.next()) {
			Country uu=new Country();
			uu.setCname(res.getString(2));
			
			ll.add(uu.getCname());
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
	public List<String> stateDAO(Country c) throws Exception {
		// TODO Auto-generated method stub
		
		Connection con=null;
		List<String> ll=null;
	
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
		PreparedStatement ps=con.prepareStatement("select id from country where country=?");
	    ps.setString(1, );
		ResultSet res=ps.executeQuery();
		
		ll=new ArrayList<String>();
		
		while(res.next()) {
			Country uu=new Country();
			uu.setCname(res.getString(2));
			
			ll.add(uu.getCname());
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
	public List<String> cityDAO(State s) throws Exception {
		// TODO Auto-generated method stub
		Connection con=null;
		List<String> ll=null;
	
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
		PreparedStatement ps=con.prepareStatement("select * from country");
				
		ResultSet res=ps.executeQuery();
		
		ll=new ArrayList<String>();
		
		while(res.next()) {
			Country uu=new Country();
			uu.setCname(res.getString(2));
			
			ll.add(uu.getCname());
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

	
}