<%--
  Created by IntelliJ IDEA.
  User: nitin
  Date: 6/7/2020
  Time: 12:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Registration</title>
        <!-- Compiled and minified CSS -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

    </head>
    <body>
        <div class="row">
            <form id="RegForm" action="register" method="post" class="col s12">
                <div class="row">
                    <div class="input-field col s6">
                        <input id="name" type="text" name="name" class="validate">
                        <label for="Name">Name</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <input id="Username" type="text" class="validate" name="username">
                        <label for="Username">UserName</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <input id="password" type="password" name="pass" class="validate">
                        <label for="password">Password</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <input id="email" type="email" name="email" class="validate">
                        <label for="email">Email</label>
                    </div>
                </div>
                <div class="row">
                    <div class="col s6">
                        <button type="submit" class="button">Submit</button>
                    </div>
                </div>
            </form>
        </div>
        <div class="loader">
            <div class="preloader-wrapper big active">
                <div class="spinner-layer spinner-blue">
                    <div class="circle-clipper left">
                        <div class="circle"></div>
                    </div>
                    <div class="gap-patch">
                        <div class="circle"></div>
                    </div>
                    <div class="circle-clipper right">
                        <div class="circle"></div>
                    </div>
                </div>
                <div class="spinner-layer spinner-red">
                    <div class="circle-clipper left">
                        <div class="circle"></div>
                    </div>
                    <div class="gap-patch">
                        <div class="circle"></div>
                    </div>
                    <div class="circle-clipper right">
                        <div class="circle"></div>
                    </div>
                </div>
                <div class="spinner-layer spinner-yellow">
                    <div class="circle-clipper left">
                        <div class="circle"></div>
                    </div>
                    <div class="gap-patch">
                        <div class="circle"></div>
                    </div>
                    <div class="circle-clipper right">
                        <div class="circle"></div>
                    </div>
                </div>
                <div class="spinner-layer spinner-green">
                    <div class="circle-clipper left">
                        <div class="circle"></div>
                    </div>
                    <div class="gap-patch">
                        <div class="circle"></div>
                    </div>
                    <div class="circle-clipper right">
                        <div class="circle"></div>
                    </div>
                </div>
            </div>
            <h5>Loading...</h5>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
        <script>
            $(document).ready(function () {
                console.log("Page is ready..");
                $("#RegForm").on('submit',function (event) {
                    event.preventDefault();
                    let f = $(this).serialize();

                    console.log(f);
                    $.ajax({
                        url : "register",
                        data : f,
                        type : 'POST',
                        success : function (data) {
                            console.log(data);
                            console.log("Success");
                        },
                        error : function (data) {
                            console.log(data);
                            console.log("Failed");
                        }
                    })
                });
            });
        </script>
    </body>
</html>
