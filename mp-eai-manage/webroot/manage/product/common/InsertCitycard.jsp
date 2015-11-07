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
             $('#country').combobox('select', result[0].ouid);
          },
          fail: function() {
             alert("error");
           }
        });
       getPData(null);
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
   function getProvince(){
      var data = null;
      var provinceId = $('#province').combobox("getValue");
      if(provinceId!=null) data={"provinceId":provinceId};
      getPData(data);
   }
   function getPData(data){
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
               $('#city').combobox('select', result[0].ouid);
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
   <span>增加城市身份证对照信息</span>
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
   action="/manage/product/common/Citycard.wa?do=insert"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <table width="850" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="78" height="33"><div align="left">身份证前6位:</div></td>
     <td><div align="left">
       <input id="cardCode" name="cardCode" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,11]'" /> <input id="adminId"
        name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所&nbsp;属&nbsp;国&nbsp;家:</div></td>
     <td><div align="left">
       <input class="easyui-combobox" style="width:380px;" id="country" name="country" data-options="valueField:'ouid',textField:'name',editable:false"/>
       <input name="countryId" id="countryId" type="hidden">
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所&nbsp;属&nbsp;区&nbsp;域:</div></td>
     <td><div align="left">
       <div onclick="getCountry()" style="width:380px;"><input class="easyui-combobox" style="width:380px;" id="area" name="area" data-options="valueField:'ouid',textField:'label',editable:false" /></div>
       <input name="areaId" id="areaId" type="hidden">
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所&nbsp;属&nbsp;省&nbsp;份:</div></td>
     <td><div align="left">
       <div onclick="getArea()" style="width:380px;"><input class="easyui-combobox" style="width:380px;" id="province" name="province" data-options="valueField:'ouid',textField:'label',editable:false" /></div>
       <input name="areaId" id="provinceId" type="hidden">
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所&nbsp;属&nbsp;城&nbsp;市:</div></td>
     <td><div align="left">
       <div onclick="getProvince()" style="width:380px;"><input class="easyui-combobox" style="width:380px;" id="city" name="city" data-options="valueField:'ouid',textField:'label',editable:false" /></div>
       <input name="cityId" id="cityId" type="hidden">
      </div></td>
    </tr>
   </table>
  </form>
 </div>
</body>

</HTML>