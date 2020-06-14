<%--
  Created by IntelliJ IDEA.
  User: RAJIV
  Date: 14-06-2020
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>keyword</title>
</head>
<body>
    <%
        System.out.println("in keyword.jsp1");
        String key=request.getParameter("keyword");
        HttpSession sess=request.getSession();
        sess.setAttribute("key",key);
        response.sendRedirect("mallHome.jsp");
        System.out.println("in keyword.jsp");
    %>
</body>
</html>
