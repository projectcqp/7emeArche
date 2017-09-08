<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="styles.css" />
<title>Articles</title>
<script src='functionsJavascript.js'></script>

<script>
//fichier .js inséré ici "en dur" lors création page

//### ancienne version avec séparateur sans json (on recevait une chaine de caractère à déconcaténer)
/* function appelAjaxAjouterPanierOld(){

	//alert("Ajouter au panier cliqué !");

	//ma variable xml http request
	var xhr = new XMLHttpRequest();

	// appelé à chaque changement d'état (4 états commence envoi, termine envoi, commence retour, termine retour)
	xhr.onreadystatechange = function() {
		// si on est bien au 4e état les données sont bien reçues
		if(xhr.readyState == 4) {
			
			// je vais récupérer ma string concaténée et la substringuer pour séparer ce qui m'intéresse
			
			// xhr.responseText retourne ma string concaténée et je split dans un tableau de string
			var tableDeStringObtenu = xhr.responseText.split(":");
			
			// je récupère la première entrée du tableau
			var txtQuantitePanierAAfficher = tableDeStringObtenu[0];
			
			// 2e entrée du tableau
			var txtMontantPanierAAfficher = tableDeStringObtenu[1];
			
			// je récupére les balises span où je vais injecter du texte
			// elles sont dans menu.jsp
			var spanQteArtPanier = document.getElementById("artCumuPanier");
			var spanPxTotPanier = document.getElementById("pxTotalPanier");
			
			// si pas d'erreur
			if(xhr.status == 200) {
				// injection html du texte de la réponse html (dans l'entête et tout le toutim)
				spanQteArtPanier.innerHTML=xhr.responseText;
				spanPxTotPanier.innerHTML=xhr.responseText;
			} //if
		} //if
	}; //on ready state change
	
	//on doit écrire ça après la fonction qui sera pourtant appelée après...
	// ServletAjax c'est la servlet, saisie c'est le champs input
	// on est en GET donc on va tout envoyer dans l'url
	// donc on remplit l'URL...
	
	var valeurIdArticle = document.getElementById('idArticle').value;
	var valeurQuteAjoutPanier = document.getElementById('quteAjoutPanier'+argIdArticle).value;
	var valeurActionBouton = document.getElementById('actionBouton').value;
	
	// true pour de l'asynchrone, false pour du synchrone
	xhr.open("GET", "ServletAjax?actionBouton=" + valeurActionBouton + "&idArticle=" + valeurIdArticle + "&quteAjoutPanier=" + valeurQuteAjoutPanier, true); 
	// null si GET, Si post il faut passer un objet avec des infos
	//send envoie la requete htttp et donc vers la servletAjax
	xhr.send(null);
	
}//	 */
//### fin version chaine de caractères

</script>

</head>
<body>
	<div class="divbody">
		<header>
			<jsp:include page="/Menu.jsp"></jsp:include>
		</header>

		<c:if test="${empty catalogue}">
			<div class="article">
				<br/><br/><br/>
				<div class="headerArticle">
				<p class="pPanier">Aucun résultat trouvé pour la recherche "${critereRecherche}"</p>
				</div>
				<br/><br/><br/>
			</div>
		</c:if>

		<c:forEach var="article" items="${catalogue}">
			<div class="article">
				<br/>
				<div class="headerArticle">
					<div id="nomArticle" class="contenuHeaderArticle">${article.nom}</div>
					<div id="formAjoutPanier" class="contenuHeaderArticle">
			<!--		<form action="ControlerPanier" method="post"> -->
						
						<input type="hidden" value="${article.ref}" name="refArticle" id="idArticle">
						<label for="nom">Quantité :</label>
						<input class="champsAjoutPanier" type="number" value="1" min="1" name="quantiteAjouteePanier" id="quteAjoutPanier${article.ref}"/>
						<button name="action" value="boutonAjoutArticle" id="actionBouton"
						onclick="appelAjaxAjouterPanier('${article.ref}',document.getElementById('quteAjoutPanier${article.ref}').
						value,document.getElementById('actionBouton').value)">
						Ajouter au panier</button>
											
					</div>
				</div>
				<br/>
				<c:if test="${referenceArticlePanier == article.ref}">
				<span class="messageException">
				<b>${ExceptionQuantiteDemandeeSuperieureAuStock}</b>
				</span>
				<br/>
				</c:if>
				<div class="imageEtInfos">
					<div class="imageArticle">
						<img src="<c:url value='${article.urlImage}'/>" />
					</div>
					<!-- si article dématérialisé -->
					<c:if test="${empty article.materiel}">
						<c:if test="${article.typeArticle eq 'LIVRE'}">
							<div class="infosArticle">
								<ul>
									<li>Auteur : ${article.auteur}</li>
									<li>Editeur : ${article.editeur}</li>
									<li>Prix HT : <fmt:formatNumber value="${article.prixHt}" minFractionDigits="2" /> €</li>
									<li>Format numérique : ${article.immateriel.format}</li>
									<li>Date de parution : ${article.date}</li>
									<li>Genre : ${article.genre}</li>
									<li>ASIN : ${article.isbn}</li>
									<li>Référence : ${article.ref}</li>
								</ul>
							</div>
						</c:if>
						<c:if test="${article.typeArticle eq 'ARTICLE_DIVERS'}">
							<div class="infosArticle">
								<ul>
									<li>Article : ${article.typeArticleDivers}</li>
									<li>Caractéristiques : ${article.caracteristiques}</li>
									<li>Prix HT : <fmt:formatNumber value="${article.prixHt}" minFractionDigits="2" /> €</li>
									<li>Format numérique : ${article.immateriel.format}</li>
									<li>Référence : ${article.ref}</li>
								</ul>
							</div>
						</c:if>
						
					</c:if>

					<!-- si article matériel -->
					<c:if test="${empty article.immateriel}">
						<c:if test="${article.typeArticle eq 'LIVRE'}">
							<div class="infosArticle">
								<ul>
									<li>Auteur : ${article.auteur}</li>
									<li>Editeur : ${article.editeur}</li>
									<li>Etat : ${article.materiel.etat}</li>
									<li>Prix HT : <fmt:formatNumber value="${article.prixHt}" minFractionDigits="2" /> €</li>
									<li>Quantité disponible : ${article.stock}</li>
									<li>Date de parution : ${article.date}</li>
									<li>Genre : ${article.genre}</li>
									<li>ISBN : ${article.isbn}</li>
									<li>Référence : ${article.ref}</li>
								</ul>
							</div>
						</c:if>
						<c:if test="${article.typeArticle eq 'ARTICLE_DIVERS'}">
							<div class="infosArticle">
								<ul>
									<li>Article : ${article.typeArticleDivers}</li>
									<li>Caractéristiques : ${article.caracteristiques}</li>
									<li>Etat : ${article.materiel.etat}</li>
									<li>Prix HT : <fmt:formatNumber value="${article.prixHt}" minFractionDigits="2" /> €</li>
									<li>Quantité disponible : ${article.stock}</li>
									<li>Référence : ${article.ref}</li>
								</ul>
							</div>
						
						</c:if>		
					</c:if>

				</div>
				<br/><!-- Description : <br />-->
				<div class="descriptionArticle">${article.description}</div>
				<br/>
			</div>
		</c:forEach>


	</div>
</body>
</html>