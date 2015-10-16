<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file='/apl/public.inc'%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"manage/mobile/";
%>
<jh:define source="&page.unit" alias="unit"></jh:define>
<!DOCTYPE >
<html>
<head>
   <base href="<%=basePath%>">
   <meta name="viewport" charset="UTF-8" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
   <link rel="stylesheet" type="text/css" href="<%=basePath%>/salestools/contentlist/css/index.css">
</head>
<body>
   <div class="box">
   <header class="header">
      <h4><jh:write source="&unit.label"></jh:write></h4>
      <p><%-- <span><jh:write source="&page.userLabel" format="text"></jh:write></span><i><jh:date source="&unit.createDate" format="yyyy-mm-dd"></jh:date></i> --%></p>
   </header>
   <div class="main">
     <jh:write source="&unit.content" format="text"></jh:write>
   </div>
   </div>
</body>
</html>