 $(document).ready(function(){
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
    ctrl.setViewport = function (){
      var h = $imagContainer.find("li").eq(0).height();
          $imagDetails.height(h);
      var $imagDetailsW = -$imagDetails.width()/2;
      var $imagDetailsH = -$imagDetails.height()/2;
      $imagDetails.css({marginLeft:$imagDetailsW, marginTop:$imagDetailsH});
       var windowW = $(window).width();
       var windowH = $(window).height();
       $(".main").height(windowH-70);
    };
    ctrl.setTimeouts = function  () {
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
    $users.mouseout(function(event) {
       $users.hide();
    });
    $(window).resize(function(){
      $imgH = $imagContainer.find("li").eq(0).height();
      ctrl.setRolling();
      ctrl.setViewport();
   });
 });