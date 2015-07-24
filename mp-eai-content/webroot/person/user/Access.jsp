<%@ include file='/apl/public.inc' %>
   <jh:define source="&page.unitList" alias="list"></jh:define>
   <HTML>

   <HEAD>
      <js:css/>
      <js:js type='runtime.client' />
      <script>
      </script>
   </HEAD>

   <body bgcolor="#198bc9">
      <table id="area">
         <thead>
            <tr>
               <th data-options="field:'ouid',halign:'center',align:'right'" width="60px">编号</th>
               <th data-options="field:'countryName',halign:'center',align:'left',sortable:true" width="140px">国家名称</th>
               <th data-options="field:'label',halign:'center',align:'left',sortable:true" width="200px">地区名称</th>
               <th data-options="field:'displayOrder',halign:'center',align:'right',sortable:true" width="60px">排序</th>
               <th data-options="field:'operation',halign:'center',align:'right',formatter:insert_editAndDelButton" width="140px">操作</th>
            </tr>
         </thead>
         <tbody>
            <jh:loop source="&list" alias="node">
               <tr>
                  <td>
                     <jh:write source='&node.userId'>
                  </td>
                  <td>
                     <jh:write source='&node.host'>
                  </td>
                  <td>
                     <jh:write source='&node.accessCd'>
                  </td>
                  <td>
                     <jh:write source='&node.userId'>
                  </td>
                  <td>
                     <jh:write source='&node.userId'>
                  </td>
               </tr>
            </jh:loop>
         </tbody>
      </table>
   </body>

   </HTML>