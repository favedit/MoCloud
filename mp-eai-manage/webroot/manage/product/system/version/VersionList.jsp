<%@ include file='/apl/public.inc' %>
<HTML>

<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
<script>
   //显示更新成功
   $(function() {
      doSubmit(null, null);
      var pager = $('#version').datagrid().datagrid('getPager');
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
      var url = "/manage/product/system/version/Version.wa?do=select&date=" + new Date().valueOf();
      var data = null;
      var label = $.trim($('#label').val()).replaceAll("'", "");
      if (label == "版本标题") label = null;
      if (page != null) {
         url = "/manage/product/system/version/Version.wa?do=select&page=" + page + "&date=" + new Date().valueOf();
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
            $('#version').datagrid('loadData', toJsonObject(msg));
         },
         fail: function() {
            closeProgress();
            alert("error");
         }
      });
   }

   function del(id) {
      alert("不可删除!");
   }
   //更新配置信息-
   function edit(id) {
      progress();
      var url ="/manage/product/system/version/Version.wa?do=isUpdate&id=" + id + "&date=" + new Date().valueOf();
      $.ajax({
         type : "POST",
         url : url,
         success : function(msg) {
             closeProgress();
             if(msg.indexOf("noUpdate")>-1){
                alert("不可编辑!");
             }else{
                closeProgress();
                console.info(id);
                window.location.href = "/manage/product/system/version/Version.wa?do=updateBefore&id="
                         + id + "&date=" + new Date().valueOf();
             }
         },
         fail : function() {
             closeProgress();
             alert("error");
         }
     });
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
         <span>版本信息</span>
      </div>
      <div class="btn_bar">
         <div class="nav_btn">
            <a href="/manage/product/system/version/Version.wa?do=insertBefore" class="add_btn"></a>
         </div>
         <div class="nav_search">
            <input id="label" name="label" type="text" onfocus="if(this.value=='版本标题'){this.value='';}this.style.color='#000000';" onblur="if(this.value=='') {this.value='版本标题';this.style.color='#ccc';}" style="color: #ccc" value="版本标题">
            <a onClick="doSubmit(0)" href="#" class="sear_btn"></a>
         </div>
      </div>
   </div>
   <table id="version" class="easyui-datagrid" fit='true' style="align: true" data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false,striped: true">
      <thead>
         <tr>
            <th data-options="field:'ouid',halign:'center',align:'right'" width="40px">编号</th>
            <th data-options="field:'applicationLabel',halign:'center',align:'left',sortable:true" width="120px">应用</th>
            <th data-options="field:'label',halign:'center',align:'left',sortable:true" width="100px">版本标题</th>
            <th data-options="field:'number',halign:'center',align:'left',sortable:true" width="90px">版本号</th>
            <th data-options="field:'forceCdStr',halign:'center',align:'left',sortable:true" width="80px">更新类型</th>
            <th data-options="field:'statusCdStr',halign:'center',align:'left',sortable:true" width="80px">版本状态</th>
            <th data-options="field:'downloadUrl',halign:'center',align:'left',sortable:true" width="400px">下载地址</th>
            <th data-options="field:'note',halign:'center',align:'left',sortable:true" width="200px">更新内容</th>
            <th data-options="field:'operation',halign:'center',align:'center',formatter:insert_editAndDelButton" width="140px">操作</th>
         </tr>
      </thead>
   </table>
</body>

</HTML>