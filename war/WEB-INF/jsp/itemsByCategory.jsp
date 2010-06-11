<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean" %>

<SCRIPT LANGUAGE="JavaScript">
<!-- Idea by:  Nic Wolfe -->
<!-- This script and many more are available free online at -->
<!-- The JavaScript Source!! http://javascript.internet.com -->

<!-- Begin
function popUp(URL) {
day = new Date();
id = day.getTime();
eval("page" + id + " = window.open(URL, '" + id + "', 'toolbar=0,scrollbars=0,location=0,statusbar=1,menubar=1,resizable=0,width: 387px; height: 500px;');");
}
// End -->
</script>

<form action="/login.htm" method="post">
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
					<%=itemListIter.getFileName()%>
					<img src="<%=request.getContextPath()%>/getImage.image?imgId=<%=itemListIter.getCategoryId()%>" title="test title" height=100 width=75 onclick="javascript:popUp('<%=request.getContextPath()%>/getImage.image?imgId=<%=itemListIter.getCategoryId()%>')"/>
					<bean:write name="itemListIter" property="description"/>
					<br/>
				</logic:iterate>
			</logic:notEmpty>
	</logic:equal>	
</logic:iterate>

</body>
</form>