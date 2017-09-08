<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="styles.css" />
<title>Gestion de compte</title>
</head>
<body>
	<div class="divbody">
		<header id="headerPanier">
			<jsp:include page="/Menu.jsp"></jsp:include>
		</header>

		<div class="titrePanier">
			<p id="titreCompte">Les informations de votre compte utilisateur</p>
		</div>
		<br/>
			
		<!-- si non connecté à un compte -->	
		<c:if test="${empty compteSession}">
		<br/>
		<br/>
		<br/>
		<br/>
		<p>Vous n'êtes connecté à aucun compte utilisateur et je me demande comment vous êtes arrivé là...</p>
		<br/>
		<br/>
		<br/>
		<br/>
		</c:if>
		
		<!-- si non connecté à un compte -->
		<c:if test="${not empty compteSession}">
		<br/>
		<p>Nom : ${compteSession.nom}</p>
		<br/>
		<p>Prénom : ${compteSession.prenom}</p>
		<br/>
		<p>Adresse :</p>
		<p>${compteSession.adresseCompte}</p>
		<br/>
		<p>Adresse de livraison :</p>
		<p>${compteSession.adresseLivraison}</p>
		<br/>
		<p>Téléphone : ${compteSession.telephone}</p>
		<br/>
		<p>Email : ${compteSession.email}</p>
		<br/>
		<p>Mot de passe : ${compteSession.password}</p>
		<br/><br/>
		<br/><br/>

		
		</c:if>		
	</div>
</body>
</html>