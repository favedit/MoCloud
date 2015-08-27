<%@ include file='/apl/public.inc' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
   <title></title>
   <link rel="stylesheet" type="text/css" href="css/reset.css">
   <link rel="stylesheet" type="text/css" href="css/animate.css">
   <link rel="stylesheet" type="text/css" href="css/login.css">
   <script type="text/javascript" src="/ajs/cookie.js"></script>
</head>
<body style="position: relative;">
   <FORM name='frmMain' style="height:100%;" method='post' action='Index.wa?do=login'>
   <p id="error" style="display: none;"><jh:write source='&page.message' /></p>
   <div class="main">
      <div class="box">
         <div class="logo">
            <img src="images/logos.png">
         </div>
         <div class="box-container">
            <h1>全球实时数据中心</h1>
            <p class="icon mt-30"><i class=""></i><input id="passport" name="passport" class="quantico account"  type="text" placeholder="请输入oa账号"></p>
            <p class="icon icon-p"><i class=" "></i><input id="password" name="password" class="quantico password" type="password" placeholder="密码"></p>
            <p  class="details" ><input id="saveCookie" name="saveCookie" type="checkbox">记住用户名</p>
            <a href="javascript:;" class="btn"><input id="btn" type="submit"  value="登录"></a>
         </div>
      </div>
   </div>
   <footer class="footer">©2015 智慧企业推进中心（北京）<p style="padding-top:5px;">客服电话：010-65499299</p></footer>
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
            <a href="javascript:;"  onclick="setShut();" class="action btn btn18 rbtn">
               <span class="text" id="shut">确定</span>
            </a>
         </div>
      </div>
      <div class="close-btn" onclick="setShut();" id="close-btn">
         <i ></i>
      </div>
   </div>
   <script type="text/javascript">
      var passport = getCookieValue("passport");
      if (passport != "") {
         document.getElementById("saveCookie").checked = true;
      }
      document.getElementById("passport").value = decodeURI(passport);
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
