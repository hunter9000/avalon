


    scotchApp.controller('inventoryController', function($scope, $http, $location, $window) {

        $scope.char;

        $http({
            method: 'GET',
            url: '/api/char/',
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