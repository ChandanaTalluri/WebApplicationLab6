<%-- 
    Document   : updateUser
    Created on : May 4, 2020, 9:29:08 PM
    Author     : gorilla
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
        <title>JSP Page</title>
    </head>
     <body  style=" background-image: url(images/other4.jpg)">
    <!--<body style="background-color: scrollbar">-->

    <div class="container text-center" > 
        <br><br><br><br>
        <div class="title">
            <b>Easy Banking</b>
        </div>
        <br><br>
        <div class= "row">
            <div class="col-md-3">
                <form  method="post">
                    <input type="submit" value="Back" class="margin_left" formaction="login.jsp">
                </form>
                
            </div>
            <div class="col-md-8">
                <h3> <spam>${message}</spam> </h3> <!-- message will print login exception-->
        <form action="updateUserServlet" method="post">
            <table class="reg_tb">
                <tr>
                    <td></td>
                    <td><b>Please enter the details</b></td>
                    
                </tr>
                <tr>
                    <td><b>Customer ID</b></td>
                    <td><input type="text" name="custID" required value=${customer.custID} readonly></td>
                    <td><h5>This value is fixed</h5></td>
                </tr>
                <tr>
                    <td><b>User ID</b></td>
                    <td><input type="text" name="userID" required value=${customer.userID}></td>
                </tr>
                <tr>
                    <td><b>First Name</b></td>
                    <td><input type="text" name="strFirstName" required value=${customer.strFirstName}></td>
                </tr>
                <tr>
                    <td><b>Last Name</b></td>
                    <td><input type="text" name="strLastName" required value=${customer.strLastName}></td>
                </tr>
                <tr>
                    <td><b>Contact number</b></td>
                    <td><input type="text" name="strPhoneNumber" required value=${customer.strPhoneNumber}></td>
                </tr>
                <tr>
                    <td><b>Email ID</b></td>
                    <td><input type="email" name="emialID" required value=${customer.emialID}></td>
                </tr>
                <tr>
                    <td><b>Password:</b></td>
                    <td><input type="password" name="strPassword" required value=${customer.strPassword}></td>
                </tr>
                <tr>
                    <td><b>User Role:</b></td>
                    <td><input type="text" name="strUserRole" required value=${customer.strUserRole}></td>
                </tr>
                <tr>
                <td></td>
                <td><input type="submit" value="Enter" class="margin_left"></td>
            </tr>
            </table>
       
    </form>
        </div>
            <div class="col-md-8"></div>
      </div>
    </body>
</html>
