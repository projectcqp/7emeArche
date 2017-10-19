<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>7eme Arche</title>

<!-- Bootstrap -->


<link href="bootstrap-3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap-3.3.7/dist/css/style.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Noto+Serif|Roboto"
	rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src='functionsJavascript.js'></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>

</head>
<body>


	<div class="container">

		<%@ include file="Menu.jsp"%>
		<%@ include file="Connexion.jsp"%>

		<div class="section">

			<div class="row">

				<c:forEach var="article" items="${catalogue1}">

					<form class="form-inline">

						<div class="form-group col-xs-6" id="nomArticle">
							<h2 style="margin-top: 0;">${article.nom}</h2>
						</div>

						<div class="form-group col-xs-6" id="formAjoutPanier">

							<input class="sr-only" value="${article.reference}"
								name="referenceArticle" id="idArticle"> <label for="nom">
								Quantité :</label> <input class="form-control" type="number" value="1"
								min="1" name="quantiteAjouteePanier"
								id="quteAjoutPanier${article.reference}" />

							<button class="btn btn-primary" name="action"
								value="boutonAjoutArticle" id="actionBouton"
								onclick="appelAjaxAjouterPanier('${article.reference}',document.getElementById('quteAjoutPanier${article.reference}').
 								value,document.getElementById('actionBouton').value); return false">Ajouter
								au panier</button>
						</div>
					</form>

					<br>
					<div class="col-xs-8">
						<img class="img-responsive"
							src="<c:url value='${article.urlImage}'/>" style="width: 20%;" />
					</div>

					<!-- si Livre -->
					<c:if test="${article.type eq 'Livre'}">
						<!-- si matérialisé -->
						<c:if test="${empty article.dematerialise}">
							<div class="col-xs-4">
								<ul>
									<li>Auteur : ${article.auteur}</li>
									<li>Editeur : ${article.editeur}</li>
									<li>Etat : ${article.materialise.etat}</li>
									<li>Prix HT : <fmt:formatNumber value="${article.prixHt}"
											minFractionDigits="2" /> €
									</li>
									<li>Quantité disponible : ${article.stock}</li>
									<li>Date de parution : ${article.date}</li>
									<li>Genre : ${article.genre}</li>
									<li>ISBN : ${article.isbn}</li>
									<li>Référence : ${article.reference}</li>
								</ul>
							</div>
						</c:if>
						<!-- si dématérialisé -->
						<c:if test="${empty article.materialise}">
							<div class="col-xs-4">
								<ul>
									<li>Auteur : ${article.auteur}</li>
									<li>Editeur : ${article.editeur}</li>
									<li>Format : ${article.dematerialise.format}</li>
									<li>Prix HT : <fmt:formatNumber value="${article.prixHt}"
											minFractionDigits="2" /> €
									</li>
									<li>Quantité disponible : ${article.stock}</li>
									<li>Date de parution : ${article.date}</li>
									<li>Genre : ${article.genre}</li>
									<li>ASIN : ${article.isbn}</li>
									<li>Référence : ${article.reference}</li>
								</ul>
							</div>
						</c:if>
					</c:if>

					<!-- si ArticleDivers -->
					<c:if test="${article.type eq 'ArticleDivers'}">
						<!-- si matérialisé -->
						<c:if test="${empty article.dematerialise}">
							<div class="col-xs-4">
								<ul>
									<li>Etat : ${article.materialise.etat}</li>
									<li>Prix HT : <fmt:formatNumber value="${article.prixHt}"
											minFractionDigits="2" /> €
									</li>
									<li>Quantité disponible : ${article.stock}</li>
									<li>Référence : ${article.reference}</li>
									<li>${article.nature}</li>
								</ul>
							</div>
						</c:if>
						<!-- si dématérialisé -->
						<c:if test="${empty article.materialise}">
							<div class="col-xs-4">
								<ul>
									<li>Format : ${article.dematerialise.format}</li>
									<li>Prix HT : <fmt:formatNumber value="${article.prixHt}"
											minFractionDigits="2" /> €
									</li>
									<li>Référence : ${article.reference}</li>
									<li>${article.nature}</li>
								</ul>
							</div>
						</c:if>
					</c:if>


					<div class="col-xs-12 text-justify">${article.description}</div>

					<div class="col-xs-12"></div>


				</c:forEach>


			</div>
		</div>
		<%@ include file="Pagination.jsp"%>

	</div>


</body>
</html>