<%@ include file='/apl/public.inc' %>
<HTML>
<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
<script type="text/javascript" src="/manage/ajs/hCharts/highcharts.js"></script>
<style type="text/css">
   #manage_id{
      width:100%;
      margin-top:-10px;
      margin-left:-10px;
      padding-bottom:-20px;
      height:75%;
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
   hCharts();
});

function doSubmit(page,pageSize) {
   progress();
   $("#flag").val("");
   var url = null;
   var data = null;
   if (page != null) {
      url = "/manage/system/statistics/user/login/Access.wa?do=select&page=" + page + "&date=" + new Date().valueOf();
      data = {
         "page": page,
         "pageSize" : pageSize
      };
   } else {
      url = "/manage/system/statistics/user/login/Access.wa?do=select&date=" + new Date().valueOf();
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
       url = "/manage/system/statistics/user/login/Access.wa?do=selectByDate&page=" + page + "&date=" + new Date().valueOf();
    } else {
       data = {
            "beginDate" :beginDate,
            "endDate" :endDate,
            "passport" :passport,
            "logicMessage" :lm
        };
       url = "/manage/system/statistics/user/login/Access.wa?do=selectByDate&date=" + new Date().valueOf();
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
//用户登录月曲线图
function hCharts(){
   progress();
   var url = "/manage/system/statistics/user/login/Access.wa?do=selectByDay&date=" + new Date().valueOf();
   $.ajax({
      type: "POST",
      url: url,
      success: function(msg) {
        var json = toJsonObject(msg);
        //曲线图标题
        var text = json.text;
        //曲线x轴时间
        var date = json.date;
        //曲线名称1
        var successName = json.login[0].name;
        //曲线1数据
        var success = json.login[0].data;
        //曲线名称2
        var failName = json.login[1].name;
        //曲线2数据
        var fail = json.login[1].data;
        
        //声明 highcharts series数据对象
        var hChartData = [{
            name:'' ,
            data: []
        }, {
            name: '',
            data: []
        }];
        hChartData[0].name=successName;
        hChartData[1].name=failName;
        //highcharts series 数组 push赋值
        for(var j=0;j<30;j++){
           hChartData[0].data.push(eval("("+success[j]+")"));
           hChartData[1].data.push(eval("("+fail[j]+")"));
        }
        
        $('#container').highcharts({
           title: {
               text: text,
               x: -20 //center
           },
           subtitle: {
               text: '',
               x: -20
           },
           xAxis: {
               categories: date
           },
           yAxis: {
               title: {
                   text: '次(登陆分布)'
               },
               plotLines: [{
                   value: 0,
                   width: 1,
                   color: 'black'
               }]
           },
           tooltip: {
               valueSuffix: '次'
           },
           legend: {
               layout: 'vertical',
               align: 'right',
               verticalAlign: 'middle',
               borderWidth: 0
           },
           series: hChartData
        });
        closeProgress();
     },
     fail: function() {
        closeProgress();
        alert("error");
     }
  });
}
</script>
</HEAD>

<body>
<div id="loginView" style="width:100%;height:35%;">
<div id="container" style="min-width: 310px; height: 300px; margin: 0 auto"></div>
</div>
<div id="manage_id" style="width:100%;height:65%;">
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