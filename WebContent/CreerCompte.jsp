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
<title>7eme Arche</title>

<!-- Bootstrap -->
<link href="bootstrap-3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap-3.3.7/dist/css/style.css" rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Indie+Flower|Noto+Serif|Roboto"
	rel="stylesheet">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="functionsJavascript.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/1000hz-bootstrap-validator/0.11.5/validator.min.js"></script>
<!-- <script
	src="http://1000hz.github.io/bootstrap-validator/dist/validator.min.js"></script> -->
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

	<div class="container">

		<jsp:include page="/Menu.jsp"></jsp:include>
		<jsp:include page="/Connexion.jsp"></jsp:include>

		<form data-toggle="validator" role="form" class="form-horizontal"
			action='ControlerCompte' method="POST">

			<div class="col-xs-6">

				<div class="form-group">
					<!-- E-mail -->
					<label class="control-label" for="e_mail_compte">E-mail</label> <input
						type="email" id="e_mail_compte" name="e_mail_compte"
						placeholder="Email" class="form-control"
						data-error="l'email est invalide" required>


				</div>

				<div class="form-group">
					<!-- Password-->
					<label class="control-label" for="password_compte">Mot de
						passe</label> <input type="password" id="password_compte"
						name="password_compte" placeholder="Mot de Passe"
						class="form-control" data-minlength="6" required>
					<div class="help-block">Minimum de 6 caractères</div>

				</div>

				<div class="form-group">

					<!-- Password Confirm-->
					<label class="control-label" for="password_compte_confirm">Confimer
						le mot de passe</label> <input type="password"
						id="password_compte_confirm" data-match="#password_compte"
						data-match-error="Les mots de passe ne correspondent pas"
						name="password_compte_confirm" placeholder="Confimer le mot de passe"
						class="form-control" required>
					<span class="help-block with-errors"></span>


				</div>

				<div class="form-group">
					<!-- Nom -->
					<label class="control-label" for="nom">Nom </label> <input
						type="text" id="nom_compte" name="nom_compte" placeholder="Nom"
						class="form-control" required>


				</div>

				<div class="form-group">
					<!--Prénom -->
					<label class="control-label" for="prenom_compte">Prénom</label> <input
						type="text" id="prenom_compte" name="prenom_compte"
						placeholder="Prénom" class="form-control" required>


				</div>




				<div class="form-group">
					<!-- Telephone -->
					<label class="control-label" for="telephone_compte">Téléphone</label>

					<input type="text" id="telephone_compte" name="telephone_compte"
						placeholder="Téléphone" class="form-control" required>

				</div>




				<div class="form-group">
					<!-- Date de naissance -->
					<label class="control-label" for="dateNaissance_compte">Date
						de naissance</label> <input type="text" id="dateNaissance_compte"
						name="dateNaissance_compte" placeholder="Date de naissance"
						class="form-control" required>

				</div>



				<div class="form-group">
					<!-- Adresse -->
					<!-- <label class="control-label" for="adresse_compte">Adresse
						de facturation</label> <input type="text" id="adresse_compte"
						name="adresse_compte" placeholder="Adresse de facturation"
						class="form-control" required> voie complement codepostal ville pays
					-->
					<label>Adresse de facturation</label>
					<br/>
					<label class="control-label">Numéro et rue</label>
					<input type="text" id="voie_adresse"name="voie_adresse" placeholder="Numéro et rue"	class="form-control" required>
					<label class="control-label">Complément d'adresse</label>
					<input type="text" id="complement_adresse"name="complement_adresse" placeholder="Complément d'adresse" class="form-control" required>
					<label class="control-label">Code postal</label>
					<input type="text" id="code_postal_adresse"name="code_postal_adresse" placeholder="Code postal"	class="form-control" required>
					<label class="control-label">Ville</label>
					<input type="text" id="ville_adresse"name="ville_adresse" placeholder="Ville" class="form-control" required>
					<label class="control-label">Pays</label>
					<input type="text" id="pays_adresse"name="pays_adresse" placeholder="pays" class="form-control" required>
				</div>
				
				<br/><br/>
				<p>Laisser vide si identique à l'adresse de facturation</p>
				<div class="form-group">
					<label>Adresse de livraison</label>
					<br/>
					<label class="control-label">Numéro et rue</label>
					<input type="text" id="voie_adresse" name="voie_adresse" placeholder="Numéro et rue" class="form-control">
					<label class="control-label">Complément d'adresse</label>
					<input type="text" id="complement_adresse"name="complement_adresse" placeholder="Complément d'adresse" class="form-control">
					<label class="control-label">Code postal</label>
					<input type="text" id="code_postal_adresse"name="code_postal_adresse" placeholder="Code postal"	class="form-control">
					<label class="control-label">Ville</label>
					<input type="text" id="ville_adresse"name="ville_adresse" placeholder="Ville" class="form-control">
					<label class="control-label">Pays</label>
					<input type="text" id="pays_adresse"name="pays_adresse" placeholder="pays" class="form-control">
				</div>

				<br/><br/>

				<div class="form-group">
					<!-- Button -->

					<button class="btn btn-success" value="Valider" name="action">S'inscrire</button>

				</div>
			</div>
		</form>



	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

</body>
</html>