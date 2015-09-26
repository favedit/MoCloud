<%@ include file='/apl/public.inc' %>
<%@ include file='/pc/marketer/recommend/head.jsp' %>
<link rel="stylesheet" type="text/css" href="/pc/marketer/recommend/css/PotentialUsers.css">
         <TR>
            <TD  width="100%" align="center" valign="center">
               <ul class="users" id="users">
                  <li class="binding"><a href="/pc/marketer/member/Followed.wa">已关用户列表</a></li>
                  <li onclick="loginOut();"><a class="exit" href="javascript:;">退出</a></li>
                </ul> 
               <div class="imag-container focus">
                  <table  border="0" cellpadding="2" cellspacing="0">
                     <tr class="title">
                        <td colspan="7" rowspan="0" align="center" valign="center">已关注用户</td>
                     </tr>
                      <tr class="main-title">
                           <td>姓名</td>
                           <td>手机号</td>
                           <td>最后登录时间</td>
                           <td>客户评分</td>
                           <td>联络周期</td>
                           <td width="30%">抢单</td>
                     </tr>
                     
                     <jh:loop alias="mMember" source="&page.marketerMemberList">
                      <tr class="trs" href="ExistingUser.wa"  >
                           <td><jh:write source="&mMember.memberLabel" /></td>
                           <td><jh:write source="&mMember.memberPhone" /></td>
                           <td><jh:date source="&mMember.memberLastLoginDate" format="yyyy-MM-dd hh:mm:ss" /></td>
                           <td><jh:write source="&mMember.memberRecommendScore" /></td>
                           <td><jh:write source="&mMember.remainingDays" /></td>
                           <td class="pr"><a class="btn remove" data-id="<jh:write source="&mMember.memberGuid" />"  href="javascript:;" onclick="setManagement();">解除关系</a>
                           </td>
                     </tr>
                     </jh:loop>                    
                  </table>
                  <ul class="pages">
                     <li><a href="javascript:void(0);" onclick="pading(-1)">上一页</a></li>
               <li><jh:write source="&page.pageCurrent" />/<jh:write source="&page.pageTotal" /></li>
               <li><a href="javascript:void(0);" onclick="pading(+1)">下一页</a></li>
                  </ul>
               </div>
            </TD>
         </TR>
         <TR>
            <TD height='60' colspan="0"  align="center" valign="top">
               <div class="fot">
                  <p>本平台由钰诚集团智慧企业推进中心 出品
                  </br>客服电话：010-65499299</p>
               </div>
            </TD>
            <td class="td-container"></td>
         </TR>
      </TABLE>
   </FORM>
   <div class="shadow-bg" onclick = "shutDown();"></div>
   <%@ include file='remove.jsp' %>
   <script type="text/javascript" src="/pc/marketer/recommend/js/existingUser.js"></script>
<script>
      function pading(nubmer){
         var currentPage = <jh:write source="&page.pageCurrent" />;
         var page = currentPage+nubmer;
         location.href="/pc/marketer/member/Followed.wa?page="+page;
      }
   </script>
</body>
</html>