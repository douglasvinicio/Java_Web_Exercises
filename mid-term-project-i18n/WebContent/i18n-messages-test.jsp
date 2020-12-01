<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="theLocale"
	value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale}"
	scope="session" />

<fmt:setLocale value="${theLocale}" />

<fmt:setBundle basename="com.ipd22.i18n.resources.mylabels" />

<html>
<head>
<title>IPD-22 MidTerm Exam / JSP - JSTL - Servlets</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>

	<a href="i18n-messages-test.jsp?theLocale=en_US">English (US)</a> |
	<a href="i18n-messages-test.jsp?theLocale=fr_CA">French (CA)</a>
	<br>
	<hr>

	<b><fmt:message key="label.movietitle" /></b>
	: The Shawshank Redemption
	<br>
	<b><fmt:message key="label.year" /></b>
	: 1994
	<br>
	<b><fmt:message key="label.director" /></b>
	: Frank Darabont
	<br>
	<b><fmt:message key="label.country" /></b>
	: USA
	<br>

	<hr>
	The selected locale is: <b>${theLocale}</b>

</body>

</html>