  $(window).load(function() {
     var ctrl = {};
     var $imgH;
     var $imagContainer = $(".imag-container");
     var $containersImg = $(".titles-container li");
     var $imagContainers = $(".titles-container");
     var $iconPictures = $(".icon-picture span");
     var imgL = $containersImg.length;
     var index = 0;
     var $imagDetails = $(".imag-details");
     var $userDetails = $("#user-details");
     var $users = $("#users");
     var $boxPrompt = $(".box-prompt").find("i");
     var $containerDetails= $("#container_details ul li");
     var alertTips = {
        emptyTel: "E租宝帐号不能为空",
        validationTel: "验证码不能为空",
        validationErrorTel: "验证码错误"
     };
     $(".loding").hide();
     $imagContainers.show();
     $imagDetails.show();

     // 绑定帐号
     if ($boxPrompt.text() != "") {
        $boxPrompt.show();
     }
     ctrl.setViewport = function() {
        var h = $imagContainer.find("li").eq(0).height();
        $imagDetails.height(h);
        var $imagDetailsW = -$imagDetails.width() / 2;
        var $imagDetailsH = -$imagDetails.height() / 2;
        $imagDetails.css({
           marginLeft: $imagDetailsW,
           marginTop: $imagDetailsH
        });
        var windowW = $(window).width();
        var windowH = $(window).height();
        $(".main").height(windowH - 86);
     };
     ctrl.setTimeouts = function() {
        setTimeout(function() {
           $(".prompt").hide();
        }, 2000);
     }
     ctrl.setTimeouts();
     ctrl.setViewport();
     var $imgW = $imagContainer.find("li").eq(0).width();
     var $imgH = $imagContainer.find("li").eq(0).height();
     var timing = null;
     $imagContainer.find("li").eq(0).show();
     ctrl.setTimer = function(argument) {
        timing = setInterval(function() {
           index++;
           if (index == imgL) {
              index = 0;
           }
           ctrl.setRolling(index);
        }, 8000);
     };
     ctrl.setTimer();
     ctrl.setRolling = function(index) {
        var W = -index * ($imgH);
        $imagDetails.find("ul").animate({
           "marginTop": W + 'px'
        });
        $iconPictures.eq(index).show().siblings().hide();
        $containersImg.eq(index).addClass('on').siblings().removeClass('on');
        $imagContainers.find("i").show();
        $containersImg.eq(index).find("i").hide();
     };

      $containersImg.mouseover(function(){
        clearInterval(timing);
        index = $(".titles-container li").index(this);
        ctrl.setRolling(index);
      });
      $containersImg.mouseleave(function(){
        ctrl.setRolling(index);
      });
      $containerDetails.mouseover(function(){
       clearInterval(timing);
      });
        $containerDetails.mouseleave(function(){
        ctrl.setTimer();
      });

     $userDetails.mousemove(function(event) {
        $users.show();
     });
     $users.mouseout(function(event) {
        $users.hide();
     });
     $users.mousemove(function(event) {
        $users.show();
     });
     $userDetails.mouseout(function(event) {
        $users.hide();
     });
     $(window).resize(function() {
        $imgH = $imagContainer.find("li").eq(0).height();
        ctrl.setRolling();
        ctrl.setViewport();
     });
     // !(/^1[3|4|5|7|8|9][\d]{9}$/).test(mobileStr)
     var wait = 60;
     ctrl.countdown = function(o) {
        if (wait == 0) {
           o.prop("disabled", false);
           o.val("发送动态密码");
           wait = 60;
        } else {
           console.log("ok");
           o.prop("disabled", true);
           o.val("重新发送(" + wait + ")");
           wait--;
           setTimeout(function() {
                 ctrl.countdown(o);
              },
              1000)
        }
     };
     var mobileVal;
     ctrl.setMatching = function(callback) {
        mobileVal = $("#mobile").val();
        if (mobileVal != '') {
           $boxPrompt.hide();
           callback();
        } else {
           $boxPrompt.show().text(alertTips.emptyTel);
        }

     };
     ctrl.setValidation = function() {
        $("#send_btn").on("click", function() {;
           var o = $(this);
           o.prop("disabled", true);  
           ctrl.setMatching(function() {
              $.post("Index.wa?do=sendValidate", {
                 "passport": mobileVal
              }, function(r) {
                 r = ctrl.replaceNbsp(r);
                 if (r == '1') {
                    ctrl.countdown(o);
                 } else {
                    o.prop("disabled", false);  
                    $boxPrompt.show().text(r);
                 }
              })
           })
        });
     };
     ctrl.submits = function() {
        $("#btn").on("click", function() {
           var frmBind = $("#frmBind");
           if ($("#mobile").val() == "") {
              $boxPrompt.show().text(alertTips.emptyTel);
              return false;
           } else if ($("#verification_code").val() == "") {
              $boxPrompt.show().text(alertTips.validationTel);
           } else {
              frmBind.submit();
           }
        })
     };
     ctrl.setValidation();
     ctrl.submits();
     ctrl.replaceNbsp = function(temp) {
        return $.trim(temp).replaceAll("&nbsp;", " ");
     }
     String.prototype.replaceAll = function(s1, s2) {
        return this.replace(new RegExp(s1, "gm"), s2);
     }

  });



