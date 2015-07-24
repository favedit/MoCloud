<%@ include file='/apl/public.inc' %>
   <HTML>
   <HEAD>
   </HEAD>

   <body bgcolor="#198bc9">
      <table border="1">
            <tr>
               <th>编号</th>
               <th>国家名称</th>
               <th>地区名称</th>
               <th>排序</th>
               <th>国家名称</th>
               <th>地区名称</th>
               <th>排序</th>
               <th>操作</th>
            </tr>
            <jh:write source='&page.result'>
            <jh:loop source="&page.unitList" alias="node">
               <tr>
                  <td>
                     <jh:write source='&node.userId'>
                  </td>
                  <td>
                     <jh:write source='&node.host'>
                  </td>
                  <td>
                     <jh:write source='&node.passport'>
                  </td>
                  <td>
                     <jh:write source='&node.password'>
                  </td>
                  <td>
                     <jh:write source='&node.accessCd'>
                  </td>
                  <td>
                     <jh:write source='&node.beginDate'>
                  </td>
                  <td>
                     <jh:write source='&node.endDate'>
                  </td>
               </tr>
            </jh:loop>
      </table>
   </body>

   </HTML>