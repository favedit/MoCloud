<%@ include file='/cloud/apl/public.inc'%>
<jh:define source="&basePage.user" alias="base"></jh:define>
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
	
	if($('#passport').val() == "admin"){
		//$("#regenerateIcon").show();
	}
});
function userSubmit(page){
	progress();	
	var url = null;
	var data = null;
	if(page != null){
		url = "/cloud/product/user/User.wa?do=selectData&date="+new Date().valueOf();
		data ={"alias":$('#alias').val(),"page":page};
	}else{
		url = "/cloud/product/user/User.wa?do=selectData&date="+new Date().valueOf();
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


function changeImg(value,row,index){
	return 	'<img width="32px" height="32px"  onerror="imgNotfind();" src="'+row.iconUrl+'" />';
}

function insertEditButton(value,row,index){
	var edit='<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-plain" sizset="true" onClick="edit(\''+row.ouid+'\')" ><span class="l-btn-left" sizset="false"><span class="l-btn-text icon-edit l-btn-icon-left">编辑</span></span></a>';
	return edit;
}

function edit(ouid){
	location.href = "/cloud/product/user/User.wa?do=selectUserInfo&ouid="+ouid+"&date="+new Date().valueOf();	
}

</script>
</HEAD>
<body>
<div id="cy_right" style="width:100%">
    <div class="right_title">
        <span>用户列表</span>
    </div>    
    <div class="btn_bar">
        <div class="nav_btn">
           <a href="/cloud/product/user/User.wa?do=insertPrepare" class="add_btn"></a>
           <a id="regenerateIcon" hidden="true" href="/cloud/product/user/User.wa?do=regenerateIcon">重新生成图标</a>
           <input id="passport" name="passport" style="display:none" value="<jh:write source='&base.passport'/>"/>
        </div>
        <div class="nav_search">
            <input id="alias" name="" type="text">            
            <a onClick="userSubmit(0)" href="#" class="sear_btn"></a>
        </div>
  </div>  
</div>
<table id="user" fit='true' class="easyui-datagrid"
style="width:100%;height:100%;text-align:center;align:true " 
data-options="toolbar:'#cy_right',pagination:true,rownumbers:true,collapsible:true,singleSelect:true,multiSort:false">
	<thead>
			<tr>
			      <th field="ouid" align="right" halign="center" width="60px" >编号</th>
                  <th field="iconUrl" align="center" width="110px" data-options="formatter:changeImg">头像</th>
                  <th field="passport" align="left" halign="center" width="120px" >帐号</th>
                  <th field="statusCdLabel" align="left" halign="center" width="60px" >状态</th>
                  <th field="roleCdLabel" align="left" halign="center" width="60px" >角色类型</th>
                  <th field="alias" align="left" halign="center" width="120px" >别称</th>
                  <th field="label" align="left" halign="center" width="80px" >名称</th>
                  <th field="teacherAlias" align="left" halign="center" width="80px" >导师名称</th>
                  <th field="teacherCdLabel" align="left" halign="center" width="80px" >导师类型</th>
                  <th field="mobilePhone" align="center" width="120px" >手机号码</th>
                  <th field="schoolLabel" align="center" width="120px" >学校名称</th>    
                  <th field="updateUserLabel" align="left" width="80px" >更新用户</th>
                  <th field="updateDate" align="center" width="140px" >更新日期</th>
                  <th data-options="field:'operation',halign:'center',align:'center',formatter:insertEditButton" width="140px">操作</th>
			</tr>
	</thead>
</table>
</body>
</HTML>
