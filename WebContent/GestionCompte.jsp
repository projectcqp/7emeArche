<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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

<title>7eme Arche - Gérer mon compte</title>
</head>
<body role="document">
	<div class="container">

		<%@ include file="Menu.jsp"%>
		<%@ include file="Connexion.jsp"%>


		<div class="section">
			<div class="row">
				<div id="monPanier" class="text-center">
					<h3>LES INFORMATIONS DE VOTRE COMPTE</h3>
				</div>

			</div>
		</div>
		<br />

		<!-- si non connecté à un compte -->
		<c:if test="${empty compteSession}">
			<br />
			<br />
			<br />
			<br />
			<p>Vous n'êtes connecté à aucun compte utilisateur et je me
				demande comment vous êtes arrivé là...</p>
			<br />
			<br />
			<br />
			<br />
		</c:if>

		<!-- si connecté à un compte -->
		<c:if test="${not empty compteSession}">

			
				<br />
				<p>Nom : ${compteSession.nom}</p>
				<br />
				<p>Prénom : ${compteSession.prenom}</p>
				<br />
				<p>Date de naissance: ${compteSession.dateNaissance}</p>
				<br />
				<p>Adresse de facturation: ${compteSession.adresseFacturation.toString()}</p>
				<br />
				<p>Adresse de livraison: ### A gérer ###</p>
				<br />
				<p>Téléphone : ${compteSession.telephone}</p>
				<br />
				<p>Email : ${compteSession.email}</p>
				<br /> <br /> <br /> <br />
			

		</c:if>
	</div>
</body>
</html>