<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
   </HEAD>
   <script>
      $(function() {
         moduleSubmit(null);
      });

      function moduleSubmit(page) {
         progress();
         var url = "/manage/module/Module.wa?do=selectAll&date=" + new Date().valueOf();
         var data = null;
         $.ajax({
            type: "POST",
            url: url,
            data: data,
            success: function(msg) {
               closeProgress();
               $('#module').datagrid('loadData', toJsonObject(msg));
            },
            fail: function() {
               closeProgress();
               alert("error");
            }
         });
      }

      function submitForm() {
         if (!isValid()) return;
         var rows = $('#module').datagrid('getSelections');
         var resourceResult = [];
         if (rows.length != 0) {
            for (var i = 0; i < rows.length; i++) {
               var row = rows[i];
               resourceResult.push(row.ouid);
            }
            $("#moduleIds").val(resourceResult);
         }
         $("#role").submit();
      }
      function isChecked(value, row, index) {
         if (row.viewValidCd == '1') {
            return '<input type="checkbox" name="DataGridCheckbox" checked="checked" onclick="clickCheck(this,' + index + ')">';
         } else {
            return '<input type="checkbox" name="DataGridCheckbox" onclick="clickCheck(this,' + index + ')">';
         }
      }
      function clickCheck(o, i) {
         var rows = $('#module').datagrid('getRows');
         var row = rows[i];
         row.viewValidCd = o.checked ? 1 : 0;
      }
   </script>

   <body bgcolor="#198bc9">
      <div class="easyui-panel" fit='true' data-options="border:false">

         <div id="cy_right" style="width:100%">
            <div class="right_title">
               <span>添加角色</span>
            </div>
            <div class="btn_bar">
               <div class="nav_btn">
                  <a href="#" onClick="submitForm()" class="add_btn"></a>
                  <a href="/manage/role/Role.wa" class="back_btn"></a>
               </div>
               <div class="nav_search"></div>
            </div>
         </div>
         <form id="role" action="/manage/role/Role.wa?do=insert" method="post" align="center">
            <table width="750" border="0" style="text-align:center; margin-left:10px; margin-top:10px; margin-bottom:10px">

<!--
               <tr>
                  <td width="60" align="left">编号</td>
                  <td width="492" align="left">
                     <input class="disabled" disabled style="width:80px;" value="" />
                     <input name="adminId" style="display:none;" value="<jh:write source='&basePage.userId' />" />
                     <input id="moduleIds" name="moduleIds" style="display:none;" />
                  </td>
                  <td width="163" align="right">
                     <input type="checkbox" checked disabled/>有效性
                  </td>
               </tr>
-->
               <tr>
                  <td width="47" align="left">英文名称</td>
                  <td width="400" align="left" colspan="2">
                     <input id="code" name="code"  class="easyui-validatebox textbox notnull" data-options="required:true,validType:'length[1,50]'" style="width:400px" />
                     <input name="adminId" style="display:none;" value="<jh:write source='&basePage.userId' />" />
                     <input id="moduleIds" name="moduleIds" style="display:none;" />
                  </td>
               </tr>
               <tr>
                  <td align="left">中文名称</td>
                  <td align="left" colspan="2">
                     <input id="label" name="label" class="easyui-validatebox textbox notnull" data-options="required:true,validType:'length[1,50]'" style="width:400px" value="" />
                  </td>
               </tr>
               <tr>
                  <td align="left">备注</td>
                  <td align="left" colspan="2">
                     <input id="note" name="note" class="easyui-validatebox textbox" style="width:400px" />
                  </td>
               </tr>
               <tr>
                  <td align="left">模块</td>
                  <td colspan="2" align="left">
                     <table id="module" class="easyui-datagrid" style="width:500px;align:true " data-options="collapsible:true,remoteSort:false,multiSort:false">
                        <thead>
                           <tr>
                              <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>
                              <th data-options="field:'code',halign:'center',align:'left',sortable:true" width="200px">代码</th>
                              <th data-options="field:'label',halign:'center',align:'left',sortable:true" width="150px">中文名称</th>
                              <th data-options="field:'viewValidCd',align:'center',checkbox:true,formatter:isChecked" width="60px">查看权限</th>
<!--                              <th data-options="field:'view_valid',halign:'center',align:'center',checkbox:true,title:'查看权限'" width="60px">查看权限</th>-->
                           </tr>
                        </thead>
                     </table>
                  </td>
               </tr>
            </table>


      </div>
      </form>
      </div>
   </body>

   </HTML>