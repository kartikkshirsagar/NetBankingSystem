<%@ page import="PayPackage.Account" %><%--
  Created by IntelliJ IDEA.
  User: RAJIV
  Date: 07-06-2020
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Withdraw</title>
</head>
<body>
    <% HttpSession sess=request.getSession(); %>
    <h2>How much do you want to withdraw?</h2>
    <h3>Current Balance:<% Account User=(Account) sess.getAttribute("User");
                          out.println(User.getBalance()) ; %></h3>
    <form method="post" action="withdrawUser">
        <input type="number" name="amount">
    </form>
</body>
</html>
