<%@ page import="java.nio.channels.AcceptPendingException" %>
<%@ page import="PayPackage.Account" %>
<%@ page import="PayPackage.TestArrayInit" %>
<%@ page import="common.DButilsBank" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: RAJIV
  Date: 07-06-2020
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transfer Page</title>
</head>
<body>
    <%
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

        HttpSession sess=request.getSession();
        if(sess.getAttribute("uname")==null)
        {
            response.sendRedirect("index.html");
        }
        Account User=null;
        String Username = sess.getAttribute("uname").toString();
        if (!Username.equals("")) {
            //User = TestArrayInit.getDetails(Username);
            try {
                User= DButilsBank.getAccObj(Username);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    %>
    <h1>Your Account No.:<% User.getAccount_Number(); %></h1>
    <p>Enter the details of the person to who you want to transfer funds:</p>
    <form method="post" action="transferUser">
        <label for="Account">Account Number of Receiver:</label>
        <input type="number" name="Account" id="Account"><br>
        <label for="amount">Amount to Transfer:</label>
        <input type="number" name="amount" id="amount"><br><br>
        <input type="submit" name="Submit request">
    </form>
</body>
</html>
