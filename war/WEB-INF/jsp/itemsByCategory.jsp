<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>

<form action="/login.htm" method="post">
<head><title>Rantz</title></head>
<body>
<h2>Category Details: </h2>
<%
	java.util.Map categoryItemsMap = new java.util.HashMap();
	for (java.util.Iterator it = categoryItemsMap.entrySet().iterator(); it.hasNext();) {
		java.util.Map.Entry entry = (java.util.Map.Entry) it.next();
	   String key = (String)entry.getKey();
	   // do something with the key and the value
	   if(key.equalsIgnoreCase("category"))
	   {
		   java.util.List<standalone.beans.Category> categoryList = (java.util.List<standalone.beans.Category>)entry.getValue();   
	   }
	}
%>
<a href="<%=request.getContextPath()%>/login.htm">Login</a>
</body>
</form>