<%@ include file='/apl/public.inc' %>
   <jh:define source="&page.member" alias="member"></jh:define>
   <%@ include file='head.jsp' %>
      <link rel="stylesheet" type="text/css" href="css/LeisureUser.css">
      
            <div class="imag-container">
               <div class="details">
                  <p class="title"><a href="">返回关注用户列表>></a></p>
                  <div class="details-l">
                     <h4>
                         <b style="width:22%"><jh:write source="&member.label" /></b>
                         <i style="width:20%"><jh:write source="&member.phone" /></i>
                         <i style="width:12%"><jh:write source="&member.age" /></i>
                         <i class="setupthes" style=""><a class="btn removes" data-id="<jh:write source="&member.guid" />"  href="javascript:;" onclick="setManagement();" >解除关系</a>

                         </i>
                      </h4>
                     <p>性别：
                        <jh:write source="&member.genderCd" />
                     </p>
                     <p>客户评分：
                        <jh:write source="&member.recommendScore" />
                     </p>
                     <p>最高学历：
                        <jh:write source="&member.educationCd" />
                     </p>
                     <p>月收入：
                        <jh:write source="&member.incomeCd" />
                     </p>
                     <p>职业：
                        <jh:write source="&member.businessCd" />
                     </p>
                     <p>城市：
                        <jh:write source="&member.cityId" />
                     </p>
                     <p>邮箱：
                        <jh:write source="&member.email" />
                     </p>
                     <p>推荐人：
                        <jh:write source="&member.recommendMarketerUserId" />
                     </p>
                  </div>
                  <div class="details-r">
                     <h4>用户动态</h4>
                     <p>注册时间：
                        <jh:date source="&member.registerDate" format="yyyy-MM-dd hh:mm:ss" />
                     </p>
                     <p>最近登录时间：
                        <jh:date source="&member.lastLoginDate" format="yyyy-MM-dd hh:mm:ss" />
                     </p>
                     <p>联络周期倒计时：<i class="yellow"><jh:write source="&member.remainingDays" /></i>天</p>
                  </div>
               </div>
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
      <div class="shadow-bg" onclick="shutDown();"></div>
      <%@ include file='remove.jsp' %>
      <script type="text/javascript" src="js/leisureUser.js"></script>
      </body>

      </html>