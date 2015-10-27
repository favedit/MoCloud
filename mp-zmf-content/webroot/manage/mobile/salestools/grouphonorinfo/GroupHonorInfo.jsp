<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"+"manage/mobile/";
%>
<!DOCTYPE >
<html>
<head>
<base href="<%=basePath%>">
   <meta name="viewport" charset="UTF-8" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
   <link rel="stylesheet" type="text/css" href="<%=basePath%>/salestools/grouphonorinfo/css/index4.css">
</head>
<body>
  <div class="box pr">
    <ul id="titles" class="pf titles clearfix">
      <li class="z-active" data="0">高管荣誉</li>
      <li data="1">获奖情况</li>
      <li data="2">知识产权</li>
      <li data="3">企业资质</li>
    </ul>
    <div class="h50"></div>
    <div class="area">
      <h3>高管荣誉</h3>
      <img src="<%=basePath%>/salestools/grouphonorinfo/images/honor/0.jpg"/>
      <img src="<%=basePath%>/salestools/grouphonorinfo/images/honor/1.jpg"/>
      <img src="<%=basePath%>/salestools/grouphonorinfo/images/honor/2.jpg"/>
      <img src="<%=basePath%>/salestools/grouphonorinfo/images/honor/3.jpg"/>
      <img src="<%=basePath%>/salestools/grouphonorinfo/images/property/5.jpg"/>
    </div>
    <div class="area"  >
      <h3>获奖情况</h3>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/Awards/0.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/Awards/1.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/Awards/2.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/Awards/3.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/Awards/4.jpg"/>
    </div>
    <div class="area" >
      <h3>知识产权</h3>
       <img src="<%=basePath%>/salestools/grouphonorinfo/images/property/0.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/property/1.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/property/13.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/property/11.jpg"/>
        <img src="<%=basePath%>/salestools/grouphonorinfo/images/property/12.jpg"/>
    </div>
    <div class="area">
      <h3>企业资质</h3>
      <img src="<%=basePath%>/salestools/grouphonorinfo/images/aptitude/0.jpg"/>
      <img src="<%=basePath%>/salestools/grouphonorinfo/images/aptitude/1.jpg"/>
      <img src="<%=basePath%>/salestools/grouphonorinfo/images/aptitude/2.jpg"/>
      <img src="<%=basePath%>/salestools/grouphonorinfo/images/aptitude/3.jpg"/>
      <img src="<%=basePath%>/salestools/grouphonorinfo/images/aptitude/4.jpg"/>
    </div>
  </div> 
  <script type="text/javascript">
  function Jump(){
    that = this;
    this.timer2 = null;
    this.trigger = function(id){
      var node = this.$(id),
          thiss = this,
          arr = [0],
          arr2 = [0],
          nodeLis = node.getElementsByTagName("li"),
          nodeLe = nodeLis.length,
          areas = document.getElementsByClassName("area"),
          bodyDemo = document.getElementsByTagName("body")[0];

          for( var i = 0; i < nodeLe ; i++ ){
               arr.push(areas[i].offsetHeight+10);
              if( i == 1 ){
               arr2.push(arr[i] + arr[i-1] );
              }else if( i == 2){
                arr2.push( arr[i-1] + arr[i] );
              }if( i == 3){
                arr2.push( arr2[i-1] + arr[i] );
              }
             console.log(arr);
             console.log(arr2);
            nodeLis[i].onclick = function(){
              thiss.setClassName(nodeLe, nodeLis);
              this.className = "z-active";
              // thiss.animate(arr2[this.getAttribute("data")]);
              thiss.animate( arr2[this.getAttribute("data")] ,this.getAttribute("data"), areas);

            }
          }
          window.onscroll = function(){
            clearInterval(that.timer2);
            var t = document.documentElement.scrollTop || document.body.scrollTop;
            if( t < arr2[1]){
                thiss.setClassName(nodeLe, nodeLis);
                nodeLis[0].className = "z-active";
            }
            if( t > arr2[1]  && t < arr2[2]  ){
                thiss.setClassName(nodeLe, nodeLis);
                nodeLis[1].className = "z-active";
            }else if( t > arr2[2] && t < arr2[3] ){
               thiss.setClassName(nodeLe, nodeLis);
               nodeLis[2].className = "z-active";
            }else if( t > arr2[3] ){
               thiss.setClassName(nodeLe, nodeLis);
               nodeLis[3].className = "z-active";
            }
          }
    };
    this.setClassName = function(le, demos ){
       for( var j=0; j < le ; j++ ){
        demos[j].className = "";
      }

    };
     this.animate = function ( h , index ,areas){
        document.getElementsByTagName("body")[0].scrollTop  = h;
        // if (that.timer2) {
        //   clearInterval(that.timer2);
        // }
        // var val = areas[index].offsetTop;
        // var endVal = h,
        //     step = 0,
        //     newVal = 0;
        // // coansole.log(h)
        // console.log(val +"..."+ endVal);
        // that.timer2 =  setInterval(function() {
        //     if (val == endVal) {
        //       return false;
        //     }
        //     if (val > endVal) {
        //       step = Math.ceil((val - endVal) / 10);
        //       console.log(step);
        //       newVal = val - step;
        //     }
        //     if (val < endVal) {
        //       step = Math.ceil((endVal - val) / 10);
        //       newVal = val + step;

        //     }
        //     // console.log(newVal)
        //     document.getElementsByTagName("body")[0].scrollTop = newVal;
        // }, 5000);
      }
  } 
  Jump.prototype.$ = function(id) {
    return typeof id === 'string' ? document.getElementById(id) : id;
  }
  window.onload = function() {
      var jump = new Jump();
      jump.trigger("titles");
  }
  </script>
</body>
</html>