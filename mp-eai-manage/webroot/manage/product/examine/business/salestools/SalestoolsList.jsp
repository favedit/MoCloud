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
       var url = "/manage/product/examine/business/salestools/Salestools.wa?do=select&date="
               + new Date().valueOf();
       var data = null;
       var label = $.trim($('#label').val()).replaceAll("'", "");
       if (label == "销售工具标题") label = null;
       if (page != null) {
           url = "/manage/product/examine/business/salestools/Salestools.wa?do=select&page="
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
   function checkTask(flag){
       var ss = [];
       var rows = $('#logicNews').datagrid('getSelections');
       if(rows.length != 0){
          for(var i=0; i<rows.length; i++){
             var row = rows[i];
             ss.push(row.ouid);
          }
          location.href= "/manage/product/examine/business/salestools/Salestools.wa?do=checking&newsIds="+ss+"&flag="+flag;
       }
   }
   function showPhoto(makeUrl){
      if(makeUrl!=null&&makeUrl.length>0){
         return "<img src="+makeUrl+" height=55px width=55px/>";
      }
   }
   function phoneInfo(ouid,linkCd,linkUrl){
      var l=(screen.availWidth-500)/2;
      var t=(screen.availHeight-500)/2;
      if(linkCd==2){
         window.open(linkUrl,'_blank','height=640px,width=360px,top='+t+',left='+l+',toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
      }else{
         window.open('/manage/product/examine/business/salestools/Salestools.wa?do=getDescription&ouid='+ouid,'_blank','height=640px,width=360px,top='+t+',left='+l+',toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no');
      }
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
   <span>销售工具未审核列表</span>
  </div>
  <div class="btn_bar" style="min-width:200px;min-height:5px;overflow:hidden;">
     <div class="nav_btn">
           <a href="javascript:checkTask('1');" class="ty_btn"></a>
           <a href="javascript:checkTask('0');" class="bty_btn"></a>
      </div>
      <div class="nav_search">
         <input id="label" name="label" type="text"
           onfocus="if(this.value=='销售工具标题'){this.value='';}this.style.color='#000000';"
           onblur="if(this.value=='') {this.value='销售工具标题';this.style.color='#ccc';}"
           style="color: #ccc" value="销售工具标题"> <a onClick="doSubmit(0)"
           href="#" class="sear_btn"></a>
      </div>
  </div>
 </div>
 <table id="logicNews" class="easyui-datagrid" fit='true'
   style="align: true"
   data-options="toolbar:'#cy_right',pagination:true,collapsible:true,remoteSort:false,multiSort:false,striped: true">
  <thead>
   <tr>
    <th data-options="field:'ck',checkbox:true">全选</th>
     <th data-options="field:'ouid',halign:'center',align:'right'"
     width="55px">编号</th>
     <th
     data-options="field:'makeUrl',halign:'center',align:'left',formatter:showPhoto"
     width="55px">图片</th>
     <th
     data-options="field:'label',halign:'center',align:'left',sortable:true"
     width="571px">销售工具标题</th>
     <th
     data-options="field:'statusCdStr',halign:'center',align:'left',sortable:true"
     width="70px">状态</th>
     <th
     data-options="field:'displayCdStr',halign:'center',align:'left',sortable:true"
     width="60px">是否显示</th>
     <th
     data-options="field:'linkCdStr',halign:'center',align:'left',sortable:true"
     width="60px">外链状态</th>
     <th 
     data-options="field:'displayOrder',halign:'center',align:'left',sortable:true"
     width="70px">排序</th>
     <th
     data-options="field:'keywords',halign:'center',align:'left',sortable:true"
     width="371px">关键字</th>
     <th 
     data-options="field:'updateDate',halign:'center',align:'left',sortable:true"
     width="132px">更新时间</th>
     <th 
     data-options="field:'createDate',halign:'center',align:'left',sortable:true"
     width="132px">创建时间</th>
     <th
     data-options="field:'operation',halign:'center',align:'center',formatter:insert_BrowserButton"
     width="88px">操作</th>
   </tr>
  </thead>
 </table>
 <div id="w" style="width:500px;height:200px;padding:5px;">
 </div>
</body>
</HTML>