<%@ taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles" %>
<html>
	<head>
		<title><tiles:getAsString name="title"/></title>
	</head>
	<body>
		<table width="100%" border="0">
			<tr>
				<td><h1><tiles:getAsString name="header"/></h1></td> 
			</tr>
			<tr>
				<td valign="top" align="left">
					<div id="left-pane">
						<tiles:insert name="left"/>
					</div>
					<div id="right-pane">
						<tiles:insert name="right"/>				
					</div>
				</td>				
			</tr>
			<tr>
				<td>
					<tiles:insert name="footer"/>
				</td>
			</tr>
		</table>
	</body>
</html>