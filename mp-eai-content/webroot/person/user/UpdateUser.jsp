<%@ include file='/apl/public.inc' %>
   <jh:define source="&page.unit" alias="unit"></jh:define>
   <HTML>

   <HEAD>
      <script>
         function _onload() {
            var access_cd = document.getElementById("access_cd_temp").value;
            var accessList = document.getElementById("access_cd").options;
            for (i = 0; i < accessList.length; i++) {
               if (accessList[i].id == access_cd) 
               {
                  accessList[i].selected = true;
               }
            }
            var type_cd = document.getElementById("type_cd_temp").value;
            var typeList = document.getElementById("type_cd").options;
            for (i = 0; i < typeList.length; i++) {
               if (typeList[i].id == type_cd) 
               {
                  typeList[i].selected = true;
               }
            }
         }
      </script>
   </HEAD>

   <body onload="_onload();">
      <form id="form" method="post" action="/person/user/Access.wa?do=update">
         <table align="left" border="0">
            <tr>
               <td align="left" style="width:60px">ip地址</td>
               <td align="left">
                  <input name="id" type="hidden" style="width:400px;text-align:left;" value="<jh:write source='&unit.ouid' />" />
                  <input name="host_address" style="width:400px;text-align:left;" value="<jh:write source='&unit.hostAddress' />" />
               </td>
            </tr>
             <tr>
               <td align="left" style="width:60px">说明</td>
               <td align="left">
                  <input name="label" style="width:400px;text-align:left;"  value="<jh:write source='&unit.label' />" />
               </td>
            </tr>
            <tr>
               <td align="left">帐号</td>
               <td align="left">
                  <input name="passport" style="width:400px;text-align:left;" value="<jh:write source='&unit.passport' />" />
               </td>
            </tr>
            <tr>
               <td align="left">密码</td>
               <td align="left">
                  <input name="password" style="width:400px;text-align:left;" value="<jh:write source='&unit.password' />" />
               </td>
            </tr>
            <tr>
               <td align="left">权限状态</td>
               <td align="left">
                  <input type="hidden" id="access_cd_temp" value="<jh:write source='&unit.accessCd' />" />
                  <select name="access_cd" id="access_cd">
                     <option id="1" value="1">允许</option>
                     <option id="2" value="2">禁止</option>
                  </select>
               </td>
            </tr>
            <tr>
               <td align="left">是否永久</td>
               <td align="left">
                  <input hidden="hidden" id="type_cd_temp" value="<jh:write source='&unit.typeCd' />" />
                  <select name="type_cd" id="type_cd">
                     <option id="1" value="1">永久</option>
                     <option id="2" value="2">临时</option>
                  </select>
               </td>
            </tr>
            <tr>
               <td align="left">开始时间</td>
               <td align="left">
                  <input class="easyui-datetimebox" name="begin_date" data-options="required:true,showSeconds:false" style="width:150px" value="<jh:write source='&unit.beginDate' />">
                  <font color="red">格式：2015-07-24 12:12:12</font>
               </td>
            </tr>
            <tr>
               <td align="left">结束时间</td>
               <td align="left">
                  <input class="easyui-datetimebox" name="end_date" data-options="required:true,showSeconds:false" style="width:150px" value="<jh:write source='&unit.endDate' />">
                  <font color="red">格式：2015-07-24 12:12:12</font>
               </td>
            </tr>
            <tr>
               <td align="left">备注</td>
               <td align="left">
                  <textarea name="note" cols="50" rows="10"><jh:write source='&unit.note' /></textarea>
               </td>
            </tr>
            <tr>
               <td align="center" colspan="2">
                  <button style="width:50px;heigt:10px" type="submit" value="提交" />提交</td>
            </tr>
         </table>
      </form>
   </body>

   </HTML>