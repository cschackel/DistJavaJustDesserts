<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Just Desserts</title>
    <link rel="stylesheet" href="<spring:url value="/resources/css/SharedStyles.css"/>">
    <script src="<spring:url value="/resources/js/program"/>"></script>
</head>
<body>
<div id="wrapper">
    <header>
        <div id="header-icon"><a href="/"><img src="<spring:url value="/resources/img/Cookie.png"/>"></a></div>
        <div id="header-name"><a href="/"><h1>Just Desserts</h1></a></div>
        <div id="header-nav">
            <a href="Cookies.html"><div class="nav-item">Cookies</div></a>
            <div class="nav-item">Pies</div>
            <div class="nav-item">Cakes</div>
            <div class="nav-item">Donuts</div>
        </div>
    </header>
    <div id="main-grid">
        <div class="menu-item">
            <a href="Cookies.html">
                <img class="menu-tile-img" src="<spring:url value="/resources/img/Cookie.png"/>">
                <p>Cookies</p>
            </a>
        </div>
        <div class="menu-item">
            <a href="#">
                <img class="menu-tile-img" src="<spring:url value="/resources/img/Pie.png"/>">
                <p>Pies</p>
            </a>
        </div>
        <div class="menu-item">
            <a href="#">
                <img class="menu-tile-img" src="<spring:url value="/resources/img/Cake.png"/>">
                <p>Cakes</p>
            </a>
        </div>
        <div class="menu-item">
            <a href="#">
                <img class="menu-tile-img" src="<spring:url value="/resources/img/Donut.png"/>">
                <p>Donuts</p>
            </a>
        </div>
    </div>

    <footer>
        <small>&copy Cyrus Schackel 2019</small>
    </footer>
</div>
</body>
</html>