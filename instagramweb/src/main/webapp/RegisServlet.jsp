<%@ page import="com.instagramweb.entity.InstagramUser,com.instagramweb.service.InstagramServiceInterface,com.instagramweb.utility.ServiceFactory "%>
    <%
    String name=request.getParameter("name");
	String password=request.getParameter("password");
	String email=request.getParameter("email");
	String address=request.getParameter("address");
	
	InstagramUser fu=new InstagramUser();
	fu.setName(name);
	fu.setAddress(address);
	fu.setEmail(email);
	fu.setPassword(password);
	
	InstagramServiceInterface fs=ServiceFactory.createObject("admin service");
	int i=fs.createprofileService(fu);
	if(i>0) { %>
	Registration successful   <a href=login.html>Continue...</a>
       Your Name is  <%= name %>
                <br>Your Password is<%= password %>
                
<%} %>
