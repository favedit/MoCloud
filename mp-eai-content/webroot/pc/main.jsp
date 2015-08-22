<%@ include file='/apl/public.inc' %>
<!DOCTYPE >
<html >
<head>
   <title></title>
   <meta name="viewport" charset="UTF-8" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
   <link rel="stylesheet" type="text/css" href="css/reset.css">
   <link rel="stylesheet" type="text/css" href="css/animate.css">
   <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<script>
function doChart(code){
   id_code.value = code;
   frmMain.submit();
}
</script>
<body>
<FORM name='frmMain' method='post' action='Index.wa'>
<INPUT id='id_do' name='do' type='hidden' value='chart'>
<INPUT id='id_code' name='code' type='hidden'>
   <header class="header floatBtn">
      <div class="head-left"><span>数据中心</span><p class="pl-10">您好，兰壮壮 欢迎登陆！上次登录时间：2015-08-18 17:20:33</p></div>
      <div class="head-right">
         <p class="user-details" id="user-details"><i>3</i>王先生<img src="images/main/icon.png"></p>
         <ul class="users" id="users">
            <li>退出</li>
         </ul>
         <span class="img-details mr-20 pulse">
            <img src='images/main/re.jpeg'>
         </span>
      </div>
   </header>
   <div class="main">
      
      <div class="container">
         <div>
            <div class="headers">
               <span>客<br>户</span>
            </div>
            <ul>
               <li><img src="images/main/bg.png" onclick='doChart("ChartMarketerCustomer")'></li>
            </ul>
         </div>
         <div>
            <div class="headers icon2">
               <span>理<br>财<br>师</span>
            </div>
            <ul><li><img src="images/main/bg.png" onclick='doChart("ChartMarketerMarketer")'></li></ul>
         </div>
         <div>
            <div class="headers icon3">
               <span>公<br>司</span>
            </div>
            <ul><li><img src="images/main/bg.png" onclick='doChart("ChartDepartmentCustomer")'></li></ul>
         </div>
         
      </div>

   </div>
</FORM>
<script type="text/javascript">
   var $userDetails = document.getElementById("user-details");
   var $users = document.getElementById("users");
   $userDetails.onmousemove = function () {
      $users.style.display = "block";
   };
   $userDetails.onmouseout = function () {
      $users.style.display = "none";
   }
   $users.onmousemove = function  (argument) {
      this.style.display = "block";
   }
   $users.onmouseout = function  (argument) {
      this.style.display = "none";
   }
</script>

</body>
</html>