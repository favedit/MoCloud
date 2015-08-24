<%@ include file='/apl/public.inc' %>
   <jh:define source="&modulePage.module" alias="module"></jh:define>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
   </HEAD>
   <script>
      $(function() {
         var ovld = "<jh:write source='&module.ovld' />";
         if (ovld == 'true') {
            $("#ovld").attr("checked", true);
         }
      });

      function submitForm() {
         if (!isValid()) return;
         $("#module").submit();
      }
   </script>

   <body bgcolor="#198bc9">
      <div id="cy_right" style="width:100%">
         <div class="right_title">
            <span>修改模块</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn">
               <a href="#" onClick="submitForm()" class="sub_btn"></a>
               <a href="/manage/module/Module.wa" class="back_btn"></a>
            </div>
            <div class="nav_search"></div>
         </div>
      </div>
      <div class="easyui-panel" fit='true' data-options="border:false">
         <form id="module" action="/manage/module/Module.wa?do=update" method="post" align="center">
            <table width="714" border="0" style="text-align:center; margin-left:10px; margin-top:10px; margin-bottom:10px">
               <tr>
                  <td align="left">代码</td>
                  <td align="left" colspan="2">
                     <input name="ouid" style="display:none;" value="<jh:write source='&module.ouid' />" />
                     <input name="adminId" style="display:none;" value="<jh:write source='&basePage.userId' />" />
                     <input id="code" name="code" class="easyui-validatebox textbox notnull" style="width:400px" data-options="required:true" value="<jh:write source='&module.code' />" />
                     <font color="red"><jh:write source='&basePage.message' /></font>
                  </td>
               </tr>
               <tr>
                  <td align="left">模块名称</td>
                  <td align="left" colspan="2">
                     <input id="label" name="label" class="easyui-validatebox textbox notnull" style="width:400px" data-options="required:true" value="<jh:write source='&module.label' />" />
                  </td>
               </tr>
               <tr>
                  <td align="left">备注</td>
                  <td align="left" colspan="2">
                     <input id="note" name="note" class="easyui-textbox" data-options="multiline:true" style="height:100px;width:500px" value="<jh:write source='&module.note' />" />
                  </td>
               </tr>
            </table>
         </form>
      </div>
   </body>

   </HTML>