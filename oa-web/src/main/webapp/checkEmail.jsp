<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script type="text/javascript">
		var xmlhttp;
		if (window.XMLHttpRequest) {
		  xmlhttp=new XMLHttpRequest();
		  }
		else {// 兼容IE6,IE5
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		  }
		xmlhttp.open("GET","test1.txt",true);
		xmlhttp.open("GET","demo_get.asp?t=" + Math.random(),true);
		xmlhttp.send();
	</script>
	<form action="/oa-web/user/checkEmail" method="post">
		<input type="text" name="email">
		<input type="submit" value="验证">
	</form>
	
	<form action="/oa-web/board/updateBoardOrder" method="post">
		原顺序:<input type="text" name="boardOrder">
		新的顺序:<input type="text" name="newBoardOrder">
		面板空间编号：<input type="text" name="boardSpaceNo">
		<input type="submit" value="验证">
	</form>
	
	<form action="/oa-web/list/addList" method="post">
		列表名称:<input type="text" name="listName">
		面板编号：<input type="text" name="boardNo">
		<input type="submit" value="验证">
	</form>
	
	<form action="/oa-web/list/updateListName" method="post">
		列表新名称:<input type="text" name="newListName">
		列表编号：<input type="text" name="listNo">
		<input type="submit" value="修改">
	</form>
	
	<form action="/oa-web/list/deleteList" method="post">
		列表编号：<input type="text" name="listNo">
		<input type="submit" value="删除">
	</form>
	
	<form action="/oa-web/card/addCard" method="post">
		列表编号：<input type="text" name="listNo">
		卡片名称：<input type="text" name="cardName">
		<input type="submit" value="新增">
	</form>
	
	<form action="/oa-web/card/deleteCard" method="post">
		卡片编号：<input type="text" name="cardNo">
		<input type="submit" value="删除">
	</form>
	
	<form action="/oa-web/card/updateCardName" method="post">
		卡片编号：<input type="text" name="cardNo">
		卡片新名称：<input type="text" name="newCardName">
		<input type="submit" value="修改">
	</form>
	
	<form action="/oa-web/comment/addComment" method="post">
		卡片编号：<input type="text" name="cardNo">
		评论：<input type="text" name="comment">
		<input type="submit" value="评论">
	</form>
	
	<form action="/oa-web/comment/deleteComment" method="post">
		卡片编号：<input type="text" name="cardNo">
		评论编号：<input type="text" name="commentNo">
		<input type="submit" value="删除">
	</form>
	
</body>
</html>