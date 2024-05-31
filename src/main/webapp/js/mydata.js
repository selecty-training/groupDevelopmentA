let btn = document.querySelectorAll(".btn");
let diaryId = document.querySelector("#diaryId");
let action =document.querySelector("#action");
for(let i=0;i<btn.length;i++){
    btn[i].addEventListener("click",function(){
       diaryId.value =this.parentNode.children[0].value;

       if(this.innerHTML==="更新"){
        action.value = "update";
       }else{
        action.value = "delete";
        alert("もう消しちゃったよ！");
       } 
       document.actionform.submit();
    });
}   