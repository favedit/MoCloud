<%@ include file='/apl/public.inc' %>
   <jh:define source="&basePage.user" alias="base"></jh:define>
   <HTML>

   <HEAD>
      <js:css/>
      <js:js type='runtime.client' />
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

            if ($('#passport').val() == "admin") {
               //$("#regenerateIcon").show();
            }
         });

         function doSubmit(page) {
            progress();
            var url = null;
            var data = null;
            if (page != null) {
               url = "/cloud/product/activity/Activity.wa?do=selectByPage&page=" + page + "&date=" + new Date().valueOf();
               data = {
                  "label": $('#label').val(),
                  "page": page
               };
            } else {
               url = "/cloud/product/activity/Activity.wa?do=selectByPage&date=" + new Date().valueOf();
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

   <body bgcolor="#198bc9">
      <div id="cy_right" style="width:100%">
         <div class="right_title">
            <span>用户白名单记录表</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn"></div>
            <div class="nav_search"></div>
         </div>
      </div>
      <table id="access" class="easyui-datagrid" fit='true' style="width:100%;height:100%;align:true" data-options="toolbar:'#cy_right',pagination:true,rownumbers:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false">
         <thead>
            <tr>
               <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>
               <th data-options="field:'label',halign:'center',align:'center',formatter:changeCheckbox" width="40px">说明</th>
               <th data-options="field:'hostAddress',halign:'center',align:'center',formatter:insert_descriptionInfoButton" width="80px">ip地址</th>
               <th data-options="field:'passport',halign:'center',align:'right',sortable:true" width="60px">账号</th>
               <th data-options="field:'password',halign:'center',align:'center',sortable:true" width="140px">密码</th>
               <th data-options="field:'accessCd',halign:'center',align:'center',sortable:true" width="140px">权限状态</th>
               <th data-options="field:'typeCd',halign:'center',align:'left',sortable:true" width="400px">是否永久</th>
               <th data-options="field:'beginDate',halign:'center',align:'center',sortable:true" width="80px">开始时间</th>
               <th data-options="field:'endDate',halign:'center',align:'center',sortable:true" width="140px">结束时间</th>
               <th data-options="field:'updateDate',halign:'center',align:'center',formatter:insert_editAndDelButton" width="140px">更新时间</th>
            </tr>
         </thead>
      </table>
   </body>

   </HTML>