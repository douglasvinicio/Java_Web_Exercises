<html>
<head>
<title>Student Check Box Response</title>
</head>
<body>
The student is confirmed. 
He's first name is <b>${ param.first_name }</b> and last name is <b> <%= request.getParameter("last_name") %></b>.
<br><br>



<!-- Display the list of "favorite_language" -->
<% 
	String[] langs = request.getParameterValues("favorite_language");

	if(langs.length > 1){
		out.println("The students favorites languages are : ");
		for(String langsTemp : langs){
			out.print("<li>" + langsTemp + "</li>");
		}
	}
	else{
		out.println("The student favorite language is : ");
		for(String langsTemp : langs){
			out.print("<li>" + langsTemp + "</li>");
		} 
	}
	
	

%>

<%-- 
 - The user can check multiple boxes and the answer is saved inside an array;
 - Then the array is returned as an HTML response.
 
 String[] langs = request.getParameterValues(""favorite_language);
  --%>
</body>
</html>