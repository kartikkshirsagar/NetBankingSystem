<%@ page import="PayPackage.Account" %><%--
  Created by IntelliJ IDEA.
  User: RAJIV
  Date: 07-06-2020
  Time: 08:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
</head>
<body>
    <%
        Account UserDetails= (Account) session.getAttribute("User");
    %>>
    <h1>Welcome,<% UserDetails.getAccount_Holder(); %></h1>
    <p>Your Account Number is:<% UserDetails.getAccount_Number(); %>
        <br>Your Balance:<% UserDetails.getBalance(); %>
    </p>


</body>
</html>
