
<%
      String n=request.getParameter("name");
       if(n.equals("rajesh")){
    	   out.println("<font color=red>INVALID USER</font>");
    	   //if we write without out.println ,then also no problem
       }
       else{%>
    	   <font color=green>VALID USER</font>
      <% }



%>