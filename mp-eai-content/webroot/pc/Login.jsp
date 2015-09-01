<%@ include file='/apl/public.inc' %>
<!DOCTYPE html>
<html>
<head>
   <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
   <meta content="always" name="referrer">
   <title></title>
   <link rel="stylesheet" type="text/css" href="css/reset.css">
   <link rel="stylesheet" type="text/css" href="css/animate.css">
   <link rel="stylesheet" type="text/css" href="css/login.css">
   <script type="text/javascript" src="/ajs/cookie.js"></script>
</head>
<body>
   <table  class="table" border="0" align="center" valign="center" cellpadding="0" cellspacing="0" border="0" width="100%" height="100%">
      <tbody>
      <tr id="heads">
         <td></td>
     </tr>
     <tr id="mains">
       <td>
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
          </FORM> 
          </td>
     </tr>

     <tr id="footers" >
       <td>
         <div class="footer">©2015 智慧企业推进中心（北京）<p style="padding-top:5px;">客服电话：010-65499299</p></div>
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
</body>
