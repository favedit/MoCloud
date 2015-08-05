<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
      <script>
         function submitForm() {
            if (!isValid()) return;
            if(!confirmpwd()) return;
            progress();
            var url = "/manage/home/Frame.wa?do=changePwd&date=" + new Date().valueOf();
            var data = {
               "id": $('#id').val(),
               "oldpwd": $('#oldpwd').val(),
               "password": $('#pwd2').val(),
            };
            $.ajax({
               type: "POST",
               url: url,
               data: data,
               success: function(msg) {
                  closeProgress();
                  var result = toJsonObject(msg);
                  if (result == '0') {
                     alertx("原密码不正确。", "wrning", function() {
                        $('#oldpwd').val("");
                        $('#pwd1').val("");
                        $('#pwd2').val("");
                        $('#oldpwd').focus();
                     });
                  } else {
                     top.location.href = "/manage/home/Frame.wa?do=loginOut";
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
               return false;
            }
            return true;
         }
      </script>
   </HEAD>

   <body bgcolor="#198bc9">
      <div id="cy_right" style="width:100%">
         <div class="right_title">
            <span>修改密码</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn">
               <a href="#" onClick="submitForm()" class="sub_btn"></a>
               <a href="/manage/user/User.wa" class="back_btn"></a>
            </div>
            <div class="nav_search"></div>
         </div>
      </div>
      <div class="easyui-panel" fit='true' data-options="border:false">
         <table width="648" border="0" style="text-align:center; margin-left:10px; margin-top:10px; margin-bottom:10px">
             <tr>
               <td align="left">原密码</td>
               <td align="left">
                  <input id="id" name="id" style="display:none" value="<jh:write source='&basePage.userId'/>" />
                  <input id="oldpwd" class="easyui-validatebox textbox" style="width:400px" data-options="required:true,validType:'length[6,20]'" type="password" name="pwd1" />
               </td>
            </tr>
            <tr>
               <td align="left">密码</td>
               <td align="left">
                  <input id="pwd1" class="easyui-validatebox textbox notnull" style="width:400px" data-options="required:true,validType:'length[6,20]'" type="password" name="pwd1" />
               </td>
            </tr>
            <tr>
               <td align="left">确认密码</td>
               <td align="left">
                  <input id="pwd2" class="easyui-validatebox textbox notnull" style="width:400px" data-options="required:true,validType:'length[6,20]'" type="password" name="pwd2"/> </td>
            </tr>
         </table>
      </div>
   </body>

   </HTML>