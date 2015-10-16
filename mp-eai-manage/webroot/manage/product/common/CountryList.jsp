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
        var url = "/manage/product/common/Country.wa?do=select&date="
                + new Date().valueOf();
        var data = null;
        var name = $.trim($('#name').val()).replaceAll("'", "");
        if (name == "名称") name = null;
        if (page != null) {
            url = "/manage/product/common/Country.wa?do=select&page="
                    + page + "&date=" + new Date().valueOf();
            data = {
                "name":name,
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
                    location.href = "/manage/product/common/Country.wa?do=delete&id="
                            + id + "&date=" + new Date().valueOf();
                });
    }
    //更新配置信息-AnjoyTian
    function edit(id) {
        console.info(id);
        window.location.href = "/manage/product/common/Country.wa?do=updateBefore&id="
                + id + "&date=" + new Date().valueOf();

    }
    function del(id) {
        alert("不可删除");
    }
</script>
</HEAD>
<body>
 <div id="cy_right" style="width: 100%">
  <div class="right_title">
   <span>国家信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="/manage/product/common/Country.wa?do=insertBefore"
     class="add_btn"></a>
   </div>
   <div class="nav_search">
    <input id="name" name="name" type="text"
     onfocus="if(this.value=='名称'){this.value='';}this.style.color='#000000';"
     onblur="if(this.value=='') {this.value='名称';this.style.color='#ccc';}"
     style="color: #ccc" value="名称"> <a onClick="doSubmit(0)"
     href="#" class="sear_btn"></a>
   </div>
  </div>
 </div>
  <table id="config" class="easyui-datagrid" fit='true' style="align:true"
   data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false,rownumbers: true,striped: true">
  <thead>
   <tr>
    <th data-options="field:'ouid',halign:'center',align:'right'"
     width="40px">编号</th>
    <th
     data-options="field:'name',halign:'center',align:'left',sortable:true"
     width="100px" >名称</th>
    <th
     data-options="field:'label',halign:'center',align:'left',sortable:true"
     width="100px">标签</th>
    <th
     data-options="field:'phoneCode',halign:'center',align:'left',sortable:true"
     width="60px">区号</th>
    <th
     data-options="field:'code',halign:'center',align:'left',sortable:true"
     width="60px">代码</th>
    <th
     data-options="field:'iconUrl',halign:'center',align:'left',sortable:true"
     width="80px">图标地址</th>
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