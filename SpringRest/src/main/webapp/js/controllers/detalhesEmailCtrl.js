angular.module("desafioIderos").controller("detalhesEmailCtrl", function ($scope, $routeParams, email) {
	$scope.email = email.data;
});