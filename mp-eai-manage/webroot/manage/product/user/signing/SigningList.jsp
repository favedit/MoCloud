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
      var pager = $('#signing').datagrid().datagrid('getPager');
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
      var url = "/manage/product/user/signing/Signing.wa?do=select&date="
              + new Date().valueOf();
      var data = null;
      if (page != null) {
          url = "/manage/product/user/signing/Signing.wa?do=select&page="
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
              $('#signing').datagrid('loadData', toJsonObject(msg));
          },
          fail : function() {
              closeProgress();
              alert("error");
          }
      });
   }
   function doSubmitByCondition(page,pageSize) {
      progress();
      var beginDate = $('#beginDate').datebox('getValue');
      var endDate = $('#endDate').datebox('getValue'); 
      var url = null;
      var data = null;
      if (page != null) {
         data = {
            "page": page,
            "pageSize" : pageSize,
            "beginDate" :beginDate,
            "endDate" :endDate
         };
         url = "/manage/product/user/signing/Signing.wa?do=selectByDate&page=" + page + "&date=" + new Date().valueOf();
      } else {
         data = {
              "beginDate" :beginDate,
              "endDate" :endDate
          };
         url = "/manage/product/user/signing/Signing.wa?do=selectByDate&date=" + new Date().valueOf();
      }
      $.ajax({
         type: "POST",
         url: url,
         data: data,
         success: function(msg) {
            closeProgress();
            $('#signing').datagrid('loadData', toJsonObject(msg));
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
   <span>用户签到信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
   </div>
   <div class="nav_search" style="width:520px;">
   <form id="logerdat" action="/manage/product/user/signing/Signing.wa" method="post" align="center">
      <table border="0" align="left" cellpadding="0" cellspacing="0" style=" margin-left:10px">
         <tr>
            <td width="60" height="33">
               <div align="left">开始时间:</div>
            </td>
            <td width="152">
               <div align="left">
                  <input id="beginDate" style="width:150px" name="beginDate" class="easyui-datebox" data-options="editable:false"></input>
                  <input id="flag" type="hidden"/>
               </div>
            </td>
            <td width="60" height="33">
               <div align="middle">结束时间:</div>
            </td>
            <td width="152">
               <div align="left">
                  <input id="endDate" style="width:150px" name="endDate" class="easyui-datebox" data-options="editable:false"></input>
               </div>
            </td>
            <td width="30"><a onClick="submitForm()" href="javascript:void(0);" class="sear_btn"></a></td>
         </tr>
      </table>
    </form>
   </div>
  </div>
 </div>
 <table id="signing" class="easyui-datagrid" fit='true'
  style="align: true"
  data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false,striped: true">
  <thead>
   <tr>
    <th data-options="field:'ouid',halign:'center',align:'right'"
     width="40px">编号</th>
     <th
     data-options="field:'userLabel',halign:'center',align:'left',sortable:true"
     width="111px">用户签名</th>
     <th
     data-options="field:'singnDate',halign:'center',align:'left',sortable:true"
     width="140px">签到时间</th>
     <th
     data-options="field:'locationLongitude',halign:'center',align:'left',sortable:true"
     width="160px">位置经度</th>
     <th
     data-options="field:'locationLatitude',halign:'center',align:'left',sortable:true"
     width="160px">位置纬度</th>
     <th
     data-options="field:'note',halign:'center',align:'left',sortable:true"
     width="260px">备注</th>
     <th 
     data-options="field:'updateDate',halign:'center',align:'left',sortable:true"
     width="140px">更新时间</th>
     <th 
     data-options="field:'createDate',halign:'center',align:'left',sortable:true"
     width="140px">创建时间</th>    
   </tr>
  </thead>
 </table>
</body>
</HTML>