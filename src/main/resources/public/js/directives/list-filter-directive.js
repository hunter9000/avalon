
avalonApp.directive('listFilter', function($compile, $interpolate) {
    return {
        restrict: 'E',
        scope: {
            options: '=',       // array of icons and filter names
            filter: '=',        // exposed array of filter options
        },
        template: '<toggle-button data="allOption" on-change="selectAll()" /> \
                    <toggle-button ng-repeat="option in options track by $index" data="option" on-change="notify(option)" /> \
                    <toggle-button data="noneOption" on-change="selectNone()" /> ',
        controller:  function($scope) {
            $scope.allOption = {'selected': true, 'label': 'All', 'filter': ''};
            $scope.noneOption = {'selected': false, 'label': 'None', 'filter': ''};

            $scope.setFilter = function() {
                // for each options, check if it's selected, add to array
                $scope.filter = [];
                for (i=0; i<$scope.options.length; i++) {
                    if ($scope.options[i].selected) {
                        $scope.filter.push($scope.options[i].filter);
                    }
                }
            }

            $scope.selectAll = function() {
                console.log('select all!');

                // don't deselect this button if it's already selected
                if ($scope.allOption.selected) {
                    return;
                }

                $scope.options.forEach(function(currentValue, index, array) {
                    currentValue.selected = true;
                });

                $scope.setFilter();
            }

            // select all by default
            $scope.selectAll();

            $scope.selectNone = function() {
                console.log('select none!');

                // don't deselect this button if it's already selected
                if ($scope.noneOption.selected) {
                    return;
                }

                $scope.options.forEach(function(currentValue, index, array) {
                    currentValue.selected = false;
                });

                $scope.setFilter();
            }

            $scope.notify = function(option) {
                console.log('a thing happened!');
                console.log(option);

                $scope.allOption.selected = false;
                $scope.noneOption.selected = false;

                $scope.setFilter();
            }

        },
    }
});
