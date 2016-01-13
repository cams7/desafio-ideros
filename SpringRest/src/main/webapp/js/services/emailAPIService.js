angular.module("desafioIderos").factory("emailAPI", function ($http, config) {
	var _getEmails = function () {
		return $http.get(config.baseUrl + "/email");
	};

	var _saveEmail = function (email) {
		return $http.post(config.baseUrl + "/email", email);
	};
	
	var _deleteEmailsByIds = function (ids) {
		return $http.delete(config.baseUrl + "/email/ids/" + ids);
	};

	return {
		getEmails: _getEmails,
		saveEmail: _saveEmail,
		deleteEmailsByIds: _deleteEmailsByIds
	};
});