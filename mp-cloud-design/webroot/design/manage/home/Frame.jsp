<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file='/design/apl/public.inc'%>
<jh:define source="&basePage.user" alias="base"></jh:define>
<html>
<head>
<title>后台管理系统</title>
<jg:css/>
<jg:js type='runtime'/>
<jsp:include page="../component/jeui.jsp"></jsp:include>
<script>
$(document).ready(function(e) {
    cover();
	$(window).resize(function(){
		cover();	
	});
});
function cover(){
       var win_width = $(window).width(); 
       var win_height = $(window).height(); 
	  // alert(win_height);
	   //$("#easyui-layout").attr("height",win_height);
	   //document.getElementById("#easyui_layout").style.height=win_height+"px";
//	   $("#easyui-layout").layout("panel", "center").panel({height:win_height});
}
var index = 0;
function addPanel(url,title){
	index++;	
	var content="<div style='padding:10px'><iframe width='100%' height='99%' src='/design/manage/home/Body.wp' scrolling='auto' frameborder='0' id='ifMain' name='ifMain"+index+"'></iframe></div>";
	$('#tt').tabs('add',{
		title: title+index,
		content: content,
		closable: true
	});
	window.open(url+"?date="+new Date().valueOf(),"ifMain"+index);
}
</script>
</head>
<body style="padding:0px;">
    <div id="easyui_layout" class="easyui-layout" fit="true" style="height:879px" >
		<div data-options="region:'north'" style="height:80px;">
          <table width="100%" border="0">
            <tr>
              <th colspan="2" align="center"><h2>后台管理系统</h2></th>
            </tr>
            <tr>
              <td align="right"><span style="">欢迎[<font color="#FF0000"><jh:write source="&base.passport"/></font>]登录</span></td>
              <td align="right" style="width:150px">              
              <a href="javascript:void(0)"  class="easyui-linkbutton" iconCls="icon-edit" plain="true" onClick="changePwd()" id="btn"  >修改密码</a>&nbsp;&nbsp; 
              <a href="javascript:void(0)"  class="easyui-linkbutton" onClick="loginout();" iconCls="icon-redo" plain="true" name="btn" id="btn"  >注销</a></td>
            </tr>
          </table>             
        </div>
		<div data-options="region:'west',split:true" title="菜单" style="width:168px;">
             <div class="easyui-accordion" style="width:100%;border:0">
                <div title="用户管理" style="padding-top:10px;padding-bottom:10px">
                    <ul class="easyui-tree">		
                           <li><a onclick="addPanel('/design/person/User.wa','用户信息');">用户信息</a></li>
                           <li>about.html</li>
                           <li>welcome.html</li>
                    </ul>
                </div>
                <div title="产品管理" style="padding-top:10px;padding-bottom:10px">
                     <ul class="easyui-tree">				
                           <li>index.html</li>
                           <li>about.html</li>
                           <li>welcome.html</li>
                     </ul>	
                </div>	
                <div title="权限管理" style="padding-top:10px;padding-bottom:10px">
                     <ul class="easyui-tree">				
                            <li>index.html</li>
                            <li>about.html</li>
                            <li>welcome.html</li>
                     </ul>
                </div>		
             </div>
        </div>        
		<div data-options="region:'center'">
          <div id="tt" class="easyui-tabs" data-options="tools:'#tab-tools',border:0" fit="true"></div>
		</div>
</div>
</body>
</html>
