<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #ff9933;
}

.topnav a {
  float: left;
  color: #000000;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #cc3399;
  color: white;
}
.footer {
   position:relative;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: #ff9933;
   color: white;
   text-align: center;
}
.footer {
   position:relative;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: #ff9933;
   color: white;
   text-align: center;
}
</style>
<body>

<div class="topnav">
  <a  href="home.jsp">Home</a>
  <a  href="<%=request.getContextPath()%>/list">List</a>
  <a class="active" href="<%=request.getContextPath()%>/new">Add new User</a>
  <a href="#about">About</a>
  <h4 style="text-align:right">Spare Parts Management System</h4><br>
</div>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${user != null}">
            			Edit User
            		</c:if>
						<c:if test="${user == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${user != null}">
					<input type="hidden" name="id" value="<c:out value='${user.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>User Name</label> <input type="text"
						value="<c:out value='${user.name}'/>" class="form-control" name="name" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>User Contact No</label> <input type="text" value="<c:out value='${user.contact}'/>" class="form-control" name="contact" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>User Email</label> <input type="email" value="<c:out value='${user.email}'/>" class="form-control" name="email" required="required">
				</fieldset>
				
				<fieldset class="form-group">
					<label>User Address</label> <input type="text" value="<c:out value='${user.address}'/>" class="form-control" name="address" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Possition</label> <input type="text" value="<c:out value='${user.possition}'/>" class="form-control" name="possition" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
	<br><div class="footer">
  <p>OOP Spare part Management</p>
</div>
</body>
</html>