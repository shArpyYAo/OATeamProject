window.onload = function()
{
	var main = document.getElementById("main");
	var menuButton = document.getElementById("menuButton");
	var menu = document.getElementById("menu");
	var overLay = document.getElementById("overLay");
	var borderList = document.getElementById("boardList");
	var title = document.getElementById("title");
	var ul = document.getElementById("proUl");
	var input1,input2,cls,first = 0,borderLength = 0,where,firstClickMenu = 0;
	//where : 0.是addBorder函数,1.是initProAndBorder函数
	var boardSpaceNo,json,boardSpaceName,member;
	function fomatFloat(src,pos)
	{   
       return Math.round(src*Math.pow(10, pos))/Math.pow(10, pos);   
    } 
	
	function initProAndBorder(title, ul, json)
	{
		var li,a,span,id,span,div,h3,temp,input,proName;
		title.innerHTML = json["data"][0]["boardSpaceName"];
		for(let i = 0;i < json["data"].length;i++)
		{//初始化用户全部项目的数据
			proName = json["data"][i]["boardSpaceName"];
			initPro(ul,li,a,span,proName,i,temp);
			where = 1;
			initAddBorderButton(input,div,h3,span,i,where);
			for(let j = 0;j < json["data"][i]["tBoard"].length;j++)
			{
				initBorder(input,div,h3,span,i,j,json["data"][i]["tBoard"][j]["boardName"],where);
			}
		}
	}
	
	function begPersonalJsonData()
	{
		$.ajax(
		{
	        cache: false,
	        type: "post",
	        dataType: "json",
	        url: "/oa-web/boardSpace/selectBoardSpaceByUserId",
	        error: function(request) 
	        {
	            alert("Connection error");
	        },
	        success: function(data) 
	        {
	        	json = data;
	        	initData();
	        	if(first == 0)
	        	{
	        		initProAndBorder(title, ul, json);
	        	}
	        	first = 1;
	        }
	    });
	}
	
	function initData()
	{
		boardSpaceNo = new Array(json["data"].length);
		boardSpaceName = new Array(json["data"].length);
		for(let i = 0;i < json["data"].length;i++)
		{
			boardSpaceNo[i] = json["data"][i]["boardSpaceNo"];
			boardSpaceName[i] = json["data"][i]["boardSpaceName"];
		}
	}
	
	begPersonalJsonData();
	
	function initPro(ul,li,a,span,proName,i,temp)
	{
		li = document.createElement("li");
		a = document.createElement("a");
		a.id = "proName" + i;
		span = document.createElement("span");
		span.className = "demoSpanX";
		span.id = "proSpanX" + i;
		span.addEventListener("click",function(event)
		{
			alert("删除空间");
			var rubish,granpar,No,borderNo;
			id = event.target.getAttribute("id");
			No = id;
			No = No.replace(/[^0-9]/ig,"");
			borderNo = boardSpaceNo[No];
			alert("borderNo:" + borderNo);
			$.ajax(
			{
		        cache: false,
		        type: "post",
		        dataType: "json",
		        data:{
		        	boardSpaceNo : borderNo
		        }
		        ,
		        url: "/oa-web/boardSpace/deleteBoardSpace",
		        error: function(request) 
		        {
		            alert("Connection error");
		        },
		        success: function(data) 
		        {
		        	alert("Connection ok:" + data["msg"]);
					location.reload();
		        }
		    });
			rubish = document.getElementById(id).parentNode;
			granPar = rubish.parentNode;
			granPar.removeChild(rubish);
		},false);
		a.innerHTML = proName;
		li.appendChild(a);
		li.appendChild(span);
		ul.appendChild(li);
		a.addEventListener("click",function(event)
		{
			id = event.target.getAttribute("id");
			title.innerHTML = document.getElementById(id).innerHTML;
			temp = id.replace(/[^0-9]/ig,"");
			$("#boardList .div").css("display","none");
			$("#boardList #div" + temp + " .div").css("display","inline-block");
			$("#divJButton" + temp).css("display","inline-block");
			/*let k = 0;
			for(let j = 0;j < json["data"][temp]["tBoard"].length;j++)
			{
				$("#div" + temp +":nth-child(" + (j + 1) +")").css("animation","none");
				$("#div" + temp +":nth-child(" + (j + 1) +")").css("animationFillMode","none");
				$("#div" + temp +":nth-child(" + (j + 1) +")").css("animation","borderAppear 0.6s " + k + "s");
				$("#div" + temp +":nth-child(" + (j + 1) +")").css("animationFillMode","forwards");
				k = k + 0.2;
				k = fomatFloat(k, 1);
			}
			$("#divJButton" + temp).css("animation","borderAppear 0.6s " + k + "s");
			$("#divJButton" + temp).css("animationFillMode","forwards");*/
		},false);
		document.getElementById("proSpanJ").addEventListener("click",addSpace,false);
		document.getElementById("proNameButton").addEventListener("click",comfirmSpace,false);
	}
	
	function initBorder(input,div,h3,span,i,j,borderName,where)
	{
		var temp,divSpace;
		temp = 0;
		div = document.createElement("div");
		divSpace = document.getElementById("div" + i);
		h3 = document.createElement("h3");
		h3.innerHTML = borderName;
		h3.id = j;
		h3.addEventListener("click",function(event)
		{
			var temp = 0,i;
			i = event.target.getAttribute("id");
			temp = event.target.parentNode;
			temp = temp.parentNode.id;
			temp = temp.replace(/[^0-9]/ig,"");
			temp = json["data"][temp]["tBoard"][i]["boardNo"];
			window.location = "TaskList.html?id=" + temp;
		},false);
		span = document.createElement("span");
		span.className = "demoSpanX";
		if(where == 1)
			span.id = "border" + i + "SpanX" + j;
		else if(where == 0)
			span.id = "border" + i + "SpanX" + json["data"][i]["tBoard"].length;
		span.addEventListener("click",deleteBorder,false);
		div.appendChild(h3);
		div.appendChild(span);
		if(i != 0 && where == 1)
			div.style.display = "none";
		div.className = "div";
		if(where == 1)
		{
			for(let k = 0;k < j;k++)
			{
				temp = temp + 0.2;
			}
			temp = fomatFloat(temp, 1);
		}
		else if(where == 0)
		{
			temp = 0;
		}
		div.style.animation = "borderAppear 0.6s " + temp + "s";
		div.style.animationFillMode = "forwards";
		if(where == 1)
		{
			divSpace.insertBefore(div,divSpace.childNodes[j]);
			
		}
		else if(where == 0)
		{
			divSpace.insertBefore(div,divSpace.childNodes[json["data"][i]["tBoard"].length]);
		}
	}
	
	function initAddBorderButton(input,div,h3,span,i,where)
	{
		var temp = 0,divSpace;
		divSpace = document.createElement("div");
		div = document.createElement("div");
		span = document.createElement("span");
		h3 = document.createElement("h3");
		input = document.createElement("input");
		input.type = "text";
		input.className = "borderNameInput";
		input.style.display = "none";
		h3.innerHTML = 1;
		span.className = "demoSpanJ";
		span.id = "border" + i + "SpanJ";
		span.addEventListener("click",function(event)
		{
			var parClassName;
			alert("增加看板");
			id = event.target.getAttribute("id");
			cls = id.replace(/[^0-9]/ig,"");
			parClassName = document.getElementById(id).parentNode.className;
			input1 = document.getElementById(id).previousSibling;
			input1.style.display = "inline-block";
			input2 = input1.previousSibling;
			input2.style.display = "inline-block";
			if(borderLength == 0)
				borderLength = json["data"][cls]["tBoard"].length;
			else
				borderLength++;
			input1.addEventListener("click",addBorder,false);
		},false);
		div.appendChild(input);
		input = document.createElement("input");
		input.type = "button";
		input.className = "borderNameButton";
		input.value = "保存";
		input.style.display = "none";
		div.appendChild(input);
		div.appendChild(span);
		div.appendChild(h3);
		if(i != 0 && where == 1)
			div.style.display = "none";
		div.className = "div";
		div.id = "divJButton" + i;
		divSpace.id = "div" + i;
		temp = 0;
		for(let k = 0;k < json["data"][i]["tBoard"].length;k++)
		{
			temp = temp + 0.2;
		}
		temp = fomatFloat(temp, 1);
		div.style.animation = "borderAppear 0.6s " + temp + "s";
		div.style.animationFillMode = "forwards";
		divSpace.appendChild(div);
		boardList.appendChild(divSpace);
	}
	
	function addSpace(event)
	{
		alert("增加空间");
		$(".proNameInput").css("animation","borderAppear 0.4s");
		$(".proNameButton").css("animation","borderAppear 0.4s");
		$(".proNameInput").css("animationFillMode","forwards");
		$(".proNameButton").css("animationFillMode","forwards");
		document.getElementById("proSpanJ").removeEventListener("click",addSpace,false);
	}
	
	function comfirmSpace(event)
	{
		var inputName,li,a,span,temp = 0,input,div,h3;
		inputName = document.getElementById("proNameInput").value;
		if(inputName != "")
			initPro(ul,li,a,span,inputName,json["data"].length,temp);
		else
		{
			inputName = "新建空间";
			initPro(ul,li,a,span,"新建空间",json["data"].length,temp);
		}
		$(".proNameInput").css("opacity","0");
		$(".proNameButton").css("opacity","0");
		$(".proNameInput").css("animation","none");
		$(".proNameButton").css("animation","none");
		$.ajax(
		{
	        cache: false,
	        type: "post",
	        dataType: "json",
	        data:{
	        	boardSpaceName : inputName
	        }
	        ,
	        url: "/oa-web/boardSpace/addBoardSpace",
	        error: function(request) 
	        {
	            alert("Connection error");
	        },
	        success: function(data) 
	        {
	        	alert("Connection ok:" + data["status"]);
	        	/*begPersonalJsonData();
	        	initAddBorderButton(input,div,h3,span,json["data"].length,1)*/
	        	location.reload();
	        }
	    });
		document.getElementById("proNameButton").removeEventListener("click",deleteSpace,false);
	}
	
	function addBorder(event)
	{ 
		var input,div,h3,span,borderName,borderNo,No;
		if(input2.value != "")
			borderName = input2.value;
		else
			borderName = "新建看板";
		No = event.target.parentNode.id;
		No = No.replace(/[^0-9]/ig,"");
		borderNo = boardSpaceNo[No];
		$.ajax(
		{
	        cache: false,
	        type: "post",
	        dataType: "json",
	        data:{
	        	newBoardName : borderName,
	        	boardSpaceNo : borderNo
	        },
	        url: "/oa-web/board/addBoard",
	        error: function(request) 
	        {
	            alert("Connection error");
	        },
	        success: function(data) 
	        {
	        	alert("Connection ok:" + data["status"]);
	        	begPersonalJsonData();
	        }
	    });
		where = 0;
		initBorder(input,div,h3,span,No,json["data"][No]["tBoard"].length,borderName,where)
		input1.style.display = "none";
		input2.style.display = "none";
		input1.removeEventListener("click",add,false);
	}
	
	function deleteBorder(event)
	{
		var rubish,id,granPar,No,span;
		alert("删除看板");
		id = event.target.getAttribute("id");
		alert(id);
		No = json["data"][id.charAt(6)]["tBoard"][id.charAt(12)]["boardNo"];
		$.ajax(
		{
	        cache: false,
	        type: "post",
	        dataType: "json",
	        data:{
	        	boardNo : No
	        },
	        url: "/oa-web/board/deleteBoard",
	        error: function(request) 
	        {
	            alert("Connection error");
	        },
	        success: function(data) 
	        {
	        	alert("Connection ok " + data["status"]);
	        	begPersonalJsonData();
	        }
	    });
		rubish = document.getElementById(id).parentNode;
		granPar = rubish.parentNode;
		granPar.removeChild(rubish);
	}
	
	function updateMember(borderSpaceNo)
	{
		$.ajax(
		{
	        cache: false,
	        type: "post",
	        dataType: "json",
	        data:
	        {
	        	boardSpaceNo : borderSpaceNo
	        },
	        url: "/oa-web/boardSpace/findUser",
	        error: function(request) 
	        {
	            alert("Connection error");
	        },
	        success: function(data) 
	        {
	        	member = data;
	        }
		});
	}
	
	function addMember(borderSpaceNo,userNo,memberMessage)
	{
		$.ajax(
		{
	        cache: false,
	        type: "post",
	        dataType: "json",
	        data:{
	        	boardSpaceNo : borderSpaceNo,
	        	targetUserNo : userNo
	        },
	        url: "/oa-web/boardSpace/addUser",
	        error: function(request) 
	        {
	            alert("Connection error");
	        },
	        success: function(data) 
	        {
	        	alert("Connection ok " + data["msg"]);
	        	updateMember(borderSpaceNo);
	        }
	    });
	}
	
	function deleteMember(borderSpaceNo,userNo)
	{
		$.ajax(
		{
	        cache: false,
	        type: "post",
	        dataType: "json",
	        data:{
	        	boardSpaceNo : borderSpaceNo,
	        	targetUserNo : userNo
	        },
	        url: "/oa-web/boardSpace/deleteUser",
	        error: function(request) 
	        {
	            alert("Connection error");
	        },
	        success: function(data) 
	        {
	        	alert("Connection ok " + data["msg"]);
	        	updateMember(borderSpaceNo);
	        }
	    });
	}
	
	menuButton.addEventListener("mouseover", function(event)
	{
		$(".Click").css("animation", "shakeClick 0.3s infinite");
		$(".It").css("animation", "shakeIt 0.3s infinite");
	},false);
	menuButton.addEventListener("mouseout", function(event)
	{
		$(".Click").css("animation", "none");
		$(".It").css("animation", "none");
	},false);
	menuButton.addEventListener("click", function(event)
	{
		$("#main").css("-webkit-transform", "scale3d(0.62,0.78,0.5) rotateY(-2deg) translate3d(186px,0px,1px)");
		$("#main").css("-moz-transform", "scale3d(0.62,0.78,0.5) rotateY(-2deg) translate3d(186px,0px,1px)");
		$("#main").css("-ms-transform", "scale3d(0.62,0.78,0.5) rotateY(-2deg) translate3d(186px,0px,1px)");
		$("#main").css("transform", "scale3d(0.62,0.78,0.5) rotateY(-2deg) translate3d(186px,0px,1px)");
		$("#menu").css("left", "-0px");
		$(".Click").css("animation", "none");
		$(".It").css("animation", "none");
		overLay.style.display = "block";
		var ul = menu.getElementsByTagName("ul");
		if(firstClickMenu == 0)
		{
			var newLi,a;
			for(let i = 0;i < boardSpaceName.length;i++)
			{
				newLi = document.createElement("li");
				a = document.createElement("a");
				a.innerHTML = boardSpaceName[i];
				a.id = i;
				a.addEventListener("click",function(event)
				{
					var div,input,span,memberMessage = document.getElementById("memberMessage");
					var borderSpaceNo = boardSpaceNo[this.id];
					$.ajax(
					{
				        cache: false,
				        type: "post",
				        dataType: "json",
				        data:{
				        	boardSpaceNo : borderSpaceNo
				        },
				        url: "/oa-web/boardSpace/findUser",
				        error: function(request) 
				        {
				            alert("Connection error");
				        },
				        success: function(data) 
				        {
				        	while(memberMessage.hasChildNodes()) //当div下还存在子节点时 循环继续  
				    	    {  
				    			memberMessage.removeChild(memberMessage.firstChild);  
				    	    }  
				        	span = document.createElement("span");
				        	input = document.createElement("input");
				        	input.style.display = "none";
				        	input.style.width = "100px";
				        	input.style.background = "white";
				        	input.value = "请输入用户编号";
				        	span.innerHTML = "邀请成员";
				        	span.style.cursor = "pointer";
				        	span.appendChild(input);
				        	for(let i = 0;i < data["data"].length;i++)
				        	{
				        		div = document.createElement("div");
				        		div.innerHTML = data["data"][i]["nickName"];
				        		div.id = data["data"][i]["userNo"];
				        		div.style.cursor = "pointer";
				        		div.addEventListener("click",function(event)
				        		{
				        			deleteMember(borderSpaceNo,this.id);
				        			memberMessage.removeChild(this); 
				        		},false);
				        		memberMessage.appendChild(div);
				        	}
				        	memberMessage.appendChild(span);
				        	memberMessage.style.display = "block";
				        	span.addEventListener("click",function(event)
				        	{
				        		input.style.display = "block";
				        		document.onkeydown = function(event)
				        		{
				        			if(event && event.keyCode==13)
				        			{
				        				if(input.value != "请输入用户编号" || input.value != "")
				        				{
				        					addMember(borderSpaceNo,input.value,memberMessage);
				        					
				        				}	
				        			}
				        		}
				        	},false);
				        }
				    });
				},false);
				newLi.appendChild(a);
				ul[0].insertBefore(newLi,ul[0].children[1]);
			}
		}
		var li = menu.getElementsByTagName("li");
		for(let i = 0;i < li.length;i++)
		{
			if(i % 2 == 0)
				li[i].style.animation = "AppearFromRight 0.6s " + "0." + (i + 1) + "s forwards";
			else
				li[i].style.animation = "AppearFromLeft 0.6s " + "0." + (i + 1) + "s forwards";
		}
	},false);
	overLay.addEventListener("click", function(event)
	{
		var memberMessage;
		$("#main").css("-webkit-transform", "none");
		$("#main").css("-moz-transform", "none");
		$("#main").css("-ms-transform", "none");
		$("#main").css("transform", "none");
		$("#menu").css("left", "-300px");
		overLay.style.display = "none";
		memberMessage = document.getElementById("memberMessage");
		memberMessage.style.display = "none";
		while(memberMessage.hasChildNodes()) //当div下还存在子节点时 循环继续  
	    {  
			memberMessage.removeChild(memberMessage.firstChild);  
	    }  
		var li = menu.getElementsByTagName("li");
		for(let i = 0;i < li.length;i++)
		{
			li[i].style.animation = "none";
		}
		firstClickMenu = 1;
	},false);
	
	document.getElementById("user").addEventListener("click", function(event)
	{
		
	},false);
}


/*span.addEventListener("click",function(event)
    	{
    		input.style.display = "block";
    		
    	},false);*/