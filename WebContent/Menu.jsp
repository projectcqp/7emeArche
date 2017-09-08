<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="menuVertical">
	<div class="titreSite">
		<div>
			<p>Ciné Grande Arche - Votre librairie cinéphile</p>
		</div>
	</div>
	<div class="menuHorizontal">
	
		<!-- si non connecté à un compte -->
		<c:if test="${empty compteSession}">
			<div class="elementMenu">
			
				<form id="formConnectionCompte" method="post" action="ControlerCompte">
					<input type=submit value="Connection" name="action" id="boutonConnexion"/>
					<b>${messageErreurConnexion}</b>
					<br/>
					<label for="nom">Email : </label><input type="email" value="${param.email}" name="email" />
					<br/>
					<label for="password">Mot de passe : </label><input type="password" value="${param.password}" name="password" />					
				</form>
				
			</div>		
		</c:if>

		<!-- si connecté -->	
		<c:if test="${not empty compteSession}">
			<div class="elementMenu" id="divBoutonDeconnecter">
				<form id="formPageCompte" method="POST" action="ControlerCompte">
					<input type=submit value="Se déconnecter" name="action">
				</form>
			</div>
		</c:if>

		<!-- si connecté -->
		<c:if test="${not empty compteSession}">
			<div class="elementMenu">
				<form id="formPageCompte" method="POST" action="ControlerCompte">
					<input type=submit value="Voir le compte" name="action">
				</form>
			</div>
		</c:if>
		
		<!-- si non connecté à un compte -->
		<c:if test="${empty compteSession}">
			<div class="elementMenu">
				<form id="formCreerCompte" method="POST" action="ControlerCompte">
					<input type=submit value="Créer un compte" name="action">
				</form>
			</div>			
		</c:if>

		<div class="elementMenu">
			<form id="formPageArticle" method="POST" action="ControlerArticles">
				<input type=submit value="Voir les articles" name="action">
			</form>
		</div>

		<div class="elementMenu">
			<div>
				<form id="formPagePanier" method="POST" action="ControlerPanier">
					<input type=submit value="Voir le panier" name="action">
				</form>
			</div>
		</div>
		
		<div class="elementMenu" id="elementMenuContenuPanier">
			<div>
				Le panier contient <span id="artCumuPanier">${panier.getArticlesCumulesPanier()}</span> articles <br />
				Montant total HT :
				<span id="pxTotalPanier"><fmt:formatNumber value="${panier.getPrixTotal()}" minFractionDigits="2" /></span>€
			</div>
		</div>
	</div>

	<div class="elementMenu" id="rechercheArticleMenu">
		<form id="formRecherche" method="post" action="ControlerArticles">
			<input type=submit value="Rechercher" name="action" />
			<input type="text" value="${param.recherche}" name="recherche" />
			</form>
	</div>
</div>

