<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
      <script>
         $(function() {
            doSubmit(null,null);
            var pager = $('#access').datagrid().datagrid('getPager');
            pager.pagination({
               pageSize: 20,
               showPageList: [ 20, 30, 40 ],
               onSelectPage: function(pageNumber,pageSize) {
                   var tip = $("#flag").val();
                   if(tip=="2"){
                      doSubmitByCondition(pageNumber,pageSize);
                   }else{
	                  doSubmit(pageNumber,pageSize);
                   }
               }
            });
         });

         function doSubmit(page,pageSize) {
            $("#flag").val("");
            progress();
            var url = null;
            var data = null;
            if (page != null) {
               url = "/manage/product/user/logger/Access.wa?do=select&page=" + page + "&date=" + new Date().valueOf();
               data = {
                  "page": page,
                  "pageSize" : pageSize
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
         function doSubmitByCondition(page,pageSize) {
             progress();
             var beginDate = $('#beginDate').datebox('getValue');
             var endDate = $('#endDate').datebox('getValue'); 
             var lm = $("#logicMessage").val();
             var url = null;
             var data = null;
             if (page != null) {
	             data = {
	                "page": page,
	                "pageSize" : pageSize,
	                "beginDate" :beginDate,
	                "endDate" :endDate,
	                "logicMessage" :lm
	             };
                url = "/manage/product/user/logger/Access.wa?do=selectByDate&page=" + page + "&date=" + new Date().valueOf();
             } else {
                data = {
                     "beginDate" :beginDate,
                     "endDate" :endDate,
                     "logicMessage" :lm
                 };
                url = "/manage/product/user/logger/Access.wa?do=selectByDate&date=" + new Date().valueOf();
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
           doSubmitByCondition(null,null);
           $("#flag").val("2");
         }
      </script>
   </HEAD>

   <body>
      <div id="cy_right">
         <div class="right_title">
            <span>用户日志</span>
         </div>
         <div class="btn_bar">
         <div class="nav_btn" style="width:700px;">
         <form id="logerdat" action="/manage/product/user/logger/Access.wa" method="post" align="center">
            <table border="0" align="left" cellpadding="0" cellspacing="0" style=" margin-left:10px">
               <tr>
                  <td width="100" height="33">
                     <div align="left">开始时间</div>
                  </td>
                  <td width="158">
                     <div align="left">
                        <input id="beginDate" style="width:150px" name="beginDate" class="easyui-datebox" data-options="editable:false"></input>
                        <input id="flag" type="hidden"/>
                     </div>
                  </td>
                  <td width="100" height="33">
                     <div align="left">结束时间</div>
                  </td>
                  <td width="158">
                     <div align="left">
                        <input id="endDate" style="width:150px" name="endDate" class="easyui-datebox" data-options="editable:false"></input>
                     </div>
                  </td>
                  <td width="100" height="33">
                     <div align="left">操作信息</div>
                  </td>
                  <td width="158" height="33">
                     <div align="left">
                        <input id="logicMessage" name="logicMessage" class="easyui-validatebox textbox" style="width:150px;" />
                     </div>
                  </td>
                  <td width="30"><a href="javascript:void(0);" class="sub_btn" onclick="submitForm()"></a></td>
               </tr>
            </table>
            </form>
         </div>
         <div class="nav_search"></div>
      </div>
      </div>
      <table id="access" class="easyui-datagrid" fit='true' style="align:true" data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false">
         <thead>
            <tr>
               <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>
               <th data-options="field:'hostAddress',halign:'center',align:'left',sortable:true" width="150px">ip地址</th>
               <th data-options="field:'passport',halign:'center',align:'left',sortable:true" width="100px">账号</th>
               <th data-options="field:'logicMessage',halign:'center',align:'left',sortable:true" width="150px">操作信息</th>
               <th data-options="field:'browserUri',halign:'center',align:'left',sortable:true" width="300px">请求地址</th>
               <th data-options="field:'pageInfo',halign:'center',align:'left',sortable:true" width="450px">页面信息</th> 
               <th data-options="field:'updateDate',halign:'center',align:'left'" width="160px">更新时间</th>
               <th data-options="field:'createDate',halign:'center',align:'left'" width="160px">创建时间</th>
            </tr>
         </thead>
      </table>
   </body>

   </HTML>