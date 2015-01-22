<!doctype html>
<%@ include file='/cloud/apl/public.inc'%>
<jh:define source="&basePage.user" alias="base"></jh:define>
<html>
<head>
    <meta charset="utf-8">
    <title>17173游戏学院 - 后台管理系统</title>
<jsp:include page="/manage/common/newIncloud.jsp"></jsp:include>
<script type="text/javascript" src="/manage/ajs/myselfJs.js" ></script>
</head>
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
	
	menu = replaceNbsp($("#five").children(".sub-menu").html());
	if(menu == ''){$("#five").hide();}
	menu = replaceNbsp($("#six").children(".sub-menu").html());
	if(menu == ''){$("#six").hide();}
	menu = replaceNbsp($("#seven").children(".sub-menu").html());
	if(menu == ''){$("#seven").hide();}
	menu = replaceNbsp($("#eight").children(".sub-menu").html());
	if(menu == ''){$("#eight").hide();}
	getAllAuditNumber();
}
setInterval(function() { 
	getAllAuditNumber();
},1000*60);
function getAllAuditNumber(){
        var url = "/manage/product/home/Home.wa?do=selectManageAuditNumber&date="+new Date().valueOf();
		$.ajax({
		   type: "POST",
		   url:url,
		   success: function(msg){
			   var audit = toJsonObject(msg);	
			   var versionAudit =parseInt(audit.versionAuditNumber);
			   $("#versionAudit").html(versionAudit);
			   var allNumber = versionAudit;
			   $("#allNumber").html(allNumber);
		   },
		   fail:function(){
			 alert("error");
		   }
		});
}
</script>
<body bgcolor="#198bc9" onLoad="checkHtml()">
<div id="cy_left">
        <!-- 导航 开始 -->
   <ul id="accordion" class="accordion">
    <li id="one" class="files">
      <a href="#">权限管理</a>
      <ul class="sub-menu">
         <jh:equals source="manage.module" value="&basePage.menuString"><li><a href="/manage/module/Module.wa" target="right" >模块管理</a></li></jh:equals>
         </jh:equals>
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