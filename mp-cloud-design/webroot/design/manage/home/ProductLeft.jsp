<!doctype html>
<%@ include file='/cloud/apl/public.inc'%>
<jh:define source="&basePage.user" alias="base"></jh:define>
<html>
<head>
    <meta charset="utf-8">
    <title>17173游戏学院 - 后台管理系统</title>
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
	menu = replaceNbsp($("#five").children(".sub-menu").html());
	if(menu == ''){$("#five").hide();}
	menu = replaceNbsp($("#six").children(".sub-menu").html());
	if(menu == ''){$("#six").hide();}
	getAllAuditNumber();
}
setInterval(function() { 
	getAllAuditNumber();
},1000*60);
function getAllAuditNumber(){
        var url = "/cloud/product/home/Home.wa?do=selectProductAuditNumber&date="+new Date().valueOf();
		$.ajax({
		   type: "POST",
		   url:url,
		   success: function(msg){
			   var audit = toJsonObject(msg);	
			   var gameAuditNumber =parseInt(audit.gameAuditNumber);
			   var lessonAuditNumber = 	parseInt(audit.lessonAuditNumber);
			   var newsAuditNumber = parseInt(audit.newsAuditNumber);
			   var taskAuditNumber = parseInt(audit.taskAuditNumber);
			   var userTaskAuditNumber = parseInt(audit.userTaskAuditNumber);
			   var goodsAuditNumber = parseInt(audit.goodsAuditNumber);
			   var bountyAuditNumber = parseInt(audit.bountyAuditNumber);
			   var userBountyAuditNumber = parseInt(audit.userBountyAuditNumber);
			   $("#auditGame").html(gameAuditNumber);
			   $("#auditLesson").html(lessonAuditNumber);
			   $("#auditNews").html(newsAuditNumber);
			   $("#auditTask").html(taskAuditNumber);
			   $("#auditUserTask").html(userTaskAuditNumber);
			   $("#auditGoods").html(goodsAuditNumber);
			   $("#auditBounty").html(bountyAuditNumber);
			   $("#auditUserBounty").html(userBountyAuditNumber);
			   var allNumber = gameAuditNumber+lessonAuditNumber+newsAuditNumber+taskAuditNumber+userTaskAuditNumber+goodsAuditNumber+bountyAuditNumber+userBountyAuditNumber;
			   $("#allNumber").html(allNumber);
		   },
		   fail:function(){
			 alert("error");
		   }
		});
}
</script>
</head>
<body bgcolor="#198bc9" onLoad="checkHtml()">
<div id="cy_left">
        <!-- 导航 开始 -->
  <ul class="accordion">
    <li id="one" class="common"> <a href="#one">共通管理</a>
      <ul class="sub-menu">
        <jh:equals source="logic.common.config" value="&basePage.menuString"><li><a href="/cloud/product/config/Config.wa" target="right">配置管理</a></li></jh:equals>
        <jh:equals source="logic.common.country" value="&basePage.menuString"><li><a href="/cloud/product/country/Country.wa" target="right">国家管理</a></li></jh:equals>
        <jh:equals source="logic.common.province" value="&basePage.menuString"><li><a href="/cloud/product/area/Area.wa" target="right">地区管理</a></li></jh:equals>
        <jh:equals source="logic.common.area" value="&basePage.menuString"><li><a href="/cloud/product/province/Province.wa" target="right">省份管理</a></li></jh:equals>
        <jh:equals source="logic.common.school" value="&basePage.menuString"><li><a href="/cloud/product/school/School.wa" target="right">学校管理</a></li></jh:equals>
        <jh:equals source="logic.common.ventor" value="&basePage.menuString"><li><a href="/cloud/product/vendor/Vendor.wa" target="right">提供商管理</a></li></jh:equals>
        <jh:equals source="logic.common.device" value="&basePage.menuString"><li><a href="/cloud/product/device/Device.wa" target="right">设备管理</a></li></jh:equals>
        <jh:equals source="logic.common.device.config" value="&basePage.menuString"><li><a href="/cloud/product/deviceConfig/DeviceConfig.wa" target="right">设备配置管理</a></li></jh:equals>
      </ul>
    </li>
    <li id="two" class="classify"> <a href="#two">分类管理</a>
      <ul class="sub-menu">
        <jh:equals source="logic.resource.module" value="&basePage.menuString"><li><a href="/cloud/product/resource/module/ResourceModule.wa" target="right">模块管理</a></li></jh:equals>
        <jh:equals source="logic.resource.channel" value="&basePage.menuString"><li><a href="/cloud/product/resource/channel/ResourceChannel.wa" target="right">频道管理</a></li></jh:equals>
        <jh:equals source="logic.resource.page" value="&basePage.menuString"><li><a href="/cloud/product/resource/page/ResourcePage.wa" target="right">分页管理</a></li></jh:equals>
        <jh:equals source="logic.resource.type" value="&basePage.menuString"><li><a href="/cloud/product/resource/type/ResourceType.wa" target="right">类型管理</a></li></jh:equals>
      </ul>
    </li>
    <li id="three" class="product"> <a href="#three">产品管理</a>
      <ul class="sub-menu">
         
         <jh:equals source="logic.product.news" value="&basePage.menuString"><li><a id="news" href="/cloud/product/news/News.wa" target="right" >资讯管理</a></li></jh:equals>
         <jh:equals source="logic.product.game" value="&basePage.menuString"><li><a href="/cloud/product/game/Game.wa" target="right" >游戏管理</a></li></jh:equals>
         <jh:equals source="logic.product.lesson" value="&basePage.menuString"><li><a href="/cloud/product/lesson/Lesson.wa" target="right" >教程管理</a></li></jh:equals>
         <jh:equals source="logic.product.task" value="&basePage.menuString"><li><a href="/cloud/product/task/Task.wa" target="right" >任务管理</a></li></jh:equals>
         <jh:equals source="logic.product.activity" value="&basePage.menuString"><li><a id="activity" href="/cloud/product/activity/Activity.wa" target="right" >活动管理</a></li></jh:equals>
         <jh:equals source="logic.product.goods" value="&basePage.menuString"><li><a id="goods" href="/cloud/product/goods/Goods.wa" target="right" >商品管理</a></li></jh:equals>
         <jh:equals source="logic.product.bounty" value="&basePage.menuString"><li><a id="bounty" href="/cloud/product/bounty/Bounty.wa" target="right" >悬赏管理</a></li></jh:equals>
      </ul>
    </li>   
    <li id="four" class="weixin"> <a href="#four">微信服务号</a>
      <ul class="sub-menu">
         <jh:equals source="external.weixin.keyword" value="&basePage.menuString"><li><a href="/cloud/product/wxkeyword/WxKeyword.wa" target="right" >关键字管理</a></li></jh:equals>
         <jh:equals source="external.weixin.reply" value="&basePage.menuString"><li><a href="/cloud/product/wxreply/WxReply.wa" target="right" >回复管理</a></li></jh:equals>
         <jh:equals source="external.weixin.menu" value="&basePage.menuString"><li><a href="/cloud/product/wxmenu/WxMenu.wa" target="right" >菜单管理</a></li></jh:equals>
      </ul>
    </li>    
     <li id="five" class="examine"> <a href="#five">用户管理</a>
      <ul class="sub-menu">
       <jh:equals source="logic.product.user" value="&basePage.menuString"><li><a href="/cloud/product/user/User.wa" target="right" >用户管理</a></li></jh:equals>
       <jh:equals source="logic.product.userGoods" value="&basePage.menuString"><li><a href="/cloud/product/userGoods/UserGoods.wa" target="right" >用户商品</a></li></jh:equals>
       <jh:equals source="logic.product.user" value="&basePage.menuString"><li><a href="/cloud/product/user/User.wa?adjustSchool=1" target="right" >学校修正</a></li></jh:equals>
       <jh:equals source="logic.product.user.teacher" value="&basePage.menuString"><li><a href="/cloud/product/starTeacher/StarTeacher.wa" target="right" >明星导师</a></li></jh:equals>
       <jh:equals source="logic.product.user.student" value="&basePage.menuString"><li><a href="/cloud/product/starStudent/StarStudent.wa" target="right" >明星学员</a></li></jh:equals>
       <jh:equals source="logic.product.feedback" value="&basePage.menuString"><li><a href="/cloud/product/feedback/Feedback.wa" target="right" >用户反馈</a></li></jh:equals>
      </ul>
    </li>
     <li id="six" class="examine"> <a href="#six">流程管理(<span id="allNumber" style="color:#F00"></span>)</a>
      <ul class="sub-menu">
       <jh:equals source="logic.examine.game" value="&basePage.menuString"><li><a href="/cloud/product/examine/game/Game.wa" target="right" >游戏审批
       (<span id="auditGame" style="color:#F00"></span>)</a>
       </li></jh:equals>
       <jh:equals source="logic.examine.lesson" value="&basePage.menuString"><li><a href="/cloud/product/examine/lesson/Lesson.wa" target="right" >教程审批
       (<span id="auditLesson" style="color:#F00"></span>)</a></li></jh:equals>
       <jh:equals source="logic.examine.news" value="&basePage.menuString"><li><a href="/cloud/product/examine/news/News.wa" target="right" >资讯审批
       (<span id="auditNews" style="color:#F00"></span>)</a></li></jh:equals>
       
       <jh:equals source="logic.examine.task" value="&basePage.menuString"><li><a href="/cloud/product/examine/task/Task.wa" target="right" >任务审批
       (<span id="auditTask" style="color:#F00"></span>)</a></li></jh:equals>
       
       <jh:equals source="logic.examine.userTask" value="&basePage.menuString"><li><a href="/cloud/product/examine/usertask/UserTask.wa" target="right" >
       用户任务审批(<span id="auditUserTask" style="color:#F00"></span>)</a></li></jh:equals>
        <jh:equals source="logic.examine.goods" value="&basePage.menuString"><li><a href="/cloud/product/examine/goods/Goods.wa" target="right" >商品审批
       (<span id="auditGoods" style="color:#F00"></span>)</a></li></jh:equals>
       <jh:equals source="logic.examine.bounty" value="&basePage.menuString"><li><a href="/cloud/product/examine/bounty/Bounty.wa" target="right" >悬赏审批
       (<span id="auditBounty" style="color:#F00"></span>)</a></li></jh:equals>
       <jh:equals source="logic.examine.userBounty" value="&basePage.menuString"><li><a href="/cloud/product/examine/userbounty/UserBounty.wa" target="right" >竞标审查
       (<span id="auditUserBounty" style="color:#F00"></span>)</a></li></jh:equals>
      </ul>
    </li>
   </ul>
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
        <!-- 导航 结束 -->
    </div>
</body>
</html>