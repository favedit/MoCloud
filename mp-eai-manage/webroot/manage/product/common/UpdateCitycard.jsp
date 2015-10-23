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
      $("#cityId").val($('#city').combobox("getValue"));
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
            $('#country').combobox("select", $('#countryId').val());
         },
         fail: function() {
            alert("error");
         }
      });
      getCountry(0);
      getArea(0);
      getProvince(0);
   })
   function getCountry(flag){
      var data = null;
      var counId = $('#country').combobox("getValue");
      var countId =$('#countryId').val();
      if(counId!=null) data={"countryId":counId};
      var url = "/manage/product/common/Area.wa?do=selectAll&date=" + new Date().valueOf();
      $.ajax({
         type: "POST",
         url: url,
         data: data,
         success: function(msg) {
               var result = toJsonObject(msg);
               $('#area').combobox("setValue",null);
               $('#area').combobox('loadData', result);
               if(flag=='0'){
                  $('#area').combobox("select", $('#areaId').val());
               }else{
                  $('#area').combobox("select", null);
               }
         },
         fail: function() {
            alert("error");
         }
      });
   }
   function getArea(flag){
      var data = null;
      var areaId = $('#area').combobox("getValue");
      if(areaId!=null) data={"areaId":areaId};
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
               if(flag=='0'){
                  $('#province').combobox("select", $('#provinceId').val());
               }else{
                  $('#province').combobox("select", null);
               }
         },
         fail: function() {
            alert("error");
         }
      });
   }
   function getProvince(flag){
      var data = null;
      var provinceId = $('#province').combobox("getValue");
      if(provinceId!=null) data={"provinceId":provinceId};
      var url = "/manage/product/common/City.wa?do=selectAll&date=" + new Date().valueOf();
      $.ajax({
         type: "POST",
         url: url,
         data: data,
         success: function(msg) {
               var result = toJsonObject(msg);
               if(result.length==0){
               }
               $('#city').combobox("setValue",null);
               $('#city').combobox('loadData', result);
               if(flag=='0'){
                  $('#city').combobox("select", $('#cityId').val());
               }else{
                  $('#city').combobox("select", null);
               }
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
   <span>修改城市身份证对照信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="add_btn"></a> <a
     href="/manage/product/common/Citycard.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">
  <form id="config"
   action="/manage/product/common/Citycard.wa?do=update"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <table width="850" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="78" height="33"><div align="left">身份证:</div></td>
     <td><div align="left">
       <input id="cardCode" name="cardCode" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;" value="<jh:write source='&unit.cardCode'/>"
        data-options="required:true,validType:'length[0,11]'" /> <input id="adminId"
        name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
        <input id="ouid" name="ouid" style="display:none;"
        value="<jh:write source='&unit.ouid'/>" />
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所属国家:</div></td>
     <td><div align="left">
       <input class="easyui-combobox" style="width:380px;" id="country" name="country" data-options="valueField:'ouid',textField:'name',editable:false"/>
       <input name="countryId" id="countryId" type="hidden" value="<jh:write source='&unit.countryId'/>">
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所属区域:</div></td>
     <td><div align="left">
       <div onclick="getCountry(1)" style="width:380px;"><input class="easyui-combobox" style="width:380px;" id="area" name="area" data-options="valueField:'ouid',textField:'label',editable:false" /></div>
       <input name="areaId" id="areaId" type="hidden" value="<jh:write source='&unit.areaId'/>">
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所属省份:</div></td>
     <td><div align="left">
       <div onclick="getArea(1)" style="width:380px;"><input class="easyui-combobox" style="width:380px;" id="province" name="province" data-options="valueField:'ouid',textField:'label',editable:false" /></div>
       <input name="provinceId" id="provinceId" type="hidden" value="<jh:write source='&unit.provinceId'/>">
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所属城市:</div></td>
     <td><div align="left">
       <div onclick="getProvince(1)" style="width:380px;"><input class="easyui-combobox" style="width:380px;" id="city" name="city" data-options="valueField:'ouid',textField:'label',editable:false" /></div>
       <input name="cityId" id="cityId" type="hidden" value="<jh:write source='&unit.cityId'/>">
      </div></td>
    </tr>
   </table>
  </form>
 </div>
</body>

</HTML>