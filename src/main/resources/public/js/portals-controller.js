
    avalonApp.controller('portalsController', function($scope, $http, $location, $window, $routeParams) {

        $scope.enterPortal = function(portalId) {
            $http({method:'POST',
                   url: '/api/char/' + $routeParams.charId + '/portal/' + portalId + '/',
                   headers: {'x-access-token': $window.localStorage['jwtToken']}
            })
            .success(function (data) {
                console.log(data);
                $location.path('/dungeon/'+$routeParams.charId);
            })
            .error(function(data) {
                console.log('Error:' + data);
            });
        }

    });
