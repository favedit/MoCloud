<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
   </HEAD>

   <body style="margin-left:20px;margin-top:20px">
      <div id="cy_right" style="">
         <div class="right_title">
            <span>白名单</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn"></div>
            <div class="nav_search"></div>
         </div>
      </div>
      <table id="userAccess" class="easyui-datagrid" fit='true' style="align:true" data-options="toolbar:'#cy_right',pagination:true,rownumbers:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false">
         <thead>
            <tr>
               <th data-options="field:'ouid',halign:'center',align:'left'" width="60px">编号</th>
               <th data-options="field:'hostAddress',halign:'center',align:'left'" width="60px">IP地址</th>
               <th data-options="field:'label',halign:'center',align:'left'" width="100px">说明</th>
               <th data-options="field:'passport',halign:'center',align:'left'" width="100px">帐号</th>
               <th data-options="field:'accessCd',halign:'center',align:'left',sortable:true" width="300px">权限</th>
               <th data-options="field:'typeCd',halign:'center',align:'left',sortable:true" width="100px">是否永久</th>
               <th data-options="field:'beginDate',halign:'center',align:'left',sortable:true" width="100px">开始时间</th>
               <th data-options="field:'endDate',halign:'center',align:'left',sortable:true" width="300px">结束时间</th>
               <th data-options="field:'operation',halign:'center',align:'center',formatter:infoButton" width="140px">操作</th>
            </tr>
         </thead>
      </table>
   </body>

   </HTML>