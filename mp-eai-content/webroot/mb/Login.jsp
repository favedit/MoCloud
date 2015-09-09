<%@ include file='/apl/public.inc' %>
   <!DOCTYPE >
   <html>

   <head>
      <title>全球实时投资数据展示中心—钰诚集团智慧企业</title>
      <meta name="viewport" charset="UTF-8" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
      <link rel="stylesheet" type="text/css" href="css/reset.css">
      <link rel="stylesheet" type="text/css" href="css/animate.css">
      <link rel="stylesheet" type="text/css" href="css/login.css">
      <script type="text/javascript" src="js/viewport.js"></script>
      <script type="text/javascript" src="/ajs/cookie.js"></script>
   </head>

   <body>

      <table cellpadding="0" cellspacing="0" border="0" width="100%" height="100%">
         <tbody>
            <tr>
               <td height="120" align="center" valign="center">
                  <p id="error" style="display: none;"><jh:write source='&page.message' /></p>
                  <img class="logo" src="images/login/6.png">
               </td>
            </tr>
            <tr>
               <td align="center" valign="center">
                  <section class="wap-main">
                     <FORM name='frmMain' style="height:100%;" method='post' action='Index.wa?do=login'>
                        <div class="wap-box">
                           <div style="position: relative">
                              <ul class="details-container">
                                 <p><b>用户名</b>
                                    <input id="passport" name="passport" class="quantico account" type="text" placeholder="请输入oa账号">
                                 </p>
                                 <p><b>密<i>码</i>码</b>
                                    <input input id="password" name="password" class="quantico password" type="password" placeholder="密码">
                                 </p>
                                 <span class="details"><input id="saveCookie" name="saveCookie" type="checkbox">记住用户名</span>
                                 <span class="btn-container"><input input id="btn" type="submit"  value=""></span>
                              </ul>
                           </div>
                        </div>
                     </FORM>
                  </section>
                  <div class="popBox animated flipInX" id="alertWidget" style="display: none;">
                     <span class="ico-pop-wrong"></span>
                     <span class="tip" id="tip">请输入病情描述</span>
                  </div>
               </td>
            </tr>
            <tr>
               <td height="60" align="center" valign="center">
                  <footer class="wap-footer">©2015 钰诚集团智慧企业推进中心（北京）<a href="tel:010-65499299">客服电话：010-65499299</a></footer>
               </td>
            </tr>
         </tbody>
      </table>

      <script type="text/javascript">
         var passport = getCookieValue("passport");
         if (passport != "") {
            document.getElementById("saveCookie").checked = true;
         }
         document.getElementById("passport").value = passport;

         function popupBox(str) {
            var $alertBox = document.getElementById("alertWidget");
            document.getElementById("tip").innerHTML = str;
            $alertBox.style.display = "block";
            setTimeout(function() {
               $alertBox.style.display = "none";
            }, 1500);
         }
         var error = document.getElementById("error").innerHTML;
         if (error != "") {
            popupBox(error);
         }
         var $username = document.getElementById('passport');
         var $password = document.getElementById('password');
         var $btn = document.getElementById('btn');
         $btn.onclick = function() {
            if ($username.value == "" || $password.value == "") {
               popupBox("用户名或密码不能为空");
               return false;
            } else {
               frmMain.submit();
            }
         }
      </script>

   </body>

   </html>