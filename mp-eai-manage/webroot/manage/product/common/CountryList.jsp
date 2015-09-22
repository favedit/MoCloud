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
        var url = "/product/common/Country.wa?do=select&date="
                + new Date().valueOf();
        var data = null;
        if (page != null) {
            url = "/product/common/Country.wa?do=select&page="
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
                    //                  var url = "/product/configration/Configration.wa?do=delete&date=" + new Date().valueOf();
                    //                  var data = {
                    //                     "id": id
                    //                  };
                    //                  $.getJSON(url, data, function(d) {
                    //                     alert(d);
                    //                     var result = toJsonObject(d);
                    //                      console.log(result);
                    //                     if (result.status == "1") {
                    //                        location.href = result.url;
                    //                     } else {
                    //                        alertx(result.url, "warning", function() {
                    //                           location.href = "/product/configration/Configration.wa";
                    //                        });
                    //                     }
                    //                  });
                    location.href = "/product/financial/customer/Customer.wa?do=delete&id="
                            + id + "&date=" + new Date().valueOf();
                });
    }

    //更新配置信息-AnjoyTian
    function edit(id) {
        console.info(id);
        window.location.href = "/product/financial/customer/Customer.wa?do=updateBefore&id="
                + id + "&date=" + new Date().valueOf();

    }
    
    是否结婚
    function isMarried(val,row){
        if(val==1){
            return '是';
        }else if(val==0){
            return '否';
        }else{
            return '未填';
        }
    }
    
    //教育
    function education(val,row){
        if(val==0){
            return "学士";
        }else if(val==1){
            return "硕士";
        }else if(val==2){
            return "博士";
        }else if(val==3){
            return "博士后";
        }
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
    <a href="/product/common/Country.wa?do=insertBefore"
     class="add_btn"></a>
   </div>
   <div class="nav_search">
    <input id="highestEducation" name="highestEducation" type="text"
     onfocus="if(this.value=='学历'){this.value='';}this.style.color='#000000';"
     onblur="if(this.value=='') {this.value='学历';this.style.color='#ccc';}"
     style="color: #ccc" value="学历"> <a onClick="doSubmit(0)"
     href="#" class="sear_btn"></a>
   </div>
  </div>
 </div>
 <table id="config" class="easyui-datagrid" fit='true'
  style="align: true"
  data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false,striped: true">
  <thead>
   <tr>
    <!-- <th data-options="field:'ouid',halign:'center',align:'right'"
     width="40px">编号</th> -->
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
    <!-- <th
     data-options="field:'displayCode',halign:'center',align:'left',sortable:true"
     width="60px">显示代码</th> -->
    <!-- <th
     data-options="field:'investmentCount',halign:'center',align:'left',sortable:true"
     width="60px">备注</th> -->
     
     <th data-options="field:'updateDate',halign:'center',align:'left'"
     width="140px">更新时间</th>    
    <!-- <th
     data-options="field:'note',halign:'center',align:'left',sortable:true"
     width="200px">备注信息</th> -->
    <th
     data-options="field:'operation',halign:'center',align:'center',formatter:insert_editAndDelButton"
     width="140px">操作</th>
   </tr>
  </thead>
 </table>
</body>

</HTML>