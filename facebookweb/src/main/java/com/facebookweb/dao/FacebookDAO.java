package com.facebookweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.facebookweb.utility.DAOFactory;
import com.facebookweb.utility.FacebookException;
import com.facebookweb.entity.FacebookUser;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;
public class FacebookDAO implements FacebookDAOInterface {
	private List<FacebookUser> userList;
	Connection con=null;
	public FacebookDAO() {
		//userList=InstagramDAOFactory.createObject("admin service");
	    userList=new ArrayList<FacebookUser>();
	    
	    try {
	    	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	    	con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
	    	}
	    	catch(ClassNotFoundException|SQLException e) {
	    		e.printStackTrace();
	    	}
	    
	}
	
	public int createProfileDAO(FacebookUser iu)throws FacebookException,Exception{
		
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

	public int editProfileDAO(FacebookUser iu) throws Exception{
		// TODO Auto-generated method stub
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int i=0;
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		//Connection con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
		PreparedStatement ps=null;
		String s="";
		System.out.println("address"+iu.getAddress());
		System.out.println("password"+iu.getPassword());
		System.out.println("email"+iu.getEmail());
		System.out.println("name"+iu.getName());
		if(iu.getName()!=null) {
		       ps=con.prepareStatement("update InstagramUser set name=? where email=?");
		       ps.setString(1, iu.getName());
		       ps.setString(2,iu.getEmail());
		       }
		else if((iu.getPassword()!=null)&&(iu.getAddress()!=null)) {
			
			ps=con.prepareStatement("update InstagramUser set password=? where address=?");
			
			ps.setString(1, iu.getPassword());
			ps.setString(2,iu.getAddress());}
		
		else if((iu.getEmail()!=null)&&(iu.getPassword()!=null)) {
			ps=con.prepareStatement("update InstagramUser set email=? where password=?");
			ps.setString(1, iu.getEmail());
			ps.setString(2,iu.getPassword());}
		else if((iu.getAddress()!=null)&&(iu.getEmail()!=null)) {
		      
		//Note:We can do Like update instausr set email="xyz" where email="zxu".But here we are passing both set and where wala paramtr via object so if both are email only then both value would go and set in setEmail functn and one would be overritten by other and thus both set val and where val would be same while extacting it here so cant do like that here.
			ps=con.prepareStatement("update InstagramUser set address=? where email=?");
			ps.setString(1, iu.getAddress());
			ps.setString(2,iu.getEmail());}
		
		i=ps.executeUpdate();
		System.out.println(i);
           return i;
	}

	public int deleteProfileDAO(FacebookUser iu)throws Exception {
		// TODO Auto-generated method stub
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
		PreparedStatement ps=con.prepareStatement("delete from instagramuser where email=?");
		ps.setString(1, iu.getEmail());
		//set string ka 1st parameter species #entries allowed for preparedstatement which is actually determined by #? passed in PreparedStatement
		//since here 1 ? we gave ie for email so we wrote 1 as 1st parameter of setstring
		//System.out.println(ps.executeUpdate());
		int rs=ps.executeUpdate();
		  return rs;
	}

	public List<FacebookUser> searchProfileDAO(FacebookUser iu)throws FacebookException {
		List<FacebookUser> ll=new ArrayList<FacebookUser>();
		Connection con=null;
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
		PreparedStatement ps=con.prepareStatement("select * from instagramuser where name=?");
		ps.setString(1, iu.getName());
		
		ResultSet res=ps.executeQuery();
		
		//List<InstagramUser> ll=new ArrayList<InstagramUser>();
		
		while(res.next()) {
			FacebookUser uu=new FacebookUser();
			uu.setName(res.getString(1));
			uu.setPassword(res.getString(2));
			uu.setEmail(res.getString(3));
			uu.setAddress(res.getString(4));
			
			ll.add(uu);
		}
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			}
			catch(SQLException e1){
				e1.printStackTrace();
			}
		}
		return ll;
		

	}

	public List<FacebookUser> viewallProfileDAO()throws FacebookException/*throws Exception*/{
		Connection con=null;
		List<FacebookUser> ll=null;
	
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
		PreparedStatement ps=con.prepareStatement("select * from instagramuser");
				
		ResultSet res=ps.executeQuery();
		
		ll=new ArrayList<FacebookUser>();
		
		while(res.next()) {
			FacebookUser uu=new FacebookUser();
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

	public FacebookUser viewProfileDAO(FacebookUser iu) throws FacebookException,Exception{
		//viewprofile nd searchprofile is same as per arraylist logic but using db view profile you can see only by login while for search profile you can seach all with that name without login
		//important code commented just for reference
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
		PreparedStatement ps=null;
		String s="";
		//if(iu.getName()!=null)//null camparison giving error {
		 //* means you may use .equals way or you may use .isEmpty() method of string comparison..equalsIgnoreCase() is better approach
		 //* 
		if(iu.getName()!=null) {
		ps=con.prepareStatement("select * from instagramuser where name=?");
		ps.setString(1, iu.getName());}
		else if(iu.getEmail()!=null) {
			ps=con.prepareStatement("select * from instagramuser where email=?");
			ps.setString(1, iu.getEmail());
		}
		//else if(!(iu.getPassword().equals(s)))
		else if(iu.getPassword()!=null){
			ps=con.prepareStatement("select * from instagramuser where password=?");
			ps.setString(1, iu.getPassword());
			//while comparison with null,it is giving null ptr. exception .why?maybe because string is initialised with empty string and is not null.
		}
		else if(iu.getAddress()!=null) {
			ps=con.prepareStatement("select * from instagramuser where address=?");
			ps.setString(1, iu.getAddress());
		}
		ResultSet res=ps.executeQuery();
		//how to verify resultset is having result or not
		//via next() method, if next() method will return true then resultset have some result otherwise no result
		
		FacebookUser uu=null;
		
		if(res.next()) {
			uu=new FacebookUser();
			uu.setName(res.getString(1));
			uu.setPassword(res.getString(2));
			uu.setEmail(res.getString(3));
			uu.setAddress(res.getString(4));
		}
		return uu;
		//this view profile will return only one user object as here we didnt use dynamic arrayy of objcts.So,even if there are more than one users it will 
		//return the one which appears first with the given name.
	
	
	}
	@Override
	public Map<String, List<FacebookUser>> userdetailwithhistorydao() throws FacebookException {
		Map<String, List<FacebookUser>> m=new HashMap<String, List<FacebookUser>>();
		
		List<FacebookUser> l1=viewallProfileDAO();
		List<FacebookUser> l2=viewallProfileDAO();
		
		m.put("studentlist", l1);
		m.put("proflist", l2);
		
		return m;
	}

	@Override
	public boolean loginprofileDAO(FacebookUser iu) {
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
	public List<FacebookUser> friendProfileDAO(FacebookUser fu) {
		// TODO Auto-generated method stub
		List<FacebookUser> ll=new ArrayList<FacebookUser>();
		FacebookUser f1=new FacebookUser();
		f1.setName("mohan");
		f1.setAddress("Chennai");
		FacebookUser f2=new FacebookUser();
		f2.setName("Chunnilal");
		f2.setAddress("Mumbai");
		ll.add(f1);
		ll.add(f2);
		/*try {
			PreparedStatement ps=con.prepareStatement("select * from friendlist where name=?");
			ps.setString(1, fu.getName());
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				FacebookUser f=new FacebookUser();
				f.setName(res.getString(1));
				f.setAddress(res.getString(4));
				ll.add(f);
			}
		}
		*/
		return ll;
	}
}