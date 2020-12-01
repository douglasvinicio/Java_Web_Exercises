<html>
<head>
<title>Student Drop-Down Response</title>
</head>
<body>
The student is confirmed. 
He's first name is <b>${ param.first_name }</b> and last name is <b> <%= request.getParameter("last_name") %></b>
and he's favorite programming language is <b>${ param.favorite_language}</b>
</body>
</html>