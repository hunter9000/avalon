
    scotchApp.controller('dungeonController', function($scope) {

    	$scope.stage = null;
		$scope.container = null;

		$scope.map = [];

		$scope.tileSize = 40;

		$scope.images = {};
		$scope.preload = null;
		$scope.manifest = [
		   {src: 'grass-tile.png', id: 'x', x: $scope.tileSize, y: $scope.tileSize},
		   {src: 'blank.png', id: 'blank', x: $scope.tileSize, y: $scope.tileSize},
		   {src: 'backing.png', id: 'backing', x: $scope.tileSize, y: $scope.tileSize},
		   {src: 'icon.png', id: 'icon', x: $scope.tileSize, y: $scope.tileSize}
		];

        $scope.offset = {x:null, y:null};     // vector from mouse point to corner of container
        $scope.allowHorizontalMove;
        $scope.allowVerticalMove;

        $scope.movingIcon;

        // sets up canvas, and starts image preload
        $scope.init = function() {
            $scope.stage = new createjs.Stage("demoCanvas");
            $scope.stage.setBounds(0, 0, $scope.stage.canvas.getAttribute('width'), $scope.stage.canvas.getAttribute('height'));
            $scope.stage.mouseMoveOutside = true;

            console.log('stage bounds '+ $scope.stage.getBounds());

            $scope.container = new createjs.Container();
            $scope.stage.addChild($scope.container);
			$scope.container.addEventListener('mousedown', function(event) {
				if (event.nativeEvent.button != 2) {        // restrict to right button
					return;
				}

				$scope.offset = {x: event.target.parent.x - event.rawX,
						  y: event.target.parent.y - event.rawY };
				console.log($scope.offset);
			});
            $scope.container.addEventListener('pressmove', function(event) {
				if (event.nativeEvent.button != 2) {        // restrict to right button
					return;
				}

				//console.log('container pressmove');
				if (allowHorizontalMove) {
					$scope.container.x = event.rawX + $scope.offset.x;
				}
				if (allowVerticalMove) {
					$scope.container.y = event.rawY + $scope.offset.y;
				}

                var stageRectangle = $scope.stage.getTransformedBounds();
                var contRectangle = $scope.container.getTransformedBounds();

                if (!contRectangle.contains(stageRectangle.x, stageRectangle.y, stageRectangle.width, stageRectangle.height)) {
                    //console.log('OUT ' + 'stageRect ' + stageRectangle + ' containerRect ' + contRectangle);
                    // adjust
                    if (allowHorizontalMove) {
                        if (contRectangle.x > stageRectangle.x) {
                            $scope.container.x = stageRectangle.x;
                        }
                        if (contRectangle.x + contRectangle.width < stageRectangle.width) {
                            $scope.container.x = stageRectangle.width - contRectangle.width;
                        }
                    }

                    if (allowVerticalMove) {
                        if (contRectangle.y > stageRectangle.y) {
                            $scope.container.y = stageRectangle.y;
                        }
                        if (contRectangle.y + contRectangle.height < stageRectangle.height) {
                            $scope.container.y = stageRectangle.height - contRectangle.height;
                        }
                    }
                }
            });

            createjs.Ticker.setFPS(60);
            createjs.Ticker.addEventListener("tick", $scope.stage);

//            $scope.preload();
			$scope.loadImage();
        }

		// begin preloading assets when page loads
		$scope.loadImage = function() {
            $scope.preload = new createjs.LoadQueue(true, 'img/tiles/');
            $scope.preload.addEventListener("fileload", $scope.handleFileComplete);
            $scope.preload.addEventListener("complete", $scope.handleComplete);
            $scope.preload.loadManifest($scope.manifest);
		}

		$scope.handleFileComplete = function(event) {
			console.log(event.item);
		}

		$scope.handleComplete = function() {
			$scope.loadMap();
		}

		$scope.instantiateImage = function(imgId) {
			var image = $scope.preload.getResult(imgId);

			// instantiate a bitmap based on this image
			var bitmap = new createjs.Bitmap(image);
			//stage.addChild(bitmap);
			return bitmap;
		}

        $scope.gridCoordsToWorldCoords = function(x, y) {
            return {'x':x*$scope.tileSize, 'y':y*$scope.tileSize};
        }

		$scope.loadMap = function() {
//			$http.get(etc) {
//				$scope.populate(data);		// get the map data from server here, pass it to populate
//			}

			// build test map
			$scope.map = [];
			for (i=0; i<5; i++) {
				var inner = [];
				for (j=0; j<5; j++) {
//					if (j%2 == 0) {
						inner.push(1);
//					}
//					else {
//						inner.push(0);
//					}
				}
				$scope.map.push(inner);
			}

            // create bitmaps for each tile, adding blank placeholders for empty spaces
            x = 0;
            y = 0;
            for (col=0; col<$scope.map.length; col++) {
                for (row=0; row<$scope.map[col].length; row++) {
                    var bitmap;
                    var backing;
                    if ($scope.map[col][row] == 1) {
                        bitmap = $scope.instantiateImage('x');
                    }
                    else {
                        bitmap = $scope.instantiateImage('blank');
                    }
                    bitmap.x = x;
                    bitmap.y = y;
                    bitmap.data = {coordCol: col, coordRow: row}
                    bitmap.addEventListener('click', function(event) {
                        if (event.nativeEvent.button != 0) {        // only left click
                            return;
                        }
                        console.log('bitmap click');
                        x = event.target.data.coordCol;
                        y = event.target.data.coordRow;

                        createjs.Tween.get($scope.movingIcon).to($scope.gridCoordsToWorldCoords(x, y), 1000).call(function() {
                            //Tween complete

                        });

                    });
                    $scope.container.addChild(bitmap);

                    if (col == 2 && row == 2) {
                        var iconBitmap = $scope.instantiateImage('icon');
                        iconBitmap.x = x;
                        iconBitmap.y = y;
                        $scope.container.addChild(iconBitmap);

                        $scope.movingIcon = iconBitmap;
                    }

                    backing = $scope.instantiateImage('backing');
                    bitmap.hitArea = backing;

                    y += $scope.tileSize;
                }
                x+= $scope.tileSize;
                y = 0;
            }

            $scope.container.setChildIndex( $scope.movingIcon, $scope.container.getNumChildren()-1);

            console.log('container bounds ' + $scope.container.getBounds());

            var stageRectangle = $scope.stage.getTransformedBounds();
            var contRectangle = $scope.container.getTransformedBounds();
            allowHorizontalMove = contRectangle.width > stageRectangle.width;
            allowVerticalMove = contRectangle.height > stageRectangle.height;

            // center the grid
            if (!$scope.allowHorizontalMove) {     // need to center horizontally
                $scope.container.x = (stageRectangle.width - contRectangle.width) / 2;
            }
            if (!$scope.allowVerticalMove) {       // // need to center vertically
                $scope.container.y = (stageRectangle.height - contRectangle.height) / 2;
            }
		}

        $scope.init();
    });

		// creates all the scene objects based on the mapdata
