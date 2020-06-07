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
    %>
    <h1>Welcome,<% out.println(UserDetails.getAccount_Holder()); %></h1>
    <p>Your Account Number is:<% out.println(UserDetails.getAccount_Number()); %>
        <br>Your Balance:<% out.println(UserDetails.getBalance()); %>
    </p>
    <!-- Above part can be made as a dashboard-->
    <form method="post" action="payoptions">
        <input type="submit" name="submit" value="Deposit">
        <input type="submit" name="submit" value="Withdraw">
        <input type="submit" name="submit" value="TransferFunds">
    </form>
    <!--<form method="post" action="">

    </form>
    <form method="post" action="">

    </form>
    -->


</body>
</html>
