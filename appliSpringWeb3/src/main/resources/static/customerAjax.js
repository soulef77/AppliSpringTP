/**
 * 
 */
 window.onload=function() {
	 (document.getElementById("btnRechercher")).addEventListener("click", rechercherCustomer);
	 (document.getElementById("btnAjout")).addEventListener("click", ajouterCustomer);
	 }
	 


function rechercherCustomer(){
	
	 
	 let wsUrl= "./api-client/customer";
	 
	 makeAjaxGetRequest(wsUrl, function(responseJSON) {
		 let customerJs = JSON.parse(responseJSON);
		 console.log("customerJs= ", customerJs);
		 
		 let bodyElt= document.getElementById("table_body");
		 bodyElt.innerHTML="";
		 for(let customer of customerJs){
			 let row = bodyElt.insertRow(-1);
			 (row.insertCell(0)).innerHTML = customer.firstname;
			 (row.insertCell(1)).innerHTML = customer.lastname;
			 (row.insertCell(2)).innerHTML = customer.password;
			 
		 }
	 });
 }
 
 function ajouterCustomer(){
	  let label = (document.getElementById("inputLabel")).value;
	   let label2 = (document.getElementById("inputLabel2")).value;
	  
	  let customerJs = {firstname : label, 
	  					 lastname: label2};
	  let customerJson= JSON.stringify(customerJs);
	   let wsUrl= "./api-client/customer";
	    makeAjaxPostRequest(wsUrl, customerJson,function(reponseJson){
			console.log("responseJson=", reponseJson);
			 rechercherCustomer();
		});
   
 }