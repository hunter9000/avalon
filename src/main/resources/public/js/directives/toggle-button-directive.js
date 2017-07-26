
avalonApp.directive('toggleButton', function() {
    return {
        restrict: 'E',
        scope: {
            initiallySelected: '=',
            label: '=',
            onChange: '&',

        },
        template: '<button ng-click="toggle()" ng-class="{selected-toggle-button:selected}">{{label}}</button>',
        controller: function($scope) {
            $scope.selected = false;

            $scope.toggle = function() {
                $scope.selected = !$scope.selected;
                $scope.onChange();
            }


        },
    }
)};