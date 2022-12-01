<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous" />
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
   <style>
       .head-sty{
           color:aliceblue;
           text-align: center;
           padding-bottom: 10px;
           background-color:rgb(72, 63, 135);
           font-family:Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
           height:50px;
           width:100%;
           font-weight:bold;
           font-size:26px;
       }
      
       
       .btn-sty{
           background-color:rgb(92, 84, 144);
           color: aliceblue;
       }
       .h1-sty{
           color:rgb(72, 63, 135);
           font-size:28px;
           font-weight:bold;
            margin:25px;

       }
       .img-sty{
           height:300px;
           width:400px;
           border-radius: 400px;
       }
       .form-block-sty{
           text-align: center;
           padding-right:25px;
           padding-top:20px;
       }
       .img-block-sty{
           padding-left:60px;
           padding-top:1px;
       }
       .img-txt{
        padding-left:100px;
        padding-top:10px;
       }
       .boot-sty{
           padding:10px;
       }
       .bb{
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 10px;
            background: linear-gradient(135deg, #71b7e6, #9b59b6);
            }
       .output-txt{
        color:rgb(201, 17, 17);
           font-size:18px;
           font-weight:bold;
       }
   </style>
</head>
<body>

<div class="head-sty">
        Login
    </div>
    <div class="bb">
    <div> 
        <div class="d-flex flex-col">
            <div class="justify-content-start form-block-sty">
            <%ServletContext context=getServletContext();
            HttpSession session1=request.getSession(); 
            String output=(String)context.getAttribute("output"); %>
            <%if(output!=null){ %>
            <%=output %>
            <%context.removeAttribute("output");} %>
            
                <div>
                    <form action="http://localhost:8080/ServletProject//AuthenticationServlet" method="post" >
                        <input type="text" class="form-control" name=uname placeholder="Enter user name"/><br/>
				        <input type="password" class="form-control" name=pwd placeholder="Enter Password"/><br/>
				    
				        <button class="btn btn-sty" type="submit">Log in</button> 
				   </form>
                </div>
            </div>

            <div class="justify-content-end img-block-sty">
                <img class="img-sty" alt="img" src = "https://res.cloudinary.com/dzux2g6rf/image/upload/v1651552371/girl_fi0cfu.jpg"/> 
                <br> 
                <div class="img-txt"><h5>ABC International School </h5></div>          
            </div>
           
        </div>
    </div>
</div>
</body>
</html>