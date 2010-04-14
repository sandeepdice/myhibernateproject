<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>

<form action="/login.htm" method="post">
<body>

<table border="1">
	<logic:iterate id="item" name="itemList" type="standalone.beans.Item">
		<tr>
			<td><%=item.getItemId() %></td>
			<td><%=item.getDisplayName() %></td>
			<td><%=item.getPrice() %></td>
			<td>
				<logic:equal name="item" property="resourceId" value="">
					<a href="<%=request.getContextPath() %>/addResource.htm</a>">Add Resource</a>
				</logic:equal>
				<logic:notEqual name="item" property="resourceId" value="">
					<%=item.getResourceId() %> <a href="<%=request.getContextPath() %>/updateResource.htm?resourceId=<%=item.getResourceId() %>:itemId=<%=item.getItemId() %>">
					Update Resource</a>
				</logic:notEqual>
			</td>
		</tr>
	</logic:iterate>
</table>
<a href="<%=request.getContextPath()%>/login.htm">Login</a>
<a href="<%=request.getContextPath()%>/addItem.htm">Add Item</a>
</body>
</form>