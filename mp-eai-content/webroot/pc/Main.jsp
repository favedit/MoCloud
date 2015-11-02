<%@ include file='/apl/public.inc' %>
   <!DOCTYPE html>

   <head>
      <title>全球实时投资数据展示中心—钰诚集团智慧企业</title>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
      <meta http-equiv="X-UA-Compatible" IE="EmulateIE7" content="IE=edge" />
      <meta content="always" name="referrer">
      <link rel="stylesheet" type="text/css" href="css/reset.css">
      <link rel="stylesheet" type="text/css" href="css/animate.css">
      <link rel="stylesheet" type="text/css" href="css/main.css">
      <style type="text/css">
         .titles-container{
            position: relative;
         }
         /*固定 大小*/
         .fixed{
            height: 608px;
            position: absolute;
            top:50%;
            left:50%;
            margin-top: -304px;
            margin-left: -116px;
         }
         .fixed-size{
            height: 535px;
            display: block;
            overflow: hidden;
         }
         .titles-container ul{
            display: block;
         }
         .next, .prev{
            display: block;
            text-align: center;
            cursor:pointer;
            height: 32px;
            line-height: 32px;
            width: 100%;
            background-size: 28px;
            position: relative;
         }
         .next{
            background-image:url(images/main/next.png);
            background-repeat: no-repeat;
            background-position:top center;
            top:30px;
         }
         .prev{
            background-image:url(images/main/prev.png);
            background-repeat: no-repeat;
            background-position:top center;
            bottom:30px;
         }
         .next.ons, .prev.ons{
            background: none;
            cursor:default;
         }
         .prev img,.next img{
            width: 28px;
            position: relative;
            top:-3px;
         }
         /*总数*/
         p.total-number{
            display: none;
            height: 50px;
            line-height: 50px;
            color:#36e4fc;
            position: absolute;
            bottom: 10px;
            right: 10px;
            font-size: 18px;
         }
         
      </style>
      <script type="text/javascript" src="js/jquery.min.js"></script>
      <script type="text/javascript" src="js/main.js"></script>
      <script type="text/javascript" src="/ajs/cookie.js"></script>
   </head>
   <script>
      function doChart(code) {
         var id_do = document.getElementById("id_do");
         id_do.value = code;
         frmMain.submit();
      }
      function loginOut() {
         location.href = "Index.wa?do=loginOut";
      }
   </script>

   <body>
      <FORM id="form" name='frmMain' method='post' action='Main.wa'>
         <p id="prompt" class="prompt"><span>您好，<jh:write source='&page.passport' />  欢迎登录！</span></p>
         <TABLE id="table" style='height:100%;width:100%;' cellpadding='0' cellspacing='0'>
            <TR style="width:100%;">
               <TD id="header" colspan="2">
                  <INPUT id='id_do' name='do' type='hidden'>
                  <div class="header floatBtn">
                     <div class="head-left">
                        <a href="javascript:;"><img class="logo" src="images/main/logos.png"></a>
                     </div>
                     <div class="head-right">
                        <ul class="user-l">
                           <je:authority module='eai.marketer.member.recommend'>
                           <li><a href="/pc/marketer/customer/Customer.wa"></a></li>
                           </je:authority>
                        </ul>
                        <jh:notEquals source="host" value="&page.userType">
                           <ul class="user-r">
                              <span><jh:write source='&page.passport' /><je:authority role='eai.marketer'><font size="3" color="#FF851A">(理财师)</font></je:authority></span>
                              <img class="triangle" src="images/main/new8.png">
                              <li>
                                 <i class="img-details mr-20 pulse">
                                    <img src='../../../mb/images/re.png'>
                                 </i>
                                 <b></b>
                              </li>
                           </ul>
                        </jh:notEquals>
                        <jh:equals source="host" value="&page.userType">
                           <div class="switch">
                              <a href="Index.wa?time=today">切换帐号</a>
                           </div>
                        </jh:equals>
                     </div>
               </TD>
            </TR>
            <TR>
               <TD class="main-left" width="79%" align="center" valign="center">
                  <ul class="users" id="users">
                     <je:authority role='eai.oa'>
                        <li class="binding"><a href="Binding.wa">账号绑定</a></li>
                     </je:authority>
                     <li onclick="loginOut();"><a class="exit" href="javascript:;">退出</a></li>
                  </ul>
                  <div class="imag-container">
                     <img class="loding" src="images/main/loading.png" style="display: block">
                     <div class="imag-details" style="display: block;">
                        <div id="container_details" style="">
                           <ul>
                              <je:authority module='eai.marketer.customer'>
                                 <li style="display: block;">
                                    <h4 style="color:#ffa200;">用户投资实时展示中心</h4>
                                    <div onclick='doChart("customer")' class="icon"></div>
                                    <img src="images/main/pc1.png">
                                    <p style="color:#ffa200;">展示e租宝全球客户的投资数据及地理分布，以及24小时投资曲线。</p>
                                 </li>
                              </je:authority>
                              <je:authority module='eai.marketer.marketer'>
                                 <li style="display: none;">
                                    <h4 style="color:#ffa200;">理财师排行实时展示中心</h4>
                                    <div onclick='doChart("marketer")' class="icon"></div>
                                    <img src="images/main/pc2.png">
                                    <p style="color:#ffa200;">展示分公司理财师的客户实时投资情况，以及当月、当周、当日的理财师业绩排行。</p>
                                 </li>
                              </je:authority>
                              <je:authority module='eai.department.marketer'>
                                 <li style="display: none;">
                                    <h4 style="color:#ffa200;">理财师业绩实时展示中心</h4>
                                    <div onclick='doChart("department")' class="icon"></div>
                                    <img src="images/main/pc3.png">
                                    <p style="color:#ffa200;">展示分公司理财师的客户实时投资和赎回情况，以及当月、当周、当日的理财师业绩排行。</p>
                                 </li>
                              </je:authority>
                              <je:authority module='eai.statistics.marketer'>
                                 <li style="display: none;">
                                    <div onclick='doChart("statisticsMarketer")' class="icon"></div>
                                    <img src="images/main/pc5.png">
                                 </li>
                              </je:authority>
                              <je:authority module='eai.marketer.manage'>
                                 <li style="display: none;">

                                    <div onclick='doChart("marketerManage")' class="icon"></div>
                                    <img src="images/main/pc4.png">

                                 </li>
                              </je:authority>
                              <je:authority module='eai.performence.marketer'>
                                 <li style="display: none;">

                                    <div onclick='doChart("performenceMarketer")' class="icon"></div>
                                    <img src="images/main/pc6.png">
                                 </li>
                              </je:authority>
                           </ul>
                        </div>
                     </div>
                  </div>
               </TD>
               <TD width="10%" class="main-right"  rowspan="2" align="center" valign="top">
                  <div class="titles-container" >
                     <div class="fixed">
                        <span class="prev ons"></span>
                        <div class="fixed-size">
                           <ul>
                              <je:authority module='eai.marketer.customer'>
                                 <li data-url="customer" ><img src="images/main/3-3.png"><b>用户投资实时展示中心</b></li>
                              </je:authority>
                              <je:authority module='eai.marketer.marketer'>
                                 <li data-url="marketer"><img src="images/main/1-1.PNG"><b>理财师排行实时展示中心</b></li>
                              </je:authority>
                              <je:authority module='eai.department.marketer'>
                                 <li data-url="department" ><img src="images/main/2-2.png"><b>理财师管理实时展示中心</b></li>
                              </je:authority>
                              <je:authority module='eai.statistics.marketer'>
                                 <li data-url="statisticsMarketer"><img src="images/main/4-1.jpg"><b>全国各省投资总额展示中心</b></li>
                              </je:authority>
                              <je:authority module='eai.marketer.manage'>
                                 <li data-url="marketerManage" ><img src="images/main/6-1.jpg"><b>全球理财师数据展示中心</b></li>
                              </je:authority>
                              <je:authority module='eai.performence.marketer'>
                                 <li data-url="performenceMarketer" ><img src="images/main/5-1.jpg"><b>全球实时统计数据展示中心</b></li>
                              </je:authority>
                           </ul>
                        </div>
                        <span class="next"></span>
                     </div>
                     <p class="total-number">(<span class="current">1</span>/<span class="total">8</span>)</p>
                  </div>
               </TD>
            </TR>
            <TR>
               <TD height='60' colspan="0" align="center" valign="top">
                  <div class="fot">
                     <p>本平台由钰诚集团智慧企业推进中心 出品</br>
                        客服电话：010-65499299</p>
                  </div>
               </TD>
            </TR>
         </TABLE>
      </FORM>
      <!-- Piwik -->
<script type="text/javascript">
  var _paq = _paq || [];
   var passport = "<jh:write source='&page.passport' />";
   if(passport.length > 0){
      _paq.push(['setUserId',passport]);   
   }
  _paq.push(['trackPageView']);
  _paq.push(['enableLinkTracking']);
  (function() {
    var u="//124.192.38.34:8081/piwik/";
    _paq.push(['setTrackerUrl', u+'piwik.php']);
    _paq.push(['setSiteId', 7]);
    var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0];
    g.type='text/javascript'; g.async=true; g.defer=true; g.src=u+'piwik.js'; s.parentNode.insertBefore(g,s);
  })();
</script>
<noscript><p><img src="//124.192.38.34:8081/piwik/piwik.php?idsite=7" style="border:0;" alt="" /></p></noscript>
<!-- End Piwik Code -->
   </body>

   </html>