// Controller Part

app
		.controller(
				"ProjectController",
				function($scope, $http) {
                 alert('controller invoked')
					$scope.project = [];

					$scope.projectForm = {
						id : -1,
						pro_name : "",
						pro_cost : "",
					

					};

					/*
					 * project : { id : -1, pro_name : "",
					 */

					// Now load the data from server
					_refreshProjectData();
					// HTTP POST/PUT methods for add/edit country
					// with the help of id, we are going to find out whether it
					// is put or post operation
					$scope.submitProject = function() {
						alert('submitProject function invoked');
						var method = "";
						var url = "";
						if ($scope.projectForm.id == -1) {

							alert('submit Project function for add');
							// Id is absent in form data, it is create new
							// country operation
							method = "POST";
							url = '/SpringWith_WebService/AddProject';
						} else {
							// Id is present in form data, it is edit country
							// operation
							method = "PUT";
							url = '/SpringWith_WebService/editProjectDetails';

						}

						$http({
							method : method,
							url : url,
							data : angular.toJson($scope.projectForm),
							headers : {
								'Content-Type' : 'application/json'
							}
						}).then(_success, _error);
					};

					$scope.deleteProject = function(id) {

						alert(id);

						$http(
								{

									method : 'DELETE',

									url : 'http://localhost:8080/SpringWith_WebService/DeleteProjectDetails/'
											+ empid,

									headers : {
										'Content-type' : 'application/json;charset=utf-8'
									}

								}).then(_success, _error);

					};
					// In case of edit, populate form fields and assign form.id
					// with country id
					$scope.editProject = function(project) {

						$scope.projectForm.id = project.id;
						$scope.projectForm.pro_name = project.pro_name;
						$scope.projectForm.pro_cost = project.cost;

					};
					/* Private Methods */
					// HTTP GET- get all countries collection
					function _refreshProjectData() {
						$http(
								{

									method : 'GET',

									url : 'http://localhost:8080/SpringWith_WebService/getProjectDetails'

								}).then(function successCallback(response) {

							$scope.project = response.data;

						}, function errorCallback(response) {

							console.log(response.statusText);

						});
					}
					function _success(response) {

						_refreshProjectData();

						_clearFormData()

					}
					function _error(response) {

						console.log(response.statusText);
					}
					// Clear the form

					function _clearFormData() {

						$scope.projectForm.id = -1;

						$scope.projectForm.pro_name = "";

					}
					;

				});
