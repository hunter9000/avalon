
avalonApp.controller('inventoryController', function(APIService, $scope, $routeParams) {

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
    }

});