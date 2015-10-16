<%@ include file='/apl/public.inc'%>
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
       $("#config").submit();
       closeProgress();
    }
</script>
<body bgcolor="#198bc9">
 <div id="cy_right" style="width:100%">
  <div class="right_title" style="width:100%">
   <span>增加城市信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="add_btn"></a> <a
     href="/manage/product/common/City.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">
  <form id="config"
   action="/manage/product/common/City.wa?do=insert"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <table width="850" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="78" height="33"><div align="left">标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签:</div></td>
     <td><div align="left">
       <input id="label" name="label" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,70]'" /> <input id="adminId"
        name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">代&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</div></td>
     <td><div align="left">
       <input id="code" name="code" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,50]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">级&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</div></td>
     <td><div align="left">
       <input id="level" name="level" class="easyui-validatebox textbox"
        style="width:380px;height:20px;"
        data-options="validType:'length[0,10]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">城市区号:</div></td>
     <td><div align="left">
       <input id="cityCode" name="cityCode" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,50]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所属国家:</div></td>
     <td><div align="left">
       <input id="countryLabel" name="countryLabel" class="easyui-validatebox textbox"
        style="width:380px;height:20px;"
        data-options="validType:'length[0,70]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所属区域:</div></td>
     <td><div align="left">
       <input id="areaLabel" name="areaLabel" class="easyui-validatebox textbox"
        style="width:380px;height:20px;"
        data-options="validType:'length[0,80]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所属省会:</div></td>
     <td><div align="left">
       <input id="provinceLabel" name="provinceLabel" class="easyui-validatebox textbox"
        style="width:380px;height:20px;"
        data-options="validType:'length[0,80]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">经&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度:</div></td>
     <td><div align="left">
       <input id="locationLongitude" name="locationLongitude" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,50]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">纬&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度:</div></td>
     <td><div align="left">
       <input id="locationLatitude" name="locationLatitude" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,50]'" /> 
      </div></td>
    </tr>
    <tr>
      <td width="78" height="30" align="left">备注</td>
      <td height="30" align="left">
         <input id="note" name="note" class="easyui-textbox" data-options="multiline:true" style="height:100px;width:600px" />
      </td>
   </tr>
   </table>
  </form>
 </div>
</body>

</HTML>