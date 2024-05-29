<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Login-Diary</title>
    <link rel="stylesheet" href="css/loginstyles.css">
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
                <form action="menu.jsp">
                    <input type="Username" maxlength="20" placeholder="ユーザー名"
                        required>
                    <input type="password" maxlength="20" placeholder="パスワード" required>
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