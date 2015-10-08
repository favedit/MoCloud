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
       $("#getHtml").click();
        $("#config").submit();
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
</script>
<body bgcolor="#198bc9">
 <div id="cy_right" style="width:100%">
  <div class="right_title" style="width:100%">
   <span>增加业务资讯信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="add_btn"></a> <a
     href="/product/news/News.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">
  <form id="config"  enctype=multipart/form-data
   action="/product/news/News.wa?do=insert"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
<br>
   <table width="710" height="346" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
      <td width="54"><div align="left">资讯标题:</div></td>
      <td width="185"><input id="label" name="label" class="easyui-validatebox textbox"
        style="width:280px;height:20px"
        data-options="validType:'length[0,200]'" /></td>
    </tr>
    <tr>
     <td height="38"><div align="left">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态:</div></td>
     <td><div align="left">
       <input id="statusCdStr" class="easyui-combobox" name="statusCdStr" data-options="valueField:'value',textField:'text',
       data:[{'value':'0','text':'未知'},{'value':'1','text':'申请'},{'value':'2','text':'发布'},{'value':'3','text':'审核未通过'}]"/>  
     </div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">是否显示:</div></td>
     <td><div align="left">
       <input id="displayCdStr" class="easyui-combobox" name="displayCdStr" data-options="valueField:'value',textField:'text',
       data:[{'value':'0','text':'未知'},{'value':'1','text':'展示'},{'value':'2','text':'未展示'}]"/>  
      </div></td>
    </tr>
    <tr>
      <td  height="38" width="54"><div align="left">关键字:</div></td>
      <td><input id="keywords" name="keywords" class="easyui-validatebox textbox"
        style="width:280px;height:20px"
        data-options="validType:'length[0,800]'" /></td>
    </tr>
    <tr>
     <td height="38"><div align="left">图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片:</div></td>
     <td style="width:380px;"><div align="left">
       <input type="file" name="iconUrl" id="iconUrl"/>
      </div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述:</div></td>
     <td><div align="left">
     	<input id="description" name="description" class="easyui-textbox"
        data-options="multiline:true" style="height:100px;width:500px" />
      </div></td>
    </tr>
    <tr>
     <td><div align="left">资讯内容:</div></td>
     <td align="left">
        <textarea id="kindeditor_view" name="kindeditor_view" style="width:670px;height:300px"></textarea>
            <input style="display:none" id="content" name="content"/>
            <input type="button" style="display:none" id="getHtml" value="取得HTML" />
     </td>
    </tr>
   </table>
  </form>
 </div>
</body>
</HTML>