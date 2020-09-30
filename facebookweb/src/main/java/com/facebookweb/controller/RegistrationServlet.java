package com.facebookweb.controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookServiceInterface;
import com.facebookweb.utility.FacebookException;
import com.facebookweb.utility.ServiceFactory;

import java.io.PrintWriter;
/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
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
		FacebookServiceInterface fs=ServiceFactory.createObject("admin service");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		FacebookUser fu=new FacebookUser();
		fu.setAddress(address);
		fu.setEmail(email);
		fu.setName(name);
		fu.setPassword(password);
		int i=0;
		try {
			i=fs.createprofileService(fu);
		}
		catch(FacebookException fe) {
			fe.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(i>0) {
		out.println("<html><body>");
		out.println("Registration successful"+" <a href=login.html>Continue</a>");
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
