var commentBtn = document.getElementById("new-comment-btn");

commentBtn.addEventListener("click",function()
{
    let form = document.getElementById("new-comment-form-box");
    form.setAttribute("class","display-block");
    commentBtn.setAttribute("class","hidden");
});

