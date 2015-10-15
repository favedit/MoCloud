<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
      <script>
         //显示更新成功
         $(function() {
            doSubmit(null, null);
            var pager = $('#logicVersion').datagrid().datagrid('getPager');
            pager.pagination({
               pageSize: 20,
               showPageList: [20, 30, 40],
               onSelectPage: function(pageNumber, pageSize) {
                  doSubmit(pageNumber, pageSize);
               }
            });
         });

         function doSubmit(page, pageSize) {
            progress();
            var url = "/manage/product/examine/system/Version.wa?do=select&date=" + new Date().valueOf();
            var data = null;
            var label = $.trim($('#label').val()).replaceAll("'", "");
            if (label == "资讯标题") label = null;
            if (page != null) {
               url = "/manage/product/examine/system/Version.wa?do=select&page=" + page + "&date=" + new Date().valueOf();
               data = {
                  "label": label,
                  "page": page,
                  "pageSize": pageSize
               };
            }
            $.ajax({
               type: "POST",
               url: url,
               data: data,
               success: function(msg) {
                  closeProgress();
                  $('#logicVersion').datagrid('loadData', toJsonObject(msg));
               },
               fail: function() {
                  closeProgress();
                  alert("error");
               }
            });
         }

         function checkTask(flag) {
            var ids = [];
            var rows = $('#logicVersion').datagrid('getSelections');
            if (rows.length != 0) {
               for (var i = 0; i < rows.length; i++) {
                  var row = rows[i];
                  ids.push(row.ouid);
               }
               location.href = "/manage/product/examine/system/Version.wa?do=checking&versionIds=" + ids + "&flag=" + flag;
            }
         }

         function downloadmanage(url) {
            window.open(url);
         }
      </script>
   </HEAD>

   <body>
      <div id="cy_right" style="width: 100%">
         <div class="right_title">
            <span>版本发布审核列表</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn">
               <a href="javascript:checkTask('2');" class="ty_btn"></a>
               <a href="javascript:checkTask('3');" class="bty_btn"></a>
            </div>
            <div class="nav_search">
               <!--
         <input id="label" name="label" type="text"
           onfocus="if(this.value=='资讯标题'){this.value='';}this.style.color='#000000';"
           onblur="if(this.value=='') {this.value='资讯标题';this.style.color='#ccc';}"
           style="color: #ccc" value="资讯标题"> <a onClick="doSubmit(0)"
           href="#" class="sear_btn"></a>
-->
            </div>
         </div>
      </div>
      <table id="logicVersion" class="easyui-datagrid" fit='true' style="align: true" data-options="toolbar:'#cy_right',pagination:true,collapsible:true,checkOnSelect:false,multiSort:false,striped: true">
         <thead>
            <tr>
               <th data-options="field:'ck',checkbox:true">全选</th>
               <th data-options="field:'ouid',halign:'center',align:'right'" width="40px">编号</th>
               <th data-options="field:'applicationLabel',halign:'center',align:'left',sortable:true" width="80px">应用</th>
               <th data-options="field:'label',halign:'center',align:'left',sortable:true" width="100px">版本标题</th>
               <th data-options="field:'code',halign:'center',align:'left',sortable:true" width="120px">版本名称</th>
               <th data-options="field:'number',halign:'center',align:'left',sortable:true" width="60px">版本号</th>
               <th data-options="field:'forceCdStr',halign:'center',align:'left',sortable:true" width="80px">更新状态</th>
               <th data-options="field:'statusCdStr',halign:'center',align:'left',sortable:true" width="80px">版本状态</th>
               <th data-options="field:'downloadUrl',halign:'center',align:'left',sortable:true" width="100px">下载地址</th>
               <th data-options="field:'note',halign:'center',align:'left'" width="400px">更新内容</th>
               <th data-options="field:'operation',halign:'center',align:'center',formatter:downloadButton" width="100px">下载</th>
            </tr>
         </thead>
      </table>
   </body>

   </HTML>