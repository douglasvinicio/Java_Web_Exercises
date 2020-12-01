
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <style>
	p, h1, h2, h3 {
		text-align:center;
	}
    </style>
    <title>JSP Expressions</title>
</head>
<body>
	<h2>JSP Expressions Examples</h2>	
	<h3>Converting Strings</h3>
	<p> Converting a string to Upper Case:  <%= new String("hello world!").toUpperCase() %></p>	
	<h2> More Examples JSP Expression </h2><br>
	<p>	25 Multiplied by 4 equals : <%= 25 * 4 %><br>
	<p> Is 75 less than 69? <%= 75 < 9 %></p>
</body>
</html>