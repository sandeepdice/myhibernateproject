<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head><title>Add Employee</title></head>
	<body>
		<form method="post" action="<%=request.getContextPath()%>/addEmployee.htm" enctype="multipart/form-data">
			<br/>
			First Name: <input type="text" name="firstName"/><br/>
			Last Name: <input type="text" name="lastName"/><br/>
			Age: <input type="text" name="age"/><br/>
			Car Type: <input type="text" name="carType"/> <br/>
			<input type="submit"/><br/>			
		</form>
	</body>
</html>