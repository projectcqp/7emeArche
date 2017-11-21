<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<header>
	<div class="text-center">
		<h1 class="blue" style="color: #2196F3;">7ème Arche</h1>
		<h3 class="blue">Votre librairie cinéphile</h3>
		<c:if test="${not empty compteSession}">
			<br/>
			<p>Bienvenue ${compteSession.prenom} ${compteSession.nom}</p>
		</c:if>
	</div>
</header>
<nav class="navbar navbar-default">


	<div class="container-fluid">


		<!-- Brand and toggle get grouped for better mobile display -->
		<nav role="menu mobile">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false" role="bouton menu mobile">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/ControlerArticles">Accueil
				</a>
			</div>
		</nav>


		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<nav>
				<ul class="nav navbar-nav ">
					<c:if test="${empty compteSession}">
						<form>
							<button type="button" class="btn btn-primary navbar-btn"
								data-toggle="modal" data-target="#myModal" role="bouton connexion">Connexion</button>
						</form>
					</c:if>
	
					<c:if test="${not empty compteSession}">
						<form role="form" action="ControlerCompte" method="POST">
							<button class="btn btn-primary navbar-btn" type="submit"
								name="action" value="Deconnexion"  role="bouton déconnexion">Déconnexion</button>
						</form>
					</c:if>
					
				</ul>
			</nav>
			<nav>
				<form class="navbar-form navbar-left" method="post" action="ControlerArticles" role="form">
					<div class="form-group">
						<input type="text" value="${param.recherche}" name="recherche" class="form-control"
							placeholder="Rechercher">
					</div>
					<button type="submit" class="btn btn-primary" name="action" value= "Rechercher" role="bouton rechercher">Soumettre</button>
				</form>
			</nav>
			<nav>
				<ul class="nav navbar-nav navbar-right" role="menu">
					<li role="lien panier">
						<a href="Panier.jsp" role="region" aria-live="polite" aria-atomic="true" aria-busy="false">Panier (
							<span id="artCumuPanier">${panier.getArticlesCumulesPanier()}
							</span>)
						</a>
					<li role="contenu panier">
						<a role="region" aria-live="polite" aria-atomic="true" aria-busy="false"> Total HT : 
							<span id="pxTotalPanier">
								<fmt:formatNumber type="number" value="${panier.getPrixTotal()}" minFractionDigits="2" />
							</span> €
						</a>
					</li>
					<c:if test="${empty compteSession}">
						<li role="créer un compte"><a href="CreerCompte.jsp">Créer un compte</a></li>
					</c:if>
					
					<c:if test="${not empty compteSession}">
						<li role="voir le compte"><a href="GestionCompte.jsp">Mon Compte</a></li>
					</c:if>
				</ul>
			 </nav>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->


</nav>