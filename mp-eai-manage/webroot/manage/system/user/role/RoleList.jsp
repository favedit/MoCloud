<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
      <script>
         $(function() {
            roleSubmit(null);
            var pager = $('#role').datagrid().datagrid('getPager');
            pager.pagination({
               pageSize: 20,
               showPageList: false,
               onSelectPage: function(pageNumber) {
                  roleSubmit(pageNumber);
               }
            });
         });

         function roleSubmit(page) {
            progress();
            var url = null;
            var data = null;
            var code = $.trim($('#code').val()).replaceAll("'", "");
            if (code == "代码") code = null;
            if (page != null) {
               url = "/manage/system/user/role/Role.wa?do=selectDataByPage&page=" + page + "&date=" + new Date().valueOf();
               data = {
                  "code": code,
                  "page": page
               };
            } else {
               url = "/manage/system/user/role/Role.wa?do=selectDataByPage&date=" + new Date().valueOf();
            }
            $.ajax({
               type: "POST",
               url: url,
               data: data,
               success: function(msg) {
                  closeProgress();
                  $('#role').datagrid('loadData', toJsonObject(msg));
               },
               fail: function() {
                  closeProgress();
                  alert("error");
               }
            });
         }

         function del(id) {
            return confirmx('确定将此角色删除?',
               function() {
                  var url = "/manage/system/user/role/Role.wa?do=delete&date=" + new Date().valueOf();
                  var data = {
                     "roleId": id
                  };
                  $.getJSON(url, data, function(d) {
                     if (d == "1") {
                        location.href = "/manage/system/user/role/Role.wa";
                     } else {
                        alertx("删除失败！", "warning", function() {
                           location.href = "/manage/system/user/role/Role.wa";
                        });
                     }
                  });

               });
         }

         function edit(id) {
            location.href = "/manage/system/user/role/Role.wa?do=updatePrepare&id=" + id + "&date=" + new Date().valueOf();
         }

         function insert_role_editButton(value, row, index) {
            var edit = '<a href="javascript:void(0)" class="easyui-linkbutton  l-btn l-btn-plain"  plain="true"><span class="l-btn-left" sizset="false" onClick="edit(\'' + row.ouid + '\')"><span class="l-btn-text icon-edit l-btn-icon-left">编辑</span></span></a>';
            if (row.ouid != '1') {
               var del = '<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-plain" sizset="true" onClick="del(\'' + row.ouid + '\')" ><span class="l-btn-left" 			sizset="false"><span class="l-btn-text icon-cancel l-btn-icon-left">删除</span></span></a>';
               return "&nbsp;&nbsp;&nbsp;" + edit + "&nbsp;|&nbsp;" + del;
            } else {
               return "&nbsp;&nbsp;&nbsp;" + edit;
            }
         }
      </script>
   </HEAD>

   <body bgcolor="#198bc9">
      <div id="cy_right" style="width:100%">
         <div class="right_title">
            <span>角色列表</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn">
               <a href="/manage/system/user/role/Role.wa?do=insertPrepare" class="add_btn"></a>
            </div>
            <div class="nav_search">
               <input id="code" name="" type="text" onfocus="if(this.value=='代码'){this.value='';}this.style.color='#000000';" onblur="if(this.value=='') {this.value='代码';this.style.color='#ccc';}" style="color:#ccc" value="代码">
               <a onClick="roleSubmit(0)" href="#" class="sear_btn"></a>
            </div>
         </div>
      </div>
      <table id="role" fit='true' class="easyui-datagrid" style="width:100%;height:100%;text-align:center;align:true " data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,multiSort:false">
         <thead>
            <tr>
               <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>
               <th data-options="field:'code',halign:'center',align:'left'" width="150px">代码</th>
               <th data-options="field:'label',halign:'center',align:'left'" width="150px">角色名称</th>
               <th data-options="field:'roleModules',halign:'center',align:'left'" width="300px">拥有模块</th>
               <th data-options="field:'note',halign:'center',align:'left'" width="200px">备注</th>
               <th data-options="field:'createDate',halign:'center'" width="140px">创建时间</th>
               <th data-options="field:'make',align:'left',halign:'center',formatter:insert_role_editButton" width="150px">操作</th>
            </tr>
         </thead>
      </table>
   </body>

   </HTML>