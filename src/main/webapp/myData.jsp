<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="entity.Diary" %>
<%@ page import="java.util.ArrayList" %>
<%ArrayList<Diary> diaryList = (ArrayList<Diary>)request.getAttribute("diaryList");%>
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
   <form action="/groupDevelopmentA/showlist" name="myData">
      <ul>
        <% for(Diary diary : diaryList){ %>
			<li class="title1">
          		
          		<h5><%=diary.getTitle() %></h5>
          		
          		<button class="update btn">更新</button>
          		<button class="delete btn">削除</button>
        	</li>
		<% } %>      
      </ul> 
      <input id="diaryId" type="hidden" name="diaryId">
      <!-- こうしんなら"update, 削除なら"dalete" -->
      <input id="action" type="hidden" name="action" value="update">
    </form>
  </div> 
  <script src="js/mydata.js"></script>
</body>
</html>



  