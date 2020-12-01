<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<c:set var="theLocale" value="${not empty param.theLocale ? param.theLocale : pageContext.request.locale}" scope="session" />

<fmt:setLocale value="${theLocale}" />

<fmt:setBundle basename="com.champlain.jsp.tagdemo.i18n.resources.mylabels"/>

<html>
<body>

    <a href="i18n-messages-test.jsp?theLocale=en_US">English (US)</a> |
    <a href="i18n-messages-test.jsp?theLocale=pt_BR">Portugues (BR)</a> |
    <a href="i18n-messages-test.jsp?theLocale=fr_CA">French (CA)</a> <br><hr>

    <fmt:message key="label.greeting"/>
    <br><br>
    <fmt:message key="label.firstname"/> : <i>John</i><br>
    <fmt:message key="label.lastname"/> : <i>Doe</i><br><br>
    <fmt:message key="label.welcome"/><br>

    <hr>
    The selected locale is: ${theLocale}

</body>

</html>