<%-- 
    Document   : loginError
    Created on : 26 Feb, 2020, 9:36:21 PM
    Author     : Chandana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="styles/main.css" type="text/css"/>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Login Page</title>
    </head>
    <body  style=" background-image: url(images/other4.jpg)">
    <!--<body style="background-color: scrollbar">-->

    <div class="container text-center" > 
        <br><br><br><br><br>
        <div class="title">
            <b>Welcome to Easy Banking</b>
        </div>
        <br><br>
        
        <div class= "row">
            <div class="col-md-3" ></div>
            <div class="col-md-4" >
         <h3> <spam>${message}</spam> </h3> <!-- message will print login exception-->
    <form action="login" method="post">
        
        <table>
            <tr>
                <td><b>User ID:</b></td>
                <td><input type="text" name="userID" required ></td>
               
            </tr>
            <tr>
                <td><b>Password:</b></td>
                <td><input type="password" name="strPassword" required></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Enter" class="margin_left"></td>
            </tr>
        </table>
        <br>
        <br>
    </form>
          </div>
        </div>
    </div>
    </body>
</html>
