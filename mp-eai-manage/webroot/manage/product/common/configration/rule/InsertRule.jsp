<%@ include file='/apl/public.inc'%>
<HTML>

<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css"
 media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
</HEAD>
<script>
    function submitForm() {
        progress();
        $("#rule").submit();
        closeProgress();
    }
</script>

<body bgcolor="#198bc9">
 <div id="cy_right" style="width:100%">
  <div class="right_title" style="width:100%">
   <span>增加规则配置信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="add_btn"></a> <a
     href="/manage/product/common/configration/rule/Rule.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">
  <form id="rule"
   action="/manage/product/common/configration/rule/Rule.wa?do=insert"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <table border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="80" height="33" colspan="1"><div align="left">规则状态:</div></td>
     <td colspan="3"><div align="left">
       <input id="ruleCd" class="easyui-combobox" name="ruleCd" data-options="valueField:'value',textField:'text',
       data:[{'value':'0','text':'未知'},{'value':'1','text':'最后登录'},{'value':'2','text':'周浏览次数'},{'value':'3','text':'月收入'},{'value':'4','text':'年龄'}]"/>
       <input id="adminId"
        name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
      </div></td>
    </tr>
    <tr>
     <td width="80" height="33" colspan="1"><div align="left">权重百分比:</div></td>
     <td colspan="3"><div align="left">
       <input id="percentage" name="percentage" class="easyui-validatebox textbox"
        style="width:280px;height:18px;"
        data-options="validType:'length[0,11]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="80" height="33" colspan="1"><div align="left">分&nbsp;&nbsp;&nbsp;&nbsp;数:</div></td>
     <td colspan="3"><div align="left">
       <input id="scorePoint" name="scorePoint" class="easyui-validatebox textbox"
        style="width:280px;height:18px;"
        data-options="validType:'length[0,11]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="80" height="33" colspan="1"><div align="left">参数1:</div></td>
     <td colspan="3"><div align="left">
       <input id="parameters1" name="parameters1" class="easyui-validatebox textbox"
        style="width:280px;height:18px;"
        data-options="validType:'length[0,40]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="80" height="33" colspan="1"><div align="left">参数2:</div></td>
     <td colspan="3"><div align="left">
       <input id="parameters2" name="parameters2" class="easyui-validatebox textbox"
        style="width:280px;height:18px;"
        data-options="validType:'length[0,40]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="80" height="33" colspan="1"><div align="left">参数3:</div></td>
     <td colspan="3"><div align="left">
       <input id="parameters3" name="parameters3" class="easyui-validatebox textbox"
        style="width:280px;height:18px;"
        data-options="validType:'length[0,40]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="80" height="33" colspan="1"><div align="left">参数4:</div></td>
     <td colspan="3"><div align="left">
       <input id="parameters4" name="parameters4" class="easyui-validatebox textbox"
        style="width:280px;height:18px;"
        data-options="validType:'length[0,40]'" /> 
      </div></td>
    </tr>
    <tr>
      <td width="80" height="30" align="left" colspan="1">备注</td>
      <td height="30" align="left"  colspan="3">
         <input id="note" name="note" class="easyui-textbox" data-options="multiline:true" style="height:100px;width:400px" />
      </td>
   </tr>
   </table>
  </form>
 </div>
</body>
</HTML>