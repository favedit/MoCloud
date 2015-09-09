<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
      <script>
         $(function() {
            doSubmit(null);
            var pager = $('#config').datagrid().datagrid('getPager');
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
            var url = "/product/configration/Configration.wa?do=select&date=" + new Date().valueOf();
            var data = null;
            if (page != null) {
               url = "/product/configration/Configration.wa?do=select&page=" + page + "&date=" + new Date().valueOf();
               data = {
                  "label": $('#label').val(),
                  "page": page
               };
            }
            $.ajax({
               type: "POST",
               url: url,
               data: "",
               success: function(msg) {
                  closeProgress();
                  $('#config').datagrid('loadData', toJsonObject(msg));
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
      </script>
   </HEAD>

   <body>
      <div id="cy_right" style="width:100%">
         <div class="right_title">
            <span>设备信息</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn"><a href="/product/configration/Configration.wa?do=insertBefore" class="add_btn"></a></div>
            <div class="nav_search"></div>
         </div>
      </div>
      <table id="config" class="easyui-datagrid" fit='true' style="align:true" data-options="toolbar:'#cy_right',collapsible:true,singleSelect:true,remoteSort:false,multiSort:false">
         <thead>
            <tr>
               <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>               
               <th data-options="field:'code',halign:'center',align:'left',sortable:true" width="200px">代码</th>
               <th data-options="field:'label',halign:'center',align:'left',sortable:true" width="100px">名称</th>
               <th data-options="field:'dataTypeCd',halign:'center',align:'right',sortable:true" width="100px">数据类型</th>
               <th data-options="field:'dataValue',halign:'center',align:'right',sortable:true" width="100px">值</th>
               <th data-options="field:'note',halign:'center',align:'left',sortable:true" width="200px">备注</th>
               <th data-options="field:'updateDate',halign:'center',align:'left'" width="140px">更新时间</th>
               <th data-options="field:'operation',halign:'center',align:'center',formatter:insert_editAndDelButton" width="140px">操作</th>
            </tr>
         </thead>
      </table>
   </body>

   </HTML>