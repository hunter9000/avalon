	// create the module and name it scotchApp
	var scotchApp = angular.module('scotchApp', ['ngRoute']);

	// configure our routes
	scotchApp.config(function($routeProvider) {
		$routeProvider
			// route for the home page
			.when('/', {
				templateUrl : 'pages/home.html',
				controller  : 'mainController'
			})
			// route for the login page
			.when('/login', {
				templateUrl : 'pages/login.html',
				controller  : 'loginController'
			})
			// route for the about page
			.when('/about', {
				templateUrl : 'pages/about.html',
				controller  : 'aboutController'
			})

			// route for the char select page
			.when('/charselect', {
				templateUrl : 'pages/charselect.html',
				controller  : 'charSelectController'
			})
			// route for the new char page
			.when('/newchar', {
				templateUrl : 'pages/newchar.html',
				controller  : 'newCharController'
			})
			.when('/editchar/:charId', {
				templateUrl: 'pages/editchar.html',
				controller: 'editCharController'
			})
			;
	});

	// create the controller and inject Angular's $scope
	scotchApp.controller('mainController', function($scope, $location, $window) {
		// create a message to display in our view
		$scope.message = 'main';
		
		$scope.logout = function() {
			$window.localStorage['jwtToken'] = undefined;
			$location.path('/');
		};
		
		var init = function() {
			var token = $window.localStorage['jwtToken']
			console.log('checking '+ token);
			if (token === 'undefined' || token === null || token == null) {
				$location.path('/login');
				console.log('redirecting');
			}
			else {
				$location.path('/charselect');
			}
		};
		init();
	});
	
	// create the controller and inject Angular's $scope
	scotchApp.controller('loginController', function($scope, $location, $http, $window) {
		// create a message to display in our view
		$scope.message = 'Everyone come and see how good I look!';
		
		$scope.formData = {};

		// when submitting the add form, send the text to the node API
		$scope.login = function() {
			$http.post('/api/authenticate', $scope.formData)
				.success(function(data) {
					/*$scope.formData = {}; // clear the form so our user is ready to enter another
					$scope.todos = data;*/
					console.log(data);
					
					if (!data.success) {
						$scope.message = 'invalid login';
					}
					else {
						$window.localStorage['jwtToken'] = data.token;
						$location.path("/charselect");
					}
				})
				.error(function(data) {
					console.log('Error: ' + data);
					$scope.message = 'invalid login - error returned';
				});
		};

		
	});


	scotchApp.controller('charSelectController', function($scope, $window, $http) {
		$scope.message = 'token: ' + $window.localStorage['jwtToken'];
		
		$scope.chars = [];
		
		$http({
		  method: 'GET',
		  url: '/api/chars',
		  headers: {'x-access-token': $window.localStorage['jwtToken']}  })
			.success(function(data) {
				$scope.chars = data;
				console.log('got these chars back: ');
				console.log(data);
			})
			.error(function(data) {
				console.log('Error: ' + data);
			});
		
		
	});
	
	scotchApp.controller('newCharController', function($scope, $window, $http) {
		$scope.message = 'token: ' + $window.localStorage['jwtToken'];
		
		$scope.formData = {};
		
		$scope.save = function() {
			$http({
				method:'POST',
				url:'api/chars',
				headers: {'x-access-token': $window.localStorage['jwtToken']},  
				data: $scope.formData  })
					.success(function(data) {
						$scope.formData = data;
						console.log(data);
					})
					.error(function(data) {
						console.log('Error: ' + data);
					});
			
		};
		
	});
	
	scotchApp.controller('editCharController', function($scope, $http, $window, $routeParams) {
		
		$scope.message = '';
		
		$scope.char = null;
		
		$http({method:'GET', 
			   url: 'api/chars/' + $routeParams.charId,
			   headers: {'x-access-token': $window.localStorage['jwtToken']}  
		})
		.success(function (data) {
			$scope.char = data;
			console.log('get api/chars/id ');
			console.log(data);
		})
		.error(function(data) {
			console.log('Error:' + data);
		});
			
		$scope.save = function() {
			$http({
				method: 'PATCH',
				url: 'api/chars/' + $scope.char._id,
				headers: {'x-access-token': $window.localStorage['jwtToken']},
				data: $scope.char
			})
			.success(function(data) {
				$scope.message = 'saved';
			})
			.error(function(data) {
				$scope.message = 'error ' + data;
			});
			
		};
	});
	
	
	
	
	