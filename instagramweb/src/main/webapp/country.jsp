
<%@page import="java.util.*,com.instagramweb.service.InstagramServiceInterface,com.instagramweb.utility.ServiceFactory" %>


<%-- InstagramServiceInterface fs=ServiceFactory.createObject("admin service");
List<String> i=fs.country(); --%>

<%
List<String> i=new ArrayList<String>();
i.add("India");
i.add("US");
String ss="<select>";
for(String ll:i){
	ss=ss+"<option>"+ll+"</option>";
}
ss=ss+"</select>";
out.println(ss);
%>