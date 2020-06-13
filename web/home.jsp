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

<%@include file = "basic.jsp"%>
<%@include file="Payform.jsp"%>
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
