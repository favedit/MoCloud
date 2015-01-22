<%@ include file='/cloud/apl/public.inc'%>
<jh:define source="&basePage.user" alias="base"></jh:define>
<HTML>
<HEAD>
<link rel="stylesheet" href="/cloud/acs/btn_title.css" type="text/css" media="screen" />
<jsp:include page="/cloud/manage/common/jeui.jsp"></jsp:include>
<script>
$(function(){
	var flag = "<jh:write source='&base.ouid' />";
	if(flag == ""){
       alert("连接超时~！");
       parent.parent.location.href="/cloud/home/Frame.wa"; 
    }	
	progress();
    $('#teacherId').combogrid({
			panelWidth:700,
			panelHeight:300,
			idField:'ouid',
			textField:'alias',
			pagination : true,//是否分页
            pageSize: 20,//每页显示的记录条数，默认为20 
			columns:[[
					{field:'ouid',title:'编号',width:40},
					{field:'passport',title:'帐号',width:60},
					{field:'alias',title:'显示名称',width:80},
					{field:'label',title:'真实名称',width:80},
					{field:'contactPhone',title:'电话号码',width:70},
					{field:'schoolLabel',title:'学校名称',width:60},
					{field:'schoolEnterYear',title:'入学年份',width:60},
					{field:'schoolPartLabel',title:'院系名称',width:80},
					{field:'schoolClassLabel',title:'班级名称',width:80}
		   ]]
	});
	getTeacherJson(null);
	//$('#cc').combogrid('setValue', $("#housetypename").val());
	var grid=$("#teacherId").combogrid("grid");//获取表格对象 
    var row = grid.datagrid('getSelected');//获取行数据 
	var pager =	grid.datagrid().datagrid('getPager');
	pager.pagination({
		pageSize: 20,
		showPageList:false,
		onSelectPage:function(pageNumber){
			getTeacherJson(pageNumber);
		}
	});
	$('#shoolId').combogrid({
			panelWidth:400,
			panelHeight:300,
			idField:'ouid',
			textField:'label',
			pagination : true,//是否分页
            pageSize: 20,//每页显示的记录条数，默认为20 
			columns:[[
					{field:'ouid',title:'编号',width:60},
					{field:'label',title:'学校名称',width:200}
		   ]]
	});
	getSchoolJson(null);
	var grid=$("#shoolId").combogrid("grid");//获取表格对象 
    var row = grid.datagrid('getSelected');//获取行数据 
	var pager =	grid.datagrid().datagrid('getPager');
	pager.pagination({
		pageSize: 20,
		showPageList:false,
		onSelectPage:function(pageNumber){
			getSchoolJson(pageNumber);
		}
	});
});
function getTeacherJson(page){
	var url = null;
	if(page != null){
		url = "/cloud/product/user/User.wa?do=selectTeacherUser&page="+page+"&date="+new Date().valueOf();
	}else{
		url = "/cloud/product/user/User.wa?do=selectTeacherUser&date="+new Date().valueOf();
	}
	$.ajax({
		type:"POST",
		url:url,
		success:function(msg){
			$("#teacherId").combogrid('grid').datagrid('loadData', toJsonObject(msg));
		},
		fail:function(){
			alert("error");
		}
	});
}
function getSchoolJson(page){
		
	var url = null;
	var data = null;
	if(page != null){
		url = "/cloud/product/school/School.wa?do=selectAll&page="+page+"&date="+new Date().valueOf();
		data ={"page":page};
	}else{
		url = "/cloud/product/school/School.wa?do=selectAll&date="+new Date().valueOf();
	}
	$.ajax({
	   type: "POST",
	   url:url,
	   data:data,
	   success: function(msg){
		 closeProgress();
		 $("#shoolId").combogrid('grid').datagrid('loadData', toJsonObject(msg));
	   },
	   fail:function(){
		 closeProgress();
	   	 alert("error");
	   }
	});
}
function submitForm(){	
	if(!checkValidateboxValid()) return;
	if(!checkNumberBox()) return;
	if(!checkImageType()) return;	
	var shoolId = $("#shoolId").combogrid("getValue");
	if(shoolId.length == 0){
		alert("请选择学校！");
		return;
	}
	$('#form').submit();
}

