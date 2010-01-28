<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>

<form action="/login.htm" method="post">
<head><title>Rantz</title></head>
<body>
<h2>Welcome to RoadRantz!</h2>
<h3>Recent rantz:</h3>
<logic:iterate id="category" name="rants" type="standalone.beans.Category">
	<logic:equal name="${category.parentCategoryId}" value="0">
		<%=category.getCategoryName()%>
		<%=category.getCategoryId()%>
		<%=category.getParentCategoryId()%>
		<%=category.getDescription()%>
	</logic:equal>
</logic:iterate>
<a href="<%=request.getContextPath()%>/login.htm">Login</a>
</body>
</form>