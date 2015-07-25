<%@ include file='/apl/public.inc' %>
   <HTML>
   <HEAD>
      <jsp:include page="/eai/common/jeui.jsp"></jsp:include>
      <script>
         $(function() {
            doSubmit(null);
            var pager = $('#browserAccess').datagrid().datagrid('getPager');
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
               url = "/device/Device.wa?do=select&page=" + page + "&date=" + new Date().valueOf();
               data = {
                  "label": $('#label').val(),
                  "page": page
               };
            } else {
               url = "/device/Device.wa?do=select&date=" + new Date().valueOf();
            }
            $.ajax({
               type: "POST",
               url: url,
               data: data,
               success: function(msg) {
                  closeProgress();
                  $('#browserAccess').datagrid('loadData', toJsonObject(msg));
               },
               fail: function() {
                  closeProgress();
                  alert("error");
               }
            });
         }

         function infoButton(value, row, index) {
            var edit = '<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-plain"  plain="true"><span class="l-btn-left" sizset="false" onClick="rowInfo(\'' + row.ouid + '\')"><span class="l-btn-text icon-tip l-btn-icon-left">详情</span></span></a>';
            return edit;
         }
         function rowInfo(id){
            location.href = "/device/Device.wa?do=updateBefore&ouid="+id+"&date="+new Date().valueOf();
         }
      </script>
   </HEAD>

   <body>
      <div id="cy_right" style="">
         <div class="right_title">
            <span>设备信息</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn">
               <button onclick="javascript:location.href='/device/Device.wa'" value="test"/>设备信息
               <button onclick="javascript:location.href='/logger/user/Access.wa'" value="test"/>用户日志
               <button onclick="javascript:location.href='/person/user/Access.wa'" value="test"/>白名单
            </div>
            <div class="nav_search"></div>
         </div>
      </div>
      <table id="browserAccess" class="easyui-datagrid" fit='true' style="align:true" data-options="toolbar:'#cy_right',pagination:true,rownumbers:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false">
         <thead>
            <tr>
               <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>
               <th data-options="field:'deviceId',halign:'center',align:'right'" width="60px">设备编号</th>
               <th data-options="field:'agentCode',halign:'center',align:'left',sortable:true" width="200px">头信息</th>
               <th data-options="field:'identityCode',halign:'center',align:'left'" width="200px">唯一标示</th>
               <th data-options="field:'label',halign:'center',align:'left'" width="80px">说明</th>
               <th data-options="field:'content',halign:'center',align:'left',sortable:true" width="400px">内容</th>
               <th data-options="field:'createUserId',halign:'center',align:'right',sortable:true" width="60px">创建用户</th>
               <th data-options="field:'createDate',halign:'center',align:'left',sortable:true" width="140px">创建时间</th>
               <th data-options="field:'updateUserId',halign:'center',align:'right',sortable:true" width="60">更新用户</th>
               <th data-options="field:'updateDate',halign:'center',align:'left',sortable:true" width="140px">更新时间</th>
               <th data-options="field:'operation',halign:'center',align:'center',formatter:infoButton" width="140px">操作</th>
            </tr>
         </thead>
      </table>
   </body>

   </HTML>