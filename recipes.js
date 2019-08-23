
var newRecipeButton = document.getElementById("new-recipe-button");

newRecipeButton.addEventListener("click",function()
{
    let box = document.getElementById("new-recipe-area");
    box.setAttribute('class','displayBlock');
    newRecipeButton.setAttribute('class',"hidden");
});

var newIngredButton = document.getElementById("new-ingredient-button");
newIngredButton.addEventListener("click",function()
{
    let ingredientList=document.getElementById("ingredient-area");
    ingredientList.innerHTML+="<input type=\"text\" required class=\"new-recipe-ingredients\">";
});

