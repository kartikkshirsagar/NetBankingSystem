<%--
  Created by IntelliJ IDEA.
  User: RAJIV
  Date: 10-06-2020
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="PayPackage.Account" %>
<%@ page import="PayPackage.TestArrayInit" %>
<%@ page import="common.DButilsBank" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trying</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="css/last.css">
</head>

<body>
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    HttpSession sess = request.getSession();
    boolean auth=true;
    Account UserDetails = null;
    if (sess.getAttribute("uname") == null) {
        response.sendRedirect("index.jsp");
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
<div class="body">
    <div class="veen">
        <div class="login-btn splits">
            <p>Withdraw Money From Your Account</p>
            <button id="login">Withdraw Funds</button>
        </div>
        <div class="trans-btn splits">
            <p>Deposit Money To Your Account</p>
            <button id="trans">Deposit Funds</button>
        </div>
        <div class="rgstr-btn splits">
            <p>Send Money To Someone Else</p>
            <button id="register">Trasnfer Funds</button>
        </div>
        <div id="1" class="wrapper">
            <form id="login" class="loginform" tabindex="501" method="post" action="withdrawUser">
                <h3>Withdraw Funds</h3>
                <div class="mail">
                    <input type="number" name="amount">
                    <label>Amount to Withdraw:</label>
                </div>
                <div class="submit">
                    <button class="dark">Withdraw</button>
                </div>
            </form>
        </div>
        <div id="2" class="wrapper" style="left: 36%;display: none;">
            <form id="trans" class="transform" tabindex="500" method="post" action="depositUser">
                <h3>Deposit Funds</h3>
                <div class="mail">
                    <input type="number" name="amount">
                    <label>Amount to Deposit:</label>
                </div>
                <div class="submit">
                    <button class="dark">Deposit</button>
                </div>
            </form>
        </div>
        <div id="3" class="wrapper" style="left: 72%;display: none;">
            <form id="register" class="regform" tabindex="502" method="post" action="transferUser">
                <h3>Register</h3>
                <div class="name">
                    <input type="number" name="Account">
                    <label>Account Number of Receiver:</label>
                </div>
                <div class="mail">
                    <input type="number" name="amount">
                    <label>Amount to Transfer</label>
                </div>
                <div class="submit">
                    <button class="dark">Transfer Funds</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    $(document).ready(function() {
        $('#login').on('click', function(event) {
            $('#1').fadeIn(700);
            $('#2').fadeOut(700);
            $('#3').fadeOut(700);
        });
        $('#trans').on('click', function(event) {
            $('#1').fadeOut(700);
            $('#2').fadeIn(700);
            $('#3').fadeOut(700);
        });
        $('#register').on('click', function(event) {
            $('#1').fadeOut(700);
            $('#2').fadeOut(700);
            $('#3').fadeIn(700);
        });
    });
</script>
</body>


</html>
