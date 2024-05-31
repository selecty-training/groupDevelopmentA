<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Diary Menu</title>
    <link rel="stylesheet" href="css/menuStyles.css">
	 <style>
        .background-image {
            background-image: url(images/test.jpg);
		    background-size: cover;
		    background-color:rgba(255,255,255,0.6);
		    background-position: center;
		    background-repeat: no-repeat;
		    height: 100vh;
        }
    </style>
</head>
<body>
<form action="/groupDevelopmentA/CheckAction" name="actionform">
    <div class="background-image">
        <div class ="userInfo">
            <strong>${LOGIN.nmUser}さん</strong>
        </div>
        <div class="menu" >
            <div class="circle">
                <a href="index.jsp">今日良いこと <br> あった❓</a>
                <a href="#" id="showList">今までのやつ</a>
            </div>
        </div>
        <input type="hidden" name="action" id="action">
    </div>
   </form>
</body>
<script>
	let showList =document.querySelector("#showList");
	showList.addEventListener("click",function(){
       document.actionform.submit();
	});
</script>

</html>
    