<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>

<form action="/login.htm" method="post">
<head><title>Rantz</title></head>
<body>
<h2>Category Details: </h2>
<bean:define id="myMap" name="categoryItemsMap" type="java.util.Map"/>
<logic:iterate id="mapEntry" name="categoryItemsMap" type="java.util.Map.Entry">
	<logic:equal name="mapEntry" property="key" value="category">
		Category List using Struts tags:
			<logic:iterate id="categoryListIter" name="mapEntry" property="value" type="standalone.beans.Category">
				<bean:write name="categoryListIter" property="categoryName"/>
			</logic:iterate>
	</logic:equal>
	<logic:equal name="mapEntry" property="key" value="items">
		Item List using Struts tags:
			<logic:iterate id="itemListIter" name="mapEntry" property="value" type="standalone.beans.Item">
				<bean:write name="itemListIter" property="description"/>
			</logic:iterate>
	</logic:equal>	
</logic:iterate>
<a href="<%=request.getContextPath()%>/login.htm">Login</a>
</body>
</form>