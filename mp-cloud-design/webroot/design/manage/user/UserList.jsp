<%@ include file='/design/apl/public.inc'%>
<jh:define source="&basePage.user" alias="base"></jh:define>
<HTML>
<HEAD>
<script type="text/javascript" src="/design/ajs/myselfJs.js" ></script>
<jsp:include page="/design/manage/component/jeui.jsp"></jsp:include>
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
	var url = "/design/person/User.wa?do=selectDataByPage&date="+new Date().valueOf();
	$.ajax({
	   type: "POST",
	   url:url,
	   success: function(msg){
		   $('#user').datagrid('loadData', toJsonObject(msg));
	   },
	   fail:function(){
	   	 alert("error");
	   }
	});
}
</script>
</HEAD>
<body>
<div id="cy_right">
<a href="javascript:void(0)"  class="easyui-linkbutton" iconCls="icon-add" plain="true" onClick="changePwd()" id="btn"  >增加</a>&nbsp;&nbsp; 
<a href="javascript:void(0)"  class="easyui-linkbutton" iconCls="icon-remove" plain="true" name="btn" id="btn"  >删除</a>
</div>
<table id="user" fit='true' class="easyui-datagrid"
style="width:100%;height:100%;text-align:center;align:true" 
data-options="toolbar:'#cy_right',pagination:true,rownumbers:true,collapsible:true">
	<thead>
			<tr>
                  <th data-options="field:'ck',checkbox:true">全选</th>
			      <th field="ouid" align="right" halign="center" width="60px" >编号</th>
                  <th field="passport" align="left" halign="center" width="120px" >帐号</th>
                  <th field="password" align="left" halign="center" width="60px" >密码</th>
                  <th field="label" align="left" halign="center" width="60px" >昵称</th>  
                  <th field="updateDate" align="center" width="140px" >更新日期</th>
			</tr>
	</thead>
</table>
</body>
</HTML>
