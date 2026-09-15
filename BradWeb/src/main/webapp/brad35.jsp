<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Brad Big Company</h1>
		<hr />
		<form action="Brad35">
			<input type='number' name="x" value="${param.x }"/>
			+
			<input type='number' name="y" value="${param.y }"/>
			<input type="submit" value="=" />
			<span>${param.x + param.y }</span>
		</form>
	</body>
</html>
