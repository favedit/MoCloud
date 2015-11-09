<%@ include file='/apl/public.inc'%>
<jh:define source="&page.unit" alias="unit"></jh:define>
<HTML>

<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css"
 media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
</HEAD>
<script>
    function submitForm() {
       progress();
       if (!isValid()){
          closeProgress();
          return;
       }
       $("#departmentId").val($('#olddepartmentId').combobox("getValue"));
       $("#config").submit();
       closeProgress();
    }
    $(function() {
       $('#olddepartmentId').combobox('clear');
       var url = "/manage/product/organization/department/Department.wa?do=selectAll&date=" + new Date().valueOf();
       var data = null;//初始化
       $.ajax({
          type: "POST",
          url: url,
          data: data,
          success: function(msg) {
             var result = toJsonObject(msg);
             $('#olddepartmentId').combobox('loadData', result);
             $('#olddepartmentId').combobox("select", $('#departmentId').val());
          },
          fail: function() {
             alert("error");
          }
       });
    });
</script>

<body bgcolor="#198bc9">
 <div id="cy_right" style="width:100%">
  <div class="right_title" style="width:100%">
   <span>修改组织部门用户信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="sub_btn"></a> <a
     href="/manage/product/organization/department/user/User.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">
  <form id="config" enctype=multipart/form-data
   action="/manage/product/organization/department/user/User.wa?do=update"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <table width="810" height="390" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="86" height="38"><div align="left">英&nbsp;&nbsp;文&nbsp;&nbsp;名&nbsp;&nbsp;&nbsp;称:</div></td>
     <td colspan="3"><div align="left">
       <input id="name" name="name" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,80]'"
        value="<jh:write source='&unit.name'/>" /><input id="adminId"
        name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" /><input
        id="ouid" name="ouid" style="display:none"
        value="<jh:write source='&unit.ouid'/>" />
      </div></td>
      <td rowspan="3" style="width:114px;" ></td>
     </tr>
     <tr>
      <td width="86" height="38"><div align="left">中&nbsp;&nbsp;文&nbsp;&nbsp;名&nbsp;&nbsp;&nbsp;称:</div></td>
      <td colspan="3"><input id="label" name="label" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,80]'" value="<jh:write source='&unit.label'/>" /></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
     <td height="38"><div align="left">英文名称简写:</div></td>
     <td colspan="3"><div align="left">
       <input id="code" name="code" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,8]'" value="<jh:write source='&unit.code'/>" />
     </div></td>
     <td>&nbsp;</td>
     </tr>
     <tr>
     <td height="38"><div align="left">所&nbsp;&nbsp;属&nbsp;&nbsp;部&nbsp;&nbsp;门:</div></td>
     <td colspan="3"><div align="left">
       <input class="easyui-combobox" style="width:380px;" id="olddepartmentId" name="olddepartmentId" data-options="valueField:'ouid',textField:'label',editable:false"/>
       <input name="departmentId" id="departmentId" type="hidden" value="<jh:write source='&unit.departmentId'/>">
      </div></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
     <td height="38"><div align="left">雇&nbsp;&nbsp;用&nbsp;&nbsp;状&nbsp;&nbsp;&nbsp;态:</div></td>
     <td colspan="3"><div align="left">
       <input type="hidden" id="oldStatusCd" value="<jh:write source='&unit.statusCd'/>">
       <input style="width:380px;height:20px" id="statusCd" class="easyui-combobox" name="statusCd" data-options="valueField:'value',textField:'text',
       data:[{'value':'1','text':'在职'},{'value':'2','text':'离职'},{'value':'3','text':'待定'}],editable:false"/>
      </div></td>
     <td>&nbsp;</td>
    </tr>
    <tr>
     <td height="38"><div align="left">关&nbsp;&nbsp;联&nbsp;&nbsp;关&nbsp;&nbsp;&nbsp;系:</div></td>
     <td colspan="3"><div align="left">
       <input type="hidden" id="oldRelationCd" value="<jh:write source='&unit.relationCd'/>">
       <input style="width:380px;height:20px" id="relationCd" class="easyui-combobox" name="relationCd" data-options="valueField:'value',textField:'text',
       data:[{'value':'0','text':'未知'},{'value':'1','text':'负责人'}],editable:false"/>
      </div></td>
     <td>&nbsp;</td>
    </tr>
    <tr>
      <td width="70" height="33">
         <div align="left">入职时间:</div>
      </td>
      <td width="230">
         <div align="left">
            <input id="entryDate" name="entryDate" style="width:200px;" class="easyui-datebox" value="<jh:write source='&unit.entryDate'/>" data-options="editable:false"></input>
         </div>
      </td>
      <td width="70" height="33">
         <div align="left">离职时间:</div>
      </td>
      <td width="208">
         <div align="left">
            <input id="leaveDate" name="leaveDate" style="width:200px;" class="easyui-datebox" value="<jh:write source='&unit.leaveDate'/>" data-options="editable:false"></input>
         </div>
      </td>
   </tr>
    <tr>
     <td height="38"><div align="left">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</div></td>
     <td colspan="3"><div align="left">
       <textarea id="note" name="note" class="border_change" style="width:520px;height:100px"><jh:write source='&unit.note' format='text'/></textarea>
      </div></td>
    </tr>
   </table>
  </form>
 </div>
</body>

</HTML>