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
   </head>
   <script>
      $(function() {
         var flag = "<jh:write source='&base.ouid' />";
         if (flag == "") {
            alert("连接超时！");
            parent.parent.location.href = "/manage/home/Frame.wp";
         }

//         if ($('#passport').val() == "admin") {
//            $("#databaseLI").show();
//         }
      });

      function loginout() {
         top.location.href = "/manage/home/Frame.wa?do=loginOut";
      }
      function productClick() {
         setInterval(function() {
            var now = (new Date()).toLocaleString();
            $('#current-time').html("日期：" + now);
         }, 1000);
         //	document.getElementById("product").click();
      }
   </script>

   <body bgcolor="#198bc9" onLoad="productClick()">
      <div id="cy_header">
         <div id="top_left">
            <div class="welcom">
               欢迎 <span style="color:#F90"><jh:write source="&base.label"/></span> 登录 &nbsp;&nbsp;&nbsp;
<!--               <a href="/cloud/manage/home/Frame.wa?do=changePwdPrepare" target="right">[修改密码]</a>&nbsp;&nbsp;&nbsp;-->
               <!--            <span style="color:#666">V.<jh:write source="&basePage.version"/></span>-->
            </div>
         </div>
         <div id="top_right">
            <ul class="nav">
               <li class="tb_01">
                  <a id="product" class="btn1" href="/manage/home/Header.wa?do=productLeft" target="left">产品管理</a>
               </li>
<!--
               <li class="tb_02">
                  <a class="btn2" href="/cloud/manage/home/Header.wa?do=analysisLeft" target="left">产品分析</a>
               </li>
               <li class="tb_03">
                  <a class="btn3" href="/cloud/manage/home/Header.wa?do=manageLeft" target="left">后台管理</a>
               </li>
               <li class="tb_04" id="databaseLI" hidden="true">
                  <a class="btn2" href="/cloud/manage/home/Header.wa?do=databaseLeft" target="left">数据管理</a>
               </li>
-->
            </ul>
            <div class="closebtn">
               <a href="#" onClick="loginout();"></a>
            </div>
            <div id="current-time" class="time"></div>
         </div>
      </div>
   </body>

   </html>