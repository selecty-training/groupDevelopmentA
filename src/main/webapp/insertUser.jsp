<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
	<h1>ユーザー登録</h1>
	<table>
		<tr>
			<th>ユーザー名</th>
			<td>
				<input type="text" name="userNm" placeholder="ユーザー名" required="required" maxlength="" value="${userNm} "/>
			</td>
		</tr>
		<tr>
			<th>パスワード</th>
			<td>
				<input type="password" name="pass" placeholder="パスワード　※〇文字以上" required="required" maxlength="" value="${pass}"/>
			</td>
		</tr>
		<tr>
				<td colspan="2" class="btnArea">
					<input type="submit" value="登録確認" />
				</td>
			</tr>
	</table>
</body>
</html>