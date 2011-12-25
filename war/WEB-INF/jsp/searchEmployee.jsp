<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head><title>Search Employee</title></head>
	<body>
		<form method="post" action="<%=request.getContextPath()%>/getEmpList.htm" enctype="multipart/form-data">
			<br/>
			First Name: <input type="text" name="firstName"/><br/>
			<input type="submit"/><br/>			
		</form>
	</body>
</html>