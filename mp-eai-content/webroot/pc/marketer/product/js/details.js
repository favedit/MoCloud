$(function(){
  var contentRightW = $(".content-right").width(),
    $prev = $(".prev1"),
    $next = $(".next1"),
    $listsList = $(".lists-list"),
    listsLists =  $listsList.find(".lists").length,
    w = $listsList.find(".lists").eq(0).outerWidth(),
    index=0,
    paging = $(".paging").find("span"),
    timing=null;
    
    paging.eq(1).text(listsLists);
    $prev.on("click",function(){
      if(index == 0 ){
       index = listsLists;
      }
      index--;
      setRolling(index);
    });
    $next.on("click",function(){
        index++;
      if(index==listsLists){
         index=0;
      }
      setRolling(index);
    });
    // function setTimer(){
    //   timing=setInterval(function(){
    //     index++;
    //    if( index == imgL){
    //     index=0;
    //    }
    //     setRolling(index);
    //    },4000);
    // };
     function setRolling(index){
      paging.eq(0).text(index+1);
      var W=-index*(w);
      $listsList.stop().animate({"left":W+'px'});
     };
})