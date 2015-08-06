<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
      <script>
         $(function() {
            userSubmit(null);
            var pager = $('#user').datagrid().datagrid('getPager');
            pager.pagination({
               pageSize: 20,
               showPageList: false,
               onSelectPage: function(pageNumber) {
                  userSubmit(pageNumber);
               }
            });
         });

         function userSubmit(page) {
            progress();
            var url = null;
            var data = null;
            if (page != null) {
               url = "/manage/user/User.wa?do=select&page=" + page + "&date=" + new Date().valueOf();
               data = {
                  "passport": $('#passport').val(),
                  "page": page
               };
            } else {
               url = "/manage/user/User.wa?do=select&date=" + new Date().valueOf();
            }
            $.ajax({
               type: "POST",
               url: url,
               data: data,
               success: function(msg) {
                  closeProgress();
                  $('#user').datagrid('loadData', toJsonObject(msg));
               },
               fail: function() {
                  closeProgress();
                  alert("error");
               }
            });
         }

         function del(id) {
            return confirmx('确定将此用户删除?',
               function() {
                  location.href = "/manage/user/User.wa?do=del&id=" + id + "&date=" + new Date().valueOf();
               });
         }
      </script>
   </HEAD>

   <body bgcolor="#198bc9">
      <div id="cy_right" style="width:100%">
         <div class="right_title">
            <span>用户列表</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn">
               <a href="/manage/user/User.wa?do=insertBefore" class="add_btn"></a>
            </div>
            <div class="nav_search">
            </div>
         </div>
      </div>
      <table id="user" fit='true' class="easyui-datagrid" style="width:100%;height:100%;text-align:center;align:true " data-options="toolbar:'#cy_right',pagination:true,collapsible:true">
         <thead>
            <tr>
               <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>
               <th data-options="field:'guid',halign:'center',align:'right',hidden:'true'" width="60px">编号</th>
               <th data-options="field:'passport',halign:'center',align:'left',sortable:true" width="200px">帐号</th>
               <th data-options="field:'label',halign:'center',align:'left',sortable:true" width="200px">名称</th>
               <th data-options="field:'createDate',halign:'center',align:'left'" width="140px">创建时间</th>
               <th data-options="field:'updateDate',halign:'center',align:'left'" width="140px">修改时间</th>
               <th data-options="field:'operation',halign:'center',align:'center',formatter:insert_admin_editButton" width="80px">操作</th>
            </tr>
         </thead>
      </table>
   </body>

   </HTML>