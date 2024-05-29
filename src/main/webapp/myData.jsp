<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>diary</title>
<link rel="stylesheet" type="text/css" href="css/myDataStyles.css">
</head>
<body>
  <div class="diary">
    <a href="menu.jsp"><small><small><small>⬅間違って来ちゃったの？</small></small></small></a>
  </div>
 <div class="list">
   <h2>一覧</h2>
   <form action="#" method="#" name="actionform">
      <ul>
        <li class="title1">
          <input type="hidden" name="id" value="${diary_id}">
          <h5>title</h5>
          <button class="update btn">更新</button>
          <button class="delete btn">削除</button>
        </li>
        <li >
          <input type="hidden" name="id" value="2">
          <h5 >title2</h5>
          <button class="update btn">更新</button>
          <button class="delete btn">削除</button>
        </li>
        <li>
          <input type="hidden" name="id" value="3">
          <h5>title3</h5>
          <button class="update btn">更新</button>
          <button class="delete btn">削除</button>
        </li>
      </ul> 
      <input id="diaryId" type="hidden" name="diaryId">
      <!-- こうしんなら"update, 削除なら"dalete" -->
      <input id="action" type="hidden" name="action" value="update">
    </form>
  </div> 
  <script src="js/mydata.js"></script>
</body>
</html>



  