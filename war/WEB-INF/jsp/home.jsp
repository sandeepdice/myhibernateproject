<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>

<form action="/login.htm" method="post">
<body>
<h3>Category List:</h3>
<logic:iterate id="category" name="rants" type="standalone.beans.Category">
	<logic:equal name="category" property="parentCategoryId" value="0">
		<a href="<%=request.getContextPath()%>/getCategoryNItems.htm?categoryId=<%=category.getCategoryId()%>">
			<%=category.getCategoryName()%></a>
		<br/>
	</logic:equal>
</logic:iterate>

</body>
</form>