
avalonApp.directive('listFilter', function($compile, $interpolate) {
    return {
        restrict: 'E',
        scope: {
            options: '@',       // array of icons and filter names
            filter: '=',        // exposed array of filter options
        },
        template: '<toggle-button ng-repeat="option in options" initially-selected="false" label="option" on-change="notify()"',
        controller:  function($scope) {
            $scope.notify = function() {
                console.log('a thing happened!');

                // for each options, check if it's selected, add to array
                $scope.filter = $scope.options.map(function() {

                });
            }
        },
    }
});
