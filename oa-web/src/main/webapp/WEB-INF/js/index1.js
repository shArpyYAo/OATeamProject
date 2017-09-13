window.onload = function()
{
	var main = document.getElementById("main");
	var menuButton = document.getElementById("menuButton");
	var menu = document.getElementById("menu");
	var li = menu.getElementsByTagName("li");
	var overLay = document.getElementById("overLay");
	var borderList = document.getElementById("boardList");
	
	function fomatFloat(src,pos)
	{   
       return Math.round(src*Math.pow(10, pos))/Math.pow(10, pos);   
    } 
	
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
        	//alert("Connection success");
        	initAll(data);
        	//data["status"]
        	//data["data"][0][""]
        }
    });
	
	function initProAndBorder(title, ul, json)
	{
		var li,a,span,id,span,div,h3,temp;
		for(let i = 0;i < json["data"].length;i++)
		{
			li = document.createElement("li");
			a = document.createElement("a");
			a.id = "proName" + i;
			span = document.createElement("span");
			span.className = "demoSpanX";
			a.innerHTML = json["data"][i]["boardSpaceName"];
			li.appendChild(a);
			li.appendChild(span);
			ul.appendChild(li);
			a.addEventListener("click",function(event)
			{
				id = event.target.getAttribute("id");
				title.innerHTML = document.getElementById(id).innerHTML;
				temp = id.replace(/[^0-9]/ig,"");
				$("#boardList div").css("display","none");
				$(".div" + temp).css("display","inline-block");
			},false);
			for(let j = 0;j < json["data"][i]["tBoard"].length;j++)
			{
				div = document.createElement("div");
				h3 = document.createElement("h3");
				h3.innerHTML = json["data"][i]["tBoard"][j]["boardName"];
				span = document.createElement("span");
				span.className = "demoSpanX";
				div.appendChild(h3);
				div.appendChild(span);
				if(i != 0)
					div.style.display = "none";
				div.className = "div" + i;
				boardList.appendChild(div);
			}
			div = document.createElement("div");
			span = document.createElement("span");
			h3 = document.createElement("h3");
			span.className = "demoSpanJ";
			div.appendChild(h3);
			div.appendChild(span);
			if(i != 0)
				div.style.display = "none";
			div.className = "div" + i;
			boardList.appendChild(div);
		}
	}
	
	function initAll(json)
	{
		var title = document.getElementById("title");
		var ul = document.getElementById("proUl");
		var boardList = document.getElementById("boardList");
		initProAndBorder(title, ul, json);
		title.innerHTML = json["data"][0]["boardSpaceName"];
		
		var temp = borderList.children;
		var s = 0.2;
		for(let i = 0;i < borderList.children.length;i++)
		{
			temp[i].style.animation = "borderAppear 0.6s " + s + "s";
			temp[i].style.animationFillMode = "forwards";
			s = s + 0.2;
			s = fomatFloat(s, 1)
		}
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
		$("#main").css("-webkit-transform", "none");
		$("#main").css("-moz-transform", "none");
		$("#main").css("-ms-transform", "none");
		$("#main").css("transform", "none");
		$("#menu").css("left", "-300px");
		overLay.style.display = "none";
		for(let i = 0;i < li.length;i++)
		{
			li[i].style.animation = "none";
		}
	},false);
}
