 document.ready = function (callback) {
   ///兼容FF,Google
   if (document.addEventListener) {
       document.addEventListener('DOMContentLoaded', function () {
           document.removeEventListener('DOMContentLoaded', arguments.callee, false);
           callback();
       }, false)
   }
    //兼容IE
   else if (document.attachEvent) {
       document.attachEvent('onreadytstatechange', function () {
             if (document.readyState == "complete") {
                       document.detachEvent("onreadystatechange", arguments.callee);
                       callback();
              }
       })
   }
   else if (document.lastChild == document.body) {
       callback();
   }
}
document.ready(function () {
   var objDiv=document.createElement("div"); 
   var objDivReturn=document.createElement("div");
   var objA = document.createElement("a");
   objDiv.id="mask_transparent";
   objDivReturn.id = "return_transparent";
   objDivReturn.condition= "true";
   objA.href="/pc/Main.wa";
   var $body = document.getElementsByTagName("body")[0];
   $body.appendChild(objDiv);
   var $maskTransparent = document.getElementById("mask_transparent");
    $maskTransparent.appendChild(objDivReturn);
   var $returnTransparent = document.getElementById("return_transparent");
   $returnTransparent.appendChild(objA);
   var state = false;
   var returnHeight = $returnTransparent.clientHeight;
   var index = returnHeight;
   var timer = null;
   var timer2 = null;
   function  animate( tr ){
      if( tr ){
         index=0;
         timer2 = setInterval(function(t){
            index -= Math.ceil((returnHeight)/10);
            if( index <= -returnHeight  ){
               clearInterval(timer2);
               index = returnHeight;
            }else{
               $returnTransparent.style.marginTop = index +'px';
            }
         }, 80)
      }else{
         index = returnHeight;
         timer = setInterval( function(t){
            index -= Math.ceil((returnHeight)/10);
            if( index <= 0  ){
               clearInterval(timer);
               index = 0; 
            }else{
               $returnTransparent.style.marginTop = -index +'px';
            }
         }, 80)
      }
   }
   $maskTransparent.onmouseenter = function(){
      clearInterval(timer2);
      animate(false);
   }
   $maskTransparent.onmouseleave = function(){
      clearInterval(timer);
      animate(true);
   }
   $returnTransparent.onmouseenter = function(){
   }
   $returnTransparent.onmouseleave = function(){
   }
});