

	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title" id="myModalLabel">Se connecter</h4>
				</div>
				<!-- /.modal-header -->


				<div class="modal-body">


					<form role="form" action="ControlerCompte" method="POST">
						<div class="form-group">
							<div class="input-group">
								<input type="text" class="form-control" id="e_mail_compte" name="e_mail_compte"
									placeholder="Login"> <label for="e_mail_compte"
									class="input-group-addon glyphicon glyphicon-user"></label>
							</div>
						</div>
						<!-- /.form-group -->

						<div class="form-group">
							<div class="input-group">
								<input type="password" class="form-control" id="password_compte" name="password_compte"
									placeholder="Password"> <label for="password_compte"
									class="input-group-addon glyphicon glyphicon-lock"></label>
							</div>
							<!-- /.input-group -->
						</div>
						<!-- /.form-group -->

						<div class="checkbox">
							<label> <input type="checkbox"> Se souvenir de
								moi
							</label>
						</div>

					
						<div class="modal-footer">
							<button class="form-control btn btn-primary" type="submit"
								value="Connexion" id="boutonConnexion" name="action">Ok</button>
						</div>


					</form>

				</div>



			</div>

		</div>

	</div>

