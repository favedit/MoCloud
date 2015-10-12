<%@ include file='/apl/public.inc'%>
<jh:define source="&page.unit" alias="unit"></jh:define>
<!DOCTYPE >
<html>
<head>
   <title></title>
   <meta name="viewport" charset="UTF-8" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
   <link rel="stylesheet" type="text/css" href="/css/mobile/logic/sales/index.css">
   <script type="text/javascript" src="/js/mobile/logic/sales/js.js"></script>
</head>
<body>
   <div class="box">
      <header class="header">
         <h4>e租宝 计算器</h4>
      </header>
      <div class="main">
         <div class="product" id="product" earnings="12" min="40" period = "1" t="40" total="365">
            <h2>e租财富</h2>
            <p>12.00%   预期年化收益率</p>
            <p>40-365天 投资期限</p>
            <div class="container">
               <ul>
                  <li class="inputs">
                     <input type="text" value="" placeholder="输入金额">
                     <input type="text" total="365"  placeholder="投资天数">
                     <input class="total" type="text" disabled  placeholder="预期收益">
                  </li><li>
                     <input type="button" value="计算" >
                  </li>
               </ul>
               
          </div>
         </div>
         <div class="product" id="product1" earnings="9" min="2" period = "1" t="2" total="365">
            <h2>e租稳盈</h2>
            <p>9.00%   预期年化收益率</p>
            <p>2-365天 投资期限</p>
            <div class="container">
               <ul>
                  <li class="inputs">
                     <input type="text" value="" placeholder="输入金额">
                     <input type="text"   placeholder="投资天数">
                     <input class="total" type="text" disabled placeholder="预期收益">
                  </li>
                  <li>
                     <input type="button" value="计算" >
                  </li>
               </ul>
          </div>
         </div>

      <div class="product" id="product2" earnings="14.60" min="0" period = "1" t="0" total="365">
         <h2>e租年享</h2>
            <p>14.60%   预期年化收益率</p>
            <p>12个月 投资期限</p>
            <div class="container">
               <ul>
                  <li class="inputs">
                     <input type="text" value="" placeholder="输入金额">
                     <input type="text" total="365"  placeholder="投资天数">
                     <input class="total" type="text" disabled placeholder="预期收益">
                  </li>
                  <li>
                     <input type="button" value="计算" >
                  </li>
               </ul>
               
          </div>
         </div>

         <div class="product" id="product3" earnings="14.20" min="0" period = "1" t="0" total="365">
         <h2>e租年丰</h2>
            <p>14.20%   预期年化收益率</p>
            <p>12个月 投资期限</p>
            <div class="container">
               <ul>
                  <li class="inputs">
                     <input type="text" value="" placeholder="输入金额">
                     <input type="text" total="365"  placeholder="投资天数">
                     <input class="total" type="text" disabled placeholder="预期收益">
                  </li>
                  <li>
                     <input type="button" value="计算" >
                  </li>
               </ul>
               
          </div>
         </div>

         <div class="product" id="product4" earnings="13.8" min="0" period = "1" t="0" total="180">
         <h2>e租富盈</h2>
            <p>13.80%   预期年化收益率</p>
            <p>6个月 投资期限</p>
            <div class="container">
               <ul>
                  <li class="inputs">
                     <input type="text" value="" placeholder="输入金额">
                     <input type="text" placeholder="投资天数">
                     <input class="total" type="text" disabled placeholder="预期收益">
                  </li>
                  <li>
                     <input type="button" value="计算" >
                  </li>
               </ul>
          </div>
         </div>
         <div class="product" id="product5" earnings="13.4" min="0" period = "0.25" t="0" total="90">
            <h2>e租富享</h2>
            <p>13.40%   预期年化收益率</p>
            <p>3个月 投资期限</p>
            <div class="container">
               <ul>
                  <li class="inputs">
                     <input type="text" value="" placeholder="输入金额">
                     <input type="text" total="365"  placeholder="投资天数">
                     <input class="total" disabled type="text" placeholder="预期收益">
                  </li>
                  <li>
                     <input type="button" value="计算" >
                  </li>
               </ul>
               
          </div>
         </div>
      </div>
   </div>
</body>
</html>