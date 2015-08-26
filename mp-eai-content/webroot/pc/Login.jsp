<%@ include file='/apl/public.inc' %>
   <!DOCTYPE>
   <html>

   <head>
      <title></title>
      <link rel="stylesheet" type="text/css" href="css/reset.css">
      <link rel="stylesheet" type="text/css" href="css/animate.css">
      <link rel="stylesheet" type="text/css" href="css/login.css">
      <script type="text/javascript" src="/ajs/cookie.js"></script>
   </head>

   <body>
      <FORM name='frmMain' style="height:100%;" method='post' action='Index.wa?do=login'>
         <p id="error" style="display: none;"><jh:write source='&page.message' /></p>
         <div class="main">
            <div class="box">
               <div class="logo">
                  <img src="images/logos.png">
               </div>
               <div class="box-container">
                  <h1>全球实时数据中心</h1>
                  <p class="icon mt-30"><i class=""></i>
                     <input id="passport" name="passport" class="quantico account" type="text" placeholder="账号">
                  </p>
                  <p class="icon icon-p"><i class=" "></i>
                     <input id="password" name="password" class="quantico password" type="password" placeholder="密码">
                  </p>
                  <p class="details">
                     <input id="savePass" onclick="saveCookie(this)" type="checkbox">记住用户名</p>
                  <a href="javascript:;" class="btn">
                     <input id="btn" type="submit" value="登录">
                  </a>
               </div>
            </div>
         </div>
         <footer class="footer">©2015 智慧企业推进中心（北京）</footer>

         <div class="dialog-overlay" id="dialog-overlay"></div>
         <div id="dialog_alert" data-name="alert" class="dialog-box flipInX">
            <div class="box-title">提示</div>
            <div class="box-inner">
               <div class="info-text">
                  <i class="icon-caution"></i>
                  <span id="prompt_val"></span>
               </div>
            </div>
            <div class="box-bottom">
               <div class="buttons">
                  <a href="#" onclick="return false;" class="action btn btn18 rbtn">
                     <span class="text" id="shut">确定</span>
                  </a>
               </div>
            </div>
            <div class="close-btn" id="close-btn">
               <i></i>
            </div>
         </div>
         <script type="text/javascript">
            var pass = document.getElementById("passport");
            var passport = getCookieValue("passport");
            if (passport != "") {
               document.getElementById("savePass").checked = true;
            }
            pass.value = passport;
            function saveCookie(o) {
               alert(o.checked);
               if (o.checked) {
                  setCookie("passport", pass.value, 24, "/");
               } else {
                  deleteCookie("passport", "/");
               }
            }
            var $dialogOverlay = document.getElementById("dialog-overlay");
            var $dialogAlert = document.getElementById("dialog_alert");
            var errorVal = document.getElementById("error").innerHTML;
            if (errorVal != "") {
               setPrompt(errorVal);
            }

            function setShut() {
               $dialogOverlay.style.display = "none";
               $dialogAlert.style.display = "none";
            }
            document.getElementById("close-btn").onclick = function() {
               setShut();
            }
            document.getElementById("shut").onclick = function() {
               setShut();
            }

            function setPrompt(val) {
               document.getElementById("prompt_val").innerHTML = val;
               $dialogOverlay.style.display = "block";
               $dialogAlert.style.display = "block";
            }
            var $username = document.getElementById('passport');
            var $password = document.getElementById('password');
            var $btn = document.getElementById('btn');
            $btn.onclick = function() {
               if ($username.value == "" || $password.value == "") {
                  setPrompt("用户名或密码不能为空");
                  return false;
               } else {
                  frmMain.submit();
               }
            }

            
         </script>
      </FORM>
   </body>

   </html>