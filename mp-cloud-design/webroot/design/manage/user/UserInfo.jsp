<%@ include file='/cloud/apl/public.inc'%>
<jh:define source="&basePage.user" alias="base"></jh:define>
<jh:define source="&userPage.userUnit" alias="user"></jh:define>
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
	
   var oldImgUrl = $("#oldIconUrl").val()
   $("#iconUrl").attr("src",oldImgUrl);	
   
   
   if($('#oriStatusCd').val() != 0){
		$('#statusCd').combobox("select",$('#oriStatusCd').val());
	}
	
	if($('#oldOccupationCd').val() != 0){
		$('#occupationCd').combobox("select",$('#oldOccupationCd').val());
	}
	if($('#oldTeacherCd').val() != 0){
		$('#teacherCd').combobox("select",$('#oldTeacherCd').val());
	}
	if($('#oriRoleCd').val() != 0){
		$('#roleCd').combobox("select",$('#oriRoleCd').val());
	}
	
	if($('#oldDevelopLevelCd').val() != 0){
		$('#developLevelCd').combobox("select",$('#oldDevelopLevelCd').val());
	}
	
	if($('#oldPlayerLevelCd').val() != 0){
		$('#playerLevelCd').combobox("select",$('#oldPlayerLevelCd').val());
	}
	
	$('#schoolId').combogrid({
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
	initSchoolCombogrid(null);
	$("#schoolId").combogrid("setValue",$("#oriSchoolId").val());
	var grid=$("#schoolId").combogrid("grid");//获取表格对象 
    var row = grid.datagrid('getSelected');//获取行数据 
	var pager =	grid.datagrid().datagrid('getPager');
	pager.pagination({
		pageSize: 20,
		showPageList:false,
		onSelectPage:function(pageNumber){
			initSchoolCombogrid(pageNumber);
		}
	});
	
    var url = "/cloud/product/user/User.wa?do=selectUserOccupation&userId="+$("#ouid").val()+"&date="+new Date().valueOf();
	$.ajax({
	   type: "POST",
	   url:url,
	   success: function(msg){
		 closeProgress();
		 $('#userOccupation').datagrid('loadData', toJsonObject(msg));
	   },
	   fail:function(){
		 closeProgress();
	   	 alert("error");
	   }
	});
});

function initSchoolCombogrid(page){
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
		 $("#schoolId").combogrid('grid').datagrid('loadData', toJsonObject(msg));
		 
		 if(page == null){
		 	 $("#schoolId").combogrid('select', 1);
		 }
	   },
	   fail:function(){
	   	 alert("error");
	   }
	});
}

function submitForm(){
	var teacherCd = $('#teacherCd').combobox("getValue");
	if(teacherCd == '2'){
		var label = $("#label").val();
		if($.trim(label).length == 0){
			alert("导师必须有真实姓名！");
			$("#label").css("border","1px solid #FF0000");
			$("#label").focus();
			return;
		}
	}
	$('#form').submit();
}

