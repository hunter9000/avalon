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
			.when('/materials', {
				templateUrl: 'pages/materials.html',
				controller: 'materialsController'
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
	
	
	scotchApp.controller('materialsController', function($scope, $modal, $http, $window, $routeParams) {

		$scope.mats = null;

		$http({method:'GET',
			   url: 'api/materials/',
			   headers: {'x-access-token': $window.localStorage['jwtToken']}
			})
			.success(function (data) {
				$scope.mats = data;
				console.log('get api/materials ');
				console.log(data);
			})
			.error(function(data) {
				console.log('Error:' + data);
			}
		);

		$scope.addMat = function() {
			var modalInstance = $modal.open({
			  animation: true,
			  templateUrl: 'new-material-modal.html',
			  controller: 'NewMaterialCtrl',
			  size: 'md'
			});

			modalInstance.result.then(
				function (newMat) {		// ok selected
					//$scope.newMat = newMat;
					// create new mat at server

					$http({method:'POST',
						   url: 'api/materials/',
						   headers: {'x-access-token': $window.localStorage['jwtToken']}
						})
						.success(function (data) {
							$scope.mats = data;
							console.log('post api/materials ');
							console.log(data);
						})
						.error(function(data) {
							console.log('Error:' + data);
						}
					);
				},
				function () {					// closed
					$log.info('Modal dismissed at: ' + new Date());
				}
			);
		}

		$scope.addEffect = function() {

		}

		$scope.deleteMat = function(matId) {
		}

		$scope.deleteEffect = function(effectId) {
		}

	});
	

    scotchApp.controller('craftingController', function($scope, $http, $window, $routeParams) {
        $scope.recipes = ['Volvo', 'Saab', 'Mercedes', 'Audi'];

        $scope.mats = ['one', 'two', 'three'];
        $scope.selectedMat = null;

        $scope.baseMats = [];
        $scope.extraMats = [];

        $scope.selectedRecipe = null;

        $scope.recipeSelect = function() {
            console.log($scope.item);
            $scope.selectedRecipe = $scope.item;
        }

        $scope.matSelect = function() {
            console.log($scope.item);
            $scope.selectedMat = $scope.item;
        }
        $scope.matDblclick = function() {
            console.log($scope.item);
            $scope.extraMats.push($scope.item);
        }

        $scope.listContains = function(list, name, quantity) {
            list.forEach(function(mat) {
                if (mat.name == name) {
                    // check if quantity <= mat.quantity
                    if (true) {
                        return true;
                    }
                }
            });
        }

        $scope.removeFromList = function(list, material) {
            list.forEach(function(mat) {
                if (mat.name == material.name) {
                    // check if quantity <= mat.quantity
                    mat.quantity -= material.quantity;
                    if (mat.quantity == 0) {
                        // remove from list
                    }
                }
            });
        }

    });

    scotchApp.controller('NewMaterialCtrl', function ($scope, $modalInstance) {

//		  $scope.newMat = newMat;

		 /* $scope.ok = function () {
			$modalInstance.close($scope.selected.item);
		  };

		  $scope.cancel = function () {
			$modalInstance.dismiss('cancel');
		  };

		  $scope.save = function(mat) {

		  }*/

//		  $scope.newMat = {}
		  $scope.submitForm = function () {
			  if ($scope.matForm.$valid) {
				  console.log('user form is in scope');
				  $modalInstance.close($scope.matForm);
			  } else {
				  console.log('userform is not in scope');
			  }
		  };
    });

    scotchApp.controller('hqCtrl', function($scope) {

    	$scope.stage = new createjs.Stage("demoCanvas");

		// begin preloading assets when page loads
		$scope.preload = function() {
			var preload = new createjs.LoadQueue();
              preload.addEventListener("fileload", function() {
				console.log('load complete');
				$scope.fetchMapData();		// load server data now
			  });
              preload.loadFile("assets/preloadjs-bg-center.png");
		}
		$scope.preload();

		$scope.fetchMapData = function() {
//			$http.get(etc) {
//				$scope.populate(data);		// get the map data from server here, pass it to populate
//			}
		}

		// creates all the scene objects based on the mapdata
    	$scope.populate = function(mapData) {
    		// create the scene objects here
    		var circle = new createjs.Shape();
			circle.graphics.beginFill("DeepSkyBlue").drawCircle(0, 0, 50);
			circle.x = 100;
			circle.y = 100;
			$scope.stage.addChild(circle);
			circle.addEventListener("click", function (event) {
				console.log('circle click');
			});
			$scope.circle = circle;

			// create map tiles, attach click listeners

			// create

			createjs.Ticker.setFPS(60);
			createjs.Ticker.addEventListener("tick", $scope.stage);
    	}

		$scope.move = function() {
			if (!createjs.Tween.hasActiveTweens($scope.circle)) {
				var tween = createjs.Tween.get($scope.circle, { loop: false })
					.to({ x: 400 }, 1000, createjs.Ease.getPowInOut(4))
					.to({ alpha: 0, y: 175 }, 500, createjs.Ease.getPowInOut(2))
					.to({ alpha: 0, y: 225 }, 100)
					.to({ alpha: 1, y: 200 }, 500, createjs.Ease.getPowInOut(2))
					.to({ x: 100 }, 800, createjs.Ease.getPowInOut(2));
				$scope.tween = tween;
			}
		}

    });
