<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>HELLO JSP FILE</h1>
<h2>${msg}</h2>
<h2>prenom : ${prenom}</h2>
<h2>nous sommmes le : ${date}</h2>
<h2>il est : ${heure}</h2>
<hr>

<form action="autre" method="post">
	<p>prenom: <input type="text" name="prenom">
	</p>
	<p>age: <input type="text" name="age">
	</p>
	<input type="submit" value="Valider">
</form>

</body>
</html>