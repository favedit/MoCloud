<%@ include file='/apl/public.inc' %>
   <jh:define source="&devicePage.unit" alias="unit"></jh:define>
   <HTML>
      
   <HEAD>     
   </HEAD>

   <body>
      <table align="left" border="0">
         <tr>
               <td align="lwft" colspan="2">
                  <button onclick="javascript:history.back(-1);" style="width:50px;heigt:10px" type="submit" value="返回" />返回
               </td>
            </tr>
            <tr>
               <td align="left" style="width:100px">设备信息</td>
               <td align="left" style="border:solid 1px #0a60c4">
                  <jh:write source='&unit.content' />
               </td>
            </tr>
            
            
         </table>
   </body>

   </HTML>