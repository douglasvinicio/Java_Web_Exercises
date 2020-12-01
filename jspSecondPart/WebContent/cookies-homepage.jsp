<html>
<head>
<title>Show Results</title>
</head>

<body>

<!-- Read the favorite programming language COOKIE -->

<%

//By Default if there are no cookies
String favLang = "Java";

//Get cookies from the browser request
Cookie[] theCookies = request.getCookies();

//Find out favorite language cookie
if(theCookies != null ){
	for(Cookie tempCookie : theCookies){
		if("myApp.favorite_language".equals(tempCookie.getName())){
			favLang = tempCookie.getValue();
			break;
		}
	}
}

%>


<!-- Show a personalized page using favLang variable -->

<!-- Show new books for this lang -->

<h4>New Books for <%= favLang %></h4>
<ul>
<li>Dummy Data</li>
<li>Dummy Data</li>
<li>Dummy Data</li>
<li>Dummy Data</li>
</ul>



<h4>New reports for <%= favLang %></h4>
<ul>
<li>Dummy Data</li>
<li>Dummy Data</li>
<li>Dummy Data</li>
<li>Dummy Data</li>
</ul>


<h4>New Hot Jobs for <%= favLang %></h4>
<ul>
<li>Dummy Data</li>
<li>Dummy Data</li>
<li>Dummy Data</li>
<li>Dummy Data</li>
</ul>

<hr>
<a href="cookies-personalize-form.html">Personalize this page</a>
</body>
</html>