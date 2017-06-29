
avalonApp.controller('craftingController', function(APIService, InventoryService, $scope, $window, $routeParams, $log) {
    $scope.recipes;
    $scope.inventoryMaterials;

    $scope.selectedRecipe = null;
//    $scope.selectedRecipeCraftable = false;

    $scope.mats;
    $scope.selectedMat = null;

    $scope.baseMats = [];
    $scope.extraMats = [];



    APIService.getChar($routeParams.charId, function(response) {
        $scope.recipes = response.data.recipes;
        $scope.inventoryMaterials = response.data.inventoryMaterials;
        $scope.resetMats();
    });

    $scope.resetMats = function() {
        // copy the mats objects
        $scope.mats = JSON.parse(JSON.stringify($scope.inventoryMaterials));
        $scope.extraMats = [];
        $scope.baseMats = [];
    }

    $scope.recipeSelect = function(recipe) {
        // get from recipe info, set base item, base mats, inventory
        $scope.selectedRecipe = recipe;

        $log.debug('controller says this recipe selected ', recipe);
        $scope.resetMats();      // reset the working list of mats

//        $scope.selectedRecipeCraftable = $scope.recipeCraftable(recipe);

        $log.debug('recipe craftable ', $scope.selectedRecipe.isCraftable);


        if ($scope.selectedRecipe.isCraftable) {
            // remove all the reqs from the working list of mats
            for (var i = 0; i < recipe.recipeReqs.length; i++) {
                var mat = recipe.recipeReqs[i];
                InventoryService.removeFromList($scope.mats, mat.material.name, mat.quantity);
            }
        }
    }

    $scope.matSelect = function(element, event) {
        console.log('clicked material!');
        $log.debug(element);
        $scope.selectedMat = element;
    }
//    $scope.matAdd = function(element, event) {
//        $log.debug(element);
//        $scope.extraMats.push(element);
//    }

    $scope.addMatToRecipe = function(element, event) {
        $log.debug('add to recipe');

        // split 1 off the item
        var newItem = InventoryService.splitItem(element, 1);

        // add to extramats
        // find in the list
        InventoryService.addToList($scope.extraMats, newItem);

        // if quantity is now 0, remove from mats list


//        $scope.addToList($scope.extraMats, $scope.selectedMat, 1);
//        $scope.removeFromList($scope.mats, $scope.selectedMat.material.name, 1);
    }

    $scope.submitRecipe = function() {
        var payload = {
            'id': $scope.selectedRecipe.id,
            'extraMats': $scope.extraMats
        };

        APIService.craftRecipe($routeParams.charId, payload, function(response) {
            $log.debug(data);
        });
    }

    // utility methods

//    $scope.filterEffects = function(effectList) {
//        var array = [];
//        if ($scope.selectedRecipe != null && effectList) {
//            for (i=0; i<effectList.length; i++) {
//                if (effectList[i].slot == $scope.selectedRecipe.item.bodySlot) {
//                    array.push(effectList[i]);
//                }
//            }
//        }
//        return array;
//    }



//    $scope.listContains = function(list, name, quantity) {
//        for (var i = 0; i < list.length; i++) {
//            var mat = list[i];
//            if (mat.material.name == name) {
//                return (quantity <= mat.quantity);      // check if quantity <= mat.quantity
//            }
//        }
//        return false;
//    }

    /** removes the quantity of the named material from the given list. returns boolean if it was removed. */
//    $scope.removeFromList = function(list, name, quantity) {
//        for (var i = 0; i < list.length; i++) {
//            var mat = list[i];
//            if (mat.material.name == name) {
//                mat.quantity -= quantity;       // reduce the quantity
//                if (mat.quantity == 0) {
//                    list.splice(i, 1);      // remove from array completely
//                }
//                return true;
//            }
//        }
//        return false;
//    }

//    $scope.addToList = function(list, mat, quantity) {
//        for (var i = 0; i < list.length; i++) {
//            var match = list[i];
//            if (match.material.name == mat.material.name) {
//                match.quantity += quantity;
//                return;
//            }
//        }
//        // not found, add to list
//        var newMat = JSON.parse(JSON.stringify(mat));
//        newMat.quantity = quantity;
//        list.push(newMat);
//    }

    /** check the given recipe to see if the player's inventory of materials has. returns boolean */
//    $scope.recipeCraftable = function(recipe) {
//        for (i=0; i<recipe.recipeReqs.length; i++) {
//            var req = recipe.recipeReqs[i];
//            if (!$scope.listContains($scope.inventoryMaterials, req.material.name, req.quantity) ) {
//                return false;
//            }
//        }
//        return true;
//    }

});