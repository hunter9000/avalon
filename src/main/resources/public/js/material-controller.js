
	angular.module('scotchApp').controller('materialsController', function($scope, $http, $window, $routeParams, $modal) {

		$scope.mats = null;

        $scope.fetchMats = function() {
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
        }

        $scope.fetchMats();

		$scope.addMat = function() {
			var modalInstance = $modal.open({
			  animation: true,
			  templateUrl: 'pages/templates/new-material-modal.html',
			  controller: 'NewMaterialCtrl',
			  size: 'md'
			});

			modalInstance.result.then(
				function (newMat) {		// ok selected
					// create new mat at server
					$http({method:'POST',
						   url: 'api/materials/',
						   data: newMat,
						   headers: {'x-access-token': $window.localStorage['jwtToken']}
						})
						.success(function (data, status, headers, config) {
//							$scope.mats.push(data.mat);
                            $scope.fetchMats();
//							console.log('post api/materials ');
							console.log(data);
						})
						.error(function(data, status, headers, config) {
							console.log('Error:' + data);
						}
					);
				},
				function () {					// closed

				}
			);
		}

		$scope.addEffect = function() {

		}

		$scope.deleteMat = function(matId) {
            $http({method:'DELETE',
                   url: 'api/materials/'+matId,
                   headers: {'x-access-token': $window.localStorage['jwtToken']}
                })
                .success(function (data, status, headers, config) {
//                    $scope.mats.push(data.mat);
//							console.log('post api/materials ');
                    console.log(data);
                    $scope.fetchMats();
                })
                .error(function(data, status, headers, config) {
                    console.log('Error:' + data);
                }
            );

		}

		$scope.deleteEffect = function(effectId) {
		}

	});


    angular.module('scotchApp').controller('NewMaterialCtrl', function ($scope, $modalInstance) {

		 /* $scope.ok = function () {
			$modalInstance.close($scope.selected.item);
		  };

		  $scope.cancel = function () {
			$modalInstance.dismiss('cancel');
		  };

		  $scope.save = function(mat) {

		  }*/

		  $scope.submitForm = function () {
			  if ($scope.matForm.$valid) {
				  console.log('user form is in scope');
				  var mat = {
				    name: $scope.name,
				    icon:$scope.icon
				  };
				  $modalInstance.close(mat);
			  } else {
				  console.log('userform is not in scope');
			  }
		  };
    });
