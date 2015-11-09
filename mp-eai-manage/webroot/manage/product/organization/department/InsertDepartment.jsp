<%@ include file='/apl/public.inc'%>
<HTML>

<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css"
 media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
</HEAD>
<script>
    function submitForm() {
       progress();
       if (!isValid()){
          closeProgress();
          return;
       }
       $("#config").submit();
       closeProgress();
    }
    $(function() {
       $('#parentId').combobox('clear');
       var url = "/manage/product/organization/department/Department.wa?do=selectAll&date=" + new Date().valueOf();
       var data = null;
       $.ajax({
          type: "POST",
          url: url,
          data: data,
          success: function(msg) {
             var result = toJsonObject(msg);
             $('#parentId').combobox('loadData', result);
             $('#parentId').combobox('select', result[0].ouid);
             var data={"parentId":result[0].ouid};
             //getAreaData(data);
          },
          fail: function() {
             alert("error");
           }
        });
   })
    //日历插件函数
    function myformatter(date) {
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        var d = date.getDate();
        return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
                + (d < 10 ? ('0' + d) : d);
    }
    function myparser(s) {
        if (!s)
            return new Date();
        var ss = (s.split('-'));
        var y = parseInt(ss[0], 10);
        var m = parseInt(ss[1], 10);
        var d = parseInt(ss[2], 10);
        if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
            return new Date(y, m - 1, d);
        } else {
            return new Date();
        }
    }
</script>

<body bgcolor="#198bc9">
 <div id="cy_right" style="width:100%">
  <div class="right_title" style="width:100%">
   <span>增加组织部门信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="add_btn"></a> <a
     href="/manage/product/organization/department/Department.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">

  <form id="config" enctype=multipart/form-data
   action="/manage/product/organization/department/Department.wa?do=insert"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <br>
   <table width="810" height="400" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
      <td width="86" height="38"><div align="left">英&nbsp;&nbsp;文&nbsp;&nbsp;名&nbsp;&nbsp;&nbsp;称:</div></td>
      <td width="380"><div align="left"><input id="name" name="name" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,80]'" />
      </div></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td width="86" height="38"><div align="left">中&nbsp;&nbsp;文&nbsp;&nbsp;名&nbsp;&nbsp;&nbsp;称:</div></td>
      <td><input id="label" name="label" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,80]'" /></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
     <td height="38"><div align="left">英文名称简写:</div></td>
     <td><div align="left">
       <input id="code" name="code" class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,8]'" />
     </div></td>
     <td>&nbsp;</td>
     </tr>
    <tr>
     <td height="38"><div align="left">是&nbsp;&nbsp;否&nbsp;&nbsp;有&nbsp;&nbsp;&nbsp;效:</div></td>
     <td><div align="left">
       <select style="width:380px;height:20px" id="validCd" class="easyui-combobox" name="validCd" style="width:200px;" data-options="editable:false">
             <option value="1">有效</option>
             <option value="2">无效</option>
        <select>
      </div></td>
     <td>&nbsp;</td>
    </tr>
    <tr>
     <td height="38"><div align="left">父&nbsp;&nbsp;级&nbsp;&nbsp;部&nbsp;&nbsp;门:</div></td>
     <td><div align="left">
       <input class="easyui-combobox" style="width:380px;" id="parentId" name="parentId" data-options="valueField:'ouid',textField:'label',editable:false"/>
      </div></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
     <td height="38"><div align="left">总&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数:</div></td>
     <td><div align="left">
       <input id="userCount"
        name="userCount"
        class="easyui-validatebox textbox notnull"
        style="width:380px;height:20px"
        data-options="required:true,validType:'length[0,11]'" />
      </div></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
     <td height="38"><div align="left">成&nbsp;&nbsp;立&nbsp;&nbsp;日&nbsp;&nbsp;期:</div></td>
     <td><div align="left">
       <input id="buildDate" style="width:200px" name="buildDate" class="easyui-datebox" data-options="editable:false"/>
      </div></td>
      <td>&nbsp;</td>
    </tr>
    <tr>
     <td height="38"><div align="left">描&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;述:</div></td>
     <td colspan="2"><div align="left">
       <input id="description" name="description" class="easyui-textbox"
        data-options="multiline:true,validType:'length[0,800]'" style="height:100px;width:700px" />
      </div></td>
    </tr>
   </table>
  </form>
 </div>
</body>

</HTML>