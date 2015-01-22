<%@ include file='/cloud/apl/public.inc'%>
<jh:define source="&basePage.user" alias="base"></jh:define>
<jh:define source="&resourceModulePage.Unit" alias="resourceModule"></jh:define>
<HTML>
<HEAD>
<jsp:include page="/cloud/manage/common/jeui.jsp"></jsp:include>
<link rel="stylesheet" href="/cloud/acs/btn_title.css" type="text/css" media="screen" />
</HEAD>
<script>
$(function(){	
	var flag = "<jh:write source='&base.ouid' />";
	if(flag == ""){
    alert("连接超时~！");
    parent.parent.location.href="/cloud/home/Frame.wa"; 
  }
  
  var oriDisplayCd = $("#oriDisplayCd").val();	
	if(oriDisplayCd =="1"){
		$("#displayCd").attr("checked",true);
	}else{
		$("#displayCd").attr("checked",false);
	}
	
	var oriIconUrl = $("#oriIconUrl").val();
	$("#oriIcon").attr("src",oriIconUrl);
})

function submitForm(){
	if(!checkValidateboxValid())return; 
	if(!checkImageType()) return;
	
	progress();
	
	var url = "/cloud/product/resource/module/ResourceModule.wa?do=canModify&date="+new Date().valueOf();
	var data ={"ouid":$('#ouid').val(),"code":$('#code').val()};
	$.ajax({
	   type:"POST",
	   url:url,
	   data:data,
	   success:function(msg){
		 closeProgress();
		 var result = toJsonObject(msg);
		 
		 if(result == '1'){
			 alertx("此代码已存在！","wrning",function(){
				 $('#code').focus();
			 });
		 }
		 else{
			 $('#form').submit();
		 }
	   },
	   fail:function(){
	   	 alert("error");
	   }
	});
}

</script>
<body class="body">
<div class="easyui-panel" fit='true'>
  <form id="form" method="post" action="/cloud/product/resource/module/ResourceModule.wa?do=updateSave" enctype="multipart/form-data">
    <div id="cy_right" style="width:100%">
      <div class="right_title"> <span>编辑资源模块</span> </div>
      <div class="btn_bar" style='boder:1px solid black'>
        <div class="nav_btn"> <a href="#" onClick="submitForm()" class="sub_btn"></a> <a href="/cloud/product/resource/module/ResourceModule.wa" class="back_btn"></a> </div>
      </div>
    </div>
    <div class='cy_edit_panel'>
      <table border="0">
        <tr>
          <td align="left" style="width:80px">编号</td>
          <td align="left"><input id="ouid" name="ouid" style="width:80px;text-align:right;" class="disabled" readonly value="<jh:write source='&resourceModule.ouid'/>"/>
            <input name="userId" style="display:none" value="<jh:write source='&base.ouid' />"/>
            <input type="checkbox" id="displayCd" name="displayCd" checked="true">显示</input>
            <input id="oriDisplayCd" style="display:none" value="<jh:write source='&resourceModule.displayCd'/>"/></td>
        </tr>
        <tr>
        <td align="left">图标</td>
        <td align="left"><img id="oriIcon" onerror="imgNotfind();"/>
          <input id="oriIconUrl" style="display:none" value="<jh:write source='&resourceModule.iconUrl' />"/>
          <input id="iconUrl" name="iconUrl" type="file" class="checkImageType"/><font color="#FF0000">(100*100)</font></td>
      </tr>
        <tr>
          <td align="left" style="width:80px">代码</td>
          <td align="left"><input id="code" name="code" style="width:600px;text-align:left;" class="easyui-validatebox textbox notnull" autocomplete="off" data-options="required:true" 
        validtype="length[1,80]" value="<jh:write source='&resourceModule.code'/>"/></td>
        </tr>
        <tr>
          <td align="left">标签</td>
          <td align="left" ><input id="label" class="easyui-validatebox textbox notnull" style="width:600px;text-align:left;" autocomplete="off" validtype="length[1,200]" data-options="required:true" name="label" value="<jh:write source='&resourceModule.label'/>"/></td>
        </tr>
         <tr>
          <td align="left">排序值</td>
          <td align="left"><input id="displayOrder" name="displayOrder" class="easyui-numberbox" style="width:600px;text-align:right" data-options="required:true" value="<jh:write source='&resourceModule.displayOrder'/>"/></td>
        </tr>
        <tr>
          <td align="left">备注</td>
          <td align="left"><textarea id="note" name="note" class="border_change" style="width:600px;height:140px"><jh:write source='&resourceModule.note' format='text'/></textarea></td>
        </tr>
      </table>
    </div>
  </form>
</div>
</body>
</HTML>