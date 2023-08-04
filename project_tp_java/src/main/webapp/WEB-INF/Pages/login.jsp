<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="assets/bs/css/bootstrap.css" />
<link rel="stylesheet" href="assets/css/css/app.css">
<title>TEST</title>
</head>
<body>
<div class="content" style=" background-color: white; width: 50%;">
		<div class="header" style=" background-color: #303f9f;">JSP-FILTER-CRUD</div>
		<div class="monForm shadow mt-5">
			<div class="titre"  style=" background-color: #303f9f;">LOGIN FORM</div>
				
				<form>
					  <div class="mb-3">
					    <label for="exampleInputEmail1" class="form-label" >Adresse mail</label>
					    <input type="email" class="form-control" id="exampleInputEmail1" name= "email" aria-describedby="emailHelp">
					    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
					  </div>
					  <div class="mb-3">
					    <label for="exampleInputPassword1" class="form-label">Mot de passe</label>
					    <input type="password" class="form-control" name="mdp" id="exampleInputPassword1">
					  </div>
					   <button type="submit" style=" background-color: #303f9f;" name= "submit">Valider</button>
					   <button type="reset" style=" background-color: #8c9eff;" >Reset</button>
					  
				</form>
					
		</div>
	</div>
</body>
</html>