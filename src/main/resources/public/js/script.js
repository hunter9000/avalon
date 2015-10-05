	// create the module and name it scotchApp
	var scotchApp = angular.module('scotchApp', ['ngRoute', 'ui.bootstrap']);

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
//			.when('/about', {
//				templateUrl : 'pages/about.html',
//				controller  : 'aboutController'
//			})
			// route for the char select page
			.when('/charselect', {
				templateUrl : 'pages/charselect.html',
				controller  : 'charSelectController'
			})
			// route for the new char page
//			.when('/newchar', {
//				templateUrl : 'pages/newchar.html',
//				controller  : 'newCharController'
//			})
			.when('/editchar/:charId', {
				templateUrl: 'pages/editchar.html',
				controller: 'editCharController'
			})
			.when('/materials', {
				templateUrl: 'pages/admin/materials.html',
				controller: 'materialsController'
			})
			.when('/hq/', {
				templateUrl: 'pages/hq.html',
				controller: 'hqController'
			})
			.when('/crafting', {
				templateUrl: 'pages/crafting.html',
				controller: 'craftingController'
			})
			.when('/inventory', {
				templateUrl: 'pages/inventory.html',
				controller: 'inventoryController'
			})
			.when('/dungeon', {
				templateUrl: 'pages/dungeon.html',
				controller: 'dungeonController'
			})
			.when('/portals', {
				templateUrl: 'pages/portals.html',
				controller: 'portalsController'
			})
			.otherwise({redirectTo:'/'});
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

		$scope.home = function() {
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



	scotchApp.factory('StaticData', ['$http', '$window', function($http, $window) {
		var serviceData = {
			effectTypes: [],
			equipmentSlots: []
		};

		$http({method:'GET',
			   url: '/api/effectTypes',
			   headers: {'x-access-token': $window.localStorage['jwtToken']}
			})
			.success(function (data) {
				serviceData.effectTypes = data;
				console.log(data);
			})
			.error(function(data) {
				console.log('Error:' + data);
			}
		);

		$http({method:'GET',
			   url: '/api/equipmentSlots',
			   headers: {'x-access-token': $window.localStorage['jwtToken']}
			})
			.success(function (data) {
				serviceData.equipmentSlots = data;
				console.log(data);
			})
			.error(function(data) {
				console.log('Error:' + data);
			}
		);

		return serviceData;
	}]);






