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
	var pager =	$('#school').datagrid().datagrid('getPager');
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
		url = "/cloud/product/school/School.wa?do=selectByPage&page="+page+"&date="+new Date().valueOf();
		data ={"label":$('#label').val(),"page":page};
	}else{
		url = "/cloud/product/school/School.wa?do=selectByPage&date="+new Date().valueOf();
	}
	$.ajax({
	   type: "POST",
	   url:url,
	   data:data,
	   success: function(msg){
		 closeProgress();
		 $('#school').datagrid('loadData', toJsonObject(msg));
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
		var url = "/cloud/product/school/School.wa?do=delete&date="+new Date().valueOf();
		var data ={"ouid":ouid};
		$.getJSON(url,data,function(d){
			if(d=="1"){
				location.href="/cloud/product/school/School.wa";			
			}else{
				alertx("删除失败！","warning",function(){
					//location.replace(location);	
					location.href="/cloud/product/school/School.wa";
				});			
			}
		});	
	
	});
}
function edit(id){
	location.href = "/cloud/product/school/School.wa?do=updateUpload&ouid="+id+"&date="+new Date().valueOf();
}

function jumpToInsertPage(){
	location.href="/cloud/product/school/School.wa?do=insertOnload";
}

function changeImg(value,row,index){
	return 	'<img src="'+row.iconUrl+'" />';
}
</script>
</HEAD>
<body bgcolor="#198bc9">
<div id="cy_right" style="width:100%">
    <div class="right_title">
        <span>学校列表</span>
    </div>    
    <div class="btn_bar">
        <div class="nav_btn">
        <a href="/cloud/product/school/School.wa?do=insertOnload" class="add_btn"></a>
        <a id="regenerateIcon" hidden="true" href="/cloud/product/school/School.wa?do=regenerateIcon">重新生成图标</a>
        <input id="passport" name="passport" style="display:none" value="<jh:write source='&base.passport'/>"/>
        </div>
        <div class="nav_search">
            <input id="label" name="" type="text">
            <a onClick="doSubmit(0)" href="#" class="sear_btn"></a>
        </div>
  </div>  
</div>
<table id="school" class="easyui-datagrid" fit='true'
style="width:100%;height:100%;text-align:center;align:true " 
data-options="toolbar:'#cy_right',pagination:true,rownumbers:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false">
	<thead>
			<tr>
			      <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>
                  <th data-options="field:'countryName',halign:'center',align:'left',sortable:true" width="140px">国家名称</th>
                  <th data-options="field:'areaName',halign:'center',align:'left',sortable:true" width="140px">地区名称</th>
                  <th data-options="field:'provinceName',halign:'center',align:'left',sortable:true" width="140px">省份名称</th>
                  <th data-options="field:'iconUrl',halign:'center',align:'center',formatter:changeImg" width="110px">图标</th>
                  <th data-options="field:'label',halign:'center',align:'left',sortable:true" width="200px">学校名称</th>
                  <th data-options="field:'operation',halign:'center',align:'center',formatter:insert_editAndDelButton" width="140px">操作</th>
			</tr>
	</thead>
</table>
</body>
</HTML>