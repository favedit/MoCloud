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
               var tip = $("#flag").val();
               if(tip=="2"){
                  doSubmitByCondition(pageNumber,pageSize);
               }else{
                 doSubmit(pageNumber,pageSize);
               }
            }
        });
    });
    function doSubmit(page, pageSize) {
        progress();
        var url = "/manage/product/business/news/News.wa?do=select&date="
                + new Date().valueOf();
        var data = null;
        var label = $.trim($('#label').val()).replaceAll("'", "");
        if (label == "资讯标题") label = null;
        if (page != null) {
            url = "/manage/product/business/news/News.wa?do=select&page="
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
    function doSubmitByCondition(page,pageSize) {
       progress();
       var statusCd = $("#statusCd").combobox("getValue");
       var displayCd = $("#displayCd").combobox("getValue");
       var label = $("#label").val();
       var url = null;
       var data = null;
       if (page != null) {
          data = {
             "page": page,
             "pageSize" : pageSize,
             "statusCd" :statusCd,
             "displayCd" :displayCd,
             "label" :label
          };
          url = "/manage/product/business/news/News.wa?do=selectByData&page=" + page + "&date=" + new Date().valueOf();
       } else {
          data = {
                "statusCd" :statusCd,
                "displayCd" :displayCd,
                "label" :label
           };
          url = "/manage/product/business/news/News.wa?do=selectByData&date=" + new Date().valueOf();
       }
       $.ajax({
          type: "POST",
          url: url,
          data: data,
          success: function(msg) {
             closeProgress();
             $('#logicNews').datagrid('loadData', toJsonObject(msg));
          },
          fail: function() {
             closeProgress();
             alert("error");
          }
       });
    }
    function del(id) {
       progress();
       var url ="/manage/product/business/news/News.wa?do=deleteBefore&id=" + id + "&date=" + new Date().valueOf();
       $.ajax({
          type : "POST",
          url : url,
          success : function(msg) {
              closeProgress();
              if(msg.indexOf("noDel")>-1){
                 alert("不可删除!");
              }else{
                 closeProgress();
                 return confirmx('确定删除?',
                    function() {
                    location.href = "/manage/product/business/news/News.wa?do=delete&id=" + id + "&date=" + new Date().valueOf();
                 });
              }
          },
          fail : function() {
              closeProgress();
              alert("error");
          }
      });
    }
    //更新配置信息-
    function edit(id) {
        progress();
        console.info(id);
        window.location.href = "/manage/product/business/news/News.wa?do=updateBefore&id="
                + id + "&date=" + new Date().valueOf();
        closeProgress();
    }
    function reBack(id){
       progress();
       console.info(id);
       window.location.href = "/manage/product/business/news/News.wa?do=resetStatusCd&id="
               + id + "&date=" + new Date().valueOf();
       closeProgress();
    }
    function showPhoto(iconUrl){
       if(iconUrl!=null&&iconUrl.length>0){
          return "<img src="+iconUrl+" height=55px width=55px/>";
       }
    }
    function tip(){
       alert("不可删除!");
    }
    function submitForm(){
       if (!isValid()) return;
       doSubmitByCondition(null,null);
       $("#flag").val("2");
    }
    function phoneInfo(ouid){
       var l=(screen.availWidth-500)/2;
       var t=(screen.availHeight-500)/2;
       var w = screen.availWidth*7/19;
       var h = screen.availHeight*12/19
       window.open('/manage/product/business/news/News.wa?do=getDescription&ouid='+ouid,'_blank','height='+h+',width='+w+',top='+t+',left='+l+',toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
    }
    //搜索按钮，enter键
    document.onkeydown=function(){
       if(event.keyCode=="13"){
          submitForm();    
       }
    }
</script>
</HEAD>

<body>
 <div id="cy_right" style="width: 100%">
  <div class="right_title">
   <span>业务资讯信息</span>
  </div>
  <div class="btn_bar">
    <div class="nav_btn">
      <td><a href="/manage/product/business/news/News.wa?do=insertBefore" class="add_btn"></a></td>
    </div>
   <div class="nav_search" style="width:660px;">
    <form id="logerdat" action="/manage/product/business/news/News.wa" method="post" align="right">
      <table border="0" align="left" cellpadding="0" cellspacing="0" style=" margin-right:1px;">
         <tr>
            <td width="30" height="33">
               <div align="right">状态:</div>
            </td>
            <td width="158">
               <div align="left">
                  <select style="width:158px;height:20px" id="statusCd" class="easyui-combobox" name="statusCd" data-options="editable:false">
                     <option value="1">申请</option>
                     <option value="2">发布</option>
                     <option value="3">审核未通过</option>
                  <select>
                  <input id="flag" type="hidden"/>
               </div>
            </td>
            <td width="58" height="33">
               <div align="right">是否显示:</div>
            </td>
            <td width="158">
               <div align="left">
                  <select  style="width:158px;height:20px" id="displayCd" class="easyui-combobox" name="displayCd" data-options="editable:false">
                     <option value="1">展示</option>
                     <option value="2">非展示</option>
                  <select>
               </div>
            </td>
            <td width="30" height="33">
               <div align="right">标题:</div>
            </td>
            <td width="158" height="33">
               <div align="left">
                  <input id="label" name="label" class="easyui-validatebox textbox" style="width:150px;" />
               </div>
            </td>
            <td width="30"><a onClick="submitForm()" href="javascript:void(0);" class="sear_btn"></a></td>
         </tr>
      </table>
     </form>
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
     data-options="field:'iconUrl',halign:'center',align:'left',formatter:showPhoto"
     width="55px">图片</th>
     <th
     data-options="field:'label',halign:'center',align:'left',sortable:true"
     width="200px">标题</th>
     <th
     data-options="field:'statusCdStr',halign:'center',align:'left',sortable:true"
     width="30px">状态</th>
     <th
     data-options="field:'displayCdStr',halign:'center',align:'left',sortable:true"
     width="60px">是否显示</th>
     <th
     data-options="field:'linkCdStr',halign:'center',align:'left',sortable:true"
     width="60px">外链状态</th>
     <th 
     data-options="field:'displayOrder',halign:'center',align:'left',sortable:true"
     width="40px">排序</th>
     <th
     data-options="field:'keywords',halign:'center',align:'left',sortable:true"
     width="60px">关键字</th>
     <th
     data-options="field:'linkUrl',halign:'center',align:'left',sortable:true"
     width="160px">外链地址</th>
    <th
     data-options="field:'description',halign:'center',align:'left',sortable:true"
     width="160px">描述</th>
     <th
     data-options="field:'content',halign:'center',align:'left',sortable:true"
     width="260px">资讯内容</th>
     <th 
     data-options="field:'updateDate',halign:'center',align:'left',sortable:true"
     width="140px">更新时间</th>
     <th 
     data-options="field:'createDate',halign:'center',align:'left',sortable:true"
     width="140px">创建时间</th>
    <th
     data-options="field:'operation',halign:'center',align:'center',formatter:insert_browser_editAndDelAndWithdrawButton"
     width="230px">操作</th>
   </tr>
  </thead>
 </table>
</body>
</HTML>