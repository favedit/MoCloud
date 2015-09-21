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
                  <span id="errors" style="position: absolute; color:#fff; top:50px;left:0px;text-align: left"></span>
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

         var x=document.getElementById("errors");
         var geo = window.navigator.geolocation;
         (function(d) {
            var tip = null,
               do_hanlder = {},
               link = location.href,
               geo = window.navigator.geolocation;
            do_hanlder.successs = function(p) {
               tip = d.getElementById("errors");
               var resulte = p.coords;
                  // url = "{{$HOST_DISEASE_WAP}}/hospitals/nearby?diseid=51&lon=" + resulte.longitude + "&lat=" + resulte.latitude;
               tip.innerHTML = "您的地理坐标,经度：" + resulte.longitude + "，纬度：" + resulte.latitude;
               // location.assign(url);
            };

            do_hanlder.error = function(error) {

               tip = d.getElementById("errors");
               switch (error.code) {
                  case 1:
                  // tip.innerHTML = "<span>您拒绝了共享地理位置信息</span><a href=\"" + link + "\">重试</a>";   
                  break;

                  default:
                  // tip.innerHTML = "<span>定位失败,请</span><button type=\"button\" id=\"re_geo\">重试</button>";
               }
            };
            // Permission denied - 用户不允许地理定位
            // Position unavailable - 无法获取当前位置
            // Timeout - 操作超时
            do_hanlder.options = {
               enableHighAccuracy: true,
               timeout: 10000,
               maximumAge: 2500
            };

            do_hanlder.init = function () {
               var self = this;
               geo.getCurrentPosition(function(p) {
                  self.successs(p);
               }, function(error) {
                  self.error(error);
               }, self.options);
            };
            do_hanlder.init();
         })(document);
      </script>

   </body>

   </html>