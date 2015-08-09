

scotchApp.factory('TemplateService', function ($http, TEMPLATE_FRAGMENT_URL) {
//    var getTemplate = function (content) {
//        return $http.get('templates/' + content + '.html');
//    };
//
//    return {
//        getTemplate: getTemplate
//    };
    return {
        getTemplate: function (content) {
            return $http.get(TEMPLATE_FRAGMENT_URL + content);
        }
    };
});