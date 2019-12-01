<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyrus Schackel
  Date: 11/26/2019
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <div id="header-icon"><a href="${pageContext.request.contextPath}"><img src="<spring:url value="/resources/img/Cookie.png"/>"></a></div>
    <div id="header-name"><a href="${pageContext.request.contextPath}"><h1>Just Desserts</h1></a></div>
    <div id="searchBar">
        <form:form method="GET" action="${pageContext.request.contextPath}/dessert/search">
            Search Desserts <input type="search" name="searchTerm">
            <input type="submit" value="Search">
        </form:form>
    </div>
    <!--
    <div id="header-nav">
        <a href="displayCategory/1"><div class="nav-item">Cookies</div></a>
        <div class="nav-item">Pies</div>
        <div class="nav-item">Cakes</div>
        <div class="nav-item">Donuts</div>
    </div>
    -->
</header>
