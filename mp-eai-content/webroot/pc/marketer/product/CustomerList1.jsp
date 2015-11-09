<%@ include file='/pc/marketer/product/head.jsp' %>
<link rel="stylesheet" type="text/css" href="/pc/marketer/product/css/customerList.css">
            <TD  width="100%" align="center" valign="center" >
              <ul class="users" id="users">
                 <!--<li class="binding"><a href="/pc/marketer/member/Followed.wa">已关注用户列表</a></li>-->
                 <li onclick="loginOut();"><a class="exit" href="javascript:;">退出</a></li>
               </ul> 
               <div class="shadow-bg" onclick = "shutDown();"></div>
               <div class="imag-container focus clearfix" >
                    <p class="search"><input id="search_text" type="text"><input id="search_btn" value="搜索" type="button"></p>
                    <div class="fl content-left" >
                      <ul class="content-title">
                        <li class="on"><a href="CustomerList1.jsp">我的客户</a></li>
                        <li><a href="CustomerResults.jsp">我的业绩</a></li>
                      </ul>
                    </div>
                    <div class="fr content-right content-container">
                      <table  border="0" cellpadding="2" cellspacing="0">
                          <tr class="main-title" id="main-title">
                               <td>头像</td>
                               <td>客户信息</td>
                                <td>性别</td>
                               <td>电话</td>
                               <td>净投</td>
                               <td>关注PV</td>
                               <td>上次关注时间</td>
                               <td>上次拜防时间</td>
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