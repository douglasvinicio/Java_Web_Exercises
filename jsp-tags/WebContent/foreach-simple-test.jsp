<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<%
// Just create some sample data - Normally provided by MVC
String[] cities = {"Paris" , "Madrid" , "Montreal" , "Sao Paulo"};
pageContext.setAttribute("myCities", cities);

%>

<body>

<c:forEach var="tempCity" items="${myCities}">${tempCity}<br></c:forEach>

</body>
</html>