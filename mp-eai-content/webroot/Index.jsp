<HTML>
<HEAD>
<TITLE>登录验证</TITLE>
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
   window.open('/live/Chart.wa', '_self');
}
</SCRIPT>
<BODY style='background-color:#000000;' onload='onLoad()'>
</BODY>
</HEAD>
</HTML>
