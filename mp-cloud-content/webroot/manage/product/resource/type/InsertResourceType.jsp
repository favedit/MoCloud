<%@ include file='/cloud/apl/public.inc'%>
<HTML>
<HEAD>
<jh:define source="&basePage.user" alias="base"></jh:define>
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
  
  var url = "/cloud/product/resource/module/ResourceModule.wa?do=selectAll&date="+new Date().valueOf();
	var data = null;
	$.ajax({
	   type:"POST",
	   url:url,
	   data:data,
	   success:function(msg){
		 $('#moduleId').combobox('loadData', toJsonObject(msg));
	   },
	   fail:function(){
	   	 alert("error");
	   }
	});
})


function onModuleSelect(record){
	var url = "/cloud/product/resource/channel/ResourceChannel.wa?do=selectByModuleId&date="+new Date().valueOf();
	var data ={"moduleId":$('#moduleId').combobox("getValue")};
	$.ajax({
	   type:"POST",
	   url:url,
	   data:data,
	   success:function(msg){
		 $('#channelId').combobox('clear');
		 $('#channelId').combobox('loadData', toJsonObject(msg));
	   },
	   fail:function(){
	   	 alert("error");
	   }
	});
}

function submitForm(){		
	if(!checkValidateboxValid()) return;
	if(!checkImageType()) return; 
	
	if($('#moduleId').combobox("getValue").length == 0){
		alertx("请指定模块");
		return;
	}
	
	if($('#channelId').combobox("getValue").length == 0){
		alertx("请指定频道");
		return;
	}
	
	progress();	
	
	var url = "/cloud/product/resource/type/ResourceType.wa?do=isExist&date="+new Date().valueOf();
	var data ={"channelId":$('#channelId').val(),"code":$('#code').val()};
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
			 $("#form").submit();
		 }
	   },
	   fail:function(){
	   	 alert("error");
	   }
	});
}

</script>
<body bgcolor="#198bc9">
<div class="easyui-panel" fit='true'>
  <form id="form" method="post" action="/cloud/product/resource/type/ResourceType.wa?do=insert" enctype="multipart/form-data">
    <div id="cy_right" style="width:100%">
      <div class="right_title"> <span>添加资源类型</span> </div>
      <div class="btn_bar">
        <div class="nav_btn"> <a href="#" onClick="submitForm()" class="add_btn"></a> <a href="/cloud/product/resource/type/ResourceType.wa" class="back_btn"></a> </div>
      </div>
    </div>
    <div class='cy_edit_panel'>
      <table align="left">
        <tr>
          <td align="left" style="width:80px">编号</td>
          <td align="left"><input name="ouid" style="width:80px;text-align:right;" disabled class="easyui-validatebox textbox disabled" id="ouid"/>
            <input name="userId" style="display:none" value="<jh:write source='&base.ouid' />"/>
            <input type="checkbox" id="displayCd" name="displayCd" checked="true">显示</input>
			</td>
        </tr>
        <tr>
          <td align="left">图标</td>
          <td align="left"><input id="iconUrl" name="iconUrl" type="file" class="checkImageType"/><font color="#FF0000">(100*100)</font></td>
        </tr>
        <tr>
          <td align="left">模块</td>
          <td><select class="easyui-combobox" style="width:600px;" id="moduleId" name="moduleId" data-options="valueField:'ouid',textField:'label',onSelect:onModuleSelect,editable:false" />
          </td>
        </tr>
        <tr>
          <td align="left">频道</td>
          <td><select class="easyui-combobox" style="width:600px;" id="channelId" name="channelId" data-options="valueField:'ouid',textField:'label',editable:false" />
          </td>
        </tr>
        <tr>
          <td align="left">代码</td>
          <td align="left"><input id="code" name="code" style="width:600px;text-align:left;" autocomplete="off" class="easyui-validatebox textbox notnull" 
          validtype="length[1,80]" data-options="required:true"	value=""/>
        </tr>
        <tr>
          <td align="left">标签</td>
          <td align="left" ><input id="label" style="width:600px;text-align:left;" autocomplete="off" class="easyui-validatebox textbox notnull" validtype="length[1,200]" data-options="required:true" name="label" value=""/></td>
        </tr>
        <tr>
          <td align="left">排序值</td>
          <td align="left"><input id="displayOrder" name="displayOrder" class="easyui-numberbox" style="width:600px;text-align:right" value="0" data-options="required:true"/></td>
        </tr>
        <tr>
          <td align="left">备注</td>
          <td align="left"><textarea id="note" name="note" class="border_change" style="width:600px;height:140px"></textarea></td>
        </tr>
      </table>
    </div>
  </form>
</div>
</body>
</HTML>