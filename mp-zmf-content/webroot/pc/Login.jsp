<%@ include file='/apl/public.inc' %>
<!DOCTYPE html>
<html>
<head>
   <title>全球实时投资数据展示中心—钰诚集团智慧企业</title>
   <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
   <meta content="always" name="referrer">
   <link rel="stylesheet" type="text/css" href="css/reset.css">
   <link rel="stylesheet" type="text/css" href="css/animate.css">
   <link rel="stylesheet" type="text/css" href="css/login.css">
   <script type="text/javascript" src="js/jquery.min.js"></script>
   <script type="text/javascript" src="/ajs/cookie.js"></script>
   <style type="text/css">

   </style>
</head>
<body>
   <table  cellpadding="0" cellspacing="0" border="0" width="100%" height="100%" >
      <tbody>
      <tr id="heads">
         <td height="50"  align="center" valign="center"  >
          <img src="images/main/logos.png">
        </td>
     </tr>
     <tr id="mains">
       <td align="center" valign="center">
          <FORM name='frmMain' method='post' action='Index.wa?do=login'>
            <p id="error" style="display: none;"><jh:write source='&page.message' /></p>
            <div class="main">
              <div class="main-container">
                <ul class="details-container">
                  <p><b>用户名</b><input id="passport" name="passport" class="quantico account"  type="text" placeholder="请输入oa账号"></p>
                  <p><b>密<i>码</i>码</b><input input id="password" name="password" class="quantico password" type="password" placeholder="密码"></p>
                  <span class="details" ><input id="saveCookie" name="saveCookie" type="checkbox">记住用户名</span>
                  <span class="btn-container" ><input input id="btn" type="submit"  value=""></span>
                </ul>
              </div>

            </div>
       
          </FORM> 
        </td>
     </tr>
     <tr  id="footers" border="1">
       <td height="100">
         <div class="footer">©2015 钰诚集团智慧企业推进中心（北京）<p style="padding-top:5px;">客服电话：010-65499299</p></div>
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
      var $btnContainer =  document.getElementsByClassName("btn-container")[0];
      if (errorVal != "") {
         $btnContainer.style.backgroundImage="url(images/6.png)";
      }


      function setPrompt(val) {
         document.getElementById("prompt_val").innerHTML = val;
         $dialogOverlay.style.display = "block";
         $dialogAlert.style.display = "block";
      }
      var $username = document.getElementById('passport');
      var $password = document.getElementById('password');
      var $btn = document.getElementById('btn');
      
      function setFocus(){

      }
      $username.onfocus=function(){
         $btnContainer.style.backgroundImage="url(images/2.png)";
      }
      $password.onfocus=function(){
         $btnContainer.style.backgroundImage="url(images/2.png)";
      }
      function setBackgroundImage (){
         $btnContainer.style.backgroundImage="url(images/7.png)";
      }
      
      $btn.onclick = function() {
         if ($username.value == "" || $password.value == "") {
            // setPrompt("用户名或密码不能为空");
            // $btnContainer.style.backgroundImage="images/7.png";
          setBackgroundImage();
         // $(".btn-container").addClass("on");
            return false;
         } else {
            // frmMain.submit();
         }
      }
   </script>      
</body>
