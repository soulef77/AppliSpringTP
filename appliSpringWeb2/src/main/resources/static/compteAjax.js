/**
 * 
 */
 window.onload=function() {
	 (document.getElementById("btnRechercher")).addEventListener("click", rechercherComptesSelonSoldeMini);
	 (document.getElementById("btnAjout")).addEventListener("click", ajouterCompte);
	 }
	 


function rechercherComptesSelonSoldeMini(){
	 let soldeMini = (document.getElementById("inputSoldeMini")).value;
	 
	 let wsUrl= "./api-bank/compte?soldeMini="+soldeMini;
	 
	 makeAjaxGetRequest(wsUrl, function(responseJSON) {
		 let compteJs = JSON.parse(responseJSON);
		 console.log("compteJs= ", compteJs);
		 
		 let bodyElt= document.getElementById("table_body");
		 bodyElt.innerHTML="";
		 for(let compte of compteJs){
			 let row = bodyElt.insertRow(-1);
			 (row.insertCell(0)).innerHTML = compte.numero;
			 (row.insertCell(1)).innerHTML = compte.label;
			 (row.insertCell(2)).innerHTML = compte.solde;
			 
		 }
	 });
 }
 
 function ajouterCompte(){
	  let label = (document.getElementById("inputLabel")).value;
	   let soldeInitial = (document.getElementById("inputSoldeInitial")).value;
	  let compteJs = {label : label,
	  				  solde: parseFloat(soldeInitial)};
	  let compteJson= JSON.stringify(compteJs);
	   let wsUrl= "./api-bank/compte";
	    makeAjaxPostRequest(wsUrl, compteJson,function(reponseJson){
			console.log("responseJson=", reponseJson);
			 rechercherComptesSelonSoldeMini();
		});
   
 }