<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>Signup-Diary</title>
    <link rel="stylesheet" href="loginStyles.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
        .background-image {
            background-image: url(images/signup.jpg);
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
            <div class="Signup">
                <div>
                    <h1>アカウント作る❓</h1>
                </div>
                <form action="#" onsubmit="return validateForm()">
                    <input type="text" maxlength="20" placeholder="ユーザー名" required>
                    <input type="password" maxlength="20" placeholder="パスワード" required>
                    <input type="password" maxlength="20" placeholder="パスワードの確認" required>
                    <hr>
                    <!-- <div class="button">
                        <a href="menu.html">始める</a>
                    </div> -->
                    <input class="button" type="submit" value="登録">
                </form>
                <div class="question">
                    <a href="login.html">アカウントあったんかい❓</a>
                </div>
            </div>
        </div>
    </div>
    <footer>

    </footer>

    <script>
        function validateForm() {
            var password = document.querySelector('input[type="password"]').value;
            var confirmPassword = document.querySelectorAll('input[type="password"]')[1].value;

            if (password !== confirmPassword) {
                alert("さっきと違うよ？パスワード");
                return false;
            }

            return true;
        }
    </script>
</body>
</html>
    