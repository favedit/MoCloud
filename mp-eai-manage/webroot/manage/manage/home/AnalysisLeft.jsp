<!doctype html>
<%@ include file='/cloud/apl/public.inc'%>
<jh:define source="&basePage.user" alias="base"></jh:define>
<html>
<head>
    <meta charset="utf-8">
    <title>17173网络学院后台管理系统</title>
<jsp:include page="/cloud/manage/common/newIncloud.jsp"></jsp:include>
<script type="text/javascript" src="/cloud/ajs/myselfJs.js" ></script>
<script>
var flag = "<jh:write source='&base.ouid' />";
if(flag == ""){
	 alert("连接超时！");
	 parent.parent.location.href="/cloud/home/Frame.wa";	
}
function checkHtml(){
	var menu = replaceNbsp($("#one").children(".sub-menu").html());
	if(menu == ''){$("#one").hide();}
	menu = replaceNbsp($("#two").children(".sub-menu").html());
	if(menu == ''){$("#two").hide();}
	menu = replaceNbsp($("#three").children(".sub-menu").html());
	if(menu == ''){$("#three").hide();}
	menu = replaceNbsp($("#four").children(".sub-menu").html());
	if(menu == ''){$("#four").hide();}
	menu = replaceNbsp($("#six").children(".sub-menu").html());
	if(menu == ''){$("#six").hide();}
}
</script>
</head>
<body bgcolor="#198bc9" onLoad="checkHtml()">
<div id="cy_left">
        <!-- 导航 开始 -->
         <ul class="accordion">
    <li id="one" class="files"> <a href="#one">用户分析</a>
      <ul class="sub-menu">
       <jh:equals source="analysis.user.register" value="&basePage.menuString"><li><a href="/cloud/analysis/user/UserRegister.wa" target="right" >用户注册</a></li></jh:equals>
       <jh:equals source="analysis.user.loginout" value="&basePage.menuString"><li><a href="/cloud/analysis/user/UserLoginout.wa" target="right" >用户登陆</a></li></jh:equals>
       <jh:equals source="analysis.activity" value="&basePage.menuString"><li><a href="/cloud/analysis/activity/Activity.wa" target="right" >活动统计</a></li></jh:equals>
      </ul>
    </li>
  </ul>
        <!-- 导航 结束 -->
</div>
  <script type="text/javascript">
		$(document).ready(function() {
			// Store variables
			var accordion_head = $('.accordion > li > a'),
				accordion_body = $('.accordion li > .sub-menu');
			// Open the first tab on load
			accordion_head.first().addClass('active').next().slideDown('normal');
			// Click function
			accordion_head.on('click', function(event) {
				// Disable header links
				event.preventDefault();
				// Show and hide the tabs on click
				if ($(this).attr('class') != 'active'){
					accordion_body.slideUp('normal');
					$(this).next().stop(true,true).slideToggle('normal');
					accordion_head.removeClass('active');
					$(this).addClass('active');
				}
			});
		});
	</script>
</body>
</html>