<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <script>
         function doSubmit() {
            progress();
            var passport = $("#passport").val();
            if (passport.length > 18) {
               alert("账号不能超过18位");
               return;
            }
            if (!ischinese(passport)) {
               alert("账号和密码，由字母及数字或下划线组成！");
               return;
            }
            form.submit();
            closeProgress();
         }
      </script>
   </HEAD>

   <body>
      <div class="easyui-panel" fit='true'>
         <form id="form" method="post" action="/manage/product/user/whitelists/Access.wa?do=insert" onsubmit="">
            <div id="cy_right" style="width:100%">
               <div class="right_title"> <span>增加用户:</span> </div>
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
                     <td align="left" style="width:60px">ip地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:</td>
                     <td align="left">
                        <input name="host_address" style="width:400px;text-align:left;" value="" />
                     </td>
                  </tr>
                  <tr>
                     <td align="left" style="width:60px">说&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;明:</td>
                     <td align="left">
                        <input name="label" style="width:400px;text-align:left;" value="" />
                     </td>
                  </tr>
                  <tr>
                     <td align="left">帐&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</td>
                     <td align="left">
                        <input id="passport" name="passport" style="width:200px;text-align:left;" value="" />
                        <font color="red">只支持英文、数字和下划线，长度18位以内</font>
                     </td>
                  </tr>
                  <tr>
                     <td align="left">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</td>
                     <td align="left">
                        <input name="password" style="width:200px;text-align:left;" value="" />
                        <font color="red">不支持单引号'分号;百分号%</font>
                     </td>
                  </tr>
                  <tr>
                     <td align="left">权限状态:</td>
                     <td align="left">
                        <select name="access_cd">
                           <option value="1">允许</option>
                           <option value="2">禁止</option>
                        </select>
                     </td>
                  </tr>
                  <tr>
                     <td align="left">是否永久:</td>
                     <td align="left">
                        <select name="type_cd">
                           <option value="1">永久</option>
                           <option value="2">临时</option>
                        </select>
                        <font color="red">当权限禁止时，此下拉框的临时选项无效。</font>
                     </td>
                  </tr>
                  <tr>
                     <td align="left">开始时间:</td>
                     <td align="left">
                        <input class="easyui-datetimebox" id="begin_date" name="begin_date" data-options="showSeconds:false" style="width:150px"> -
                        <input class="easyui-datetimebox" id="end_date" name="end_date" data-options="showSeconds:false" style="width:150px">
                     </td>
                  </tr>
                  <tr>
                     <td align="left">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注:</td>
                     <td align="left">
                        <textarea name="note" cols="80" rows="10"></textarea>
                     </td>
                  </tr>
               </table>
            </div>
         </form>
      </div>
   </body>

   </HTML>