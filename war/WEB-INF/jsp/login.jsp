<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>

<html>
	<head><title>Rantz</title></head>
	<body>
		<html:form action="/login.htm" method="POST">
			<html:text property="loginForm.userName" title="User Name"/>
			<html:text property="loginForm.password" title="Password:"/>
		</html:form>
	</body>
</html>