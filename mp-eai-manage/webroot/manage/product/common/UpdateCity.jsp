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
        var url = "/product/common/City.wa?do=update&date="
                + new Date().valueOf();
        var data = {
            "label" : $('#label').val(),
            "adminId" : $('#adminId').val(),
            "ouid" : $('#ouid').val(),
            "level" : $('#level').val(),
            "code" : $('#code').val(),
            "note" : $('#note').val(),
            "cityCode" : $('#cityCode').val(),
            "countryLabel" : $('#countryLabel').val(),
            "areaLabel" : $('#areaLabel').val(),
            "provinceLabel" : $('#provinceLabel').val(),
            "locationLongitude" : $('#locationLongitude').val(),
            "locationLatitude" : $('#locationLatitude').val(),
            "note" : $('#note').val()
        };
        $.ajax({
            type : "POST",
            url : url,
            data : data,
            success : function(msg) {
                closeProgress();
                var result = toJsonObject(msg);
                location.href = "/product/common/City.wa";
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
   <span>修改城市信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="sub_btn"></a> <a
     href="/product/common/City.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">
  <form id="config"
   action="/product/common/City.wa?do=update"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <table width="550" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="78" height="33"><div align="left">标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签:</div></td>
     <td><div align="left">
       <input id="label" name="label" class="easyui-validatebox textbox" readonly="readonly" value="<jh:write source='&unit.label'/>"
        style="width:280px;height:20px;"
        data-options="validType:'length[0,70]'" /> <input id="adminId"
        name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
        <input id="ouid"
        name="ouid" style="display:none"
        value="<jh:write source='&unit.ouid'/>" />
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">级&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</div></td>
     <td><div align="left">
       <input id="level" name="level" class="easyui-validatebox textbox" value="<jh:write source='&unit.level'/>"
        style="width:280px;height:20px;"
        data-options="validType:'length[0,10]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">城市区号:</div></td>
     <td><div align="left">
       <input id="cityCode" name="cityCode" class="easyui-validatebox textbox" value="<jh:write source='&unit.cityCode'/>"
        style="width:280px;height:20px;"
        data-options="validType:'length[0,50]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所属国家:</div></td>
     <td><div align="left">
       <input id="countryLabel" name="countryLabel" class="easyui-validatebox textbox"  value="<jh:write source='&unit.countryLabel'/>"
        style="width:280px;height:20px;"
        data-options="validType:'length[0,70]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所属区域:</div></td>
     <td><div align="left">
       <input id="areaLabel" name="areaLabel" class="easyui-validatebox textbox" value="<jh:write source='&unit.areaLabel'/>"
        style="width:280px;height:20px;"
        data-options="validType:'length[0,80]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所属省会:</div></td>
     <td><div align="left">
       <input id="provinceLabel" name="provinceLabel" class="easyui-validatebox textbox" value="<jh:write source='&unit.provinceLabel'/>"
        style="width:280px;height:20px;"
        data-options="validType:'length[0,80]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">经&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度:</div></td>
     <td><div align="left">
       <input id="locationLongitude" name="locationLongitude" class="easyui-validatebox textbox" value="<jh:write source='&unit.locationLongitude'/>"
        style="width:280px;height:20px;"
        data-options="validType:'length[0,50]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">纬&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度:</div></td>
     <td><div align="left">
       <input id="locationLatitude" name="locationLatitude" class="easyui-validatebox textbox" value="<jh:write source='&unit.locationLatitude'/>"
        style="width:280px;height:20px;"
        data-options="validType:'length[0,50]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">代&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</div></td>
     <td><div align="left">
       <input id="code" name="code" class="easyui-validatebox textbox"  value="<jh:write source='&unit.code'/>"
        style="width:280px;height:20px;"
        data-options="validType:'length[0,50]'" /> 
      </div></td>
    </tr>
    <tr>
      <td width="78" height="30" align="left">备注</td>
      <td height="30" align="left">
         <input id="note" name="note" class="easyui-textbox"  value="<jh:write source='&unit.note'/>" data-options="multiline:true" style="height:100px;width:400px" />
      </td>
   </tr>
   </table>
  </form>
 </div>
</body>

</HTML>