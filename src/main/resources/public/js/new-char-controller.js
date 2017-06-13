//
//avalonApp.controller('newCharController', function($scope, $location, $http, $window) {
//    $scope.message = '';
//
//    $scope.formData = {
//        characterName: '',
//        selectedClassId: {}
//    };
//
//    $scope.charClasses = [];
//
//    $http({
//        method:'GET',
//        url:'/api/class/',
//        headers: {'x-access-token': $window.localStorage['jwtToken']}
//    })
//    .then(function successCallback(response) {
//        $scope.charClasses = response.data;
//    }, function errorCallback(response) {
//        $scope.message = "error loading character classes";
//        $location.path('/error');
//    });
//
//    $scope.save = function() {
//        $http({
//            method: 'POST',
//            url: '/api/charactersheet/',
//            headers: {'x-access-token': $window.localStorage['jwtToken']},
//            data: $scope.formData
//        })
//        .then(function successCallback(response) {
//            $location.path("/charselect");
//        }, function errorCallback(response) {
//            $scope.message = "error creating character sheet";
//            $location.path('/error');
//        });
//    };
//});
//