</script>
</HEAD>
<body class="body">
<div class="easyui-panel" fit='true'>
  <form id="form" method="post" action="/cloud/product/user/User.wa?do=insert" enctype="multipart/form-data">
    <div id="cy_right" style="width:100%">
      <div class="right_title"> <span>用户添加</span> </div>
      <div class="btn_bar">
        <div class="nav_btn"> <a href="#" onClick="submitForm()" class="sub_btn"></a> 
        <a href="/cloud/product/user/User.wa" class="back_btn"></a> </div>
      </div>
    </div>
    <div class='cy_edit_panel'>
      <table border="0" width="1200">
        <tr>
          <td width="48" height="30" align="left">编号</td>
          <td width="172" align="left">
          <input id="ouid" name="ouid" class="disabled" readonly style="width:80px;"/>
          <input name="adminId" style="display:none" value="<jh:write source='&base.ouid' />"/></td>         
          
          <td height="24" align="left" >图标</td>
          <td colspan="3" align="left">          
            <input  id="iconUrl" name="iconUrl" class="checkImageType" type="file"/>          
          </td>
        </tr>
        <tr>
          <td height="30" align="left">帐号</td>
          <td width="172" align="left"><input name="passport" class="easyui-validatebox textbox" data-options="required:true" style="width:120px;"/></td>
          <td width="48" height="30" align="left">密码</td>
          <td width="172" align="left"><input name="password" class="easyui-validatebox textbox" data-options="required:true"validtype="length[6,20]" type="password" style="width:140px;"/></td>
        </tr>
        <tr>
          <td width="48" height="30" align="left">显示名称</td>
          <td align="left"><input name="alias" class="easyui-validatebox textbox" data-options="required:true" style="width:120px;"/></td>
          <td align="left" width="49">真实名称</td>
          <td align="left"><input name="label" class="easyui-validatebox textbox" style="width:140px;"/></td>
          <td align="left" width="49">导师</td>
          <td align="left">
             <select id="teacherId" name="teacherId" class="easyui-combogrid" style="width:120px;"></select>
          </td>
          <td align="left" width="50">导师类型</td>
          <td align="left" colspan="2">
            <select class="easyui-combobox" id="teacherCd" name="teacherCd" style="width:120px;" data-options="editable:false">
              <option value="1">普通</option>
              <option value="2">导师</option>
            </select>
          </td>
        </tr>
        <tr>
          <td align="left" height="30" width="48">性别</td>
          <td align="left">
           <select class="easyui-combobox" id="gender" name="gender" style="width:120px;" data-options="editable:false">
              <option value="1">男</option>
              <option value="2">女</option>
           </select>
          <td align="left" width="49">生日</td>
          <td align="left"><input name="birthday" class="easyui-datetimebox" data-options="required:true" value="9999"style="width:140px;"/></td>
          <td width="49"  align="left">状态</td>
          <td align="left" width="191">
            <select class="easyui-combobox" id="statusCd" name="statusCd" style="width:120px;" data-options="editable:false">
              <option value="1">正常</option>
              <option value="2">锁定</option>
            </select></td>
        </tr>
        <tr>
          <td height="30" align="left" width="48">手机号码</td>
          <td align="left">
          <input name="mobilePhone" class="easyui-validatebox textbox checkNBox" data-options="min:0,required:true" validtype="length[11,11]"
           style="width:120px;"/></td>
           <td height="30" align="left" width="48">电子邮箱</td>
          <td align="left"><input name="contactEmail" class="easyui-validatebox textbox" style="width:140px;"/></td>
           <td height="30" align="left" width="48">QQ号码</td>
          <td align="left"><input name="contactQq" class="easyui-validatebox textbox checkNBox" style="width:120px;"/></td>
          <td height="30" align="left" width="48">MSN</td>
          <td align="left"><input name="contactMsn" class="easyui-validatebox textbox checkNBox" style="width:120px;"/></td>
        </tr>       
         <tr>
          <td height="30" align="left">家庭电话</td>
          <td align="left"><input name="homePhone" class="easyui-validatebox textbox checkNBox" validtype="length[8,20]" style="width:120px;" /></td>
          <td align="left">家庭住址</td>
          <td align="left"><input name="homeAddress" class="easyui-validatebox textbox" style="width:140px;"/></td>
        </tr>
        <tr>        
          <td width="48" height="30" align="left">学校</td>
          <td align="left">
             <select id="shoolId" name="shoolId" class="easyui-combogrid" style="width:120px;"></select>
          </td>
          <td width="49" align="left">入学年份</td>
          <td align="left"><input name="schoolEnterYear" class="easyui-validatebox textbox"  style="width:140px;"/></td>
          <td width="60" align="left">院系名称</td>
          <td width="155" align="left"><input name="schoolPartLabel" class="easyui-validatebox textbox" style="width:120px;"/></td>
          <td align="left" width="60">班级名称</td>
          <td align="left" width="378"><input name="schoolClassLabel" class="easyui-validatebox textbox" style="width:120px;"/></td>
        </tr>
        <tr>
          <td align="left" width="48">公司名称</td>
          <td align="left" width="172" colspan="4"><input name="companyLabel" class="easyui-validatebox textbox" style="width:370px;"/></td>
        </tr>
        
       <tr>
        <tr>
          <td align="left" width="49">等级</td>
          <td align="left"><input id="scoreLevel" name="scoreLevel" class="easyui-numberbox" style="width:120px;text-align:right" 
          value="0" data-options="required:true"/></td>
        </tr>
        <tr>
          <td align="left" width="49">金币</td>
          <td align="left"><input id="scoreGold" name="scoreGold" class="easyui-numberbox" style="width:120px;text-align:right" 
          value="0" data-options="required:true"/></td>
          <td align="left" width="49">金币经验</td>
          <td align="left"><input id="scoreGoldExperience" name="scoreGoldExperience" class="easyui-numberbox" style="width:120px;text-align:right" 
          value="0" data-options="required:true"/></td>
        </tr>
        <tr>
          <td align="left" width="49">豆币</td>
          <td align="left"><input id="scorePoint" name="scorePoint" class="easyui-numberbox" style="width:120px;text-align:right" 
          value="0" data-options="required:true"/></td>
          <td align="left" width="49">豆币经验</td>
          <td align="left"><input id="scorePointExperience" name="scorePointExperience" class="easyui-numberbox" style="width:120px;text-align:right" 
          value="0" data-options="required:true"/></td>
        </tr>
        <tr>
          <td align="left" width="49">豆豆</td>
          <td align="left"><input id="scoreBean" name="scoreBean" class="easyui-numberbox" style="width:120px;text-align:right" 
          value="0" data-options="required:true"/></td>
          <td align="left" width="49">豆豆经验</td>
          <td align="left"><input id="scoreBeanExperience" name="scoreBeanExperience" class="easyui-numberbox" style="width:120px;text-align:right" 
          value="0" data-options="required:true"/></td>
        </tr>
       
      </table>
    </div>
</form>
</div>
</body>
</HTML>