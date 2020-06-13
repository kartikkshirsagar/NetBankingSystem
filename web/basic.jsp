<html>
<html lang="en">
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
<nav
        class="navbar navbar-expand-lg navbar-dark bg-mattBlackLight fixed-top"
>
    <button class="navbar-toggler sideMenuToggler" type="button">
        <span class="navbar-toggler-icon"></span>
    </button>

    <a class="navbar-brand" href="#">Welcome <%
        if(auth) {
            out.println(UserDetails.getAccount_Holder());
        }%></a>
    <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
    >
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item dropdown">
                <a
                        class="nav-link dropdown-toggle p-0"
                        href="#"
                        id="navbarDropdown"
                        role="button"
                        data-toggle="dropdown"
                        aria-haspopup="true"
                        aria-expanded="false"
                >
                    <i class="material-icons icon">
                        person
                    </i>
                    <span class="text">Account</span>
                </a>
                <div
                        class="dropdown-menu dropdown-menu-right"
                        aria-labelledby="navbarDropdown"
                >
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="logout.jsp">Logout</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
<div class="wrapper d-flex">
    <div class="sideMenu bg-mattBlackLight">
        <div class="sidebar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a href="home.jsp" class="nav-link px-2">
                        <i class="material-icons icon">
                            dashboard
                        </i>
                        <span class="text">Dashboard</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="profile.jsp" class="nav-link px-2">
                        <i class="material-icons icon">
                            person
                        </i>
                        <span class="text">User Profile</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="mallHome.jsp" class="nav-link px-2">
                        <i class="material-icons icon"> border_all </i
                        ><span class="text">Mall</span></a
                    >
                </li>

                <li class="nav-item">
                    <a href="#" class="nav-link px-2">
                        <i class="material-icons icon"> cloud </i
                        ><span class="text">About Us</span></a
                    >
                </li>

                <li class="nav-item">
                    <a href="landing.html" class="nav-link px-2 sideMenuToggler">
                        <i class="material-icons icon expandView ">
                            keyboard_arrow_left
                        </i>
                        <span class="text">Landing</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>




























<!-- <h1 style="margin-top: 200px;margin-left:200px;color: dodgerblue">Your Account Number is: <% if(auth) {out.println(UserDetails.getAccount_Number());} %>
    <br>Your Balance: <%if(auth){ out.println(UserDetails.getBalance());} %>
</h1> -->