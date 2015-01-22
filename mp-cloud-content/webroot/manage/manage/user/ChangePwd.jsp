<%@ include file='/apl/public.inc' %>
<jh:define source="&basePage.user" alias="base"></jh:define>
<HTML>
<HEAD>
<link rel="stylesheet" href="/cloud/acs/btn_title.css" type="text/css" media="screen" />
<jsp:include page="/cloud/manage/common/jeui.jsp"></jsp:include>
<script>
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
function submitForm(){
	if(!isValid()) return; 
	progress();		
	var url ="/cloud/manage/home/Frame.wa?do=changePwd&date="+new Date().valueOf();
	var data ={"passport":$('#passport').val(),"password":$('#pwd2').val(),"ouid":$("#ouid").val()};		
	$.ajax({
	   type: "POST",
	   url:url,
	   data:data,
	   success: function(msg){
		 closeProgress();
		 top.location.href="/cloud/home/Frame.wa?do=loginOut";	
		
	   },
	   fail:function(){
		 closeProgress();
	   	 alert("error");
	   }
	});
}
</script>
</HEAD>
<body bgcolor="#198bc9">
<div id="cy_right" style="width:100%">
    <div class="right_title">
        <span>修改密码</span>
    </div>    
    <div class="btn_bar">
        <div class="nav_btn">
        <a href="#" onClick="submitForm()" class="sub_btn"></a>
        </div>
        <div class="nav_search"></div>
    </div>
</div>
<div class="easyui-panel" fit='true' data-options="border:false">
<table width="648" border="0" style="text-align:center; margin-left:10px; margin-top:10px; margin-bottom:10px">
  <tr>
    <td align="left" width="66">帐号</td>
    <td align="left" width="572">    
    <input id="passport" name="passport" disabled class="disabled" style="width:500px" value="<jh:write source='&base.passport'/>"/>
    <input id="ouid" style="display:none" value="<jh:write source='&base.ouid'/>" />
    </td>
  </tr>
  <tr>
    <td align="left">密码</td>
    <td align="left">
    <input id="pwd1" class="easyui-validatebox textbox" style="width:500px" data-options="validType:'length[6,20]'"
     type="password" name="pwd1" value="<jh:write source='&base.password'/>"/></td>
  </tr>
  <tr>
    <td align="left">确认密码</td>
    <td align="left"><input id="pwd2" class="easyui-validatebox textbox notnull" style="width:500px" 
    data-options="required:true,validType:'length[6,20]'" type="password" name="pwd2" value="<jh:write source='&base.password'/>" onBlur="confirmpwd()" />    </td>  
</table>
</div>
</body>
</HTML>
