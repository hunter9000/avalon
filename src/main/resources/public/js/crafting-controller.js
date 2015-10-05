


    scotchApp.controller('craftingController', function($scope, $http, $window, $routeParams) {
        $scope.recipes;
        $scope.char;

        $scope.mats;
        $scope.selectedMat = null;

        $scope.baseMats = [];
        $scope.extraMats = [];

        $scope.selectedRecipe = null;

        $scope.fetchRecipes = function() {
            $http({
              method: 'GET',
              url: '/api/recipes/'+1,
              headers: {'x-access-token': $window.localStorage['jwtToken']}  })
                .success(function(data) {
                    $scope.recipes = data;
                    console.log(data);
                })
                .error(function(data) {
                    console.log('Error: ' + data);
                }
            );
        }
        $scope.fetchRecipes();
        $http({
            method: 'GET',
            url: '/api/char/',
            headers: {'x-access-token': $window.localStorage['jwtToken']}
        })
        .success(function (data) {
            $scope.char = data;
            $scope.resetMats();
        })
        .error(function (data) {
            console.log(data);
        });

        $scope.recipeSelect = function(recipe) {
//            console.log($scope.item);
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
        }

        $scope.filterEffects = function(effectList) {
            var array = [];
            if ($scope.selectedRecipe != null) {
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
            $scope.mats = JSON.parse(JSON.stringify($scope.char.inventoryMaterialModels))
        }

    });