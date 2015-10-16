<%@ include file='/apl/public.inc'%>
<jh:define source="&page.unit" alias="unit"></jh:define>
<HTML>

<HEAD>
<link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css"
 media="screen" />
<jsp:include page="/manage/common/jeui.jsp"></jsp:include>
</HEAD>
<script>
    function submitForm() {
        if (!isValid())
            return;
        progress();
        var url = "/manage/product/financial/department/Department.wa?do=update&date="
                + new Date().valueOf();
        var investmentDate = $('#investmentDate').datebox('getValue');
        var redemptionDate = $('#redemptionDate').datebox('getValue');
        var data = {
            "level" : $('#level').val(),
            "ovld" : $('#ovld').val(),
            "name" : $('#name').val(),
            "label" : $('#label').val(),
            "leaderLabel" : $('#leaderLabel').val(),
            "leaderPhone" : $('#leaderPhone').val(),
            "departmentLabel" : $('#departmentLabel').val(),
            "provinceId" : $('#provinceId').val(),
            "cityId" : $('#cityId').val(),
            "regionId" : $('#regionId').val(),
            "locationLongitude" : $('#locationLongitude').val(),
            "locationLatitude" : $('#locationLatitude').val(),
            "departmentPhone" : $('#departmentPhone').val(),
            "investmentTotal" : $('#investmentTotal').val(),
            "investmentCount" : $('#investmentCount').val(),
            "investmentDate" : investmentDate,
            "redemptionTotal" : $('#redemptionTotal').val(),
            "redemptionCount" : $('#redemptionCount').val(),
            "redemptionDate" : redemptionDate,
            "interestTotal" : $('#interestTotal').val(),
            "performanceTotal" : $('#performanceTotal').val(),
            "netinvestmentTotal" : $('#netinvestmentTotal').val(),
            "ouid" : $('#ouid').val(),
            "code" : $('#code').val(),
            "detailAddress" : $('#detailAddress').val(),
            "note" : $('#note').val()
        };
        $.ajax({
            type : "POST",
            url : url,
            data : data,
            success : function(msg) {
                closeProgress();
                var result = toJsonObject(msg);
                location.href = "/manage/product/financial/department/Department.wa";
            },
            fail : function() {
                closeProgress();
                alert("error");
            }
        });
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
   <span>修改部门信息</span>
  </div>
  <div class="btn_bar">
   <div class="nav_btn">
    <a href="#" onClick="submitForm()" class="sub_btn"></a> <a
     href="/manage/product/financial/department/Department.wa" class="back_btn"></a>
   </div>
   <div class="nav_search"></div>
  </div>
 </div>
 <div class="easyui-panel" fit='true' data-options="border:false">

  <form id="config"
   action="/manage/product/financial/department/Department.wa?do=insert"
   method="post" align="center">
   <font style="color:red;"><jh:write source='&page.result' /></font>
   <table width="710" height="551" border="0" align="left"
    cellpadding="0" cellspacing="0" style=" margin-left:10px">
    <tr>
     <td width="56" height="38"><div align="left">级&nbsp;&nbsp;&nbsp;&nbsp;别:</div></td>
     <td width="160"><div align="left">
       <input id="level" name="level"
        value="<jh:write source='&unit.level'/>" maxLength=5 type="text"
        class="easyui-numberbox" style="width:50px;height:20px"
        data-options="validType:'length[0,100]'" /><input id="ouid"
        name="ouid" style="display:none"
        value="<jh:write source='&unit.ouid'/>">
      </div></td>
     <td width="56"><div align="left">是否删除:</div></td>
     <td width="160"><div align="left">
       <select id="ovld" class="easyui-combobox" name="ovld"
        style="width:50px;">
        <option value="1">否</option>
        <option value="0" selected="selected">是</option>
       </select>
      </div></td>

     <td width="56"><div align="left"></div></td>
     <td width="222"><div align="left"></div></td>
    </tr>
    <tr>
     <td height="20"><div align="left">名&nbsp;&nbsp;&nbsp;&nbsp;称:</div></td>
     <td><div align="left">
       <input id="name" name="name" class="easyui-validatebox textbox"
        style="width:80px;height:20px;"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.name'/>" />
      </div></td>
     <td><div align="left">标&nbsp;&nbsp;&nbsp;&nbsp;</div></td>
     <td><div align="left">
       <input id="label" name="label" class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.label'/>" />
      </div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">负&nbsp;责&nbsp;人:</div></td>
     <td><div align="left">
       <input id="leaderLabel" name="leaderLabel"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.leaderLabel'/>" />
      </div></td>
     <td><div align="left">负责人电话:</div></td>
     <td><div align="left">
       <input id="leaderPhone" name="leaderPhone"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.leaderPhone'/>" />
      </div></td>
     <td><div align="left">所属公司:</div></td>
     <td><div align="left">
       <input id="departmentLabel" name="departmentLabel"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.departmentLabel'/>" />
      </div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">省&nbsp;&nbsp;&nbsp;&nbsp;份:</div></td>
     <td><div align="left">
       <select id="provinceId" class="easyui-combobox" name="provinceId"
        style="width:80px;">
        <option value="0">山西</option>
        <option value="1">陕西</option>
        <option value="2">黑龙江</option>
        <option value="4" selected="selected">北京</option>
       </select> <input id="provinceLabel" name="provinceLabel" type="hidden"
        value="北京" />
      </div></td>
     <td><div align="left">城&nbsp;&nbsp;&nbsp;&nbsp;市:</div></td>
     <td><div align="left">
       <select id="cityId" class="easyui-combobox" name="cityId"
        style="width:80px;">
        <option value="0" selected="selected">大同</option>
        <option value="1">哈尔滨</option>
       </select>
      </div></td>
     <td><div align="left">所属区域:</div></td>
     <td><div align="left">
       <select id="regionId" class="easyui-combobox" name="regionId"
        style="width:80px;">
        <option value="0" selected="selected">海淀区</option>
        <option value="1">昌平区</option>
       </select>
      </div></td>
    </tr>
    <tr>
     <td><div align="left">位置经度:</div></td>
     <td><div align="left">
       <input id="locationLongitude" name="locationLongitude"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.locationLongitude'/>" />
      </div></td>
     <td height="38"><div align="left">位置纬度:</div></td>
     <td><div align="left">
       <input id="locationLatitude" name="locationLatitude"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.locationLatitude'/>" />
      </div></td>

     <td><div align="left">部门电话:</div></td>
     <td><div align="left">
       <input id="departmentPhone" name="departmentPhone"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.departmentPhone'/>" />
      </div></td>
    </tr>
    <tr>
     <td height="38"><div align="left">投资总额:</div></td>
     <td><div align="left">
       <input id="investmentTotal" name="investmentTotal"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.investmentTotal'/>" />
      </div></td>
     <td><div align="left">投资次数:</div></td>
     <td><div align="left">
       <input id="investmentCount" name="investmentCount"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.investmentCount'/>" />
      </div></td>
     <td height="38"><div align="left">投资时间:</div></td>
     <td><div align="left">
       <input id="investmentDate" name="investmentDate" type="text"
        class="easyui-datebox" style="width:100px;height:20px"
        data-options="formatter:myformatter,parser:myparser"
        value="<jh:write source='&page.strInvestment'/>" />
      </div></td>

    </tr>
    <tr>
     <td height="38"><div align="left">赎回总额:</div></td>
     <td><div align="left">
       <input id="redemptionTotal" name="redemptionTotal"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.redemptionTotal'/>" />
      </div></td>
     <td><div align="left">赎回次数:</div></td>
     <td><div align="left">
       <input id="redemptionCount" name="redemptionCount"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.redemptionCount'/>" />
      </div></td>
     <td><div align="left">赎回时间:</div></td>
     <td><div align="left">
       <input id="redemptionDate" name="redemptionDate"
        class="easyui-datebox" style="width:100px;height:20px"
        data-options="formatter:myformatter,parser:myparser"
        value="<jh:write source='&page.redemptionDate'/>" />
      </div></td>
    </tr>
    <tr>


     <td><div align="left">利息总额:</div></td>
     <td><div align="left">
       <input id="interestTotal" name="interestTotal"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.interestTotal'/>" />
      </div></td>
     <td><div align="left">业绩总额:</div></td>
     <td><div align="left">
       <input id="performanceTotal" name="performanceTotal"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.performanceTotal'/>" />
      </div></td>
     <td><div align="left">净投总额:</div></td>
     <td><div align="left">
       <input id="netinvestmentTotal" name="netinvestmentTotal"
        class="easyui-validatebox textbox"
        style="width:80px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.netinvestmentTotal'/>" />
      </div></td>
    </tr>
    <tr>
     <td height="20"><div align="left">代码:</div></td>
     <td><div align="left">
       <input id="code" name="code" class="easyui-validatebox textbox"
        style="width:160px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.code'/>" /> <input id="adminId"
        name="adminId" style="display:none"
        value="<jh:write source='&basePage.userId'/>" />
      </div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></div></td>
     <td><div align="left"></td>
    </tr>
    <tr>
     <td height="38"><div align="left">详细地址:</div></td>
     <td colspan="5"><div align="left">
       <input id="detailAddress" name="detailAddress"
        class="easyui-validatebox textbox"
        style="width:320px;height:20px"
        data-options="validType:'length[0,100]'"
        value="<jh:write source='&unit.detailAddress'/>" />
      </div>
      <div align="right"></div>
      <div align="left"></div>
      <div align="right"></div>
      <div align="left"></div></td>
    </tr>
    <tr>
     <td height="61"><div align="left">备注:</div></td>
     <td colspan="5"><div align="left">
       <input id="note" name="note" class="easyui-textbox"
        data-options="multiline:true" style="height:100px;width:500px"
        value="<jh:write source='&unit.note'/>" />
      </div></td>
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
     <td><div align="left"></div></td>
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