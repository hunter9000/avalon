

    scotchApp.controller('portalsController', function($scope, $http, $location, $window) {
        $scope.enterPortal = function(portalId) {
            $http({method:'POST',
                   url: '/api/portal/' + portalId,
                   headers: {'x-access-token': $window.localStorage['jwtToken']}
            })
            .success(function (data) {
                console.log(data);
                $location.path('/dungeon/');
            })
            .error(function(data) {
                console.log('Error:' + data);
            });
        }
    });
