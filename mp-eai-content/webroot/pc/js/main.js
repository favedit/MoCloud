  $(window).load(function(){
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
    var alertTips={
        emptyTel:"E租宝帐号不能为空",
        validationTel:"验证码不能为空",
        validationErrorTel:"验证码错误"
      };
    // 绑定帐号
     
    
     if($boxPrompt.text()!=""){
      $boxPrompt.show();
     }

    ctrl.setViewport = function (){
      var h = $imagContainer.find("li").eq(0).height();
          $imagDetails.height(h);
      var $imagDetailsW = -$imagDetails.width()/2;
      var $imagDetailsH = -$imagDetails.height()/2;
      $imagDetails.css({marginLeft:$imagDetailsW, marginTop:$imagDetailsH});
       var windowW = $(window).width();
       var windowH = $(window).height();
       $(".main").height(windowH-86);
    };
    ctrl.setTimeouts = function () {
      setTimeout(function () {
        $(".prompt").hide();
      },2000);
    }
    ctrl.setTimeouts();
    ctrl.setViewport();
    var $imgW = $imagContainer.find("li").eq(0).width();
    var $imgH = $imagContainer.find("li").eq(0).height();
    var timing = null;
    $imagContainer.find("li").eq(0).show();
    ctrl.setTimer = function  (argument) {
       timing = setInterval(function(){
          index++;
        if( index == imgL){
          index = 0;
        }
          ctrl.setRolling(index);
        },8000);
    };
    ctrl.setTimer();
    ctrl.setRolling = function(index){
       var W=-index*($imgH);
       $imagDetails.find("ul").animate({"marginTop":W+'px'});
       $iconPictures.eq(index).show().siblings().hide();
       $containersImg.eq(index).addClass('on').siblings().removeClass('on');
       $imagContainers.find("i").show();
       $containersImg.eq(index).find("i").hide();
    };
  
   $containersImg.on("click",function(){
      clearInterval(timing);
      index = $(".titles-container li").index(this);
      ctrl.setRolling(index);
   });
   $containersImg.mouseover(function(){
     clearInterval(timing);
   });
   $containersImg.mouseleave(function(){
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
    $(window).resize(function(){
      $imgH = $imagContainer.find("li").eq(0).height();
      ctrl.setRolling();
      ctrl.setViewport();
   });
    // !(/^1[3|4|5|7|8|9][\d]{9}$/).test(mobileStr)
   var wait=60;
   ctrl.countdown = function(o){
      if (wait == 0) { 
          o.prop("disabled",false); 
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
   ctrl.setMatching = function(callback){
     var mobileVal = $("#mobile").val();
      if( mobileVal != ''){
        $boxPrompt.hide();
        callback();
      }else{
        $boxPrompt.show().text(alertTips.emptyTel);
      }

   };
   ctrl.setValidation = function(){
    $("#send_btn").on("click",function(){
      var o = $(this);
       ctrl.setMatching(function(){
        if($("input_state").val == 1 ){
          ctrl.countdown(o);
        }
       })
    });
   };
   ctrl.submits = function(){
    $("#btn").on("click", function(){
        if($("#mobile").val() == ""){
           $boxPrompt.show().text(alertTips.emptyTel);
           return false;
        }else if($("#verification_code").val() == ""){
          $boxPrompt.show().text(alertTips.validationTel);
        }else{
           frmMain.submit();
        }
    })
   };
   ctrl.setValidation();
   ctrl.submits();
  


 });
