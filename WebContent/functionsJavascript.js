
function appelAjaxAjouterPanier(argIdArticle, argQte, argActionBouton){

	//alert("Ajouter au panier cliqué !");

	//ma variable xml http request
	var xhr = new XMLHttpRequest();

	// appelé à chaque changement d'état (4 états commence envoi, termine envoi, commence retour, termine retour)
	xhr.onreadystatechange = function() {
		// si on est bien au 4e état les données sont bien reçues
		if(xhr.readyState == 4) {
			
			// je récupére les balises span où je vais injecter du texte
			// elles sont dans menu.jsp
			var spanQteArtPanier = document.getElementById("artCumuPanier");
			var spanPxTotPanier = document.getElementById("pxTotalPanier");
						
			// si pas d'erreur
			if(xhr.status == 200) {
				
				// on remplit les span avec ce qu'on récupère du serveur
				// on crée l'objet à partir de la chaine contenant du json
				var objetJSON = JSON.parse(xhr.responseText);
				spanQteArtPanier.innerHTML = objetJSON.nouveauQteCumuPanier;
				spanPxTotPanier.innerHTML= objetJSON.nouveauPxTotalPanier;
			} //if
		} //if
	}; //on ready state change
	
	// J'ENVOIE LES INFOS A LA SERVLET
	// on doit écrire ça après la fonction mais ce sera appelé avant...
	// ServletAjax c'est la servlet, saisie c'est le champs input
	// on est en GET donc on va tout envoyer en concaténé dans l'url séparé par des ? et des &
	// donc on remplit l'URL...
	// true pour de l'asynchrone, false pour du synchrone
	xhr.open("GET", "ServletAjax?actionBouton=" + argActionBouton + "&idArticle=" + argIdArticle + "&quteAjoutPanier=" + argQte, true); 
	// null si GET, Si post il faut passer un objet avec des infos
	//send envoie la requete htttp et donc vers la servletAjax
	xhr.send(null);
	
}//	function