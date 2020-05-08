<%-- 
    Document   : adminBank
    Created on : May 4, 2020, 9:20:34 PM
    Author     : Chandana
    UI for Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Bank Admin</title>
    </head>
    <body style=" background-image: url(images/other4.jpg)">
        <h1>Welcome Admin</h1>
        <div class= "row">
            <div class="col-md-8"></div>
            <div class="col-md-3">
                 
                <form action="index.html" method="post">
                        <input type="hidden" name="action" value="join">
                        <input type="submit" value="Logout">
                </form>
          
            </div>
          </div>     
        <br>
        <br>
        <h2> To view account details</h2>
        <form action="account" method="post">  
            <table>
                <tr>
                    <td>Enter User ID:</td>
                    <td><input type="text" name="userID" required></td>
                    <td><input type="submit" name ="register" value="Enter" ></td>
                    
                </tr>
            </table>
        </form> 
         <br>
        <br>
        <h2>Click below to add New user</h2>
         <form action="registration" method="post">  
            <table>
                <tr>
                   
                    <td><input type="submit" name ="Mgt" value="Add USER" formaction="register.jsp"></td>
                   
                </tr>
            </table>
        </form>
         <br>
        <br>
        <h2>Update User Details</h2>
        <form action="fetchUser" method="post">  
            <table>
                <tr>
                    <td>Enter User ID:</td>
                    <td><input type="text" name="userID" required></td>
                    <td><input type="submit" name ="register" value="Enter" ></td>
                   
                </tr>
            </table>
        </form> 
         <br>
        <br>
        <h2> User Role</h2>
        <form action="UserRole" method="post">  
            <table>
                <tr>
                    <td><input type="submit" name ="register" value="Update Role" formaction="updateUserRole.jsp"></td>
                    <td><input type="submit" name ="register" value="Add User Role" formaction="addUserRole.jsp"></td>
                </tr>
            </table>
        </form> 
       
   </body>
</html>
