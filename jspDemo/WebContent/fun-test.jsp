<%@page import="com.champlain.jsp.FunUtils"%>
<html>
	<body>
		
		<h1>Let's have fun today with JSP -> <%= com.champlain.jsp.FunUtils.makeItLower("THIS WAS ALL IN CAPS LOCK!!!") %></h1>
		
		<h2><%= FunUtils.makeItLower("This ONE is USING IMPORTED PACKAGE!") %></h2>
		
	</body>
</html>

