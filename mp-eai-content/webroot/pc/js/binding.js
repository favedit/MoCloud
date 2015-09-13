  $(window).load(function() {
     var ctrl = {};
     var $userDetails = $("#user-details");
     var $users = $("#users");
     var $boxPrompt = $(".box-prompt").find("i");
     var alertTips = {
        emptyTel: "E租宝账号不能为空",
        validationTel: "验证码不能为空",
        validationErrorTel: "验证码错误"
     };
      // 绑定帐号
     if ($boxPrompt.text() != "") {
        $boxPrompt.show();
     }
     $userDetails.mouseenter(function(event) {
        $users.show();
     });
     $userDetails.mouseleave(function(event) {
        $users.hide();
     });
     $users.mouseleave(function(event) {
        $(this).hide();
     });
     $users.mouseenter(function(event) {
        $(this).show();
     });

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
           var sendBtn = $("#send_btn");
           sendBtn.val("发送动态密码");
           sendBtn.prop("disabled", false);
           $boxPrompt.show().text(alertTips.emptyTel);
        }
     };
     ctrl.setValidation = function() {
        $("#send_btn").on("click", function() {
           var o = $(this);
           o.prop("disabled", true);
           o.val("正在发送");
           ctrl.setMatching(function() {
              $.post("Binding.wa?do=sendValidate", {
                 "passport": mobileVal
              }, function(r) {
                 r = ctrl.replaceNbsp(r);
                 if(r.length > 20){
                    o.val("发送动态密码");
                    o.prop("disabled", false);
                    $boxPrompt.show().text("验证码发送失败");
                 }else if (r == '1') {
                    ctrl.countdown(o);
                 } else {
                    o.val("发送动态密码");
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
              return false;
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