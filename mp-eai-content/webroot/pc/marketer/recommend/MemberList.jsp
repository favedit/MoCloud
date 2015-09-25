<%@ include file='/apl/public.inc' %>
<%@ include file='head.jsp' %>
   <link rel="stylesheet" type="text/css" href="css/PotentialUsers.css">
   <TR>
      <TD width="100%" align="center" valign="center">
         <ul class="users" id="users">
            <li class="binding"><a href="/pc/marketer/member/Followed.wa">已关用户列表</a></li>
            <li onclick="loginOut();"><a class="exit" href="javascript:;">退出</a></li>
         </ul>
         <div class="imag-container">
            <table border="0" cellpadding="2" cellspacing="0">
               <tr class="title">
                  <td colspan="7" rowspan="0" align="center" valign="center">我要关注</td>
               </tr>
               <tr class="main-title">
                  <td>姓名</td>
                  <td>年龄</td>
                  <td>地区</td>
                  <td>注册时间</td>
                  <td>最后登录时间</td>
                  <td>客户评分</td>
                  <td width="30%">关注</td>
               </tr>
               <div class="glass-cover"><img src="images/glass-cover.png"></div>
               <jh:loop alias="member" source="&page.memberList">
                  <tr class="trs">
                     <td><jh:write source="&member.label" /></td>
                     <td><jh:write source="&member.age" /></td>
                     <td><jh:write source="&member.cityLabel" /></td>
                     <td><jh:date source="&member.registerDate" format="yyyy-MM-dd HH:mm:ss" /></td>
                     <td><jh:date source="&member.lastLoginDate" format="yyyy-MM-dd HH:mm:ss"/></td>
                     <td><jh:write source="&member.recommendScore" /></td>
                     <td><a class="btn" data-id="<jh:write source='&member.guid' />" href="javascript:;">关&nbsp;&nbsp;&nbsp;&nbsp;注</a></td>
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
      <TD height='60' colspan="0" align="center" valign="top">
         <div class="fot">
            <p>本平台由钰诚集团智慧企业推进中心 出品
               </br>客服电话：010-65499299</p>
         </div>
      </TD>
      <td class="td-container"></td>
   </TR>
   </TABLE>
   </FORM>
   <script>
      function pading(nubmer){
         var currentPage = <jh:write source="&page.pageCurrent" />;
         var page = currentPage+nubmer;
         location.href="/pc/marketer/recommend/Recommend.wa?page="+page;
      }
   </script>
   <div class="prompts">
      不好意思，您手慢了！
   </div>
   <script type="text/javascript" src="js/potentialUsers.js"></script>
   </body>
   </html>