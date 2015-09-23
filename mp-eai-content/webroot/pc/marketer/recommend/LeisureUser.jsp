<%@ include file='head.jsp' %>
<link rel="stylesheet" type="text/css" href="">
         <TR>
            <TD  width="100%" align="center" valign="center">
               <ul class="users" id="users">
                  <li class="binding"><a href="Binding.wa">已关用户列表</a></li>
                  <li onclick="loginOut();"><a class="exit" href="javascript:;">退出</a></li>
                </ul> 
               <div class="imag-container">
                  <table  border="0" cellpadding="2" cellspacing="0">
                     <tr class="title">
                        <td colspan="7" rowspan="0" align="center" valign="center">我要关注</td>
                     </tr>
                  </table>

                 
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
   <div class="management-prompt">
      <!-- 44d5d8 -->
      <p><input type="checkbox">上线提醒</p>
      <p><input type="checkbox">产品关注提醒</p>
      <p><input type="checkbox">产品购买提醒</p>
      <p><input type="checkbox">充值提醒</p>
      <textarea id="content" class="" name="" placeholder=""></textarea>
      <p class="btn-container"><input class="btn" type="submit" value="提交"></p>
   </div>
</body>
</html>