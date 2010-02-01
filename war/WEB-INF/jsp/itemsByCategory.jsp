<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>

<form action="/login.htm" method="post">
<head><title>Rantz</title></head>
<body>
<h2>Category Details: </h2>
<logic:iterate id="category" name="categoryList" type="standalone.beans.Category">
		<a href="<%=request.getContextPath()%>/getCategory.htm?categoryId=<%=category.getCategoryId()%>">
			<%=category.getCategoryName()%></a>
		<br/>
</logic:iterate>
<a href="<%=request.getContextPath()%>/login.htm">Login</a>
</body>
</form>