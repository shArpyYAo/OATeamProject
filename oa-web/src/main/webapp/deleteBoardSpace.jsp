<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/oa-web/boardSpace/deleteBoardSpace" method="post">
		<input type="text" name="boardSpaceNo" value="4">
		<input type="submit">
	</form>
	
	<form action="/oa-web/boardSpace/addBoardSpace" method="post">
		<input type="text" name="boardSpaceName" value="些钱">
		<input type="submit" value="新增">
	</form>
	<form action="/oa-web/boardSpace/updateBoardSpace" method="post">
		<input type="text" name="newBoardSpaceName">
		<input type="text" name="newSummary">
		<input type="submit" value="修改">
	</form>
	
</body>
</html>