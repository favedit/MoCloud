<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"manage/mobile/";
%>
<!DOCTYPE >
<html>
<head>
<base href="<%=basePath%>">
   <meta name="viewport" charset="UTF-8" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
   <link rel="stylesheet" type="text/css" href="<%=basePath%>salestools/calculator/css/index.css">
   <script type="text/javascript" src="<%=basePath%>salestools/calculator/js/js.js"></script>
</head>
<body>
   <div class="box" >
      <div class="pf calculate-container">
         <ul id="calculate-container" >
            <li class="inputs border-tbl">
               <input type="text" value="" placeholder="输入金额">
               <input type="text" style="border:none;height: 43px;"  placeholder="投资天数(投资期限最多365)">
            </li>
            <li class="">
               <!-- <img src="images/btn.png"> -->
               <!-- <input type="button" value="" > -->
               <span class="btn"></span>
            </li>
         </ul>
         <ol class="hide" id="percentage">
            <input type="hidden" earnings="3.00" min="0" t="" period="" total="365" >
            <input type="hidden" earnings="12.00" min="40" t="" period="" total="365" >
            <input type="hidden" earnings="9.00" min="40" t="" period="" total="365" >
            <input type="hidden" earnings="14.60" min="40" t="" period="" total="365" >
            <input type="hidden" earnings="14.20" min="40" t="" period="" total="365" >
            <input type="hidden" earnings="13.80" min="40" t="" period="" total="180" >
            <input type="hidden" earnings="13.40" min="40" t="" period="" total="90" >
            <input type="hidden" earnings="14.60" min="40" t="" period="" total="365" >
            <input type="hidden" earnings="14.60" min="40" t="" period="" total="365" >
         </ol>
         
      </div>
      <div class="nul"></div>
      <div class="main" id="product">
         <p class="bank">银行收益：<span class="money"></span>元  <i></i></p>
         <div class="product" data="" id="products0">
            <ul>
               <li class="inputs">
                  <h2>e租财富(12.00%)</h2>
                  <p>预期收益率：<span class="money">0</span>元  <i>投资期限最多365天</i></p>
               </li>
               <li>
               </li>
            </ul>
            <div class="details">
               <p>40-365天 投资期限<p>
               <p>起投金额：1元 / 付息方式：按月 / 赎回方式：T+10，投资满30天即可申请赎回，赎回期内同等计息</p>
            </div>
         </div>
         <div class="product" data="" id="products1">
            <ul>
               <li class="inputs">
                  <h2>e租稳盈(9.00%)</h2>
                  <p>预期收益率：<span class="money">0</span>元 <i>投资期限最多365天</i></p>
               </li>
               <li>
               </li>
            </ul>
            <div class="details">
               <p>2-365天 投资期限<p>
               <p>起投金额：1元 / 付息方式：按月 / 赎回方式：T+2，投资后可随时申请赎回</p>
            </div>
         </div>

         <div class="product" data="" id="products2">
            <ul>
               <li class="inputs">
                  <h2>e租年享(14.60%)</h2>
                  <p>预期收益率：<span class="money">0</span>元 <i>投资期限最多365天</i></p>
               </li>
               <li>
               </li>
            </ul>
            <div class="details">
               <p>12个月 投资期限<p>
               <p>起投金额：1元 / 付息方式：每三个月 / 赎回方式：T+10，可提前赎回，提前赎回收部分手续费</p>
            </div>
         </div>
         <div class="product" data="" id="products3">
            <ul>
               <li class="inputs">
                  <h2>e租年丰(14.20%)</h2>
                  <p>预期收益率：<span class="money">0</span>元 <i>投资期限最多365天</i></p>
               </li>
               <li>
               </li>
            </ul>
            <div class="details">
               <p>12个月 投资期限<p>
               <p>起投金额：1元 / 付息方式：按月 / 赎回方式：T+10，可提前赎回，提前赎回收部分手续费</p>
            </div>
         </div>

         <div class="product" data="" id="products3">
            <ul>
               <li class="inputs">
                  <h2>e租富盈(13.80%)</h2>
                  <p>预期收益率：<span class="money">0</span>元 <i>投资期限最多180天</i></p>
               </li>
               <li>
               </li>
            </ul>
            <div class="details">
               <p>6个月 投资期限<p>
               <p>起投金额：1元 / 付息方式：按月 / 赎回方式：T+10 ，可提前赎回，提前赎回收部分手续费</p>
            </div>
         </div>

         <div class="product" data="" id="products3">
            <ul>
               <li class="inputs">
                  <h2>e租富享(13.40%)</h2>
                  <p>预期收益率：<span class="money">0</span>元 <i>投资期限最多90天</i></p>
               </li>
               <li>
               </li>
            </ul>
            <div class="details">
               <p>3个月 投资期限<p>
               <p>起投金额：1元 / 付息方式：按月 / 赎回方式：T+10 ， 可提前赎回，提前赎回收部分手续费</p>
            </div>
         </div>

         <div class="product" data="" id="products3">
            <ul>
               <li class="inputs">
                  <h2>缪斯珍品(14.60%)</h2>
                  <p>预期收益率：<span class="money">0</span>元 <i>投资期限最多365天</i></p>
               </li>
               <li>
               </li>
            </ul>
            <div class="details">
               <p>12个月 投资期限<p>
               <p>起投金额：1元 / 付息方式：每三个月付息 / 赎回方式：T+10 ， 可提前赎回，提前赎回收部分手续费</p>
            </div>
         </div>

         <div class="product" data="" id="products3">
            <ul>
               <li class="inputs">
                  <h2>缪斯影视(14.60%)</h2>
                  <p>预期收益率：<span class="money">0</span>元 <i>投资期限最多365天</i></p>
               </li>
               <li>
               </li>
            </ul>
            <div class="details">
               <p>12个月 投资期限<p>
               <p>起投金额：1元 / 付息方式：每三个月付息 / 赎回方式：T+10 ， 可提前赎回，提前赎回收部分手续费</p>
            </div>
         </div>

      </div>
   
   </div>
</body>
</html>