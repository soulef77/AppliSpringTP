<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Page de AutreServlet</h1>

<%! String ville="Paris"; %>
<%! declaration %>codepostal: 7700 <% declaration %>

<h2 style="color: red">
	<%= ville %>
</h2>
</body>
</html>