<%@ page import="java.util.*"%>

<html>
<head>
<title>To-Do List</title>
</head>
<body>
	<h1>To Do</h1>

	<!-- Step 1 -  HTML Form -->
	<form action="todo-demo.jsp">
		Add new item: <input type="text" name="item" /> <input type="submit"
			value="Submit" />
	</form>

	<!-- Step 2 - Add new item to "To Do" list -->

	<%
		//Get the To Do list items from the session 
	List<String> items = (List<String>) session.getAttribute("myToDoList");

	//If the To Do item does not exist, then create a new one. 
	if (items == null) {
		items = new ArrayList<String>();
		session.setAttribute("myToDoList", items);
	}

	//See if there is form data to add 

	String theItem = request.getParameter("item");
	if (theItem != null) {
		items.add(theItem);
	}
	%>
	<!-- Step 3 - Display all "To Do" items from session -->
	<hr>
	<b>To Do List Items</b>
	<ol>

		<%
			for (String temp : items) {
			out.print("<li>" + temp + "</li>");
		}
		%>

	</ol>

</body>
</html>