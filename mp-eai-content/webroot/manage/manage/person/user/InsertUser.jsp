<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
   </HEAD>
   <body style="margin-left:20px;margin-top:20px">
      <form id="form" method="post" action="/manage/person/user/Access.wa?do=insert" >
         <table align="left" border="0">
            <tr>
               <td align="left" style="width:60px">ip地址</td>
               <td align="left">
                  <input name="host_address" style="width:400px;text-align:left;"  value="" />
               </td>
            </tr>
            <tr>
               <td align="left" style="width:60px">说明</td>
               <td align="left">
                  <input name="label" style="width:400px;text-align:left;"  value="" />
               </td>
            </tr>
            <tr>
               <td align="left">帐号</td>
               <td align="left">
                  <input name="passport" style="width:400px;text-align:left;"  value="" />
               </td>
            </tr>
            <tr>
               <td align="left">密码</td>
               <td align="left">
                  <input name="password" style="width:400px;text-align:left;"  value="" />
               </td>
            </tr>
            <tr>
               <td align="left">权限状态</td>
               <td align="left">
                  <select name="access_cd">
                     <option value="1">允许</option>
                     <option value="2">禁止</option>
                  </select>
               </td>
            </tr>
            <tr>
               <td align="left">是否永久</td>
               <td align="left">
                  <select name="type_cd">
                     <option value="1">永久</option>
                     <option value="2">临时</option>
                  </select>
                  <font color="red">当权限禁止时，此下拉框的临时选项无效。</font>
               </td>
            </tr>
            <tr>
               <td align="left">开始时间</td>
               <td align="left">
                  <input class="easyui-datetimebox" name="begin_date" data-options="showSeconds:false" style="width:150px">
               </td>
            </tr>
            <tr>
               <td align="left">结束时间</td>
               <td align="left">
                  <input class="easyui-datetimebox" name="end_date" data-options="showSeconds:false" style="width:150px">
               </td>
            </tr>
            <tr>
               <td align="left">备注</td>
               <td align="left">
                  <textarea name="note" cols="50" rows="10"></textarea>
               </td>
            </tr>
            <tr>
               <td align="center" colspan="2">
                  <button style="width:50px;heigt:10px" type="submit" value="提交" />提交
                  <button onclick="javascript:history.back(-1);" style="width:50px;heigt:10px" type="submit" value="返回" />返回
               </td>
            </tr>
         </table>
      </form>
   </body>

   </HTML>