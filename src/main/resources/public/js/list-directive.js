
scotchApp.directive('list', function($compile, $interpolate) {
    return {
        restrict: 'E',
        scope: {
            contents: '=',
            templateContents: '@'
        },
        template: '<div class="scroll-list equipment-list"> \
                        <div class="scroll-list-inner"> \
                            <element ng-repeat="ele in contents track by $index" ele="ele" click="click(element)" template-contents="{{templateContents}}"></element> \
                        </div> \
                    </div>',
        link: function(scope, element, attrs) {
            //scope.contents = ['hi', 'hi', 'hi', 'hi', 'hi', 'hi', 'hi', 'hi', 'hi'];
            scope.click = function(element) {
                console.log('click ' + element);
            }

//            var myAttrFn = $interpolate(attrs.templatecontents)(scope);
//            $compile(myAttrFn)(scope);

//            element.find('element').append(myAttrFn);
//            $compile(element.contents())(scope);

//                    scope.rootDirectory = 'images/';
//
//                    TemplateService.getTemplates().then(function (response) {
//                        var templates = response.data;
//
//                        element.html(getTemplate(templates, scope.content.content_type));
//
//                        $compile(element.contents())(scope);
//                    });


        }
    }
});
scotchApp.directive('element', function($compile, $interpolate, TemplateService) {
    return {
        restrict: 'E',
        scope: {
            ele: '=ele',
            clickCallback: '&click',
            templateContents: '@'
        },
//        template: '<div class="scroll-item equipment-item" ng-click="click()"> \
//                        hello {{ele}}\
//                    </div>',
        link: function(scope, element, attrs) {
            scope.click = function() {
                scope.clickCallback({element: scope.ele});
            }

            TemplateService.getTemplate(scope.templateContents).then(function (response) {
                element.html(response.data);
                $compile(element.contents())(scope);
            });

//            startingTemplate = '<div class="scroll-item equipment-item" ng-click="click()"> \
//                                    hello {{ele}}\
//                                </div>';

//            var myAttrFn = $interpolate(attrs.templatecontents)(scope);
//            element.find('div').append(myAttrFn);
//            $compile(element.contents())(scope);
        }
    };
});