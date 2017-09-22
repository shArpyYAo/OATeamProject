<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/oa-web/boardSpace/selectBoardSpaceByUserId" method="post">
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
	
	<form action="/oa-web/card/selectCard" method="post">
		<input type="text" name="cardNo">
		<input type="submit" value="查询">
	</form>
	
	<form action="/oa-web/board/findBoard/1" method="post">
		<input type="submit" value="查询看板详情">
	</form>
	
	<form action="/oa-web/comment/addComment" method="post">
		<input type="text" name="cardNo">
		<input type="text" name="comment">
		<input type="submit" value="新增评论">
	</form>
	<form action="/oa-web/comment/deleteComment" method="post">
		<input type="text" name="commentNo">
		<input type="submit" value="删除评论">
	</form>
	
	<form action="/oa-web/boardSpace/addUser" method="post">
		<input type="text" name="boardSpaceNo">
		<input type="text" name="targetUserNo">
		<input type="submit" value="添加看板空间用户">
	</form>
	
	<form action="/oa-web/boardSpace/deleteUser" method="post">
		<input type="text" name="boardSpaceNo">
		<input type="text" name="targetUserNo">
		<input type="submit" value="移除看板空间用户">
	</form>
	
	<form action="/oa-web/board/addUser" method="post">
		<input type="text" name="boardNo">
		<input type="text" name="targetUserNo">
		<input type="submit" value="添加看板用户">
	</form>
	<form action="/oa-web/board/deleteUser" method="post">
		<input type="text" name="boardNo">
		<input type="text" name="targetUserNo">
		<input type="submit" value="移除看板用户">
	</form>
	
	<form action="/oa-web/card/addUser" method="post">
		<input type="text" name="cardNo">
		<input type="text" name="targetUserNo">
		<input type="submit" value="添加卡片用户">
	</form>
	<form action="/oa-web/card/deleteUser" method="post">
		<input type="text" name="cardNo">
		<input type="text" name="targetUserNo">
		<input type="submit" value="移除卡片用户">
	</form>
	
</body>
</html>