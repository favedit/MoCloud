<%@ include file='/apl/public.inc'%>
<HTML>
<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
<script>
$(function(){  
   moduleSubmit(null);
   var pager = $('#module').datagrid().datagrid('getPager');
   pager.pagination({
         pageSize: 20,
         showPageList:false,
         onSelectPage:function(pageNumber){
             moduleSubmit(pageNumber);
         }
   });
});
function moduleSubmit(page){
   progress();
   var url = "/manage/system/user/module/Module.wa?do=selectDataByPage&date="+new Date().valueOf();
   var data = null;
   var code = $.trim($('#code').val()).replaceAll("'", "");
   if(code == "英文名称") code = null;
   if(page != null){
      url = "/manage/system/user/module/Module.wa?do=selectDataByPage&page="+page+"&date="+new Date().valueOf();
      data ={"code":code,"page":page};
   }
   $.ajax({
      type: "POST",
      url:url,
      data:data,
      success: function(msg){
         closeProgress();
         $('#module').datagrid('loadData', toJsonObject(msg));
      },
     fail:function(){
       closeProgress();
          alert("error");
      }
   });
}
function del(id){
   return confirmx('确定将此模块删除?',
   function(){
      var url = "/manage/system/user/module/Module.wa?do=delete&date="+new Date().valueOf();
      var data ={"id":id};
      $.getJSON(url,data,function(d){
         var result = toJsonObject(d);
         if(result=="1"){
               location.href = "/manage/system/user/module/Module.wa";
         }else if(result=="2"){
            alertx("此模块正被使用中，请先取消角色关联后再删除！","warning",function(){
               location.href = "/manage/module/Module.wa";
            });      
         }else{
            alertx("删除失败！","warning",function(){
               location.href = "/manage/system/user/module/Module.wa";
            });         
         }
      });   
   
   });
}
function edit(id){
   location.href = "/manage/system/user/module/Module.wa?do=updatePrepare&id="+id+"&date="+new Date().valueOf();  
}
</script>
</HEAD>
<body bgcolor="#198bc9">
<div id="cy_right" style="width:100%">
    <div class="right_title">
        <span>模块列表</span>
    </div>    
    <div class="btn_bar">
        <div class="nav_btn">
        <a href="/manage/system/user/module/Module.wa?do=insertPrepare" class="add_btn"></a>
        </div>
        <div class="nav_search">
            <input id="code" name="" type="text" onfocus="if(this.value=='英文名称'){this.value='';}this.style.color='#000000';" 
                   onblur="if(this.value=='') {this.value='英文名称';this.style.color='#ccc';}" style="color:#ccc" value="英文名称">
            <a onClick="moduleSubmit(0)" href="#" class="sear_btn"></a>
        </div>
  </div>  
</div>
<table id="module" fit='true' class="easyui-datagrid"
style="width:100%;height:100%;text-align:center;align:true " 
data-options="toolbar:'#cy_right',pagination:true,collapsible:true,singleSelect:true,remoteSort:false,multiSort:false">
   <thead>
         <tr>
               <th data-options="field:'ouid',halign:'center',align:'right'" width="60px" >编号</th>
                  <th data-options="field:'code',halign:'center',align:'left',sortable:true" width="400px" >英文名称</th>
                  <th data-options="field:'label',halign:'center',align:'left',sortable:true" width="300px" >模块名称</th>
                  <th data-options="field:'note',halign:'center',align:'left',sortable:true" width="200px" >备注</th>
                  <th data-options="field:'createDate',halign:'center',sortable:true" width="140px" >创建时间</th>
                  <th data-options="field:'make',halign:'center',align:'right',formatter:insert_editAndDelButton" width="150px">操作</th>
         </tr>
   </thead>
</table>
</body>
</HTML>