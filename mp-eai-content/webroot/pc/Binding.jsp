<%@ include file='/apl/public.inc' %>
   <!DOCTYPE >
   <html>
   <head>
      <title></title>
      <meta charset="UTF-8" />
      <meta name="baidu-site-verification" content="r49gUEsySi" />
      <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
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
      function loginOut(){
         location.href="Index.wa?do=loginOut";
      }
   </script>
   <body>
      <FORM name='frmMain' method='post' action='Index.wa'>
         <INPUT id='id_do' name='do' type='hidden' value='chart'>
         <INPUT id='id_code' name='code' type='hidden'>
         <header class="header floatBtn">
            <div class="head-left"><img class="logo" src="images/main/logo.png">
               <p class="pl-10"></p>
            </div>
               <div class="head-right">
                  <p class="user-details" id="user-details"><i>3</i>&nbsp;<img src="images/main/icon.png"></p>
                  <ul class="users" id="users">
                     <li onclick="loginOut();">退出</li>
                  </ul>
                  <span class="img-details mr-20 pulse">
                     <img src='../mb/images/re.png'>
                  </span>
               </div>
         </header>
         <div class="clear"></div>
         <div class="binding-container" >
            <input tyle="hidden" value="1" id="input_state" style="display: none;">
            <div class="box">
               <div class="box-container">
                  <h1>账号绑定</h1>
                  <span class="box-prompt"><i></i></span>
                  <p class="icon mt-30"><i class=""></i><input id="mobile" class="quantico account"  type="text" placeholder="E租宝"></p>
                  <p class="validation"><input type="text" id="verification_code" placeholder="验证码"><input type="button" id="send_btn" value="发送动态密码"></p>
                  <a href="javascript:;" class="btn"><input id="btn" type="submit"  value="提交"></a>
                  <p style="text-align: right"><a href="Main.jsp" class="returns" style="margin-top: 20px;display:block;font-size: 14px;">返回首页</a></p>
               </div>
            </div>
         </div>
      <script type="text/javascript"></script>
   </body>
   </html>