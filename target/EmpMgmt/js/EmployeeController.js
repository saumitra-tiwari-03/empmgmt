// Controller Part

app.controller(
				"EmployeeController",
				function($scope, $http) {
					alert("EmployeeController hit!!");
					$scope.query = {};
					$scope.queryBy = '$';

					$scope.employee = [];

					$scope.pro =  {
						id : -1,
						pro_name : "",
						pro_cost : "",
					};

					$scope.employeeForm = {
						empid : -1,
						emp_name : "",
						emp_salary : "",
						emp_email : "",
						project : [ {
							id : -1,
							pro_name : "",
							pro_cost : ""
						}

						],

					};

					$scope.orderProp = "empid";

					$scope.addProject = function() {
						alert('called');
						$scope.employeeForm.project.push({})
					};

					/*
					 * project : { id : -1, pro_name : "",
					 */

					// Now load the data from server
					_refreshEmployeeData();
					// HTTP POST/PUT methods for add/edit country
					// with the help of id, we are going to find out whether it
					// is put or post operation
					$scope.submitEmployee = function() {
						alert($scope.employeeForm.project);
						var method = "";
						var url = "";
						if ($scope.employeeForm.empid == -1) {

							alert('submit Employee function invoked');
							// Id is absent in form data, it is create new
							// country operation
							method = "POST";
							url = '/SpringWith_WebService/AddEmployee';
						} else {

							alert('edit fuction invoked');
							method = "PUT";
							url = '/SpringWith_WebService/editEmployeeDetails';

						}

						$http({
							method : method,
							url : url,
							data : angular.toJson($scope.employeeForm),
							headers : {
								'Content-Type' : 'application/json'
							}
						}).then(_success, _error);
					};

					$scope.deleteEmployee = function(empid) {

						alert(empid);

						$http(
								{

									method : 'DELETE',

									url : 'http://localhost:8080/SpringWith_WebService/DeleteEmployeeDetails/'
											+ empid,

									headers : {
										'Content-type' : 'application/json;charset=utf-8'
									}

								}).then(_success, _error);

					};

					$scope.editAllEmployee = function(employee) {

						alert('edit function invoked');
						$scope.employeeForm.empid = employee.empid;
						$scope.employeeForm.emp_name = employee.emp_name;
						$scope.employeeForm.emp_salary = employee.emp_salary;
						$scope.employeeForm.emp_email = employee.emp_email;

					};

					// In case of edit, populate form fields and assign form.id
					// with country id
					$scope.editEmployee = function(employee, project) {

						alert(project.id);

						alert('edit function invoked');
						$scope.employeeForm.empid = employee.empid;
						$scope.employeeForm.emp_name = employee.emp_name;
						$scope.employeeForm.emp_salary = employee.emp_salary;
						$scope.employeeForm.emp_email = employee.emp_email;
						$scope.pro.id = project.id;
						$scope.pro.pro_name = project.pro_name;
						$scope.pro.pro_cost = project.pro_cost;

					};
					/* Private Methods */
					// HTTP GET- get all countries collection
					function _refreshEmployeeData() {
						$http(
								{

									method : 'GET',

									url : 'http://localhost:8080/SpringWith_WebService/getEmployeeList'

								}).then(function successCallback(response) {

							$scope.employee = response.data;
							$scope.pro = $scope.employee.project;

						}, function errorCallback(response) {

							console.log(response.statusText);

						});
					}
					function _success(response) {

						_refreshEmployeeData();

						_clearFormData()

					}
					function _error(response) {

						console.log(response.statusText);
					}
					// Clear the form

					function _clearFormData() {

						$scope.employeeForm.empid = -1;
						$scope.employeeForm.emp_name = "";
						$scope.employeeForm.emp_salary = "";
						$scope.employeeForm.emp_email = "";
						$scope.pro.id = -1;
						$scope.pro.pro_name = "";
						$scope.pro.pro_cost = "";

					}
					;

				});
