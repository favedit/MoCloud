<%@ include file='/cloud/apl/public.inc'%>
<jh:define source="&basePage.user" alias="base"></jh:define>
<HTML>
<HEAD>
<link rel="stylesheet" href="/cloud/acs/btn_title.css" type="text/css" media="screen" />
<jsp:include page="/cloud/manage/common/jeui.jsp"></jsp:include>
</HEAD>
<script>
$(function(){
	var flag = "<jh:write source='&base.ouid' />";
	if(flag == ""){
	  alert("连接超时~！");
	  parent.parent.location.href="/cloud/home/Frame.wa";	
	}	
	var url = "/cloud/manage/role/Role.wa?do=selectAll&date="+new Date().valueOf();
	$.ajax({
	   type: "POST",
	   url:url,
	   success: function(msg){
		 closeProgress();
		 $('#role').combobox('loadData', toJsonObject(msg));
		 
	   },
	   fail:function(){
		 closeProgress();
	   	 alert("error");
	   }
	});
});
function submitForm(){
	if(!isValid()) return; 
	progress();		
	var url ="/cloud/manage/user/User.wa?do=insertUser&date="+new Date().valueOf();
	var data ={"passport":$('#passport').val(),"password":$('#pwd2').val(),"roleId":$('#role').combobox("getValue"),
	   "label":$('#label').val(),"contact_email":$('#contact_email').val(),
	   "contact_phone":$('#contact_phone').val(),"adminId":$('#adminId').val()};		
	$.ajax({
	   type: "POST",
	   url:url,
	   data:data,
	   success: function(msg){
		 closeProgress();
		 var result = toJsonObject(msg);
		 if(result == '0'){
			 alertx("此帐号已被使用！","wrning",function(){$('#passport').val("");$('#passport').focus()});
		 }else{
			  location.href="/cloud/manage/user/User.wa";
		 }
	   },
	   fail:function(){
		 closeProgress();
	   	 alert("error");
	   }
	});
}
function confirmpwd()
{
	var pwd1 = $("#pwd1").val();
	var pwd2 = $("#pwd2").val();
	if(pwd1 != pwd2){
		msg("两次密码不一致！");
		$("#pwd1").val("");
	    $("#pwd2").val("");
		$("#pwd1").focus();
	}
}

</script>
<body bgcolor="#198bc9">
<div id="cy_right" style="width:100%">
    <div class="right_title" style="width:100%">
        <span>添加管理员</span>
    </div>    
    <div class="btn_bar">
        <div class="nav_btn">
        <a href="#" onClick="submitForm()" class="add_btn"></a>
        <a href="#" onClick="history.go(-1);" class="back_btn"></a>
        </div>
        <div class="nav_search"></div>
    </div>
</div>
<div class="easyui-panel" fit='true' data-options="border:false">
<table width="718" border="0" style="text-align:center; margin-left:10px; margin-top:10px; margin-bottom:10px">
  <tr>
    <td align="left" width="48">帐号</td>
    <td align="left" width="660">
    <input id="passport" name="passport" class="easyui-validatebox textbox notnull"style="width:500px"  data-options="required:true"
     value=""/>
     <input id="adminId" name="adminId" style="display:none" value="<jh:write source='&base.ouid'/>" />
     </td>
  </tr>
  <tr>
    <td align="left">密码</td>
    <td align="left">
    <input id="pwd1" class="easyui-validatebox textbox notnull" style="width:500px" data-options="required:true,validType:'length[6,20]'" type="password" name="pwd1" value=""/></td>
  </tr>
  <tr>
    <td align="left">确认密码</td>
    <td align="left"><input id="pwd2" class="easyui-validatebox textbox notnull" style="width:500px" data-options="required:true,validType:'length[6,20]'" type="password" name="password" value="" onBlur="confirmpwd()" />    </td>
  </tr>
   <tr>
    <td align="left">真实名称</td>
    <td align="left"><input id="label" class="easyui-validatebox textbox notnull" style="width:500px"
    data-options="required:true"  name="label" value=""/></td>
  </tr>
  <tr>
         <td width="48" height="30" align="left">角色</td>
         <td height="30" colspan="7" align="left">
             <select class="easyui-combobox" id="role" name="role" style="width:500px;"
                    data-options="valueField:'ouid',textField:'label',editable:false"/>
         </td>
    </tr>
    <tr>
    <td align="left">联系电话</td>
    <td align="left"><input id="contact_phone" class="easyui-numberbox textbox" style="width:500px"
     name="contact_phone" value=""/></td>
  </tr>
  <tr>
    <td align="left">联系邮箱</td>
    <td align="left"><input id="contact_email" class="easyui-validatebox textbox notnull" style="width:500px"
    data-options="required:true,validType:'email'" name="contact_email" value=""/></td>
  </tr>
</table>
</div>
</body>
</HTML>