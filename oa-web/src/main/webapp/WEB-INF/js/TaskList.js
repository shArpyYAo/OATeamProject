var TaskArea = document.getElementById("TaskArea");
var OnOff = 0;
window.onload = function()
{
	var main = document.getElementById("main");
	var menuButton = document.getElementById("menuButton");
	var menu = document.getElementById("menu");
	var li = menu.getElementsByTagName("li");
	var overLay = document.getElementById("overLay");
	var top = document.getElementById("top");
	
	var TaskList;/* = TaskArea.children;*/
	var divTask;
	var MousePositionX;
	var MousePositionY;
	var Biggest = 0;
	var InMove = 0;
	var Task = new Array(100);
	var next = new Array(100);
	var index; /*= new Array(TaskList.length * 2);*/
	var TotalLength = 0;
	var Selected;
	var url = window.location.href;
	var borderNo = url.substring(url.lastIndexOf('=')+1, url.length);
	var json,first = 1,updateBor = 0,div,len,t;
	initPersonalJsonData(div,len,t);
	
	function findBiggest()
	{
		for(let i = 1;i < TaskList.length + 1;i++)
		{
			divTask = TaskList[i - 1].children;
			if(divTask.length >= Biggest)
			{
				Biggest = divTask.length;
			}
		}
	}
	
	function updateBorder(div,len,t,json)
	{
		alert(div);
		alert(len);
		alert(t);
		alert(json["data"]["lists"][t]["cards"][len - 1]["cardNo"])
		div.setAttribute("idvalue",json["data"]["lists"][t]["cards"][len - 1]["cardNo"]);
		updateBor = 0;
	}
	
	function initPersonalJsonData(div,len,t)
	{
		$.ajax(
		{
	        cache: false,
	        type: "post",
	        dataType: "json",
	        url: "/oa-web/board/findBoard/" + borderNo,
	        error: function(request) 
	        {
	            alert("Connection error");
	        },
	        success: function(data) 
	        {
	        	//alert("Connection ok:" + data["data"]["lists"].length);
	        	json = data;
	        	if(first == 1)
	        		init();
	        	if(updateBor == 1)
	        		updateBorder(div,len,t,json);
	        }
	    });
	}
	
	function init()
	{
		var temp = 0;
		var StartAndEnd = 0;
		var temp1 = 0;
		cList(json["data"]["lists"].length);
		TaskList = TaskArea.children;
		index = new Array(TaskList.length * 2);
		findBiggest();
		for(let i = 1;i < TaskList.length + 1;i++)
		{
			cBorder(i, json["data"]["lists"][i - 1]["cards"].length,json["data"]["lists"][i - 1]);
			cForm("#","添加卡片", i, temp1++,json);
			cForm("#","删除列表", i, temp1++,json);
			cTitleForm("#",json["data"]["lists"][i - 1]["listName"],"保存",i);
			divTask = TaskList[i - 1].children;
			index[StartAndEnd] = temp;
			StartAndEnd++;
			for(let j = 0; j < divTask.length;j++)
			{
				$("#" + divTask[j].id).css("width","240px");
				$("#" + divTask[j].id).css("height","100px");
				$("#" + divTask[j].id).css("position","absolute");
				$("#" + divTask[j].id).css("background","lightsteelblue");
				$("#" + divTask[j].id).css("borderRadius","4px");
				$("#" + divTask[j].id).css("top",((j * 110) + 90) + "px");
				$("#" + divTask[j].id).css("left",(((i - 1) * 318) + 66) + "px");
				Task[temp] = divTask[j].id;
				next[temp] = temp + 1;
				if(i == TaskList.length && j == divTask.length - 1)
				{
					next[temp] = 0;
				}
				temp++;
			}
			index[StartAndEnd] = temp - 1;
			StartAndEnd++;
			if(divTask.length == Biggest)
			{
				if(document.getElementById("TaskList" + i))
				{
					$("#TaskList" + i).css("height",(divTask.length * 110) + 20 + "px");
				}
			}
			else
			{
				if(document.getElementById("TaskList" + i))
				{
					$("#TaskList" + i).css("height",(divTask.length * 110) + 10 + "px");
					$("#TaskList" + i).css("margin-bottom",((Biggest - divTask.length) * 110) + 10 + "px");
				}
			}
			TotalLength = TotalLength + divTask.length;
		}
		/*for(let i = 0;i < 4;i++)
		{
			alert(index[i]);
		}*/
		for(let j = 0;j < TaskList.length;j++)
		{
			divTask = TaskList[j].children;
			for(let i = 0;i < divTask.length;i++)
			{
				divTask[i].addEventListener("mousedown", function(event)
				{
					OnOff = 1;
					MousePositionX = event.clientX;
					MousePositionY = event.clientY;
					TaskArea.addEventListener("mousemove",mouseMove,false);
				},false);
				divTask[i].addEventListener("mouseup", function(event)
				{
					//alert("松开");
					OnOff = 0;
					mouseMove(event);
					TaskArea.removeEventListener("mousemove",mouseMove,false);
				},false);
				
				divTask[i].addEventListener("mouseover", function(event)
				{
					$("#" + this.id).css("background","cadetblue");
					$("#" + this.id).css("boxShadow","4px 4px 2px #c0c0c0");
				},false);
				divTask[i].addEventListener("mouseout", function(event)
				{
					$("#" + this.id).css("background","lightsteelblue");
					$("#" + this.id).css("boxShadow","none");
				},false);
				document.getElementById("TaskList" + (j + 1) + "TaskDelete" + (i + 1)).addEventListener("click",function(event)
				{
					deleteBorder(event, j,json);
				},false);
			}
		}
	}
	
	function addBorder(temp, event)
	{
		var div;
		var list;
		var tt;
		var k = 0;
		var img,h3,listNo;
		listNo = json["data"]["lists"][temp]["listNo"];
		//alert(listNo);
		div = document.createElement("div");
		list = document.getElementById("TaskList" + (temp + 1));
		div.id = "TaskList" + (temp + 1) + "Task" + (list.children.length + 1);
		img = document.createElement("img");
		img.id = "TaskList" + (temp + 1) + "TaskDelete" + (list.children.length + 1);
		img.className = "rubish";
		img.src = "../img/rubish.png";
		h3 = document.createElement("h3");
		h3.innerHTML = "新建卡片";
		list.appendChild(div);
		div.appendChild(img);
		div.appendChild(h3);
		document.getElementById(img.id).addEventListener("click",function(event)
		{
			alert("temp:" + temp);
			deleteBorder(event, temp,json);
			alert("here1");
		},false);
////////////////////////////////////////////////////////////
		$.ajax(
		{
	        cache: false,
	        type: "post",
	        dataType: "json",
	        url: "/oa-web/card/addCard",
	        data:
	        {
	        	cardName:"新建卡片",
	        	listNo:listNo
	        },
	        error: function(request) 
	        {
	            alert("Connection error");
	        },
	        success: function(data) 
	        {
	        	//alert("Connection ok:" + data["msg"]);
	        	var len;
	        	first = 0;
	        	updateBor = 1;
	        	len = json["data"]["lists"][temp]["cards"].length;
	        	initPersonalJsonData(div,len,temp);
	        }
	    });		
	////////////////////////////////////////////////////////////
		divTask = TaskList[temp].children;
		//alert(divTask.length);next,//task index
		Task[TotalLength] = div.id;
		
		next[TotalLength] = index[temp * 2];
		//alert("index[" + temp * 2 +"]:" + index[temp * 2]);
		while(k != -1)
		{
			if(next[k] == index[temp * 2])
			{
				break;
			}
			k = next[k];
		}
		//alert("k:" + k);
		next[k] = TotalLength;
		index[temp * 2] = TotalLength;
		/*for(let i = 0;i <= TotalLength;i++)
		{
			alert("2.next[" + i + "]:" + next[i]);
		}*/
		TotalLength++;
		$("#" + div.id).css("width","240px");
		$("#" + div.id).css("height","100px");
		$("#" + div.id).css("position","absolute");
		$("#" + div.id).css("background","lightsteelblue");
		$("#" + div.id).css("borderRadius","4px");
		$("#" + div.id).css("left",((temp * 318) + 66) + "px");
		temp = temp * 2;
		BeginPaintting(temp,temp + 1);
		AllTaskListInit();
		div.addEventListener("mouseover", function(event)
		{
			$("#" + this.id).css("background","cadetblue");
			$("#" + this.id).css("boxShadow","4px 4px 2px #c0c0c0");
		},false);
		div.addEventListener("mouseout", function(event)
		{
			$("#" + this.id).css("background","lightsteelblue");
			$("#" + this.id).css("boxShadow","none");
		},false);
		div.addEventListener("mousedown", function(event)
		{
			OnOff = 1;
			MousePositionX = event.clientX;
			MousePositionY = event.clientY;
			TaskArea.addEventListener("mousemove",mouseMove,false);
		},false);
		div.addEventListener("mouseup", function(event)
		{
			OnOff = 0;
			mouseMove(event);
			TaskArea.removeEventListener("mousemove",mouseMove,false);
		},false);
	}
	function deleteBorder(event, IndexJ,json)
	{
		var id;
		var rubish
		var par;
		var granpar;
		var k = 0;
		var last;
		var temp,cardNo;
		//cardNo = json["data"]["list"]
		id = event.target.getAttribute("id");
		alert(id);
		rubish = document.getElementById(id);
		alert("rubish:" + rubish.id);
		par = document.getElementById(id).parentNode;
		alert("par:" + rubish.id);
		cardNo = par.attributes["idvalue"].nodeValue;
		alert("cardNo:" + cardNo);
		granpar = document.getElementById(par.id).parentNode;
		alert("granpar:" + granpar.id);
		par.removeChild(rubish);
		alert("delete rubish");
		granpar.removeChild(par);
		alert("delete par");
////////////////////////////////////////////////////////////
		$.ajax(
		{
	        cache: false,
	        type: "post",
	        dataType: "json",
	        url: "/oa-web/card/deleteCard",
	        data:
	        {
	        	cardNo:cardNo
	        },
	        error: function(request) 
	        {
	            alert("Connection error");
	        },
	        success: function(data) 
	        {
	        	alert("Connection ok:" + data["msg"]);
	        }
	    });		
////////////////////////////////////////////////////////////////
		/*var i;
		i = new FormData*/
		while(k != -1)
		{
			if(Task[k] == par.id)
			{
				break;
			}
			last = k;
			k = next[k];
		}
		if(Task[index[IndexJ * 2]] == par.id && index[(IndexJ * 2) + 1] != index[IndexJ * 2])
		{
			index[IndexJ * 2] = next[index[IndexJ * 2]];
		}
		else if(Task[index[(IndexJ * 2) + 1]] == par.id && index[(IndexJ * 2) + 1] != index[IndexJ * 2])
		{
			index[(IndexJ * 2) + 1] = last;
		}
		else if(index[(IndexJ * 2) + 1] == index[IndexJ * 2])
		{
			index[(IndexJ * 2) + 1] = -1;
			index[IndexJ * 2] = -1;
		}
		Task[k] = 0;
		temp = next[k];
		next[last] = temp;
		AllTaskListInit();
	}
	function deleteList(temp, event)
	{
		if(TaskList.length == temp + 1)
		{
			var k = 0;
			/*var list = document.getElementById("TaskList" + (temp + 1));
			TaskArea.removeChild(list);*/
			var form1 = document.getElementById("List" + (temp * 2));
			top.removeChild(form1);
			form1 = document.getElementById("List" + ((temp * 2) + 1));
			top.removeChild(form1);
			form1 = document.getElementById("ListTitle" + temp);
			top.removeChild(form1);
			
			/*if(index[temp * 2] != -1)
			{
				while(k != -1)
				{
					if(next[k] == index[temp * 2])
					{
						break;
					}
					k = next[k];
				}
				next[k] = index[((temp * 2) + 1)];
				index[temp * 2] = -2;
				index[((temp * 2) + 1)] = -2;
				AllTaskListInit();
			}
			AllTaskListInit();*/
		}
		else
		{
			
		}
	}
	function cForm(url, value, temp, id,json)
	{
		temp--;
		//var form;
		var input1;
		input1 = document.createElement("input");
		/*form = document.createElement("form");
		form.action = url;
		form.method = "get";
		form.className = "List";
		form.id = "List" + id;*/
		top.appendChild(input1);
		input1.type = "submit"; 
		input1.className = "Listsubmit"; 
		if(value == "删除列表")
		{
			input1.id = "ListsubmitDelete" + temp;
		}
		else
		{
			input1.id = "Listsubmit" + temp;
		}
		input1.value = value;
		//form.appendChild(input1); 
		$(".Listsubmit").css("top","40px");//40
		if(temp == 0)
		{	
			if(value == "添加卡片")
			{
				$("#Listsubmit" + temp).css("left","218px");
				document.getElementById("Listsubmit" + temp).addEventListener("mouseup",function(event)
				{
					addBorder(temp,event);
				},false);
			}
			if(value == "删除列表")
			{
				$("#ListsubmitDelete" + temp).css("left","55px");
				document.getElementById("ListsubmitDelete" + temp).addEventListener("mouseup",function(event)
				{
					deleteList(temp,event);
				},false);
			}
		}
		else
		{
			if(value == "添加卡片")
			{
				$("#Listsubmit" + temp).css("left",(318 * temp) + 219 + "px");
				document.getElementById("Listsubmit" + temp).addEventListener("mouseup",function(event)
				{
					addBorder(temp,event);
				},false);
			}
			if(value == "删除列表")
			{
				$("#ListsubmitDelete" + temp).css("left",(318 * temp) + 55 + "px");
				document.getElementById("ListsubmitDelete" + temp).addEventListener("mouseup",function(event)
				{
					deleteList(temp,event);
				},false);
			}
		}
	}
	function cTitleForm(url, value1, value2, temp)
	{
		//var form;
		var input1;
		var input2;
		var span;
		temp--;
		input1 = document.createElement("input");
		input2 = document.createElement("input");
		//form = document.createElement("form");
		span = document.createElement("span");
		/*form.action = url;
		form.method = "get";
		form.className = "ListTitle";
		form.id = "ListTitle" + temp;*/
		//top.appendChild(form);
		input1.type = "text"; 
		input1.className = "ListTitleInput";
		input1.id = "ListTitleInput" + temp;
		input1.value = value1;
		span.className = "ListTitleInputSpan";
		span.id = "ListTitleInputSpan" + temp;
		span.innerHTML = input1.value;
		input2.type = "submit"; 
		input2.id = "ListTitleSubmit" + temp;
		input2.className = "ListTitleSubmit";
		input2.value = value2;
		top.appendChild(input1);
		top.appendChild(input2);
		top.appendChild(span);
		if(temp > 0)
		{
			$("#ListTitleInput" + temp).css("left",(((315 * temp) + 75) + temp * 8) + "px");
			$("#ListTitleInputSpan" + temp).css("left",318 * temp + "px");
			$("#ListTitleSubmit" + temp).css("left",((315 * temp) + 120) + temp * 6 + "px");
		}
		document.getElementById("ListTitleInputSpan" + temp).addEventListener("click", function()
		{
			if(document.getElementById("ListTitleInput" + temp).style.display == "block")
			{
				$("#ListTitleInput" + temp).css("display","none");
				$("#ListTitleSubmit" + temp).css("display","none");
			}
			else
			{
				$("#ListTitleInput" + temp).css("display","block");
				$("#ListTitleSubmit" + temp).css("display","block");
			}
			
		},false);
	}
	function cBorder(i,num,jsonMin)
	{
		var div;
		var list;
		var img,h3;
		list = document.getElementById("TaskList" + i);
		for(let k = 1;k <= num;k++)
		{
			div = document.createElement("div");
			div.id = "TaskList" + i + "Task" + k;
			div.setAttribute("idvalue",jsonMin["cards"][k - 1]["cardNo"]);
			//alert(div.attributes["idvalue"].nodeValue);
			img = document.createElement("img");
			img.id = "TaskList" + i + "TaskDelete" + k;
			img.className = "rubish";
			img.src = "../img/rubish.png";
			h3 = document.createElement("h3");
			h3.innerHTML = jsonMin["cards"][k - 1]["cardTitle"];
			list.appendChild(div);
			div.appendChild(h3);
			list.appendChild(div);
			div.appendChild(img);
		}
		
	}
	function cList(num)
	{
		var div;
		for(let k = 1;k <= num;k++)
		{
			div = document.createElement("div");
			div.id = "TaskList" + k;
			TaskArea.appendChild(div);
		}
	}
	
	function ConfirmTarget(id ,Selected)
	{
		for(let i = 0;i < TotalLength;i++)
		{
			if(id == Task[i])
			{
				Selected = i;
			}
		}
		return Selected;
	}
	function ConfirmLast(Start,End,x,num,indexStart)//判断插入的是不是最后一个位置
	{
		var t = indexStart;
		var beforeNum = 0;
		while(t != -1)
		{
			beforeNum++;
			if(next[t] == index[End])
			{
				break;
			}
			t = next[t];
		}
		beforeNum++;
		//alert("beforeNum:" + beforeNum);
		if(num >= beforeNum && index[Start] != -1)//如果是最后一个
		{
			return beforeNum;
		}
		else if (index[Start] == index[End] && index[Start] != -1)//如果队列只有一个
		{
			return 1;
		}
		else if(index[Start] == -1)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
	function ChangeHeadAndTail(sele)
	{
		var t;
		var jiou = 0;
		for(let i = 0;i < TaskList.length * 2;i++)
		{
			if(index[i] == sele && i % 2 == 0)
			{
				jiou = 1;
				index[i] = next[sele];
			}
			else if(index[i] == sele && i % 2 != 0)
			{
				if(jiou == 1)
				{
					index[i] = -1;
					index[i - 1] = -1;
					jiou = 0;
					break;
				}
				t = 0;
				while(t != -1)
				{
					if(next[t] == sele)
					{
						index[i] = t;
						break;
					}
					t = next[t];
				}
			}
		}
		/*for(let i = 0;i < 4;i++)
		{
			alert("1.index：" + index[i]);
		}*/
	}
	function FindInsertPosition(sele, time, t, num, Start, indexStart,last,End)
	{
		/*if(last > 0)
		{
			num--;
		}*/
		while(t != -1)//找到要插入的位置
		{
			if(num == 0)//如果插入的是最前面
			{
				//index[0] = sele;
				t = 0;
				while(t != -1)
				{
					if(next[t] == indexStart)
					{
						index[Start] = sele;
						break;
					}
					t = next[t];
				}
				break;
			}
			time++;
			if(num == time)
			{
				break;
			}
			t = next[t];
			
		}
		//alert("num:" + num);
		return t;
	}
	function Insert(num, sele, Start,End, last,indexStart)//插入
	{
		var temp = 0;
		var temp1;
		var time = 0;
		var InPosition;
		var i;
		var t;
		ChangeHeadAndTail(sele);
		if(last > 0)//如果插入的是最后面
		{
			index[End] = sele;
			//alert("Insert:last" + last);
		}
		if(index[Start] == -1)
		{
			index[Start] = sele;
			index[End] = sele;
			//alert("End:" + End);
			i = 0;
			time = 0;
			temp = next[sele];//脱落现在的位置
			while(i != -1)
			{
				if(next[i] == sele)
				{
					next[i] = temp;
					break;
				}
				i = next[i];
			}
			temp1 = next[index[Start - 1]];
			next[sele] = temp1;
			next[index[Start - 1]] = sele;
		}
		else
		{
			t = index[Start];
			indexStart = index[Start];
		 	t = FindInsertPosition(sele, time, t, num, Start, indexStart,last,End);
		 	//index[Start] = indexStart;//先把第一个div开头标记改回来
			if(next[t] != sele)//如果插入的位置不在原地的话
			{
				i = 0;
				time = 0;
				temp = next[sele];//脱落现在的位置
				while(i != -1)
				{
					if(next[i] == sele)
					{
						next[i] = temp;
						break;
					}
					i = next[i];
				}
				t = indexStart;
				t = FindInsertPosition(sele, time, t, num, Start, indexStart,last,End);
				temp1 = next[t];
				next[t] = sele;
				next[sele] = temp1;
			}
		}
	}
	function BeginPaintting(Start,End)
	{
		var t;
		var num;
		t = index[Start];
		num = -1;
		while(t != -1)
		{
			//从该任务列表开始
			if(t == index[End])
			{
				break;
			}
			num++;
			$("#" + Task[t]).css("top",num * 110 + 90 + "px");
			t = next[t];
		}
		num++;
		$("#" + Task[t]).css("top",num * 110 + 90 + "px");
	}
	function Paintting(Start, End, id, clientX, number,indexStart)
	{
		var last = 0;
		var t;
		Selected = ConfirmTarget(id,Selected);
		t = Selected;
		last = ConfirmLast(Start,End,event.clientX,number,indexStart);
		//alert("last:" + last);
		if(last > 0)
			number = last;
		else if(last == -1)
			number = 0;
		if(number > 0)
		{
			$("#" + id).css("top", number * 110 + 90 + "px");
			if(last > 0)
			{
				Insert(number, Selected, Start,End,last,indexStart);
				BeginPaintting(Start,End);
			}
			else
			{
				Insert(number, Selected, Start,End,last,indexStart);
				BeginPaintting(Start,End);
			}
		}
		else
		{
			$("#" + id).css("top", number * 110 + 90 + "px");
			Insert(number, Selected, Start,End,last,indexStart);
			while(t != -1)
			{
				t = next[t];
				if(t == index[End])
				{
					break;
				}
				number++;
				$("#" + Task[t]).css("top",number * 110 + 90 + "px");
			}
			number++;
			$("#" + Task[t]).css("top",number * 110 + 90 + "px");
		}
		
	}
	function AllTaskListInit()
	{
		var i = 0;
		var temp;
		var num;
		var RecordNum = 0;
		var list  = 1;
		while(i != index.length)
		{
			if(index[i] != -1 && index[i] != index[i + 1])
			{
				num = 0;
				if(num + 1 > RecordNum)
				{
					RecordNum = num + 1;
				}
			}
			i = i + 2;
		}
		i = 0;
		while(i != index.length)
		{
			if(index[i] == -1)
			{
				//alert("here1");
				//continue;
				if(document.getElementById("TaskList" + list))
				{
					$("#TaskList" + list).css("margin-bottom",((RecordNum - 1) * 110) + 10 + "px");
					list++;
				}
			}
			else if(index[i] == index[i + 1])
			{
				//alert("here2");
				$("#" + Task[index[i]]).css("top", 90 + "px");
				if(document.getElementById("TaskList" + list))
				{
					$("#TaskList" + list).css("height",110 + 20 + "px");
					$("#TaskList" + list).css("margin-bottom",((RecordNum - 1) * 110) + 10 + "px");
					list++;
				}
			}
			else
			{
				num = 0;
				//alert("here3");
				temp = index[i];
				while(temp != -1)
				{
					$("#" + Task[temp]).css("top", num * 110 + 90 + "px");
					if(temp == index[i + 1])
						break;
					temp = next[temp];
					num++;
				}
				/*alert("RecordNum:" + RecordNum);
				alert("num:" + num);*/
				if(document.getElementById("TaskList" + list))
				{
					$("#TaskList" + list).css("height",((num + 1) * 110) + 20 + "px");
					$("#TaskList" + list).css("margin-bottom",((RecordNum - (num + 1)) * 110) + 10 + "px");
					list++;
				}
				/*for(let i = 0;i < 4;i++)
				{
					alert("AllTaskListInit.index：" + index[i]);
				}*/
			}
			i = i + 2;
		}
	}
	function mouseMove(event)
	{
		var id;
		//var t;
		//var last = 0;
		var number;
		if(OnOff == 1)
		{
			InMove = 1;
			id = event.target.getAttribute("id");
			$("#" + id).css("boxShadow","none");
			$("#" + id).css("left",event.clientX - 430 + "px");
			$("#" + id).css("top",event.clientY - 50 + "px");
			$("#" + id).css("z-index", "10");
		}
		else if(InMove == 1)
		{
			id = event.target.getAttribute("id");
			$("#" + id).css("z-index", "1");
			if(event.clientX <= 580)
			{
				number = Math.floor(event.clientY / 110);
				$("#" + id).css("left","66px");
				Paintting(0, 1, id, event.clientX, number,index[0]);
				AllTaskListInit();
				/*for(let i = 0;i < 6;i++)
				{
					alert("next：" + next[i]);
				}
				for(let i = 0;i < 4;i++)
				{
					alert("2.index：" + index[i]);
				}*/
			}
			else if(event.clientX <= 900 && event.clientX >= 620)
			{
				$("#" + id).css("left","384px");
				number = Math.floor(event.clientY / 110);
				Paintting(2, 3, id, event.clientX, number,index[2]);
				AllTaskListInit();
			}
			else if(event.clientX <= 1220 && event.clientX >= 940)
			{
				$("#" + id).css("left","702px");
				number = Math.floor(event.clientY / 110);
				Paintting(4, 5, id, event.clientX, number,index[4]);
				AllTaskListInit();
			}
			else if(event.clientX > 1220)
			{
				$("#" + id).css("left","1020px");
				number = Math.floor(event.clientY / 110);
				Paintting(6, 7, id, event.clientX, number,index[6]);
				AllTaskListInit();
			}
			
			InMove = 0;
		}
	}
	
	/*for(let j = 0;j < TaskList.length;j++)
	{
		divTask = TaskList[j].children;
		for(let i = 0;i < divTask.length;i++)
		{
			divTask[i].addEventListener("mousedown", function(event)
			{
				OnOff = 1;
				MousePositionX = event.clientX;
				MousePositionY = event.clientY;
				TaskArea.addEventListener("mousemove",mouseMove,false);
			},false);
			divTask[i].addEventListener("mouseup", function(event)
			{
				//alert("松开");
				OnOff = 0;
				mouseMove(event);
				TaskArea.removeEventListener("mousemove",mouseMove,false);
			},false);
			
			divTask[i].addEventListener("mouseover", function(event)
			{
				$("#" + this.id).css("background","cadetblue");
				$("#" + this.id).css("boxShadow","4px 4px 2px #c0c0c0");
			},false);
			divTask[i].addEventListener("mouseout", function(event)
			{
				$("#" + this.id).css("background","lightsteelblue");
				$("#" + this.id).css("boxShadow","none");
			},false);
			document.getElementById("TaskList" + (j + 1) + "TaskDelete" + (i + 1)).addEventListener("click",function(event)
			{
				deleteBorder(event, j,json);
			},false);
		}
	}*/
	
	
	
	menuButton.addEventListener("mouseover", function(event)
	{
		$(".Click").css("animation",	 "shakeClick 0.3s infinite");
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