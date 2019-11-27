<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyrus Schackel
  Date: 11/21/2019
  Time: 9:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="<spring:url value="/resources/css/SharedStyles.css"/>">
    <script src="<spring:url value="/resources/js/program"/>"></script>
</head>
<body>
<div id="wrapper">
    <%@ include file="/WEB-INF/view/includes/header.jsp" %>

    <div id="content">
        <form:form method="post" action="login">
            <label>Username:</label>
            <input type="text" name="username">
            <br>
            <label>Password: </label>
            <input type="password" name="password">
            <button type="submit">Log In</button>
        </form:form>
    </div>
</div>
<%@ include file="/WEB-INF/view/includes/footer.jsp" %>
</body>
</html>
