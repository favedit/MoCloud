<%@ include file='/apl/public.inc' %>
<!DOCTYPE >
<html >
<head>
   <title></title>
   <meta name="viewport" charset="UTF-8" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
   <link rel="stylesheet" type="text/css" href="css/reset.css">
   <link rel="stylesheet" type="text/css" href="css/wap.css">
   <script type="text/javascript" src="js/TouchSlide.1.1.js"></script>
</head>
<body>
   <div class="main" style="overflow-x:hidden;">
      <section class="nav-container" id="nav-container">
         <ul>
         </ul>
      </section>
      <section class="main-container" id="main-container" >
         <header>
            <span class="btn-list" id="btn-list"></span>
            全球实时数据中心
            <div class="header-r"><img src="images/ban.jpg"></div>
         </header>

         <div class="banner" id="banner">
            <div class="bd">
               <ul>
                  <li>
                     <a class="pic" href="#"><img src="images/ban.jpg"> </a>
                  </li>
                  <li>
                     <a class="pic" href="#"><img src="images/ban.jpg"></a>
                  </li>
                  <li>
                     <a class="pic" href="#"><img src="images/ban.jpg"></a>
                  </li>
                  <li>
                     <a class="pic" href="#"><img src="images/ban.jpg"></a>
                  </li>
               </ul>
            </div>

            <div class="hd">
               <ul></ul>
            </div>
         </div>
         <div class="details-container">
            <ul>
               <p>客户</p>
               <li>
                  <span>投资实时数据图</span>
                  <img src="images/img.png">
               </li>
            </ul>
            <ul>
               <p class="icon2">理财师</p>
               <li>
                  <span>投资实时数据图</span>
                  <img src="images/img.png">
               </li>
            </ul>
            <ul>
               <p class="icon3">公司</p>
               <li>
                  <span>投资实时数据图</span>
                  <img src="images/img.png">
               </li>
            </ul>

            
         </div>
      </section>
   </div>
   <script type="text/javascript">
      TouchSlide({ 
         slideCell:"#banner",
         titCell:".hd ul", 
         mainCell:".bd ul", 
         effect:"leftLoop", 
         autoPage:true,
         autoPlay:true 
      });
   </script>
   <script type="text/javascript">
      var $btnList = document.getElementById("btn-list");
      var $mainContainer = document.getElementById("main-container");
      var $navContainer = document.getElementById("nav-container");
      var state = true;
      $btnList.onclick = function (argument) {
         if( state ){
            $mainContainer.setAttribute("details","slidebar");
            $navContainer.setAttribute("details","slidebar");
            state = false;
         }else{
            $mainContainer.setAttribute("details"," ");
             $navContainer.setAttribute("details"," ");
             state = true;
         }
      }
   </script>
</body>
</html>