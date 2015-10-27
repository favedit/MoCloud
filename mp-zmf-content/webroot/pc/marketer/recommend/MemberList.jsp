<%@ include file='/apl/public.inc' %>
<%@ include file='head.jsp' %>
   <link rel="stylesheet" type="text/css" href="css/PotentialUsers.css">
   <div class="shadow-bg" style="display: none;background: rgba(0, 0, 0, 0.33);" onclick=""></div>
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
            <div class="loading"></div>
            <div id="loading_img_div" style="width:160px;">
               <div>
                  <img style="position:absolute;opacity:0.8;width:127px;height:127px;" src="images/loading7.png">
                  <img style="position:absolute;opacity:0.7;width:127px;height:127px;" src="images/loading6.png">
                  <img style="position:absolute;opacity:0.6;width:127px;height:127px;" src="images/loading5.png">
                  <img style="position:absolute;opacity:0.5;width:127px;height:127px;" src="images/loading4.png">
                  <img style="position:absolute;opacity:0.4;width:127px;height:127px;" src="images/loading3.png">
                  <img style="position:absolute;opacity:0.3;width:127px;height:127px;" src="images/loading2.png">
                  <img style="position:absolute;opacity:0.2;width:127px;height:127px;" src="images/loading1.png">
                  <img style="opacity:0.1;width:127px;height:127px;" src="images/loading8.png">
               </div>
               <img style="width:160px;margin-top: 10px;" src="images/loading.png">
            </div>

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
         $(".loading").show();
         $("#loading_img_div").show();
         var currentPage = <jh:write source="&page.pageCurrent" />;
         var page = currentPage+nubmer;
         location.href="/pc/marketer/recommend/Recommend.wa?page="+page;
      }
      doLoading();
   </script>
   <div class="prompts" style="display: none;">
      <span  class="lh200">不好意思，您手慢了！</span>
      <span class="mt50 hide" style="display:none;">恭喜您！已关注成功</span>
      <p><a class="fz16 hide" target="_blank" style="display:none;" href="javascript:;">查看客户资料</a></p>
   </div>
   <script type="text/javascript" src="js/potentialUsers.js"></script>
   </body>
   </html>