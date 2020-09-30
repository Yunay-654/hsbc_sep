package com.facebookweb.controller;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookServiceInterface;
import com.facebookweb.utility.FacebookException;
import com.facebookweb.utility.ServiceFactory;

import java.io.PrintWriter;
/**
 * Servlet implementation class RegistrationServlet
 */
public class FriendList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//passing data through session for security
		//String name=request.getParameter("name");
		HttpSession ss=request.getSession(true);
		String name=ss.getAttribute("userid").toString();
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		FacebookServiceInterface fs=ServiceFactory.createObject("admin service");
		List<FacebookUser> ll=fs.friendProfileService(fu);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		if(ll.size()>0) {
		for(FacebookUser f:ll) {
			out.println(f.getName());
		}
		
		  }
		else {
			out.println("no friend found");
		}
		out.println("</body></html>");
	}

}
