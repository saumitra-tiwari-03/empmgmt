var app = angular.module('EmpMgmt', []);
app.controller('empCtrl', function($scope,$http) {
    //alert("angular controller called");
	
	$url = "http://localhost:8080/EmpMgmt/saveEmp";
    $scope.submitEmp = function(){
    	$http.post($url, $scope.emp)
        .success(function (data) {
        	$scope.msg = data
        })
    }
});

