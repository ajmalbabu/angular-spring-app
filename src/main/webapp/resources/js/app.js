'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['ngResource','AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives']);

App.factory('Price', function ($resource) {
	// TODO decide on the context variable.
    var Price = $resource('/angular-spring-app-master/pricelist/:priceid', {priceid: '@id'},
        {update: {method: 'PUT'}});

//    Price.prototype.isNew = function(){
//        return (typeof(this.id) === 'undefined');
//    }

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

    $routeProvider.otherwise({redirectTo: '/members'});
}]);
