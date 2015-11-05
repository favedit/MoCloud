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
        var url = "/manage/product/common/Country.wa?do=update&date="
                + new Date().valueOf();
        var data = {
            "name" : $('#name').val(),
            "adminId" : $('#adminId').val(),
            "ouid" : $('#ouid').val(),
            "displayCode" : $('#displayCode').val(),
            "label" : $('#label').val(),
            "phoneCode" : $('#phoneCode').val(),
            "code" : $('#code').val(),
            "note" : $('#note').val(),
        };
        $.ajax({
            type : "POST",
            url : url,
            data : data,
            success : function(msg) {
                closeProgress();
                var result = toJsonObject(msg);
                location.href = "/manage/product/common/Country.wa";
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
   <span>修改国家信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="sub_btn"></a> <a
     href="/manage/product/common/Country.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">
  <form id="config"
   action="/manage/product/common/Country.wa?do=update"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <table width="850" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="78" height="33"><div align="left">名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</div></td>
     <td><div align="left">
       <input id="name" name="name"  value="<jh:write source='&unit.name'/>"  class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,70]'" /> <input id="adminId"
        name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
        <input id="ouid" name="ouid" style="display:none" value="<jh:write source='&unit.ouid'/>" />
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签:</div></td>
     <td><div align="left">
       <input id="label" name="label" class="easyui-validatebox textbox notnull"  value="<jh:write source='&unit.label'/>"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,70]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">排&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;序:</div></td>
     <td><div align="left">
       <input id="displayCode" name="displayCode" class="easyui-validatebox textbox notnull"  value="<jh:write source='&unit.displayCode'/>"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,11]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">区&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</div></td>
     <td><div align="left">
       <input id="phoneCode" name="phoneCode" class="easyui-validatebox textbox notnull"  value="<jh:write source='&unit.phoneCode'/>"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,7]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">代&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</div></td>
     <td><div align="left">
       <input id="code" name="code" class="easyui-validatebox textbox notnull"  value="<jh:write source='&unit.code'/>"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,80]'" /> 
      </div></td>
    </tr>
    <tr>
      <td width="78" height="30" align="left">备注</td>
      <td height="30" align="left">
         <input id="note" name="note" class="easyui-textbox"  value="<jh:write source='&unit.note'/>" data-options="multiline:true" style="height:100px;width:600px" />
      </td>
   </tr>
   </table>
  </form>
 </div>
</body>

</HTML>