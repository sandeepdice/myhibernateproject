<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head><title>Rantz</title></head>
	<body>
		<form method="post" action="<%=request.getContextPath()%>/addItem.htm">
			<select name="categoryId">
				<c:forEach items="${categoryList}" var="category">
					<option value="<c:out value="${category.categoryId}"/>">
						<c:out value="${category.categoryName}"/>
					</option> 
				</c:forEach>
			</select>
			<br/>
			Display Name: <input type="text" name="displayName"/><br/>
			Price: <input type="text" name="price"/><br/>
			Price Currency: <input type="text" name="priceCurrency"/><br/>
			<input type="submit"/><br/>			
		</form>
	</body>
</html>