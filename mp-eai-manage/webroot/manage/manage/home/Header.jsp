<!doctype html>
<%@ include file='/apl/public.inc' %>
   <html>

   <head>
      <meta charset="utf-8">
      <title>后台管理系统</title>
      <link rel="stylesheet" href="/manage/acs/style.css" type="text/css" media="screen" />
      <link rel="stylesheet" href="/manage/acs/main.css" type="text/css" media="screen" />
      <link rel="stylesheet" href="/manage/acs/lrtk.css" type="text/css" media="screen" />
      <script src="/manage/ajs/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
   </head>
   <script>
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
               欢迎 <span style="color:#F90"><jh:write source="&basePage.userName"/></span> 登录 &nbsp;&nbsp;&nbsp;
                              <a href="/manage/home/Frame.wa?do=changePwdPrepare" target="right">[修改密码]</a>&nbsp;&nbsp;&nbsp;
               <!--            <span style="color:#666">V.<jh:write source="&basePage.version"/></span>-->
            </div>
         </div>
         <div id="top_right">
            <ul class="nav">
               <li class="tb_01">
                  <a id="product" class="btn1" href="/manage/home/Header.wa?do=productLeft" target="left">产品管理</a>
               </li>

               <jh:equals source="admin" value="&basePage.passport">
               <li class="tb_02">
                  <a class="btn2" href="/manage/home/Header.wa?do=manageLeft" target="left">后台管理</a>
               </li>
               </jh:equals>
<!--
               <li class="tb_03">
                  <a class="btn3" href="/cloud/manage/home/Header.wa?do=manageLeft" target="left">后台管理</a>
               </li>
-->
               <!-- <li class="tb_04" id="databaseLI" hidden="true">
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