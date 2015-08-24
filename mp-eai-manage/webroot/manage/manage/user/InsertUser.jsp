<%@ include file='/apl/public.inc' %>
   <HTML>

   <HEAD>
      <link rel="stylesheet" href="/manage/acs/btn_title.css" type="text/css" media="screen" />
      <jsp:include page="/manage/common/jeui.jsp"></jsp:include>
   </HEAD>
   <script>
      $(function() {
         var url = "/manage/role/Role.wa?do=selectAll&date=" + new Date().valueOf();
         $.ajax({
            type: "POST",
            url: url,
            success: function(msg) {
               closeProgress();
               $('#role').combobox('loadData', toJsonObject(msg));
               $('#role').combobox("select", $('#oldRoleId').val());
            },
            fail: function() {
               closeProgress();
               alert("error");
            }
         });
      });

      function submitForm() {
         if (!isValid()) return;
         if (!confirmpwd()) return;
         progress();
         var url = "/manage/user/User.wa?do=insert&date=" + new Date().valueOf();
         var data = {
            "passport": $('#passport').val(),
            "password": $('#pwd2').val(),
            "label": $('#label').val(),
            "role":$('#role').combobox("getValue"),
            "adminId": $('#adminId').val()
         };
         $.ajax({
            type: "POST",
            url: url,
            data: data,
            success: function(msg) {
               closeProgress();
               var result = toJsonObject(msg);
               if (result == '-1') {
                  alertx("帐号请勿输入特殊字符。", "wrning", function() {
                     $('#passport').val("");
                     $('#passport').focus();
                  });
               } else
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
            return false;
         }
         return true;
      }
   </script>

   <body bgcolor="#198bc9">
      <div id="cy_right" style="width:100%">
         <div class="right_title" style="width:100%">
            <span>添加用户</span>
         </div>
         <div class="btn_bar">
            <div class="nav_btn">
               <a href="#" onClick="submitForm()" class="add_btn"></a>
               <a href="/manage/user/User.wa" class="back_btn"></a>
            </div>
            <div class="nav_search"></div>
         </div>
      </div>
      <div class="easyui-panel" fit='true' data-options="border:false">
         <table width="718" border="0" style="text-align:center; margin-left:10px; margin-top:10px; margin-bottom:10px">
            <tr>
               <td align="left" width="48">帐号</td>
               <td align="left" width="660">
                  <input id="passport" name="passport" class="easyui-validatebox textbox notnull" style="width:400px" data-options="required:true,validType:'length[1,16]'" value="" />
                  <input id="adminId" name="adminId" style="display:none" value="<jh:write source='&basePage.userId'/>" />
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
                  <input id="pwd2" class="easyui-validatebox textbox notnull" style="width:400px" data-options="required:true,validType:'length[6,20]'" type="password" name="password" /> </td>
            </tr>
            <tr>
               <td align="left">真实名称</td>
               <td align="left">
                  <input id="label" class="easyui-validatebox textbox notnull" style="width:400px" data-options="required:true,validType:'length[1,16]'" name="label" value="" />
               </td>
            </tr>
            <tr>
               <td width="66" height="30" align="left">角色</td>
               <td height="30" colspan="7" align="left">
                  <select class="easyui-combobox" id="role" name="role" style="width:400px;" data-options="valueField:'ouid',textField:'label',editable:false" />
               </td>
            </tr>
         </table>
      </div>
   </body>

   </HTML>