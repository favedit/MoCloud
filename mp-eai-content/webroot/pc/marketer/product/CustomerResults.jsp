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
                        <li><a href="CustomerList1.jsp">我的客户</a></li>
                        <li class="on"><a href="CustomerResults.jsp">我的业绩</a></li>
                      </ul>
                    </div>
                    <div class="fr content-right content-container">
                      <table  border="0" cellpadding="2" cellspacing="0">
                          <tr class="main-title" id="main-title">
                               <td>产品名称</td>
                               <td>业绩</td>
                                <td>投资人数</td>
                               <td>投资次数</td>
                               <td>业绩比率</td>
                               <td>关注PV</td>
                         </tr>
                         <tr class="trs trigger"   href ="javascript;">
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
<script type="text/javascript">
  $(function(){
    // hover 跳转
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