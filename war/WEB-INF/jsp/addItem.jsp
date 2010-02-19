<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>

<html>
	<head><title>Rantz</title></head>
	<body>
		<form method="post" action="<%=request.getContextPath()%>/addItem.htm">
			<html:select property="states">
			</html:select>
		</form>
	</body>
</html>