function CallBackObject() 
{ 
this.XmlHttp = this.GetHttpObject(); 
} 
CallBackObject.prototype.GetHttpObject = function() //动态为CallBackObject的原型添加了GetHttpObject共有方法 
{ 
//第一步：创建XMLHttpRequest对象 
//进行兼容性判断 
var xmlhttp; 
/*@cc_on 
@if (@_jscript_version >= 5) 
try { 
xmlhttp = new ActiveXObject("Msxml2.XMLHTTP"); 
} catch (e) { 
try { 
xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); 
} catch (E) { 
xmlhttp = false; 
} 
} 
@else 
xmlhttp = false; 
@end @*/ 
if (!xmlhttp && typeof XMLHttpRequest != 'undefined') { 
try { 
xmlhttp = new XMLHttpRequest(); 
} catch (e) { 
xmlhttp = false; 
} 
} 
return xmlhttp; 
} 
CallBackObject.prototype.DoCallBack = function(URL) 
{ 
if( this.XmlHttp ) 
{ 
if( this.XmlHttp.readyState == 4 || this.XmlHttp.readyState == 0 ) 
{ 
var oThis = this; 
//第二步：注册回调方法，当服务器处理结束返回数据以后利用回调方法实现局部的页面刷新数据 
//这个回调方法实际上在每次XMLHttpRequest对象的readyState属性的值发生变化的时候都会被调用 
this.XmlHttp.onreadystatechange = function() { 
//根据XmlHttp.readyState返回值不同调用不同的方法。 
oThis.ReadyStateChange(); 
}; 
//第三步：设置和服务器交互的相应参数 
this.XmlHttp.open('POST', URL); 
this.XmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); 
//第四步：设置向服务器发送的数据，启动和服务器端交互 
this.XmlHttp.send(null); 
} 
} 
} 
CallBackObject.prototype.AbortCallBack = function() 
{ 
if( this.XmlHttp ) 
this.XmlHttp.abort(); 
} 
CallBackObject.prototype.ReadyStateChange = function() { 
//第五步：判断和服务器交互是否完成，还要判断服务器端是否正确返回数据 
//this.XmlHttp.readyState == 0初始化状态。XMLHttpRequest 对象已创建或已被 abort() 方法重置。 
if (this.XmlHttp.readyState == 1) { 
//open() 方法已调用，但是 send() 方法未调用。请求还没有被发送。 
this.OnLoading(); 
} 
else if (this.XmlHttp.readyState == 2) { 
//Send() 方法已调用，HTTP 请求已发送到 Web 服务器。未接收到响应。 
this.OnLoaded(); 
} 
else if (this.XmlHttp.readyState == 3) { 
//Receiving 所有响应头部都已经接收到。响应体开始接收但未完成。 
this.OnInteractive(); 
} 
else if (this.XmlHttp.readyState == 4) { 
//Loaded HTTP 响应已经完全接收。 
if (this.XmlHttp.status == 0) 
this.OnAbort(); 
else if (this.XmlHttp.status == 200 && this.XmlHttp.statusText == "OK") 
this.OnComplete(this.XmlHttp.responseText, this.XmlHttp.responseXML); 
else 
this.OnError(this.XmlHttp.status, this.XmlHttp.statusText, this.XmlHttp.responseText); 
} 
} 
CallBackObject.prototype.OnLoading = function() 
{ 
// Loading 
} 
CallBackObject.prototype.OnLoaded = function() 
{ 
// Loaded 
} 
CallBackObject.prototype.OnInteractive = function() 
{ 
// Interactive 
} 
CallBackObject.prototype.OnComplete = function(responseText, responseXml) 
{ 
// Complete 
} 
CallBackObject.prototype.OnAbort = function() 
{ 
// Abort 
} 
CallBackObject.prototype.OnError = function(status, statusText) 
{ 
// Error 
} 


