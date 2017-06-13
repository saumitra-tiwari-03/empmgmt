<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Employee</title>
</head>
<body>
	<h1><u>Employee Management System</u></h1>
	
	<h2><u>New Employee</u></h2>
	
	<form method="POST" action="/EmpMgmt/saveEmp">
		Employee ID <input type="text" name="empId" /><br>
		Employee Name <input type="text" name="empName"/><br>
		Project Code <input type="text" name="projectID"/><br>
		<input type="submit" value="Submit"/>
	</form>
	
</body>
</html>