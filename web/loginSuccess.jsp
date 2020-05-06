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
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Login</title>
    </head>
    <body style=" background-image: url(images/other4.jpg)">
        <br><br>
        
        <h1>Welcome <spam>${customer.strFirstName}</spam><spam>${customer.strLastName}</spam> </h1>
        <br>
        <hr>
        <h1>${message}</h1>
        <h2> <spam>${assetTitle}</spam></h2>
       
        <div class= "row">
            <div class="col-md-3"></div>
            <div class="col-md-5">
        
            <c:forEach var="asset" items="${asset}">
                <form action="transaction" method="post"></form>
                    <table>
                        <tr>
                            <td> Account Number </td>
                            <td> ${asset.strAccountNumber} </td>
                            <td> 
                                <form action="transaction" method="post">
                                        <input type="submit" value="View Transactions">
                                         <input type="hidden" name="accountNumber" value="<c:out value='${asset.strAccountNumber}'/>">
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td>Balance</td>
                            <td class="dollar">${asset.balanceAmount}</td>
                        </tr>
                        <tr>
                            <td>Account Name</td>
                            <td>${asset.strAccountName}</td>
                        </tr>
                        <tr>
                            <td> Account opening Date</td>
                            <td>${asset.strFormattedOpeningDate}</td>
                        </tr>
                    </table>
            </c:forEach>
            </div></div>
        <h2> <spam>${LiabilityTitle}</spam></h2>
        <div class= "row">
            <div class="col-md-3"></div>
                
            <div class="col-md-5">
        
            <c:forEach var="liability" items="${liability}">
                <form action="transaction" method="post">
                    <table class="reg_tb">
                        <tr>
                            <td> Account Number </td>
                            <td> ${liability.strAccountNumber} </td>
                            <td> 
                                <form action="transaction" method="post">
                                        <input type="submit" value="View Transactions">
                                         <input type="hidden" name="accountNumber" value="<c:out value='${liability.strAccountNumber}'/>">
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <td>Balance</td>
                            <td class="dollar">${liability.balanceAmount}</td>
                        </tr>
                        <tr>
                            <td>Account Name</td>
                            <td>${liability.strAccountName}</td>
                        </tr>
                        <tr>
                            <td> Account opening Date</td>
                            <td>${liability.strFormattedOpeningDate}</td>
                        </tr>
                    </table>
                        </form>
            </c:forEach>
            </div></div>
        <br>
        <br>
        
        <form action="index.html" method="get">
        <input type="hidden" name="action" value="join">
        <input type="submit" value="Return">
    </form>
    </body>
</html>
