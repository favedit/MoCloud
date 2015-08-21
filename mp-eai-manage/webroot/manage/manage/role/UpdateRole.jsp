<%@ include file='/apl/public.inc'%>
<jh:define source="&rolePage.role" alias="role"></jh:define>
<HTML>
<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
</HEAD>
<script>
$(function(){
	var ovld = 	"<jh:write source='&role.ovld' />";
	if(ovld == 'true'){
		$("#ovld").attr("checked",true);
	}
	roleSubmit(null);
	/*var pager =	$('#module').datagrid().datagrid('getPager');
	pager.pagination({
			pageSize: 20,
			showPageList:false,
			onSelectPage:function(pageNumber){
				roleSubmit(pageNumber);
			}
	});*/
	$('#module').datagrid('clearSelections');
});
function roleSubmit(page){
	progress();		
	var url = null;
	var data = null;
	var roleId = "<jh:write source='&role.ouid' />";
	if(page != null){
		url = "/manage/role/Role.wa?do=selectRoleModule&page="+page+"&date="+new Date().valueOf();
		data ={"roleId":roleId,"page":page};
	}else{
		url = "/manage/role/Role.wa?do=selectRoleModule&date="+new Date().valueOf();
		data ={"roleId":roleId};
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
function clickCheck(o, i){
	var rows = $('#module').datagrid('getRows');
    var row = rows[i];
    row.viewValidCd = o.checked ? 1 : 0;
}
function isChecked(value,row,index){
	if(row.viewValidCd == '1'){
       return '<input type="checkbox" name="DataGridCheckbox" checked="checked" onclick="clickCheck(this,'+index+')">';
    }else{
       return '<input type="checkbox" name="DataGridCheckbox" onclick="clickCheck(this,'+index+')">';
    }
}
function submitForm(){
	if(!isValid()) return;
	var rows = $('#module').datagrid('getRows');
	var resourceResult = [];
	if(rows.length != 0){
		for(var i=0; i<rows.length; i++){
			var row = rows[i];
			if(row.viewValidCd == '1'){
			   resourceResult.push(row.ouid);			
			}
		}
		$("#moduleIds").val(resourceResult);		
	}
	$("#role").submit();
}
</script>
<body bgcolor="#198bc9">
<div class="easyui-panel" fit='true' data-options="border:false">

<div id="cy_right" style="width:100%">
    <div class="right_title">
        <span>修改角色</span>
    </div>    
    <div class="btn_bar">
        <div class="nav_btn">
        <a href="#" onClick="submitForm()" class="sub_btn"></a>
        <a href="/manage/role/Role.wa" class="back_btn"></a>
        </div>
        <div class="nav_search"></div>
    </div>
</div>
<form id="role" action="/manage/role/Role.wa?do=update" method="post" align="center">
<table width="716" border="0" style="text-align:center; margin-left:10px; margin-top:10px; margin-bottom:10px">

  <tr>
    <td width="47" align="left">编号</td>
    <td width="492" align="left">
          <input id="ouid" name="roleId" class="disabled" style="width:80px;" value="<jh:write source='&role.ouid' />"/>
          <input name="adminId" style="display:none;" value="<jh:write source='&basePage.userId' />"/>
          <input id="moduleIds" name="moduleIds" style="display:none;"/>
    </td>
    <td width="163" align="right">
    	<input id="ovld" name="ovld" type="checkbox" />有效性
    </td>
  </tr>
   <tr>
    <td align="left">英文名称</td>
    <td align="left" colspan="2">
        <input id="code" name="code" class="textbox" style="width:660px" value="<jh:write source='&role.code' />"/>    
    </td>
  </tr>
  <tr>
    <td align="left">中文名称</td>
    <td align="left" colspan="2">
        <input id="label" name="label" class="textbox" style="width:660px" value="<jh:write source='&role.label' />"/>    
    </td>
  </tr>
  <tr>
    <td align="left">备注</td>
    <td align="left" colspan="2">
      <input id="note" name="note"  class="textbox"  style="width:660px" 
      value="<jh:write source='&role.note' />"/>
    </td>
  </tr>
  <tr>
      <td align="left">模块</td>
      <td colspan="2" align="left">
            <table id="module" class="easyui-datagrid"
            style="width:660px;align:true" 
            data-options="rownumbers:true,collapsible:true,remoteSort:false,multiSort:false">
                <thead>
                        <tr>
                              <th data-options="field:'ouid',halign:'center',align:'right'" width="60px" >ID</th>
                              <th data-options="field:'code',halign:'center',align:'left',sortable:true" width="200px" >代码</th>
                              <th data-options="field:'label',halign:'center',align:'left',sortable:true" width="150px" >中文名称</th>
                              <th data-options="field:'viewValidCd',align:'center',formatter:isChecked" width="60px">查看权限</th>
                        </tr>
                </thead>
            </table>         
      </td>
  </tr>
</table>

</div>
</form>
</div>
</body>
</HTML>