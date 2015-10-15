<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
   </HEAD>
   <script>
      function submitForm() {
         if (!isValid()) return;
         var version = $("#version");
         $("#applicationId").val($('#application').combobox("getValue"));
         version.submit();
      }
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
               $('#application').combobox('select', result[0].ouid);
            },
            fail: function() {
               alert("error");
            }
         });
      })
   </script>

   <body bgcolor="#198bc9">
      <div id="cy_right" style="width:100%">
         <div class="right_title" style="width:100%">
            <span>增加版本信息</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn">
               <a href="#" onClick="submitForm()" class="add_btn"></a>
               <a href="/product/system/version/Version.wa" class="back_btn"></a>
            </div>
            <div class="nav_search"></div>
         </div>
      </div>
      <div class="easyui-panel" fit='true' data-options="border:false">
         <form id="version" action="/product/system/version/Version.wa?do=insert" method="post" align="center">
            <font style="color:red;"><jh:write source='&page.result' /></font>
            <table border="0" align="left" cellpadding="0" cellspacing="0" style=" margin-left:10px">
               <tr>
                  <td width="69" height="33" colspan="1">
                     <div align="left">应用</div>
                  </td>
                  <td width="214" colspan="3">
                     <input class="easyui-combobox" style="width:200px;" id="application" name="application" data-options="valueField:'ouid',textField:'label',editable:false" />
                     <input name="applicationId" id="applicationId" type="hidden">
                  </td>
               </tr>
               <tr>
                  <td width="69" height="33" colspan="1">
                     <div align="left">版本名称</div>
                  </td>
                  <td colspan="3">
                     <div align="left">
                        <input id="code" name="code" class="easyui-validatebox textbox notnull" style="width:200px;height:18px;" data-options="required:true,validType:'length[0,40]'" />
                        <span style="color:red;">&nbsp;&nbsp;建议版本名称少于15个字符</span>
                     </div>
                  </td>
               </tr>
               <tr>
                  <td width="69" height="33" colspan="1">
                     <div align="left">版本标题</div>
                  </td>
                  <td colspan="3">
                     <div align="left">
                        <input id="label" name="label" class="easyui-validatebox textbox notnull" style="width:200px;height:20px;" data-options="required:true,validType:'length[0,80]'" />
                        <input id="adminId" name="adminId" style="display:none" value="<jh:write source='&basePage.userId'/>" />
                     </div>
                  </td>
               </tr>
               <tr>
                  <td width="69" height="33" colspan="1">
                     <div align="left">版本号</div>
                  </td>
                  <td colspan="3">
                     <div align="left">
                        <input id="number" name="number" class="easyui-validatebox textbox notnull" style="width:200px;height:18px;" data-options="required:true" />
                     </div>
                  </td>
               </tr>

               <tr>
                  <td height="30">
                     <div align="left">更新状态</div>
                  </td>
                  <td colspan="3">
                     <div align="left">
                        <select id="forceCdStr" class="easyui-combobox" name="forceCdStr" style="width:200px;">
                           <option value="1">可选</option>
                           <option value="2">强制</option>
                           <option value="3">自动</option>
                           <select>
                     </div>
                  </td>
               </tr>

               <tr>
                  <td width="30" height="33">
                     <div align="left">开始时间</div>
                  </td>
                  <td width="98">
                     <div align="left">
                        <input id="beginDate" style="width:200px" name="beginDate" class="easyui-datebox" />
                     </div>
                  </td>
                  <td width="30" height="33">
                     <div align="left">结束时间</div>
                  </td>
                  <td width="98">
                     <div align="left">
                        <input id="endDate" style="width:200px" name="endDate" class="easyui-datebox" />
                     </div>
                  </td>
               </tr>
               <tr>
                  <td width="69" height="33" colspan="1">
                     <div align="left">下载地址</div>
                  </td>
                  <td colspan="3">
                     <div align="left">
                        <input id="downloadUrl" name="downloadUrl" class="easyui-validatebox textbox notnull" style="width:500px;height:18px;" data-options="required:true" />
                     </div>
                  </td>
               </tr>
               <tr>
                  <td width="30" height="30" align="left" colspan="1">更新内容</td>
                  <td height="30" align="left" colspan="3">
                     <input id="note" name="note" class="easyui-textbox" data-options="multiline:true" style="height:100px;width:500px" />
                  </td>
               </tr>
            </table>
         </form>
      </div>
   </body>

   </HTML>