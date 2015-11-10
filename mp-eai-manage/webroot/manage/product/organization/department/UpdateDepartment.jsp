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
       $("#parentId").val($('#oldparentId').combobox("getValue"));
       $("#config").submit();
       closeProgress();
    }
    $(function() {
       $('#validCd').combobox("select", $('#oldValidCd').val());
       $('#oldparentId').combobox('clear');
       var url = "/manage/product/organization/department/Department.wa?do=selectAll&date=" + new Date().valueOf();
       var data = null;//初始化
       $.ajax({
          type: "POST",
          url: url,
          data: data,
          success: function(msg) {
             var result = toJsonObject(msg);
             $('#oldparentId').combobox('loadData', result);
             $('#oldparentId').combobox("select", $('#parentId').val());
          },
          fail: function() {
             alert("error");
          }
       });
       var oriBuildDate = $("#oriBuildDate").html();
       oriBuildDate = replaceNbsp(oriBuildDate);
       $('#buildDate').datetimebox({
          value: oriBuildDate,
          required: false,
          showSeconds: false
       });
    });
</script>

<body bgcolor="#198bc9">
 <div id="cy_right" style="width:100%">
  <div class="right_title" style="width:100%">
   <span>修改组织部门信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="sub_btn"></a> <a
     href="/manage/product/organization/department/Department.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">
  <form id="config" enctype=multipart/form-data
   action="/manage/product/organization/department/Department.wa?do=update"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <table width="810" height="200" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="86" height="38"><div align="left">英&nbsp;&nbsp;文&nbsp;&nbsp;名&nbsp;&nbsp;&nbsp;称:</div></td>
     <td><div align="left">
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
      <td><input id="label" name="label" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,80]'" value="<jh:write source='&unit.label'/>" /></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
     <td height="38"><div align="left">英文名称简写:</div></td>
     <td><div align="left">
       <input id="code" name="code" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,8]'" value="<jh:write source='&unit.code'/>" />
     </div></td>
     <td>&nbsp;</td>
     </tr>
    <tr>
     <td height="38"><div align="left">是&nbsp;&nbsp;否&nbsp;&nbsp;有&nbsp;&nbsp;&nbsp;效:</div></td>
     <td><div align="left">
       <input type="hidden" id="oldValidCd" value="<jh:write source='&unit.validCd'/>">
       <input style="width:380px;height:20px" id="validCd" class="easyui-combobox" name="validCd" data-options="valueField:'value',textField:'text',
       data:[{'value':'1','text':'有效'},{'value':'2','text':'无效'}],editable:false"/>
      </div></td>
     <td>&nbsp;</td>
    </tr>
    <tr>
     <td height="38"><div align="left">父&nbsp;&nbsp;级&nbsp;&nbsp;部&nbsp;&nbsp;门:</div></td>
     <td><div align="left">
       <input class="easyui-combobox" style="width:380px;" id="oldparentId" name="oldparentId" data-options="valueField:'ouid',textField:'label',editable:false"/>
       <input name="parentId" id="parentId" type="hidden" value="<jh:write source='&unit.parentId'/>">
      </div></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
     <td height="38"><div align="left">总&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数:</div></td>
     <td><div align="left">
       <input id="userCount"
        name="userCount"
        class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,11]'" value="<jh:write source='&unit.userCount'/>" />
      </div></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
     <td height="38"><div align="left">成&nbsp;&nbsp;立&nbsp;&nbsp;日&nbsp;&nbsp;期:</div></td>
     <td><div align="left">
       <input class="easyui-datetimebox" name="buildDate" id="buildDate" data-options="showSeconds:false,editable:false" style="width:180px" value="">
        <span id="oriBuildDate" style="display:none"><jh:date source='&unit.buildDate' format="YYYY-MM-DD"/></span>
      </div></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
     <td height="38"><div align="left">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述:</div></td>
     <td colspan="2"><div align="left">
       <textarea id="description" name="description" class="border_change" style="width:700px;height:100px"><jh:write source='&unit.description' format='text'/></textarea>
      </div></td>
    </tr>
   </table>
  </form>
 </div>
</body>

</HTML>