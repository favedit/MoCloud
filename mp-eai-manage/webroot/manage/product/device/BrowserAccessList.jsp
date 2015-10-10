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
        var pager = $('#browserAccess').datagrid().datagrid('getPager');
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
        var url = "/manage/product/device/Device.wa?do=select&date="
                + new Date().valueOf();
        var data = null;
        var label = $.trim($('#label').val()).replaceAll("'", "");
        if (label == "资讯标题") label = null;
        if (page != null) {
            url = "/manage/product/device/Device.wa?do=select&page="
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
                $('#browserAccess').datagrid('loadData', toJsonObject(msg));
            },
            fail : function() {
                closeProgress();
                alert("error");
            }
        });
    }
    function infoButton(value, row, index) {
       var edit = '<a href="javascript:void(0)" class="easyui-linkbutton l-btn l-btn-plain"  plain="true"><span class="l-btn-left" sizset="false" onClick="rowInfo(\'' + row.ouid + '\')"><span class="l-btn-text icon-tip l-btn-icon-left">详情</span></span></a>';
       return edit;
    }
    function rowInfo(id){
       location.href="/manage/product/device/Device.wa?do=updateBefore&id="+id;
    }
    function expend(){
       progress();
       var url = "/manage/product/device/Device.wa?do=expend";
       $.post(url,function(json){
          json = toJsonObject(json);
          closeProgress();
          if(json.status == "1"){
             alert("导出成功！文件："+json.url);
             location.href="/manage/product/device/Device.wa";
          }else{
             alert("导出失败!"+json.url);
          }
          
       });
    }
</script>
</HEAD>

<body>
 <div id="cy_right" style="width: 100%">
  <div class="right_title">
   <span>设备信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="/manage/product/device/Device.wa?do=insertBefore"
     class="add_btn"></a>
   </div>
   <div class="nav_search">
    <input id="agentCode" name="agentCode" type="text"
     onfocus="if(this.value=='头信息'){this.value='';}this.style.color='#000000';"
     onblur="if(this.value=='') {this.value='头信息';this.style.color='#ccc';}"
     style="color: #ccc" value="头信息"> <a onClick="doSubmit(0)"
     href="#" class="sear_btn"></a>
   </div>
  </div>
 </div>
 <table id="browserAccess" class="easyui-datagrid" fit='true'
  style="align: true"
  data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false,striped: true">
  <thead>
   <tr>
    <th data-options="field:'ouid',halign:'center',align:'right'"
     width="40px">编号</th>
     <th
     data-options="field:'agentCode',halign:'center',align:'left',sortable:true"
     width="900px">头信息</th>
     <th 
     data-options="field:'updateDate',halign:'center',align:'left'"
     width="140px">更新日期</th>    
    <th
     data-options="field:'operation',halign:'center',align:'center',formatter:infoButton"
     width="140px">操作</th>
   </tr>
  </thead>
 </table>
</body>
</HTML>
