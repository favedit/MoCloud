<%@ include file='/apl/public.inc'%>
<HTML>
<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css"
 media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
<script>
   //显示更新成功
   $(function() {
       doSubmit(null, null);
       var pager = $('#config').datagrid().datagrid('getPager');
       pager.pagination({
           pageSize : 20,
           showPageList : [ 20, 30, 40 ],
           onSelectPage : function(pageNumber, pageSize) {
              var tip = $("#flag").val();
              if(tip=="2"){
                 doSubmitByCondition(pageNumber,pageSize);
              }else{
                 doSubmit(pageNumber,pageSize);
              }
           }
       });
   });
   function doSubmit(page, pageSize) {
       progress();
       $("#flag").val("");
       var url = "/manage/product/financial/marketer/Marketer.wa?do=select&date="
               + new Date().valueOf();
       var data = null;
       if (page != null) {
           url = "/manage/product/financial/marketer/Marketer.wa?do=select&page="
                   + page + "&date=" + new Date().valueOf();
           data = {
               "page" : page,
               "pageSize" : pageSize
           };
       }
       $.ajax({  
           type : "POST",
           url : url,
           data : data,
           success : function(msg) {
               closeProgress();
               $('#config').datagrid('loadData', toJsonObject(msg));
           },
           fail : function() {
               closeProgress();
               alert("error");
           }
       });
   }
   function del(id) {
       return confirmx(
               '确定删除?',
               function() {
                   location.href = "/manage/product/financial/marketer/Marketer.wa?do=delete&id="
                           + id + "&date=" + new Date().valueOf();
               });
   }
   //更新配置信息-AnjoyTian
   function edit(id) {
       console.info(id);
       window.location.href = "/manage/product/financial/marketer/Marketer.wa?do=updateBefore&id="
               + id + "&date=" + new Date().valueOf();
   }
   function doSubmitByCondition(page,pageSize) {
      progress();
      var beginDate = $('#beginDate').datebox('getValue');
      var endDate = $('#endDate').datebox('getValue'); 
      var name = $("#name").val();
      var url = null;
      var data = null;
      if (page != null) {
         data = {
            "page": page,
            "pageSize" : pageSize,
            "beginDate" :beginDate,
            "endDate" :endDate,
            "name" :name
         };
         url = "/manage/product/financial/marketer/Marketer.wa?do=selectByDate&page=" + page + "&date=" + new Date().valueOf();
      } else {
         data = {
              "beginDate" :beginDate,
              "endDate" :endDate,
              "name" :name
          };
          url = "/manage/product/financial/marketer/Marketer.wa?do=selectByDate&date=" + new Date().valueOf();
      }
      $.ajax({
         type: "POST",
         url: url,
         data: data,
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
 <div id="cy_right" style="width: 100%">
  <div class="right_title">
   <span>理财师信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    </div>
   <div class="nav_search" style="width:900px;">
    <form id="logerdat" action="/manage/product/financial/marketer/Marketer.wa" method="post" align="center">
      <table border="0" align="left" cellpadding="0" cellspacing="0" style=" margin-left:10px">
         <tr>
            <td width="59" height="33">
               <div align="left">开始时间:</div>
            </td>
            <td width="158">
               <div align="left">
                  <input id="beginDate" style="width:150px" name="beginDate" class="easyui-datebox" data-options="editable:false"></input>
                  <input id="flag" type="hidden"/>
               </div>
            </td>
            <td width="59" height="33">
               <div align="left">结束时间:</div>
            </td>
            <td width="158">
               <div align="left">
                  <input id="endDate" style="width:150px" name="endDate" class="easyui-datebox" data-options="editable:false"></input>
               </div>
            </td>
            <td width="30" height="33">
               <div align="right">名称:</div>
            </td>
            <td width="158" height="33">
               <div align="left">
                  <input id="name" name="name" class="easyui-validatebox textbox" style="width:150px;" />
               </div>
            </td>
            <td width="30"><a onClick="submitForm()" href="javascript:void(0);" class="sear_btn"></a></td>
            <td><a href="/manage/product/financial/marketer/Marketer.wa?do=insertBefore" class="add_btn"></a></td>
         </tr>
      </table>
      </form>
   </div>
  </div>
 </div>
 <table id="config" class="easyui-datagrid" fit='true'
  style="align: true"
  data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false,striped: true">
  <thead>
   <tr>
    <th data-options="field:'ouid',halign:'center',align:'right'"
     width="40px">编号</th>
    <th
     data-options="field:'userId',halign:'center',align:'left',sortable:true"
     width="60px">用户id</th>
    <th
     data-options="field:'name',halign:'center',align:'left',sortable:true"
     width="60px">名称</th>
    <th
     data-options="field:'label',halign:'center',align:'left',sortable:true"
     width="60px">标签</th>
    <th data-options="field:'statusCd',halign:'center',align:'left',sortable:true"
     width="40px">状态</th>
    <th
     data-options="field:'phone',halign:'center',align:'left',sortable:true"
     width="90px">电话号码</th>
    <th data-options="field:'rankLabel',halign:'center',align:'left',sortable:true"
     width="40px">职务</th>
    <th
     data-options="field:'departmentLabel',halign:'center',align:'left'"
     width="100px">所属部门</th>
    <th
     data-options="field:'customerInvestmentTotal',halign:'center',align:'left',sortable:true"
     width="90px">客户投资总额</th>
    <th
     data-options="field:'customerInvestmentCount',halign:'center',align:'left',sortable:true"
     width="90px">客户投资次数</th>
    <th
     data-options="field:'customerInvestmentDate',halign:'center',align:'left',sortable:true"
     width="90px">客户投资时间</th>
    <th
     data-options="field:'customerRedemptionTotal',halign:'center',align:'left',sortable:true"
     width="90px">客户赎回总额</th>
    <th
     data-options="field:'customerRedemptionCount',halign:'center',align:'left',sortable:true"
     width="90px">客户赎回次数</th>
    <th
     data-options="field:'customerRedemptionDate',halign:'center',align:'left',sortable:true"
     width="90px">客户赎回时间</th>
    <th
     data-options="field:'customerNetinvestmentTotal',halign:'center',align:'left',sortable:true"
     width="90px">客户净投总额</th>
    <th
     data-options="field:'customerInterestTotal',halign:'center',align:'left',sortable:true"
     width="90px">客户利息总额</th>
    <th
     data-options="field:'customerPerformanceTotal',halign:'center',align:'left',sortable:true"
     width="90px">客户业绩总额</th>
    <th
     data-options="field:'note',halign:'center',align:'left',sortable:true"
     width="200px">备注信息</th>
    <th
     data-options="field:'operation',halign:'center',align:'center',formatter:insert_editAndDelButton"
     width="140px">操作</th>
   </tr>
  </thead>
 </table>
</body>

</HTML>