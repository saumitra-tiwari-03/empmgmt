<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Welcome</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
		<script src="js/app.js"></script>
	</head>
	<body ng-app="EmpMgmt" ng-controller="appController">
		<div class="container">
	  		<h2><u>Employee Management System</u></h2>
	  		<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#employee" ng-click="openEmployeeForm()">New Employee</button>
		  	<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#project" ng-click="openProjectForm()">New Project</button>
		  	<br><br>
		  	<ul class="nav nav-tabs">
			  <li class="active"><a data-toggle="tab" href="#projects">Projects</a></li>
			  <li><a data-toggle="tab" href="#employees">Employees</a></li>
			</ul>
		  	<div class="tab-content">
		  		<div id="projects" class="tab-pane fade in active">
			  		<table class="table table-hover" >
				  		<tr>
					      <th>Project Code</th>
					      <th>Project Name</th>
					      <th>Project Leader</th>
					      <th>Actions</th>
					    </tr>
					    <tr ng-repeat="x in projects">
					        <td>{{ x.projectCode }}</td>
					        <td>{{ x.projectName }}</td>
					        <td>{{ x.projectLeader }}</td>
					        <td>
					        	<button type="button" class="btn btn-warning"  data-toggle="modal" data-target="#project" ng-click="updateProjectBtn(x.projectID)">Update</button>
								<button type="button" class="btn btn-danger" ng-click="deleteProject(x.projectID)" >Delete</button>
					        </td>
					      </tr>
					</table>
				</div>
				<div id="employees" class="tab-pane fade">
					<table class="table table-hover">
						<tr>
						    <th>Employee Code</th>
						    <th>Employee Name</th>
						    <th>Emploee Email</th>
						    <th>Employee Mobile</th>
						    <th>Emploee Project</th>
						    <th>Actions</th>
						</tr>
						<tr ng-repeat="y in employees">
							<td>{{y.empCode}}</td>
							<td>{{y.empName}}</td>
							<td>{{y.empEmail}}</td>
							<td>{{y.empMobile}}</td>
							<td>{{y.project.projectName}}</td>
							<td>
					        	<button type="button" class="btn btn-warning"  data-toggle="modal" data-target="#employee" ng-click="updateEmpBtn(y.empId)">Update</button>
								<button type="button" class="btn btn-danger" ng-click="deleteEmployee(y.empId)" >Delete</button>
					        </td>
						</tr>      
					</table>
				</div>
		  	</div>
			<!-- Modal -->
			<div class="modal fade" id="employee" role="dialog">
			    <div class="modal-dialog">
			    	<!-- Modal content-->
			      	<div class="modal-content">
				        <div class="modal-header">
				        	<button type="button" class="close" data-dismiss="modal">&times;</button>
				          	<h4 class="modal-title">Create New Employee</h4>
				        </div>
				        <div class="modal-body">
				          	<form>
				          		Employee Code:<br>
				          		<input type="text" ng-model="employee.empCode"/><br>
				          		Employee Name:<br>
				          		<input type="text" ng-model="employee.empName"/><br>
				          		Employee Email:<br>
				          		<input type="text" ng-model="employee.empEmail"/><br>
				          		Employee Mobile:<br>
				          		<input type="text" ng-model="employee.empMobile"/><br>
				          		Project:<br>
				          		<select ng-model="employee.project" ng-options="p.projectName for p in projects track by p.projectID"></select><br><br>
				          		<button type="button" ng-click="submitEmployee()">Submit</button>
				          	</form>
				        </div>
				        <div class="modal-footer">
				          	<button type="button" class="btn btn-default" data-dismiss="modal" ng-click="closeEmployee()">Close</button>
				        </div>
			    	</div>
			    </div>
	    	</div>
			<div class="modal fade" id="project" role="dialog">
				<div class="modal-dialog">
				
				  <!-- Modal content-->
					<div class="modal-content">
						<div class="modal-header">
						  <button type="button" class="close" data-dismiss="modal">&times;</button>
						  <h4 class="modal-title">Create New Project</h4>
						</div>
					   	<div class="modal-body">
					    	<form>
					    		Project Code:<br>
					    		<input type="text" ng-model="project.projectCode"/><br>
								Project Name :<br>
								<input type="text" ng-model="project.projectName"/><br>
								Project Leader :<br>
								<input type="text" ng-model="project.projectLeader"/><br><br>
								<button type="button" ng-click="submitProject()">Submit</button>
							</form>
					 	</div>
						<div class="modal-footer">
						  <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="closeProject()">Close</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>