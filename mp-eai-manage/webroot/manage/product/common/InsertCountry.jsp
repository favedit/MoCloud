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
       if (!isValid()){
          closeProgress();
          return;
       }
       $("#config").submit();
       closeProgress();
    }
</script>
<body bgcolor="#198bc9">
 <div id="cy_right" style="width:100%">
  <div class="right_title" style="width:100%">
   <span>增加国家信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="add_btn"></a> <a
     href="/manage/product/common/Country.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">

  <form id="config"
   action="/manage/product/common/Country.wa?do=insert"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <table width="850" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="78" height="33"><div align="left">英&nbsp;&nbsp;文&nbsp;&nbsp;名&nbsp;&nbsp;称:</div></td>
     <td><div align="left">
       <input id="name" name="name" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,70]'" /> <input id="adminId"
        name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
      </div></td>
    </tr>
    <tr>
     <td width="30" height="33" colspan="1"><div align="left">中&nbsp;&nbsp;文&nbsp;&nbsp;名&nbsp;&nbsp;称:</div></td>
     <td colspan="3"><div align="left">
       <input id="label" name="label" style="width:380px;height:20px;"
        class="easyui-validatebox textbox notnull" data-options="required:true,validType:'length[0,80]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">排&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;序:</div></td>
     <td><div align="left">
       <input id="displayCode" name="displayCode" style="width:380px;height:20px;" 
        class="easyui-validatebox textbox notnull" data-options="required:true,validType:'length[0,11]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">区&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</div></td>
     <td><div align="left">
       <input id="phoneCode" name="phoneCode" style="width:380px;height:20px;" 
        class="easyui-validatebox textbox notnull" data-options="required:true,validType:'length[0,7]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">英文名称简写:</div></td>
     <td><div align="left">
       <input id="code" name="code" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,80]'" /> 
      </div></td>
    </tr>
    <tr>
      <td width="78" height="30" align="left">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注</td>
      <td height="30" align="left">
         <input id="note" name="note" class="easyui-textbox" data-options="multiline:true" style="height:100px;width:600px" />
      </td>
   </tr>
   </table>
  </form>
 </div>
</body>

</HTML>