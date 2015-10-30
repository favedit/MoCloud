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
          //window.location.href = "http://eai.ezubo.com/";
        } else {
           wait--;
           o.innerHTML = "("+wait+")";
           setTimeout(function() {
              setTiming(o);
           }, 1000)
        }
     };
</script>	
<jh:write source='&message.description' format='text'/>
</BODY>
</HEAD>
</HTML>
