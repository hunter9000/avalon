
	angular.module('scotchApp').controller('materialsController', function($scope, $http, $window, $routeParams, $modal) {

		$scope.mats = null;
		$scope.effectTypes = [];
		$scope.equipmentSlots = [];

        $scope.fetchMats = function() {
            $http({method:'GET',
                   url: 'api/materials/',
                   headers: {'x-access-token': $window.localStorage['jwtToken']}
                })
                .success(function (data) {
                    $scope.mats = data;
                    console.log(data);
                })
                .error(function(data) {
                    console.log('Error:' + data);
                }
            );
        }

        $scope.fetchMats();

        // Get the effect types
        $http({method:'GET',
               url: '/api/effectTypes',
               headers: {'x-access-token': $window.localStorage['jwtToken']}
            })
            .success(function (data) {
                $scope.effectTypes = data;
                console.log(data);
            })
            .error(function(data) {
                console.log('Error:' + data);
            }
        );

        // get the equipment slot
        $http({method:'GET',
               url: '/api/equipmentSlots',
               headers: {'x-access-token': $window.localStorage['jwtToken']}
            })
            .success(function (data) {
                $scope.equipmentSlots = data;
                console.log(data);
            })
            .error(function(data) {
                console.log('Error:' + data);
            }
        );

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
                            $scope.fetchMats();
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

		$scope.addEffect = function(matId) {
            var modalInstance = $modal.open({
                animation: true,
                templateUrl: 'pages/templates/new-effect-modal.html',
                controller: 'NewEffectCtrl',
                size: 'md',
                resolve: {
                    effectTypes: function () {
                        return $scope.effectTypes;
                    },
                    matId: function() {
                        return matId;
                    },
                    equipmentSlots: function() {
                        return $scope.equipmentSlots;
                    }
                }
			});

			modalInstance.result.then(
                function (newEff) {		// ok selected
                    $http({method:'POST',
                           url: 'api/materials/'+newEff.matId+'/effect',
                           data: newEff,
                           headers: {'x-access-token': $window.localStorage['jwtToken']}
                        })
                        .success(function (data, status, headers, config) {
                            $scope.fetchMats();
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

		$scope.deleteMat = function(matId) {
            $http({method:'DELETE',
                   url: 'api/materials/'+matId,
                   headers: {'x-access-token': $window.localStorage['jwtToken']}
                })
                .success(function (data, status, headers, config) {
                    console.log(data);
                    $scope.fetchMats();
                })
                .error(function(data, status, headers, config) {
                    console.log('Error:' + data);
                }
            );
		}

		$scope.deleteEffect = function(matId, effectId) {
            $http({method:'DELETE',
                   url: 'api/materials/'+matId+'/effect/'+effectId,
                   headers: {'x-access-token': $window.localStorage['jwtToken']}
                })
                .success(function (data, status, headers, config) {
                    console.log(data);
                    $scope.fetchMats();
                })
                .error(function(data, status, headers, config) {
                    console.log('Error:' + data);
                }
            );
		}

	});


    angular.module('scotchApp').controller('NewMaterialCtrl', function ($scope, $modalInstance) {
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

          $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
          };
    });

    angular.module('scotchApp').controller('NewEffectCtrl', function ($scope, $modalInstance, effectTypes, equipmentSlots, matId) {

        $scope.effectTypes = effectTypes;
        $scope.equipmentSlots = equipmentSlots;
        $scope.matId = matId;

        $scope.submitForm = function () {
            if ($scope.effForm.$valid) {
                console.log('user form is in scope');
                var eff = {
                    name: $scope.name,
                    value: $scope.value,
                    effectType: $scope.effectType,
                    slot: $scope.slot,
                    matId: $scope.matId
                };
                $modalInstance.close(eff);
            } else {
                console.log('userform is not in scope');
            }
        };

        $scope.cancel = function () {
            $modalInstance.dismiss('cancel');
        };
    });
