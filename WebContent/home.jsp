<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@page import="com.usermgt.dao.*"%>
<html>
<title>Spare parts home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
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
   position: fixed;
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
  <a class="active" href="#home">Home</a>
  <a href="<%=request.getContextPath()%>/list">List</a>
  <a href="<%=request.getContextPath()%>/new">Add new User</a>
  <a href="#about">About</a>
  <h4 style="text-align:right">Spare Parts Management System</h4><br>
</div>

<div class="w3-container">

<h2 style="text-align:center">Welcome Admin!</h2><br>

<br><a href="<%=request.getContextPath()%>/list" class="w3-btn w3-block w3-teal" style="text-align:center"><h2>User Management</h2></a></p>
<br><a href="" class="w3-btn w3-block w3-teal" style="text-align:center"><h2>Supplier Management</h2></a></p>
<br><a href="" class="w3-btn w3-block w3-teal" style="text-align:center"><h2>Spare Part Management</h2></a></p>
</div>
<div class="footer">
  <p>OOP Spare part Management</p>
</div>

</body>
</html> 