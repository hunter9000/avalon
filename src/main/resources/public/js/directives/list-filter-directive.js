
avalonApp.directive('listFilter', function($compile, $interpolate) {
    return {
        restrict: 'E',
        scope: {
            options: '=',       // array of icons and filter names
            filter: '=',        // exposed array of filter options
        },
        template: '<toggle-button ng-repeat="option in options track by $index" initially-selected="false" data="option" on-change="notify()" />',
        controller:  function($scope) {
            $scope.notify = function() {
                console.log('a thing happened!');

                // for each options, check if it's selected, add to array
                // filter isn't right function, need to only include those selected
                $scope.filter = $scope.options.filter(function(s) {
                    if (s.selected) {
                        return s.filter;
                    }
                });
            }
        },
    }
});
