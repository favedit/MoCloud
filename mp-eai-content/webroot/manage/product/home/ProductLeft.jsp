<!doctype html>
<%@ include file='/apl/public.inc' %>
   <jh:define source="&basePage.user" alias="base"></jh:define>
   <html>

   <head>
      <meta charset="utf-8">
      <title>17173游戏学院 - 后台管理系统</title>
      <link rel="stylesheet" href="/manage/acs/style.css" type="text/css" media="screen" />
      <link rel="stylesheet" href="/manage/acs/main.css" type="text/css" media="screen" />
      <link rel="stylesheet" href="/manage/acs/lrtk.css" type="text/css" media="screen" />
      <script src="/manage/ajs/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
      <script>
//         var flag = "<jh:write source='&base.ouid' />";
//         if(flag == ""){
//         	 alert("连接超时！");
//         	 parent.parent.location.href="/manage/home/Frame.wp";	
//         }
//         function checkHtml() {
//            var menu = replaceNbsp($("#one").children(".sub-menu").html());
//            if (menu == '') {
//               $("#one").hide();
//            }
//            menu = replaceNbsp($("#two").children(".sub-menu").html());
//            if (menu == '') {
//               $("#two").hide();
//            }
//            menu = replaceNbsp($("#three").children(".sub-menu").html());
//            if (menu == '') {
//               $("#three").hide();
//            }
//            menu = replaceNbsp($("#four").children(".sub-menu").html());
//            if (menu == '') {
//               $("#four").hide();
//            }
//            menu = replaceNbsp($("#five").children(".sub-menu").html());
//            if (menu == '') {
//               $("#five").hide();
//            }
//            menu = replaceNbsp($("#six").children(".sub-menu").html());
//            if (menu == '') {
//               $("#six").hide();
//            }
//            getAllAuditNumber();
//         }
         //setInterval(function() { 
         //	getAllAuditNumber();
         //},1000*60);
         //function getAllAuditNumber(){
         //        var url = "/cloud/product/home/Home.wa?do=selectProductAuditNumber&date="+new Date().valueOf();
         //		$.ajax({
         //		   type: "POST",
         //		   url:url,
         //		   success: function(msg){
         //			   var audit = toJsonObject(msg);	
         //			   var gameAuditNumber =parseInt(audit.gameAuditNumber);
         //			   var lessonAuditNumber = 	parseInt(audit.lessonAuditNumber);
         //			   var newsAuditNumber = parseInt(audit.newsAuditNumber);
         //			   var taskAuditNumber = parseInt(audit.taskAuditNumber);
         //			   var userTaskAuditNumber = parseInt(audit.userTaskAuditNumber);
         //			   var goodsAuditNumber = parseInt(audit.goodsAuditNumber);
         //			   $("#auditGame").html(gameAuditNumber);
         //			   $("#auditLesson").html(lessonAuditNumber);
         //			   $("#auditNews").html(newsAuditNumber);
         //			   $("#auditTask").html(taskAuditNumber);
         //			   $("#auditUserTask").html(userTaskAuditNumber);
         //			   $("#auditGoods").html(goodsAuditNumber);
         //			   var allNumber = gameAuditNumber+lessonAuditNumber+newsAuditNumber+taskAuditNumber+userTaskAuditNumber+goodsAuditNumber;
         //			   $("#allNumber").html(allNumber);
         //		   },
         //		   fail:function(){
         //			 alert("error");
         //		   }
         //		});
         //}
      </script>
   </head>

   <body bgcolor="#198bc9">
      <div id="cy_left">
         <!-- 导航 开始 -->
         <ul class="accordion">
            <li id="one" class="common"> <a href="#one">设备管理</a>
               <ul class="sub-menu">
                  <li><a href="/product/device/Device.wa" target="right">设备信息</a></li>
               </ul>
            </li>
            <li id="two" class="classify"> <a href="#two">用户管理</a>
               <ul class="sub-menu">
                  <li><a href="/product/logger/user/Access.wa" target="right">用户日志</a></li>
                  <li><a href="/product/person/user/Access.wa" target="right">白名单</a></li>
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
                  if ($(this).attr('class') != 'active') {
                     accordion_body.slideUp('normal');
                     $(this).next().stop(true, true).slideToggle('normal');
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