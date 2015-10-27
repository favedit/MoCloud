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
               doSubmit(pageNumber, pageSize);
           }
       });
   });

   function doSubmit(page, pageSize) {
       progress();
       var url = "/manage/product/financial/product/Product.wa?do=select&date="
               + new Date().valueOf();
       var data = null;
       var label = $.trim($('#label').val()).replaceAll("'", "");
       if (label == "标签")
          label = null;
       if (page != null) {
           url = "/manage/product/financial/product/Product.wa?do=select&page="
                   + page + "&date=" + new Date().valueOf();
           data = {
               "label" : label,
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
                   location.href = "/manage/product/financial/product/Product.wa?do=delete&id="
                           + id + "&date=" + new Date().valueOf();
               });
   }

   //更新配置信息-AnjoyTian
   function edit(id) {
       console.info(id);
       window.location.href = "/manage/product/financial/product/Product.wa?do=updateBefore&id="
               + id + "&date=" + new Date().valueOf();
   }
  //搜索按钮，enter键
   document.onkeydown=function(){
      if(event.keyCode=="13"){
         doSubmit(0);    
      }
   }
</script>
</HEAD>

<body>
 <div id="cy_right" style="width: 100%">
  <div class="right_title">
   <span>产品信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="/manage/product/financial/product/Product.wa?do=insertBefore"
     class="add_btn"></a>
   </div>
   <div class="nav_search">
    <input id="label" name="label" type="text"
     onfocus="if(this.value=='标签'){this.value='';}this.style.color='#000000';"
     onblur="if(this.value=='') {this.value='标签';this.style.color='#ccc';}"
     style="color: #ccc" value="标签"> <a onClick="doSubmit(0)"
     href="#" class="sear_btn"></a>
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
     data-options="field:'code',halign:'center',align:'center',sortable:true"
     width="60px" >名称</th>
     <th
     data-options="field:'label',halign:'center',align:'left',sortable:true"
     width="60px">标签</th>
     <th
     data-options="field:'rate',halign:'center',align:'left',sortable:true"
     width="60px">收益率</th>
     <th
     data-options="field:'horizonUnit',halign:'center',align:'left',sortable:true"
     width="60px">投资期限类型</th>
    <th
     data-options="field:'horizonCount',halign:'center',align:'left',sortable:true"
     width="60px">投资期限</th>
    <th
     data-options="field:'horizonClosed',halign:'center',align:'left',sortable:true"
     width="80px">关闭期</th>
    <th
     data-options="field:'horizonWait',halign:'center',align:'left',sortable:true"
     width="80px">等待期</th>
    <th
     data-options="field:'factor',halign:'center',align:'left',sortable:true"
     width="80px">业绩</th>
     <th
     data-options="field:'note',halign:'center',align:'left',sortable:true"
     width="60px">备注</th>
     
     <th data-options="field:'updateDate',halign:'center',align:'left',sortable:true"
     width="140px">更新时间</th>    
    <th
     data-options="field:'operation',halign:'center',align:'center',formatter:insert_editAndDelButton"
     width="140px">操作</th>
   </tr>
  </thead>
 </table>
</body>
</HTML>