<%@ include file='/apl/public.inc' %>
   <jh:define source="&page.customerInfo" alias="customerInfo"></jh:define>
   <%@ include file='head.jsp' %>
      <link rel="stylesheet" type="text/css" href="css/LeisureUser.css">
      
            <div class="imag-container">
               <div class="details">
                  <div class="details-l">
                  <a onclick="tuenOver(-1)">上一个</a>   
                  <a onclick="tuenOver(+1)">下一个</a>
                  <script type="text/javascript">
                  function tuenOver(num){
                  var pageCurrent=<jh:write source="&page.pageCurrent" />;
                  if(num == +1){
                   if(<jh:write source="&page.maxIndex" />==<jh:write source="&page.index" />){
                  location.href="/pc/marketer/customer/Customer.wa?do=selectByCustomerId&page="+eval(pageCurrent+num);
                  }else{
                  location.href="/pc/marketer/customer/Customer.wa?do=selectByCustomerId&customerId=<jh:write source="&customerInfo.ouid" />&flag=true&page="+pageCurrent;
                  } 
                  //location.href="/pc/marketer/customer/Customer.wa?do=selectByCustomerId&customerId=<jh:write source="&customerInfo.ouid" />&flag=true&page="+pageCurrent;
                  }
                  if(num == -1){
                   if(<jh:write source="&page.index" /> == 0){
                  location.href="/pc/marketer/customer/Customer.wa?do=selectByCustomerId&page="+eval(pageCurrent+num);
                           }else{
                           location.href="/pc/marketer/customer/Customer.wa?do=selectByCustomerId&customerId=<jh:write source="&customerInfo.ouid" />&flag=false&page="+pageCurrent;
                           } 
                 // location.href="/pc/marketer/customer/Customer.wa?do=selectByCustomerId&customerId=<jh:write source="&customerInfo.ouid" />&flag=false&page="+pageCurrent;
                  }
                  }
                  </script>
                     <h4>
                         <b style="width:22%"><jh:write source="&customerInfo.label" /></b>
                      </h4>
                     <p>性别：<jh:write source="&customerInfo.genderLabel" />
                     婚姻状况：<jh:write source="&customerInfo.marray" />
                     最高学历：<jh:write source="&customerInfo.education" />
                     </p>
                     <p>月收入：
                     职业：<jh:write source="&customerInfo.business" />
                     城市：<jh:write source="&customerInfo.cityLabel" />
                     </p>
                     <p>籍贯：
                    住址：
                      紧急联系人：
                     </p>
                     <p>邮箱：<jh:write source="&customerInfo.EMAIL" />
                     联系人手机：
                    与联系人关系
                     </p>
                     <p>上次关注时间：
                     关注时间偏好：
                     近期关注产品：
                     </p>
                     <p>TEL：<jh:write source="&customerInfo.phone" />
                     </p>
                     <p>投资总额：<jh:write source="&customerInfo.investmentTotal" />
                            投资次数：<jh:write source="&customerInfo.investmentCount" />次</p><p>
                            赎回总额：<jh:write source="&customerInfo.redemptionTotal" />
                            赎回次数：<jh:write source="&customerInfo.redemptionCount" />次</p><p>
                            净投总额：<jh:write source="&customerInfo.netinvestment" />
                            利息总额：<jh:write source="&customerInfo.interestTotal" /></p>
                            
                            <p><input type="checkbox" value="1" id="contactOnline">上线提醒 
                             <input type="checkbox" value="2" id="contactFollow">产品关注提醒</p><p>
   <input type="checkbox"  value="3" id="contactPurchase">购买提醒 
   <input type="checkbox"  value="4" id="contactRecharge">充值提醒</p>
   <input type="button" value="确定" onclick="ensure()">
                  </div>
                           <script type="text/javascript">
                           var contactOnline= document.getElementById("contactOnline");
                           var contactFollow= document.getElementById("contactFollow");
                           var contactPurchase= document.getElementById("contactPurchase");
                           var contactRecharge= document.getElementById("contactRecharge");
                            if(<jh:write source="&customerInfo.contactOnline" />==contactOnline.value){
                            contactOnline.checked=true;
                            } 
                            if(<jh:write source="&customerInfo.contactFollow" />==contactFollow.value){
                            contactFollow.checked=true;
                            }
                           if(<jh:write source="&customerInfo.contactPurchase" />==contactPurchase.value){
                            contactPurchase.checked=true;
                            }
                           if(<jh:write source="&customerInfo.contactRecharge" />==contactRecharge.value){
                              contactRecharge.checked=true;
                            }
                           function ensure(){
                           if(contactOnline.checked==true){
                           var contactOnlineVlaue= $("#contactOnline").val();
                           }else{
                               contactOnlineVlaue=0;
                           }
                           if(contactFollow.checked==true){
                                   var contactFollowVlaue= $("#contactFollow").val();
                                }else{
                                      contactFollowVlaue=0;
                                } 
                           if(contactPurchase.checked==true){
                                   var contactPurchaseVlaue= $("#contactPurchase").val();
                                }else{
                                      contactPurchaseVlaue=0;
                                }
                           if(contactRecharge.checked==true){
                                   var contactRechargeVlaue= $("#contactRecharge").val();
                                }else{
                                      contactRechargeVlaue=0;
                                }
                           $.ajax({
                        type:"POST",
                        url:"/pc/marketer/customer/Customer.wa?do=updataSms",
                           data:{customerId:<jh:write source="&customerInfo.ouid" />,contactOnline:contactOnlineVlaue,contactFollow:contactFollowVlaue,contactPurchase:contactPurchaseVlaue,contactRecharge:contactRechargeVlaue},
                        dataType: "text",
                           success:function(data){
                           alert("修改成功");
                           }
                           }) 
                           
                           
                           }
                           
                            </script>

                      <div class="details-r">
                     <h4>用户</h4>
                     <table border="0" cellpadding="2" cellspacing="0">
      <tr class="title">
      </tr>
      <jh:loop alias="customer" source="&page.customerList">
         <tr class="trs">
            <td><jh:write source="&customer.ouid" /></td>
            <td>
          <a href="/pc/marketer/customer/Customer.wa?do=selectByCustomerId&customerId=<jh:write source="&customer.ouid" />&page=<jh:write source="&page.pageCurrent" />">
            <jh:write source="&customer.label" />
            </a>
            </td>
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
                    location.href="/pc/marketer/customer/Customer.wa?do=selectByCustomerId&page="+eval(pageCurrent+num);
                    
                  }
                  
                  </script>
                     
                  </div>
               </div>
            </div>
 
      </body>

      </html>