
avalonApp.directive('toggleButton', function() {
    return {
        restrict: 'E',
        scope: {
            data: '=',
            onChange: '&',
        },
        template: '<button ng-click="toggle()" class="btn btn-secondary toggle-button" ng-class="{\'active\':data.selected, \'toggle-button-selected\': data.selected}">{{data.label}}</button>',
        controller: function($scope) {


            $scope.toggle = function() {
                console.log('toggling ' + $scope.data.label);
                $scope.data.selected = !$scope.data.selected;
                $scope.onChange({option: $scope.data});
//                scope.clickCallback({element: scope.ele});
            }
        },
    }
});