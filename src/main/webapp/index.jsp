<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Diary</title>
    <link rel="stylesheet" href="css/indexStyles.css">
</head>
<body>
	<form action="/groupDevelopmentA/insertDiary" method="post">
	    <div class="container">
	        <h1>お帰り、今日もおつかれー</h1>
	        <div class="title">
	            <input type="text" id="title" placeholder="タイトルを入力してください" name="title">
	        </div>
	        <textarea id="diary" placeholder="ここに入力してください" name="text"></textarea>
	        <input class="button" type="submit" value="終わったよ～">
	    </div>
    </form>
</body>
</html>
    