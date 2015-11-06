<%@ include file='/apl/public.inc' %>
<%@ include file='/pc/marketer/customer/head.jsp' %>
<link rel="stylesheet" type="text/css" href="/pc/marketer/customer/css/PotentialUsers.css">
 <div class="shadow-bg" onclick = "shutDown();"></div>
               <div class="imag-container focus">
                  <table  border="0" cellpadding="2" cellspacing="0">
                     <tr class="title">
                        <td colspan="7" rowspan="0" align="center" valign="center">我的客户</td>
                        <a href="/pc/marketer/product/customer/CustomerTender.wa">我的业绩</a>
                        <a href="/pc/marketer/customer/Customer.wa?do=selectByCustomerId&customerId=">我的客户</a>
                     </tr>
                      <tr class="main-title">
                           <td>姓名</td>
                           <td>手机号</td>
                           <td>最后登录时间</td>
                           <td>年龄</td>
                           <td>总投资</td>
                           <td>状态</td>
                           <td width="30%">操作</td>
                     </tr>
                     
                     <jh:loop alias="customer" source="&page.customerList">
                      <tr class="trs" href="/pc/marketer/recommend/Recommend.wa?do=memberInfo&id="  >
                           <td><jh:write source="&customer.label" /></td>
                           <td><jh:write source="&customer.phone" /></td>
                           <td><jh:date source="&customer.lastLogin" format="yyyy-MM-dd hh:mm:ss" /></td>
                           <td><jh:write source="&customer.age" /></td>
                           <td align="right"><jh:write source="&customer.investmentTotal" /></td>
                         <!--  <td class="pr"><a class="btn remove" data-id=""  href="javascript:;" onclick="setManagement();">短信提醒</a>
                           </td>-->
                         <td align="right"><jh:write source="&customer.statusSMS" /></td>
                        <td class="pr" ><a class="btn btns" href="javascript:;">短信设置</a>
                              <div class="note-setupthe">
                                 <p>
                                    <input type="radio" name="sms" value="1">上线提醒</p>
                                 <p>
                                    <input type="radio" name="sms" value="2">产品关注提醒</p>
                                 <p>
                                    <input type="radio" name="sms" value="3">产品购买提醒</p>
                                 <p>
                                    <input type="radio" name="sms" value="4">充值提醒</p>
                                 <p class="btn-box"  data-id="<jh:write source='&customer.ouid' />">
                                    <a class="btn" href="javascript:;" onclick="shutDown();">关闭</a>
                                    <a class="btn confirm" href="javascript:; ">确认</a>
                                 </p>
                              </div>
                           </td>
                     </tr>
                     </jh:loop>                    
                  </table>
                  <div class="loading"></div>
                  <div id="loading_img_div" style="width:160px;">
                     <div>
                        <img style="position:absolute;opacity:0.8;width:127px;height:127px;" src="/pc/marketer/recommend/images/loading7.png">
                        <img style="position:absolute;opacity:0.7;width:127px;height:127px;" src="/pc/marketer/recommend/images/loading6.png">
                        <img style="position:absolute;opacity:0.6;width:127px;height:127px;" src="/pc/marketer/recommend/images/loading5.png">
                        <img style="position:absolute;opacity:0.5;width:127px;height:127px;" src="/pc/marketer/recommend/images/loading4.png">
                        <img style="position:absolute;opacity:0.4;width:127px;height:127px;" src="/pc/marketer/recommend/images/loading3.png">
                        <img style="position:absolute;opacity:0.3;width:127px;height:127px;" src="/pc/marketer/recommend/images/loading2.png">
                        <img style="position:absolute;opacity:0.2;width:127px;height:127px;" src="/pc/marketer/recommend/images/loading1.png">
                        <img style="opacity:0.1;width:127px;height:127px;" src="/pc/marketer/recommend/images/loading8.png">
                     </div>
                     <img style="width:160px;margin-top: 10px;" src="/pc/marketer/recommend/images/loading.png">
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
   <%@ include file='remove.jsp' %>
   <script type="text/javascript" src="/pc/marketer/customer/js/existingUser.js"></script>
<script>
      function pading(nubmer){
         $(".loading").show();
         $("#loading_img_div").show();
         var currentPage = <jh:write source="&page.pageCurrent" />;
         var page = currentPage+nubmer;
         location.href="/pc/marketer/member/Followed.wa?page="+page;
      }
   doLoading();
   </script>
</body>
</html>