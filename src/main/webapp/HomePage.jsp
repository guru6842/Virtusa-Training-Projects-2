<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    <style>
        .nav-sty{
            background-color:rgb(72, 63, 135);
        }
        .btn-sty{
            border-radius: 5px;
            border-width: 1px;
            padding:9px;
            background-color:#7f7fac;
        }    
        .head-sty{
           color:aliceblue;
           text-align: center;
           padding-bottom: 8px;

           height:50px;
           width:100%;
           font-weight:bold;
           font-size:26px;
       }
       body {
  margin: 0;
  font-family: "Lato", sans-serif;
}

.sidebar {
  margin: 0;
  padding: 0;
  width: 200px;
  background-color: #f1f1f1;
  position: fixed;
  height: 100%;
  overflow: auto;
}

.sidebar a {
  display: block;
  color: black;
  padding: 16px;
  text-decoration: none;
}
 
.sidebar a.active {
  background-color: #295da1;
  color: white;
}

.sidebar a:hover:not(.active) {
  background-color: #555;
  color: white;
}

div.content {
  margin-left: 200px;
  padding: 1px 16px;
  height: 1000px;
}

@media screen and (max-width: 700px) {
  .sidebar {
    width: 100%;
    height: auto;
    position: relative;
  }
  .sidebar a {float: left;}
  div.content {margin-left: 0;}
}

@media screen and (max-width: 400px) {
  .sidebar a {
    text-align: center;
    float: none;
  }
  
    </style>
</head>
<body>
    <% 
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		String role=(String)session.getAttribute("role");
		if(role==null || !role.equals("admin")){
			response.sendRedirect("Login.jsp");
		}
	%>
 <nav class="navbar navbar-expand-lg navbar-light nav-sty">
  <div class="head-sty">
        ABC International School
    </div>
    <div>
        <button id="logout" class="btn-sty"><a href="Logout">logout</a></button>
    </div>
    </nav>
    
<div class="sidebar">
    <a class="active" >Teacher</a>
    <a href="AddTeacher.jsp"> Add Teacher</a>
    <a href="DeleteTeacher.jsp">Delete Teacher</a>
    <a href="SearchTeacher.jsp">Edit teacher</a>
    <a href="http://localhost:8080/ServletProject//ListOfTeachers">Teachers List</a>
    <a class="active" >Students</a>
    <a href="AddStudent.jsp"> Add Student</a>
    <a href="DeleteStudent.jsp">Delete Student</a>
    <a href="SearchStudent.jsp">Edit Student</a>
    <a href="http://localhost:8080/ServletProject//ListOfStudents">Students List</a>
  </div>
  
  <div class="content">
    
  </div>
</body>
</html>