
var newRecipeButton = document.getElementById("new-recipe-button");

newRecipeButton.addEventListener("click",function()
{
    var box = document.getElementById("new-recipe-area");
    box.setAttribute('class','displayBlock');
    newRecipeButton.setAttribute('class',"hidden");
});

var newIngredButton = document.getElementById("new-ingredient-button");
newIngredButton.addEventListener("click",function()
{
    var ingredientList=document.getElementById("ingredient-area");
    //ingredientList.innerHTML+="<input type=\"text\" required class=\"new-recipe-ingredients\">";
    var input = document.createElement("input");
    input.type = "text";
    input.setAttribute("required","true");
    input.setAttribute("class","new-recipe-ingredients")
    ingredientList.appendChild(input);
});

