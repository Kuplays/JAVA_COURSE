angular.module('angular-app', []).
controller('data-handler', function($scope, $http) {
    $http.get('http://localhost:9999/get_links').
      then(function(response) {
          $scope.data = response.data;
      });
    });