
avalonApp.directive('paperDoll', function() {
    return {
        restrict: 'E',
        scope: {
            equippedItems: '=',
        },
        template: '<div class="paper-doll"> \
                       <div class="paper-doll-wrapper"> \
                           <div class="paper-doll-slot paper-doll-body">Body: {{equippedItems.BODY.equipment.item.name}}</div> \
                           <div class="paper-doll-slot paper-doll-left-hand">Left Hand: {{equippedItems.LEFT_HAND.equipment.item.name}}</div> \
                           <div class="paper-doll-slot paper-doll-right-hand">Right Hand: {{equippedItems.RIGHT_HAND.equipment.item.name}}</div> \
                       </div> \
                   </div>',
        controller: function ($scope) {

        }
    }
});


