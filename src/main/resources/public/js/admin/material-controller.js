

	angular.module('scotchApp').controller('materialsController', function($scope, $http, $window, $routeParams, $modal) {

		$scope.mats = null;
//		$scope.effectTypes = [];
//		$scope.equipmentSlots = [];
//
//        $scope.fetchEffectTypes = function() {
//            // Get the effect types
//            $http({method:'GET',
//                   url: '/api/effectTypes',
//                   headers: {'x-access-token': $window.localStorage['jwtToken']}
//                })
//                .success(function (data) {
//                    $scope.effectTypes = data;
//                    $scope.fetchEquipmentSlots();
//                    console.log(data);
//                })
//                .error(function(data) {
//                    console.log('Error:' + data);
//                }
//            );
//        }
//
//        $scope.fetchEquipmentSlots = function() {
//            // get the equipment slot
//            $http({method:'GET',
//                   url: '/api/equipmentSlots',
//                   headers: {'x-access-token': $window.localStorage['jwtToken']}
//                })
//                .success(function (data) {
//                    $scope.equipmentSlots = data;
//                    $scope.fetchMats();
//                    console.log(data);
//                })
//                .error(function(data) {
//                    console.log('Error:' + data);
//                }
//            );
//        }

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

        $scope.fetchMats();      // kick off the chain of loading all the data. Load the effect types, then equip slots, then mats. this is so when we populate the mats, the other two are already loaded.

	});

    angular.module('scotchApp').directive('material', ['$http', '$window', function ($http, $window) {
        return {
            restrict: 'E',
            templateUrl: 'pages/templates/material-template.html',
            replace: true,
            scope: {
                material: '=material',
                refreshCallback: '&refresh',
                effectTypes: '=effectTypes',
                equipmentSlots: '=equipmentSlots'
            },
            link: function (scope, element, attrs) {
                scope.deleteMat = function(matId) {
                    console.log('jwt ' + $window.localStorage['jwtToken']);
                    $http({method:'DELETE',
                           url: 'api/materials/'+matId,
                           headers: {'x-access-token': $window.localStorage['jwtToken']}
                        })
                        .success(function (data, status, headers, config) {
                            console.log(data);
//                            $scope.fetchMats();
                            element[0].remove();
                        })
                        .error(function(data, status, headers, config) {
                            console.log('Error:' + data);
                        }
                    );
                };

                scope.deleteEffect = function(matId, effectId) {
                    $http({method:'DELETE',
                           url: 'api/materials/'+matId+'/effect/'+effectId,
                           headers: {'x-access-token': $window.localStorage['jwtToken']}
                        })
                        .success(function (data, status, headers, config) {
                            console.log(data);
//                            $scope.fetchMats();
                            scope.refreshCallback();
                        })
                        .error(function(data, status, headers, config) {
                            console.log('Error:' + data);
                        }
                    );
                }
            }
        };
    }]);

    angular.module('scotchApp').directive('materialadd', ['$http', '$window', function ($http, $window) {
        return {
            restrict: 'E',
            templateUrl: 'pages/templates/material-add-template.html',
            replace: true,
            scope: {
                refreshCallback: '&refresh'
            },
            link: function (scope, element, attrs) {
                scope.showForm = false;
                scope.mat = {name: '', icon: ''};

                scope.clickMe = function () {
                    scope.showForm = !scope.showForm;
                };

                scope.createNew = function() {
                    scope.showForm = !scope.showForm;
                    console.log(scope.mat);
                    // post scope.mat to the server
                    $http({method:'POST',
                           url: 'api/materials/',
                           data: scope.mat,
                           headers: {'x-access-token': $window.localStorage['jwtToken']}
                        })
                        .success(function (data, status, headers, config) {
//                            scope.fetchMats();
                            scope.refreshCallback();
                            console.log(data);
                        })
                        .error(function(data, status, headers, config) {
                            console.log('Error:' + data);
                        }
                    );
                }
            }
        };
    }]);

    angular.module('scotchApp').directive('effectadd', ['$http', '$window', 'StaticData', function ($http, $window, StaticData) {
        return {
            restrict: 'E',
            templateUrl: 'pages/templates/effect-add-template.html',
            replace: true,
            scope: {
                refreshCallback: '&refresh'
                mat: '='
            },
            link: function(scope, element, attrs) {
                scope.showForm = false;
                scope.effectTypes = StaticData.effectTypes;
                scope.equipmentSlots = StaticData.equipmentSlots;
                scope.eff = {effectType: '', value: '', slot: '', matId: scope.mat.id};

                scope.clickMe = function () {
                    scope.showForm = !scope.showForm;
                };

                scope.createNew = function() {
                    scope.showForm = !scope.showForm;

                    $http({method:'POST',
                           url: 'api/materials/'+scope.mat.id+'/effect',
                           data: scope.eff,
                           headers: {'x-access-token': $window.localStorage['jwtToken']}
                        })
                        .success(function (data, status, headers, config) {

                            console.log(data);
                        })
                        .error(function(data, status, headers, config) {
                            console.log('Error:' + data);
                        }
                    );
                    scope.eff = {effectType: '', value: '', slot: '', matId: scope.mat.id};      // reset the eff
                };
            }
        }
    }]);

