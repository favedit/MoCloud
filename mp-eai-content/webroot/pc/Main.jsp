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
         id_do.value = code;
         frmMain.submit();
      }

      function loginOut() {
         location.href = "Index.wa?do=loginOut";
      }
   </script>

   <body>
      <FORM id="form" name='frmMain' method='post' action='Main.wa'>
         <jh:equals source="true" value="&page.isLogin">
            <p class="prompt"><span>您好，<jh:write source='&page.passport' />  欢迎登录！</span></p>
         </jh:equals>
         <TABLE style='height:100%;width:100%;' cellpadding='0' cellspacing='0'>
            <TR>
               <TD id="header" height='100' colspan="2">
                  <INPUT id='id_do' name='do' type='hidden'>
                  <div class="header floatBtn" >
                     <div class="head-left">
                        <a href="javascript:;"><img class="logo" src="images/main/logo3.png"></a>
                     </div>
                     <jh:notEquals source="host" value="&page.userType">
                        <div class="head-right">
                           <p class="user-details" id="user-details"><i></i>
                              <jh:write source='&page.passport' />&nbsp;<img src="images/main/new8.png"></p>
                           <b></b>
                           <span class="img-details mr-20 pulse">
                              <img src='../mb/images/re.png'>
                        </span>
                        </div>
                     </jh:notEquals>
                  </div>
                  <ul class="users" id="users">
                     <je:authority role='eai.oa'>
                        <li class="binding"><a href="Binding.wa">账号绑定</a></li>
                     </je:authority>
                     <li onclick="loginOut();"><a class="exit" href="javascript:;">退出</a></li>
                  </ul>
               </TD>
            </TR>
            <TR>
               <TD class="main-left" width="80%" align="center" valign="center">
                  <div class="imag-container">
                     <img class="loding" src="images/main/loading.png" style="display: block">
                     <div class="imag-details" style="display: block;">
                        <div id="container_details" style="">
                           <ul>
                              <je:authority module='eai.marketer.customer'>
                                 <li style="display: none;" onclick='doChart("customer")'>
                                    <img src="images/main/1-2.png">
                                 </li>
                              </je:authority>
                              <je:authority module='eai.marketer.marketer'>
                                 <li style="display: none;" onclick='doChart("marketer")'>
                                    <img src="images/main/2-1.png">
                                 </li>
                              </je:authority>
                              <je:authority module='eai.department.marketer'>
                                 <li style="display: none;" onclick='doChart("department")'>
                                    <img src="images/main/2-3.png">
                                 </li>
                              </je:authority>
                           </ul>
                        </div>
                     </div>
                  </div>
               </TD>
               <TD width="19%" class="main-right" rowspan="2">
                  <div class="titles-container">
                     <ul>
                        <je:authority module='eai.marketer.customer'>
                           <li><img src="images/main/3-3.png"><b>全球实时投资数据展示中心</b></li>
                        </je:authority>
                        <je:authority module='eai.marketer.marketer'>
                           <li><img src="images/main/1-1.PNG"><b>理财师排行实时投资数据展示</b></li>
                        </je:authority>
                        <je:authority module='eai.department.marketer'>
                           <li>
                              </i><img src="images/main/2-2.png"><b>理财师管理实时投资数据展示</b></li>
                        </je:authority>
                     </ul>
                  </div>
               </TD>
            </TR>
            <TR>
               <TD height='56' colspan="0">
                  <div class="fot">
                     <p>客服电话：010-65499299</p>
                  </div>
               </TD>
               <td class="td-container"></td>
            </TR>
         </TABLE>
      </FORM>
   </body>

   </html>