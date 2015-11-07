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
        var url = "/manage/product/common/configration/rule/Rule.wa?do=update&date="
                + new Date().valueOf();
        var data = {
            "ruleCdStr" : $('#ruleCdStr').val(),
            "adminId" : $('#adminId').val(),
            "percentage" : $('#percentage').val(),
            "scorePoint" : $('#scorePoint').val(),
            "parameters1" : $('#parameters1').val(),
            "parameters2" : $('#parameters2').val(),
            "parameters3" : $('#parameters3').val(),
            "parameters4" : $('#parameters4').val(),
            "note" : $('#note').val(),
            "ouid" : $('#ouid').val()
        };
        $.ajax({
            type : "POST",
            url : url,
            data : data,
            success : function(msg) {
                closeProgress();
                var result = toJsonObject(msg);
                location.href = "/manage/product/common/configration/rule/Rule.wa";
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
   <span>修改规则配置信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="sub_btn"></a> <a
     href="/manage/product/common/configration/rule/Rule.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">

  <form id="config"
   action="/manage/product/common/configuration/rule/Rule.wa?do=update"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
    <table border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="80" height="33" colspan="1"><div align="left">规&nbsp;则&nbsp;状&nbsp;态:</div></td>
     <td colspan="3"><div align="left">
       <input id="ruleCdStr" name="ruleCdStr" class="easyui-validatebox textbox"
        style="width:280px;height:20px;" readonly="readonly"
        value="<jh:write source='&unit.ruleCdStr'/>" />
        <input id="adminId" name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
        <input id="ouid" name="ouid" style="display:none"
        value="<jh:write source='&unit.ouid'/>" />
      </div></td>
    </tr>
    <tr>
     <td width="80" height="33" colspan="1"><div align="left">权重百分比:</div></td>
     <td colspan="3"><div align="left">
       <input id="percentage" name="percentage" class="easyui-validatebox textbox"
        style="width:280px;height:18px;"
        data-options="validType:'length[0,11]'" value="<jh:write source='&unit.percentage'/>"/> 
      </div></td>
    </tr>
    <tr>
     <td width="80" height="33" colspan="1"><div align="left">分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数:</div></td>
     <td colspan="3"><div align="left">
       <input id="scorePoint" name="scorePoint" class="easyui-validatebox textbox"
        style="width:280px;height:18px;"
        data-options="validType:'length[0,11]'" value="<jh:write source='&unit.scorePoint'/>"/> 
      </div></td>
    </tr>
    <tr>
     <td width="80" height="33" colspan="1"><div align="left">参&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数1:</div></td>
     <td colspan="3"><div align="left">
       <input id="parameters1" name="parameters1" class="easyui-validatebox textbox"
        style="width:280px;height:18px;"
        data-options="validType:'length[0,40]'" value="<jh:write source='&unit.parameters1'/>"/> 
      </div></td>
    </tr>
    <tr>
     <td width="80" height="33" colspan="1"><div align="left">参&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数2:</div></td>
     <td colspan="3"><div align="left">
       <input id="parameters2" name="parameters2" class="easyui-validatebox textbox"
        style="width:280px;height:18px;"
        data-options="validType:'length[0,40]'" value="<jh:write source='&unit.parameters2'/>"/> 
      </div></td>
    </tr>
    <tr>
     <td width="80" height="33" colspan="1"><div align="left">参&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数3:</div></td>
     <td colspan="3"><div align="left">
       <input id="parameters3" name="parameters3" class="easyui-validatebox textbox"
        style="width:280px;height:18px;"
        data-options="validType:'length[0,40]'" value="<jh:write source='&unit.parameters3'/>"/> 
      </div></td>
    </tr>
    <tr>
     <td width="80" height="33" colspan="1"><div align="left">参&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数4:</div></td>
     <td colspan="3"><div align="left">
       <input id="parameters4" name="parameters4" class="easyui-validatebox textbox"
        style="width:280px;height:18px;"
        data-options="validType:'length[0,40]'" value="<jh:write source='&unit.parameters4'/>"/> 
      </div></td>
    </tr>
    <tr>
      <td width="80" height="30" align="left" colspan="1">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
      <td height="30" align="left"  colspan="3">
         <input id="note" name="note" class="easyui-textbox" data-options="multiline:true" 
         style="height:100px;width:400px" value="<jh:write source='&unit.note'/>"/>
      </td>
   </tr>
   </table>
  </form>
 </div>
</body>
</HTML>