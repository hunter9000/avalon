

    scotchApp.controller('hqController', function($scope, $http, $routeParams, $window) {
        // get the character from the provided id
        $http({method:'GET',
               url: 'api/char/',
               headers: {'x-access-token': $window.localStorage['jwtToken']}
        })
        .success(function (data) {
            $scope.char = data;
            console.log('get api/char/charId');
            console.log(data);
        })
        .error(function(data) {
            console.log('Error:' + data);
        });
    });
