<%@ include file='/apl/public.inc'%>
<HTML>
<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
<script>
$(function(){	
	moduleSubmit(null);
	var pager =	$('#module').datagrid().datagrid('getPager');
	pager.pagination({
			pageSize: 20,
			showPageList:false,
			onSelectPage:function(pageNumber){
				moduleSubmit(pageNumber);
			}
	});
});
function moduleSubmit(page){
	progress();	
	var url = null;
	var data = null;
	if(page != null){
		url = "/manage/module/Module.wa?do=selectDataByPage&page="+page+"&date="+new Date().valueOf();
		data ={"code":$('#code').val(),"page":page};
	}else{
		url = "/manage/module/Module.wa?do=selectDataByPage&date="+new Date().valueOf();
	}
	$.ajax({
	   type: "POST",
	   url:url,
	   data:data,
	   success: function(msg){
		 closeProgress();
		 $('#module').datagrid('loadData', toJsonObject(msg));
	   },
	   fail:function(){
		 closeProgress();
	   	 alert("error");
	   }
	});
}
function del(id){
	return confirmx('确定将此模块删除?',
	function(){
		var url = "/manage/module/Module.wa?do=delete&date="+new Date().valueOf();
		var data ={"id":id};
		$.getJSON(url,data,function(d){
         var result = toJsonObject(d);
			if(result=="1"){
				alertx("删除成功！","info",function(){
					location.href = "/manage/module/Module.wa";
				});			
			}else if(result=="2"){
				alertx("此模块正在被使用中，不可删除！","warning",function(){
					location.href = "/manage/module/Module.wa";
				});			
			}else{
				alertx("删除失败！","warning",function(){
					location.href = "/manage/module/Module.wa";
				});			
			}
		});	
	
	});
}
function edit(id){
	location.href = "/manage/module/Module.wa?do=updatePrepare&id="+id+"&date="+new Date().valueOf();	
}
</script>
</HEAD>
<body bgcolor="#198bc9">
<div id="cy_right" style="width:100%">
    <div class="right_title">
        <span>模块列表</span>
    </div>    
    <div class="btn_bar">
        <div class="nav_btn">
        <a href="/manage/module/Module.wa?do=insertPrepare" class="add_btn"></a>
        </div>
        <div class="nav_search">
            <input id="code" name="" type="text">
            <a onClick="moduleSubmit(0)" href="#" class="sear_btn"></a>
        </div>
  </div>  
</div>
<table id="module" fit='true' class="easyui-datagrid"
style="width:100%;height:100%;text-align:center;align:true " 
data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false">
	<thead>
			<tr>
			      <th data-options="field:'ouid',halign:'center',align:'right'" width="60px" >编号</th>
                  <th data-options="field:'code',halign:'center',align:'left',sortable:true" width="150px" >代码</th>
                  <th data-options="field:'label',halign:'center',align:'left'" width="150px" >中文名称</th>
                  <th data-options="field:'note',halign:'center',align:'left'" width="200px" >备注</th>
                  <th data-options="field:'createDate',halign:'center'" width="140px" >创建时间</th>
                  <th data-options="field:'make',halign:'center',align:'right',formatter:insert_editAndDelButton" width="150px">操作</th>
			</tr>
	</thead>
</table>
</body>
</HTML>