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
      <script>
         function checkHtml() {
            var menu = $.trim($("#one").children(".sub-menu").html());
            if (menu == '') {
               $("#one").hide();
            }
            menu = $.trim($("#two").children(".sub-menu").html());
            if (menu == '') {
               $("#two").hide();
            }
            menu = $.trim($("#three").children(".sub-menu").html());
            if (menu == '') {
               $("#three").hide();
            }
            menu = $.trim($("#four").children(".sub-menu").html());
            if (menu == '') {
               $("#four").hide();
            }
            menu = $.trim($("#six").children(".sub-menu").html());
            if (menu == '') {
               $("#six").hide();
            }
         }
      </script>
   </head>

   <body bgcolor="#198bc9" onload="checkHtml();">
      <div id="cy_left">
         <!-- 导航 开始 -->
         <ul id="accordion" class="accordion">
            <li id="one" class="files">
               <a href="#">系统管理</a>
               <ul class="sub-menu">
                  <jh:equals source="manage.system.user.module" value="&basePage.menuString"><li><a href="/manage/system/user/module/Module.wa" target="right">模块管理</a></li></jh:equals>
                  <jh:equals source="manage.system.user.role" value="&basePage.menuString"><li><a href="/manage/system/user/role/Role.wa" target="right">角色管理</a></li></jh:equals>
                  <jh:equals source="manage.system.user" value="&basePage.menuString"><li><a href="/manage/system/user/User.wa" target="right">用户管理</a></li></jh:equals>
               </ul>
            </li>
            <li id="two" class="files">
               <a href="#">日志管理</a>
               <ul class="sub-menu">
                  <jh:equals source="manage.system.logger.user.notice" value="&basePage.menuString"><li><a href="/manage/system/logger/user/notice/Notice.wa" target="right">用户公告日志管理</a></li></jh:equals>
                  <jh:equals source="manage.system.logger.user.access" value="&basePage.menuString"><li><a href="/manage/system/logger/user/access/Access.wa" target="right">用户日志管理</a></li></jh:equals>
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
               if ($(this).attr('class') != 'active') {
                  accordion_body.slideUp('normal');
                  $(this).next().stop(true, true).slideToggle('normal');
                  accordion_head.removeClass('active');
                  $(this).addClass('active');
               }
            });
         });
      </script>
   </body>

   </html>