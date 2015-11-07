<%@ include file='/apl/public.inc' %>
   <jh:define source="&page.unit" alias="unit"></jh:define>
   <HTML>

   <HEAD>
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <script>
         function _onload() {
            var access_cd = document.getElementById("access_cd_temp").value;
            var accessList = document.getElementById("access_cd").options;
            for (i = 0; i < accessList.length; i++) {
               if (accessList[i].id == access_cd) {
                  accessList[i].selected = true;
               }
            }
            var type_cd = document.getElementById("type_cd_temp").value;
            var typeList = document.getElementById("type_cd").options;
            for (i = 0; i < typeList.length; i++) {
               if (typeList[i].id == type_cd) {
                  typeList[i].selected = true;
               }
            }
            var oriBeginDate = $("#oriBeginDate").html();
            oriBeginDate = replaceNbsp(oriBeginDate);
            $('#begin_date').datetimebox({
               value: oriBeginDate,
               required: false,
               showSeconds: false
            });
            var oriEndDate = $("#oriEndDate").html();
            oriBeginDate = replaceNbsp(oriBeginDate);
            $('#end_date').datetimebox({
               value: oriEndDate,
               required: false,
               showSeconds: false
            });
         }

         function doSubmit() {
            progress(); 
            var passport = $("#passport").val();
            if (passport.length > 18) {
               alert("账号不能超过18位");
               return;
            }
            if (!ischinese(passport)) {
               alert("账号和密码，由字母及数字或下划线组成！");
               return;
            }
            form.submit();
            closeProgress();
         }
      </script>
   </HEAD>

   <body onload="_onload();">
      <div class="easyui-panel" fit='true'>
         <form id="form" method="post" action="/manage/product/user/whitelists/Access.wa?do=update">
            <div id="cy_right" style="width:100%">
               <div class="right_title"> <span>增加用户</span> </div>
               <div class="btn_bar">
                  <div class="nav_btn">
                     <a href="javascript:doSubmit();" class="sub_btn"></a>
                     <a href="javascript:history.back(-1);" class="back_btn"></a>
                  </div>
                  <div class="nav_search"></div>
               </div>
            </div>
            <div class='cy_edit_panel'>
               <table align="left" border="0">
                  <tr>
                     <td align="left" style="width:60px">ip地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:</td>
                     <td align="left">
                        <input name="id" type="hidden" style="width:400px;text-align:left;" value="<jh:write source='&unit.ouid' />" />
                        <input name="host_address" style="width:400px;text-align:left;" value="<jh:write source='&unit.hostAddress' />" />
                     </td>
                  </tr>
                  <tr>
                     <td align="left" style="width:60px">说&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;明:</td>
                     <td align="left">
                        <input name="label" style="width:400px;text-align:left;" value="<jh:write source='&unit.label' />" />
                     </td>
                  </tr>
                  <tr>
                     <td align="left">帐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</td>
                     <td align="left">
                        <input id="passport" name="passport" style="width:200px;text-align:left;" value="<jh:write source='&unit.passport' />" />
                        <font color="red">只支持英文、数字和下划线，长度18位以内</font>
                     </td>
                  </tr>
                  <tr>
                     <td align="left">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
                     <td align="left">
                        <input name="password" style="width:200px;text-align:left;" value="<jh:write source='&unit.password' />" />
                        <font color="red">不支持单引号'分号;百分号%</font>
                     </td>
                  </tr>
                  <tr>
                     <td align="left">权限状态:</td>
                     <td align="left">
                        <input type="hidden" id="access_cd_temp" value="<jh:write source='&unit.accessCd' />" />
                        <select name="access_cd" id="access_cd">
                           <option id="1" value="1">允许</option>
                           <option id="2" value="2">禁止</option>
                        </select>
                     </td>
                  </tr>
                  <tr>
                     <td align="left">是否永久:</td>
                     <td align="left">
                        <input hidden="hidden" id="type_cd_temp" value="<jh:write source='&unit.typeCd' />" />
                        <select name="type_cd" id="type_cd">
                           <option id="1" value="1">永久</option>
                           <option id="2" value="2">临时</option>
                        </select>
                        <font color="red">当权限禁止时，此下拉框的临时选项无效。</font>
                     </td>
                  </tr>
                  <tr>
                     <td align="left">开始时间:</td>
                     <td align="left">
                        <input class="easyui-datetimebox" name="begin_date" id="begin_date" data-options="showSeconds:false" style="width:150px" value=""><span id="oriBeginDate" style="display:none"><jh:date source='&unit.beginDate' format="YYYY-MM-DD HH24:mi:ss"/></span> -
                        <input class="easyui-datetimebox" name="end_date" id="end_date" data-options="showSeconds:false" style="width:150px" value=""><span id="oriEndDate" style="display:none"><jh:date source='&unit.endDate' format="YYYY-MM-DD HH24:mi:ss"/></span>
                     </td>
                  </tr>
                  <tr>
                     <td align="left">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
                     <td align="left">
                        <textarea name="note" cols="80" rows="10">
                           <jh:write source='&unit.note' format="text" />
                        </textarea>
                     </td>
                  </tr>
               </table>
            </div>
         </form>
      </div>
   </body>

   </HTML>