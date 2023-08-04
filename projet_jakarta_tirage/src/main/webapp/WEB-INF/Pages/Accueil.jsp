<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="assets/bs/css/bootstrap.css" />
<link rel="stylesheet" href="assets/css/css/app.css">
<title>Application</title>
</head>
<body>
<div class="content" style=" background-color: yellow; width: 50%;">
		<div class="header">Tirage aléatoire</div>
		<div class="monForm shadow mt-5">
			<div class="titre bg-primary">APPLICATION DE JEUX</div>
			<form method="post">
				<div class="mb-3" >
					<label for="nbre" class="form-label">Introduisez votre nombre</label> <input name="nbre"
						type="text" class="form-control" id="nbre"
						>
				</div>
				
				<div>
					<input type="submit" name="submit" value="Valider votre choix" class="btn btn-primary" /> <input
						type="reset" value="tout recommencer" class="btn btn-secondary float-end" />
				</div>
				<div><p>Nombre de tentative : ${nbreTentative}</p></div>
				
				<% 
				String result = (String) request.getAttribute("nbre");
							System.out.println(" VALEUR" + result);
				if(result != null) {
			%>
				<div><p>commentaire : ${comment}</p></div>
				<div class=" result alert alert-success"><%= result %></div>
			<% } %>  
			<% 
				String erreur = (String) request.getAttribute("erreur");
				String comment = (String) request.getAttribute("comment");
				if(erreur != null){
			%>
			<% } %>
			<div class= "error alert alert-danger"><%= erreur %></div>
			<table>
			<%
				String historique = (String) request.getAttribute("historique");
			if(historique != null) {
							
			%>
			  <caption>Historiques</caption>
				
				<tr> <th>Valeurs enregistrées</th>  <th>VALEUR</th> </tr>
				
					<tr> <td>1ère valeure</td>  <td>historique</td> </tr>
					
					<tr> <td>2ème valeure</td>  <td>110 €</td> </tr>
					
					<tr> <td>3ème valeure</td>  <td>200 €</td> </tr>
					
					<tr> <td>4ème valeure</td>  <td>200 €</td> </tr>
				
			</table>
			<% } %>   
					
		</form>
		</div>
	</div>
</body>
</html>