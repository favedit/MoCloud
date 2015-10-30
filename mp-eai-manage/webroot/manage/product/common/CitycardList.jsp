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
        var url = "/manage/product/common/Citycard.wa?do=select&date="
                + new Date().valueOf();
        var data = null;
        var cardCode = $.trim($('#cardCode').val()).replaceAll("'", "");
        if (cardCode == "身份证") cardCode = null;
        if (page != null) {
            url = "/manage/product/common/Citycard.wa?do=select&page=" + page + "&date="
                    + new Date().valueOf();
            data = {
                "cardCode" : cardCode,
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
        return confirmx('确定删除?', function() {
            location.href = "/manage/product/common/Citycard.wa?do=delete&id=" + id
                    + "&date=" + new Date().valueOf();
        });
    }

    //更新配置信息-AnjoyTian
    function edit(id) {
        console.info(id);
        window.location.href = "/manage/product/common/Citycard.wa?do=updateBefore&id="
                + id + "&date=" + new Date().valueOf();
    }
    function del(id) {
        alert("不可删除");
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
   <span>城市身份证对照信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="/manage/product/common/Citycard.wa?do=insertBefore"
     class="add_btn"></a>
   </div>
   <div class="nav_search">
    <input id="cardCode" name="cardCode" type="text"
     onfocus="if(this.value=='身份证'){this.value='';}this.style.color='#000000';"
     onblur="if(this.value=='') {this.value='身份证';this.style.color='#ccc';}"
     style="color: #ccc" value="身份证"> <a onClick="doSubmit(0)"
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
     width="80px">编号</th>
    <th
     data-options="field:'cityLabel',halign:'center',align:'left',sortable:true"
     width="300px">城市</th>
    <th
     data-options="field:'cardCode',halign:'center',align:'center',sortable:true"
     width="100px">身份证</th>
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