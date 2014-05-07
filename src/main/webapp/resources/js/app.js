'use strict';

var AngularSpringApp = {};

var app = angular.module('AngularSpringApp', [ 'ngResource','ngRoute',
		'AngularSpringApp.filters', 'AngularSpringApp.services',
		'AngularSpringApp.directives', 'ngGrid' ]);

app.factory('Price', function($resource) {
 
	var Price = $resource('pricelist/:priceid', {
		priceid : '@id'
	}, {
		update : {
			method : 'PUT'
		}
	});

	return Price;
});


app.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when('/members', {
		templateUrl : 'members/layout',
		controller : MemberController
	});

	$routeProvider.when('/pricelist', {
		templateUrl : 'pricelist/layout',
		controller : PriceListController
	});

	$routeProvider.when('/facilities', {
		templateUrl : 'facilities/layout',
		controller : FacilitiesController
	});

	$routeProvider.otherwise({
		redirectTo : '/members'
	});
	
} ]);


app.factory('httpInterceptorService', function($q, $rootScope) {
	
	// Append the right header to the request
	var extendHeaders = function(config) {
		config.headers = config.headers || {}; 
		config.headers['SsoAuthorizationCookie'] =  $rootScope.ssoAuthCookie;
	};
	
  return {
	      
    'request': function(config) {
      // Add the SSO cookie header.
    	extendHeaders(config);
    	return config || $q.when(config);
    },

   'requestError': function(rejection) {
      return $q.reject(rejection);
    },

    'response': function(response) {
      return response || $q.when(response);
    },

   'responseError': function(rejection) {
      return $q.reject(rejection);
    }
  };
});

//https://github.com/philipsorst/angular-rest-springsecurity/blob/master/src/main/webapp/js/app.js
app.config(['$httpProvider', function (httpProvider) {
    httpProvider.interceptors.push('httpInterceptorService');    
}]);



