
avalonApp.controller('craftingController', function(APIService, $scope, $window, $routeParams, $log) {
    $scope.recipes;
    $scope.inventoryMaterials;

    $scope.selectedRecipe = null;
    $scope.selectedRecipeCraftable = false;

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

        $log.debug('controller says this recipe selected ', recipe);
        $scope.resetMats();      // reset the working list of mats

        $scope.selectedRecipeCraftable = $scope.recipeCraftable(recipe);

        $log.debug('recipe craftable ', $scope.selectedRecipeCraftable);
        $scope.selectedRecipe = recipe;

        if ($scope.selectedRecipeCraftable) {
            // remove all the reqs from the working list of mats
            for (var i = 0; i < recipe.recipeReqs.length; i++) {
                var mat = recipe.recipeReqs[i];
                $scope.removeFromList($scope.mats, mat.material.name, mat.quantity);
            }
        }
//        else {
//            $log.debug('recipe not craftable');
//            $scope.selectedRecipe = null;
//        }
    }

    $scope.matSelect = function(element) {
//        if (event.ctrlKey) {
//
//        }

        $log.debug(element);
        $scope.selectedMat = element;
    }
    $scope.matDblclick = function() {
        $log.debug($scope.item);
        $scope.extraMats.push($scope.item);
    }

    $scope.addMatToRecipe = function() {
        $log.debug('add to recipe');

        $scope.addToList($scope.extraMats, $scope.selectedMat, 1);
        $scope.removeFromList($scope.mats, $scope.selectedMat.material.name, 1);
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

    $scope.listContains = function(list, name, quantity) {
        for (var i = 0; i < list.length; i++) {
            var mat = list[i];
            if (mat.material.name == name) {
                return (quantity <= mat.quantity);      // check if quantity <= mat.quantity
            }
        }
        return false;
    }

    /** removes the quantity of the named material from the given list. returns boolean if it was removed. */
    $scope.removeFromList = function(list, name, quantity) {
        for (var i = 0; i < list.length; i++) {
            var mat = list[i];
            if (mat.material.name == name) {
                mat.quantity -= quantity;       // reduce the quantity
                if (mat.quantity == 0) {
                    list.splice(i, 1);      // remove from array completely
                }
                return true;
            }
        }
        return false;
    }

    $scope.addToList = function(list, mat, quantity) {
        for (var i = 0; i < list.length; i++) {
            var match = list[i];
            if (match.material.name == mat.material.name) {
                match.quantity += quantity;
                return;
            }
        }
        // not found, add to list
        var newMat = JSON.parse(JSON.stringify(mat));
        newMat.quantity = quantity;
        list.push(newMat);
    }

    /** check the given recipe to see if the player's inventory of materials has. returns boolean */
    $scope.recipeCraftable = function(recipe) {
        for (i=0; i<recipe.recipeReqs.length; i++) {
            var req = recipe.recipeReqs[i];
            if (!$scope.listContains($scope.inventoryMaterials, req.material.name, req.quantity) ) {
                return false;
            }
        }
        return true;
    }

});