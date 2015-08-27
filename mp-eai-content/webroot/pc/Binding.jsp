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
      function loginOut() {
         location.href = "Index.wa?do=loginOut";
      }
   </script>

   <body>
      <div class="header floatBtn">
         <div class="head-left">
            <a href="javascript:;"><img class="logo" src="images/main/logo.png"></a>
            <p class="pl-10" style="line-height: 56px;">客服电话：010-65499299</p>
         </div>
         <div class="head-right">
            <p class="user-details" id="user-details" title="" ><i></i>
               <jh:write source='&page.passport' />&nbsp;<img src="images/main/icon.png"></p>
            <ul class="users" id="users">
               <li onclick="loginOut();">退出</li>
            </ul>
            <span class="img-details mr-20 pulse">
               <img src='../mb/images/re.png'>
            </span>
         </div>
      </div>
      <div class="clear"></div>
      <div class="binding-container">
         <input tyle="hidden" value="1" id="input_state" style="display: none;">
         <div class="box">
            <div class="box-container">
               <h1>账号绑定</h1>
               <span class="box-prompt"><i><jh:write source='&page.message' /></i></span>
               <FORM id="frmBind" name='frmBind' method='post' action='Index.wa?do=bindOnAccount'>
                  <p class="icon mt-30"><i class=""></i>
                     <input id="mobile" name="ePassport" class="quantico account" type="text" placeholder="E租宝">
                     <input id="id" name="id"  type="hidden" value="<jh:write source='&page.id' />" />
                  </p>
                  <p class="validation">
                     <input type="text" name="validate" id="verification_code" placeholder="验证码">
                     <input type="button" id="send_btn" value="发送动态密码">
                  </p>
                  <a href="javascript:;" class="btn">
                     <input id="btn"  type="submit" value="提交">
                  </a>
               </FORM>
               <p style="text-align: right"><a href="Index.wa?do=main&id=<jh:write source='&page.id' />" class="returns" style="margin-top: 20px;display:block;font-size: 14px;text-decoration:underline;">返回首页</a></p>
            </div>
         </div>
      </div>
      <script type="text/javascript"></script>
   </body>

   </html>