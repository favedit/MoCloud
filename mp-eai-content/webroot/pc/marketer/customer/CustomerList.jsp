<%@ include file='/apl/public.inc' %>
<%@ include file='/pc/marketer/customer/head.jsp' %>
<jh:define source="&page.marketer" alias="marketer"></jh:define>
<jh:define source="&page.customerList" alias="customers"></jh:define>
<link rel="stylesheet" type="text/css" href="/pc/marketer/customer/css/customerList.css">
            <TD  width="100%" align="center" valign="center" >
              <ul class="users" id="users">
                 <!--<li class="binding"><a href="/pc/marketer/member/Followed.wa">已关注用户列表</a></li>-->
                 <li onclick="loginOut();"><a class="exit" href="javascript:;">退出</a></li>
               </ul> 
               <div class="shadow-bg" onclick = "shutDown();"></div>
               <div class="imag-container focus clearfix" >
               <span>客户数：<jh:write source="&page.rowCount"/></span>
                  <span>投资总额：<jh:write source="&marketer.customerInvestmentTotal"/></span>
                  <span>净投总额：<jh:write source="&marketer.customerNetinvestmentTotal"/></span>
                  <span>赎回总额：<jh:write source="&marketer.customerRedemptionTotal"/></span>
                    <p class="search"><input id="keyword" name="keyword" value="<jh:write source="&page.keyword"/>" type="text"><input id="search_btn" value="搜索" type="button" onclick="javascript:search();"></p>
                    <div class="fl content-left" >
                      <ul class="content-title">
                        <li class="on"><a href="Customer.wa">我的客户</a></li>
                        <li><a href="Result.wa">我的业绩</a></li>
                      </ul>
                    </div>
                    <div class="fr content-right content-container">
                      <table  border="0" cellpadding="2" cellspacing="0">
                          <tr class="main-title" id="main-title">
                               <td>头像</td>
                               <td>客户信息</td>
                                <td>性别</td>
                               <td>电话</td>
                               <td>年龄</td>
                               <td>投资</td>
                               <td>净投</td>
                               <td>赎回</td>
                               <td>关注度</td>
                               <td>上次关注时间</td>
                         </tr>
                         <jh:loop alias="customer" source="&page.customerList">
                         <tr class="trs trigger"   href = "/pc/marketer/customer/Customer.wa?do=selectByCustomerId&customerId=<jh:write source="&customer.ouid"/>">
                               <td><img src="images/re.png"/></td>
                               <td><jh:write source="&customer.label" /></td>
                               <td><jh:write source="&customer.genderLabel"/></td>
                               <td><jh:write source="&customer.phone" /></td>
                               <td><jh:write source="&customer.age" /></td>
                               <td><jh:write source="&customer.investmentTotal" /></td>
                               <td><jh:write source="&customer.netinvestment"/></td>
                               <td><jh:write source="&customer.redemptionTotal"/></td>
                               <td><jh:write source="&customer.pv"/></td>
                               <td><jh:date source="&customer.lastLogin" format="yyyy-MM-dd hh:mm:ss" /></td>
                         </tr> 
                         </jh:loop>    
                         

                      </table>
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
            <td class="td-container"><input type="hidden" id="page" name="page" value="<jh:write source="&page.pageCurrent"/>"/></td>
         </TR>
      </TABLE>
   </FORM>
   <%@ include file='remove.jsp' %>
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
      $(function(){
        $(".content-container").on("click", ".trs", function() {
          var url = $(this).attr("href");
          //alert(url);
          // window.open(url, "_blank")
           location.href = url;
        })

      })  
      function search()
      {
         var formParam = $('#customerform').serialize();
         var datas = {keyword: $("#keyword").val()};
         var url="/pc/marketer/customer/Customer.wa?do=search";
         //$("#page").attr("value",0);
         customerform.action="/pc/marketer/customer/Customer.wa?do=search";
         customerform.submit();
      }
   </script>
</body>
</html>