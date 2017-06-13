	avalonApp.controller('editCharController', function($scope, $http, $window, $routeParams) {

		$scope.message = '';

		$scope.char = null;

		$http({method:'GET',
			   url: 'api/chars/' + $routeParams.charId,
			   headers: {'x-access-token': $window.localStorage['jwtToken']}
		})
		.success(function (data) {
			$scope.char = data;
			console.log('get api/chars/id ');
			console.log(data);
		})
		.error(function(data) {
			console.log('Error:' + data);
		});

		$scope.save = function() {
			$http({
				method: 'PATCH',
				url: 'api/chars/' + $scope.char._id,
				headers: {'x-access-token': $window.localStorage['jwtToken']},
				data: $scope.char
			})
			.success(function(data) {
				$scope.message = 'saved';
			})
			.error(function(data) {
				$scope.message = 'error ' + data;
			});

		};
	});