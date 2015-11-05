<%@ include file='/apl/public.inc' %>
   <jh:define source="&page.unit" alias="unit"></jh:define>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
   </HEAD>
   <script>
      $(function() {
         var url = "/manage/product/system/application/Application.wa?do=selectAll&date=" + new Date().valueOf();
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
         progress();
         if (!isValid()){
            closeProgress();
            return;
         }
         var number=$("#number").val();
         if(number>100){
            alert("版本号小于100!");
            closeProgress();
            return false;
         }
         var forceCd = $("#forceCd").combobox("getValue");
         var applicationId = $('#application').combobox("getValue");
         var url = "/manage/product/system/version/Version.wa?do=update&date=" + new Date().valueOf();
         var data = {
            "label": $('#label').val(),
            "adminId": $('#adminId').val(),
            "forceCd": forceCd,
            "applicationId": applicationId,
            "beginDate": $('#beginDate').val(),
            "downloadUrl": $('#downloadUrl').val(),
            "endDate": $('#endDate').val(),
            "code": $('#code').val(),
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
               if(msg.indexOf("overwrite")>-1){
                  $('#overid').text("版本号重复!");
               }
               if(msg.indexOf("nonumber")>-1){
                   $('#overid').text("版本号只支持数字和英文小数点!");
                }
               if(msg.indexOf("success")>-1){
                   location.href = "/manage/product/system/version/Version.wa";
                }
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
               <a href="/manage/product/system/version/Version.wa" class="back_btn"></a>
            </div>
            <div class="nav_search"></div>
         </div>
      </div>
      <div class="easyui-panel" fit='true' data-options="border:false">

         <form id="config" action="/manage/product/system/version/Version.wa?do=update" method="post" align="center">
            <font style="color:red;"><jh:write source='&page.result' /></font>
            <font style="color:red;"><div id="overid"></div></font>
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
                        <input id="label" name="label" class="easyui-validatebox textbox notnull" style="width:200px;height:20px;" data-options="required:true,validType:'length[0,80]'" value="<jh:write source='&unit.label'/>" />
                        <span style="color:red;">&nbsp;&nbsp;建议版本标题少于15个字符</span>
                        <input id="adminId" name="adminId" style="display:none" value="<jh:write source='&basePage.userId'/>" />
                        <input id="ouid" name="ouid" style="display:none" value="<jh:write source='&unit.ouid'/>" />
                     </div>
                  </td>
               </tr>
               <tr>
                  <td width="70" height="33">
                     <div align="left">版本号</div>
                  </td>
                  <td colspan="3">
                     <div align="left">
                        <input id="number" name="number" class="easyui-validatebox textbox notnull" data-options="required:true,validType:'length[0,5]'" style="width:200px;height:18px;" value="<jh:write source='&unit.number'/>" />
                     </div>
                  </td>
               </tr>
               <tr>
                  <td width="70" height="33" colspan="1">
                     <div align="left">版本号名</div>
                  </td>
                  <td colspan="3">
                     <div align="left">
                        <input id="code" name="code" class="easyui-validatebox textbox notnull" style="width:200px;height:18px;" data-options="required:true,validType:'length[0,40]'" value="<jh:write source='&unit.code'/>"/>
                        <span style="color:red;">&nbsp;&nbsp;建议版本号名少于40个字符</span>
                     </div>
                  </td>
               </tr>
               <tr>
                  <td height="30">
                     <div align="left">更新类型</div>
                  </td>
                  <td colspan="3">
                     <div align="left">
                        <input id="forceCd" class="easyui-combobox" style="width:200px;" name="forceCd" data-options="valueField:'value',textField:'text', 
       data:[{'value':'1','text':'可选'},{'value':'2','text':'强制'},{'value':'3','text':'自动'}],editable:false" value="<jh:write source='&unit.forceCd'/>" />
                     </div>
                  </td>
               </tr>

               <tr>
                  <td width="70" height="33">
                     <div align="left">开始时间</div>
                  </td>
                  <td width="230">
                     <div align="left">
                        <input id="beginDate" name="beginDate" style="width:200px;" class="easyui-datebox" value="<jh:write source='&unit.beginDate'/>" data-options="editable:false"></input>
                     </div>
                  </td>
                  <td width="70" height="33">
                     <div align="left">结束时间</div>
                  </td>
                  <td width="208">
                     <div align="left">
                        <input id="endDate" name="endDate" style="width:200px;" class="easyui-datebox" value="<jh:write source='&unit.endDate'/>" data-options="editable:false"></input>
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
                     <textarea id="note" name="note" class="border_change" style="width:500px;height:100px"><jh:write source='&unit.note' format='text'/></textarea>
                  </td>
               </tr>
            </table>
         </form>
      </div>
   </body>

   </HTML>