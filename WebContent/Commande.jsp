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
<title>7eme Arche - Ma commande</title>

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
					<h3> VOTRE COMMANDE </h3> 
				</div>

			</div>
		</div>

			<c:forEach var="ligne" items="${panier.iterator()}">
				<div class="articlePanier">
					<div class="headerArticle">
							<div class="section">
								<div class="row">
									<div class="col-xs-12">
										<ul>
											<li>${ligne.article.nom}</li>
											<li>Quantité : ${ligne.getQuantite()}</li>
											<li>Prix HT : <fmt:formatNumber value="${ligne.article.prixHt}" minFractionDigits="2" /> €</li>
											<li>Tva : <fmt:formatNumber value="${ligne.getMontantTva()}" minFractionDigits="2" /> €</li>
										</ul>
									</div>
								</div>
							</div>
					</div>
				</div>
			</c:forEach>
			
			<div  class="col-xs-12">
				<ul>
					<li>Prix total TTC : <fmt:formatNumber value="${panier.getMontantToutesTaxsComprises()}" minFractionDigits="2" /> €</li>
				</ul>
			</div>


		<br /> <br />
		
				

	</div>




	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

</body>
</html>