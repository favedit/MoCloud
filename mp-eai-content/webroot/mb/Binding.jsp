<%@ include file='/apl/public.inc' %>
   <!DOCTYPE>
   <html>

   <head>
      <title>e租宝-全球实时数据展示系统帐号棒定</title>
      <meta name="viewport" charset="UTF-8" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
      <link rel="stylesheet" type="text/css" href="css/reset.css">
      <link rel="stylesheet" type="text/css" href="css/animate.css">
      <link rel="stylesheet" type="text/css" href="css/wap.css">
   </head>

   <body>
      <FORM id="frmBind" name='frmBind' method='post' action='Index.wa?do=bindOnAccount'>
         <INPUT id='id_do' name='do' type='hidden' value='chart' />
         <INPUT id='id_code' name='code' type='hidden' />
         <div class="main" style="overflow-x:hidden;">
            <section class="main-container" id="main-container">
               <section class="binding-container" style="display:block;">
                  <header>
                     <a href="Index.wa?do=main&id=<jh:write source='&page.id' />"><img class="return-img" src="images/fanhui.png"></a>
                     账号绑定
                  </header>
                  <ul class="fieldsWidget">
                     <p class="error"><jh:write source='&page.message' /></p>
                     <li class="fieldsItem">
                        <div class="fieldsItemRibbon">
                           <label>帐号：</label>
                           <input type="tel" name="passport" class="fieldInput" placeholder="请输入E租宝帐号" value="">
                           <button id="getVerifyCodeBtn" class="btnGetCode" type="button">获取验证码</button>
                           <input tyle="hidden" style="display: none;" value="1" id="input_state">
                           <input name="id" type="hidden" value="<jh:write source='&page.id' />" />
                        </div>
                     </li>

                     <li class="fieldsItem">
                        <div class="fieldsItemRibbon">
                           <label>验证码：</label>
                           <input type="tel" name="validate" maxlength="4" data-type="code" class="fieldInput" placeholder="请输入验证码">
                        </div>
                     </li>
                     <a href="javascript:;" class="wap-btn">
                        <input id="btn" type="submit" value="提交">
                     </a>
                  </ul>
               </section>
            </section>
         </div>
      </FORM>

      <script type="text/javascript">
         var alertTips = {
            emptyTel: "E租宝帐号不能为空",
            validationTel: "验证码不能为空",
            validationErrorTel: "验证码错误"
         };
         var ctrl = {};
         var wait = 60;
         ctrl.countdown = function(o) {
            if (wait == 0) {
               o.removeAttribute("disabled");
               o.style.background = "#f5f5f5";
               o.innerHTML = "获取验证码";
               wait = 60;
            } else {
               o.setAttribute("disabled", true);
               o.style.background = "#cdcdcd";
               o.innerHTML = wait;
               wait--;
               setTimeout(function() {
                  ctrl.countdown(o);
               }, 1000)
            }
         };
         var $fieldInput = document.getElementsByClassName("fieldInput")[0];
         var $fieldInput2 = document.getElementsByClassName("fieldInput")[1];
         var error = document.getElementsByClassName("error")[0];
         if (error.innerHTML != "") {
            error.innerHTML = error.innerHTML;
         }
         // 验证码
         document.getElementById("getVerifyCodeBtn").onclick = function() {
            var o = this;
            if ($fieldInput.value != "") {
               var url = "Index.wa?do=sendValidate";
               var cbo = new CallBackObject();
               cbo.OnComplete = Cbo_Complete;
               cbo.onError = Cbo_Error;
               cbo.OnLoaded = OnLoading;
               cbo.DoCallBack("Index.wa?do=sendValidate", "passport=" + $fieldInput.value);
               function OnLoading() {
//                  alert("OnLoading ");
               }
               function Cbo_Complete(responseText, responseXML) {
                  var result = ctrl.replaceNbsp(responseText);
                  console.log(result);
                  if(result == "1"){
                     ctrl.countdown(o);
                  }else{
                     error.innerHTML = result;
                  }
               }
               function Cbo_Error(status, statusText, responseText) {
                  alert(responseText);
               }
            } else {
               error.innerHTML = alertTips.emptyTel;
            }
         };
         ctrl.replaceNbsp = function(temp) {
            return temp.replace(/[\r\n]/g,"");
         } 
         
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


         function CallBackObject() {
            this.XmlHttp = this.GetHttpObject();
         }
         CallBackObject.prototype.GetHttpObject = function()
            {
               var xmlhttp;
               if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
                  try {
                     xmlhttp = new XMLHttpRequest();
                  } catch (e) {
                     xmlhttp = false;
                  }
               }
               return xmlhttp;
            }
         CallBackObject.prototype.DoCallBack = function(URL, data) {
            if (this.XmlHttp) {
               if (this.XmlHttp.readyState == 4 || this.XmlHttp.readyState == 0) {
                  var oThis = this;
                  this.XmlHttp.onreadystatechange = function() {
                     oThis.ReadyStateChange();
                  };
                  this.XmlHttp.open('POST', URL);
                  this.XmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
                  this.XmlHttp.send(data);
               }
            }
         }
         CallBackObject.prototype.AbortCallBack = function() {
            if (this.XmlHttp)
               this.XmlHttp.abort();
         }
         CallBackObject.prototype.ReadyStateChange = function() {
            if (this.XmlHttp.readyState == 1) {
               this.OnLoading();
            } else if (this.XmlHttp.readyState == 2) {
               this.OnLoaded();
            } else if (this.XmlHttp.readyState == 3) {
               this.OnInteractive();
            } else if (this.XmlHttp.readyState == 4) {
               if (this.XmlHttp.status == 0)
                  this.OnAbort();
               else if (this.XmlHttp.status == 200 && this.XmlHttp.statusText == "OK")
                  this.OnComplete(this.XmlHttp.responseText, this.XmlHttp.responseXML);
               else
                  this.OnError(this.XmlHttp.status, this.XmlHttp.statusText, this.XmlHttp.responseText);
            }
         }
         CallBackObject.prototype.OnLoading = function() {
            // Loading 
         }
         CallBackObject.prototype.OnLoaded = function() {
            // Loaded 
         }
         CallBackObject.prototype.OnInteractive = function() {
            // Interactive 
         }
         CallBackObject.prototype.OnComplete = function(responseText, responseXml) {
            // Complete 
         }
         CallBackObject.prototype.OnAbort = function() {
            // Abort 
         }
         CallBackObject.prototype.OnError = function(status, statusText) {
            // Error 
         }
      </script>
   </body>

   </html>