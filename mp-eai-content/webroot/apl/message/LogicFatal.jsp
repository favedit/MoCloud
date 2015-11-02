<%@ page contentType='text/html;charset=utf-8' %>
<%@ include file='/apl/public.inc' %>
<!DOCTYPE HTML>
<HTML>
<HEAD>
<META http-equiv='Content-Type' content='text/html;charset=UTF-8'>
<meta name="viewport" charset="UTF-8" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
<link rel="stylesheet" type="text/css" href="../../apl/message/css/logicFatal.css">
<TITLE>错误页面中</TITLE>
<BODY >
	<div class="main">
		<h1>当前系统繁忙，请您尝试以下地址：</h1>
		<p><a href="http://eai.ezubo.com/">http://eai.ezubo.com<span id="countdown">(5)<span></a></p>
	</div>
<script type="text/javascript">
	var wait = 6;
	setTiming(document.getElementById("countdown"));
	function setTiming(o) {
        if (wait == 0) {
          window.location.href = "http://eai.ezubo.com/";
        } else {
           wait--;
           o.innerHTML = "("+wait+")";
           setTimeout(function() {
              setTiming(o);
           }, 1000)
        }
     };
</script>	
<DIV id='id_message' style='color:red'>
<jh:write source='&message.description'/>
</DIV>
         <!-- Piwik -->
<script type="text/javascript">
  var _paq = _paq || [];
  _paq.push(['trackPageView']);
  _paq.push(['enableLinkTracking']);
  (function() {
    var u="//tongji.ycgj.com:8081/piwik/";
    _paq.push(['setTrackerUrl', u+'piwik.php']);
    _paq.push(['setSiteId', 7]);
    var d=document, g=d.createElement('script'), s=d.getElementsByTagName('script')[0];
    g.type='text/javascript'; g.async=true; g.defer=true; g.src=u+'piwik.js'; s.parentNode.insertBefore(g,s);
  })();
</script>
<noscript><p><img src="//tongji.ycgj.com:8081/piwik/piwik.php?idsite=7" style="border:0;" alt="" /></p></noscript>
<!-- End Piwik Code -->
</BODY>
</HEAD>
</HTML>
