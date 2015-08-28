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
     var $containerDetails = $("#container_details ul li");
     var alertTips = {
        emptyTel: "E租宝账号不能为空",
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
        // var windowW = $(window).width();
        // var windowH = $(window).height();
        // $(".main").height(windowH - 86);
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

     $containersImg.mouseover(function() {
        clearInterval(timing);
        index = $(".titles-container li").index(this);
        ctrl.setRolling(index);
     });
     $containersImg.mouseleave(function() {
        ctrl.setRolling(index);
     });
     $containerDetails.mouseover(function() {
        clearInterval(timing);
     });
     $containerDetails.mouseleave(function() {
        ctrl.setTimer();
     });

     $userDetails.mouseover(function(event) {
        $users.show();
     });
     $userDetails.mouseleave(function(event) {
        $users.hide();
     });
     $users.mouseleave(function(event) {
        $(this).hide();
     });
     $users.mouseover(function(event) {
        $(this).show();
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
              $.post("Index.wa?do=sendValidate", {
                 "passport": mobileVal
              }, function(r) {
                 r = ctrl.replaceNbsp(r);
                 if (r == '1') {
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