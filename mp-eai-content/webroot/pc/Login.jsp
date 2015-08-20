<%@ include file='/apl/public.inc' %>
<!DOCTYPE>
<html >
<head>
   <title></title>
   <meta name="viewport" charset="UTF-8" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
   <link rel="stylesheet" type="text/css" href="css/reset.css">
   <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
   <FORM name='frmMain' style="height:100%;" method='post' action='Index.wa?do=login'>
   <div class="main">
      <div class="box">
         <div class="logo">
            <img src="images/logos.png">
         </div>
         <div class="box-container">
            <h1>全球实时数据中心</h1>
            <p><input id="passport" name="passport" class="quantico account" style="margin-top: 40px;" type="text" placeholder="账号"></p>
            <p><input id="password" name="password" class="quantico password" type="password" placeholder="密码"></p>
            <p  class="details" ><input type="checkbox">记住用户名</p>
            <a href="javascript:;" class="btn"><input id="btn" type="submit"  value="登录"></a>
            
         </div>

      </div>
   </div>
   <footer class="footer">©2015 智慧企业推进中心（北京）</footer>
   <script type="text/javascript">
         var $username = document.getElementById('passport');
         var $password = document.getElementById('password');
         var $btn = document.getElementById('btn');
         // var err = document.getElementById('error');
         $btn.onclick = function() {
            if ($username.value == "" || $password.value == "") {
               // err.innerHTML = "用户名或密码不能为空";
               alert("用户名或密码不能为空");
               return;
            } else {
               frmMain.submit();
            }
         }
   </script>
   </FORM>
</body>
</html>
