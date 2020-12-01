<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<html>

<body>

<!--  Setting  a variable using core tag -->
<c:set var="data" value="champlain"></c:set>

Length of the string <b>${data}</b>: ${fn:length(data)}

<br><br>

The uppercase version of the string <b>${data}</b>: ${fn:toUpperCase(data)}
<br><br>

Does the string <b>${data }</b> start with <b>champ</b>? ${ fn:startsWith(data, "champ")}

</body>

</html>