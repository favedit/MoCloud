<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <script>
         function doSubmit(){
            console.log("123");
            var beginTime = $("begin_date").val();
            alert(beginTime);
         }
      </script>
   </HEAD>
   <body>
      <div class="easyui-panel" fit='true'>
         <form id="form" method="post" action="/manage/person/user/Access.wa?do=insert" onsubmit="">
            <div id="cy_right" style="width:100%">
               <div class="right_title"> <span>增加用户</span> </div>
               <div class="btn_bar">
                  <div class="nav_btn">
                     <a href="javascript:doSubmit();" class="sub_btn"></a>
                     <a href="javascript:history.back(-1);" class="back_btn"></a>
                  </div>
                  <div class="nav_search"></div>
               </div>
            </div>
            <div class='cy_edit_panel'>
               <table align="left" border="0">
                  <tr>
                     <td align="left" style="width:60px">ip地址</td>
                     <td align="left">
                        <input name="host_address" style="width:400px;text-align:left;" value="" />
                     </td>
                  </tr>
                  <tr>
                     <td align="left" style="width:60px">说明</td>
                     <td align="left">
                        <input name="label" style="width:400px;text-align:left;" value="" />
                     </td>
                  </tr>
                  <tr>
                     <td align="left">帐号</td>
                     <td align="left">
                        <input name="passport" style="width:400px;text-align:left;" value="" />
                     </td>
                  </tr>
                  <tr>
                     <td align="left">密码</td>
                     <td align="left">
                        <input name="password" style="width:400px;text-align:left;" value="" />
                     </td>
                  </tr>
                  <tr>
                     <td align="left">权限状态</td>
                     <td align="left">
                        <select name="access_cd">
                           <option value="1">允许</option>
                           <option value="2">禁止</option>
                        </select>
                     </td>
                  </tr>
                  <tr>
                     <td align="left">是否永久</td>
                     <td align="left">
                        <select name="type_cd">
                           <option value="1">永久</option>
                           <option value="2">临时</option>
                        </select>
                        <font color="red">当权限禁止时，此下拉框的临时选项无效。</font>
                     </td>
                  </tr>
                  <tr>
                     <td align="left">开始时间</td>
                     <td align="left">
                        <input class="easyui-datetimebox" id="begin_date" name="begin_date" data-options="showSeconds:false" style="width:150px">   -   
                        <input class="easyui-datetimebox" id="end_date" name="end_date" data-options="showSeconds:false" style="width:150px">
                     </td>
                  </tr>
                  <tr>
                     <td align="left">备注</td>
                     <td align="left">
                        <textarea name="note" cols="60" rows="10"></textarea>
                     </td>
                  </tr>
               </table>
            </div>
         </form>
      </div>
   </body>

   </HTML>