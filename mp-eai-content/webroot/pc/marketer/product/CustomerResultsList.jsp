<%@ include file='/pc/marketer/product/head.jsp' %>
<link rel="stylesheet" type="text/css" href="/pc/marketer/product/css/resultsList.css">
            <TD  width="100%" align="center" valign="center" >
              <ul class="users" id="users">
                 <!--<li class="binding"><a href="/pc/marketer/member/Followed.wa">已关注用户列表</a></li>-->
                 <li onclick="loginOut();"><a class="exit" href="javascript:;">退出</a></li>
               </ul> 
               <div class="shadow-bg" onclick = "shutDown();"></div>
               <div class="imag-container focus clearfix" >
                <div class="container-top">
                  <div class="product">
                    <ul>
                     <jh:loop alias="product" source="&page.productList">
                      <li style="margin-left:0px;">
                        <a href="/pc/marketer/product/customer/CustomerTender.wa?productId=<jh:write source="&product.ouid" />">
                          <span class="icon1"></span>
                          <b>
                            <jh:write source="&product.label" /></b>
                          <p>净投：<jh:write source="&product.netInvestment_total" /></p>
                        </a>
                      </li>
                       </jh:loop>
                    </ul>
                  </div>                  
                  <ul class="total-number">
                    <li><b>业绩：</b><jh:write source="&page.Investment_total" /></li>
                    <li><b>投资人数：</b><jh:write source="&page.customer_total" /></li>
                    <li><b>关注PV：</b>545646465</li>
                    <li><b>本期次：</b>54564</li>
                  </ul>
                </div>
                    <div class="fl content-left" >
                      <ul class="content-title">
                        <li><a href="CustomerList1.jsp">我的客户</a></li>
                        <li><a href="CustomerResults.jsp">我的业绩</a></li>
                      </ul>
                    </div>
                    <div class="fr content-right content-container">
                      <table  border="0" cellpadding="2" cellspacing="0">
                          <tr class="main-title" id="main-title">
                               <td >头像</td>
                               <td>客户信息</td>
                                <td>性别</td>
                               <td>电话</td>
                               <td>净投</td>
                               <td>关注PV</td>
                               <td>上次关注时间</td>
                               <td >上次拜访时间</td> 
                         </tr>
                         <!-- href="/pc/marketer/recommend/Recommend.wa?do=memberInfo&id=" -->
                          <jh:loop alias="customer" source="&page.customerTenderList">
                         <tr class="trs trigger"   href = "/pc/marketer/customer/Customer.wa?do=selectByCustomerId&customerId=<jh:write source="&customer.customerId" />">
                               <td><a href="/pc/marketer/customer/Customer.wa?do=selectByCustomerId&customerId=<jh:write source="&customer.customerId" />">
                                <jh:write source="&customer.memberLabel" /></a></td>
                               <td><img src="images/re.png"/></td>
                               <td><jh:write source="&customer.genderLabel" /></td>
                               <td><jh:write source="&customer.memberPhone" /></td>
                               <td><jh:write source="&customer.netinvestment" /></td>
                               <td>234234234</td>
                               <td><jh:write source="&customer.memberLastLoginDate" /></td>
                               <td>234234234</td>
                         </tr> 
                         </jh:loop>
                      </table>
                       <ul class="pages">
                           <li><a href="javascript:void(0);" onclick="pading(-1)">上一页</a></li>
                             <li><jh:write source="&page.pageCurrent" />/<jh:write source="&page.pageTotal" /></li>
                           <li><a href="javascript:void(0);" onclick="pading(+1)">下一页</a></li>
                       </ul>
                        <script type="text/javascript">
                  function pading(num){
                  var pageCurrent=<jh:write source="&page.pageCurrent" />;
                  location.href="/pc/marketer/product/customer/CustomerTender.wa?productId=<jh:write source="&page.productId" />&page="+eval(pageCurrent+num);
                  
                  }
                  
                  </script>
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
            <td class="td-container"></td>
         </TR>
      </TABLE>
   </FORM>
   <%@ include file='remove.jsp' %>
<script>
      // function pading(nubmer){
      //    $(".loading").show();
      //    $("#loading_img_div").show();
      //    var currentPage = <jh:write source="&page.pageCurrent" />;
      //    var page = currentPage+nubmer;
      //    location.href="/pc/marketer/member/Followed.wa?page="+page;
      // }
   // doLoading();
 $(function(){
        $(".content-container").on("click", ".trs", function() {
          var url = $(this).attr("href");
          alert(url);
          // window.open(url, "_blank")
          // location.href = url;
        })

      }) 
   </script>
</body>
</html>