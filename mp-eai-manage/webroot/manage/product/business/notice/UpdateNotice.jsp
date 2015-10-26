<%@ include file='/apl/public.inc'%>
<jh:define source="&page.unit" alias="unit"></jh:define>
<HTML>

<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css"
 media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
<jsp:include page="/manage/common/kindediter.jsp"></jsp:include>
</HEAD>
<style> 
  form {
      margin: 0;
  }
  textarea {
      display: block;
  }
  #manage_id{
      width:100%;
      margin-top:-10px;
      margin-left:-10px;
      padding-bottom:20px;
      height:100%;
  }
</style> 
<script>
    $(function(){
       $('#displayCd').combobox("select", $('#oldDisplayCd').val());
       $('#linkCd').combobox("select", $('#oldLinkCd').val());
       var conte = $("#conte").val();
       $("#kindeditor_view").val(conte);
    });
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
       
    $("#getHtml").click();
    $("#logicNews").submit();
    closeProgress();
    }
    var editor;
    KindEditor.ready(function(K) {
       editor=K.create('#kindeditor_view', {
           uploadJson : '/manage/ajs/kindeditor-4.1.10/jsp/upload_json.jsp',
           items : kindeditor_items,
           resizeType : 1,
           allowFileManager : true,
           afterCreate : function() {
              var self = this;
              K.ctrl(document, 83, function() {
                 return false;
              });
              K.ctrl(self.edit.doc, 83, function() {
                 return false;
              });
           }
       });
       K('input[id=getHtml]').click(function(e) {
           $("#content").val(editor.html())
       });
      K('input[id=showHtml]').click(function(e) {	
         $("#phoneShow").window("open");
         $("#phoneShow").html(editor.html());
      });
   });
   function phoneInfo(){
      $("#getHtml").click();
      var content = $("#content").val();
      var l=(screen.availWidth-500)/2;
      var t=(screen.availHeight-500)/2;
      var w = screen.availWidth*7/19;
      var h = screen.availHeight*12/19;
      openwin(content,l,t,w,h);
   }
   function openwin(content,l,t,w,h) 
   { 
    OpenWindow=window.open("", '_blank','height='+h+',width='+w+',top='+t+',left='+l+',toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no'); 
    //写成一行 
    OpenWindow.document.write("<TITLE>用户公告内容</TITLE>") 
    OpenWindow.document.write("<BODY BGCOLOR=#ffffff>") 
    OpenWindow.document.write(content) 
    OpenWindow.document.write("</BODY>") 
    OpenWindow.document.write("</HTML>") 
    OpenWindow.document.close() 
   } 
</script>

<body bgcolor="#198bc9">
<div id="manage_id">
 <div id="cy_right" style="width:100%">
  <div class="right_title" style="width:100%">
   <span>修改公告信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
      <a href="#" onClick="submitForm()" class="sub_btn"></a> 
      <a href="/manage/product/business/notice/Notice.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">
  <form id="logicNews" enctype=multipart/form-data
   action="/manage/product/business/notice/Notice.wa?do=update"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <table width="800" height="346" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
      <td width="54" height="38"><div align="left">公告标题:</div></td>
      <td style="width:380px;"><input id="label" name="label" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px" data-options="required:true,validType:'length[0,200]'" 
        value="<jh:write source='&unit.label'/>" />
        <input id="adminId" name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
        <input id="ouid" name="ouid" style="display:none"
        value="<jh:write source='&unit.ouid'/>" />
        <input id="conte" name="conte" style="display:none"
        value="<jh:write source='&unit.content'/>" />
      </td>
    </tr>
    <tr>
     <td height="38"><div align="left">是否展示:</div></td>
     <td style="width:380px;"><div align="left">
       <input type="hidden" id="oldDisplayCd" value="<jh:write source='&unit.displayCd'/>">
       <input style="width:380px;height:20px" id="displayCd" class="easyui-combobox" name="displayCd" data-options="valueField:'value',textField:'text',
       data:[{'value':'1','text':'展示'},{'value':'2','text':'非展示'}],editable:false"/>
      </div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">外链状态:</div></td>
     <td><div align="left">
       <input type="hidden" id="oldLinkCd" value="<jh:write source='&unit.linkCd'/>">
       <input style="width:380px;height:20px" id="linkCd" class="easyui-combobox" name="linkCd" data-options="valueField:'value',textField:'text',
       data:[{'value':'1','text':'内容'},{'value':'2','text':'外链'}],editable:false"/>  
      </div></td>
    </tr>
    <tr>
      <td  height="38" width="74"><div align="left">排序:</div></td>
      <td><input id="displayOrder" name="displayOrder" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,11]'"  value="<jh:write source='&unit.displayOrder'/>"/></td>
    </tr>
    <tr>
     <td height="38"><div align="left">外链地址:</div></td>
     <td><div align="left">
         <input id="linkUrl" name="linkUrl" class="easyui-validatebox textbox"
        style="width:380px;height:20px" data-options="validType:'length[0,800]'" value="<jh:write source='&unit.linkUrl'/>"/>
     </div></td>
     <td style="text-align:center;" >
      <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" style="width:80px" onclick="phoneInfo()">浏览</a>
     </td>
    </tr>
    <tr>
     <td height="38"><div align="left">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述:</div></td>
     <td colspan="2"><div align="left">
      <input id="description" name="description" class="easyui-textbox"
        data-options="multiline:true" value="<jh:write source='&unit.description'/>" 
        style="height:100px;width:700px" />
      </div></td>
    </tr>
    <tr>
     <td><div align="left">公告内容:</div></td>
     <td align="left" colspan="2">
        <textarea id="kindeditor_view" name="kindeditor_view" style="width:700px;height:300px" ></textarea>
          <input style="display:none" id="content" name="content" />
          <input type="button" style="display:none" id="getHtml" value="取得HTML" />
     </td>
     <td></td>
    </tr>
   </table>
  </form>
 </div>
</div>
</body>
</HTML>