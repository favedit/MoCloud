<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      <jsp:include page="/eai/common/jeui.jsp"></jsp:include>
      <script>
         $(function() {
            doSubmit(null);
            var pager = $('#access').datagrid().datagrid('getPager');
            pager.pagination({
               pageSize: 20,
               showPageList: false,
               onSelectPage: function(pageNumber) {
                  doSubmit(pageNumber);
               }
            });
         });

         function doSubmit(page) {
            progress();
            var url = null;
            var data = null;
            if (page != null) {
               url = "/logger/user/Access.wa?do=select&page=" + page + "&date=" + new Date().valueOf();
               data = {
                  "label": $('#label').val(),
                  "page": page
               };
            } else {
               url = "/logger/user/Access.wa?do=select&date=" + new Date().valueOf();
            }
            $.ajax({
               type: "POST",
               url: url,
               data: data,
               success: function(msg) {
                  closeProgress();
                  $('#access').datagrid('loadData', toJsonObject(msg));
               },
               fail: function() {
                  closeProgress();
                  alert("error");
               }
            });
         }
      </script>
   </HEAD>

   <body>
      <div id="cy_right" style="">
         <div class="right_title">
            <span>用户白名单记录表</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn">
               <button onclick="javascript:location.href='/device/Device.wa'" value="test" />设备信息
               <button onclick="javascript:location.href='/logger/user/Access.wa'" value="test" />用户日志
               <button onclick="javascript:location.href='/person/user/Access.wa'" value="test" />白名单
            </div>
            <div class="nav_search"></div>
         </div>
      </div>
      <table id="access" class="easyui-datagrid" fit='true' style="align:true" data-options="toolbar:'#cy_right',pagination:true,rownumbers:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false">
         <thead>
            <tr>
               <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>
               <th data-options="field:'label',halign:'center',align:'center'" width="40px">说明</th>
               <th data-options="field:'hostAddress',halign:'center',align:'center'" width="80px">ip地址</th>
               <th data-options="field:'passport',halign:'center',align:'right',sortable:true" width="60px">账号</th>
               <th data-options="field:'password',halign:'center',align:'center',sortable:true" width="140px">密码</th>
               <th data-options="field:'accessCd',halign:'center',align:'center',sortable:true" width="140px">权限状态</th>
               <th data-options="field:'typeCd',halign:'center',align:'left',sortable:true" width="400px">是否永久</th>
               <th data-options="field:'beginDate',halign:'center',align:'center',sortable:true" width="80px">开始时间</th>
               <th data-options="field:'endDate',halign:'center',align:'center',sortable:true" width="140px">结束时间</th>
               <th data-options="field:'updateDate',halign:'center',align:'center'" width="140px">更新时间</th>
            </tr>
         </thead>
      </table>
   </body>

   </HTML>