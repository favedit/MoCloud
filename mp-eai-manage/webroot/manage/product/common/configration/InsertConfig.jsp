<%@ include file='/apl/public.inc' %>
   <HTML>
   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
   </HEAD>
   <script>
      function submitForm() {
         progress(); 
         $("#config").submit();
         closeProgress();
      }
   </script>

   <body bgcolor="#198bc9">
      <div id="cy_right" style="width:100%">
         <div class="right_title" style="width:100%">
            <span>增加配置信息</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn">
               <a href="#" onClick="submitForm()" class="add_btn"></a>
               <a href="/manage/product/common/configration/Configration.wa" class="back_btn"></a>
            </div>
            <div class="nav_search"></div>
         </div>
      </div>
      <div class="easyui-panel" fit='true' data-options="border:false">
         
         <form id="config" action="/manage/product/common/configration/Configration.wa?do=insert" method="post" align="center">
            <font style="color:red;"><jh:write source='&page.result'/></font>
         <table width="718" border="0" style="text-align:center; margin-left:10px; margin-top:10px; margin-bottom:10px">
            <tr>
               <td align="left" width="48">英文名称:</td>
               <td align="left" width="660">
                  <input id="code" name="code" class="easyui-validatebox textbox" style="width:400px" data-options="validType:'length[0,100]'"/>
                  <input id="adminId" name="adminId" style="display:none" value="<jh:write source='&basePage.userId'/>" />
               </td>
            </tr>
            <tr>
               <td align="left">中文名称:</td>
               <td align="left">
                  <input id="label" name="label" class="easyui-validatebox textbox" style="width:400px" data-options="validType:'length[0,100]'" />
               </td>
            </tr>
            <tr>
               <td align="left">数据类型:</td>
               <td align="left">
                  <input id="dataType" name="dataType" class="easyui-validatebox textbox" style="width:400px" data-options="validType:'length[0,20]'" /> </td>
            </tr>
            <tr>
               <td align="left">数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;据:</td>
               <td align="left">
                  <input id="dataValue" name="dataValue" class="easyui-validatebox textbox" style="width:400px" data-options="validType:'length[0,200]'" />
               </td>
            </tr>
            <tr>
               <td width="66" height="30" align="left">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
               <td height="30" colspan="7" align="left">
                  <input id="note" name="note" class="easyui-textbox" data-options="multiline:true" style="height:100px;width:500px" />
               </td>
            </tr>
         </table>
         </form>
      </div>
   </body>

   </HTML>