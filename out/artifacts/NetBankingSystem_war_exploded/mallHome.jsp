<%@ page import="java.util.ArrayList" %>
<%@ page import="MallPack.Product" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: karti
  Date: 12/06/2020
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mall</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            let myobj,txt="";
            $.ajax({
                url : "mall",
                success: function (response) {
                    myobj = JSON.parse(response);
                    txt += "<table border='1'>"
                    for (x in myobj) {
                        txt += "<tr><td>" + myobj[x].name + "</td></tr>";
                    }
                    txt += "</table>"
                    document.getElementById("demo").innerHTML = txt;
                }
            });
        });
    </script>
</head>
<body>
<p id="demo"></p>

<div class="container" id="container">
    <h2 id="heading"></h2>
    <h3 id="Quantity">Quantity : </h3>
    <h4 id="description"></h4>
    <h2 id="price">Price : </h2>
</div>
</body>
</html>
