<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>7eme Arche - Mon panier</title>

<!-- Bootstrap -->
<link href="bootstrap-3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap-3.3.7/dist/css/style.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Noto+Serif|Roboto"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="functionsJavascript.js"></script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body role="document">
	<div class="container">

		<%@ include file="Menu.jsp" %>
		<%@ include file="Connexion.jsp" %>


		<div class="section">
			<div class="row">
				<div id="monPanier" CLASS="text-center">
					<h3> VOTRE PANIER </h3> 
				</div>

			</div>
		</div>

		<c:if test="${panier.getSizeContenuPanier() == 0}">
			<br />
			<br />
			<br />
			<br />
			<p class="pPanier">Votre panier est vide</p>
			<br />
			<br />
			<br />
			<br />
		</c:if>

		<c:if test="${panier.getSizeContenuPanier() > 0}">
			<c:forEach var="ligne" items="${panier.iterator()}">
				<div class="articlePanier">
				<h4>${ligne.article.nom}</h4>
					<div class="headerArticle">
						<c:if test="${empty ligne.article.materialise}">

							<div class="section">
								<div class="row">
									<div class="col-xs-6">
										<img class="img-responsive"
											src="<c:url value='${ligne.article.urlImage}'/>"
											style="width: 20%;" alt="${article.nom}"/>

									</div>
									<div class="col-xs-6">
										<ul>
											<!-- <li>${ligne.article.nom}</li> -->
											<li>Prix HT : <fmt:formatNumber
													value="${ligne.article.prixHt}" minFractionDigits="2" /> €
											</li>
											<li>Format numérique :
												${ligne.article.dematerialise.format}</li>
										</ul>

									</div>
								</div>
							</div>
						</c:if>

						<!-- si article matériel -->
						<c:if test="${empty ligne.article.dematerialise}">

							<div class="section">
								<div class="row">
									<div class="col-xs-6">
										<img class="img-responsive"
											src="<c:url value='${ligne.article.urlImage}'/>"
											style="width: 20%;" />

									</div>
									<div class="col-xs-6">
										<ul>
											<!-- <li>${ligne.article.nom}</li> -->
											<li>Etat : ${ligne.article.materialise.etat}</li>
											<li>Prix HT : <fmt:formatNumber
													value="${ligne.article.prixHt}" minFractionDigits="2" /> €
											</li>
											<li>Quantité disponible : ${ligne.article.stock}</li>
											<c:if test="${referenceArticlePanier == ligne.article.reference}">
												<li class="messageException">
													${ExceptionQuantiteDemandeeSuperieureAuStock}</li>
											</c:if>
										</ul>
									</div>
								</div>
							</div>
						</c:if>

						<div class="contenuHeaderArticle">
							<br />
							<form action="ControlerPanier" method="post">
								<input type="hidden" value="${ligne.article.reference}"	name="refArticle">
								<label for="nom">Quantité :<input class="champsAjoutPanier" type="number"
									value="${ligne.getQuantite()}" min="1"
									name="quantiteDansPanier" /></label>
									<input class="btn btn-success" type=submit value="Modifier" name="action"/>
									<input class="btn btn-danger" type=submit value="Supprimer"	name="action"/>
							</form>
						</div>
					</div>
				</div>
				<br/>
				<br/>
			</c:forEach>
		</c:if>


		<br /> <br />

		<c:if test="${not empty compteSession}">
			<c:if test="${panier.getSizeContenuPanier() > 0}">
				<div id="boutonAcheter" class="enTetePanier">
					<form id="acheter" action="ControlerCommande" method="get">
						<input class="btn btn-primary" type=submit value="Commander" name="action"/>
					</form>
				</div>
			</c:if>
		</c:if>
		<c:if test="${empty compteSession}">
			<c:if test="${panier.getSizeContenuPanier() > 0}">
				<div id="boutonAcheter" class="enTetePanier">
					<form>
						<input class="btn btn-primary" value="Commander" name="action"  disabled/>
					</form>
					<p>Vous devez être connecté pour commander</p>
				</div>
			</c:if>
		</c:if>
		
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

</body>
</html>