//    	$scope.populate = function(mapData) {
//    		// create the scene objects here
//    		var circle = new createjs.Shape();
//			circle.graphics.beginFill("DeepSkyBlue").drawCircle(0, 0, 50);
//			circle.x = 100;
//			circle.y = 100;
//			$scope.stage.addChild(circle);
//			circle.addEventListener("click", function (event) {
//				console.log('circle click');
//			});
//			$scope.circle = circle;
//
//			// create map tiles, attach click listeners
//
//			// create
//
//			createjs.Ticker.setFPS(60);
//			createjs.Ticker.addEventListener("tick", $scope.stage);
//    	}
//
//		$scope.move = function() {
//			if (!createjs.Tween.hasActiveTweens($scope.circle)) {
//				var tween = createjs.Tween.get($scope.circle, { loop: false })
//					.to({ x: 400 }, 1000, createjs.Ease.getPowInOut(4))
//					.to({ alpha: 0, y: 175 }, 500, createjs.Ease.getPowInOut(2))
//					.to({ alpha: 0, y: 225 }, 100)
//					.to({ alpha: 1, y: 200 }, 500, createjs.Ease.getPowInOut(2))
//					.to({ x: 100 }, 800, createjs.Ease.getPowInOut(2));
//				$scope.tween = tween;
//			}
//		}


/////// MOVE A SHAPE ALONG A PATH
//            steps = [
//                {x:10, y:10},
//                {x:20, y:10},
//                {x:20, y:30},
//                {x:40, y:30},
//                {x:10, y:10}
//            ];
//
//            var tween = createjs.Tween.get(circle, { loop: false });
//            for (i=0; i<steps.length; i++) {
//                tween.to({ x: steps[i].x, y: steps[i].y }, 1000, createjs.Ease.getPowInOut(4));
//            }
