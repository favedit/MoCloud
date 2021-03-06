<!DOCTYPE HTML>
<HTML>

<HEAD>
   <TITLE>e租宝-百亿历程</TITLE>
   <META http-equiv='Content-Type' content='text/html;charset=UTF-8'>
   <META name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
   <LINK rel="stylesheet" href='acs/mobile.css' type="text/css" media="all" />
   <SCRIPT language='javascript' src='ajs/lzma.js'></SCRIPT>
   <SCRIPT language='javascript' src='ajs/me.js'></SCRIPT>
   <SCRIPT language='javascript' src='ajs/eai.js'></SCRIPT>
   <SCRIPT language='javascript' src='ajs/context_cn.js'></SCRIPT>
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

      function onLoaded(event) {
         clearInterval(g_loadingHandle);
      }

      function onLoad() {
         // 设置变量
         MO.initialize();
         MO.Runtime.setProcessCd(MO.EProcess.Debug);
         MO.Window.Browser.setContentPath('..');
         MO.Window.Browser.fullscreen(window, true);
         MO.Window.lsnsLoaded.register(null, onLoaded);
         MO.Window.lsnsDeviceError.register(null, onDeviceError);
         // 设置环境
         MO.Console.find(MO.FE3sVendorConsole).setup('net');
         MO.Console.find(MO.FEnvironmentConsole).registerValue(MO.EEaiConstant.ServiceHost, '115.28.201.170');
         MO.Console.find(MO.FEnvironmentConsole).registerValue(MO.EEaiConstant.Resource, '/ars/eai');
         // 设置应用
         var application = MO.Desktop.initialize(MO.FEaiChartApplication);
         application.setSceneCode(MO.EEaiScene.ChartHistory);
         application.setup(document.body);
      }
   </SCRIPT>
</HEAD>

<body scroll='no' style='position:relative;overflow:hidden;background-color:#000000;background-size:100% 100%;' onload='onLoad()'>
   <table id='id_loading' style='position:absolute;left:0px;top:0px;width:100%;height:100%;background:url("/ars/eai/loading/background.jpg");background-size:100% 100%;'>
      <tr>
         <td align='center'>
            <div id="loading_img">
               <div id="loading_img_div" style="position:relative;width:128px;">
                  <img style="position:absolute;opacity:0.8;width:127;height:127;" src="/ars/eai/loading/loading7.png">
                  <img style="position:absolute;opacity:0.7;width:127;height:127;" src="/ars/eai/loading/loading6.png">
                  <img style="position:absolute;opacity:0.6;width:127;height:127;" src="/ars/eai/loading/loading5.png">
                  <img style="position:absolute;opacity:0.5;width:127;height:127;" src="/ars/eai/loading/loading4.png">
                  <img style="position:absolute;opacity:0.4;width:127;height:127;" src="/ars/eai/loading/loading3.png">
                  <img style="position:absolute;opacity:0.3;width:127;height:127;" src="/ars/eai/loading/loading2.png">
                  <img style="position:absolute;opacity:0.2;width:127;height:127;" src="/ars/eai/loading/loading1.png">
                  <img style="opacity:0.1;width:127;height:127;" src="/ars/eai/loading/loading8.png">
               </div>
               <img src='/ars/eai/loading/loading.png' style='padding-top:30px;padding-left:20px;width:196;height:36'>
            </div>
         </td>
      </tr>
   </table>
   <table id='id_error' style='position:absolute;left:0px;top:0px;width:100%;height:100%;background-size:100% 100%;display:none;'>
      <tr>
         <td align='center'>
            <img style="width:100%;" id="error_img">
            <br>
         </td>
      </tr>
   </table>
   <script>
      doLoading();
   </script>
</body>

</html>