angular.module("desafioIderos").controller("listaEmailsCtrl",
		function($scope, emails, emailAPI) {
			$scope.emails = emails.data;

			$scope.apagarEmails = function(emailsListados) {
				var ids = [];
				var count = 0;
				emailsListados.filter(function(email) {
					if (email.selecionado)
						ids[count++] = email.id;
				});

				emailAPI.deleteEmailsByIds(ids).success(function(data) {
					$scope.emails = emailsListados.filter(function(email) {
						var emailRemovido = ids.some(function(id) {
							return id == email.id;
						});
						if (!emailRemovido)
							return email;
					});
				}).error(function(data, status) {
					$scope.message = "Aconteceu um problema: " + data;
				});
			};

			$scope.isEmailsSelecionados = function(emailsListados) {
				if (emailsListados.length === 0)
					return false;
				// retorna verdade se algum email for selecionado
				return emailsListados.some(function(email) {
					return email.selecionado;
				});
			};

			$scope.ordernarPor = function(campo) {
				$scope.criterioDeOrdenacao = campo;
				$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
			};
		});