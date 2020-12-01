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
    <title>Declaration Test</title>
</head>
<body>
    
	<h1>Hello World of Java</h1>	
	
	<%! 
		String makeItLower(String data){
		return data.toLowerCase();
	}	
	%>
	
	<p> To Lower case "Hello World!" : <%= makeItLower("Hello World!") %></p>


</body>
</html>