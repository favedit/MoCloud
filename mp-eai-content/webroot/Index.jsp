<!DOCTYPE HTML>
<HTML>
<HEAD>
<META http-equiv='Content-Type' content='text/html;charset=UTF-8'>
<TITLE>登录中</TITLE>
<SCRIPT language='javascript' src='/ajs/ml.js'></SCRIPT>
<SCRIPT>
function onLoad(){
   // 设置变量
   MO.initialize();
   MO.Window.Browser.setContentPath('.');
   MO.Window.Browser.construct();
   MO.Window.connect(window);
   //..........................................................
   // 创建信息
   var xroot = new MO.TXmlNode('Configuration');
   var identityCode = MO.Window.Browser.agent();
   // 创建浏览器信息
   var xbrowser = xroot.create('Browser')
   MO.Window.Browser.saveConfig(xbrowser);
   // 创建桌面节点
   var xdesktop = xbrowser.create('Desktop')
   var xcontext2d = xdesktop.create('Context2d');
   var xcontext3d = xdesktop.create('Context3d');
   // 创建桌面信息
   var hCanvas = MO.Window.Builder.create(document.body, 'CANVAS');
   var context3d = MO.Graphic.Context3d.createContext(MO.FWglContext, hCanvas);
   if(context3d){
      var parameter = context3d.parameter('VERSION');
      if(parameter){
         identityCode += '|' + parameter;
      }
      var parameter = context3d.parameter('SHADING_LANGUAGE_VERSION');
      if(parameter){
         identityCode += '|' + parameter;
      }
      var parameter = context3d.parameter('UNMASKED_RENDERER_WEBGL');
      if(parameter){
         identityCode += '|' + parameter;
      }
      context3d.saveConfig(xcontext3d);
   }
   // 设置鉴定码
   xroot.set('identity_code', identityCode);
   MO.Console.find(MO.FServiceConsole).send('cloud.info.device', 'access', xroot);
   //..........................................................
   // 页面跳转
   if(MO.Runtime.isPlatformMobile()){
      console.log("mb");
      window.location = '/mb/Index.wa';
   }else{
      console.log("pc");
      window.location = '/pc/Index.wa';
   }
}
</SCRIPT>
<BODY style='background-color:#000000;' onload='onLoad()'>
</BODY>
</HEAD>
</HTML>
