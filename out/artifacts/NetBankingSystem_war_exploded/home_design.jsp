<%@ page import="common.DButilsBank" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="PayPackage.Account" %><%--
  Created by IntelliJ IDEA.
  User: RAJIV
  Date: 10-06-2020
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.0-2/css/all.min.css">
    <link rel="stylesheet" href="css/home_style.css">
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
    HttpSession sess = request.getSession();
    Account UserDetails = null;
    if (sess.getAttribute("uname") == null) {
        response.sendRedirect("index.html");
    } else {
        String Username = sess.getAttribute("uname").toString();
        UserDetails = null;
        if (!Username.equals("")) {
            //UserDetails = TestArrayInit.getDetails(Username);
            try {
                UserDetails = DButilsBank.getAccObj(Username);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

%>

<!--Sidebar Dashboard-->
    <input type="checkbox" id="sidebars">
    <header>
        <label for="sidebars">
            <i class="fas fa-bars" id="sidebar_btn"></i>
        </label>
        <div class="left_area">
            <h3>Bank Name/Logo</h3>
            <a href="logout.jsp" class="logout_btn">Logout</a>
        </div>
    </header>

    <div class="sidebar">
        <img src="image/user.jpg" alt="User Icon" class="profile_image">
        <h4><% out.println(UserDetails.getAccount_Holder()); %></h4>
        <a href="#"><i class="fas fa-desktop"></i><span>DashBoard </span></a>
        <a href="#"><i class="fas fa-cogs"></i><span> Deposit</span></a>
        <a href="#"><i class="fas fa-table"></i><span> Withdraw</span></a>
        <a href="#"><i class="fas fa-th"></i><span> Transfer Funds</span></a>
        <a href="#"><i class="fas fa-info-circle"></i><span> About Us</span></a>

    </div>
    <div class="content">
        <h2>Your Account Number is:<% out.println(UserDetails.getAccount_Number()); %></h2>
        <h3>Your Balance is:<% out.println(UserDetails.getBalance()); %></h3>
    </div>

</body>
</html>
