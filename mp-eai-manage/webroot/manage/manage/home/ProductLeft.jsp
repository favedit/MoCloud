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
            menu = $.trim($("#five").children(".sub-menu").html());
            if (menu == '') {
               $("#five").hide();
            }
            menu = $.trim($("#six").children(".sub-menu").html());
            if (menu == '') {
               $("#six").hide();
            }
            menu = $.trim($("#seven").children(".sub-menu").html());
            if (menu == '') {
               $("#seven").hide();
            }
         }
      </script>
   </head>

   <body bgcolor="#198bc9" onLoad="checkHtml()">
      <div id="cy_left">
         <!-- 导航 开始 -->
         <ul class="accordion">
         
            <li id="one" class="common"> <a href="#one">共通管理</a>
               <ul class="sub-menu">
                  <jh:equals source="manage.product.common.country" value="&basePage.menuString">
                     <li><a href="/manage/product/common/Country.wa" target="right">国家信息</a></li>
                  </jh:equals>
                  <jh:equals source="manage.product.common.area" value="&basePage.menuString">
                     <li><a href="/manage/product/common/Area.wa" target="right">区域信息</a></li>
                  </jh:equals>
                  <jh:equals source="manage.product.common.province" value="&basePage.menuString">
                     <li><a href="/manage/product/common/Province.wa" target="right">省会信息</a></li>
                  </jh:equals>
                  <jh:equals source="manage.product.common.city" value="&basePage.menuString">
                     <li><a href="/manage/product/common/City.wa" target="right">城市信息</a></li>
                  </jh:equals>
                  <jh:equals source="manage.product.common.configration" value="&basePage.menuString">
                     <li><a href="/manage/product/common/configration/Configration.wa" target="right">配置信息</a></li>
                  </jh:equals>
                  <jh:equals source="manage.product.common.configration.rule" value="&basePage.menuString">
                     <li><a href="/manage/product/common/configration/rule/Rule.wa" target="right">规则配置信息</a></li>
                  </jh:equals>
               </ul>
            </li>
            <li id="three" class="classify"> <a href="#three">用户管理</a>
               <ul class="sub-menu">
                  <jh:equals source="manage.product.user.logger" value="&basePage.menuString">
                     <li><a href="/manage/product/user/logger/Access.wa" target="right">用户日志</a></li>
                  </jh:equals>
                  <jh:equals source="manage.product.user.whitelists" value="&basePage.menuString">
                     <li><a href="/manage/product/user/whitelists/Access.wa" target="right">白名单</a></li>
                  </jh:equals>
                  <jh:equals source="manage.product.user.signing" value="&basePage.menuString">
                     <li><a href="/manage/product/user/signing/Signing.wa" target="right">用户签到</a></li>
                  </jh:equals>
                  <jh:equals source="manage.product.device" value="&basePage.menuString">
                     <li><a href="/manage/product/device/Device.wa" target="right">设备信息</a></li>
                  </jh:equals>
               </ul>
            </li>
            
            <li id="four" class="common"> <a href="#four">金融管理</a>
               <ul class="sub-menu">
                  <jh:equals source="manage.product.financial.department" value="&basePage.menuString">
                     <li><a href="/manage/product/financial/department/Department.wa" target="right">部门信息</a></li>
                  </jh:equals>
                  <jh:equals source="manage.product.financial.marketer" value="&basePage.menuString">
                     <li><a href="/manage/product/financial/marketer/Marketer.wa" target="right">理财师信息</a></li>
                  </jh:equals>
                  <jh:equals source="manage.product.financial.customer" value="&basePage.menuString">
                     <li><a href="/manage/product/financial/customer/Customer.wa" target="right">客户信息</a></li>
                  </jh:equals>
                  <jh:equals source="manage.product.financial.product" value="&basePage.menuString">
                     <li><a href="/manage/product/financial/product/Product.wa" target="right">产品信息</a></li>
                  </jh:equals>
               </ul>
         </li>
         <li id="five" class="common"> <a href="#five">系统管理</a>
               <ul class="sub-menu">
                  <jh:equals source="product.system.application" value="&basePage.menuString">
                     <li><a href="/product/system/application/Application.wa" target="right">应用信息</a></li>
                  </jh:equals>
                  <jh:equals source="product.system.version" value="&basePage.menuString">
                     <li><a href="/product/system/version/Version.wa" target="right">版本信息</a></li>
                  </jh:equals>
               </ul>
         </li>
         <li id="six" class="common"> <a href="#six">业务管理</a>
               <ul class="sub-menu">
                  <jh:equals source="manage.product.business.news.news" value="&basePage.menuString">
                     <li><a href="/manage/product/business/news/News.wa" target="right">资讯信息</a></li>
                  </jh:equals>
                  <jh:equals source="manage.product.business.salestools" value="&basePage.menuString">
                     <li><a href="/manage/product/business/Salestools.wa" target="right">销售工具信息</a></li>
                  </jh:equals>
               </ul>
         </li>
         <li id="seven" class="common"><a href="#seven">审核管理</a>
               <ul class="sub-menu">
                  <jh:equals source="manage.product.examine.news" value="&basePage.menuString">
                     <li><a href="/manage/product/examine/news/News.wa" target="right">业务资讯审核</a></li>
                  </jh:equals>
                  <jh:equals source="manage.product.examine.business" value="&basePage.menuString">
                     <li><a href="/manage/product/examine/business/Salestools.wa" target="right">销售工具审核</a></li>
                  </jh:equals>
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