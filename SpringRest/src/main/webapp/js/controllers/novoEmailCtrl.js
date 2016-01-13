angular.module("desafioIderos").controller("novoEmailCtrl", function ($scope, emailAPI, $location) {
	$scope.adicionarEmail = function(email) {
		email.datetime = new Date();
		emailAPI.saveEmail(email).success(function(data) {
			delete $scope.email;
			$scope.emailForm.$setPristine();
			$location.path("/listaEmails");
		}).error(function(data, status) {
			$scope.message = "Aconteceu um problema: " + data;
		});
	};	
});