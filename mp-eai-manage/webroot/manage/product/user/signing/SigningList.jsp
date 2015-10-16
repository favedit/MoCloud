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
        var pager = $('#logicNews').datagrid().datagrid('getPager');
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
        var url = "/manage/product/user/signing/Signing.wa?do=select&date="
                + new Date().valueOf();
        var data = null;
        var userId = $.trim($('#userId').val()).replaceAll("'", "");
        if (userId == "用户id") userId = null;
        if (page != null) {
            url = "/manage/product/user/signing/Signing.wa?do=select&page="
                    + page + "&date=" + new Date().valueOf();
            data = {
                "auserId" : userId,
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
                $('#logicNews').datagrid('loadData', toJsonObject(msg));
            },
            fail : function() {
                closeProgress();
                alert("error");
            }
        });
    }
    function del(id) {
       return confirmx('确定删除?',
                 function() {
                     location.href = "/manage/product/user/signing/Signing.wa?do=delete&id=" + id + "&date=" + new Date().valueOf();
                 });
    }
    //更新配置信息-AnjoyTian
    function edit(id) {
        console.info(id);
        window.location.href = "/manage/product/user/signing/Signing.wa?do=updateBefore&id="
                + id + "&date=" + new Date().valueOf();
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
    <!--<a href="/product/news/News.wa?do=insertBefore"
     class="add_btn"></a>-->
   </div> 
   <div class="nav_search">
    <input id="userId" name="userId" type="text"
     onfocus="if(this.value=='用户id'){this.value='';}this.style.color='#000000';"
     onblur="if(this.value=='') {this.value='用户id';this.style.color='#ccc';}"
     style="color: #ccc" value="用户id"> <a onClick="doSubmit(0)"
     href="#" class="sear_btn"></a>
   </div>
  </div>
 </div>
 <table id="logicNews" class="easyui-datagrid" fit='true'
  style="align: true"
  data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false,striped: true">
  <thead>
   <tr>
    <th data-options="field:'ouid',halign:'center',align:'right'"
     width="40px">编号</th>
     <th
     data-options="field:'userId',halign:'center',align:'left',sortable:true"
     width="200px">用户id</th>
     <th
     data-options="field:'singnDate',halign:'center',align:'left',sortable:true"
     width="190px">签到时间</th>
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
     data-options="field:'updateDate',halign:'center',align:'left'"
     width="140px">更新日期</th>    
   </tr>
  </thead>
 </table>
</body>
</HTML>