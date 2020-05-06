<!DOCTYPE html>
<!--
Created by Chandana.
Template to add/update UserRole table
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
    <br><br>
            <form  method="post">
                    <input type="submit" value="Back" class="margin_left" formaction="adminBank.jsp">
            </form>
    <div class="container text-center" > 
        <br><br><br><br>
        <div class="title">
            <b>Easy Banking</b>
        </div>
        <br><br>
        <div class= "row">
            <div class="col-md-3"> </div>
            <div class="col-md-8">
                <h3> <spam>${message}</spam> </h3> <!-- message will print login exception-->
        <form action="UserRole" method="post">
            <table class="reg_tb">
                <tr>
                    <td></td>
                    <td><b>Please enter the details</b></td>
                    
                </tr>
                <tr>
                    <td><b>User Role</b></td>
                    <td><input type="text" name="userRole" required></td>
                    <td><h4>Only 5 charecters allowed </h4> </td>
                </tr>
                <tr>
                    <td><b>Access Account</b></td>
                    <td><input type="text" name="accAccess" required></td>
                     <td><h4>Please enter Y or N</h4> </td>
                </tr>
                <tr>
                    <td><b>Access User</b></td>
                    <td><input type="text" name="userAccess" required></td>
                     <td><h4>Please enter Y or N</h4> </td>
                </tr>
                <tr>
                    <td><b>Access User Role</b></td>
                    <td><input type="text" name="access_userRole" required></td>
                     <td><h4>Please enter Y or N</h4> </td>
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
