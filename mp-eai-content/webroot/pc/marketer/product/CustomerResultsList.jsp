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
                      <li style="margin-left:0px;">
                        <a>
                          <span class="icon1"></span>
                          <b>e租财富</b>
                          <p>净投：22100</p>
                        </a>
                      </li>

                       <li>
                        <a>
                        <span class="icon2"></span>
                        <b>e租稳盈</b>
                        <p>净投：221000</p>
                        </a>
                      </li>
                      
                       <li>
                         <a>
                        <span class="icon3"></span>
                        <b>e租年享</b>
                        <p>净投：2210000</p>
                        </a>
                      </li>
                       <li>
                        <a>
                        <span class="icon4"></span>
                        <b>e租年丰</b>
                        <p>净投：2210000</p>
                         </a>
                      </li>

                       <li>
                         <a>
                        <span class="icon5"></span>
                        <b>e租富盈</b>
                        <p>净投：221011000</p>
                         </a>
                      </li>

                       <li style="margin-right:0px;">
                         <a>
                        <span class="icon6"></span>
                        <b>e租富享</b>
                        <p>净投：221000</p>
                        </a>
                      </li>
                    </ul>
                  </div>                  
                  <ul class="total-number">
                    <li><b>业绩：</b>545646465</li>
                    <li><b>投资人数：</b>545646465</li>
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
                         <tr class="trs trigger"   href = "javascript;">
                                <td><img src="images/re.png"/></td>
                               <td>234</td>
                               <td>234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                         </tr> 
                          <tr class="trs trigger"   href = "javascript;">
                                <td><img src="images/re.png"/></td>
                               <td>234</td>
                               <td>234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                         </tr>
                         <tr class="trs trigger"   href = "javascript;">
                               <td><img src="images/re.png"/></td>
                               <td>234</td>
                               <td>234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                         </tr> 
                         <tr class="trs trigger"   href = "javascript;">
                                <td><img src="images/re.png"/></td>
                               <td>234</td>
                               <td>234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                         </tr> 
                         <tr class="trs trigger"   href = "javascript;">
                                <td><img src="images/re.png"/></td>
                               <td>234</td>
                               <td>234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                         </tr> 
                         <tr class="trs trigger"   href = "javascript;">
                                <td><img src="images/re.png"/></td>
                               <td>234</td>
                               <td>234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                         </tr> 
                      </table>
                       <ul class="pages">
                           <li><a href="javascript:void(0);" onclick="pading(-1)">上一页</a></li>
                           <li>33/222</li>
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