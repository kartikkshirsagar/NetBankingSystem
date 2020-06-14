<%--
  Created by IntelliJ IDEA.
  User: karti
  Date: 13/06/2020
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<main>
    <div class="body" id="body_tag" style="margin-left: 70px "  >
    <div class="veen">
        <div class="login-btn splits">
            <p>Withdraw Money From Your Account</p>
            <button id="login1">Withdraw Funds</button>
        </div>
        <div class="trans-btn splits">
            <p>Deposit Money To Your Account</p>
            <button id="trans1">Deposit Funds</button>
        </div>
        <div class="rgstr-btn splits">
            <p>Send Money To Someone Else</p>
            <button id="register1">Trasnfer Funds</button>
        </div>
        <div id="1" class="wrapper1">
            <form id="login" class="loginform" tabindex="501" method="post" action="withdrawUser">
                <h3>Withdraw Funds</h3>
                <div class="mail">
                    <input type="number" id="withdraw_id" name="amount">
                    <label>Amount to Withdraw:</label>
                </div>
                <h3 id="err"></h3>
                <div class="submit">
                    <button class="dark">Withdraw</button>
                </div>
            </form>
        </div>
        <div id="2" class="wrapper1" style="left: 36%;display: none;">
            <form id="trans" class="transform" tabindex="500" method="post" action="depositUser">
                <h3>Deposit Funds</h3>
                <div class="mail">
                    <input type="number" id="deposit_id" name="amount">
                    <label>Amount to Deposit:</label>
                </div>
                <h3 id="err1"></h3>
                <div class="submit">
                    <button class="dark">Deposit</button>
                </div>
            </form>
        </div>
        <div id="3" class="wrapper1" style="left: 72%;display: none;">
            <form id="register" class="regform" tabindex="502" method="post" action="transferUser">
                <h3>Transfer Funds</h3>
                <div class="name">
                    <input type="number" id="Account_id" name="Account">
                    <label>Account Number of Receiver:</label>
                </div>
                <h3 id="err2"></h3>
                <div class="mail">
                    <input type="number" id="Amount_id" name="amount">
                    <label>Amount to Transfer</label>
                </div>
                <h3 id="err3"></h3>
                <div class="submit">
                    <button class="dark">Transfer Funds</button>
                </div>
            </form>
        </div>
    </div>
    </div>
</main>
<script>
    $(document).ready(function () {
        $("#withdraw_id").keyup(function (event) {
            let name = $(this).val();
            name = parseInt(name);
            if (name <= 0) {
                console.log(name);
                $('#err').html("Invalid amt");
                event.preventDefault();
            } else {
                console.log(name);
                $('#err').html("Valid amt");
            }
        });
        $("#deposit_id").keyup(function (event) {
            let name = $(this).val();
            name = parseInt(name);
            if (name <= 0) {
                console.log(name);
                $('#err1').html("Invalid amt");
                event.preventDefault();
            } else {
                console.log(name);
                $('#err1').html("Valid amt");
            }
        });
        $("#Account_id").keyup(function (event) {
            let name = $(this).val();
            name = parseInt(name);
            if (name <= 0) {
                console.log(name);
                $('#err2').html("Invalid Acc");
                event.preventDefault();
            } else {
                console.log(name);
                $('#err2').html("Valid Acc");
            }
        });
        $("#Amount_id").keyup(function (event) {
            let name = $(this).val();
            name = parseInt(name);
            if (name <= 0) {
                console.log(name);
                $('#err3').html("Invalid amt");
                event.preventDefault();
            } else {
                console.log(name);
                $('#err3').html("Valid amt");
            }
        });
    })
</script>
</body>
</html>
