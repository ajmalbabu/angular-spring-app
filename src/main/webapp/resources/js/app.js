'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['ngResource','AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives','ngGrid']);

App.factory('Price', function ($resource) {

    var Price = $resource('pricelist/:priceid', {priceid: '@id'},
        {update: {method: 'PUT'}});


    return Price;
});

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {

    $routeProvider.when('/members', {
        templateUrl: 'members/layout',
        controller: MemberController
    });

    $routeProvider.when('/pricelist', {
        templateUrl: 'pricelist/layout',
        controller: PriceListController
    });
    
    $routeProvider.when('/facilities', {
        templateUrl: 'facilities/layout',
        controller: FacilitiesController
    });   

    $routeProvider.otherwise({redirectTo: '/members'});
}]);
