<%--
  Created by IntelliJ IDEA.
  User: RAJIV
  Date: 07-06-2020
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
    <% HttpSession sess=request.getSession();
        sess.removeAttribute("uname");
        sess.invalidate();
        %>
    <p>Thank you for using our services!</p>
</body>
</html>
