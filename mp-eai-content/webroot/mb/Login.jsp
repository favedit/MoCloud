<%@ include file='/apl/public.inc' %>
 <!DOCTYPE >
<html >
<head>
   <title></title>
   <meta name="viewport" charset="UTF-8" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
   <link rel="stylesheet" type="text/css" href="css/reset.css">
   <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
   <FORM name='frmMain' style="height:100%;" method='post' action='Index.wa?do=login'>
   <div class="wap-main">
         <div class="wap-logo">
            <img src="images/logos.png">
         </div>
         <div class="wap-box-container">
            <p class="wap-title">账号</p>
            <p class="content"><input name="passport"  id="passport" type="text" placeholder=""></p>
            <p class="wap-title password">密码</p>
            <p class="content "><input id="password" name="password" type="password" ></p>
            <a href="javascript:;" class="wap-btn"><input type="submit" id="btn" value="登录"></a>
         </div>
   </div>
   <footer class="wap-footer">©2015 智慧企业推进中心（北京）</footer>
   <script type="text/javascript">
         var $username = document.getElementById('passport');
         var $password = document.getElementById('password');
         var $btn = document.getElementById('btn');
         $btn.onclick = function() {
            if ($username.value == "" || $password.value == "") {
               alert("用户名或密码不能为空");
               return false;
            } else {
               frmMain.submit();
            }
         }
   </script>
   </FORM>
</body>
</html>
