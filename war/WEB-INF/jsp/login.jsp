<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>

<html>
	<head><title>Rantz</title></head>
	<body>
		<form method="POST" action="j_acegi_security_check">
			<b>Username: </b><input type="text" name="j_username"><br>
			<b>Password: </b><input type="password" name="j_password"><br>
			<input type="submit" value="Login">
		</form>		
	</body>
</html>