<html>
<head>
<title>Confirmation - Cookies Practice</title>
</head>

<%
// Read form data
String favLang = request.getParameter("favorite_language");

//Create Cookie object
Cookie theCookie = new Cookie("myApp.favorite_language", favLang);

//Set life span / expiration of the cookie
theCookie.setMaxAge(60 * 60 * 24 * 365);

//Send cookie to browser
response.addCookie(theCookie);
%>

<body>
Thanks we added your favorite language to : ${ param.favorite_language }

<br><br>

<a href="cookies-homepage.jsp">Return to home page</a>
</body>
</html>