<%@ page import="PayPackage.Account" %>
<%@ page import="PayPackage.TestArrayInit" %>
<%@ page import="common.DButilsBank" %>
<%@ page import="java.sql.SQLException" %><%--
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
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    HttpSession sess = request.getSession();
    boolean auth=true;
    Account UserDetails = null;
    if (sess.getAttribute("uname") == null) {
        response.sendRedirect("index.html");
        auth=false;
    } else {
        String Username = sess.getAttribute("uname").toString();
        UserDetails = null;
        if (!Username.equals("")) {
            //UserDetails = TestArrayInit.getDetails(Username);
            try {
                UserDetails = DButilsBank.getAccObj(Username);
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
    }

%>
    <h1>Welcome,<%
        if(auth) {
            out.println(UserDetails.getAccount_Holder());
        }%></h1>
    <p>Your Account Number is:<% if(auth) {out.println(UserDetails.getAccount_Number());} %>
        <br>Your Balance:<%if(auth){ out.println(UserDetails.getBalance());} %>
    </p>
    <jsp:include page="logoutbutton.html" />
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
