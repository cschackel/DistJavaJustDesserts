<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyrus Schackel
  Date: 12/1/2019
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Dessert</title>
    <link rel="stylesheet" href="<spring:url value="/resources/css/SharedStyles.css"/>">
    <link rel="stylesheet" href="<spring:url value="/resources/css/ItemDesc.css"/>">
    <script src="<spring:url value="/resources/js/program.js"/>"></script>
</head>
<body>
<div id="wrapper">
    <%@ include file="/WEB-INF/view/includes/header.jsp" %>
    <form:form action="${pageContext.request.contextPath}/dessert/save" modelAttribute="newDessert" enctype="multipart/form-data">
        <form:hidden path="dessertID" value="${newDessert.dessertID}"/>
        <form:hidden path="imageName" value="${newDessert.imageName}"/>

        <table>
            <tr>
                <td><label>Dessert Name</label></td>
                <td><form:input path="dessertName"/>
                    <form:errors path="dessertName"/></td>
            </tr>
            <tr>
                <td><label>Description</label></td>
                <td><form:textarea path="description"/>
                    <form:errors path="description"/></td>
            </tr>
            <tr>
                <td><label>Discerning Features:</label></td>
                <td><form:textarea path="discerningFeatures"/>
                    <form:errors path="discerningFeatures"/></td>
            </tr>
            <tr>
                <td><label>Rating</label></td>
                <td><form:input path="rating"/>
                    <form:errors path="rating"/></td>
            </tr>
            <tr>
                <td><label>Category</label></td>
                <td>
                    <form:select path="category" items="${categories}" itemLabel="categoryName" itemValue="categoryID">
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><label>Image</label></td>
                <td><input type="file" name="dessertImage"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>
        </table>

    </form:form>
    <%@ include file="/WEB-INF/view/includes/footer.jsp" %>
</div>

</body>
</html>
