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
		Sub-Category List:
		<br/>
			<logic:empty name="mapEntry" property="value">
				There no Sub-Categories under this Category. 
			</logic:empty>
			<logic:notEmpty name="mapEntry" property="value">		
				<logic:iterate id="categoryListIter" name="mapEntry" property="value" type="standalone.beans.Category">
					<a href="<%=request.getContextPath()%>/getCategoryNItems.htm?categoryId=<%=categoryListIter.getCategoryId()%>">
						<bean:write name="categoryListIter" property="categoryName"/></a>
					<br/>
				</logic:iterate>
			</logic:notEmpty>
	</logic:equal>
	<br/>
	<logic:equal name="mapEntry" property="key" value="items">
		Item List:
		<br/>
			<logic:empty name="mapEntry" property="value">
				There are no items under this Category. Browse through Sub-Categories
			</logic:empty>
			<logic:notEmpty name="mapEntry" property="value">			
				<logic:iterate id="itemListIter" name="mapEntry" property="value" type="standalone.beans.Item">
					<html:img page="/resources/Images/<%=itemListIter.getFileName()%>"/>
					<bean:write name="itemListIter" property="description"/>
					<br/>
				</logic:iterate>
			</logic:notEmpty>
	</logic:equal>	
</logic:iterate>
<br/>
<a href="<%=request.getContextPath()%>/login.htm">Login</a>
<a href="<%=request.getContextPath()%>/hello.htm">Login</a>
</body>
</form>