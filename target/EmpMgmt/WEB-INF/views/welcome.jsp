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
<body ng-app="EmpMgmt" ng-controller="empCtrl">
	<h1><u>Employee Management System</u></h1>
	<div>
		<h2><u>New Employee</u></h2>
		<form ng-submit="submitEmp()">
			Employee Code: <br>
			<input type="text" ng-model="emp.empId"/><br>
			Employee Name:<br>
			<input type="text" ng-model="emp.empName"/><br><br>
			<button type="submit">Submit</button>
		</form>
		<span ng-bind="msg"></span>
	</div>
</body>
</html>