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
       $("#countryId").val($('#country').combobox("getValue"));
       $("#areaId").val($('#area').combobox("getValue"));
       $("#provinceId").val($('#province').combobox("getValue"));
       $("#config").submit();
       closeProgress();
    }
    $(function() {
       var url = "/manage/product/common/Country.wa?do=selectAll&date=" + new Date().valueOf();
       var data = null;
       $.ajax({
          type: "POST",
          url: url,
          data: data,
          success: function(msg) {
             var result = toJsonObject(msg);
             $('#country').combobox('loadData', result);
             $('#country').combobox('select', result[0].ouid);
          },
          fail: function() {
             alert("error");
           }
        });
       getAData(null);
       getCData(null);
   })
   function getCountry(){
      var data = null;
      var counId = $('#country').combobox("getValue");
      if(counId!=null) data={"countryId":counId};
      getCData(data);
   }
    function getCData(data){
       var url = "/manage/product/common/Area.wa?do=selectAll&date=" + new Date().valueOf();
       $.ajax({
          type: "POST",
          url: url,
          data: data,
          success: function(msg) {
                var result = toJsonObject(msg);
                if(result.length==0){
                }
                $('#area').combobox("setValue",null);
                $('#area').combobox('loadData', result);
                $('#area').combobox('select', result[0].ouid);
          },
          fail: function() {
             alert("error");
          }
       });
    }
   function getArea(){
      var data = null;
      var areaId = $('#area').combobox("getValue");
      if(areaId!=null) data={"areaId":areaId};
      getAData(data);
   }
   function getAData(data){
      var url = "/manage/product/common/Province.wa?do=selectAll&date=" + new Date().valueOf();
      $.ajax({
         type: "POST",
         url: url,
         data: data,
         success: function(msg) {
               var result = toJsonObject(msg);
               if(result.length==0){
               }
               $('#province').combobox("setValue",null);
               $('#province').combobox('loadData', result);
               $('#province').combobox('select', result[0].ouid);
         },
         fail: function() {
            alert("error");
         }
      });
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
       <input class="easyui-combobox" style="width:380px;" id="country" name="country" data-options="valueField:'ouid',textField:'name',editable:false"/>
       <input name="countryId" id="countryId" type="hidden">
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所属区域:</div></td>
     <td><div align="left">
       <div onclick="getCountry()" style="width:380px;"><input class="easyui-combobox" style="width:380px;" id="area" name="area" data-options="valueField:'ouid',textField:'label',editable:false" /></div>
       <input name="areaId" id="areaId" type="hidden">
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所属省份:</div></td>
     <td><div align="left">
       <div onclick="getArea()" style="width:380px;"><input class="easyui-combobox" style="width:380px;" id="province" name="province" data-options="valueField:'ouid',textField:'label',editable:false" /></div>
       <input name="provinceId" id="provinceId" type="hidden">
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