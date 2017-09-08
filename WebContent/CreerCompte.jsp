<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="styles.css" />
<title>Création de compte</title>
</head>
<body>
	<div class="divbody">
		<header id="headerPanier">
			<jsp:include page="/Menu.jsp"></jsp:include>
		</header>

		<div class="titrePanier">
			<p id="titreCompte">Créez votre compte utilisateur</p>
			</div>
			<br/>
			
		<!-- si connecté à un compte -->	
		<c:if test="${not empty compteSession}">
		<br/>
		<br/>
		<br/>
		<br/>
		<p>Vous avez déjà un compte utilisateur et vous êtes connecté</p>
		<br/>
		<br/>
		<br/>
		<br/>
		</c:if>
		
		<!-- si non connecté à un compte -->
		<c:if test="${empty compteSession}">
			<div id="formCreationCompte" class="contenuHeaderArticle">
				<br/>
				<form action="ControlerCompte" method="post">
					<label for="nom">Nom :</label>
					<input type="text" name="nom"/>
					<br/><br/>
					<label for="prenom">Prénom :</label>
					<input type="text" name="prenom"/>
					<br/><br/>
					<label for="adresse">Adresse :</label>
					<br/>
					<textarea name="adresseCompte" rows=5 cols=50></textarea>
					<br/><br/>
					<label for="adresse">Adresse livraison :</label>
					<br/>
					<textarea type="text" name="adresseLivraison" rows=5 cols=50></textarea>
					<br/><br/>
					<label for="email">Email :</label>
					<input type="email" name="email"/>
					<br/><br/>
					<label for="telephone">Téléphone :</label>
					<input type="tel" name="telephone"/>
					<br/><br/>
					<label for="password">Mot de passe :</label>
					<input type="password" name="password"/>
					<br/><br/>
					<label for="testPassword">Confirmez votre mot de passe :</label>
					<input type="password" name="testPassword"/>
					<br/><br/>
					<br/><br/>
					<br/><br/>
					<input type=submit value="Valider" name="action" />
				</form>
			</div>
		</c:if>		
	</div>
</body>
</html>