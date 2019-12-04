<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyrus Schackel
  Date: 12/1/2019
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search</title>
    <link rel="stylesheet" href="<spring:url value="/resources/css/SharedStyles.css"/>">
    <link rel="stylesheet" href="<spring:url value="/resources/css/ItemDesc.css"/>">
    <script src="<spring:url value="/resources/js/program.js"/>"></script>
</head>
<body>
<div id="wrapper">
    <%@ include file="/WEB-INF/view/includes/header.jsp" %>
    <c:if test="${desserts.size() gt 0}">
    <ul>
    <c:forEach var="dessert" items="${desserts}">
        <li><a href="${pageContext.request.contextPath}/dessert/${dessert.dessertID}">
            ${dessert.dessertName}
        </a></li>

    </c:forEach>
    </ul>
    </c:if>
    <c:if test="${desserts == null or desserts.size() == 0}">
        <p>No Matching Desserts Found</p>
    </c:if>
    <%@ include file="/WEB-INF/view/includes/footer.jsp" %>
</div>
</body>
</html>
