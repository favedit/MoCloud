<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      
   </HEAD>
   <body>
      <form id="form" method="post" action="/person/user/Access.wa?do=insert" >
         <table align="left" border="0">
            <tr>
               <td align="left" style="width:60px">ip地址</td>
               <td align="left">
                  <input name="host_address" style="width:400px;text-align:left;"  value="" />
               </td>
            </tr>
            <tr>
               <td align="left">ip地址端口</td>
               <td align="left">
                  <input name="host_port" style="width:400px;text-align:left;"  value="" />
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
                     <option value="0">未知</option>
                     <option value="1">允许</option>
                     <option value="2">禁止</option>
                  </select>
               </td>
            </tr>
            <tr>
               <td align="left">是否永久</td>
               <td align="left">
                  <select name="type_cd">
                     <option value="0">未知</option>
                     <option value="1">永久</option>
                     <option value="2">临时</option>
                  </select>
               </td>
            </tr>
            <tr>
               <td align="left">开始时间</td>
               <td align="left">
                  <input class="easyui-datetimebox" name="begin_date" data-options="required:true,showSeconds:false" style="width:150px">
                  <font color="red">格式：2015-07-24 12:12:12</font>
               </td>
            </tr>
            <tr>
               <td align="left">结束时间</td>
               <td align="left">
                  <input class="easyui-datetimebox" name="end_date" data-options="required:true,showSeconds:false" style="width:150px">
                  <font color="red">格式：2015-07-24 12:12:12</font>
               </td>
            </tr>
            <tr>
               <td align="left">备注</td>
               <td align="left">
                  <textarea name="note" cols="50" rows="10"></textarea>
               </td>
            </tr>
            <tr>
               <td align="center" colspan="2"><button style="width:50px;heigt:10px" type="submit" value="提交" />提交</td>
            </tr>
         </table>
      </form>
   </body>

   </HTML>