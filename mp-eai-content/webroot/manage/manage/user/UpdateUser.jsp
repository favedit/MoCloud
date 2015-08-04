<%@ include file='/apl/public.inc' %>
   <jh:define source="&userPage.user" alias="user"></jh:define>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
      <script>
         function submitForm() {
            if (!isValid()) return;
            progress();
            var url = "/manage/user/User.wa?do=update&date=" + new Date().valueOf();
            var data = {
               "id": $('#id').val(),
               "passport": $('#passport').val(),
               "password": $('#pwd2').val(),
               "label": $('#label').val(),
               "adminId": $('#adminId').val()
            };
            $.ajax({
               type: "POST",
               url: url,
               data: data,
               success: function(msg) {
                  closeProgress();
                  var result = toJsonObject(msg);
                  if (result == '0') {
                     alertx("此帐号已被使用！", "wrning", function() {
                        $('#passport').val("");
                        $('#passport').focus();
                     });
                  } else {
                     location.href = "/manage/user/User.wa";
                  }
               },
               fail: function() {
                  closeProgress();
                  alert("error");
               }
            });
         }

         function confirmpwd() {
            var pwd1 = $("#pwd1").val();
            var pwd2 = $("#pwd2").val();
            if (pwd1 != pwd2) {
               msg("两次密码不一致！");
               $("#pwd1").val("");
               $("#pwd2").val("");
               $("#pwd1").focus();
            }
         }
      </script>
   </HEAD>

   <body bgcolor="#198bc9">
      <div id="cy_right" style="width:100%">
         <div class="right_title">
            <span>修改管理员</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn">
               <a href="#" onClick="submitForm()" class="sub_btn"></a>
               <a href="#" onClick="history.go(-1);" class="back_btn"></a>
            </div>
            <div class="nav_search"></div>
         </div>
      </div>
      <div class="easyui-panel" fit='true' data-options="border:false">
         <table width="648" border="0" style="text-align:center; margin-left:10px; margin-top:10px; margin-bottom:10px">
            <tr>
               <td align="left" width="66">帐号</td>
               <td align="left" width="572">
                  <input id="passport" name="passport" readonly class="easyui-validatebox textbox notnull" style="width:500px" data-options="required:true" value="<jh:write source='&user.passport'/>" />
                  <input id="id" name="id" style="display:none" value="<jh:write source='&user.ouid'/>" />
               </td>
            </tr>
            <tr>
               <td align="left">密码</td>
               <td align="left">
                  <input id="pwd1" class="easyui-validatebox textbox" style="width:500px" data-options="validType:'length[6,32]'" type="password" name="pwd1" value="<jh:write source='&user.password'/>" />
               </td>
            </tr>
            <tr>
               <td align="left">确认密码</td>
               <td align="left">
                  <input id="pwd2" class="easyui-validatebox textbox notnull" style="width:500px" data-options="required:true,validType:'length[6,32]'" type="password" name="pwd2" value="<jh:write source='&user.password'/>" onBlur="confirmpwd()" /> </td>
            </tr>
            <tr>
               <td align="left">真实名称</td>
               <td align="left">
                  <input id="label" class="easyui-validatebox textbox notnull" data-options="required:true" style="width:500px" name="label" value="<jh:write source='&user.label'/>" />
               </td>
            </tr>
         </table>
      </div>
   </body>

   </HTML>