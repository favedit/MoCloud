<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
   </HEAD>
   <script>
      function submitForm() {
         if (!isValid()) return;
         $("#module").submit();
      }
   </script>

   <body bgcolor="#198bc9">
      <div id="cy_right" style="width:100%">
         <div class="right_title">
            <span>添加模块</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn">
               <a href="#" onClick="submitForm()" class="add_btn"></a>
               <a href="/manage/module/Module.wa" class="back_btn"></a>
            </div>
            <div class="nav_search"></div>
         </div>
      </div>
      <div class="easyui-panel" fit='true' data-options="border:false">
         <form id="module" action="/manage/module/Module.wa?do=insert" method="post" align="center">
            <table width="705" border="0" style="text-align:center; margin-left:10px; margin-top:10px; margin-bottom:10px">
               <tr>
                  <td width="33" align="left">编号</td>
                  <td width="494" align="left">
                     <input class="disabled" disabled style="width:80px;" value="" />
                     <input name="adminId" style="display:none;" value="<jh:write source='&basePage.userId' />" />
                  </td>
                  <td width="164" align="right">
                     <input type="checkbox" checked disabled />有效性
                  </td>
               </tr>
               <tr>
                  <td align="left">代码</td>
                  <td align="left" colspan="2">
                     <input id="code" name="code" class="easyui-validatebox textbox notnull" style="width:660px" data-options="required:true" validtype="length[1,40]" value="" />
                  </td>
               </tr>
               <tr>
                  <td align="left">标题</td>
                  <td align="left" colspan="2">
                     <input id="label" name="label" class="easyui-validatebox textbox notnull" data-options="required:true" validtype="length[1,40]" style="width:660px" value="" />
                  </td>
               </tr>
               <tr>
                  <td align="left">备注</td>
                  <td align="left" colspan="2">
                     <input id="note" name="note" class="easyui-textbox" data-options="multiline:true" style="height:100px;width:660px" />
                  </td>
               </tr>
            </table>
         </form>
      </div>
   </body>

   </HTML>