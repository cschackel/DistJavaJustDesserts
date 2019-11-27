<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Cyrus Schackel
  Date: 11/26/2019
  Time: 10:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recipes</title>
    <link rel="stylesheet" href="<spring:url value="/resources/css/SharedStyles.css"/>">
    <link rel="stylesheet" href="<spring:url value="/resources/css/Recipe.css"/>">
    <script src="<spring:url value="/resources/js/program.js"/>"></script>
</head>
<body>
<div id="wrapper">
    <%@ include file="/WEB-INF/view/includes/header.jsp" %>
<button type="button" id="new-recipe-button">Add A New Recipe</button>
<div id="new-recipe-area" class="hidden">
    <form:form method="post" action="${dessertID}/add" modelAttribute="newRecipe" enctype="multipart/form-data" class="new-recipe-box">
        <form:hidden path="dessert" value="${dessertID}"></form:hidden>
        <form:errors path="dessert"></form:errors>
        <form:hidden path="recipeID" value="${newRecipe.recipeID}"></form:hidden>
        <form:errors path="recipeID"></form:errors>
        <form:label path="title" for="new-recipe-title" onclick="">Recipe Title:</form:label>
        <form:errors path="title"></form:errors>
        <form:input type="text" path="title" required="true"  id="new-recipe-title"/>
        <form:label path="ingredients">Ingredients: <small>Comma Separated, Please</small></form:label>
        <form:errors path="ingredients"></form:errors>
        <!--
        <div id="ingredient-area">
            <input type="text" required class="new-recipe-ingredients">
        </div>

        <button type="button" id="new-ingredient-button">Add Ingredient</button>
        -->
        <form:textarea  path="ingredients"></form:textarea>
        <form:label for="new-recipe-directions" path="body">Directions:</form:label>
        <form:errors path="body"></form:errors>
        <form:textarea path="body" id="new-recipe-directions" required="true" maxlength="1000" minlength="10"></form:textarea>
        <input type="submit" id="new-recipe-submit" value="Submit">
    </form:form>
</div>
<div id="recipe-content" onclick="console.log('# Of Recipes: '+ ${recipes.size()})">
    <c:forEach var="recipe" items="${recipes}">
        <div class="recipe-box">
            <h2 class="recipe-title">${recipe.title}</h2>
            <div class="recipe-ingredients">
                <ul onclick="">
                    <c:forEach var="item" items="${recipe.ingredients}">
                        <li>${item.toString()}</li>
                    </c:forEach>
                </ul>
            </div>
            <div class="recipe-instructions">
                ${recipe.body}
            </div>
        </div>
    </c:forEach>
    <!--
    <div class="recipe-box">
        <h2 class="recipe-title">Recipe Title</h2>
        <div class="recipe-ingredients">
            <ul>
                <li> 1/2 cup (113g) unsalted butter, melted</li>
                <li> 1/3 cup (66 g) granulated sugar</li>
                <li> 1/2 cup (104g) packed light brown sugar</li>
                <li> 1 large egg</li>
                <li>1 teaspoon (5ml) vanilla extract</li>
                <li>1/2 teaspoon baking soda</li>
                <li>1/2 teaspoon salt</li>
                <li> 1 1/2 cups (186g) all-purpose flour</li>
                <li>1 1/2 cups (255g) chocolate chips (semi-sweet or milk)</li>
            </ul>
        </div>
        <div class="recipe-instructions">
            Note: This dough requires chilling.<br><br>
            Place melted butter in the bowl of a stand mixer fitted with the paddle attachment (or a large bowl if
            using a hand mixer). Add granulated and brown sugars and mix on low speed until the mixture is smooth.
            Mix in egg and vanilla extract and mix on medium speed until combined.<br><br>
            Mix in baking soda and salt, then slowly mix in flour and mix just until the batter is smooth and comes
            together. Be sure to scrape the sides of the bowl during mixing. Slowly mix in chocolate chips.<br><br>
            Line a cookie sheet with a silicone baking mat or parchment paper. Scoop 2 tablespoon balls of dough
            onto the cookie sheet. Spacing doesn’t matter because you will be chilling the dough. Cover with plastic
            wrap and chill for at least 2 hours.<br><br>
            Preheat oven to 350°F. Line a second cookie sheet with parchment paper or a silicone baking mat.<br><br>
            Remove the chilled cookie dough balls from the refrigerator and space them 2-inches apart on the cookie
            sheets. Bake (2 tablespoon sized cookies) for 11-15 minutes, or until the edges are a light golden and
            the tops are no longer glossy. Let cool on the cookie sheets at least 10 minutes before removing.<br><br>

        </div>
    </div>
    -->
</div>
<%@ include file="/WEB-INF/view/includes/footer.jsp" %>
</div>
<script src="<spring:url value="/resources/js/recipes.js"/>"></script>
</body>
</html>
