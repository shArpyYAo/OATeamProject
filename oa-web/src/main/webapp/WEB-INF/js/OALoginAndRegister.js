$(document).ready(function()
{
	var loginPage = $("#loginPage");
	var registerPage = $("#registerPage");
	var Login = $("#head");
	var Regin = $("#foot");
	//////////////////////////////////////////////////
	var LoginNameText = $("#nameTextLogin");
	var LoginPasswordText = $("#passwordTextLogin");
	
	var PLoginName = $("#PLoginName");
	var PLoginPassword = $("#PLoginPassword");
	
	var LoginButton = $("#LoginButton");
    /////////////////////////////////////////////////////////////////////
    var Text = new Array();
    var P = new Array;
    Text[0] = $("#emailTextRegister");
    Text[1] = $("#passwordTextRegister");
    Text[2] = $("#passwordTextRegisterComfirm");
    Text[3] = $("#nameTextRegister");
    P[0] = $("#PRegisterEmail");
    P[1] = $("#PRegisterPassword");
    P[2] = $("#PRegisterPasswordComfirm");
    P[3] = $("#PRegisterName");
    var RegisterButton = $("#RegisterButton");
   	
    
	loginPage.click(function()
	{
		Regin.css("z-index","-1");
		Login.css("z-index","1");
		LoginNameText.css("opacity","1");
		PLoginName.css("opacity","1");
		LoginPasswordText.css("opacity","1");
		PLoginPassword.css("opacity","1");
		LoginButton.css("opacity","1");
		
		Login.css("width","28%");
		Login.css("height","400px");
		Login.css("top","140%");
		Login.css("left","36%");
		
		Text[0].css("opacity","0");
		Text[1].css("opacity","0");
		Text[2].css("opacity","0");
		Text[3].css("opacity","0");
		P[0].css("opacity","0");
		P[1].css("opacity","0");
		P[2].css("opacity","0");
		P[3].css("opacity","0");
		RegisterButton.css("opacity","0");
		
		Regin.css("width","26%");
		Regin.css("height","408px");
		Regin.css("top","160%");
		Regin.css("left","40%");
	});
	
	registerPage.click(function()
	{
		Login.css("z-index","-1");
		Regin.css("z-index","1");
		
		LoginNameText.css("opacity","0");
		PLoginName.css("opacity","0");
		LoginPasswordText.css("opacity","0");
		PLoginPassword.css("opacity","0");
		LoginButton.css("opacity","0");
		
		Login.css("width","26%");
		Login.css("height","380px");
		Login.css("top","120%");
		Login.css("left","34%");
		
		Text[0].css("opacity","1");
		Text[1].css("opacity","1");
		Text[2].css("opacity","1");
		Text[3].css("opacity","1");
		P[0].css("opacity","1");
		P[1].css("opacity","1");
		P[2].css("opacity","1");
		P[3].css("opacity","1");
		RegisterButton.css("opacity","1");
		
		Regin.css("width","28%");
		Regin.css("height","420px");
		Regin.css("top","158%");
		Regin.css("left","36%");
	});
	
	LoginNameText.change(function()
	{
		if(LoginNameText.val() != '')
			PLoginName.css("display","none");
		else
			PLoginName.css("display","block");
	});
	LoginPasswordText.change(function()
	{
		if(LoginPasswordText.val() != '')
			PLoginPassword.css("display","none");
		else
			PLoginPassword.css("display","block");
	});
	
	for(let i = 0;i < 4;i++)
	{
		Text[i].change(function()
		{
			/*alert(i)*/
			if(Text[i].val() != '')
				P[i].css("display","none");
			else
				P[i].css("display","block");
		});
	}
	function isEmail(str)
	{
		var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
		return reg.test(str); 
	} 
	Text[0].blur(function()
	{
		var temp = Text[0].val();
		if(isEmail(temp))
		{
			$(".demoSpan1").css("opacity","0");
		}
		else
		{
			$(".demoSpan1").css("opacity","1");
		}
	});
	document.getElementById("LoginButton").addEventListener("click",function()
	{
		$.ajax(
		{
            cache: false,
            type: "POST",
            url: "/oa-web/user/login",
            data:$('#loginForm').serialize(),
            async: false,
            error: function(request) 
            {
                alert("Connection error");
            },
            success: function(data) 
            {
            	alert("Login success:" + data);
            	if(data["status"] == 200)
            	{
            		window.location = "index1.html";
            	}
            	else if(data["status"] == 400)
            	{
            		alert(data["msg"]);
            	}
            }
        });
	},false);
	document.getElementById("RegisterButton").addEventListener("click",function()
	{
		$.ajax(
		{
            cache: false,
            type: "POST",
            url: "/oa-web/user/register",
            data:$('#registerForm').serialize(),
            async: false,
            error: function(request) 
            {
                alert("Connection error");
            },
            success: function(data) 
            {
            	if(data["status"] == 200)
            	{
            		window.location = "index1.html";
            	}
            	else if(data["status"] == 400)
            	{
            		alert(data["msg"]);
            	}
            }
        });
	},false);
});
