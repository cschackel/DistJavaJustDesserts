<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyrus Schackel
  Date: 11/26/2019
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${dessert.dessertName}</title>
    <link rel="stylesheet" href="<spring:url value="/resources/css/SharedStyles.css"/>">
    <link rel="stylesheet" href="<spring:url value="/resources/css/ItemDesc.css"/>">
    <script src="<spring:url value="/resources/js/program.js"/>"></script>
</head>
<body>
<div id="wrapper">
    <%@ include file="/WEB-INF/view/includes/header.jsp" %>

    <div class="item-grid">
    <div class="item-grid-img-main"><img src="<spring:url value="/resources/img/${dessert.imageName}"/>"></div>
    <div class="item-grid-title"><h1 class="item-grid-field-header">Name: ${dessert.dessertName}</h1></div>
    <div class="item-grid-rating"><h2 class="item-grid-field-header">Discerning Feature: ${dessert.discerningFeatures}</h2></div>
    <div class="item-grid-rating"><h2 class="item-grid-field-header">Rating: ${dessert.rating}</h2></div>
    <div class="item-grid-desc"><h2 class="item-grid-field-header">Description:</h2><p>${dessert.description}</p></div>
    <div class="item-grid-comments-section">
        <h2 class="item-grid-field-header">Comments:</h2>
        <div class="item-grid-comments-box">
            <form:form action="${dessertID}/addComment" method="post" modelAttribute="newComment" id="new-comment-form-box" class="hidden">
                <form:hidden path="commentID" value="${newComment.commentID}"></form:hidden>
                <form:errors path="commentID"></form:errors>
                <form:hidden path="dessert" value="${dessertID}"></form:hidden>
                <form:errors path="dessert"></form:errors>
                <div id="new-comment-form">
                    <form:label path="postedBy" for="new-comment-user">Username:</form:label>
                    <form:errors path="postedBy"></form:errors>
                    <form:input path="postedBy" type="text" id="new-comment-user" required="true"/>
                    <form:label path="title" for="new-comment-user">Post Title:</form:label>
                    <form:errors path="title"></form:errors>
                    <form:input path="title" type="text" id="new-comment-title" required="true"/>
                    <form:label path="body" for="new-comment-body">Comment:</form:label>
                    <form:errors path="body"></form:errors>
                    <form:textarea path="body" id="new-comment-body" minlength="5" maxlength="500" required="true"></form:textarea>
                </div>
                <form:button value="submit" type="submit">Post comment</form:button>
            </form:form>

            <button type="button" id="new-comment-btn">Add Comment</button>
        </div>
        <div class="item-grid-comments">
            <c:forEach var="comment" items="${dessert.commentList}">
                <div class="item-grid-comments-comment">
                    <h4>User: ${comment.postedBy} - ${comment.title}:</h4>
                    <div>${comment.body}</div>
                </div>
            </c:forEach>
            <!--
            <div class="item-grid-comments-comment">
                <h4>User: Jim - I Don't Like Them:</h4>
                <div>They are Gross</div>
            </div>
            <div class="item-grid-comments-comment">
                <h4>User: Jim - I Don't Like Them:</h4>
                <p>They are Gross</p>
            </div>
            -->
        </div>
    </div>
    <div class="item-grid-recipe">
        <a href="<spring:url value="/recipe/${dessert.dessertID}"/>"><button>See Recipes</button></a>
    </div>
</div>
        <%@ include file="/WEB-INF/view/includes/footer.jsp" %>
</div>
        <script src="<spring:url value="/resources/js/ItemDesc.js"/>"></script>
</body>
</html>
