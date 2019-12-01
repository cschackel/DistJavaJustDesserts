<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyrus Schackel
  Date: 10/23/2019
  Time: 4:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${category.categoryName}</title>
    <link rel="stylesheet" href="<spring:url value="/resources/css/SharedStyles.css"/>">
    <script src="<spring:url value="/resources/js/program.js"/>"></script>
</head>
<body>
<div id="wrapper">
    <%@ include file="/WEB-INF/view/includes/header.jsp" %>

    <form:form action="${pageContext.request.contextPath}/dessert/add" method="get">
        <input type="submit" value="Add Dessert">
    </form:form>

    <div class="list-specifier">
    <h1>${category.categoryName}</h1>
</div>
<div id="main-grid">

    <c:forEach var="dessert" items="${category.dessertList}">
        <div class="menu-item">
            <a href="${pageContext.request.contextPath}/dessert/${dessert.dessertID}">
                <img class="menu-tile-img" src="<spring:url value="/resources/img/${dessert.imageName}"/>">
                <p>${dessert.dessertName}</p>
            </a>
        </div>
    </c:forEach>
    <!--
    <div class="menu-item">
        <a href="ChocolateChip.html">
            <img class="menu-tile-img" src="Cookie.png">
            <p>Chocolate Chip</p>
        </a>
    </div>
    <div class="menu-item">
        <a href="#">
            <img class="menu-tile-img" src="Cookie.png">
            <p>Rasin</p>
        </a>
    </div>
    <div class="menu-item">
        <a href="#">
            <img class="menu-tile-img" src="Cookie.png">
            <p>Sugar</p>
        </a>
    </div>
    <div class="menu-item">
        <a href="#">
            <img class="menu-tile-img" src="Cookie.png">
            <p>Almond</p>
        </a>
    </div>
    -->
</div>
</div>
<%@ include file="/WEB-INF/view/includes/footer.jsp" %>
</body>
</html>
