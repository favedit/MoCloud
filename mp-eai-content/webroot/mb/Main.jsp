<%@ include file='/apl/public.inc' %>
   <!DOCTYPE>
   <html>
   <head>
      <title>全球实时投资数据展示中心—钰诚集团智慧企业</title>
      <meta name="viewport" charset="UTF-8" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
      <link rel="stylesheet" type="text/css" href="css/reset.css">
      <link rel="stylesheet" type="text/css" href="css/animate.css">
      <link rel="stylesheet" type="text/css" href="css/wap.css">
      <script type="text/javascript" src="js/viewport.js"></script>
      <script type="text/javascript" src="js/TouchSlide.1.1.js"></script>
   </head>
   <body>
      <FORM name='frmMain' method='post' action='Main.wa'>
         <INPUT id='id_do' name='do' type='hidden' />
         <div class="main" style="overflow-x:hidden;">
            <section class="nav-container"  id="nav-container">
               <ul>
                  <li class="img"><Img src="images/main/7.png"></li>
                  <li class="current font20">当前账号</li>
                  <li class="names font30"><jh:write source='&page.passport' /></li>
                  <je:authority role='eai.oa'><p class="font30 mt50"><a style="color:#31b7d5;" href="Binding.wa">帐号绑定</a></p></je:authority>
                  <p class="font30" onclick="loginOut();">退出账号</p>
                  <p class="service font40">客服电话</p>
                  <p class=""><a class="phone-container font20" style="color:#31b7d5;" href="tel:010-65499299">010-65499299</a></p>
               </ul>
            </section>
             <div class="shadow"></div>
            <section class="main-container" id="main-container">
               <section class="box-container" style="display: block;">
                  <header>
                     <span class="btn-list" id="btn-list"></span>全球实时数据中心
                     <jh:notEquals source="host" value="&page.userType"><div class="header-r"><img src="images/main/81.png"></div></jh:notEquals>
                  </header>
                  <div class="banner" id="banner">
                     <div class="bd">
                        <ul>
                           <li>
                              <a class="pic" href="#"><img src="images/main/5.png"></a>
                           </li>
                           <li>
                              <a class="pic" href="#"><img src="images/main/6.png"></a>
                           </li>
                         
                        </ul>
                     </div>
                     <div class="hd">
                        <ul></ul>
                     </div>
                  </div>
                  <div class="details-container">
                     <je:authority module='eai.marketer.customer'>
                        <ul class="ul" onclick='doChart("customer")' >
                           <li>
                              <img src="../pc/images/main/3-3.png">
                              <img class="cover" src="images/main/3.png"/>
                           </li>
                           <p>用户投资实时展示中心</p>
                        </ul>
                      </je:authority>
                     <je:authority module='eai.marketer.marketer'>
                        <ul onclick='doChart("marketer")' class="ul" >
                           <li>
                              <img class="cover" src="images/main/3.png"/>
                              <img src="../pc/images/main/1-1.PNG">
                           </li>
                            <p class="icon2">理财师排行实时展示中心</p>
                        </ul>
                     </je:authority>
                     <je:authority module='eai.department.marketer'>
                        <ul onclick='doChart("department")' class="ul" >
                           <li>
                              <img class="cover" src="images/main/3.png"/>
                              <img src="../pc/images/main/2-2.png">
                           </li>
                           <p class="icon3">理财师管理实时展示中心</p>
                        </ul> 
                     </je:authority>
                     
                     
                      <je:authority module='eai.statistics.marketer'>
                        <ul class="ul" onclick='doChart("statisticsMarketer")' >
                           <li>
                              <img src="../pc/images/main/4-1.jpg">
                              <img class="cover" src="images/main/3.png"/>
                           </li>
                           <p>全国各省投资总额展示中心</p>
                        </ul>
                      </je:authority>
                     <je:authority module='eai.marketer.manage'>
                        <ul onclick='doChart("marketerManage")' class="ul" >
                           <li>
                              <img class="cover" src="images/main/3.png"/>
                              <img src="../pc/images/main/6-1.jpg">
                           </li>
                            <p class="icon2">全球理财师数据展示中心</p>
                        </ul>
                     </je:authority>
                     <je:authority module='eai.performence.marketer'>
                        <ul onclick='doChart("performenceMarketer")' class="ul" >
                           <li>
                              <img class="cover" src="images/main/3.png"/>
                              <img src="../pc/images/main/5-1.jpg">
                           </li>
                           <p class="icon3">全球实时统计数据展示中心</p>
                        </ul> 
                     </je:authority>
                  </div>
               </section>

            </section>
         </div>
      </FORM>
      <script type="text/javascript">
         TouchSlide({
            slideCell: "#banner",
            titCell: ".hd ul",
            mainCell: ".bd ul",
            effect: "leftLoop",
            autoPage: true,
            autoPlay: true
         });
      </script>
      <script type="text/javascript">
         var $btnList = document.getElementById("btn-list");
         var $mainContainer = document.getElementById("main-container");
         var $navContainer = document.getElementById("nav-container");
         var $headerR = document.getElementsByClassName("header-r")[0];
         var $shadow = document.getElementsByClassName("shadow")[0];
         var $detailsContainers = document.getElementsByClassName("ul");
         var detailsContainersLs = $detailsContainers.length-1;
         var timing = null;
         function setHeight(){
            var windowH = document.documentElement.scrollHeight;
            console.log(windowH);
            if( $mainContainer.offsetHeight < windowH){
               $navContainer.style.height = windowH;
            }else{
               $navContainer.style.height = $mainContainer.offsetHeight;
            }
         };
         window.onload = function(){
            setHeight();
         };
         var i = 0;
         function setSetTimeout(){
             timing = setInterval(function(){
             if( i == detailsContainersLs ){
               clearInterval(timing);
             }
             $detailsContainers[i].setAttribute("dynamic",true);
             setHeight();
              i++;
            },300);
         }
         window.onresize = function(){
            setHeight();
         };
         setSetTimeout();
         // $navContainer.addEventListener("touchmove", function(event){
             // event.preventDefault();
             // $navContainer.setAttribute("animation","");
             // $shadow.style.display = "none";
         // },true);
         $headerR.addEventListener("touchstart", function(){
            $navContainer.setAttribute("animation",true);
            $shadow.style.display = "block";
         },false);
         $shadow.addEventListener("touchstart", function(){

             $navContainer.setAttribute("animation","");
             this.style.display = "none";
         },false);

         function doChart(code) {
            id_do.value = code;
            frmMain.submit();
         }
         function loginOut() {
            location.href = "Index.wa?do=loginOut";
         }

      </script>
   </body>

   </html>