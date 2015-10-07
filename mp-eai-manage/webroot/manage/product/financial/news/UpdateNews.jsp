<%@ include file='/apl/public.inc'%>
<jh:define source="&page.unit" alias="unit"></jh:define>
<HTML>

<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css"
 media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
</HEAD>
<style> 
  form {
  margin: 0;
  }
  textarea {
  display: block;
  }
  </style> 

<script>
    $(function(){
       var image = $("#image").val()
       $("#oriIcon").attr("src",image);
    });
    function submitForm() {
        $("#logicNews").submit();
    }
    var uploadFile = function(){
       var path = $('#iconUrl').val();
       var len = path.length;
       if(len>=200){
          alert("文件地址过长，请重新上传！");
          return;
       }
       $("#oriIcon").attr("src",path);
       alert("上传成功！");
    }
    var removeFile = function(){
       $('#iconUrl').val("");
       $('#iconUrl').show();
       $('#oiconUr').val("");
       $('#oiconUr').hide();
       $('#imgdiv').hide();
       $("#oriIcon").attr("src","");
       $("#removeFile").hide();
       //$('#uploadFile').show();
    }
</script>

<body bgcolor="#198bc9">
 <div id="cy_right" style="width:100%">
  <div class="right_title" style="width:100%">
   <span>修改业务资讯信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="sub_btn"></a> <a
     href="/product/financial/news/News.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">
  <form id="logicNews" enctype=multipart/form-data
   action="/product/financial/news/News.wa?do=update"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <table width="710" height="346" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
      <td width="54" height="38"><div align="left">资讯标题:</div></td>
      <td style="width:380px;"><input id="label" name="label" class="easyui-validatebox textbox"
        style="width:380px;height:20px" readonly="readonly"
        value="<jh:write source='&unit.label'/>" />
        <input id="adminId" name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
        <input id="ouid" name="ouid" style="display:none"
        value="<jh:write source='&unit.ouid'/>" />
        <input id="image" name="image" style="display:none"
        value="<jh:write source='&unit.imageName'/>" />
      </td>
      <td rowspan="4" style="width:140px;" ><div align="left" id="imgdiv">
       <img width="140" height="140" id="oriIcon"></div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态:</div></td>
     <td><div align="left">
       <input id="statusCdStr" class="easyui-combobox" name="statusCdStr" data-options="valueField:'value',textField:'text',
       data:[{'value':'0','text':'未知'},{'value':'1','text':'申请'},{'value':'2','text':'发布'},{'value':'3','text':'审核未通过'}]"
       value="<jh:write source='&unit.statusCdStr'/>"/>  
     </div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">是否显示:</div></td>
     <td><div align="left">
       <input id="displayCdStr" class="easyui-combobox" name="displayCdStr" data-options="valueField:'value',textField:'text',
       data:[{'value':'0','text':'未知'},{'value':'1','text':'展示'},{'value':'2','text':'未展示'}]"
       value="<jh:write source='&unit.displayCdStr'/>"/>   
      </div></td>
    </tr>
    <tr>
      <td height="38"><div align="left">关键字:</div></td>
      <td><input id="keywords" name="keywords" class="easyui-validatebox textbox"
        style="width:280px;height:20px"
        data-options="validType:'length[0,800]'"   value="<jh:write source='&unit.keywords'/>"/></td>
    </tr>
    
    <tr>
     <td height="38"><div align="left">图&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片:</div></td>
     <td style="width:380px;"><div align="left">
       <input type="file" name="iconUrl" id="iconUrl" style="display:none;" multiple="multiple"/>
       <input id="oiconUr" name="oiconUr" class="easyui-validatebox textbox" value="<jh:write source='&unit.iconUrl'/>"/>
       <a id="uploadFile" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="uploadFile()"  style="display:none;">上传</a>
       <a id="removeFile" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="removeFile()">删除</a>
      </div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述:</div></td>
     <td colspan="3"><div align="left">
      <input id="description" name="description" class="easyui-textbox"
        data-options="multiline:true" value="<jh:write source='&unit.description'/>" 
        style="height:100px;width:590px" />
      </div></td>
    </tr>
    <tr>
     <td><div align="left">资讯内容:</div></td>
     <td colspan="3"><div align="left">
       <input id="content" name="content" class="easyui-textbox"
        data-options="multiline:true" value="<jh:write source='&unit.content'/>"
        style="height:100px;width:590px" />
     </div></td>
    </tr>
   </table>
  </form>
 </div>
</body>
</HTML>