package com.instagramweb.controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.instagramweb.entity.InstagramUser;
import com.instagramweb.service.InstagramServiceInterface;
import com.instagramweb.utility.ServiceFactory;

import java.io.PrintWriter;
/**
 * Servlet implementation class RegistrationServlet
 */
public class RegisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		InstagramServiceInterface fs=ServiceFactory.createObject("admin service");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		InstagramUser fu=new InstagramUser();
		fu.setAddress(address);
		fu.setEmail(email);
		fu.setName(name);
		fu.setPassword(password);
		int i=0;
		try {
			i=fs.createprofileService(fu);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(i>0) {
		out.println("<html><body>");
		out.println("Registration successful"+" <a href=Login.html>Continue</a>");
		  out.println("Your Nameis "+name);
		  out.println("<br>Your Password "+password);
		  //out.println("<br> Your Email is "+n3);
		  //out.println("<br> Your Address is "+n4);
		  out.println("</body></html>");
		  }
		else {
			out.println("<html><body>");
			  out.println("Not inserted");
			  out.println("</body></html>");
		}
	}

}
