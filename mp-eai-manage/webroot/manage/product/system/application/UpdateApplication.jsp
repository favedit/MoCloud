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
        var url = "/manage/product/system/application/Application.wa?do=update&date="
                + new Date().valueOf();
        var data = {
            "label" : $('#label').val(),
            "adminId" : $('#adminId').val(),
            "code" : $('#code').val(),
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
                location.href = "/manage/product/system/application/Application.wa";
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
     href="/manage/product/system/application/Application.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">

  <form id="config"
   action="/manage/product/system/application/Application.wa?do=update"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
    <table width="770" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="78" height="33"><div align="left">英文名称:</div></td>
     <td><div align="left">
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
     <td width="78" height="33"><div align="left">中文名称:</div></td>
     <td><div align="left">
       <input id="code" name="code" class="easyui-validatebox textbox notnull"
        style="width:380px;height:18px;"
        data-options="required:true,validType:'length[0,80]'" value="<jh:write source='&unit.code'/>"/> 
      </div></td>
    </tr>
    <tr>
      <td width="78" height="30" align="left">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
      <td height="30" align="left">
         <input id="note" name="note" class="easyui-textbox" data-options="multiline:true" 
         value="<jh:write source='&unit.note'/>" style="height:100px;width:700px" />
      </td>
   </tr>
   </table>
  </form>
 </div>
</body>
</HTML>