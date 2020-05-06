<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Registration</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="styles/main.css" type="text/css"/>
  
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
            <div class="col-md-5">
                <h3> <spam>${message}</spam> </h3> <!-- message will print login exception-->
        <form action="registration" method="post">
            <table class="reg_tb">
                <tr>
                    <td></td>
                    <td><b>Please enter the details</b></td>
                    
                </tr>
                <tr>
                    <td><b>User ID</b></td>
                    <td><input type="text" name="userID" required></td>
                </tr>
                <tr>
                    <td><b>First Name</b></td>
                    <td><input type="text" name="strFirstName" required></td>
                </tr>
                <tr>
                    <td><b>Last Name</b></td>
                    <td><input type="text" name="strLastName" required></td>
                </tr>
                <tr>
                    <td><b>Contact number</b></td>
                    <td><input type="text" name="strPhoneNumber" required></td>
                </tr>
                <tr>
                    <td><b>Email ID</b></td>
                    <td><input type="email" name="emialID" required></td>
                </tr>
                <tr>
                    <td><b>Password:</b></td>
                    <td><input type="password" name="strPassword" required></td>
                </tr>
                <tr>
                    <td><b>User Role:</b></td>
                    <td><input type="text" name="strUserRole" required></td>
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
        
    </div>
    </body>
</html>
