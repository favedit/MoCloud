<%@ include file='/apl/public.inc' %>
   <jh:define source="&page.unit" alias="unit"></jh:define>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
   </HEAD>
   <script>
      $(function() {
         var url = "/product/system/application/Application.wa?do=selectAll&date=" + new Date().valueOf();
         var data = null;
         $.ajax({
            type: "POST",
            url: url,
            data: data,
            success: function(msg) {
               var result = toJsonObject(msg);
               $('#application').combobox('loadData', result);

               $('#application').combobox("select", $('#oldAppId').val());
            },
            fail: function() {
               alert("error");
            }
         });
      })

      function submitForm() {
         if (!isValid())
            return;
         progress();
         var forceCd = $("#forceCdStr").combobox("getValue");
         var applicationId = $('#application').combobox("getValue");
         var url = "/product/system/version/Version.wa?do=update&date=" + new Date().valueOf();
         var data = {
            "label": $('#label').val(),
            "adminId": $('#adminId').val(),
            "code": $('#code').val(),
            "forceCdStr": forceCd,
            "applicationId": applicationId,
            "beginDate": $('#beginDate').val(),
            "downloadUrl": $('#downloadUrl').val(),
            "endDate": $('#endDate').val(),
            "note": $('#note').val(),
            "number": $('#number').val(),
            "ouid": $('#ouid').val()
         };
         $.ajax({
            type: "POST",
            url: url,
            data: data,
            success: function(msg) {
               closeProgress();
               location.href = "/product/system/version/Version.wa";
            },
            fail: function() {
               closeProgress();
               alert("error");
            }
         });
      }
   </script>

   <body bgcolor="#198bc9">
      <div id="cy_right" style="width:100%">
         <div class="right_title" style="width:100%">
            <span>修改版本信息</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn">
               <a href="#" onClick="submitForm()" class="sub_btn"></a>
               <a href="/product/system/version/Version.wa" class="back_btn"></a>
            </div>
            <div class="nav_search"></div>
         </div>
      </div>
      <div class="easyui-panel" fit='true' data-options="border:false">

         <form id="config" action="/product/system/version/Version.wa?do=update" method="post" align="center">
            <font style="color:red;"><jh:write source='&page.result' /></font>
            <table border="0" align="left" cellpadding="0" cellspacing="0" style=" margin-left:10px">
               <tr>
                  <td width="70" height="33">
                     <div align="left">应用</div>
                  </td>
                  <td colspan="3">
                     <div align="left">
                        <input type="hidden" id="oldAppId" value="<jh:write source='&unit.applicationId'/>">
                        <select class="easyui-combobox" style="width:200px;" id="application" name="application" data-options="valueField:'ouid',textField:'label',editable:false" />
                        <input name="applicationId" id="applicationId" type="hidden">
                     </div>
                  </td>
               </tr>

               <tr>
                  <td width="70" height="33">
                     <div align="left">版本标题</div>
                  </td>
                  <td colspan="3">
                     <div align="left">
                        <input id="label" name="label" class="easyui-validatebox textbox" style="width:200px;height:20px;" data-options="validType:'length[0,80]'" value="<jh:write source='&unit.label'/>" />
                        <input id="adminId" name="adminId" style="display:none" value="<jh:write source='&basePage.userId'/>" />
                        <input id="ouid" name="ouid" style="display:none" value="<jh:write source='&unit.ouid'/>" />
                     </div>
                  </td>
               </tr>
               <tr>
                  <td width="70" height="33">
                     <div align="left">版本名称</div>
                  </td>
                  <td colspan="3">
                     <div align="left">
                        <input id="code" name="code" class="easyui-validatebox textbox notnull" style="width:200px;height:18px;" value="<jh:write source='&unit.code'/>" data-options="required:true,validType:'length[0,40]'" />
                     </div>
                  </td>
               </tr>
               <tr>
                  <td width="70" height="33">
                     <div align="left">版本号</div>
                  </td>
                  <td colspan="3">
                     <div align="left">
                        <input id="number" name="number" class="easyui-validatebox textbox notnull" data-options="required:true" style="width:200px;height:18px;" value="<jh:write source='&unit.number'/>" />
                     </div>
                  </td>
               </tr>

               <tr>
                  <td height="30">
                     <div align="left">更新状态</div>
                  </td>
                  <td colspan="3">
                     <div align="left">
                        <input id="forceCdStr" class="easyui-combobox" style="width:200px;" name="forceCdStr" data-options="valueField:'value',textField:'text', 
       data:[{'value':'0','text':'未知'},{'value':'1','text':'可选'},{'value':'2','text':'强制'},{'value':'3','text':'自动'}]" value="<jh:write source='&unit.forceCd'/>" />
                     </div>
                  </td>
               </tr>

               <tr>
                  <td width="70" height="33">
                     <div align="left">开始时间</div>
                  </td>
                  <td width="230">
                     <div align="left">
                        <input id="beginDate" name="beginDate" style="width:200px;" class="easyui-datebox" value="<jh:write source='&unit.beginDate'/>"></input>
                     </div>
                  </td>
                  <td width="70" height="33">
                     <div align="left">结束时间</div>
                  </td>
                  <td width="208">
                     <div align="left">
                        <input id="endDate" name="endDate" style="width:200px;" class="easyui-datebox" value="<jh:write source='&unit.endDate'/>"></input>
                     </div>
                  </td>
               </tr>
               <tr>
                  <td width="70" height="33" colspan="1">
                     <div align="left">下载地址</div>
                  </td>
                  <td colspan="3">
                     <div align="left">
                        <input id="downloadUrl" name="downloadUrl" class="easyui-validatebox textbox notnull" style="width:500px;" data-options="required:true" value="<jh:write source='&unit.downloadUrl'/>" />
                     </div>
                  </td>
               </tr>
               <tr>
                  <td width="70" height="30" align="left">更新内容</td>
                  <td height="30" align="left" colspan="3">
                     <input id="note" name="note" class="easyui-textbox" data-options="multiline:true" value="<jh:write source='&unit.note'/>" style="height:100px;width:500px" />
                  </td>
               </tr>
            </table>
         </form>
      </div>
   </body>

   </HTML>