<%@ include file='/apl/public.inc' %>
   <jh:define source="&page.customerInfo" alias="customerInfo"></jh:define>
   <%@ include file='head.jsp' %>
      <link rel="stylesheet" type="text/css" href="css/LeisureUser.css">
      
            <div class="imag-container">
               <div class="details">
                  <p class="title"><a href="/pc/marketer/customer/Customer.wa">返回已关注用户列表</a></p>
                  <div class="details-l">
                     <h4>
                         <b style="width:22%"><jh:write source="&customerInfo.label" /></b>
                         <i style="width:20%"><jh:write source="&customerInfo.phone" /></i>
                         <i style="width:12%"><jh:write source="&customerInfo.age" /></i>
                         <i class="setupthes" style=""><a class="btn removes" data-id="<jh:write source="&customerInfo.guid" />"  href="javascript:;" onclick="setManagement();" >解除关系</a>
                           <a class="btn " onclick="setPrompts(1500);" href="javascript:;">短信设置</a>
                         </i>
                      </h4>
                     <p>性别：
                        <jh:write source="&customerInfo.genderLabel" />
                     </p>
                     <p>客户评分：
                        <jh:write source="&customerInfo.recommendScore" />
                     </p>
                     <p>最高学历：
                        <jh:write source="&customerInfo.educationLabel" />
                     </p>
                     <p>月收入：
                        <jh:write source="&customerInfo.incomeLabel" />
                     </p>
                     <p>职业：
                        <jh:write source="&customerInfo.businessLabel" />
                     </p>
                     <p>城市：
                        <jh:write source="&customerInfo.cityLabel" />
                     </p>
                     <p>邮箱：
                        <jh:write source="&customerInfo.email" />
                     </p>
                     <p>推荐人：
                        <jh:write source="&customerInfo.recommendMarketerUserId" />
                     </p>
                  </div>
                  <div class="details-r">
                     <h4>用户动态</h4>
                     <p>注册时间：
                        <jh:date source="&customerInfo.registerDate" format="yyyy-MM-dd hh:mm:ss" />
                     </p>
                     <p>最近登录时间：
                        <jh:date source="&customerInfo.lastLoginDate" format="yyyy-MM-dd hh:mm:ss" />
                     </p>
                     <p>联络周期倒计时：<i class="yellow"><jh:write source="&customerInfo.remainingDays" /></i>天</p>
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
      <div class="prompts">
         <i>程序猿们不分昼夜开发，此功能近期开通，请持续关注。</i>
      </div>
      <%@ include file='remove.jsp' %>
      <script type="text/javascript" src="js/leisureUser.js"></script>
      </body>

      </html>