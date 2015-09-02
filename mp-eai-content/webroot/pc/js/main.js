  $(window).load(function() {
     var ctrl = {};
     var $imgH;
     var $imagContainer = $(".imag-container");
     var $containersImg = $(".titles-container li");
     var $imagContainers = $(".titles-container");
     var imgL = $containersImg.length;
     var index = 0;
     var $imagDetails = $(".imag-details");
     var $userDetails = $("#user-details");
     var $users = $("#users");
     var $container = $("#container_details");
     var $containerDetails = $("#container_details ul li");
     // 列表 给第一个加
     $containersImg.eq(0).addClass('on');
     // 预加载
     $(".loding").hide();
     // 侧边栏
     $imagContainers.show();
     // 主内容 效果
     $imagDetails.show();
     var isLogin = getCookieValue("islogin");
     if(isLogin == ""){
         $(".prompt").hide();
     }
     ctrl.setTimeouts = function() {
        setTimeout(function() {
           $(".prompt").hide();
        }, 2000);
     };     
     ctrl.setTimeouts();
     deleteCookie("islogin","/");
     $imgH = $imagContainer.find("li").eq(0).height();
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
        $containerDetails.eq(index).show().siblings().hide();
        $containersImg.eq(index).addClass('on').siblings().removeClass('on');
     };
     $containersImg.mouseenter(function() {
        clearInterval(timing);
        index = $(".titles-container li").index(this);
        ctrl.setRolling(index);
     });
     $containersImg.mouseleave(function() {
        ctrl.setRolling();
     });
     $containerDetails.mouseenter(function() {
        clearInterval(timing);
     });
     $containerDetails.mouseleave(function() {
        ctrl.setTimer();
     });

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
  });