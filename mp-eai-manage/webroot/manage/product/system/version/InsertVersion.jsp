<%@ include file='/apl/public.inc'%>
<HTML>

<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css"
 media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
</HEAD>
<script>
    function submitForm() {
        if (!isValid()) return;
        $("#version").submit();
    }
</script>

<body bgcolor="#198bc9">
 <div id="cy_right" style="width:100%">
  <div class="right_title" style="width:100%">
   <span>增加版本信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="add_btn"></a> <a
     href="/product/system/version/Version.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">
  <form id="version"
   action="/product/system/version/Version.wa?do=insert"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <table border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="30" height="33" colspan="1"><div align="left">标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签:</div></td>
     <td colspan="3"><div align="left">
       <input id="label" name="label" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,80]'" /> <input id="adminId"
        name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
      </div></td>
    </tr>
    <tr>
     <td width="30" height="33" colspan="1"><div align="left">代&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</div></td>
     <td colspan="3"><div align="left">
       <input id="code" name="code" class="easyui-validatebox textbox notnull"
        style="width:380px;height:18px;"
        data-options="required:true,validType:'length[0,40]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="30" height="33" colspan="1"><div align="left">版本号:</div></td>
     <td colspan="3"><div align="left">
       <input id="number" name="number" class="easyui-validatebox textbox notnull"
        style="width:380px;height:18px;" data-options="required:true"/> 
      </div></td>
    </tr>
    <tr>
     <td height="30"><div align="left">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态:</div></td>
     <td colspan="3"><div align="left">
       <select id="statusCdStr" class="easyui-combobox" name="statusCdStr" style="width:200px;">
             <option value="1">申请</option>
             <option value="0">未知</option>
             <option value="2">发布</option>
             <option value="3">审核未通过</option>
        <select>
     </div></td>
    </tr>
    <tr>
     <td height="30"><div align="left">版本更新状态:</div></td>
     <td colspan="3"><div align="left">
       <select id="forceCdStr" class="easyui-combobox" name="forceCdStr" style="width:200px;">
             <option value="1">可选</option>
             <option value="0">未知</option>
             <option value="2">强制</option>
             <option value="3">自动</option>
             <option value="4">不更新</option>
        <select>
      </div></td>
    </tr>
    <tr>
     <td width="30" height="33" ><div align="left">应&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用:</div></td>
     <td colspan="3"><div align="left">
       <input id="applicationLabel" name="applicationLabel" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,80]'" /> 
        <input id="applicationLabel" name="applicationLabel" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,80]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="30" height="33"><div align="left">开始时间:</div></td>
     <td width="98"><div align="left">
       <input id="beginDate" name="beginDate" class="easyui-datebox"/>
      </div></td>
      <td width="30" height="33"><div align="left">结束时间:</div></td>
     <td width="98"><div align="left">
       <input id="endDate" name="endDate" class="easyui-datebox"/>
      </div></td>
    </tr>
    <tr>
      <td width="30" height="30" align="left" colspan="1">备注</td>
      <td height="30" align="left"  colspan="3">
         <input id="note" name="note" class="easyui-textbox" data-options="multiline:true" style="height:100px;width:700px" />
      </td>
   </tr>
   </table>
  </form>
 </div>
</body>
</HTML>