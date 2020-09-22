package com.instagram.controller;
import com.instagram.utility.*;
import com.instagram.utility.InstagramException;
import com.instagram.utility.SortByAddress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.List;
import java.util.Map;
import com.instagram.entity.InstagramUser;
import com.instagram.service.InstagramService;
import com.instagram.service.InstagramServiceInterface;
import java.util.*;
import java.lang.*;
public class InstagramController implements InstagramControllerInterface {
	
	private InstagramServiceInterface is;
	
	public InstagramController() {
		//is=new InstagramService();
		is=ServiceFactory.createObject("admin service");
	}

	public void createProfile() throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your Name : ");
		String name=br.readLine();
		
		System.out.println("Enter your Password : ");
		String password=br.readLine();
		
		System.out.println("Enter your Email : ");
		String email=br.readLine();
		
		System.out.println("Enter your Address : ");
		String address=br.readLine();
		
		InstagramUser iu=new InstagramUser();
		iu.setName(name);
		iu.setPassword(password);
		iu.setEmail(email);
		iu.setAddress(address);
		
		
		int i=is.createprofileService(iu);//we should not transfer concrete data
		
		if(i>0) {
			System.out.println("profile created");
		}
		else {
			System.out.println("could not create profile");
		}

	}

	public void editProfile()throws Exception {
		viewProfile();
		int i=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//is.editprofileService();
		System.out.println("*********************************MAIN MENU************************");
		System.out.println("press 1 to edit name");
		System.out.println("press 2 to edit passworrd");
		System.out.println("press 3 to edit address");
		System.out.println("press 4 to edit email");
		System.out.println("Enter your choice");
	     int ch=Integer.parseInt(br.readLine());
	     InstagramUser iu=new InstagramUser();
		//int ch=br.readLine();
	     String name="",email="",password="",address="";
		switch(ch) {
		case 1:
			System.out.println("Enter the new name you want to update: ");
			name=br.readLine();
			System.out.println("Enter your original email : ");
			 email=br.readLine();
			iu.setName(name);
			iu.setEmail(email);
			i=is.editprofileService(iu);
		       break;
		case 2:
			System.out.println("Enter the new password you want to update: ");
			password=br.readLine();
			System.out.println("Enter your original address : ");
			address=br.readLine();
			iu.setPassword(password);
			iu.setAddress(address);
			i=is.editprofileService(iu);
		       break;
		       //inside switch case ,even if cases are different,you cant declare same variable 2 times ,else it will give eeror,eg:in case 1 we gave String email and in case 2 also we gave String email ,then it was showing error duplicate varble.
		
		case 3:
			System.out.println("Enter the new email you want to update: ");
			 email=br.readLine();
			System.out.println("Enter your original password : ");
			password=br.readLine();
			iu.setEmail(email);
			iu.setPassword(password);
			i=is.editprofileService(iu);
		       break;
		case 4:
			System.out.println("Enter the new address you want to update: ");
			 address=br.readLine();
			System.out.println("Enter your original email : ");
			email=br.readLine();
			iu.setAddress(address);
			iu.setEmail(email);
			i=is.editprofileService(iu);
		       break;
		default:
			
			System.out.println("Invalid user input");
		}
		if(i>0) {
			System.out.println("profile edited");
		}

	}

	public void deleteProfile() throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Email to delete profile : ");
		String email=br.readLine();
		
		InstagramUser iu=new InstagramUser(); //this object is used for transfering data from controller to service
		iu.setEmail(email);
		
		
		int uu=is.deleteprofileService(iu);//this object is used for taking data from service to controller
		if(uu>0) {
			System.out.println("User with email"+email+"profile deleted");
		}
		else {
			System.out.println("User with email : "+email+" not exist");
		}

	}

	public void searchProfile() {
		try {
		BufferedReader br=null;
		String name=null;
		 br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Name to search profile : ");
		name=br.readLine();
		if(name.length()<3) {
			throw new InstagramException(name);
		}
		InstagramUser iu=new InstagramUser(); //this object is used for transfering data from controller to service
		iu.setName(name);
		
		List<InstagramUser> uu=is.searchprofileService(iu);
		
		System.out.println(uu.size()+"  users found");
		
		for(InstagramUser u:uu) {
			System.out.println("****************************************");
			System.out.println("Name is : "+u.getName());
			System.out.println("Password is : "+u.getPassword());
			System.out.println("Email is : "+u.getEmail());
			System.out.println("Address is : "+u.getAddress());
			System.out.println("****************************************");
		}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("custom exception occured "+e);
		}
		catch (InstagramException e1) {
			// TODO Auto-generated catch block
			System.out.println("custom exception occured "+e1.uu());
			//System.out.println("custom exception occured "+e1);
			//System.out.println("custom exception occured "+e1.toString());
		}

	}

	public void viewAllProfile(){
		List<InstagramUser> uu=is.viewallprofileService();
		Collections.sort(uu,new SortByAddress());
		System.out.println(uu.size()+"  users found");
		
		for(InstagramUser u:uu) {
			System.out.println("****************************************");
			System.out.println("Name is : "+u.getName());
			System.out.println("Password is : "+u.getPassword());
			System.out.println("Email is : "+u.getEmail());
			System.out.println("Address is : "+u.getAddress());
			System.out.println("****************************************");
		}

	}

	public void viewProfile()throws Exception {
		int i=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//System.out.println("Enter Name to view profile : ");
		//String name=br.readLine();
		System.out.println("*********************************MAIN MENU************************");
		System.out.println("press 1 to view  profile by name");
		System.out.println("press 2 to view profile by password");
		System.out.println("press 3 to view profile by email");
		System.out.println("press 4 to view profile by address");
		/*System.out.println("what field you want to enter: ");
		String input=br.readLine();
		InstagramUser iu=new InstagramUser(); 
	//this object is used for transferring data from controller to service
		if(input.equals("name")) {
		String name=br.readLine();
		iu.setName(name);
		}
		else if(input.equals("password")) {
			String password=br.readLine();
			iu.setPassword(password);
			}
		else if(input.equals("email")) {
			String email=br.readLine();
			iu.setName(email);
			}
		else if(input.equals("address")) {
			String address=br.readLine();
			iu.setName(address);
			}
		else {
			System.out.println("Invalid user ip");
		}*/
		System.out.println("Enter your choice");
		i=Integer.parseInt(br.readLine());
		InstagramUser iu=new InstagramUser();
		switch(i) {
		case 1:
			System.out.println("Enter name of user of whom you want to view profile");
			String name=br.readLine();
			iu.setName(name);
			break;
		case 2:
			System.out.println("Enter password of user of whom you want to view profile");
			String password=br.readLine();
			iu.setPassword(password);
			break;
		case 3:
			System.out.println("Enter email of user of whom you want to view profile");
			String email=br.readLine();
			iu.setName(email);
			break;
		case 4:
			System.out.println("Enter address of user of whom you want to view profile");
			String address=br.readLine();
			iu.setName(address);
			break;
		default:System.out.println("wrong choice");
		
		}
		InstagramUser uu=is.viewprofileService(iu);//this object is used for taking data from service to controller
		if(uu!=null) {
			System.out.println("User Information is below");
			System.out.println("Name is : "+uu.getName());
			System.out.println("Password is : "+uu.getPassword());
			System.out.println("Email is : "+uu.getEmail());
			System.out.println("Address is : "+uu.getAddress());
		}
		else {
			//System.out.println("User with Name : "+name+" not exist");
			System.out.println("Entered user does not exist");
		}

	}

	public void createcustomtable() throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter table name ");
		String name=br.readLine();
		
		System.out.println("how many column");
		int i=Integer.parseInt(br.readLine());
		
		for(int j=1;j<=i;j++) {
			System.out.println("Enter "+j+" column name");
			String cname=br.readLine();
			System.out.println("Enter "+j+" column data type");
			String cdata=br.readLine();
			System.out.println("Enter "+j+" column size");
			String csize=br.readLine();
		}
		
	}
	@Override
	public void userdetailwithhistory() {
		Map<String, List<InstagramUser>> uu=is.userdetailwithhistoryservice();
		
		List<InstagramUser>  ll=uu.get("studentlist");
		
		for(InstagramUser u:ll) {
			System.out.println("****************************************");
			System.out.println("Name is : "+u.getName());
			System.out.println("Password is : "+u.getPassword());
			System.out.println("Email is : "+u.getEmail());
			System.out.println("Address is : "+u.getAddress());
			System.out.println("****************************************");
		}
		
		
      List<InstagramUser>  ll1=uu.get("proflist");
		
		for(InstagramUser u:ll) {
			System.out.println("****************************************");
			System.out.println("Name is : "+u.getName());
			System.out.println("Password is : "+u.getPassword());
			System.out.println("Email is : "+u.getEmail());
			System.out.println("Address is : "+u.getAddress());
			System.out.println("****************************************");
		}

		
	}

}


















