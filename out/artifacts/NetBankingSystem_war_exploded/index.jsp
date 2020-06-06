<%--
  Created by IntelliJ IDEA.
  User: kartik
  Date: 02/06/2020
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    if(session.getAttribute("uname")==null)
    {
      response.sendRedirect("AuthFail.html");
    }
  %>
  <h1>Welcome${uname}</h1>
  </body>
</html>
