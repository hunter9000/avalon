
avalonApp.controller('inventoryController', function(APIService, InventoryService, $scope, $routeParams) {

    $scope.char;

    APIService.getChar($routeParams.charId, function(response) {
        $scope.char = response.data;
    });

    $scope.inventoryMaterialSelect = function(invMaterial, event) {
        console.log(invMaterial);
    }

    $scope.inventoryEquipmentSelect = function(invEquipment, event) {
        console.log(invEquipment);
        // show difference between this and equipped item
    }

    $scope.equipItem = function(invEquipment, event) {
        console.log('equiping item');
        console.log(invEquipment);

        var equipRequest = InventoryService.getEquipmentRequest(invEquipment.id, invEquipment.item.bodySlot);

        APIService.equipItem($routeParams.charId, equipRequest, function(response) {
            $scope.char = response.data;
        })
    }
});