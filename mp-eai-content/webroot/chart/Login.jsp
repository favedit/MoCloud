<%@ include file='/apl/public.inc' %>
<!DOCTYPE HTML>
<HTML>
<HEAD>
<TITLE>e租宝-全球实时投资数据展示中心(中国)</TITLE>
<META http-equiv='Content-Type' content='text/html;charset=UTF-8'>
<META name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
<LINK rel="stylesheet" href='/acs/mobile.css' type="text/css" media="all"/>
<LINK rel="stylesheet" href='css/style.css' type="text/css" media="all"/>
<SCRIPT>
function onLogin(){
   frmMain.submit();
}
</SCRIPT>
</HEAD>
<BODY scroll='no' style='overflow:hidden;'>
<FORM name='frmMain' style="height:100%;" method='post' action='Live.wa?do=login'>
   <div id='id_login' class="bg">
         <div class="login_box">
            <h1>钰诚-e租宝-全球实时投资数据展示中心中国区</h1>
            <p class="test" style="padding-top:20px;">为保证全球实时投资数据展示中心展示的安全性，</p>
            <p class="test">我们需要您输入用户名和密码，谢谢。</p>
            <p class="error"><jh:write source='&page.message' /></p>
            <div class="container">
               <p><span>用户名：</span><input type="text" name="username" id="username" placeholder="" /></p>
               <p><span>密码：</span><input type="password" id="passport" name="passport" /></p>
               <p style="background:none;"><input style="height: 46px;" type="button" id="btn" value=""/></p>
            </div>
            <p class="prompt" style="padding-top: 25px;">如果需要使用，请联系 钰诚智慧企业推进中心</p>
            <p class="prompt">联系电话：010-65499299</p>
         </div>
   </div>
</FORM>
<script type="text/javascript">
  var $username=document.getElementById('username'),
      $passport=document.getElementById('passport'),
      $btn=document.getElementById('btn');
      $btn.onclick=function() {
         if($username.value != "" && $passport.value !="" ){
            onLogin();
         }else{
            alert("用户名或密码不能为空");
            
         }
      }
</script>
</BODY>
</HTML>
