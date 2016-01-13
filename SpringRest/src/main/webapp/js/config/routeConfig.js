angular.module("desafioIderos").config(function ($routeProvider) {
	$routeProvider.when("/listaEmails", {
		templateUrl: "view/listaEmails.html",
		controller: "listaEmailsCtrl",
		resolve: {
			emails: function (emailAPI) {
				return emailAPI.getEmails();
			}
		}
	});
	$routeProvider.when("/novoEmail", {
		templateUrl: "view/novoEmail.html",
		controller: "novoEmailCtrl"		
	});
	$routeProvider.when("/detalhesEmail/:id", {
		templateUrl: "view/detalhesEmail.html",
		controller: "detalhesEmailCtrl",
		resolve: {
			email: function (emailAPI, $route) {
				return emailAPI.getEmail($route.current.params.id);
			}
		}
	});
	$routeProvider.otherwise({redirectTo: "/listaEmails"});
});