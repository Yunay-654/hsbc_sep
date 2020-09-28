package com.instagramweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.instagramweb.entity.InstagramUser;
import com.instagramweb.service.InstagramServiceInterface;
import com.instagramweb.utility.ServiceFactory;

/**
 * Servlet implementation class LoginServlet
 */
public class Login extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		
		InstagramUser fu=new InstagramUser();
		fu.setName(name);
		fu.setPassword(password);
		
		
		InstagramServiceInterface fs=ServiceFactory.createObject("admin service");
		boolean i=false;
		try {
			i = fs.loginprofileService(fu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		if(i) {
			
			HttpSession ss=request.getSession(true);
			ss.setAttribute("userid", name);
			ss.setAttribute("pass", password);
			
			out.println("welcome "+name);
	
		}
		else {
			out.println("Invalid id and password");
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/Login.html");
			rd.include(request, response);
		}
		out.println("</body></html>");
	}
}
