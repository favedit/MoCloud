<%@ include file='/apl/public.inc' %>
   <jh:define source="&page.customerInfo" alias="customerInfo"></jh:define>
   <%@ include file='head.jsp' %>
      <link rel="stylesheet" type="text/css" href="css/LeisureUser.css">
      
            <div class="imag-container">
               <div class="details">
                  <div class="details-l">
                  <a href="/pc/marketer/customer/Customer.wa?do=selectByCustomerId&customerId=<jh:write source="&customerInfo.ouid" />&flag=false">上一个</a>   
                  <a href="/pc/marketer/customer/Customer.wa?do=selectByCustomerId&customerId=<jh:write source="&customerInfo.ouid" />&flag=true">下一个</a>
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
                            if(<jh:write source="&customerInfo.contactOnline" />==1){
                            	contactOnline.checked=true;
                            } 
                            if(<jh:write source="&customerInfo.contactFollow" />==2){
                            	contactFollow.checked=true;
                            }
                           if(<jh:write source="&customerInfo.contactPurchase" />==3){
                            	contactPurchase.checked=true;
                            }
                           if(<jh:write source="&customerInfo.contactRecharge" />==4){
                            	  contactRecharge.checked=true;
                            }
                           function ensure(){
                        	   alert($("#contactOnline").val())
                           $.ajax({
                        		type:"post",
                        		url:"/pc/marketer/customer/Customer.wa?do=updataSms",
                        	   data:{contactOnline:$("#contactOnline").val(),contactFollow:$("#contactFollow").val(),contactPurchase:$("#contactPurchase").val(),contactRecharge:$("#contactRecharge").val()},
                        		dataType: "text",
                        	   success:function(data){
                        		   alert("sdds");
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