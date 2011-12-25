<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>

<form action="/login.htm" method="post">
<body>

<table border="1">
	<logic:iterate id="item" name="employeeList" type="hibernatebook.ch01.UserInfo">
		<tr>
			<td><%=item.getFirstName() %></td>
			<td><%=item.getLastName() %></td>
			<td><%=item.getAge() %></td>
		</tr>
	</logic:iterate>
</table>
</body>
</form>