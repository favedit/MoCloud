<!doctype html>
<%@ include file='/manage/apl/public.inc'%>
<html>
<head>
    <meta charset="utf-8">
    <title>17173游戏学院 - 后台管理系统</title>
<jsp:include page="/manage/common/newIncloud.jsp"></jsp:include>
<script type="text/javascript" src="/manage/ajs/myselfJs.js" ></script>
<script>

function checkHtml(){

	return;
	
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
/*setInterval(function() { 
	getAllAuditNumber();
},1000*60);
function getAllAuditNumber(){
        var url = "/manage/product/home/Home.wa?do=selectProductAuditNumber&date="+new Date().valueOf();
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
			   $("#auditGame").html(gameAuditNumber);
			   $("#auditLesson").html(lessonAuditNumber);
			   $("#auditNews").html(newsAuditNumber);
			   $("#auditTask").html(taskAuditNumber);
			   $("#auditUserTask").html(userTaskAuditNumber);
			   $("#auditGoods").html(goodsAuditNumber);
			   var allNumber = gameAuditNumber+lessonAuditNumber+newsAuditNumber+taskAuditNumber+userTaskAuditNumber+goodsAuditNumber;
			   $("#allNumber").html(allNumber);
		   },
		   fail:function(){
			 alert("error");
		   }
		});
}*/
</script>
</head>
<body bgcolor="#198bc9" onLoad="checkHtml()">
<div id="cy_left">
        <!-- 导航 开始 -->
  <ul class="accordion">
    <li id="one" class="common"> <a href="#one">共通管理</a>
    </li>
    <li id="two" class="classify"> <a href="#two">分类管理</a>
      <ul class="sub-menu">
    
      </ul>
    </li>
    <li id="three" class="product"> <a href="#three">产品管理</a>
      <ul class="sub-menu">

      </ul>
    </li>   
    <li id="four" class="weixin"> <a href="#four">微信服务号</a>
      <ul class="sub-menu">
      </ul>
    </li>    
     <li id="five" class="examine"> <a href="#five">用户管理</a>
      <ul class="sub-menu">
      </ul>
    </li>
     <li id="six" class="examine"> <a href="#six">流程管理(<span id="allNumber" style="color:#F00"></span>)</a>
      <ul class="sub-menu">
     
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