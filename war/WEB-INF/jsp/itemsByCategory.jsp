<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>

<form action="/login.htm" method="post">
<head><title>Rantz</title></head>
<body>
<h2>Category Details: </h2>
<bean:define id="myMap" name="categoryItemsMap" type="java.util.Map"/>
<%
	for (java.util.Iterator it = myMap.entrySet().iterator(); it.hasNext();) {
		java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
	   String key = (String)entry.getKey();
	   // do something with the key and the value
	   if(key.equalsIgnoreCase("category"))
	   {%>
		  <h2>Category List: </h2>
		  <% 
		   java.util.List<standalone.beans.Category> categoryList = (java.util.List<standalone.beans.Category>)entry.getValue(); 
		   for(java.util.Iterator it1 = categoryList.iterator(); it1.hasNext();) {
			   standalone.beans.Category category = (standalone.beans.Category)it1.next();
			   %>
			   <%=category.getCategoryName() %>
			   <%
		   }
	   }
	   if(key.equalsIgnoreCase("items"))
	   {%>
	   	<h2>Items List: </h2>
		<%
		   java.util.List<standalone.beans.Item> itemList = (java.util.List<standalone.beans.Item>)entry.getValue(); 
		   for(java.util.Iterator it1 = itemList.iterator(); it1.hasNext();) {
			   standalone.beans.Item item = (standalone.beans.Item)it1.next();
			   %>
			   <%=item.getDescription() %>
			   <%
		   }
	   }	   
	}
%>
<a href="<%=request.getContextPath()%>/login.htm">Login</a>
</body>
</form>