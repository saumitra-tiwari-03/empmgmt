app.controller('ProjectCtrl', function($scope,$http){
	$url = "http://localhost:8080/EmpMgmt/";
	loadProject();
	
	$scope.openProjectForm = function(){
		$scope.project = {projectID:null,projectName:'',projectLeader:''};
	}
	
	$scope.submitClick = function(){
		loadProject();
	}
	
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
});
