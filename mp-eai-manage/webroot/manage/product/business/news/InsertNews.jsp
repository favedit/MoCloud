<%@ include file='/apl/public.inc'%>
<HTML>
<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css"
 media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
<jsp:include page="/manage/common/kindediter.jsp"></jsp:include>
</HEAD>
<script>
    function submitForm() {
       if (!isValid())
          return;
       progress();
       
       var linkCd = $("#linkCd").combobox("getValue");
       if(linkCd>1){
          var linkUrl = $("#linkUrl").val();
          if(null==linkUrl||""==linkUrl){
             closeProgress();
             alert("外链地址不为空!");
             return false;
          }
       }
       
       var file = $("#iconUrl").val();
       if(""!=file){
          if(!/.(gif|jpg|jpeg|png|gif|jpg|png)$/.test(file)){
             closeProgress();
             alert("图片类型必须是.gif|jpg|jpeg|png|gif|jpg|png中的一种!");
             return false;
          }
          var fileSize = document.getElementById("iconUrl").files[0].size;
          if(fileSize>1024*1024){
             closeProgress();
             alert("请上传大小小于1M的等比例图片!");
             return false;
          }
       }
    $("#getHtml").click();
    $("#config").submit();
    closeProgress();
    }
   var editor;
   KindEditor.ready(function(K) {
             editor=K.create('#kindeditor_view', {
               uploadJson : '/manage/ajs/kindeditor-4.1.10/jsp/upload_json.jsp',
               items : kindeditor_items,
               resizeType : 1
             });
             K('input[id=getHtml]').click(function(e) {
                 $("#content").val(editor.html())
             });
             K('input[id=showHtml]').click(function(e) {
                $("#phoneShow").window("open");
                $("#phoneShow").html(editor.html());
              });
    });
   //选择图片
   function but(){
      $("#iconUrl").click();
   }   
   function changfile(obj){
      var a = obj.lastIndexOf("\\");
      $("#oiconUr").val(obj.substr(a+1,obj.length));
   }

</script>
<body bgcolor="#198bc9">
 <div id="cy_right" style="width:100%">
  <div class="right_title" style="width:100%">
   <span>增加业务资讯信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="add_btn"></a> <a
     href="/manage/product/business/news/News.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">
  <form id="config" enctype=multipart/form-data
   action="/manage/product/business/news/News.wa?do=insert"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
<br>
   <table width="810" height="346" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
      <td width="74"><div align="left">资讯标题:</div></td>
      <td width="185"><input id="label" name="label" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,200]'" /></td>
    </tr>
    <tr>
     <td height="38"><div align="left">是否展示:</div></td>
     <td><div align="left">
      <select  style="width:380px;height:20px" id="displayCd" class="easyui-combobox" name="displayCd" style="width:200px;" data-options="editable:false">
             <option value="1">展示</option>
             <option value="2">非展示</option>
        <select>
      </div></td>
    </tr>   
    <tr>
     <td height="38"><div align="left">外链状态:</div></td>
     <td><div align="left">
       <select style="width:380px;height:20px" id="linkCd" class="easyui-combobox" name="linkCd" style="width:200px;" data-options="editable:false">
             <option value="1">内容</option>
             <option value="2">外链</option>
        <select>
      </div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片:</div></td>
     <td style="width:380px;"><div align="left">
     <input type="file" name="iconUrl" id="iconUrl" style="display:none;" onchange="changfile(this.value)"/> 
     <input style="width:280px;" name="oiconUr" readonly="readonly" type="text" id="oiconUr" class="easyui-validatebox textbox">
     <input type="button" value="选择上传文件" onclick="but()"> <span style="color:red;">&nbsp;&nbsp;选择小于1M的等比例图片</span>
     </div></td>
    </tr>
    <tr>
      <td  height="38" width="74"><div align="left">排序:</div></td>
      <td><input id="displayOrder" name="displayOrder" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,11]'" /></td>
    </tr>
    <tr>
      <td  height="38" width="74"><div align="left">关键字:</div></td>
      <td><input id="keywords" name="keywords" class="easyui-validatebox textbox"
        style="width:380px;height:20px"
        data-options="validType:'length[0,800]'" /></td>
    </tr>
    <tr>
     <td height="38"><div align="left">外链地址:</div></td>
     <td><div align="left">
         <input id="linkUrl" name="linkUrl" class="easyui-validatebox textbox"
        style="width:380px;height:20px" data-options="validType:'length[0,800]'"/>
     </div></td>
    </tr>
    <tr>
      <td align="left" height="38">原始发布时间</td>
      <td align="left">
         <input class="easyui-datetimebox" id="recordDate" name="recordDate" data-options="showSeconds:true" style="width:380px">
      </td>
    </tr>
    <tr>
     <td height="38"><div align="left">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述:</div></td>
     <td><div align="left">
     	<input id="description" name="description" class="easyui-textbox"
        data-options="multiline:true" style="height:100px;width:700px" />
      </div></td>
    </tr>
    <tr>
     <td><div align="left">资讯内容:</div></td>
     <td align="left">
        <textarea id="kindeditor_view" name="kindeditor_view" style="width:700px;height:300px"></textarea>
            <input style="display:none" id="content" name="content"/>
            <input type="button" style="display:none" id="getHtml" value="取得HTML" />
     </td>
    </tr>
   </table>
  </form>
 </div>
</body>
</HTML>