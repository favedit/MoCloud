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
   <span>增加理财师信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="add_btn"></a> <a
     href="/product/financial/marketer/Marketer.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">

  <form id="config"
   action="/product/financial/marketer/Marketer.wa?do=insert"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>

   <table width="710" height="492" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="38" height="33"><div align="left">名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</div></td>
     <td width="109"><div align="left">
       <input id="name" name="name" class="easyui-validatebox textbox"
        style="width:80px;height:20px;"
        data-options="validType:'length[0,20]'" /> <input id="adminId"
        name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
      </div></td>
     <td width="38"><div align="left">标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签:</div></td>
     <td width="120"><div align="left">
       <input id="label" name="label" class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td width="38"><div align="left">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态:</div></td>
     <td width="241"><div align="left">
       <input id="statusCd" name="statusCd"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,30]'" />
      </div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务:</div></td>
     <td><div align="left">
       <input id="rankLabel" name="rankLabel"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td><div align="left">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:</div></td>
     <td><div align="left">
       <input id="phone" name="phone" class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td><div align="left">所属部门:</div></td>
     <td><div align="left">
       <input id="departmentLabel" name="departmentLabel"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">客户投资总额:</div></td>
     <td><div align="left">
       <input id="customerInvestmentTotal"
        name="customerInvestmentTotal"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td><div align="left">客户投资次数:</div></td>
     <td><div align="left">
       <input id="customerInvestmentCount"
        name="customerInvestmentCount"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td height="38"><div align="left">客户投资时间:</div></td>
     <td><div align="left">
       <input id="customerInvestmentDate" name="customerInvestmentDate"
        class="easyui-datebox" style="width:100px;height:20px"
        data-options="formatter:myformatter,parser:myparser" />
      </div></td>

    </tr>
    <tr>
     <td height="38"><div align="left">客户赎回总额:</div></td>
     <td><div align="left">
       <input id="customerRedemptionTotal"
        name="customerRedemptionTotal"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td><div align="left">客户赎回次数:</div></td>
     <td><div align="left">
       <input id="customerRedemptionCount"
        name="customerRedemptionCount"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td><div align="left">客户赎回时间:</div></td>
     <td><div align="left">
       <input id="customerRedemptionDate" name="customerRedemptionDate"
        class="easyui-datebox" style="width:100px;height:20px"
        data-options="formatter:myformatter,parser:myparser" />
      </div></td>
    </tr>
    <tr>


     <td height="38"><div align="left">客户净投总额:</div></td>
     <td><div align="left">
       <input id="customerNetinvestmentTotal"
        name="customerNetinvestmentTotal"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td><div align="left">客户利息总额:</div></td>
     <td><div align="left">
       <input id="customerInterestTotal" name="customerInterestTotal"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
     <td><div align="left">客户业绩总额:</div></td>
     <td><div align="left">
       <input id="customerPerformanceTotal"
        name="customerPerformanceTotal"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'" />
      </div></td>
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