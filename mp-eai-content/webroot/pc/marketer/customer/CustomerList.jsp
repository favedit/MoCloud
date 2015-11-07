<%@ include file='/apl/public.inc' %>
<%@ include file='/pc/marketer/customer/head.jsp' %>
<link rel="stylesheet" type="text/css" href="/pc/marketer/customer/css/PotentialUsers.css">
<script type="text/javascript" src="/pc/marketer/customer/js/potentialUsers.js"></script>
<jh:define source="&page.marketer" alias="marketer"></jh:define>
<jh:define source="&page.customerList" alias="customers"></jh:define>
 <div class="shadow-bg" onclick = "shutDown();"></div>
 
 <div id="Content-Left">
 <div id="Content-Up" style="background: #400000;"><a href="Customer.wa">我的客户</a></div>
 
 <div id="Content-Down">我的业绩</div>
 </div>
 <div >
               <div class="imag-container focus">
                  <table  border="0" cellpadding="2" cellspacing="0">
                  <tr class="title">
                        <td colspan="9"  align="center" valign="center">我的客户</td>
                     </tr>
                  <tr class="title"><td colspan="9" ><span>客户数：<jh:write source="&page.rowCount"/></span>
                  <span>投资总额：<jh:write source="&marketer.customerInvestmentTotal"/></span>
                  <span>净投总额：<jh:write source="&marketer.customerNetinvestmentTotal"/></span>
                  <span>赎回总额：<jh:write source="&marketer.customerRedemptionTotal"/></span>
                  <span><input id="keyword" name="keyword" value="<jh:write source="&page.keyword"/>"/><input type="button" value="搜索" onclick="javascript:search();"/></span>
                  </td>
                  
                  </tr>
                     
                      <tr class="main-title">
                           <td>姓名</td>
                           <td>性别</td>
                           <td>手机号</td>
                           <td>年龄</td>
                           <td>投资</td>
                           <td>净投</td>
                           <td>赎回</td>
                           <td>关注度</td>
                           <td>最后关注时间</td>
                           
                           <!--<td>操作</td>-->
                     </tr>
                     
                     <jh:loop alias="customer" source="&page.customerList">
                      <tr class="trs" href="/pc/marketer/recommend/Recommend.wa?do=memberInfo&id="  >
                           <td><jh:write source="&customer.label" /></td>
                           <td><jh:write source="&customer.gender"/></td>
                           <td><jh:write source="&customer.phone" /></td>
                           <td><jh:write source="&customer.age" /></td>
                           <td align="right"><jh:write source="&customer.investmentTotal" /></td>
                           <td><jh:write source="&customer.netinvestment"/></td>
                           <td><jh:write source="&customer.redemptionTotal"/></td>
                           <td><jh:write source="&customer.pv"/></td>
                           <td><jh:date source="&customer.lastLogin" format="yyyy-MM-dd hh:mm:ss" /></td>
                         <!--
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
                           -->
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
            <td class="td-container"><input type="hidden" id="page" name="page" value=""/></td>
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
         $("#page").attr("value",page);
         customerform.action="/pc/marketer/customer/Customer.wa?do=search";
         customerform.submit();
         
      }
      function search()
      {
         var formParam = $('#customerform').serialize();
         var datas = {keyword: $("#keyword").val()};
         var url="/pc/marketer/customer/Customer.wa?do=search";
         $("#page").attr("value",0);
         customerform.action="/pc/marketer/customer/Customer.wa?do=search";
         customerform.submit();
      }
   //doLoading();
   </script>
</body>
</html>