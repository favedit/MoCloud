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
        if (!isValid())
            return;
        progress();
        var url = "/product/system/version/Version.wa?do=update&date="
                + new Date().valueOf();
        var data = {
            "label" : $('#label').val(),
            "adminId" : $('#adminId').val(),
            "code" : $('#code').val(),
            "statusCdStr" : $("#statusCdStr").combobox("getValue"),
            "forceCdStr" : $("#forceCdStr").combobox("getValue"),
            "applicationLabel" : $('#applicationLabel').val(),
            "beginDate" : $('#beginDate').val(),
            "endDate" : $('#endDate').val(),
            "note" : $('#note').val(),
            "number" : $('#number').val(),
            "ouid" : $('#ouid').val()
        };
        $.ajax({
            type : "POST",
            url : url,
            data : data,
            success : function(msg) {
                closeProgress();
                var result = toJsonObject(msg);
                location.href = "/product/system/version/Version.wa";
            },
            fail : function() {
                closeProgress();
                alert("error");
            }
        });
    }
</script>

<body bgcolor="#198bc9">
 <div id="cy_right" style="width:100%">
  <div class="right_title" style="width:100%">
   <span>修改应用信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="sub_btn"></a> <a
     href="/product/system/version/Version.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">

  <form id="config"
   action="/product/system/version/Version.wa?do=update"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
    <table border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="30" height="33"><div align="left">标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签:</div></td>
     <td colspan="3"><div align="left">
       <input id="label" name="label" class="easyui-validatebox textbox"
        style="width:380px;height:20px;"
        data-options="validType:'length[0,80]'" readonly="readonly"
        value="<jh:write source='&unit.label'/>" />
        <input id="adminId" name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
        <input id="ouid" name="ouid" style="display:none"
        value="<jh:write source='&unit.ouid'/>" />
      </div></td>
    </tr>
    <tr>
     <td width="30" height="33"><div align="left">代&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</div></td>
     <td colspan="3"><div align="left">
       <input id="code" name="code" class="easyui-validatebox textbox notnull"
        style="width:380px;height:18px;" value="<jh:write source='&unit.code'/>"
        data-options="required:true,validType:'length[0,40]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="30" height="33"><div align="left">版本号:</div></td>
     <td colspan="3"><div align="left">
       <input id="number" name="number" class="easyui-validatebox textbox notnull" data-options="required:true"
        style="width:380px;height:18px;" value="<jh:write source='&unit.number'/>"/> 
      </div></td>
    </tr>
    <tr>
     <td width="30"><div align="left">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态:</div></td>
     <td colspan="3"><div align="left">
       <input id="statusCdStr" class="easyui-combobox" name="statusCdStr" 
       data-options="valueField:'value',textField:'text', 
       data:[{'value':'0','text':'未知'},{'value':'1','text':'申请'},{'value':'2','text':'发布'},{'value':'3','text':'审核未通过'}]" 
       value="<jh:write source='&unit.statusCdStr'/>"/>  
     </div></td>
    </tr>
    <tr>
     <td height="30"><div align="left">版本更新状态:</div></td>
     <td colspan="3"><div align="left">
       <input id="forceCdStr" class="easyui-combobox" name="forceCdStr"
        data-options="valueField:'value',textField:'text', 
       data:[{'value':'0','text':'未知'},{'value':'1','text':'可选'},{'value':'2','text':'强制'},{'value':'3','text':'自动'},{'value':'4','text':'不更新'}]" 
       value="<jh:write source='&unit.forceCdStr'/>"/>
      </div></td>
    </tr>
    <tr>
     <td width="30" height="33"><div align="left">应&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;用:</div></td>
     <td colspan="3"><div align="left">
       <input id="applicationLabel" name="applicationLabel" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;" value="<jh:write source='&unit.applicationLabel'/>"
        data-options="required:true,validType:'length[0,80]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="30" height="33"><div align="left">开始时间:</div></td>
     <td width="78"><div align="left">
       <input id="beginDate" name="beginDate" class="easyui-datebox" value="<jh:write source='&unit.beginDate'/>"></input>
      </div></td>
     <td width="30" height="33"><div align="left">结束时间:</div></td>
     <td width="98"><div align="left">
       <input id="endDate" name="endDate" class="easyui-datebox" value="<jh:write source='&unit.endDate'/>"></input>
      </div></td>
    </tr>
    <tr>
      <td width="30" height="30" align="left">备注</td>
      <td height="30" align="left" colspan="3">
         <input id="note" name="note" class="easyui-textbox" data-options="multiline:true" 
            value="<jh:write source='&unit.note'/>" style="height:100px;width:700px" />
      </td>
   </tr>
   </table>
  </form>
 </div>
</body>
</HTML>