<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>

<html>
	<head><title>Rantz</title></head>
	<body>
		<form method="post" action="<%=request.getContextPath()%>/login.htm">
			<table border = "1">
			<tr><td>Login Id: <input type="text" name="loginId" title="loginId: "/></td></tr>
			<tr><td>Password: <input type="text" name="password"/></td></tr>
			<tr><td><input type="submit" name="submit" value="Submit"/></td></tr>
			</table>
		</form>
	</body>
</html>