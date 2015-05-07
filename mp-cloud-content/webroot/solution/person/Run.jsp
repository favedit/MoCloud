<%@ include file='/apl/public.inc' %>
<jh:define source='&page.user' alias='user'/>
<!DOCTYPE HTML>
<HTML>
<HEAD>
<TITLE>CoolLight Designer</TITLE>
<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
<META content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport"/>
<LINK rel="stylesheet" href='/script/acs/mobile.css' type="text/css" media="all"/>
<SCRIPT language='javascript' src='/script/ajs/lzma.js'></SCRIPT>
<SCRIPT language='javascript' src='/script/ajs/lzma_worker.js'></SCRIPT>
<SCRIPT language='javascript' src='/script/ajs/mo.js'></SCRIPT>
<SCRIPT language='javascript' src='/script/ajs/context_cn.js'></SCRIPT>
<SCRIPT>
var canvas = null;
var display = null;
var movie = false;
//------------------------------------------------------------
function onEnterFrame(){
   if(display){
      var m = display.matrix();
      m.ry -= 0.004;
      m.updateForce();
   }
}
//------------------------------------------------------------
function onSceneLoad(c, s){
   //s.addEnterFrameListener(null, onEnterFrame);
   //canvas.switchPlay(true);
   //canvas.switchMovie(true);
}
//------------------------------------------------------------
function onKeydown(p){
   var e = window.event;
   var c = e.keyCode;
   if(c == EKeyCode.Space){
      movie = !movie;
      canvas.switchMovie(movie);
   }
}
//------------------------------------------------------------
function doCanvasAction(p, f){
   canvas.doAction(window.event, p, f);
}
//------------------------------------------------------------
function onLoad(){
   // 环境设置
   RRuntime.setProcessCd(EProcess.Release);
   RApplication.initialize();
   RBrowser.setContentPath('/script');
   // 获得场景代码
   var url = window.location.toString();
   var find = url.indexOf('guid=');
   var guid = null;
   if(find != -1){
      guid = url.substring(find + 5);
   }
   if(RString.isEmpty(guid)){
      throw new TFatal(this, 'Space guid is empty.');
   }
   // 设置资源获取方式
   RConsole.find(FE3sVendorConsole).setup('net');
   // 创建场景画板
   canvas = RClass.create(FE3dSceneCanvas);
   canvas._scaleRate = 1;
   canvas._optionAlpha = false;
   canvas.build(document);
   canvas.setPanel(document.body);
   canvas.loadByGuid(guid);
   canvas.addLoadListener(null, onSceneLoad);
}
</SCRIPT>
</HEAD>
<BODY scroll='no' style='background-color:#000000;overflow:hidden;' onload='onLoad()' onkeydown='onKeydown()'>
   <DIV style='position:absolute; left:1em; top:1em;'>
      <IMG src='/script/ars/picture/fullscreen.png' style='width:5em; height:5em;' onmousedown='doCanvasAction("fullscreen")' ontouchstart='doCanvasAction("fullscreen")'>
   </DIV>
   <DIV style='position:absolute; right:1em; top:1em;'>
      <IMG src='/script/ars/picture/play.png' style='width:5em; height:5em;' onmousedown='doCanvasAction("play")' ontouchstart='doCanvasAction("play")'>
   </DIV>
   <DIV style='position:absolute; left:1em; bottom:1em;'>
      <TABLE>
         <TR>
            <TD><IMG src='/script/ars/picture/arrow_up.png' style='width:5em; height:5em;' onmousedown='doCanvasAction("up", true)' onmouseup='doCanvasAction("up", false)' ontouchstart='doCanvasAction("up", true)' ontouchend='doCanvasAction("up", false)'></TD>
         </TR>
         <TR>
            <TD height='0.5em'></TD>
         </TR>
         <TR>
            <TD><IMG src='/script/ars/picture/arrow_down.png' style='width:5em; height:5em;' onmousedown='doCanvasAction("down", true)' onmouseup='doCanvasAction("down", false)' ontouchstart='doCanvasAction("down", true)' ontouchend='doCanvasAction("down", false)'></TD>
         </TR>
      </TABLE>
   </DIV>
   <DIV style='position:absolute; right:1em; bottom:1em;'>
      <TABLE>
         <TR>
            <TD><IMG src='/script/ars/picture/arrow_up.png' style='width:5em; height:5em;'onmousedown='doCanvasAction("forward", true)' onmouseup='doCanvasAction("forward", false)' ontouchstart='doCanvasAction("forward", true)' ontouchend='doCanvasAction("forward", false)'></TD>
         </TR>
         <TR>
            <TD height='0.5em'></TD>
         </TR>
         <TR>
            <TD><IMG src='/script/ars/picture/arrow_down.png' style='width:5em; height:5em;' onmousedown='doCanvasAction("back", true)' onmouseup='doCanvasAction("back", false)' ontouchstart='doCanvasAction("back", true)' ontouchend='doCanvasAction("back", false)'></TD>
         </TR>
      </TABLE>
   </DIV>
</BODY>
</HTML>
