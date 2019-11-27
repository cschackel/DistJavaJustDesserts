<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
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
    <%@ include file="/WEB-INF/view/includes/header.jsp" %>

    <div id="main-grid">

        <c:forEach var="cat" items="${categories}">
            <!--
            <c:url var="categoryPageLink" value="${pageContext.request.contextPath}/category/${cat.categoryID}">
                <c:param name="donutId" value="${tempDonut.id}"/>
            </c:url>
            -->

            <div class="menu-item">
                <a href="${pageContext.request.contextPath}/category/${cat.categoryID}">
                    <img class="menu-tile-img" src="<spring:url value="/resources/img/${cat.imageName}"/>">
                    <p>${cat.categoryName}</p>
                </a>
            </div>


        </c:forEach>


        <!--
        <div class="menu-item">
            <a href="displayCategory/1">
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
        -->
    </div>
    <%@ include file="/WEB-INF/view/includes/footer.jsp" %>
</div>
</body>
</html>