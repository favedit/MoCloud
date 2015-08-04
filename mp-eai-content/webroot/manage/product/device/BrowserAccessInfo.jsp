<%@ include file='/apl/public.inc' %>
   <jh:define source="&devicePage.unit" alias="unit"></jh:define>
   <HTML>

   <HEAD>
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
   </HEAD>

   <body>
      <div class="easyui-panel" fit='true'>
            <div id="cy_right" style="width:100%">
               <div class="right_title"> <span>设备详情</span> </div>
               <div class="btn_bar">
                  <div class="nav_btn">
                     <a href="javascript:history.back(-1);" class="back_btn"></a>
                  </div>
               </div>
            </div>
            <div class='cy_edit_panel'>
               <table align="left" border="0">
                   <tr>
                     <td align="left" style="width:100px">头信息</td>
                     <td align="left" style="border:solid 0px #0a60c4;font-size:9;">
                        <jh:write source='&unit.agentCode' />
                     </td>
                  </tr>
                  <tr>
                     <td align="left" valign="top" style="width:100px">设备信息</td>
                     <td align="left" style="border:solid 1px #0a60c4;font-size:9">
                        <jh:write source='&unit.content' />
                     </td>
                  </tr>
               </table>
            </div>
      </div>

   </body>

   </HTML>