<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- Created By CodingLab - www.codinglabweb.com -->
<html lang="en">

<head>
  <title>Add teacher Page</title>  
</head>
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
           
            .container{
            
            background-color: #fff;
            padding-right:10px;
           	padding-top:70px;
            border-radius: 5px;
           
            }
            .container .title{
            font-size: 35px;
            font-weight: 500;
            text-decoration: underline;
           
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
            width: 70%;
            border-radius: 5px;
            border: none;
            color: #fff;
            align-self:center;
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
      
      <center><div class="title">Student Registration </div></center>
      <form action="http://localhost:8080/ServletProject/AddStudent" method="post">
          <div class="content">
              <div class="user-details">
                <div class="input-box">
                  <span class="details">Full Name</span>
                  <input type="text" name=sname placeholder="Enter Student name" required>
                </div>
                <div class="input-box">
                  <span class="details">Grade</span>
                  <input type="text" name=grade placeholder="Enter student grade" required>
                </div>
                <div class="input-box">
                  <span class="details">Father Name</span>
                  <input type="text" name=fatherName placeholder="Enter father name" required>
                </div>
                <div class="input-box">
                  <span class="details">Parent Phone Number</span>
                  <input type="text" name=PhoneNo placeholder="Enter phone number" required>
                </div>
              </div>
              <div class="gender-details">
                <input type="radio" name="gender" id="dot-1" value=male>
                <input type="radio" name="gender" id="dot-2" value=Female>
                <input type="radio" name="gender" id="dot-3" value=NotPrefered>
                <span class="gender-title">Gender</span>
                <div class="category" >
                  <label for="dot-1">
                  <span class="dot one" name=gender ></span>
                  <span class="gender" >Male</span>
                </label>
                <label for="dot-2">
                  <span class="dot two" name=gender ></span>
                  <span class="gender" >Female</span>
                </label>
                <label for="dot-3">
                  <span class="dot three" name=gender ></span>
                  <span class="gender" >Prefer not to say</span>
                  </label>
                </div>
              </div>
              <div class="button">
                <input type="submit" value="Register">
              </div>
          
          </div>
        </form>
    </div>
 </div>
</body>
</html>
