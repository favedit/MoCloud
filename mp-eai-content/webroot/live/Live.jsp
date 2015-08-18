<%@ include file='/apl/public.inc' %>
<!DOCTYPE HTML>
<HTML>
<HEAD>
<TITLE>e租宝-全球实时投资数据展示中心(中国)</TITLE>
<META http-equiv='Content-Type' content='text/html;charset=UTF-8'>
<META name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
<LINK rel="stylesheet" href='/acs/mobile.css' type="text/css" media="all" />
<SCRIPT language='javascript' src='/ajs/mc.js'></SCRIPT>
<SCRIPT>
   var g_loadingHandle;
   function doLoading() {
      var htmlBody = document.body;
      htmlBody.style.backgroundImage = 'url(/ars/eai/background.jpg)';
      var hImages = document.getElementById("loading_img_div").getElementsByTagName("img");
      var index = [7, 6, 5, 4, 3, 2, 1, 0];
      g_loadingHandle = setInterval(function() {
         for (var i = 0; i < index.length; i++) {
            hImages[index[i]].style.opacity = 0.1 + (0.1 * i);
            if (i == index.length - 1) {
               index.push(index[0]);
               index.splice(0, 1);
            }
         }
      }, 80);
   }
   function onDeviceError(event) {
      var hLoading = document.getElementById("id_loading")
      document.body.removeChild(hLoading);
      var hError = document.getElementById("id_error");
      hError.style.backgroundImage = 'url(/ars/eai/loading/background.jpg)';
      document.getElementById("error_img").src = "/ars/eai/loading/error.png";
      MO.Window.Html.visibleSet(hError, true);
   }
   function oniOSStart(event) {
       var hLoading = document.getElementById("id_ios_play")
       document.body.removeChild(hLoading);
       MO.Console.find(MO.FAudioConsole).select();
       var liveScene = MO.Desktop.application().activeChapter().activeScene();
       liveScene._statusLayerLevel = -1;
       liveScene._groundAutio.play(0);
       liveScene._countryEntity._audioMapEnter.play(0);
   }
   function onLoaded(event) {
      clearInterval(g_loadingHandle);
   }
   function onLoadScript() {
      // 设置变量
      MO.initialize();
      MO.Window.Browser.setContentPath('..');
      MO.Window.Browser.fullscreen(window, true);
      MO.Window.lsnsLoaded.register(null, onLoaded);
      MO.Window.lsnsDeviceError.register(null, onDeviceError);
      // 设置环境
      MO.Console.find(MO.FE3sVendorConsole).setup('net');
      MO.Console.find(MO.FEnvironmentConsole).registerValue(MO.EEaiConstant.Resource, '/ars/eai');
      MO.Console.find(MO.FEnvironmentConsole).registerValue(MO.EEaiConstant.ServiceHost, '<jh:write source='&page.serviceHost'/>');
      // 设置应用
      var application = MO.Desktop.initialize(MO.FEaiChartApplication);
      application.setSceneCode(MO.EEaiScene.<jh:write source='&page.sceneCode'/>);
      application.setup(document.body);
   }
   function onLoad(){
      MO.initialize();
      RJsLoader.loadUrl('../ajs/eai.jc', onLoadScript);
   }
</SCRIPT>
</HEAD>
<BODY scroll='no' style='position:relative;overflow:hidden;background-color:#000000;background-size:100% 100%;' onload='onLoad()'>
   <TABLE id='id_ios_play' style='position:absolute;left:0px;top:0px;width:100%;height:100%;background-size:100% 100%;display:none' onclick="oniOSStart()">
       <TR>
           <TD align='center'>
               <DIV id="ios_play_img">
                   <IMG src='/ars/eai/player.png'>
               </DIV>
           </TD>
       </TR>
   </TABLE>
   <TABLE id='id_loading' style='position:absolute;left:0px;top:0px;width:100%;height:100%;background:url("/ars/eai/loading/background.jpg");background-size:100% 100%;'>
      <TR>
         <TD align='center'>
            <DIV id="loading_img">
               <DIV id="loading_img_div" style="position:relative;width:128px;">
                  <IMG style="position:absolute;opacity:0.8;width:127;height:127;" src="/ars/eai/loading/loading7.png">
                  <IMG style="position:absolute;opacity:0.7;width:127;height:127;" src="/ars/eai/loading/loading6.png">
                  <IMG style="position:absolute;opacity:0.6;width:127;height:127;" src="/ars/eai/loading/loading5.png">
                  <IMG style="position:absolute;opacity:0.5;width:127;height:127;" src="/ars/eai/loading/loading4.png">
                  <IMG style="position:absolute;opacity:0.4;width:127;height:127;" src="/ars/eai/loading/loading3.png">
                  <IMG style="position:absolute;opacity:0.3;width:127;height:127;" src="/ars/eai/loading/loading2.png">
                  <IMG style="position:absolute;opacity:0.2;width:127;height:127;" src="/ars/eai/loading/loading1.png">
                  <IMG style="opacity:0.1;width:127;height:127;" src="/ars/eai/loading/loading8.png">
               </DIV>
               <IMG src='/ars/eai/loading/loading.png' style='padding-top:30px;padding-left:20px;width:196;height:36'>
            </DIV>
         </TD>
      </TR>
   </TABLE>
   <TABLE id='id_error' style='position:absolute;left:0px;top:0px;width:100%;height:100%;background-size:100% 100%;display:none;'>
      <TR>
         <TD align='center'>
            <IMG style="width:100%;" id="error_img">
            <BR>
         </TD>
      </TR>
   </TABLE>
   <SCRIPT>doLoading();</SCRIPT>
</BODY>
</HTML>
