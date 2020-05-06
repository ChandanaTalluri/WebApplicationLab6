<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Transactions</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="styles/main.css" type="text/css"/>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    </head>
    <style>
        table {
            border-collapse: collapse;
        }
        th{
            background-color: aquamarine;
        }
        table, td, th {
            border: 1px solid black;
        }
        tr{
             background-color: antiquewhite;
        }
    </style>
    <body  style=" background-image: url(images/other4.jpg)">
         <br>
        <h1>Welcome <spam>${customer.strFirstName}</spam><spam>${customer.strLastName}</spam> </h1>
        <br>
        <div class= "row">
            <div class="col-md-2"> 
                <form action="loginSuccess.jsp" method="get">
                        <input type="hidden" name="action" value="join">
                        <input type="submit" value="Back">
                </form>
            </div>
            <div class="col-md-7"></div>
            <div class="col-md-3"> 
                <form action="index.html" method="post">
                        <input type="hidden" name="action" value="join">
                        <input type="submit" value="Logout">
                </form>
            </div>
        </div>
        <div class= "row">
            <div class="col-md-7"> 
               <h2> <b><spam>Transactions for account number </spam><spam>${accNumber}</spam></b></h2>
            </div>
           
            <div class="col-md-3"> 
                <h3><b>Balance  :</b><spam class="dollar">${balanceAmount}</spam></h3>
                
            </div>
        </div>
                <br>
                <br>
        <div class= "row">
            <div class="col-md-2"></div>
            <div class="col-md-12">
                <table>
                    <tr>
                     <th>Transaction ID</th>
                     <th>Transaction Date</th>
                     <th> Transaction Amount</th>
                     <th> Description </th>
                     <th>Account Balance</th>
                     </tr>
                <c:forEach var="transactions" items="${transactions}">
                    
                    <tr>
                    <td>${transactions.transactionID}</td>
                    
                    <td>${transactions.strFormatedDate}</td>
                    
                    <td class="dollar">${transactions.trasactionAmount}</td>
                    
                    <td>${transactions.strDescription}</td>
                    
                    <td class="dollar">${transactions.balanceAmount}</td>
                    </tr>
                </c:forEach>
            </table>
    </body>
</html>
