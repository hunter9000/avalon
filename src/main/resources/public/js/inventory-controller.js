


    avalonApp.controller('inventoryController', function($scope, $http, $routeParams, $location, $window) {

        $scope.char;

        $http({
            method: 'GET',
            url: '/api/char/' + $routeParams.charId + '/',
            headers: {'x-access-token': $window.localStorage['jwtToken']}
        })
        .success(function (data) {
            $scope.char = data;
        })
        .error(function (data) {
            console.log('Error: ');
            console.log(data);
        });

        $scope.inventoryMaterialSelect = function(element) {
            console.log(element);
        }

    });