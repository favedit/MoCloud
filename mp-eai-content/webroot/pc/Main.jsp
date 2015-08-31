<%@ include file='/apl/public.inc' %>
<!DOCTYPE html>
<head>
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
   <meta http-equiv="X-UA-Compatible" IE="EmulateIE7" content="IE=edge" />
   <meta content="always" name="referrer">
   <link rel="stylesheet" type="text/css" href="css/reset.css">
   <link rel="stylesheet" type="text/css" href="css/animate.css">
   <link rel="stylesheet" type="text/css" href="css/main.css">
   <script type="text/javascript" src="js/jquery.min.js"></script>
   <script type="text/javascript" src="js/main.js"></script>
 </head>
<script>
   function doChart(code) {
      id_code.value = code;
      frmMain.submit();
   }
   function loginOut() {
      location.href = "Index.wa?do=loginOut";
   }
</script>
 <body>
   <FORM id="form" name='frmMain' method='post' action='Index.wa'>
   <jh:equals source="true" value="&page.isLogin" ><p class="prompt"><span>您好，<jh:write source='&page.passport' />  欢迎登录！</span></p></jh:equals>
      <TABLE style='height:100%;width:100%;' cellpadding='0' cellspacing='0'>
         <TR>
            <TD height='56' colspan="2">
               <INPUT id='id_do' name='do' type='hidden' value='chart'>
               <INPUT name='id' type='hidden' value="<jh:write source='&page.id'/>" />
               <INPUT id='id_code' name='code' type='hidden'>
             <div class="header floatBtn">
                  <div class="head-left"><a href="javascript:;"><img class="logo" src="images/main/logo.png"></a></div>
                  <jh:notEquals source="host" value="&page.userType">
                     <div class="head-right">
                        <p class="user-details" id="user-details"><i>3</i>
                           <jh:write source='&page.passport' />&nbsp;<img src="images/main/icon.png"></p>
                        <span class="img-details mr-20 pulse">
                           <img src='../mb/images/re.png'>
                        </span>
                     </div>
                  </jh:notEquals>
               </div> 
               <ul class="users" id="users">
                  <jh:equals source="true" value="&page.isOa" ><li class="binding"><a href="Index.wa?do=bind&id=<jh:write source='&page.id' />">账号绑定</a></li></jh:equals>
                  <li onclick="loginOut();">退出</li>
               </ul>
            </TD>
         </TR>
         <TR>
            <TD class="main-left" width="80%">
               <div class="imag-container">
                  <img class="loding" src="images/main/loding.gif" style="display: block">
                  <div class="imag-details" style="display: block;">
                     <p class="icon-picture">
                        <je:authority module='eai.marketer.customer'><span >全球实时投资数据展示中心</span></je:authority>
                        <je:authority module='eai.marketer.marketer'><span >理财师排行实时投资数据展示</span></je:authority>
                        <je:authority module='eai.department.marketer'><span >理财师管理实时投资数据展示</span></je:authority>
                     </p>
                     <div id="container_details" style="">
                        <ul>
                           <je:authority module='eai.marketer.customer'>
                              <li onclick='doChart("ChartMarketerCustomer")'>
                                 <img src="images/main/3.png">
                                 <div class="shadow"><img src="images/main/iconfont-sousuo.png"></div>
                              </li>
                           </je:authority>
                           <je:authority module='eai.marketer.marketer'>
                              <li onclick='doChart("ChartMarketerMarketer")'>
                                 <img src="images/main/1.png">
                                 <div class="shadow"><img src="images/main/iconfont-sousuo.png"></div>
                              </li>
                           </je:authority>
                          <je:authority module='eai.department.marketer'>
                              <li onclick='doChart("ChartDepartmentMarketer")'>
                                 <img src="images/main/2.png">
                                 <div class="shadow"><img src="images/main/iconfont-sousuo.png"></div>
                              </li>
                           </je:authority>
                        </ul>
                     </div>
                  </div>
               </div>
            </TD>
            <TD width="19%" class="main-right">
               <div class="titles-container">
                  <ul>
                    <p class="play_prev"></p>
                    <je:authority module='eai.marketer.customer'>
                        <li class="on"><i class="mask"></i><img src="images/main/3-3.png"></li>
                     </je:authority>
                      <je:authority module='eai.marketer.marketer'>
                        <li > <i class="mask"></i><img src="images/main/1-1.PNG"></li>
                     </je:authority>
                     <je:authority module='eai.department.marketer'>
                        <li><i class="mask"></i><img src="images/main/2-2.png"></li>
                     </je:authority>
                     <p class="play_next"></p>
                  </ul> 
               </div>  
            </TD>
         </TR>
         <TR>
            <TD height='56' colspan="2">
                <div class="fot"><p>客服电话：010-65499299</p></div>
            </TD>
         </TR>
      </TABLE>
   </FORM>
</body>
</html>
