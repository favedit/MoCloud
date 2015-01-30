<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file='/design/apl/public.inc'%>
<html>
<head>
<title>贪吃西游运营平台</title>
<jg:css/>
<jg:js type='runtime'/>
<jsp:include page="../component/jeui.jsp"></jsp:include>
<script>
$(function(){
	var flag = "<jh:write source='&basePage.flag' />";
	//alert(flag);
	if(flag == "0"){
		top.alertx("连接超时，请重新登录！","info",function(){
			parent.location.href="/tcxy/Index.wa";	
	    });
	}
});
function menu(url){
	progress();
	window.open(url+"&date="+new Date().valueOf(),"ifMain");
}
</script>
</head>
<body>
    <div class="easyui-layout" fit='true' style="height:660px;" >
		<div data-options="region:'north'" style="height:85px;">
          <table width="100%" border="0">
            <tr>
              <th colspan="2" align="center"><h2>贪吃西游运营平台</h2></th>
            </tr>
            <tr>
              <td align="right">
              <span>欢迎[<font color="#FF0000"><jh:write source="&user.user_name"/></font>]登录</span>
              <a href="javascript:void(0)"  class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="changePwd()" id="btn"  >修改密码</a>&nbsp;&nbsp; 
              <a href="javascript:void(0)"  class="easyui-linkbutton" onClick="loginout();" iconCls="icon-redo" plain="true" name="btn" id="btn"  >注销</a></td>
            </tr>
          </table>             
        </div>
		<div data-options="region:'west',split:true" title="系统菜单" style="width:160px;"><br>
               <ul class="easyui-tree">
               		<jh:equals source="&user.user_state_authority" value="0">
                        <li data-options="state:'closed'">
                           <span>超级管理</span>
                            <ul>
                                <li>
                                    <span><a onClick="menu('/tcxy/admin/user/User.wa?do=jumpToThisPage');" id="btn" >用户管理</a></span>
                                </li>
                                <li>
                                   <span><a onClick="menu('/tcxy/admin/database/Database.wa?do=jumpToThisPage');" id="btn" >服务器管理</a></span>
                                </li>
                            </ul>
                        </li>
                       </jh:equals>
                        <li>
                            <span>普通信息</span>
                            <ul>
                                <li><a onClick="menu('/tcxy/admin/pay/Pay.wa?do=jumpToThisPage');" id="btn" >充值信息</a></li>
                                <li><a onClick="menu('/tcxy/admin/player/Player.wa?do=jumpToThisPage');" id="btn" >玩家信息</a></li>
                                <li><a onClick="menu('/tcxy/admin/activity/Activity.wa?do=jumpToThisPage');" id="btn" >活动信息</a></li>
                                <li><a onClick="menu('/tcxy/admin/notice/Notice.wa?do=jumpToThisPage');" id="btn" >走马灯信息</a></li>
                            </ul>
                        </li>
                        <jh:equals source="&user.user_state_authority" value="0">
                        <li>
                            <span>运算结果</span>
                            <ul>
                                <li><a onClick="" id="btn" >基础数据</a></li>
                                <li><a onClick="" id="btn" >充值排行</a></li>
                            </ul>
                        </li>
                        </jh:equals>
                    </ul>     
        </div>
		<div data-options="region:'center',title:'主窗体',iconCls:'icon-ok'">
         <iframe width="100%" height="99%" src="/tcxy/admin/home/Body.wp" scrolling="auto" frameborder="0" id="ifMain" name="ifMain"></iframe>			
		</div>
	</div>
</body>
</html>
