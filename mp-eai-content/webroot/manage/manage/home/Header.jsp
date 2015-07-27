<!doctype html>
<%@ include file='/cloud/apl/public.inc'%>
<jh:define source="&basePage.user" alias="base"></jh:define>
<html>
<head>
    <meta charset="utf-8">
    <title>17173游戏学院 - 后台管理系统</title>
    <jsp:include page="/cloud/manage/common/newIncloud.jsp"></jsp:include>
</head>
<script>

$(function(){	
	var flag = "<jh:write source='&base.ouid' />";
	if(flag == ""){
		 alert("连接超时！");
		 parent.parent.location.href="/cloud/home/Frame.wa";	
	}
	
	if($('#passport').val() == "admin"){
		$("#databaseLI").show();
	}
});

function loginout(){
    top.location.href="/cloud/home/Frame.wa?do=loginOut";	
}
function productClick(){
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
            <a href="/cloud/manage/home/Frame.wa?do=changePwdPrepare" target="right">[修改密码]</a>&nbsp;&nbsp;&nbsp;
            <span style="color:#666">V.<jh:write source="&basePage.version"/></span>
        </div>
    </div>
	<div id="top_right">
    	<ul class="nav">
            
        	<li class="tb_01">
                <a id="product" class="btn1" href="/cloud/manage/home/Header.wa?do=productLeft&roleId=<jh:write source='&base.roleId' />" 
                target="left">产品管理</a>
            </li>
        	<li class="tb_02">
                 <a class="btn2" href="/cloud/manage/home/Header.wa?do=analysisLeft&roleId=<jh:write source='&base.roleId' />" target="left">产品分析</a>
            </li>
            <li class="tb_04" id="databaseLI" hidden="true">
                 <a class="btn2" href="/cloud/manage/home/Header.wa?do=databaseLeft&roleId=<jh:write source='&base.roleId' />" target="left">数据管理</a>
                 <input id="passport" name="passport" style="display:none" value="<jh:write source='&base.passport'/>"/>
            </li>
        	<li class="tb_03">
                 <a class="btn3" href="/cloud/manage/home/Header.wa?do=manageLeft&roleId=<jh:write source='&base.roleId' />" target="left">后台管理</a>
            </li>

        </ul>
		<div class="closebtn"><a href="#" onClick="loginout();"></a></div>

        <div id="current-time" class="time"></div>
    </div>
</div>
</body>
</html>
