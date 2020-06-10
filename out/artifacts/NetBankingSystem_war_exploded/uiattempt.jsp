<%--
  Created by IntelliJ IDEA.
  User: RAJIV
  Date: 10-06-2020
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script  src="https://code.jquery.com/jquery-3.1.1.min.js"  integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="  crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" ></script>
    <link rel="stylesheet" href="css/ui.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script>
        $(document).ready(function(){
            $(".veen .deposit-btn button").click(function(){
                $('.veen .wrapper').addClass('move');
                $('.body').css('background','#e0b722');
                $(".veen .login-btn button").removeClass('active');
                $(this).addClass('active');

            });
            $(".veen .withdraw-btn button").click(function(){
                $('.veen .wrapper').removeClass('move');
                $('.body').css('background','#ff4931');
                $(".veen .rgstr-btn button").removeClass('active');
                $(this).addClass('active');
            });
        });
    </script>
</head>
<body>
<div class="body">
    <div class="veen">
        <div class="withdraw-btn splits">
            <p>Withdraw Funds</p>
            <button class="active">Withdraw</button>
        </div>
        <div class="deposit-btn splits">
            <p>Deposit Funds</p>
            <button>Deposit</button>
        </div>
        <div class="transfer-btn splits">
            <p>Transfer Funds</p>
            <button>Transfer</button>
        </div>
        <div class="wrapper">
            <form id="withdraw" tabindex="500" action="withdrawUser">
                <h3>Withdraw</h3>
                <div class="amount">
                    <input type="number" name="amount">
                    <label>Amount to withdraw</label>
                </div>
                <div class="submit">
                    <button class="dark">Withdraw Amount</button>
                </div>
            </form>
            <form id="deposit" tabindex="502" action="depositUser">
                <h3>Deposit</h3>
                <div class="amount">
                    <input type="number" name="amount">
                    <label>Amount to deposit</label>
                </div>
                <div class="submit">
                    <button class="dark">Deposit Amount</button>
                </div>
            </form>
            <form id="transfer" tabindex="504" action="transferUser">
                <h3>Trasnfer Funds</h3>
                <div class="account">
                    <input type="number" name="Account">
                    <label>Account Number of Receiver</label>
                </div>
                <div class="amount">
                    <input type="number" name="amount">
                    <label>Amount to withdraw</label>
                </div>
                <div class="submit">
                    <button class="dark">Transfer Amount</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
