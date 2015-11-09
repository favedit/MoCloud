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
       var url = "/manage/product/organization/department/user/User.wa?do=select&date="
               + new Date().valueOf();
       var data = null;
       var label = $.trim($('#label').val()).replaceAll("'", "");
       if (label == "中文名称")
          label = null;
       if (page != null) {
           url = "/manage/product/organization/department/user/User.wa?do=select&page="
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
                   location.href = "/manage/product/organization/department/user/User.wa?do=delete&id="
                           + id + "&date=" + new Date().valueOf();
               });
   }

   //更新配置信息-AnjoyTian
   function edit(id) {
       console.info(id);
       window.location.href = "/manage/product/organization/department/user/User.wa?do=updateBefore&id="
               + id + "&date=" + new Date().valueOf();
   }
  //搜索按钮，enter键
   document.onkeydown=function(){
      if(event.keyCode=="13"){
         doSubmit(0);    
      }
   }
  //展示图片
   function showPhoto(makeUrl){
      if(makeUrl!=null&&makeUrl.length>0){
         return "<img src="+makeUrl+" height=55px width=55px/>";
      }
   }
</script>
</HEAD>

<body>
 <div id="cy_right" style="width: 100%">
  <div class="right_title">
   <span>组织部门信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="/manage/product/organization/department/user/User.wa?do=insertBefore"
     class="add_btn"></a>
   </div>
   <div class="nav_search">
    <input id="label" name="label" type="text"
     onfocus="if(this.value=='中文名称'){this.value='';}this.style.color='#000000';"
     onblur="if(this.value=='') {this.value='中文名称';this.style.color='#ccc';}"
     style="color: #ccc" value="中文名称"> <a onClick="doSubmit(0)"
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
     width="55px">编号</th>
     <th
     data-options="field:'name',halign:'center',align:'center',sortable:true"
     width="180px" >英文名称</th>
     <th
     data-options="field:'label',halign:'center',align:'left',sortable:true"
     width="180px">中文名称</th>
     <th
     data-options="field:'code',halign:'center',align:'left',sortable:true"
     width="90px">英文名称简写</th>
     <th
     data-options="field:'statusCdStr',halign:'center',align:'left',sortable:true"
     width="60px">雇佣状态</th>
     <th
     data-options="field:'relationCdStr',halign:'center',align:'left',sortable:true"
     width="90px">关联关系</th>
    <th
     data-options="field:'departmentName',halign:'center',align:'left',sortable:true"
     width="100px">部门名称</th>
    <th
     data-options="field:'userName',halign:'center',align:'left',sortable:true"
     width="100px">用户</th>
    <th
     data-options="field:'entryDate',halign:'center',align:'left',sortable:true"
     width="140px">入职时间</th>
    <th
     data-options="field:'leaveDate',halign:'center',align:'left',sortable:true"
     width="140px">离职时间</th>
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