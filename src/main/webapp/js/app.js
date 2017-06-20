var app = angular.module('EmpMgmt', []);
app.controller('appController',function($scope,$http){
	$url = "http://localhost:8080/EmpMgmt/";
	loadProject();
	loadEmployees();
	
	$scope.openProjectForm = function(){
		$scope.project = null;
	}
	
	$scope.openEmployeeForm = function(){
		$scope.emp = null;
		$http.get($url+"getProjectDetails")
		.then(function (response) {
			$scope.projects = response.data;
			});
	}
	$scope.closeProject = function(){
		loadProject();
	}
	/*
	 * 
	 * For Projects
	 * 
	 * */
	function loadProject(){
		$http.get($url+"getProjectDetails")
		.then(function (response) {
			$scope.projects = response.data;
			});
	}
	
	$scope.submitProject = function(){
		if($scope.project.projectID === null){
	    	$http.post($url+"newProject", $scope.project)
	        .success(function (message) {
	        	$scope.msg = message,
	        	$scope.project = ""
	        });
		}else{
			$http.put($url+"editProjectDetails",$scope.project)
			.then(function(response){
				alert("update done");
			});
		}
    }
	
	$scope.deleteProject = function deleteProject(id){
		$http.delete($url+"DeleteProjectDetails/"+id)
		.then(function (response) {
                $scope.delmsg = response.data;
                loadProject();
            });
	}
	
	$scope.updateProjectBtn = function updateProject(id){
		$http.get($url+"ProjectById/"+id)
		.then(function(response){
			$scope.project = response.data
		});
	}
	
	/*
	 * 
	 * For Employee
	 * 
	 * */
	
	$scope.submitEmployee = function submitEmployee(){
		if($scope.employee.empId === null){
			$http.post($url+"saveEmp",$scope.employee)
			.then(function (message) {
	        	$scope.msg = message,
	        	$scope.employee = null
	        });
		}else{
			$http.put($url+"editEmployeeDetails",$scope.employee)
			.then(function(message){
				$scope.msg = message;
				$scope.employee = null;
				alert("Update done");
			});
		}
		
	}
	
	$scope.updateEmpBtn = function updateEmpBtn(id){
		$http.get($url+"employeeById/"+id)
		.then(function(response){
			$scope.employee = response.data
		});
	}
	
	function loadEmployees(){
		$http.get($url+"getEmployees")
		.then(function(response){
			$scope.employees = response.data
		});
	}
	
	$scope.closeEmployee = function(){
		loadEmployees();
	}
});
