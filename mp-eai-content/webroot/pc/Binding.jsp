<%@ include file='/apl/public.inc' %>
   <!DOCTYPE >
   <html>
   <head>
      <title>账号绑定—全球实时投资数据展示中心—钰诚集团智慧企业</title>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
      <meta http-equiv="X-UA-Compatible" IE="EmulateIE7" content="IE=edge" />
      <meta content="always" name="referrer">
      <link rel="stylesheet" type="text/css" href="css/reset.css">
      <link rel="stylesheet" type="text/css" href="css/animate.css">
      <link rel="stylesheet" type="text/css" href="css/binding.css">
      <script type="text/javascript" src="js/jquery.min.js"></script>
      <script type="text/javascript" src="js/binding.js"></script>
   </head>
   <script>
      function loginOut() {
         location.href = "Index.wa?do=loginOut";
      }
   </script>
   <body>
     <table  cellpadding="0" cellspacing="0" border="0" width="100%" height="100%" >
      <tbody>
      <tr id="heads">
         <td id="header">
            <div class="header floatBtn">
               <div class="head-left"><a href="javascript:;"><img class="logo" src="images/main/logos.png"></a></div>
                  <div class="head-right">
                     <p class="user-details" id="user-details"><i></i>
                        <jh:write source='&page.passport' />&nbsp;<img src="images/main/new8.png"></p>
                        <b></b>
                        <span class="img-details mr-20 pulse">
                              <img src='../mb/images/re.png'>
                        </span>
                  </div>
            </div> 
            <ul class="users" id="users" >
               <li onclick="loginOut();"><a class="exit" href="javascript:;">退出</a></li>
            </ul>
            <div class="clear"></div>
        </td>
     </tr>
     <tr id="mains">
       <td align="center" valign="center">
           <div class="binding-container">
               <input tyle="hidden" value="1" id="input_state" style="display: none;">
               <div class="box">
                  <div class="box-container">
                     <h1>账号绑定</h1>
                     <span class="box-prompt"><i><jh:write source='&page.message' /></i></span>
                     <FORM id="frmBind" name='frmBind' method='post' action='Binding.wa?do=bindOnAccount'>
                        <p class="user-name">
                           <input id="mobile" name="ePassport" class="quantico account" type="text" placeholder="E租宝理财师账号">
                        </p>
                        <p class="validation"><input type="text" name="validate" id="verification_code" placeholder="验证码"><input type="button" id="send_btn" value="发送动态密码">
                        </p>
                        <a href="javascript:;" class="btn">
                           <input id="btn"  type="submit" value=" ">
                        </a>
                     </FORM>
                     <p class="refund"><a href="Main.wa" class="returns">返回首页</a></p>
                  </div>
               </div>
            </div>
        </td>
     </tr>
     <tr>
       <td height="100" align="center" valign="center">
         <div class="footer">©2015 钰诚集团智慧企业推进中心（北京）<p style="padding-top:5px;">客服电话：010-65499299</p></div>
       </td>
     </tr>
      </tbody>
   </table>
   </body>

   </html>