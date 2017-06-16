<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
<script src="js/app.js"></script>

</head>
<body ng-app="EmpMgmt" >

	<div class="container" ng-controller="ProjectCtrl">
  	<h2><u>Employee Management System</u></h2>
  	
  	<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#employee">New Employee</button>
  	<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#project" ng-click="openProjectForm()">New Project</button>
  	<br><br>
  	<div>
  	<table class="table table-hover" >
  	
		      <tr>
		        <th>Project ID</th>
		        <th>Project Name</th>
		        <th>Project Leader</th>
		        <th>Actions</th>
		      </tr>
    
    
	      <tr ng-repeat="x in projects">
	        <td>{{ x.projectID }}</td>
	        <td>{{ x.projectName }}</td>
	        <td>{{ x.projectLeader }}</td>
	        <td>
	        	<button type="button" class="btn btn-warning"  data-toggle="modal" data-target="#project" ng-click="updateProjectBtn(x.projectID)">Update</button>
				<button type="button" class="btn btn-danger" ng-click="deleteProject(x.projectID)" >Delete</button>
	        </td>
	      </tr>
	</table>
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
          	
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
         <form ng-submit="submitProject()">
			Project Name :<br>
			<input type="text" ng-model="project.projectName"/><br>
			Project Leader :<br>
			<input type="text" ng-model="project.projectLeader"/><br><br>
			<button type="submit">Submit</button>
		</form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal" ng-click="submitClick()">Close</button>
        </div>
      </div>
      
    </div>
    
  </div>
  
</div>
</body>
</html>