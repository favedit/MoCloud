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
        var url = "/manage/product/examine/news/News.wa?do=select&date="
                + new Date().valueOf();
        var data = null;
        var label = $.trim($('#label').val()).replaceAll("'", "");
        if (label == "资讯标题") label = null;
        if (page != null) {
            url = "/manage/product/examine/news/News.wa?do=select&page="
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
                $('#logicNews').datagrid('loadData', toJsonObject(msg));
            },
            fail : function() {
                closeProgress();
                alert("error");
            }
        });
    }
    function phoneInfo(ouid){
        window.showModalDialog("/manage/product/examine/news/News.wa?do=getDescription&ouid="+ouid,null,"dialogWidth=360px;dialogHeight=640px");
    }
    function checkTask(flag){
        var ss = [];
        var rows = $('#logicNews').datagrid('getSelections');
        if(rows.length != 0){
           for(var i=0; i<rows.length; i++){
              var row = rows[i];
              ss.push(row.ouid);
           }
           location.href= "/manage/product/examine/news/News.wa?do=checking&newsIds="+ss+"&flag="+flag;
        }
  }
</script>
</HEAD>

<body>
 <div id="cy_right" style="width: 100%">
  <div class="right_title">
   <span>业务资讯未审核列表</span>
  </div>
  <div class="btn_bar">
     <div class="nav_btn">
           <a href="javascript:checkTask('1');" class="ty_btn"></a>
           <a href="javascript:checkTask('0');" class="bty_btn"></a>
      </div>
      <div class="nav_search">
         <input id="label" name="label" type="text"
           onfocus="if(this.value=='资讯标题'){this.value='';}this.style.color='#000000';"
           onblur="if(this.value=='') {this.value='资讯标题';this.style.color='#ccc';}"
           style="color: #ccc" value="资讯标题"> <a onClick="doSubmit(0)"
           href="#" class="sear_btn"></a>
      </div>
  </div>
 </div>
 <table id="logicNews" class="easyui-datagrid" fit='true'
   style="align: true"
   data-options="toolbar:'#cy_right',pagination:true,rownumbers:true,collapsible:true,remoteSort:false,multiSort:false,striped: true">
  <thead>
   <tr>
    <th data-options="field:'ck',checkbox:true">全选</th>
    <th data-options="field:'ouid',halign:'center',align:'right'"
     width="40px">编号</th>
     <th
     data-options="field:'label',halign:'center',align:'left',sortable:true"
     width="200px">资讯标题</th>
     <th
     data-options="field:'statusCdStr',halign:'center',align:'left',sortable:true"
     width="90px">状态</th>
     <th
     data-options="field:'displayCdStr',halign:'center',align:'left',sortable:true"
     width="60px">是否显示</th>
     <th
     data-options="field:'keywords',halign:'center',align:'left',sortable:true"
     width="60px">关键字</th>
     <th
     data-options="field:'iconUrl',halign:'center',align:'left',sortable:true"
     width="160px">图片</th>
    <th
     data-options="field:'description',halign:'center',align:'left',sortable:true"
     width="160px">描述</th>
     <th
     data-options="field:'content',halign:'center',align:'left',sortable:true"
     width="260px">资讯内容</th>
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