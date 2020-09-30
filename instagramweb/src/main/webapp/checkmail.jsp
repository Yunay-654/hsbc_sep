<%@page import="com.instagramweb.entity.InstagramUser,java.util.*,com.instagramweb.service.InstagramServiceInterface,com.instagramweb.utility.ServiceFactory" %>
<% 
String email=request.getParameter("email");//its also a jquey part
InstagramUser iu=new InstagramUser();
iu.setEmail(email);
InstagramServiceInterface is=ServiceFactory.createObject("admin service");
int j=is.checkmailService(iu);
if(j>0){%>
<font color=red>email already exists.Please enter a new email</font>
 <% }
else{ %>
	<font color=green>VALID MAIL</font>
<% }
%>
