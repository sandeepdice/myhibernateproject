<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<body>
		<form method="post" action="<%=request.getContextPath()%>/uploadResource.htm" enctype="multipart/form-data">
			Image File: <input type="file" name="file"/><br/>
			<input type="submit"/><br/>
			<input type="hidden" name="itemId" value=<%=itemIdFromSuccessView%>/>		
		</form>
	</body>
</html>