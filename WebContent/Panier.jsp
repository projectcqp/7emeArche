<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="styles.css" />
<title>Panier</title>
</head>
<body>
	<div class="divbody">
		<header id="headerPanier">
			<jsp:include page="/Menu.jsp"></jsp:include>
		</header>
		
		<div class="parentFlex">
		<div class="titrePanier">
			<div id="titreVotrePanier">
			VOTRE PANIER
			</div>
			<c:if test="${panier.getSizeContenuPanier() > 0}">
				<div id="boutonAcheter" class="enTetePanier">
					<form id="acheter" action="ControlerPanier" method="post">
						<input type=submit value="Acheter" name="action" />
					</form>
				</div>
			</c:if>
		</div>
		</div>
			
		<c:if test="${panier.getSizeContenuPanier() == 0}">
		<br/>
		<br/>
		<br/>
		<br/>
		<p class="pPanier">Votre panier est vide</p>
		<br/>
		<br/>
		<br/>
		<br/>
		</c:if>
		
		<c:if test="${panier.getSizeContenuPanier() > 0}">
			<c:forEach var="ligne" items="${panier.iterator()}">
				<div class="articlePanier">
					<div class="headerArticle">
						<c:if test="${empty ligne.article.materiel}">
							<div class="infosArticle">
								<ul>
									<li>${ligne.article.nom}</li>
									<li>Prix HT : <fmt:formatNumber	value="${ligne.article.prixHt}" minFractionDigits="2"/> €</li>
									<li>Format numérique : ${ligne.article.immateriel.format}</li>
								</ul>
							</div>
						</c:if>

						<!-- si article matériel -->
						<c:if test="${empty ligne.article.immateriel}">
							<div class="infosArticle">
								<ul>
								<li>${ligne.article.nom}</li>
								<li>Etat : ${ligne.article.materiel.etat}</li>
								<li>Prix HT : <fmt:formatNumber
										value="${ligne.article.prixHt}" minFractionDigits="2" /> €</li>
								<li>Quantité disponible : ${ligne.article.stock}</li>
								<c:if test="${referenceArticlePanier == ligne.article.ref}">
									<li class="messageException">
									${ExceptionQuantiteDemandeeSuperieureAuStock}
									</li>
								</c:if>
								</ul>
							</div>
						</c:if>
					
						<div class="contenuHeaderArticle">
						<br/>
						<form action="ControlerPanier" method="post">
							<input type="hidden" value="${ligne.article.ref}" name="refArticle">
							<label for="nom">Quantité :</label>
							<input class="champsAjoutPanier" type="number" value="${ligne.getQuantite()}" min="1" name="quantiteDansPanier"/>
							<input type=submit value="Modifier" name="action" />
							<input type=submit value="Supprimer" name="action" />
						</form>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>

		<br/>
		<br/>

	</div>
</body>
</html>