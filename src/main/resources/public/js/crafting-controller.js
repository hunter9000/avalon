
avalonApp.controller('craftingController', function(APIService, $scope, $window, $routeParams) {
    $scope.recipes;
    $scope.inventory;

    $scope.selectedRecipe = null;

    $scope.mats;
    $scope.selectedMat = null;

    $scope.baseMats = [];
    $scope.extraMats = [];



    APIService.getChar($routeParams.charId, function(response) {
        $scope.recipes = response.data.recipes;
        $scope.inventory = response.data.inventory;
    });

    $scope.recipeSelect = function(recipe) {
        // get from recipe info, set base item, base mats, inventory

        console.log('controller says this recipe selected ' + recipe);
        $scope.resetMats();      // reset the working list of mats

        if ($scope.recipeCraftable(recipe)) {
            console.log('recipe craftable');
            $scope.selectedRecipe = recipe;

            // remove all the reqs from the working list of mats
            for (var i = 0; i < recipe.recipeReqs.length; i++) {
                var mat = recipe.recipeReqs[i];
                $scope.removeFromList($scope.mats, mat.materialModel.name, mat.quantity);
            }
        }
        else {
            console.log('recipe not craftable');
            $scope.selectedRecipe = null;
        }
    }

    $scope.matSelect = function(element) {
        console.log(element);
        $scope.selectedMat = element;
    }
    $scope.matDblclick = function() {
        console.log($scope.item);
        $scope.extraMats.push($scope.item);
    }

    $scope.addMatToRecipe = function() {
        console.log('add to recipe');

        $scope.addToList($scope.extraMats, $scope.selectedMat, 1);
        $scope.removeFromList($scope.mats, $scope.selectedMat.materialModel.name, 1);
    }

    $scope.submitRecipe = function() {
        var payload = {
            'id': $scope.selectedRecipe.id,
            'extraMats': $scope.extraMats
        };

        APIService.craftRecipe($routeParams.charId, payload, function(response) {
            console.log(data);
        });

//        $http({
//            method: 'POST',
//            url: '/api/recipes/',
//            headers: {'x-access-token': $window.localStorage['jwtToken']},
//            data: payload
//        })
//        .success(function (data) {
//            console.log(data);
//        })
//        .error(function (data) {
//            console.log(data);
//        });
    }

    // utility methods

    $scope.filterEffects = function(effectList) {
        var array = [];
        if ($scope.selectedRecipe != null && effectList) {
            for (i=0; i<effectList.length; i++) {
                if (effectList[i].slot == $scope.selectedRecipe.item.bodySlot) {
                    array.push(effectList[i]);
                }
            }
        }
        return array;
    }

    $scope.listContains = function(list, name, quantity) {
        for (var i = 0; i < list.length; i++) {
            var mat = list[i];
            if (mat.materialModel.name == name) {
                return (quantity <= mat.quantity);      // check if quantity <= mat.quantity
            }
        }
        return false;
    }

    /** removes the quantity of the named material from the given list. returns boolean if it was removed. */
    $scope.removeFromList = function(list, name, quantity) {
        for (var i = 0; i < list.length; i++) {
            var mat = list[i];
            if (mat.materialModel.name == name) {
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
            if (match.materialModel.name == mat.materialModel.name) {
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
            if (!$scope.listContains($scope.char.inventoryMaterialModels, req.materialModel.name, req.quantity) ) {
                return false;
            }
        }
        return true;
    }

    $scope.resetMats = function() {
        $scope.mats = JSON.parse(JSON.stringify($scope.char.inventoryMaterialModels));
        $scope.extraMats = [];
        $scope.baseMats = [];
    }

});