<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
   </HEAD>

   <body style="margin-left:20px;margin-top:20px">
      <div>
      <a href="/manage/manage/person/user/InsertUser.jsp">增加</a>
      <button onclick="javascript:location.href='/manage/device/Device.wa'" value="test" />设备信息   
      <button onclick="javascript:location.href='/manage/logger/user/Access.wa'" value="test" />用户日志   
      <button onclick="javascript:location.href='/manage/person/user/Access.wa'" value="test" />白名单   
         </div>
      <table border="0" cellpadding="3" cellspacing="1" style="background-color: #b9d8f3;">
         <tr style="text-align: center; COLOR: #0076C8; BACKGROUND-COLOR: #F4FAFF; font-weight: bold">
            <th>ip地址</th>
            <th>说明</th>
            <th>帐号</th>
            <th>密码</th>
            <th>权限状态</th>
            <th>是否永久</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>操作</th>
         </tr>
         <jh:loop source="&page.unitList" alias="node">
            <tr bgcolor='#F4FAFF'>
               <td>
                  <jh:write source='&node.hostAddress' />
               </td>
               <td>
                  <jh:write source='&node.label' />
               </td>
               <td>
                  <jh:write source='&node.passport' />
               </td>
               <td>
                  <jh:write source='&node.password' />
               </td>
               <td>
                  <jh:equals source="&node.accessCd" value="1">
                     允许
                  </jh:equals>
                  <jh:equals source="&node.accessCd" value="2">
                     禁止
                  </jh:equals>
               </td>
               <td>
                  <jh:equals source="&node.typeCd" value="1">
                     永久
                  </jh:equals>
                  <jh:equals source="&node.typeCd" value="2">
                     临时
                  </jh:equals>
               </td>
               <td>
                  <jh:date source='&node.beginDate' format="YYYY-MM-DD HH24:mi:ss" />
               </td>
               <td>
                  <jh:date source='&node.endDate' format="YYYY-MM-DD HH24:mi:ss" />
               </td>
               <td>
                  <a href="/manage/person/user/Access.wa?do=updateBefore&id=<jh:write source='&node.ouid' />">修改</a>
                  <a href="/manage/person/user/Access.wa?do=delete&id=<jh:write source='&node.ouid' />">删除</a>
               </td>
            </tr>
         </jh:loop>
      </table>
   </body>

   </HTML>