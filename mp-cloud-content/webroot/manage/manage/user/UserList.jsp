<%@ include file='/cloud/apl/public.inc'%>
<HTML>
<HEAD>
<link rel="stylesheet" href="/cloud/acs/btn_title.css" type="text/css" media="screen" />
<jsp:include page="/cloud/manage/common/jeui.jsp"></jsp:include>
<script>
$(function(){	
	userSubmit(null);
	var pager =	$('#user').datagrid().datagrid('getPager');
	pager.pagination({
			pageSize: 20,
			showPageList:false,
			onSelectPage:function(pageNumber){
				userSubmit(pageNumber);
			}
	});
});
function userSubmit(page){
	progress();	
	var url = null;
	var data = null;
	if(page != null){
		url = "/cloud/manage/user/User.wa?do=selectDataByPage&page="+page+"&date="+new Date().valueOf();
		data ={"passport":$('#passport').val(),"page":page};
	}else{
		url = "/cloud/manage/user/User.wa?do=selectDataByPage&date="+new Date().valueOf();
	}
	$.ajax({
	   type: "POST",
	   url:url,
	   data:data,
	   success: function(msg){
		 closeProgress();
		 $('#user').datagrid('loadData', toJsonObject(msg));
	   },
	   fail:function(){
		 closeProgress();
	   	 alert("error");
	   }
	});
}
function del(id){
	return confirmx('确定将此用户删除?',
	function(){
		var url = "/cloud/manage/user/User.wa?do=deleteUser&date="+new Date().valueOf();
		var data ={"id":id};
		$.getJSON(url,data,function(d){
			if(d=="1"){
				alertx("删除成功！","info",function(){
					location.href = "/cloud/manage/user/User.wa";
				});			
			}else{
				alertx("删除失败！","warning",function(){
					location.href = "/cloud/manage/user/User.wa";
				});			
			}
		});	
	
	});
}
function edit(id){
	location.href = "/cloud/manage/user/User.wa?do=updateUserOnload&id="+id+"&date="+new Date().valueOf();	
}

</script>
</HEAD>
<body bgcolor="#198bc9">
<div id="cy_right" style="width:100%">
    <div class="right_title">
        <span>管理员列表</span>
    </div>    
    <div class="btn_bar">
        <div class="nav_btn">
        <a href="/cloud/manage/user/User.wa?do=insertOnload" class="add_btn"></a>
        </div>
        <div class="nav_search">
            <input id="passport" name="" type="text">
            <a onClick="userSubmit(0)" href="#" class="sear_btn"></a>
        </div>
  </div>  
</div>
<table id="user" fit='true' class="easyui-datagrid"
style="width:100%;height:100%;text-align:center;align:true " 
data-options="toolbar:'#cy_right',pagination:true,rownumbers:true,collapsible:true">
	<thead>
			<tr>
			      <th field="ouid" align="left" halign="center" width="60px" >ID</th>
                  <th field="passport" align="left" halign="center" width="140px" >帐号</th>
                  <th field="passportLoginDate" align="center" width="150px" >上次登陆时间</th>
                  <th field="passwordUpdateDate" align="center" width="150px" >密码更新时间</th>
                  <th field="statusCdLabel" align="center" halign="center" width="60px" >状态类型</th>
                  <th field="roleIdLabel" align="center" halign="center" width="100px" >角色类型</th>
                  <th field="label" align="left" halign="center" width="200px" >真实名称</th>
                  <th field="contactPhone" align="left" halign="center" width="140px" >联系电话号码</th>
                  <th field="contactEmail" align="left" halign="center" width="140px" >联系邮箱地址</th>
                  <th field="make" halign="center" align="left" width="150px" data-options="formatter:insert_admin_editButton" >操作</th>
			</tr>
	</thead>
</table>
</body>
</HTML>