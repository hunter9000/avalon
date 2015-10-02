

	scotchApp.controller('charSelectController', function($scope, $window, $http, $modal, $location) {
		$scope.message = 'token: ' + $window.localStorage['jwtToken'];

		$scope.chars = [];

        $scope.fetchChars = function() {
            $http({
              method: 'GET',
              url: '/api/user/'+1+'/chars',
              headers: {'x-access-token': $window.localStorage['jwtToken']}  })
                .success(function(data) {
                    $scope.chars = data;
                    console.log('got these chars back: ');
                    console.log(data);
                })
                .error(function(data) {
                    console.log('Error: ' + data);
                }
            );
        }

        $scope.fetchChars();

        $scope.newChar = function() {
            var modalInstance = $modal.open({
                animation: true,
                templateUrl: 'pages/templates/new-char-modal.html',
                controller: 'NewCharCtrl',
                size: 'md',
                resolve: {}
            });

            modalInstance.result.then(
                function (newChar) {		// ok selected
                    $http({
                        method:'POST',
                        url:'/api/chars',
                        headers: {'x-access-token': $window.localStorage['jwtToken']},
                        data: newChar  })
                    .success(function(data) {
//                        $scope.formData = data;
                        $scope.fetchChars();
                        console.log(data);
                    })
                    .error(function(data) {
                        console.log('Error: ' + data);
                    });
                },
                function () {					// closed

                }
            );
        }

        $scope.selectChar = function(charId) {
            $http({
                method:'POST',
                url:'/api/charselect/' + charId,
                headers: {'x-access-token': $window.localStorage['jwtToken']}
            })
            .success(function(data) {
                $window.localStorage['jwtToken'] = data.token;
                $location.path("/hq/");
            })
            .error(function(data) {
                console.log('Error: ' + data);
            });
        }

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

    angular.module('scotchApp').controller('NewCharCtrl', function ($scope, $modalInstance) {
          $scope.submitForm = function () {
              if ($scope.charForm.$valid) {
                  console.log('user form is in scope');
                  var char = {
                    name: $scope.name
                  };
                  $modalInstance.close(char);
              } else {
                  console.log('userform is not in scope');
              }
          };

          $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
          };
    });