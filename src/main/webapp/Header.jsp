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
        <button id="logout" class="btn-sty">
            Logout
        </button>
    </div>
    </nav>
</body>
</html>