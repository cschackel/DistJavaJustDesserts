<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyrus Schackel
  Date: 11/21/2019
  Time: 10:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="<spring:url value="/resources/css/SharedStyles.css"/>">
    <script src="<spring:url value="/resources/js/program"/>"></script>
</head>
<body>
<div id="wrapper">
    <%@ include file="/WEB-INF/view/includes/header.jsp" %>

    <div id="content">
        <h1>Oops. Something went wrong!</h1>
        <div id="errorMsg">
            <p>${errorMessage}</p>
        </div>
    </div>
</div>
<%@ include file="/WEB-INF/view/includes/footer.jsp" %>

</body>
</html>
