<%@ include file='/apl/public.inc'%>
<HTML>

<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css"
 media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
</HEAD>
<script>
    function submitForm() {
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
       <input id="label" name="label" class="easyui-validatebox textbox"
        style="width:280px;height:20px;"
        data-options="validType:'length[0,80]'" /> <input id="adminId"
        name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
      </div></td>
    </tr>
    <tr>
     <td width="30" height="33" colspan="1"><div align="left">代&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</div></td>
     <td colspan="3"><div align="left">
       <input id="code" name="code" class="easyui-validatebox textbox"
        style="width:280px;height:18px;"
        data-options="validType:'length[0,40]'" /> 
      </div></td>
    </tr>
    <tr>
     <td height="30"><div align="left">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态:</div></td>
     <td colspan="3"><div align="left">
       <input id="statusCdStr" class="easyui-combobox" name="statusCdStr" data-options="valueField:'value',textField:'text',
       data:[{'value':'0','text':'未知'},{'value':'1','text':'申请'},{'value':'2','text':'发布'},{'value':'3','text':'审核未通过'}]"/>  
     </div></td>
    </tr>
    <tr>
     <td height="30"><div align="left">版本更新状态:</div></td>
     <td colspan="3"><div align="left">
       <input id="forceCdStr" class="easyui-combobox" name="forceCdStr" data-options="valueField:'value',textField:'text',
       data:[{'value':'0','text':'未知'},{'value':'1','text':'可选'},{'value':'2','text':'强制'},{'value':'3','text':'自动'}]"/>  
      </div></td>
    </tr>
    <tr>
     <td width="30" height="33" ><div align="left">应&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用:</div></td>
     <td colspan="3"><div align="left">
       <input id="applicationLabel" name="applicationLabel" class="easyui-validatebox textbox"
        style="width:280px;height:20px;"
        data-options="validType:'length[0,80]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="30" height="33"><div align="left">开始时间:</div></td>
     <td width="78"><div align="left">
       <input id="beginDate" name="beginDate" class="easyui-datebox"></input>
      </div></td>
      <td width="30" height="33"><div align="left">结束时间:</div></td>
     <td width="78"><div align="left">
       <input id="endDate" name="endDate" class="easyui-datebox"></input>
      </div></td>
    </tr>
    <tr>
      <td width="30" height="30" align="left" colspan="1">备注</td>
      <td height="30" align="left"  colspan="3">
         <input id="note" name="note" class="easyui-textbox" data-options="multiline:true" style="height:100px;width:400px" />
      </td>
   </tr>
   </table>
  </form>
 </div>
</body>
</HTML>