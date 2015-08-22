<%@ include file='/apl/public.inc' %>
   <!DOCTYPE >
   <html>

   <head>
      <title></title>
      <meta name="viewport" charset="UTF-8" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
      <link rel="stylesheet" type="text/css" href="css/reset.css">
      <link rel="stylesheet" type="text/css" href="css/animate.css">
      <link rel="stylesheet" type="text/css" href="css/wap.css">
      <script type="text/javascript" src="js/TouchSlide.1.1.js"></script>
   </head>

   <body>
      <FORM name='frmMain' method='post' action='Index.wa'>
         <INPUT id='id_do' name='do' type='hidden' value='chart' />
         <INPUT id='id_code' name='code' type='hidden' />
         <div class="main" style="overflow-x:hidden;">
            <section class="nav-container" id="nav-container">
               <ul>
               </ul>
            </section>
            <section class="main-container" id="main-container">
               <header>
                  <span class="btn-list" id="btn-list"></span> 全球实时数据中心
                  <div class="header-r"><img src="images/re.png"></div>
                  <ul class="header-list bounceInDown">
                     <span>当前帐号</span>
                     <p>
                        <jh:write source='&page.passport' />
                     </p>
                     <li onclick="loginOut();">退出</li>
                  </ul>
                  <div class="shadow"></div>
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
                  <jh:equals source="eai.marketer.customer" value="&page.menuString">
                     <ul>
                        <p>客户</p>
                        <li>
                           <span>投资实时数据图</span>
                           <img src="images/img.png" onclick='doChart("ChartMarketerCustomer")'>
                        </li>
                     </ul>
                  </jh:equals>
                  <jh:equals source="eai.marketer.marketer" value="&page.menuString">
                     <ul>
                        <p class="icon2">理财师</p>
                        <li>
                           <span>投资实时数据图</span>
                           <img src="images/img.png" onclick='doChart("ChartMarketerMarketer")'>
                        </li>
                     </ul>
                  </jh:equals>
                  <jh:equals source="eai.department.marketer" value="&page.menuString">
                     <ul>
                        <p class="icon3">公司</p>
                        <li>
                           <span>投资实时数据图</span>
                           <img src="images/img.png" onclick='doChart("ChartDepartmentMarketer")'>
                        </li>
                     </ul>
                  </jh:equals>
               </div>
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
         var state = true;
         $btnList.onclick = function() {
            if (state) {
               $mainContainer.setAttribute("details", "slidebar");
               $navContainer.setAttribute("details", "slidebar");
               state = false;
            } else {
               $mainContainer.setAttribute("details", " ");
               $navContainer.setAttribute("details", " ");
               state = true;
            }
         }
         var $headerR = document.getElementsByClassName("header-r")[0];
         var $shadow = document.getElementsByClassName("shadow")[0];
         var $headerList = document.getElementsByClassName("header-list")[0];
         $headerR.onclick = function() {
            $headerList.style.display = "block";
            $shadow.style.display = "block";
         }
         $shadow.onclick = function() {
            $headerList.style.display = "none";
            this.style.display = "none";
         }

         function doChart(code) {
            id_code.value = code;
            frmMain.submit();
         }

         function loginOut() {
            location.href = "Index.wa?do=loginOut";
         }
      </script>
   </body>

   </html>