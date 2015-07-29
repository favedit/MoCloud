<!DOCTYPE HTML>
<HTML>
<HEAD>
<META http-equiv='Content-Type' content='text/html;charset=UTF-8'>
<TITLE>登录中</TITLE>
<SCRIPT language='javascript' src='/ajs/me.js'></SCRIPT>
<SCRIPT>
function onLoad(){
   // 设置变量
   MO.initialize();
   MO.Window.Browser.setContentPath('.');
   // 设置应用
   var application = MO.Desktop.initialize(MO.FTestApplication);
   application.setup(document.body);
   // 页面跳转
   window.location = '/live/Chart.wa';
}
</SCRIPT>
<BODY style='background-color:#000000;' onload='onLoad()'>
</BODY>
</HEAD>
</HTML>
