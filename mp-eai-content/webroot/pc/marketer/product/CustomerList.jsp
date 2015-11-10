<%@ include file='/pc/marketer/product/head.jsp' %>
<link rel="stylesheet" type="text/css" href="/pc/marketer/product/css/results.css">
            <TD  width="100%" align="center" valign="center" >
              <ul class="users" id="users">
                 <!--<li class="binding"><a href="/pc/marketer/member/Followed.wa">已关注用户列表</a></li>-->
                 <li onclick="loginOut();"><a class="exit" href="javascript:;">退出</a></li>
               </ul> 
               <div class="shadow-bg" onclick = "shutDown();"></div>
               <div class="imag-container focus clearfix" >
                <div class="container-top">
                  <ul class="total-number">
                    <li><b>投资：</b>545646465</li>
                    <li><b>赎回：</b>545646465</li>
                    <li><b>净投：</b>545646465</li>
                  </ul>
                  <ul class="total-people">
                    <li><b>投资：</b>545646465</li>
                  </ul>

                </div>
                    <div class="fl content-left" >
                      <ul class="content-title">
                        <li><a href="CustomerList.jsp">我的客户</a></li>
                        <li><a href="CustomerResults.jsp">我的业绩</a></li>
                      </ul>
                    </div>
                    <div class="fr content-right">

                      <table  border="0" cellpadding="2" cellspacing="0">
                        <!--  <tr class="title">
                            <td colspan="7" rowspan="0" align="center" valign="center">我的客户</td>
                         </tr> -->

                          <tr class="main-title" id="main-title">
                               <td>产品名称</td>
                               <td>业绩</td>
                                <td>投资人数</td>
                               <td>投资次数</td>
                               <td>业绩比率</td>
                               <td>关注PV</td>
                         </tr>
                         <!-- href="/pc/marketer/recommend/Recommend.wa?do=memberInfo&id=" -->
                         <tr class="trs trigger"   href = "javascript;">
                               <td><img src="images/1.png"/>e租财富</td>
                               <td>234</td>
                               <td>234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                         </tr> 
                          <tr class="trs trigger"   href = "javascript;">
                               <td><img src="images/2.png"/>e租稳盈</td>
                               <td>234</td>
                               <td>234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                         </tr>
                         <tr class="trs trigger"   href = "javascript;">
                               <td><img src="images/3.png"/>e租稳盈</td>
                               <td>234</td>
                               <td>234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                         </tr> 
                         <tr class="trs trigger"   href = "javascript;">
                               <td><img src="images/4.png"/>e租稳盈</td>
                               <td>234</td>
                               <td>234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                         </tr> 
                         <tr class="trs trigger"   href = "javascript;">
                               <td><img src="images/5.png"/>e租稳盈</td>
                               <td>234</td>
                               <td>234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                         </tr> 
                         <tr class="trs trigger"   href = "javascript;">
                               <td><img src="images/6.png"/>e租稳盈</td>
                               <td>234</td>
                               <td>234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                               <td>234234234</td>
                         </tr> 
<!-- e租财富e租稳盈e租年享
e租年丰
e租富盈
e租富享 -->

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
   <!--<script type="text/javascript" src="/pc/marketer/customer/js/existingUser.js"></script>-->
<script>
      // function pading(nubmer){
      //    $(".loading").show();
      //    $("#loading_img_div").show();
      //    var currentPage = <jh:write source="&page.pageCurrent" />;
      //    var page = currentPage+nubmer;
      //    location.href="/pc/marketer/member/Followed.wa?page="+page;
      // }
   // doLoading();
   // // 短信设置 提醒
   // function onRadio( ts ){
   //   if (window.event) { 
   //      event.cancelBubble = true; 
   //  }else{ 
   //      event.stopPropagation(); 
   //  } 
   //   ts.find('input').prop("checked", true);
   // } 
   </script>
</body>
</html>