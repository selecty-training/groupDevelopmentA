<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="entity.Diary" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>my diary</title>
<link rel="stylesheet" type="text/css" href="css/myDataStyles.css">
</head>
<body>
  <div class="diary">
    <a href="menu.jsp"><small>⬅間違って来ちゃったの？</small></a>
  </div>
 <div class="list">
   <h2>一覧</h2>
   <form action="/groupDevelopmentA/showlist" name="myData">
      <ul>
      	<c:forEach var="diary" items="${diaryList}">
			<li class="title1">
          		<input type="hidden" value="${ diary.idDiary }">
          		
          		<h5><c:out value="${diary.title}" /></h5>
          		
          		<button class="delete btn">削除</button>
        	</li>
		</c:forEach>      
      </ul> 
      <input id="diaryId" type="hidden" name="diaryId">
      <!-- こうしんなら"update, 削除なら"dalete" -->
      <input id="action" type="hidden" name="action">
    </form>
  </div> 
 
  <script src="js/mydata.js"></script>
</body>
</html>



  