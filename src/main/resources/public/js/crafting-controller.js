


    scotchApp.controller('craftingController', function($scope, $http, $window, $routeParams) {
        $scope.recipes;// = ['Volvo', 'Saab', 'Mercedes', 'Audi'];

        $scope.mats;// = ['one', 'two', 'three'];
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

        $scope.recipeSelect = function() {
            console.log($scope.item);
            $scope.selectedRecipe = $scope.item;
        }

        $scope.matSelect = function() {
            console.log($scope.item);
            $scope.selectedMat = $scope.item;
        }
        $scope.matDblclick = function() {
            console.log($scope.item);
            $scope.extraMats.push($scope.item);
        }

        $scope.listContains = function(list, name, quantity) {
            list.forEach(function(mat) {
                if (mat.name == name) {
                    // check if quantity <= mat.quantity
                    if (true) {
                        return true;
                    }
                }
            });
        }

        $scope.removeFromList = function(list, material) {
            list.forEach(function(mat) {
                if (mat.name == material.name) {
                    // check if quantity <= mat.quantity
                    mat.quantity -= material.quantity;
                    if (mat.quantity == 0) {
                        // remove from list
                    }
                }
            });
        }

    });