angular.module("desafioIderos").controller("desafioIderosCtrl",
		function($scope, emailAPI) {
			$scope.app = "Lista de e-mails";
			$scope.emails = [];
			var carregarEmails = function() {
				emailAPI.getEmails().success(function(data) {
					$scope.emails = data;
				}).error(function(data, status) {
					$scope.message = "Aconteceu um problema: " + data;
				});
			};

			$scope.adicionarEmail = function(email) {
				email.datetime = new Date();
				emailAPI.saveEmail(email).success(function(data) {
					delete $scope.email;
					$scope.emailForm.$setPristine();
					carregarEmails();
				}).error(function(data, status) {
					$scope.message = "Aconteceu um problema: " + data;
				});
			};

			$scope.apagarEmails = function(emails) {
				var ids = [];
				var count = 0;
				emails.filter(function(email) {
					if (email.selecionado)
						ids[count++] = email.id;
				});

				emailAPI.deleteEmailsByIds(ids).success(function(data) {
					carregarEmails();
				}).error(function(data, status) {
					$scope.message = "Aconteceu um problema: " + data;
				});
			};

			$scope.isEmailsSelecionados = function(emails) {
				if (emails.length === 0)
					return false;
				// retorna verdade se algum email for selecionado
				return emails.some(function(email) {
					return email.selecionado;
				});
			};

			$scope.ordernarPor = function(campo) {
				$scope.criterioDeOrdenacao = campo;
				$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
			};

			carregarEmails();
		});