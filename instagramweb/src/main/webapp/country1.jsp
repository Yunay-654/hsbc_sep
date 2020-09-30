
<%@page import="java.util.*,com.instagramweb.service.InstagramServiceInterface,com.instagramweb.utility.ServiceFactory" %>
<%@page import="com.instagramweb.entity.Country" %>

<%--FacebookServiceInterface fs=ServiceFactory.createObject("user");
List<String> i=fs.country(); --%>

<%
String cname=request.getParameter("cname");//its also a jquey part
Country c=new Country();
c.setCname(cname);
InstagramServiceInterface is=ServiceFactory.createObject("admin service");
List<String> ll=is.countryService();

String ss="<select id=cc name=country   onchange=loadstate()>";
for(String ll1:ll){
	ss=ss+"<option value='"+ll1+"'>"+ll1+"</option>";
}
ss=ss+"</select>";

out.println(ss);
%>