<html>
<head>
<title>Student Confirmation</title>
</head>
<body>

The student is confirmed: ${param.first_name } ${param.last_name }
<hr>
The student first name is <b><%= request.getParameter("first_name") %> </b> and the last name is <b> <%= request.getParameter("last_name")%>  </b>

<%-- <%= request.getParameter("first_name") %> <%= request.getParameter("last_name")%> --%>

</body>
</html>


