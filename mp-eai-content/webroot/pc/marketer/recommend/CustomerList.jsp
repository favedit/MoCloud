<%@ include file='/apl/public.inc' %>
   <!DOCTYPE>
   <html>

   <head>
      <title>客户列表—全球实时投资数据展示中心—钰诚集团智慧企业</title>
      <meta name="viewport" charset="UTF-8" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
   </head>

   <body>
      <table border="1" class="tab" align="center" style="text-align:center;border:1px solid black;border-collapse:collapse;">
         <tr class="line">
            <td>大区</td>
            <td>版本名称</td>
         </tr>

         <jh:loop alias="member" source="&page.memberList">
            <tr>
               <td>
                  <jh:write source='&member.passport' />
               </td>
               <td>
                  <jh:write source='&member.label' />
               </td>
            </tr>
         </jh:loop>
         <tr class="line">
            <td height="9" bgcolor="#FFFFFF" colspan="10">
               <jz:selec name="pageNums" source="&versionPage.pageDataset" value="id" text="p" selected="&versionPage.pageCurrent" onchange="location.href='javascript:version_doConditionsPage('+this.value+')'" href='javascript:version_doConditionsPage("'>
               </jz:selec>
            </td>
         </tr>
      </table>
   </body>

   </html>