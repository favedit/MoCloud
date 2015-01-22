<%@ include file='/cloud/apl/public.inc'%>
<jh:define source="&basePage.user" alias="base"></jh:define>
<HTML>
<HEAD>
<js:css/>
<js:js type='runtime.client'/>
<jsp:include page="/cloud/manage/common/jeui.jsp"></jsp:include>
<link rel="stylesheet" href="/cloud/acs/btn_title.css" type="text/css" media="screen" />
<script>
$(function(){	
	doSubmit(null);
	var pager =	$('#resourceChannel').datagrid().datagrid('getPager');
	pager.pagination({
			pageSize: 20,
			showPageList:false,
			onSelectPage:function(pageNumber){
				doSubmit(pageNumber);
			}
	});
	
	if($('#passport').val() == "admin"){
		//$("#regenerateIcon").show();
	}
});
function doSubmit(page){
	progress();	
	var url = null;
	var data = null;
	if(page != null){
		url = "/cloud/product/resource/channel/ResourceChannel.wa?do=selectByPage&page="+page+"&date="+new Date().valueOf();
		data ={"label":$('#label').val(),"page":page};
	}else{
		url = "/cloud/product/resource/channel/ResourceChannel.wa?do=selectByPage&date="+new Date().valueOf();
	}
	$.ajax({
	   type: "POST",
	   url:url,
	   data:data,
	   success: function(msg){
		 closeProgress();
		 $('#resourceChannel').datagrid('loadData', toJsonObject(msg));
	   },
	   fail:function(){
		 closeProgress();
	   	 alert("error");
	   }
	});
}

function del(ouid){
	return confirmx('确定将此项删除?',
	function(){
		var url = "/cloud/product/resource/channel/ResourceChannel.wa?do=delete&date="+new Date().valueOf();
		var data ={"ouid":ouid};
		$.getJSON(url,data,function(d){ 
			if(d=="1"){
				location.href="/cloud/product/resource/channel/ResourceChannel.wa";			
			}else{
				alertx("删除失败！","warning",function(){
					//location.replace(location);	
					location.href="/cloud/product/resource/channel/ResourceChannel.wa";
				});			
			}
		});	
	
	});
}
function edit(id){
	location.href = "/cloud/product/resource/channel/ResourceChannel.wa?do=updateUpload&ouid="+id+"&date="+new Date().valueOf();
}

function jumpToInsertPage(){
	location.href="/cloud/product/resource/channel/ResourceChannel.wa?do=insertOnload";
}

function changeCheckbox(value,row,index){
	var display = row.displayCd;
	if(display =="1"){
		return 	'<img width="15px" src="/cloud/images/ok.png" />';
	}else{
		return 	'<img width="15px" src="/cloud/images/cancel.png" />';
	}
}

function changeImg(value,row,index){
	return 	'<img src="'+row.iconUrl+'" />';
}
</script>
</HEAD>
<body bgcolor="#198bc9">
<div id="cy_right" style="width:100%">
    <div class="right_title">
        <span>频道列表</span>
    </div>    
    <div class="btn_bar">
        <div class="nav_btn">
        <a href="/cloud/product/resource/channel/ResourceChannel.wa?do=insertOnload" class="add_btn"></a>
        <a id="regenerateIcon" hidden="true" href="/cloud/product/resource/channel/ResourceChannel.wa?do=regenerateIcon">重新生成图标</a>
        <input id="passport" name="passport" style="display:none" value="<jh:write source='&base.passport'/>"/>
        </div>
        <div class="nav_search">
            <input id="label" name="" type="text">
            <a onClick="doSubmit(0)" href="#" class="sear_btn"></a>
        </div>
  </div>  
</div>
<table id="resourceChannel" class="easyui-datagrid" fit='true'
style="width:100%;height:100%;align:true" 
data-options="toolbar:'#cy_right',pagination:true,rownumbers:true,collapsible:true,singleSelect:true">
	<thead>
			<tr>
			      <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>
                  <th data-options="field:'iconUrl',halign:'center',align:'center',formatter:changeImg" width="110px">图标</th>
                  <th data-options="field:'displayCd',halign:'center',align:'center',formatter:changeCheckbox" width="80px">显示</th>
                  <th data-options="field:'moduleLabel',halign:'center',align:'left'" width="200px">模块</th>
                  <th data-options="field:'code',halign:'center',align:'left'" width="140px">代码</th>
                  <th data-options="field:'label',halign:'center',align:'left'" width="200px">标签</th>
                  <th data-options="field:'displayOrder',halign:'center',align:'right'" width="60px">排序值</th>
                  <th data-options="field:'updateUserLabel',halign:'center',align:'left'" width="80px">更新用户</th>
                  <th data-options="field:'updateDate',halign:'center',align:'center'" width="140px">更新日期</th>
                  <th data-options="field:'operation',halign:'center',align:'center',formatter:insert_editAndDelButton" width="140px">操作</th>
			</tr>
	</thead>
</table>
</body>
</HTML>