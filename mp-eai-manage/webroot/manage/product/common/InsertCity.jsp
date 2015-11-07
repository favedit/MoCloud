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
    $(function() {
       $('#countryId').combobox('clear');
       var url = "/manage/product/common/Country.wa?do=selectAll&date=" + new Date().valueOf();
       var data = null;
       $.ajax({
          type: "POST",
          url: url,
          data: data,
          success: function(msg) {
             var result = toJsonObject(msg);
             $('#countryId').combobox('loadData', result);
             $('#countryId').combobox('select', result[0].ouid);
             var data={"countryId":result[0].ouid};
             getAreaData(data);
          },
          fail: function() {
             alert("error");
           }
        });
   })
   function getCountry(){//获取countryId
      var data = null;
      var counId = $('#countryId').combobox("getValue");
      if(counId!=null) data={"countryId":counId};
      getAreaData(data);
   }
    function getAreaData(data){//获取区域
       $('#areaId').combobox('clear');
       var url = "/manage/product/common/Area.wa?do=selectAll&date=" + new Date().valueOf();
       $.ajax({
          type: "POST",
          url: url,
          data: data,
          success: function(msg) {
             var result = toJsonObject(msg);
             $('#areaId').combobox("setValue",null);
             $('#areaId').combobox('loadData', result);
             $('#areaId').combobox('select', result[0].ouid);
             var data={"areaId":result[0].ouid};
             getProvinceData(data);
          },
          fail: function() {
             alert("error");
          }
       });
    }
   function getArea(){//取得区域id
      var data = null;
      var areaId = $('#areaId').combobox("getValue");
      if(areaId!=null) data={"areaId":areaId};
      getProvinceData(data);
   }
   function getProvinceData(data){//获取省份
      $('#provinceId').combobox('clear');
      var url = "/manage/product/common/Province.wa?do=selectAll&date=" + new Date().valueOf();
      $.ajax({
         type: "POST",
         url: url,
         data: data,
         success: function(pmsg) {
            var presult = toJsonObject(pmsg);
            $('#provinceId').combobox("setValue",null);
            $('#provinceId').combobox('loadData', presult);
            $('#provinceId').combobox('select', presult[0].ouid);
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
     <td width="78" height="33"><div align="left">所&nbsp;&nbsp;属&nbsp;&nbsp;国&nbsp;&nbsp;家:</div></td>
     <td><div align="left">
       <input class="easyui-combobox" style="width:380px;" id="countryId" name="countryId" data-options="valueField:'ouid',textField:'name',editable:false"/>
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所&nbsp;&nbsp;属&nbsp;&nbsp;区&nbsp;&nbsp;域:</div></td>
     <td><div align="left">
       <div style="width:380px;" onclick="getCountry()"><input class="easyui-combobox" style="width:380px;" id="areaId" name="areaId" data-options="valueField:'ouid',textField:'label',editable:false"/></div>
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">所&nbsp;&nbsp;属&nbsp;&nbsp;省&nbsp;&nbsp;份:</div></td>
     <td><div align="left">
       <div style="width:380px;" onclick="getArea()"><input class="easyui-combobox" style="width:380px;" id="provinceId" name="provinceId" data-options="valueField:'ouid',textField:'label',editable:false"/></div>
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">中&nbsp;&nbsp;文&nbsp;&nbsp;名&nbsp;&nbsp;称:</div></td>
     <td><div align="left">
       <input id="label" name="label" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,70]'" /> <input id="adminId"
        name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">排&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;序:</div></td>
     <td><div align="left">
       <input id="displayOrder" name="displayOrder" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,11]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">身份证前4位:</div></td>
     <td><div align="left">
       <input id="code" name="code" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,50]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">级&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</div></td>
     <td><div align="left">
       <input id="level" name="level" class="easyui-validatebox textbox"
        style="width:380px;height:20px;"
        data-options="validType:'length[0,10]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">城&nbsp;&nbsp;市&nbsp;&nbsp;区&nbsp;&nbsp;号:</div></td>
     <td><div align="left">
       <input id="cityCode" name="cityCode" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,50]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">经&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度:</div></td>
     <td><div align="left">
       <input id="locationLongitude" name="locationLongitude" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,50]'" /> 
      </div></td>
    </tr>
    <tr>
     <td width="78" height="33"><div align="left">纬&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;度:</div></td>
     <td><div align="left">
       <input id="locationLatitude" name="locationLatitude" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px;"
        data-options="required:true,validType:'length[0,50]'" /> 
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