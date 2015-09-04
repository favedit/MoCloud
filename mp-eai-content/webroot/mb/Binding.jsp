<%@ include file='/apl/public.inc' %>
   <!DOCTYPE>
   <html>

   <head>
      <title>e租宝-全球实时数据展示系统账号棒定</title>
      <meta name="viewport" charset="UTF-8" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
      <link rel="stylesheet" type="text/css" href="css/reset.css">
      <link rel="stylesheet" type="text/css" href="css/animate.css">
      <link rel="stylesheet" type="text/css" href="css/binding.css">
      <script type="text/javascript" src="js/viewport.js"></script>
      <script type="text/javascript" src="js/ajax.js"></script>
   </head>
   <body>
     <table  cellpadding="0" cellspacing="0" border="0" width="100%" height="100%" >
      <tbody>
      <tr >
         <td height="60">
             <header class="header">
               <a  href="Main.wa"><img class="return-img" src="images/binding/8.png"></a>
               全球实时数据中心
            </header>
        </td>
      </tr>
      <tr>
       <td align="center" valign="center">
         <div class="box-container">
            <h1>账号绑定</h1>
            <span class="box-prompt error"></span>
            <FORM id="frmBind" name='frmBind' method='post' action='Binding.wa?do=bindOnAccount'>
               <p class="user-name">
                  <input id="mobile" name="ePassport" class="quantico account" type="text" placeholder="E租宝理财师账号">
               </p>
               <p class="validation"><input type="text" name="validate" id="verification_code" placeholder="验证码"><input type="button" id="send_btn" value="发送动态密码">
               </p>
               <a href="javascript:;" class="btn">
                  <input id="btn"  type="submit" value=" ">
               </a>
            </FORM>
            <p class="refund"><a href="Main.wa" class="returns">返回首页</a></p>
         </div>
        </td>
      </tr>
      <tr>
       <td height="10" align="center" valign="center">
       </td>
      </tr>
      </tbody>
      </table>

      <script type="text/javascript">
         var alertTips = {
            emptyTel: "E租宝账号不能为空",
            validationTel: "验证码不能为空",
            validationErrorTel: "验证码错误"
         };
         var ctrl = {};
         var wait = 60;
         var $getVerifyCodeBtn = document.getElementById("send_btn");
         ctrl.countdown = function(o) {
            if (wait == 0) {
               o.removeAttribute("disabled");
               o.value = "获取验证码";
               wait = 60;
            } else {
               error.innerHTML = "";
               o.value = wait;
               wait--;
               o.setAttribute("disabled", true);
               setTimeout(function() {
                  ctrl.countdown(o);
               }, 1000)
            }
         };
         var $fieldInput = document.getElementsByClassName("quantico")[0];
         var $fieldInput2 = document.getElementById("verification_code");
         var error = document.getElementsByClassName("error")[0];
         if (error.innerHTML != "") {
            error.innerHTML = error.innerHTML;
         }
         ctrl.setCallBackObject = function() {
               var cbo = new CallBackObject(); 
               cbo.OnComplete = ctrl.Cbo_Complete; 
               cbo.onError = ctrl.Cbo_Error; 
               cbo.OnLoaded = ctrl.OnLoading; 
               cbo.DoCallBack("Binding.wa?do=sendValidate", "passport=" + $fieldInput.value); 
         };
         ctrl.OnLoading = function() {
         }
         ctrl.Cbo_Complete = function(responseText, responseXML) {
            var result = ctrl.replaceNbsp(responseText);
             console.log(result);
            if (result == 1) {
               ctrl.countdown($getVerifyCodeBtn);
            } else {
               error.innerHTML = result;
            }
         }
         ctrl.Cbo_Error = function(status, statusText, responseText) {
            console.log(responseText);
         }
         ctrl.replaceNbsp = function(temp) {
            if (temp != undefined && temp != "") {
               return temp.replace(/[\r\n]/g, "");
            }
            return temp;
         };

         // 验证码
         $getVerifyCodeBtn.onclick = function() {
            var o = this;
            if ($fieldInput.value != "") {
               ctrl.setCallBackObject();
            } else {
               error.innerHTML = alertTips.emptyTel;
            }
         };
         document.getElementById("btn").onclick = function() {
            if ($fieldInput.value == "") {
               error.innerHTML = alertTips.emptyTel;
               return false;
            } else if ($fieldInput2.value != "") {
               frmBind.submit();
            } else {
               error.innerHTML = alertTips.validationTel;
               return false;
            }
         };
      </script>
   </body>
   </html>