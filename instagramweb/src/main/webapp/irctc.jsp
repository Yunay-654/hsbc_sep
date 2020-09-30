<%@page import="com.instagramweb.entity.IrctcUser,java.util.*,com.instagramweb.service.InstagramServiceInterface,com.instagramweb.utility.ServiceFactory" %>
<%@page contentType="text/html; charset=UTF-8" %>
<% 
String city=request.getParameter("city");//its also a jquey part
IrctcUser iu=new IrctcUser();
iu.setCity(city);
InstagramServiceInterface is=ServiceFactory.createObject("admin service");
List<IrctcUser> ll=is.sourceService();

System.out.println(ll.size()+" users found");
if(city==""){
	
}
else{
List<String> ll1=new ArrayList<String>();
for(IrctcUser u:ll) {
	if (u.getCity().toUpperCase().startsWith(city.toUpperCase())) {
        //ll1.add(u.getCity());//this one is also working fine required when you want to print list at once
        out.println(u.getCity() + "<br>");//this also working  prints one by one
    }
}
//out.println(ll1);
}
%>
