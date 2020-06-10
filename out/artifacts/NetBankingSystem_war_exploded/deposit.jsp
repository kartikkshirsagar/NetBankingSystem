<%--
  Created by IntelliJ IDEA.
  User: RAJIV
  Date: 07-06-2020
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        HttpSession sess=request.getSession();
        if(sess.getAttribute("uname")==null)
        {
            response.sendRedirect("index.html");
        }
    %>
    <h2>How much would you like to deposit</h2>
    <form method="post" action="depositUser">
        <input type="number" name="amount">
        <input type="submit" name="Submit Request">
    </form>


</body>
</html>
