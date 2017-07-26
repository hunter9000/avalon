
avalonApp.directive('toggleButton', function() {
    return {
        restrict: 'E',
        scope: {
            initiallySelected: '=',
            data: '=',
            onChange: '&',
        },
        template: '<button ng-click="toggle()" class="btn btn-secondary" ng-class="{\'active\':data.selected}">{{data.label}}</button>',
        controller: function($scope) {


            $scope.toggle = function() {
                console.log('toggling ' + $scope.data.label);
                $scope.data.selected = !$scope.data.selected;
                $scope.onChange();
            }
        },
    }
});