</script>
</HEAD>
<body class="body">
<div class="easyui-panel" fit='true'>
  <form id="form" method="post" action="/cloud/product/user/User.wa?do=updateSave">
    <div id="cy_right" style="width:100%">
      <div class="right_title"> <span>用户详细信息</span> </div>
      <div class="btn_bar">
        <div class="nav_btn"> <a href="#" onClick="submitForm()" class="sub_btn"></a> <a href="/cloud/product/user/User.wa" class="back_btn"></a> </div>
      </div>
    </div>
    <div class='cy_edit_panel'>
      <table border="0">
        <tr>
          <td width="48" height="30" align="left">编号</td>
          <td width="172" align="left"><input id="ouid" name="ouid" class="disabled" readonly style="width:80px;" value="<jh:write source='&user.ouid'/>"/>
            <input name="adminId" style="display:none" value="<jh:write source='&base.ouid' />"/></td>
          <td align="left" width="50">角色类型</td>
          <td align="left"><select class="easyui-combobox" id="roleCd" name="roleCd" style="width:120px;" data-options="editable:false">
              <option value="0">未知</option>
              <option value="1">管理员</option>
              <option value="2">用户</option>
            </select>
            <input id="oriRoleCd" class="disabled" type="hidden" value="<jh:write source='&user.roleCd'/>"/></td>
          <td height="24" align="left" >图标</td>
          <td rowspan="2" colspan="3" align="left"><img width="64" height="64" id="iconUrl" onerror="imgNotfind();"/>
            <input class="textbox" id="oldIconUrl" readonly style="width:80px; display:none" value="<jh:write source='&user.iconUrl'/>"/></td>
        </tr>
        <tr>
          <td height="30" align="left">帐号</td>
          <td width="172" align="left"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.passport'/>"/></td>
          <td width="49" align="left">登陆时间</td>
          <td align="left"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.formatPassportLoginDate'/>"/></td>
        </tr>
        <tr>
          <td width="48" height="30" align="left">密码</td>
          <td width="172" align="left"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.password'/>"/></td>
          <td align="left" width="49">修改时间</td>
          <td align="left"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.formatPasswordUpdateDate'/>"/></td>
        </tr>
        <tr>
          <td width="48" height="30" align="left">显示名称</td>
          <td align="left"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.alias'/>"/></td>
          <td width="49"  align="left">状态</td>
          <td align="left" width="191"><input id="oriStatusCd" style="display:none" value="<jh:write source='&user.statusCd'/>"/>
            <select class="easyui-combobox" id="statusCd" name="statusCd" style="width:120px;" data-options="editable:false">
              <option value="1">正常</option>
              <option value="2">锁定</option>
            </select></td>
          <td align="left" width="50">职业类型</td>
          <td align="left" colspan="2"><input id="oldOccupationCd" type="hidden" value="<jh:write source='&user.occupationCd'/>"/>
            <select class="easyui-combobox" id="occupationCd" name="occupationCd" style="width:120px;" data-options="editable:false">
              <option value="1">开发者</option>
              <option value="2">玩家</option>
            </select></td>
        </tr>
        <tr>
          <td align="left" height="30" width="48">性别</td>
          <td align="left"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.genderCdLabel'/>"/></td>
          <td align="left" width="49">生日</td>
          <td align="left"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.formatBirthday'/>"/></td>
          <td align="left" width="49">真实名称</td>
          <td align="left"><input name="label" class="easyui-validatebox textbox" validtype="length[1,80]" style="width:120px;" value="<jh:write source='&user.label'/>"/></td>
          <td align="left" width="50">导师类型</td>
          <td align="left" colspan="2"><input id="oldTeacherCd" type="hidden" value="<jh:write source='&user.teacherCd'/>"/>
            <select class="easyui-combobox" id="teacherCd" name="teacherCd" style="width:120px;" data-options="editable:false">
              <option value="1">普通</option>
              <option value="2">导师</option>
            </select></td>
        </tr>
        <tr>
          <td height="30" align="left" width="48">手机号码</td>
          <td align="left"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.mobilePhone'/>"/></td>
          <td align="left" width="49">电话权限</td>
          <td align="left" width="191"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.phoneSecurityCdLabel'/>"/>
            <%-- <input type="checkbox"/>
            已验证--%></td>
        </tr>
        <tr>
          <td height="30" align="left" width="48">电子邮箱</td>
          <td align="left"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.contactEmail'/>"/></td>
          <td align="left" width="49">邮箱权限</td>
          <td align="left" width="191"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.emailSecurityCdLabel'/>"/>
            <%-- <input type="checkbox"/>
            已验证--%></td>
        </tr>
        <tr>
          <td height="30" align="left" width="48">QQ号码</td>
          <td align="left"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.contactQq'/>"/></td>
          <td align="left" width="49">QQ权限</td>
          <td align="left" width="191"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.qqSecurityCdLabel'/>"/></td>
        </tr>
        <tr> </tr>
        
          <td width="48" height="30" align="left">学校</td>
          <td align="left"><input id="schoolLabel" name="schoolLabel" class="easyui-validatebox textbox" validtype="length[1,80]" style="width:120px;" value="<jh:write source='&user.schoolLabel'/>"/></td>
          <td width="49" align="left">入学年份</td>
          <td align="left"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.schoolEnterYear'/>"/></td>
          <td width="60" align="left">院系名称</td>
          <td width="155" align="left"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.schoolPartLabel'/>"/></td>
          <td align="left" width="60">班级名称</td>
          <td align="left" width="378"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.schoolClassLabel'/>"/></td>
        <tr>
          <td width="48" height="30" align="left">学校</td>
          <td align="left">
          	<input id="oriSchoolId" type="hidden" value="<jh:write source='&user.schoolId'/>"/>
             <select id="schoolId" name="schoolId" class="easyui-combogrid" style="width:120px;"></select>
          </td>
        </tr>
        <tr>
          <td align="left" width="48">公司名称</td>
          <td align="left" width="172"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.companyLabel'/>"/></td>
        </tr>
        <tr>
          <td height="30" align="left">家庭电话</td>
          <td align="left"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.homePhone'/>"/></td>
          <td align="left">家庭住址</td>
          <td align="left"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.homeAddress'/>"/></td>
        </tr>
        <tr>
          <td height="30" align="left" width="60">创建日期</td>
          <td align="left"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.formatCreateDate'/>"/></td>
          <td height="24" align="left" width="60">修改日期</td>
          <td align="left"><input class="disabled" disabled style="width:120px;" value="<jh:write source='&user.formatUpdateDate'/>"/></td>
        </tr>
        <tr>
        <td align="left" width="49">开发者：</td>
        </tr>
        <tr>
        <td align="left" width="49">豆币</td>
          <td align="left"><input id="developScorePoint" name="developScorePoint" class="easyui-numberbox" style="width:120px;text-align:right" 
          value="<jh:write source='&user.developScorePoint'/>" data-options="required:true"/></td>
         <td align="left" width="49">职业级别</td>
          <td align="left"><input id="oldDevelopLevelCd" type="hidden" value="<jh:write source='&user.developLevelCd'/>"/>
            <select class="easyui-combobox" id="developLevelCd" name="developLevelCd" style="width:120px;" data-options="editable:false">
              <option value="0">未知</option>
              <option value="1">初级</option>
              <option value="2">高级</option>
            </select></td>
             <td align="left" width="49">等级</td>
          <td align="left"><input id="developLevel" name="developLevel" class="easyui-numberbox" style="width:120px;text-align:right" 
          value="<jh:write source='&user.developLevel'/>" data-options="required:true"/></td>
          <td align="left" width="49">经验</td>
          <td align="left"><input id="developExperience" name="developExperience" class="easyui-numberbox" style="width:120px;text-align:right" 
          value="<jh:write source='&user.developExperience'/>" data-options="required:true"/></td>
        </tr>
        <tr>
        <td align="left" width="49">玩家：</td>
        </tr>
        <tr>
        <td align="left" width="49">豆豆</td>
          <td align="left"><input id="playerScoreBean" name="playerScoreBean" class="easyui-numberbox" style="width:120px;text-align:right" 
          value="<jh:write source='&user.playerScoreBean'/>" data-options="required:true"/></td>
         <td align="left" width="49">职业级别</td>
          <td align="left"><input id="oldPlayerLevelCd" type="hidden" value="<jh:write source='&user.playerLevelCd'/>"/>
            <select class="easyui-combobox" id="playerLevelCd" name="playerLevelCd" style="width:120px;" data-options="editable:false">
              <option value="0">未知</option>
              <option value="1">初级</option>
              <option value="2">高级</option>
            </select></td>
             <td align="left" width="49">等级</td>
          <td align="left"><input id="playerLevel" name="playerLevel" class="easyui-numberbox" style="width:120px;text-align:right" 
          value="<jh:write source='&user.playerLevel'/>" data-options="required:true"/></td>
          <td align="left" width="49">经验</td>
          <td align="left"><input id="playerExperience" name="playerExperience" class="easyui-numberbox" style="width:120px;text-align:right" 
          value="<jh:write source='&user.playerExperience'/>" data-options="required:true"/></td>
        </tr>
        <tr>
          <td></td>
        </tr>
      </table>
      <table class="easyui-datagrid" id="userOccupation" title="用户职业" style="width:950px;height:200px; text-align:center" 
       data-options="rownumbers:true,collapsible:true,singleSelect:true">
        <thead>
          <tr>
            <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>
            <th data-options="field:'occupationCdLabel',halign:'center',align:'center'" width="110px">职业类型</th>
            <th data-options="field:'scorePoint',halign:'center',align:'right'" width="60px">积分</th>
            <th data-options="field:'scoreExperience',halign:'center',align:'right'" width="60px">最大点数</th>
            <th data-options="field:'occupationLevel',halign:'center',align:'right'" width="60px">职业级别</th>
            <th data-options="field:'createDate',halign:'center',align:'center'" width="140px">创建时间</th>
            <th data-options="field:'updateDate',halign:'center',align:'center'" width="140px">更新时间</th>
          </tr>
        </thead>
      </table>
    </div>
  </form>
</div>
</body>
</HTML>