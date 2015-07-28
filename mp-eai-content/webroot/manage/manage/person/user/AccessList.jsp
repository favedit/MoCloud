<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
      <script>
         $(function() {
            doSubmit(null);
            var pager = $('#userAccess').datagrid().datagrid('getPager');
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
               url = "/manage/person/user/Access.wa?do=select&page=" + page + "&date=" + new Date().valueOf();
               data = {
                  "label": $('#label').val(),
                  "page": page
               };
            } else {
               url = "/manage/person/user/Access.wa?do=select&date=" + new Date().valueOf();
            }
            $.ajax({
               type: "POST",
               url: url,
               data: data,
               success: function(msg) {
                  closeProgress();
                  $('#userAccess').datagrid('loadData', toJsonObject(msg));
               },
               fail: function() {
                  closeProgress();
                  alert("error");
               }
            });
         }

         function del(id) {
            location.href = "/manage/person/user/Access.wa?do=delete&id=" + id + "&date=" + new Date().valueOf();
         }
         function edit(id) {
            location.href = "/manage/person/user/Access.wa?do=updateBefore&id=" + id + "&date=" + new Date().valueOf();
         }
      </script>
   </HEAD>

   <body>
      <div id="cy_right">
         <div class="right_title">
            <span>白名单</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn"><a href="/manage/manage/person/user/InsertUser.wp" class="add_btn"></a></div>
            <div class="nav_search"></div>
         </div>
      </div>
      <table id="userAccess" class="easyui-datagrid" fit='true' style="align:true" data-options="toolbar:'#cy_right',pagination:true,rownumbers:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false">
         <thead>
            <tr>
               <th data-options="field:'ouid',halign:'center',align:'left'" width="60px">编号</th>
               <th data-options="field:'hostAddress',halign:'center',align:'left'" width="100px">IP地址</th>
               <th data-options="field:'label',halign:'center',align:'left'" width="150px">说明</th>
               <th data-options="field:'passport',halign:'center',align:'left'" width="100px">帐号</th>
               <th data-options="field:'accessCd',halign:'center',align:'left',sortable:true" width="80px">权限</th>
               <th data-options="field:'typeCd',halign:'center',align:'left',sortable:true" width="80px">是否永久</th>
               <th data-options="field:'beginDate',halign:'center',align:'left',sortable:true" width="140px">开始时间</th>
               <th data-options="field:'endDate',halign:'center',align:'left',sortable:true" width="140px">结束时间</th>
               <th data-options="field:'operation',halign:'center',align:'center',formatter:insert_editAndDelButton" width="140px">操作</th>
            </tr>
         </thead>
      </table>
   </body>

   </HTML>