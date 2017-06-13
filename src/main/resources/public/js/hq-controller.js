

    avalonApp.controller('hqController', function($scope, $http, $routeParams, $window, $location) {
        $scope.char;

        // get the character from the provided id
        $http({method:'GET',
               url: 'api/char/' + $routeParams.charId + '/',
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

        $scope.goToInventory = function() {
            $location.path('/inventory/' + $routeParams.charId);
        }

        $scope.goToDungeon = function() {
            $location.path('/dungeon/' + $routeParams.charId);
        }
        $scope.goToPortals = function() {
            $location.path('/portals/' + $routeParams.charId);
        }

    });
