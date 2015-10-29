<%@ include file='/apl/public.inc' %>
<HTML>
<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
<style type="text/css">
   #manage_id{
      width:100%;
      margin-top:-10px;
      margin-left:-10px;
      padding-bottom:-20px;
      height:100%;
   }
   #cond_id{
      float:right;
      margin-right:10px;
   }
   #search_id{
      float:right;
      margin-bottom:6px;
   }
</style>
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
      url = "/manage/system/logger/user/access/Access.wa?do=select&page=" + page + "&date=" + new Date().valueOf();
      data = {
         "page": page,
         "pageSize" : pageSize
      };
   } else {
      url = "/manage/system/logger/user/access/Access.wa?do=select&date=" + new Date().valueOf();
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
    var passport = $("#passport").val();
    var url = null;
    var data = null;
    if (page != null) {
       data = {
          "page": page,
          "pageSize" : pageSize,
          "beginDate" :beginDate,
          "endDate" :endDate,
          "passport" :passport,
          "logicMessage" :lm
       };
       url = "/manage/system/logger/user/access/Access.wa?do=selectByDate&page=" + page + "&date=" + new Date().valueOf();
    } else {
       data = {
            "beginDate" :beginDate,
            "endDate" :endDate,
            "passport" :passport,
            "logicMessage" :lm
        };
       url = "/manage/system/logger/user/access/Access.wa?do=selectByDate&date=" + new Date().valueOf();
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
<div id="manage_id" style="width:100%;height:100%;">
<div id="cy_right">
   <div class="right_title">
      <span>用户日志</span>
   </div>
  <div id="cond_id">
    <span>开始时间:</span>
      <input id="beginDate" style="width:150px" name="beginDate" class="easyui-datebox" data-options="editable:false"></input>
      <input id="flag" type="hidden"/>
    <span>结束时间:</span>
      <input id="endDate" style="width:150px" name="endDate" class="easyui-datebox" data-options="editable:false"></input>
    <span>账号:</span>
      <input id="passport" name="passport" class="easyui-validatebox textbox" style="width:150px;" />
    <span>操作信息:</span>
      <input id="logicMessage" name="logicMessage" class="easyui-validatebox textbox" style="width:150px;" />
      <a href="javascript:void(0);" id="search_id" onClick="submitForm()" class="sear_btn"></a>
  </div>
 </div>
<table id="access" class="easyui-datagrid" fit='false' style="align:true;height:102%;width:101%;" data-options="toolbar:'#cy_right',pagination:true,collapsible:true,
         singleSelect:true,remoteSort:false,multiSort:false">
   <thead>
      <tr>
         <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>
         <th data-options="field:'hostAddress',halign:'center',align:'left',sortable:true" width="150px">ip地址</th>
         <th data-options="field:'passport',halign:'center',align:'left',sortable:true" width="100px">账号</th>
         <th data-options="field:'logicMessage',halign:'center',align:'left',sortable:true" width="150px">操作信息</th>
         <th data-options="field:'browserUri',halign:'center',align:'left',sortable:true" width="300px">请求地址</th>
         <th data-options="field:'pageInfo',halign:'center',align:'left',sortable:true" width="450px">页面信息</th> 
         <th data-options="field:'updateDate',halign:'center',align:'left',sortable:true" width="160px">更新时间</th>
         <th data-options="field:'createDate',halign:'center',align:'left',sortable:true" width="160px">创建时间</th>
      </tr>
   </thead>
</table>
</div>
</body>

</HTML>