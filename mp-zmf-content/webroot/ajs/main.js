  $(window).load(function() {
     var ctrl = {};
     var $imgH;
     var $imagContainer = $(".imag-container");
     var $imagContainers = $(".titles-container");
     var $containersImg = $imagContainers.find("li");
     var imgL = $containersImg.length;
     var index = 0;
     var $imagDetails = $(".imag-details");
     var $userDetails = $("#user-details");
     var $headRight = $(".user-r");
     var $users = $("#users");
     var $container = $("#container_details");
     var $containerDetails = $("#container_details ul li");
     var $prev = $(".prev");
     var $next = $(".next");
     // 列表 给第一个加
     $containersImg.eq(0).addClass('on');
     // 预加载
     $(".loding").hide();
     // 侧边栏
     $imagContainers.show();
     if( imgL < 3 ){
        $prev.hide();
        $next.hide();
     }
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
     $containerDetails.length
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
     // 侧边栏 的第一个高度
     var indexH = $containersImg.eq(0).height();
     var totalHeight= $imagContainers.height();
     var totalLe = Math.round(totalHeight/indexH);
    
     ctrl.setRolling = function(index) {
        var indexW= indexH * (index-1);
        var bigW= indexH * (imgL-3);
        // 最后 
        if(index == imgL-1){
            $next.addClass('ons');
        }
        if(index < 2){
            if( index == 0 ){
                $prev.addClass('ons');
                $next.removeClass('ons');
            }else{
                $prev.removeClass('ons');
            }
            $imagContainers.find("ul").animate({marginTop: 0});
        }else if( index >= 2 && index <= imgL-2){
            $imagContainers.find("ul").animate({marginTop: -indexW});
            $prev.removeClass('ons');
            $next.removeClass('ons');
        }else{
            $imagContainers.find("ul").animate({marginTop: -bigW});
        }
        $containerDetails.eq(index).show().siblings().hide();
        $containersImg.eq(index).addClass('on').siblings().removeClass('on');
     };
    // $containersImg.mouseenter(function() {
    //    clearInterval(timing);
    //    index = $(".titles-container li").index(this);
    //    ctrl.setRolling(index);
    // });
    // $containersImg.mouseleave(function() {
    //     ctrl.setRolling();
    //  });

    // 侧边 n个li
    $containersImg.on("click",function(e){
        clearInterval(timing);
        index = $(".titles-container li").index(this);
        var containersImgIndex =$containersImg.eq(index);
        if(containersImgIndex.hasClass("on")){
            doChart(containersImgIndex.data("url"))
        }else{
            e = e || window.event;
            e.preventDefault();
            ctrl.setRolling(index);
        }
        
     })
    // prev
    $prev.on("click",function(){
        index--;
        if( index <= 0 ){
            index = 0;
        }
        ctrl.setRolling(index);
    })
    // next
    $next.on("click",function(){
        index ++;
        if( index >= imgL-1 ){
            index = imgL-1;
        }
        ctrl.setRolling(index);
    })
     // $containersImg.on("click",function(){
     //    clearInterval(timing);
     //    index = $(".titles-container li").index(this);
     //    var ls = imgL - totalLe;
     //    if( index <= ls){
     //    var h = -index * indexH;
     //        $imagContainers.animate({
     //            top: h 
     //        });
     //    }
     //    ctrl.setRolling(index);
     // })
     $containerDetails.mouseenter(function() {
        clearInterval(timing);
     });
     $containerDetails.mouseleave(function() {
        ctrl.setTimer();
     });
     // $userDetails
     $headRight.mouseenter(function(event) {
        $users.show();
     });
     $headRight.mouseleave(function(event) {
        $users.hide();
     });
     $users.mouseleave(function(event) {
        $(this).hide();
     });
     $users.mouseenter(function(event) {
        $(this).show();
     });
     // 最小的高度 侧边栏
     var $windowH,$hadeH;
     ctrl.setResize = function(){
        $windowH = $(window).height();

        if( $windowH < 700){
           $("body,html").height(700);
        }
        if( $windowH < 800 ){
           $prev.css("bottom","0px");
           $next.css("top","0px");
        }else{
            $hadeH = $("#header").height();
            var H = $windowH -$hadeH;
            if( H < 600){
                H = 600;
            }
            $imagContainers.height( H );
        }
     };
     ctrl.setResize();
    $(window).resize(function(){
        ctrl.setResize();
    }); 
  });