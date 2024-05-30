<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Login-Diary</title>
    <link rel="stylesheet" href="css/LoginStyles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .background-image {
            background-image: url(images/login.jpg);
            background-size: cover;
            background-color:rgba(255,255,255,0.6);
            background-blend-mode:lighten;
            background-position: center;
            background-repeat: no-repeat;
        }
    </style>
</head>
<body>
    <div class="background-image" >
        <div class="row res">
            <div class="Diary">
                <div>
                    <h1>Diary</h1>
                </div>
                <c:if test="${errMsg != null}">
            		<div class="msgBox error">
               	 		<c:forEach items="${ errMsg }" var="errList">
                    		<c:out value="${errList}" />
                		</c:forEach>
            		</div>
				</c:if>
                <form method="post" action="/groupDevelopmentA/login">
                    <input type="text" name="userNm" maxlength="20" placeholder="ユーザー名"
                        required value="${userNm}">
                    <input type="password" name="pass" maxlength="20" placeholder="パスワード" required value="${pass }">
                    <div class="submit">
                        <a href="signup.jsp">新規登録</a>
                    </div>
                    <hr>
                    <!-- <div class="button">
                    <a href="menu.html">ログイン</a>
                    </div> -->
                    <input class="button" type="submit" value="ログイン">
                    
                </form>
            </div>
        </div>
    </div>
    <footer>
        
    </footer>
</body>

</html>