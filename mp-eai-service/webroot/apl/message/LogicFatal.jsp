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
		<h1>当前系统错。</h1>
	</div>
   <HR>
   <DIV style='color:red'><jh:write source='&message.message'/></DIV>
   <HR>
   <DIV style='color:red'><jh:write source='&message.description' format='text'/></DIV>
</BODY>
</HEAD>
</HTML>
