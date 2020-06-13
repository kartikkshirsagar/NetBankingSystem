<%@ page import="java.sql.SQLException" %>
<%@ page import="common.DButilsBank" %>
<%@ page import="PayPackage.Account" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

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
<div class="jumbotron text-center">
    <h1 class="display-3">Thank You!</h1>
    <p class="lead"><strong>Your order is received </strong>and your current balance is <%out.println(UserDetails.getBalance());%> </p>
    <hr>
    <p>
        Having trouble? <a href="">Contact us</a>
    </p>
    <p class="lead">
        <a class="btn btn-primary btn-sm" href="home.jsp" role="button">Continue to homepage</a>
    </p>
</div>
</body>
</html>