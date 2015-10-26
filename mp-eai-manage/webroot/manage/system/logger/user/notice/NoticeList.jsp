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
      progress();
      $("#flag").val("");
      var url = null;
      var data = null;
      if (page != null) {
         url = "/manage/system/logger/user/notice/Notice.wa?do=select&page=" + page + "&date=" + new Date().valueOf();
         data = {
            "page": page,
            "pageSize" : pageSize
         };
      } else {
         url = "/manage/system/logger/user/notice/Notice.wa?do=select&date=" + new Date().valueOf();
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
       var activeCd = $("#activeCd").combobox("getValue");
       var url = null;
       var data = null;
       if (page != null) {
          data = {
             "page": page,
             "pageSize" : pageSize,
             "beginDate" :beginDate,
             "endDate" :endDate,
             "activeCd" :activeCd
          };     
          url = "/manage/system/logger/user/notice/Notice.wa?do=selectByDate&page=" + page + "&date=" + new Date().valueOf();
       } else {
          data = {
               "beginDate" :beginDate,
               "endDate" :endDate,
               "activeCd" :activeCd
           };
          url = "/manage/system/logger/user/notice/Notice.wa?do=selectByDate&date=" + new Date().valueOf();
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
   //搜索按钮，enter键
   document.onkeydown=function(){
      if(event.keyCode=="13"){
         submitForm();    
      }
   }
</script>
</HEAD>

<body>
   <div id="cy_right">
      <div class="right_title">
         <span>用户公告日志</span>
      </div>
      <div class="btn_bar">
      <div class="nav_btn">
      </div>
      <div class="nav_search" style="width:940px;">
        <form id="logerdat" action="/manage/system/logger/user/notice/Notice" method="post" align="center">
         <table border="0" align="left" cellpadding="0" cellspacing="0" style=" margin-left:10px">
            <tr>
               <td width="60" height="33">
                  <div align="left">开始时间:</div>
               </td>
               <td width="158">
                  <div align="left">
                     <input id="beginDate" style="width:150px" name="beginDate" class="easyui-datebox" data-options="editable:false"></input>
                     <input id="flag" type="hidden"/>
                  </div>
               </td>
               <td width="60" height="33">
                  <div align="left">结束时间:</div>
               </td>
               <td width="158">
                  <div align="left">
                     <input id="endDate" style="width:150px" name="endDate" class="easyui-datebox" data-options="editable:false"></input>
                  </div>
               </td>
               <td width="60" height="33">
                  <div align="left">激活状态:</div>
               </td>
               <td width="158">
	               <div align="left">
	                  <select  style="width:158px;height:20px" id="activeCd" class="easyui-combobox" name="activeCd" data-options="editable:false">
	                     <option value="1">激活</option>
	                     <option value="2">非激活</option>
	                  <select>
	               </div>
               </td>
               <td width="70" height="33">
                  <div align="left">日志公告id:</div>
               </td>
               <td width="150" height="33">
                  <div align="left">
                     <input id="noticeId" name="noticeId" class="easyui-validatebox textbox" style="width:150px;" />
                  </div>
               </td>
               <td width="30"><a onClick="submitForm()" href="javascript:void(0);" class="sear_btn"></a></td>
            </tr>
         </table>
        </form>
      </div>
   </div>
   </div>
   <table id="access" class="easyui-datagrid" fit='true' style="align:true" data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false">
      <thead>
         <tr>
            <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>
            <th data-options="field:'userId',halign:'center',align:'left',sortable:true" width="90px">用户id</th> 
            <th data-options="field:'noticeId',halign:'center',align:'left',sortable:true" width="90px">日志公告id</th> 
            <th data-options="field:'activeCdStr',halign:'center',align:'left',sortable:true" width="90px">是否激活</th> 
            <th data-options="field:'updateDate',halign:'center',align:'left',sortable:true" width="160px">更新时间</th>
            <th data-options="field:'createDate',halign:'center',align:'left',sortable:true" width="160px">创建时间</th>
         </tr>
      </thead>
   </table>
</body>

</HTML>