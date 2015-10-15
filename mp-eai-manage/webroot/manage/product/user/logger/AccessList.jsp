<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
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
               url = "/manage/product/user/logger/Access.wa?do=select&page=" + page + "&date=" + new Date().valueOf();
               data = {
                  "label": $('#label').val(),
                  "page": page
               };
            } else {
               url = "/manage/product/user/logger/Access.wa?do=select&date=" + new Date().valueOf();
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
         function submitForm(){
           if (!isValid()) return;
           $("#logerdat").submit();
         }
      </script>
   </HEAD>

   <body>
      <div id="cy_right">
         <div class="right_title">
            <span>用户日志</span>
         </div>
         <div class="btn_bar">
         <form id="logerdat" action="/manage/product/user/logger/Access.wa?do=selectByDate" method="post" align="center">
            <table border="0" align="left" cellpadding="0" cellspacing="0" style=" margin-left:10px">
               <tr>
                  <td width="60" height="33">
                     <div align="left">开始时间</div>
                  </td>
                  <td width="158">
                     <div align="left">
                        <input id="beginDate" style="width:150px" name="beginDate" class="easyui-datebox notnull" data-options="required:true"/>
                     </div>
                  </td>
                  <td width="60" height="33">
                     <div align="left">结束时间</div>
                  </td>
                  <td width="158">
                     <div align="left">
                        <input id="endDate" style="width:150px" name="endDate" class="easyui-datebox notnull" data-options="required:true"/>
                     </div>
                  </td>
                  <td width="30" height="33"><a href="javascript:void(0);" class="sub_btn" onclick="submitForm()"></a></td>
               </tr>
            </table>
            </form>
            <div class="nav_search"></div>
         </div>
      </div>
      <table id="access" class="easyui-datagrid" fit='true' style="align:true" data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false">
         <thead>
            <tr>
               <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>
               <th data-options="field:'hostAddress',halign:'center',align:'left',sortable:true" width="150px">ip地址</th>
               <th data-options="field:'passport',halign:'center',align:'left',sortable:true" width="200px">账号</th>
               <th data-options="field:'logicMessage',halign:'center',align:'left',sortable:true" width="250px">操作信息</th>   
               <th data-options="field:'browserUri',halign:'center',align:'left',sortable:true" width="300px">请求地址</th>
               <th data-options="field:'pageInfo',halign:'center',align:'left',sortable:true" width="450px">页面信息</th> 
               <th data-options="field:'updateDate',halign:'center',align:'left'" width="160px">更新时间</th>
            </tr>
         </thead>
      </table>
   </body>

   </HTML>