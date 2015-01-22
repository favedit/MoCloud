<!doctype html>
<%@ include file='/manage/apl/public.inc'%>
<jh:define source="&basePage.user" alias="base"></jh:define>
<html>
<head>
    <meta charset="utf-8">
    <title>17173游戏学院 - 后台管理系统</title>
    <jsp:include page="/manage/common/newIncloud.jsp"></jsp:include>
</head>
<script>

$(function(){	
	var flag = "<jh:write source='&base.ouid' />";
	if(flag == ""){
		 alert("连接超时！");
		 parent.parent.location.href="/manage/login/Login.wa";	
	}
});

function loginout(){
    top.location.href="/manage/login/Login.wa";	
}
function productClick(){
	return;
	
	setInterval(function() { var now = (new Date()).toLocaleString(); 
     $('#current-time').html("日期："+now); }, 1000);
	document.getElementById("product").click();
}
</script>
<body bgcolor="#198bc9" onLoad="productClick()">
<div id="cy_header">
	<div id="top_left">
    	<div class="welcom">
        	欢迎 <span style="color:#F90"><jh:write source="&base.label"/></span> 登录 &nbsp;&nbsp;&nbsp;
            <a href="/manage/login/Login.wa?do=changePwdPrepare" target="right">[修改密码]</a>&nbsp;&nbsp;&nbsp;
            <span style="color:#666">V.<jh:write source="&basePage.version"/></span>
        </div>
    </div>
	<div id="top_right">
    	<ul class="nav">
            
        	<li class="tb_01">
                <a id="product" class="btn1" href="/manage/home/Header.wa?do=productLeft/>" 
                target="left">产品管理</a>
            </li>
        	<li class="tb_02">
                 <a class="btn2" href="/manage/home/Header.wa?do=analysisLeft/>" target="left">产品分析</a>
            </li>
            <li class="tb_04">
                 <a class="btn2" href="/manage/home/Header.wa?do=databaseLeft/>" target="left">数据管理</a>
            </li>
        	<li class="tb_03">
                 <a class="btn3" href="/manage/home/Header.wa?do=manageLeft/>" target="left">后台管理</a>
            </li>

        </ul>
		<div class="closebtn"><a href="#" onClick="loginout();"></a></div>

        <div id="current-time" class="time"></div>
    </div>
</div>
</body>
</html>
