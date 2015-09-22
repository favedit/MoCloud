<%@ include file='/apl/public.inc'%>
<HTML>

<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css"
 media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
</HEAD>
<script>
    function submitForm() {
        $("#config").submit();
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
   <span>增加客户信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="add_btn"></a> <a
     href="/product/financial/customer/Customer.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">

  <form id="config"
   action="/product/financial/customer/Customer.wa?do=insert"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>

   <table width="710" height="492" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="78" height="33"><div align="left">关&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联:</div></td>
     <td width="100"><div align="left">
       <input id="linkId" name="linkId" style="display:none" readonly="readonly" class="easyui-validatebox textbox"
        style="width:80px;height:20px;"
        data-options="validType:'length[0,20]'" /> <input id="adminId"
        name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
      </div></td>
     <td width="78"><div align="left">统&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;计:</div></td>
     <td width="142"><input id="statisticsId" name="statisticsId" style="display:none" readonly="readonly" class="easyui-validatebox textbox"
        style="width:80px;height:20px;"
        data-options="validType:'length[0,20]'" /></td>
     <td width="67">&nbsp;</td>
     <td width="245">&nbsp;</td>
    </tr>
    <tr>
      <td height="38"><div align="left">婚&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;否:</div></td>
      <td><div align="left">
      <select id="marryCd" name="marryCd">
         <option value="1">是</option>
         <option value="0" selected="selected">否</option>
      </select>
      </div></td>
      <td><div align="left">学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历:</div></td>
      <td><select id="educationCd" name="educationCd">
         <option value="0" selected="selected">学士</option>
         <option value="1">硕士</option>
         <option value="2">博士</option>
         <option value="3">博士后</option>
      </select></td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
    <tr>
     
     <td><div align="left">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:</div></td>
     <td><div align="left">
       <input id="businessCd" name="businessCd" class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td><td height="38"><div align="left">月&nbsp;收&nbsp;入:</div></td>
     <td><div align="left">
       <input id="incomeCd" name="incomeCd"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td>&nbsp;</td>
     <td>&nbsp;</td>
    </tr>
    <tr>
     <td height="38"><div align="left">客户投资总额:</div></td>
     <td><div align="left">
       <input id="investmentTotal"
        name="investmentTotal"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td><div align="left">客户投资次数:</div></td>
     <td><div align="left">
       <input id="investmentCount"
        name="investmentCount"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td height="38"><div align="left"></div></td>
     <td><div align="left"></div></td>

    </tr>
    <tr>
     <td height="38"><div align="left">客户赎回总额:</div></td>
     <td><div align="left">
       <input id="redemptionTotal"
        name="redemptionTotal"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td><div align="left">客户赎回次数:</div></td>
     <td><div align="left">
       <input id="redemptionCount"
        name="redemptionCount"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
    </tr>
    <tr>


     <td height="38"><div align="left">客户净投总额:</div></td>
     <td><div align="left">
       <input id="netinvestment"
        name="netinvestment"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td><div align="left">客户利息总额:</div></td>
     <td><div align="left">
       <input id="interestTotal" name="interestTotal"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td><div align="left">:</div></td>
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