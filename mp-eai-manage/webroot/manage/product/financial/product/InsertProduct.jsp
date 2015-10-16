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
       $("#config").submit();
       closeProgress();
    }
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
   <span>增加产品信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="add_btn"></a> <a
     href="/manage/product/financial/product/Product.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">

  <form id="config"
   action="/manage/product/financial/product/Product.wa?do=insert"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
<br>
   <table width="710" height="446" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
      <td width="56" height="38"><div align="left">名&nbsp;&nbsp;&nbsp;&nbsp;称:</div></td>
      <td width="103"><div align="left"><input id="name" name="name" class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
      <td width="54"><div align="left">标&nbsp;&nbsp;&nbsp;&nbsp;签:</div></td>
      <td width="185"><input id="label" name="label" class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" /></td>
      <td width="67">&nbsp;</td>
      <td width="245">&nbsp;</td>
    </tr>
    <tr>
     
     <td><div align="left">出租人:</div></td>
     <td><div align="left">
       <input id="rentPerson" name="rentPerson" class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td><td height="30"><div align="left">承租人:</div></td>
     <td><div align="left">
       <input id="tenantPerson" name="tenantPerson"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
    </tr>
    <tr>
     <td height="38"><div align="left">投资期限:</div></td>
     <td><div align="left">
       <input id="timeLimit"
        name="timeLimit"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td><div align="left">预期年收益率:</div></td>
     <td><div align="left">
       <input id="annualRateOfReturn"
        name="annualRateOfReturn"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td height="38"><div align="left"></div></td>
     <td><div align="left"></div></td>

    </tr>
    <tr>


     <td height="19"><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">备注:</div></td>
     <td colspan="5"><div align="left">
       <input id="note" name="note" class="easyui-textbox"
        data-options="multiline:true" style="height:100px;width:500px" />
      </div></td>
    </tr>
    <tr>
     <td height="38"><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
    </tr>
    <tr>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
    </tr>
    <tr>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
    </tr>
    <tr>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
    </tr>
    <tr>
     <td height="38"><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
    </tr>
   </table>

  </form>
 </div>
</body>

</HTML>