<%@ include file='/apl/public.inc' %>
<%@ include file='head.jsp' %>
<link rel="stylesheet" type="text/css" href="css/LeisureUser.css">
<!-- <div class="note-setupthe">
  <a class="btn sms-settings" href="javascript:;" >短信设置</a>
  <p><input name="radio" data-id="0" type="radio">上线提醒</p>
  <p><input name="radio" data-id="0" type="radio">产品关注提醒</p>
  <p><input name="radio" data-id="0" type="radio">产品购买提醒</p>
  <p><input name="radio" data-id="0" type="radio">充值提醒</p>
  <p class="btn-box"><a class="btn shut-down"  href="javascript:;">关闭</a><a class="btn determine" href="javascript:;" >确认</a></p>
</div> -->
       <TR>
          <TD  width="100%" align="center" valign="center">
             <ul class="users" id="users">
                <li class="binding"><a href="Binding.wa">已关注用户列表</a></li>
                <li onclick="loginOut();"><a class="exit" href="javascript:;">退出</a></li>
              </ul> 
             <div class="imag-container">
                 <div class="details">
                   <p class="title"><a href="">返回关注用户列表>></a></p>
                    <div class="details-l">
                      <h4>
                         <b style="width:22%">王某某</b>
                         <i style="width:20%">13105551234</i>
                         <i style="width:12%">22</i>
                         <i class="setupthes" data-id="" style=""><a class="btn removes" href="javascript:;" onclick="setManagement();" >解除关系</a>

                         </i>
                      </h4>
                      <p>性别：</p>
                      <p>客户评分：</p>
                      <p>最高学历：</p>
                      <p>月收入：</p>
                      <p>职业：</p>
                      <p>城市：</p>
                      <p>邮箱：</p>
                      <p>推荐人：</p>
                    </div>
                    <div class="details-r">
                       <h4>用户动态</h4>
                       <p>注册时间：</p>
                       <p>最近登录时间：</p>
                       <p>联络周期倒计时：<i class="yellow">4</i>天</p>
                    </div>
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
 <div class="shadow-bg" onclick = "shutDown();"></div>
 <%@ include file='remove.jsp' %>
 <script type="text/javascript" src="js/leisureUser.js"></script>
</body>
</html>