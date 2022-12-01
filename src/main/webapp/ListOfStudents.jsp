<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

  <head>
  <title>List of students Page</title>
     <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap');
            .content {
				  margin-left: 100px;
				  padding: 1px 16px;
				  height: 100px;
				}
            *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins',sans-serif;
            }
            .container .title{
            font-size: 25px;
            font-weight: 500;
             text-decoration: underline;
            position: relative;
            }
            .container .title::before{
            content: "";
            position: absolute;
            left: 0;
            bottom: 0;
            height: 3px;
            width: 30px;
            border-radius: 5px;
         
            }
            table, td, th {
  				border: 1px solid black;
			}

			table {
			  border-collapse: collapse;
			  width: 100%;
			}
			
			td {
			  text-align: center;
			}
            .content form .user-details{
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            margin: 20px 0 12px 0;
            }
            form .user-details .input-box{
            margin-bottom: 15px;
            width: calc(100% / 2 - 20px);
            }
            form .input-box span.details{
            display: block;
            font-weight: 500;
            margin-bottom: 5px;
            }
            .user-details .input-box input{
            height: 45px;
            width: 100%;
            outline: none;
            font-size: 16px;
            border-radius: 5px;
            padding-left: 15px;
            border: 1px solid #ccc;
            border-bottom-width: 2px;
            transition: all 0.3s ease;
            }
            .user-details .input-box input:focus,
            .user-details .input-box input:valid{
            border-color: #9b59b6;
            }
            form .gender-details .gender-title{
            font-size: 20px;
            font-weight: 500;
            }
            form .category{
            display: flex;
            width: 80%;
            margin: 14px 0 ;
            justify-content: space-between;
            }
            form .category label{
            display: flex;
            align-items: center;
            cursor: pointer;
            }
            form .category label .dot{
            height: 18px;
            width: 18px;
            border-radius: 50%;
            margin-right: 10px;
            background: #d9d9d9;
            border: 5px solid transparent;
            transition: all 0.3s ease;
            }
            #dot-1:checked ~ .category label .one,
            #dot-2:checked ~ .category label .two,
            #dot-3:checked ~ .category label .three{
            background: #9b59b6;
            border-color: #d9d9d9;
            }
            form input[type="radio"]{
            display: none;
            }
            form .button{
            height: 45px;
            margin: 35px 0
            }
            form .button input{
            height: 100%;
            width: 100%;
            border-radius: 5px;
            border: none;
            color: #fff;
            font-size: 18px;
            font-weight: 500;
            letter-spacing: 1px;
            cursor: pointer;
            transition: all 0.3s ease;
            background: linear-gradient(135deg, #71b7e6, #9b59b6);
            }
            form .button input:hover{
            /* transform: scale(0.99); */
            background: linear-gradient(-135deg, #71b7e6, #9b59b6);
            }
            @media(max-width: 584px){
            .container{
            max-width: 100%;
            }
            form .user-details .input-box{
                margin-bottom: 15px;
                width: 100%;
            }
            form .category{
                width: 100%;
            }
            .content form .user-details{
                max-height: 300px;
                overflow-y: scroll;
            }
            .user-details::-webkit-scrollbar{
                width: 5px;
            }
            }
            @media(max-width: 459px){
            .container .content .category{
                flex-direction: column;
            }
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
	<%@ include file="Header1.jsp" %>
	<div class="content">
    <div class="container">
   
       <br><div class="title">List of  students</div><br>
      <table>
      <caption></caption>
      <th></th>
        <tr>
        <td><strong>ID</strong></td>
        <td><strong>Name</strong></td>
        <td><strong>Gender</strong></td>
        <td><strong>Grade</strong></td>
        <td><strong>Father Name</strong></td>
        <td><strong>Phone Number</strong></td>
        
        </tr>
        <%@ page import="java.util.List" %>
        <% List data= (List)request.getAttribute("obj");
        for (int i=0;i<data.size();i+=6 )
        {
        %>
        <tr>
        <td s><%=data.get(i)%></td>
        <td ><%=data.get(i+1)%></td>
        <td ><%=data.get(i+2)%></td>
        <td ><%=data.get(i+3)%></td>
        <td ><%=data.get(i+4)%></td>
        <td ><%=data.get(i+5)%></td>
        </tr>
        <%}%>
      </table>
      
        
    </div>
</div>
</body>
</html>