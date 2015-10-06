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
        var pager = $('#configRule').datagrid().datagrid('getPager');
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
        var url = "/product/configration/Rule.wa?do=select&date="
                + new Date().valueOf();
        var data = null;
        var ruleCdStr = $.trim($('#ruleCdStr').val()).replaceAll("'", "");
        if (ruleCdStr == "规则状态") ruleCdStr = null;
        if (page != null) {
            url = "/product/configration/Rule.wa?do=select&page="
                    + page + "&date=" + new Date().valueOf();
            data = {
                "ruleCdStr" : ruleCdStr,
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
                $('#configRule').datagrid('loadData', toJsonObject(msg));
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
                 location.href = "/product/configration/Rule.wa?do=delete&id=" + id + "&date=" + new Date().valueOf();
             });
    }
    //更新配置信息-AnjoyTian
    function edit(id) {
        console.info(id);
        window.location.href = "/product/configration/Rule.wa?do=updateBefore&id="
                + id + "&date=" + new Date().valueOf();
    }
</script>
</HEAD>

<body>
 <div id="cy_right" style="width: 100%">
  <div class="right_title">
   <span>规则配置信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="/product/configration/Rule.wa?do=insertBefore"
     class="add_btn"></a>
   </div>
   <div class="nav_search">
    <input id="ruleCdStr" name="ruleCdStr" type="text"
     onfocus="if(this.value=='规则状态'){this.value='';}this.style.color='#000000';"
     onblur="if(this.value=='') {this.value='规则状态';this.style.color='#ccc';}"
     style="color: #ccc" value="规则状态"> <a onClick="doSubmit(0)"
     href="#" class="sear_btn"></a>
   </div>
  </div>
 </div>
 <table id="configRule" class="easyui-datagrid" fit='true'
  style="align: true"
  data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false,striped: true">
  <thead>
   <tr>
    <th data-options="field:'ouid',halign:'center',align:'right'"
     width="40px">编号</th>
     <th
     data-options="field:'ruleCdStr',halign:'center',align:'left',sortable:true"
     width="200px">规则状态</th>
     <th
     data-options="field:'percentage',halign:'center',align:'left',sortable:true"
     width="90px">权重百分比</th>
     <th
     data-options="field:'scorePoint',halign:'center',align:'left',sortable:true"
     width="60px">分数</th>
    <th
     data-options="field:'parameters1',halign:'center',align:'left',sortable:true"
     width="60px">参数1</th>
     <th
     data-options="field:'parameters2',halign:'center',align:'left',sortable:true"
     width="60px">参数2</th>
     <th
     data-options="field:'parameters3',halign:'center',align:'left',sortable:true"
     width="60px">参数3</th>
     <th
     data-options="field:'parameters4',halign:'center',align:'left',sortable:true"
     width="60px">参数4</th>
     <th 
     data-options="field:'note',halign:'center',align:'left'"
     width="140px">备注</th>
     <th 
     data-options="field:'updateDate',halign:'center',align:'left'"
     width="140px">更新日期</th>    
    <th
     data-options="field:'operation',halign:'center',align:'center',formatter:insert_editAndDelButton"
     width="140px">操作</th>
   </tr>
  </thead>
 </table>
</body>
</HTML>