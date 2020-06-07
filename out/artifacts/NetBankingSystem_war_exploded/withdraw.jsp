<%@ page import="PayPackage.Account" %>
<%@ page import="PayPackage.TestArrayInit" %><%--
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
<%
    HttpSession sess = request.getSession();
    String Username = sess.getAttribute("uname").toString();
    Account UserDetails = null;
    if (!Username.equals("")) {
        UserDetails = TestArrayInit.getDetails(Username);
    }
%>

    <h2>How much do you want to withdraw?</h2>
    <h3>Current Balance:<% UserDetails.getBalance(); %></h3>
    <form method="post" action="withdrawUser">
        <input type="number" name="amount">
    </form>
</body>
</html>
