<%-- 
    Document   : login
    Created on : Feb 20, 2020, 11:09:17 AM
    Author     : 0809379
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <link rel="stylesheet" href="styles/main.css" type="text/css"/>    

    </head>
    <body style=" background-image: url(images/other4.jpg)">
    <h1> Welcome<span>${customer.strFirstName}</span> </h1>
    <h1>${message}</h1>

    <p>Here is the information that you entered:</p>
<div class= "row">
    <div class="col-md-5">
        <table>
            <tr>
                <td>User ID: </td>
                <td>${customer.userID}</td>
            </tr>
            <tr>
                <td>First Name: </td>
                <td>${customer.strFirstName}</td>
            </tr>
            <tr>
                <td>Last Name: </td>
                <td>${customer.strLastName}</td>
            </tr>
            <tr>
                <td>Email ID: </td>
                <td>${customer.emialID}</td>
            </tr>
            <tr>
                <td>Contact Number: </td>
                <td>${customer.strPhoneNumber}</td>
            </tr>
            <tr>
                <td>User Role: </td>
                <td>${customer.strUserRole}</td>
            </tr>
            <tr>
                <td></td>
                <td></td>
            </tr>
        </table>
        
    </div>
            <div class="col-md-5"></div>
</div>

    
    <form action="index.html" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>
    </body>
</html>
