package com.instagram.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.instagram.utility.InstagramException;
import com.instagram.entity.InstagramUser;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;
public class InstagramDAO implements InstagramDAOInterface {

	public int createProfileDAO(InstagramUser iu)throws Exception {
		
		int i=0;
		
		//step 1 load driver
		/*important commented just for time being
		 * Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		 
		
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
		*/
File f1=new File("C:\\Users\\nEW u\\Documents\\TrainingHSBCJAVAsts\\instagram\\DBFile.txt");
		
		FileOutputStream out=new FileOutputStream(f1);
		
		String name=iu.getName();
		String password=iu.getPassword();
		String email=iu.getEmail();
		String address=iu.getAddress();
		
		for(int j =0; j<name.length(); j++)
			out.write(name.charAt(j));
		out.write('\n');
		for(int j =0; j<password.length(); j++)
			out.write(password.charAt(j));
		
		out.write('\n');
		for(int j =0; j<email.length(); j++)
			out.write(email.charAt(j));
		out.write('\n');
		for(int j=0;j<address.length();j++)
			out.write(address.charAt(j));
		out.close();			
		return i;

	}

	public int editProfileDAO(InstagramUser iu) throws Exception{
		// TODO Auto-generated method stub
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int i=0;
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
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

	public int deleteProfileDAO(InstagramUser iu)throws Exception {
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

	public List<InstagramUser> searchProfileDAO(InstagramUser iu)throws InstagramException {
		List<InstagramUser> ll=new ArrayList<InstagramUser>();
		Connection con=null;
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
		PreparedStatement ps=con.prepareStatement("select * from instagramuser where name=?");
		ps.setString(1, iu.getName());
		
		ResultSet res=ps.executeQuery();
		
		//List<InstagramUser> ll=new ArrayList<InstagramUser>();
		
		while(res.next()) {
			InstagramUser uu=new InstagramUser();
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

	public List<InstagramUser> viewallProfileDAO()/*throws Exception*/ {
		Connection con=null;
		List<InstagramUser> ll=null;
	
		try {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
		PreparedStatement ps=con.prepareStatement("select * from instagramuser");
				
		ResultSet res=ps.executeQuery();
		
		ll=new ArrayList<InstagramUser>();
		
		while(res.next()) {
			InstagramUser uu=new InstagramUser();
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

	public InstagramUser viewProfileDAO(InstagramUser iu) throws Exception{
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		Connection con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
		PreparedStatement ps=null;
		String s="";
		/*if(iu.getName()!=null)//null camparison giving error {
		 * means you may use .equals way or you may use .isEmpty() method of string comparison
		 * */
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
		
		InstagramUser uu=null;
		
		if(res.next()) {
			uu=new InstagramUser();
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
	public Map<String, List<InstagramUser>> userdetailwithhistorydao() {
		Map<String, List<InstagramUser>> m=new HashMap<String, List<InstagramUser>>();
		
		List<InstagramUser> l1=viewallProfileDAO();
		List<InstagramUser> l2=viewallProfileDAO();
		
		m.put("studentlist", l1);
		m.put("proflist", l2);
		
		return m;
	}

}















