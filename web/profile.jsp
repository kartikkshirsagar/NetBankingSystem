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



<body>
<style>
    .card {
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        max-width: 300px;
        margin: auto;
        text-align: center;
        background-color: #676767;
    }

    .title {
        color: dodgerblue;
        font-size: 18px;
    }
    img{
        border-radius: 10%;
        display: block;
        box-shadow: black;

    }
    p{
        font-size: 18px;
    }
</style>
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
<%@ include file="basic.jsp"%>

<div class="card col-3" style="margin-top: 50px;margin-left: 40%;background-color: #676767">
    <img src="image/person.jpg" alt="John" style="width:100% ;height:350px">
    <h1 style="color: black"><%if(auth){ out.println(UserDetails.getAccount_Holder());}%></h1>
    <p class="title">Your username is <%out.println(sess.getAttribute("uname").toString());%></p>
    <p style="color: dodgerblue">Your Account Number is: <% if(auth) {out.println(UserDetails.getAccount_Number());} %>
        <br>Your Balance: <%if(auth){ out.println(UserDetails.getBalance());} %>
    </p>
</div>



            <!-- Above part can be made as a dashboard-->
            <!--
            <form method="post" action="payoptions">
                <input type="submit" name="submit" value="Deposit">
                <input type="submit" name="submit" value="Withdraw">
                <input type="submit" name="submit" value="TransferFunds">
            </form>
          -->
            <!--<form method="post" action="">

            </form>
            <form method="post" action="">

            </form>
            -->
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
