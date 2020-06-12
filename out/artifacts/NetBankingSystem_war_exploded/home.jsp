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
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>HomePage</title>
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.min.css"
            integrity="sha256-L/W5Wfqfa0sdBNIKN9cG6QA5F2qx4qICmU2VgLruv9Y="
            crossorigin="anonymous"
    />

    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/material-design-icons/3.0.1/iconfont/material-icons.min.css"
            integrity="sha256-x8PYmLKD83R9T/sYmJn1j3is/chhJdySyhet/JuHnfY="
            crossorigin="anonymous"
    />
    <script src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <link rel="stylesheet" href="css/style.css" />
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
            } catch (SQLException throwables)  {
                throwables.printStackTrace();
            }
            catch (ClassNotFoundException throwables){
                throwables.printStackTrace();
            }
        }
    }

%>
<nav
        class="navbar navbar-expand-lg navbar-dark bg-mattBlackLight fixed-top"
>
    <button class="navbar-toggler sideMenuToggler" type="button">
        <span class="navbar-toggler-icon"></span>
    </button>

    <a class="navbar-brand" href="#">Welcome <%
        if(auth) {
            out.println(UserDetails.getAccount_Holder());
        }%></a>
    <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
    >
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <a
                        class="nav-link dropdown-toggle p-0"
                        href="#"
                        id="navbarDropdown"
                        role="button"
                        data-toggle="dropdown"
                        aria-haspopup="true"
                        aria-expanded="false"
                >
                    <i class="material-icons icon">
                        person
                    </i>
                    <span class="text">Account</span>
                </a>
                <div
                        class="dropdown-menu dropdown-menu-right"
                        aria-labelledby="navbarDropdown"
                >
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
<div class="wrapper d-flex">
    <div class="sideMenu bg-mattBlackLight">
        <div class="sidebar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a href="#" class="nav-link px-2">
                        <i class="material-icons icon">
                            dashboard
                        </i>
                        <span class="text">Dashboard</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="profile.jsp" class="nav-link px-2">
                        <i class="material-icons icon">
                            person
                        </i>
                        <span class="text">User Profile</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link px-2">
                        <i class="material-icons icon"> border_all </i
                        ><span class="text">Mall</span></a
                    >
                </li>

                <li class="nav-item">
                    <a href="#" class="nav-link px-2">
                        <i class="material-icons icon"> cloud </i
                        ><span class="text">About Us</span></a
                    >
                </li>

                <li class="nav-item">
                    <a href="#" class="nav-link px-2 sideMenuToggler">
                        <i class="material-icons icon expandView ">
                            keyboard_arrow_left
                        </i>
                        <span class="text">Landing</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="content">
        <main>
            <!--<p>nitin ka recent video wala part</p>-->
            <div class="body" id="body_tag">
                <div class="veen">
                    <div class="login-btn splits">
                        <p>Withdraw Money From Your Account</p>
                        <button id="login1">Withdraw Funds</button>
                    </div>
                    <div class="trans-btn splits">
                        <p>Deposit Money To Your Account</p>
                        <button id="trans1">Deposit Funds</button>
                    </div>
                    <div class="rgstr-btn splits">
                        <p>Send Money To Someone Else</p>
                        <button id="register1">Trasnfer Funds</button>
                    </div>
                    <div id="1" class="wrapper1">
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
                    <div id="2" class="wrapper1" style="left: 36%;display: none;">
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
                    <div id="3" class="wrapper1" style="left: 72%;display: none;">
                        <form id="register" class="regform" tabindex="502" method="post" action="transferUser">
                            <h3>Transfer Funds</h3>
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
                    $('#login1').on('click', function(event) {
                        $('#1').fadeIn(700);
                        $('#2').fadeOut(700);
                        $('#3').fadeOut(700);
                        $('#body_tag').css({"background" : "#d63031"});
                    });
                    $('#trans1').on('click', function(event) {
                        $('#1').fadeOut(700);
                        $('#2').fadeIn(700);
                        $('#3').fadeOut(700);
                        $('#body_tag').css({"background" : "#00b894"});
                    });
                    $('#register1').on('click', function(event) {
                        $('#1').fadeOut(700);
                        $('#2').fadeOut(700);
                        $('#3').fadeIn(700);
                        $('#body_tag').css({"background" : "#01a3a4"});
                    });
                });
            </script>
        </main>
    </div>
</div>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"
></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.bundle.min.js"
        integrity="sha256-OUFW7hFO0/r5aEGTQOz9F/aXQOt+TwqI1Z4fbVvww04="
        crossorigin="anonymous"
></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/jQuery-slimScroll/1.3.8/jquery.slimscroll.min.js"
        integrity="sha256-qE/6vdSYzQu9lgosKxhFplETvWvqAAlmAuR+yPh/0SI="
        crossorigin="anonymous"
></script>
<script src="./js/script.js"></script>
</body>
</html>
